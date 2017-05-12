/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.geometria.solidos;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import rey.geometria.Vertice;
import rey.jogl.ReyJogl;

/**
 *
 * @author Urso
 */
public abstract class Geometrico
                extends ReyJogl
{
    private Vertice posicao;

    public Geometrico(GL gl)
    {
        super(gl);
    }
    public Geometrico(GL gl, GLUT glut)
    {
        super(gl, glut);
    }
    public Geometrico()
    {
    }

    public void drawVertex(Vertice v)
    {
        this.getGl().glVertex3f(v.getX(), v.getY(), v.getZ());
    }
    
    public abstract void draw();

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
