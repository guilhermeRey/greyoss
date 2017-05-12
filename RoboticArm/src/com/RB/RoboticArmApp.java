package com.RB;

import java.nio.FloatBuffer;
import javax.media.opengl.GL;
import rey.exercices.robot.RobotArm;
import rey.exercices.robot.RobotBase;
import rey.exercices.robot.RobotClaw;
import rey.exercices.robot.RobotForeArm;
import rey.exercices.robot.RobotFullArm;
import rey.exercices.robot.RobotJunction;
import rey.geometria.Intervalo;
import rey.geometria.Plano;
import rey.geometria.Vertice;
import rey.geometria.solidos.Cilindro;
import rey.jogl.CorAlfa;
import rey.jogl.ReyJoglWindow;
import rey.jogl.Teclas;


/**
 * RoboticArmApp.java
 * 
 * Exercicio Programa de Computação Gráfica
 * 
 * | -------------------------------------- |
 * | Centro Universitário Senac             |
 * | Bacharelado em Ciência da Computação   |
 * | Professor: Fábio Miranda               |
 * | -------------------------------------- |
 *
 * Simula um braço robótico que movimenta-se
 *   em x e z, e rotaciona duas articulações.
 *
 * Comandos:
 *
 *   Setas Up, Down, Left e Right:  Movimenta o braço no espaço
 *        Shift + Setas Up e Down:  Rotaciona o ante-braço
 *     Shift + Setas Left e Right:  Rotaciona o braço
 *                          Enter:  Play/Pause a rotação do braço no seu próprio eixo
 *                         Espaço:  Fecha a garra
 *                 Shift + Espaço:  Liga/Desliga a luz
 * 
 * author:  Guilherme Policicio Rey
 * date:    28/09/2010
 */
