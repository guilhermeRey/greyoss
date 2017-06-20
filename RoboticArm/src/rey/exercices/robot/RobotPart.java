/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.exercices.robot;

import rey.geometria.Vertice;
import rey.jogl.CorAlfa;
import rey.jogl.ReyJogl;

/**
 *
 * @author Urso
 */
public abstract class RobotPart extends ReyJogl{
    private CorAlfa cor;
    private Vertice posicao;
    
    public RobotPart(CorAlfa cor, Vertice pos){
        this.cor = cor;
        this.posicao = pos;
    }

    public void render() {
        
        this.getGl().glColor3f( this.cor.getRed()
                               ,this.cor.getGreen()
                               ,this.cor.getBlue() );


        this.getGl().glTranslatef( this.posicao.getX()
                                  ,this.posicao.getY()
                                  ,this.posicao.getZ() );

        drawPart();
    }

    public void rotate(float angulo, Vertice pontos){
        //translate(new Vertice(0.0f, 0.0f, 0.0f));
        this.getGl().glRotatef( angulo
                               ,pontos.getX()
                               ,pontos.getY()
                               ,pontos.getZ());
    }

    public void translate(Vertice pos)
    {
            this.getGl().glTranslatef(pos.getX()
                                      ,pos.getY()
                                      ,pos.getZ());
        
    }

    public abstract void drawPart();
    

    /**
     * @return the cor
     */
    public CorAlfa getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(CorAlfa cor) {
        this.cor = cor;
    }

    /**
     * @return the posicao
     */
    public Vertice getPosicao() {
        return posicao;
    }

    /**
     * @param posicao the posicao to set
     */
    public void setPosicao(Vertice posicao) {
        this.posicao = posicao;
    }

    
}
