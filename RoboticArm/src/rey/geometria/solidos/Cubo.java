/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.geometria.solidos;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/**
 *
 * @author Urso
 */
public class Cubo extends Geometrico {
    
    private float size;

    public Cubo(GL gl, GLUT glut, float size)
    {
        super(gl, glut);
        this.size = size;
    }

    @Override
    public void draw() {
        this.getGlut().glutSolidCube(this.getSize());
    }

    /**
     * @return the vertices
     */
    public float getSize() {
        return size;
    }

    /**
     * @param vertices the vertices to set
     */
    public void setSize(float size) {
        this.size = size;
    }

}
