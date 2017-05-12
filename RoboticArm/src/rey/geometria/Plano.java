/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.geometria;

import javax.media.opengl.GL;
import rey.geometria.solidos.Geometrico;
import rey.jogl.CorAlfa;
import rey.jogl.ReyJogl;

/**
 *
 * @author guirey
 */
public class Plano
                extends Geometrico
{
    private Vertice[] vertices;
    private CorAlfa cor;

    public Plano(ReyJogl obj, Vertice[] v, CorAlfa cor){
        super(obj.getGl(), obj.getGlut());
        this.vertices   = v;
        this.cor        = cor;
    }

    @Override
    public void draw() {
        this.getGl().glColor3f(cor.getRed(), cor.getGreen(), cor.getBlue());
        this.getGl().glBegin(GL.GL_QUAD_STRIP);
            for(Vertice v : this.getVertices())
                this.drawVertex(v);
        this.getGl().glEnd();
    }

    /**
     * @return the vertices
     */
    public Vertice[] getVertices() {
        return vertices;
    }

    /**
     * @param vertices the vertices to set
     */
    public void setVertices(Vertice[] vertices) {
        this.vertices = vertices;
    }

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

}
