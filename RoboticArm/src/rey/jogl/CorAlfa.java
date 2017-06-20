/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.jogl;

import javax.media.opengl.GL;

/**
 *
 * @author Urso
 */
public class CorAlfa {
    private float red;
    private float green;
    private float blue;
    private float alfa;

    public CorAlfa(float r, float g, float b, float a){
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alfa = a;
    }
    public CorAlfa(float r, float g, float b){
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alfa = 1.0f;
    }

    public static void glColor(CorAlfa cor, GL gl) {
        gl.glColor3f(cor.getRed(), cor.getGreen(), cor.getBlue());
    }

    /**
     * @return the red
     */
    public float getRed() {
        return red;
    }

    /**
     * @param red the red to set
     */
    public void setRed(float red) {
        this.red = red;
    }

    /**
     * @return the green
     */
    public float getGreen() {
        return green;
    }

    /**
     * @param green the green to set
     */
    public void setGreen(float green) {
        this.green = green;
    }

    /**
     * @return the blue
     */
    public float getBlue() {
        return blue;
    }

    /**
     * @param blue the blue to set
     */
    public void setBlue(float blue) {
        this.blue = blue;
    }

    /**
     * @return the alfa
     */
    public float getAlfa() {
        return alfa;
    }

    /**
     * @param alfa the alfa to set
     */
    public void setAlfa(float alfa) {
        this.alfa = alfa;
    }

    
}
