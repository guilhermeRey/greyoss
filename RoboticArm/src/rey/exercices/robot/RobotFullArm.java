/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.exercices.robot;

import javax.media.opengl.GL;
import rey.geometria.Intervalo;
import rey.geometria.Vertice;
import rey.jogl.ReyJogl;

/**
 *
 * @author Urso
 */
public class RobotFullArm {

    private RobotArm          arm;
    private RobotBase         base;
    private RobotClaw         claw;
    private RobotForeArm      foreArm;
    private RobotJunction[]   junction;

    public float anguloArm;
    public float anguloForeArm;

    public GL gl;

    
    public RobotFullArm(RobotBase base
                       ,RobotArm arm
                       ,RobotForeArm foreArm
                       ,RobotClaw claw
                       ,RobotJunction[] junc
                       ,ReyJogl obj)
    {
        this.arm      = arm;
        this.base     = base;
        this.claw     = claw;
        this.foreArm  = foreArm;
        this.junction = junc;

        this.anguloArm = 0.0f;
        this.anguloForeArm = 0.0f;

        setGls(obj);
    }

    public final void setGls(ReyJogl obj)
    {
        this.base.setGl(obj.getGl());
        this.arm.setGl(obj.getGl());
        this.foreArm.setGl(obj.getGl());
        this.claw.setGl(obj.getGl());
        this.junction[0].setGl(obj.getGl());
        this.junction[1].setGl(obj.getGl());
        this.gl = obj.getGl();
    }

    public void renderArm()
    {
        this.base.render();

        this.base.getGl().glPushMatrix();
            // Coloca a articulação
            this.junction[0].rotate(90f, new Vertice(1.f, 0.f, 0.f));
            this.junction[0].rotate(90f, new Vertice(0.f, 1.f, 0.f));
            this.junction[0].render();
            this.junction[0].rotate(-90f, new Vertice(0.f, 1.f, 0.f));
            this.junction[0].rotate(-90f, new Vertice(1.f, 0.f, 0.f));
        this.base.getGl().glPopMatrix();

        // Coloca a rotação do braço
        this.arm.rotate(anguloArm, new Vertice(0.1f, 0.0f, 0.0f));
        this.arm.render();

        this.base.getGl().glPushMatrix();
            // Coloca a articulação
            this.junction[1].rotate(90f, new Vertice(1.f, 0.f, 0.f));
            this.junction[1].rotate(90f, new Vertice(0.f, 1.f, 0.f));
            this.junction[1].render();
            this.junction[1].rotate(-90f, new Vertice(0.f, 1.f, 0.f));
            this.junction[1].rotate(-90f, new Vertice(1.f, 0.f, 0.f));
        this.base.getGl().glPopMatrix();

        // Rotaciona o ante braço
        this.arm.rotate(anguloForeArm, new Vertice(0.1f, 0.0f, 0.0f));
        this.foreArm.render();
        
        this.claw.render();
    }

    /**
     * @return the arm
     */
    public RobotArm getArm() {
        return arm;
    }

    /**
     * @param arm the arm to set
     */
    public void setArm(RobotArm arm) {
        this.arm = arm;
    }

    /**
     * @return the base
     */
    public RobotBase getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(RobotBase base) {
        this.base = base;
    }

    /**
     * @return the claw
     */
    public RobotClaw getClaw() {
        return claw;
    }

    /**
     * @param claw the claw to set
     */
    public void setClaw(RobotClaw claw) {
        this.claw = claw;
    }

    /**
     * @return the foreArm
     */
    public RobotForeArm getForeArm() {
        return foreArm;
    }

    /**
     * @param foreArm the foreArm to set
     */
    public void setForeArm(RobotForeArm foreArm) {
        this.foreArm = foreArm;
    }

    /**
     * @return the junction
     */
    public RobotJunction[] getJunction() {
        return junction;
    }

    /**
     * @param junction the junction to set
     */
    public void setJunction(RobotJunction[] junction) {
        this.junction = junction;
    }

}