public class RoboticArmApp
        extends ReyJoglWindow
{
    /* Atributos */
    private RobotFullArm robotArm;
    private Plano        plano;

    private boolean      lightOn = false;
    private boolean      rotacionarCamera = false;
    private float        anguloCamera = 0.0f;

    private int          teclaModificadora = 0;

    private float        fatorTranslate = 0.2f;
    private float        fatorRotate = 3.f;

    private Vertice      posicaoBase;

    public Intervalo     intervaloArm = new Intervalo(-30, 30);
    public Intervalo     intervaloForeArm = new Intervalo(-90, 90);

    private float[]      pos         = {0.2f, 0.2f, 0.2f, 1.0f};
    private float[]      colorBlack  = {0.0f, 0.0f, 0.0f, 1.0f};
    private float[]      colorWhite  = {1.0f, 1.0f, 1.0f, 1.0f};
    /* --- */

    public RoboticArmApp(String windowTitle, int width, int height){
        super(windowTitle, width, height);
    }

    @Override
    public void start() {
        this.robotArm = new RobotFullArm(
                // Crio a base do robo
                new RobotBase(
                    new Cilindro(this, 0.7, 0.2, 16, 16)
                   ,new CorAlfa(0.1f, 0.1f, 0.4f)
                   ,new Vertice(0.0f, 0.0f, 0.0f)
                )
                // Braco
                ,new RobotArm(
                    new Cilindro(this, 0.25, 1.3, 16, 16)
                   ,new CorAlfa(0.4f, 0.4f, 0.4f)
                   ,new Vertice(0.0f, 0.0f, -1.3f)
                )
                // Ante-braco
                ,new RobotForeArm(
                    new Cilindro(this, 0.25, 1.6, 16, 16)
                   ,new CorAlfa(0.2f, 0.2f, 0.2f)
                   ,new Vertice(0.0f, 0.0f, -1.6f)
                )
                // Garra
                ,new RobotClaw(
                     new Cilindro[] {
                        new Cilindro(this, 0.1, 0.2, 16, 16)
                       ,new Cilindro(this, 0.1, 0.2, 16, 16)
                    }
                   ,new CorAlfa(0.5f, 0.5f, 0.5f)
                   ,new Vertice(-0.3f, 0.0f, -0.2f)
                   ,new Vertice[] {
                        new Vertice(0.1f, 0.0f, 0.0f)
                       ,new Vertice(0.4f, 0.0f, 0.0f)
                    }
                )
                ,new RobotJunction[]{
                    new RobotJunction(
                        new Cilindro(this, 0.30, 0.5, 15, 15)
                       ,new CorAlfa(0.3f, 0.3f, 0.3f)
                       ,new Vertice(0.0f, 0.f, -0.25f)
                    )
                    ,new RobotJunction(
                        new Cilindro(this, 0.30, 0.5, 15, 15)
                       ,new CorAlfa(0.3f, 0.3f, 0.3f)
                       ,new Vertice(0.0f, 0.f, -0.25f)
                    )
                }
                ,this);

        this.plano = new Plano(this
                ,new Vertice[]{
                         new Vertice(3.0f, 4.f, 1.f)     // Baixo direita
                        ,new Vertice(-3.0f, 4.f, 1.f)    // Baixo esquerda
                        ,new Vertice(10.0f, -30.f, 1.f)  // Cima direita
                        ,new Vertice(-10.0f, -30.f, 1.f) // Cima esquerda
                    }
                ,new CorAlfa(0.6f, 0.7f, 0.6f));

        this.posicaoBase = new Vertice(0.f, 0.f, 0.f);
    }

    @Override
    public void render()
    {
        checkLights();

        this.getGl().glClearColor(1.f, 1.f, 1.f, 1.0f);
        this.getGl().glTranslatef(0.0f, -1.0f, -7.0f);

        desenhaPlano();

        this.getGl().glTranslatef(this.posicaoBase.getX()
                                 ,0.0f
                                 ,this.posicaoBase.getZ());

        roll();
        rotacionaCamera();
        
        this.robotArm.renderArm();
    }

    @Override
    public void keyInput() {

        switch(this.getEvent())
        {
            case KEY_PRESSED:

                if(this.getKeyInput().getModifiers() > 0)
                    teclaModificadora = Teclas.SHIFT;

                if(!(this.getKeyInput().getKeyCode() == Teclas.SHIFT))
                    trataInput();

                break;

            case KEY_RELEASED:

                if(this.getKeyInput().getKeyCode() == teclaModificadora)
                    teclaModificadora = 0;

                if(this.getKeyInput().getKeyCode() == Teclas.SPACE)
                    this.robotArm.getClaw().closed = false;

                break;
        }
    }

    @Override
    public void mouseInput() {
    
    }

    public void checkLights()
    {
        if(!lightOn) {
            this.getGl().glDisable(GL.GL_LIGHTING);
            this.getGl().glDisable(GL.GL_LIGHT0);
        }
        else
            initLights();
    }

    public void initLights()
    {
        this.getGl().glEnable(GL.GL_LIGHTING);
        this.getGl().glEnable(GL.GL_LIGHT0);

        this.getGl().glLightfv( GL.GL_LIGHT0, GL.GL_AMBIENT, FloatBuffer.wrap(colorBlack) );
        this.getGl().glLightfv( GL.GL_LIGHT0, GL.GL_DIFFUSE, FloatBuffer.wrap(colorWhite) );
        this.getGl().glLightfv( GL.GL_LIGHT0, GL.GL_SPECULAR, FloatBuffer.wrap(colorWhite) );
        this.getGl().glLightModelfv(GL.GL_AMBIENT, FloatBuffer.wrap(pos));

        this.getGl().glEnable(GL.GL_COLOR_MATERIAL);
        this.getGl().glColorMaterial(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE);
        this.getGl().glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, FloatBuffer.wrap(colorBlack));
        this.getGl().glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, FloatBuffer.wrap(colorBlack));
    }

    public void desenhaPlano()
    {
        this.getGl().glPushMatrix();
            this.getGl().glRotatef(90f, 1.0f, 0.0f, 0.0f);
            this.plano.draw();
            this.getGl().glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        this.getGl().glPopMatrix();
    }

    public void roll(){
        // Na mão
        float[] matrizA = new float[]
        {
            1, 0, 0, 0,
            0, cos((float) Math.PI / 2), seno((float) Math.PI / 2), 0,
            0, -seno((float) Math.PI / 2), cos((float) Math.PI / 2), 0,
            0, 0, 0, 1
        };

        FloatBuffer m = FloatBuffer.wrap(matrizA);
        this.getGl().glMultMatrixf(m);
    }

    public void rotacionaCamera()
    {
        if(rotacionarCamera)
            this.anguloCamera += 1.f;
        this.getGl().glRotatef(this.anguloCamera, 0.f, 0.f, 1.f);
    }

    private void trataInput()
    {

        switch(this.getKeyInput().getKeyCode() + teclaModificadora)
        {
            // Rotaciona as articulações
            case Teclas.SETA_SHIFT_DIREITA:
                if(intervaloArm.estaDentro(this.robotArm.anguloArm + fatorRotate, true))
                    this.robotArm.anguloArm += fatorRotate;

                break;
            case Teclas.SETA_SHIFT_ESQUERDA:
                if(intervaloArm.estaDentro(this.robotArm.anguloArm - fatorRotate, true))
                    this.robotArm.anguloArm -= fatorRotate;
                break;
            case Teclas.SETA_SHIFT_CIMA:
                  if(intervaloForeArm.estaDentro(this.robotArm.anguloForeArm - fatorRotate, true))
                      this.robotArm.anguloForeArm -= fatorRotate;
                break;
            case Teclas.SETA_SHIFT_BAIXO:
                if(intervaloForeArm.estaDentro(this.robotArm.anguloForeArm + fatorRotate, true))
                      this.robotArm.anguloForeArm += fatorRotate;
                break;
            case Teclas.SHIFT_SPACE:
                lightOn = lightOn ? false : true;
                break;

                
            // Movimenta o braço no espaço
            case Teclas.SETA_DIREITA:
                this.posicaoBase.setX(this.posicaoBase.getX() + fatorTranslate);
                break;

            case Teclas.SETA_ESQUERDA:
                this.posicaoBase.setX(this.posicaoBase.getX() - fatorTranslate);
                break;

            case Teclas.SETA_CIMA:
                this.posicaoBase.setZ(
                        this.posicaoBase.getZ() - fatorTranslate);
                break;
            case Teclas.SETA_BAIXO:
                this.posicaoBase.setZ(
                        this.posicaoBase.getZ() + fatorTranslate);
                break;
            case Teclas.SPACE:
                this.robotArm.getClaw().closed = true;
                break;

            // Play/Pause a rotation
            case Teclas.ENTER:
                this.rotacionarCamera = this.rotacionarCamera ? false : true;
                break;
        }
        
    }

    public float seno(float alfa)
    {
        return (float) Math.sin(alfa);
    }

    public float cos(float alfa)
    {
        return (float) Math.cos(alfa);
    }

    public static void main(String[] args) {
        ReyJoglWindow robo = new RoboticArmApp("Robotic Arm", 800, 600);
        ReyJoglWindow.exec(robo);
    }


}

