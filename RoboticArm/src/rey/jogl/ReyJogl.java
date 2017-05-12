/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.jogl;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author Urso
 */
public class ReyJogl {
    private GL gl;
    private GLUT glut;
    private GLU glu;

    public ReyJogl(GL gl)
    {
        this.gl = gl;
    }
    public ReyJogl(GL gl, GLUT glut)
    {
        this.gl = gl;
        this.glut = glut;
    }
    public ReyJogl(){

    }
    /**
     * @return the gl
     */
    public GL getGl() {
        return gl;
    }

    /**
     * @param gl the gl to set
     */
    public void setGl(GL gl) {
        this.gl = gl;
    }

    /**
     * @return the glut
     */
    public GLUT getGlut() {
        return glut;
    }

    /**
     * @param glut the glut to set
     */
    public void setGlut(GLUT glut) {
        this.glut = glut;
    }

    /**
     * @return the glu
     */
    public GLU getGlu() {
        return glu;
    }

    /**
     * @param glu the glu to set
     */
    public void setGlu(GLU glu) {
        this.glu = glu;
    }


}
