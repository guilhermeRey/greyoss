/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.exercices.robot;

import rey.geometria.Vertice;
import rey.geometria.solidos.Cilindro;
import rey.jogl.CorAlfa;

/**
 *
 * @author Urso
 */
public class RobotClaw
                extends RobotPart
{
    private Cilindro[] cilindros;
    private Vertice[]   vertices;
    public boolean closed;
    

    public RobotClaw(Cilindro[] cilindros
                        ,CorAlfa cor
                        ,Vertice pos
                        ,Vertice[] posicoes)
    {
        super(cor, pos);
        this.cilindros = cilindros;
        this.vertices  = posicoes;
    }

    @Override
    public void drawPart()
    {
        if(cilindros.length != vertices.length) return;

        if(closed) {
            super.getGl().glPushMatrix();
                trasladar(vertices[0]);
                trasladar(new Vertice(0.1f, 0.0f, 0.f));
                cilindros[0].draw();
            super.getGl().glPopMatrix();

            super.getGl().glPushMatrix();
                trasladar(vertices[1]);
                trasladar(new Vertice(-0.04f, 0.0f, 0.f));
                cilindros[1].draw();
            super.getGl().glPopMatrix();
        } else {
            for(int i = 0; i < vertices.length; i++) {
                trasladar(vertices[i]);
                cilindros[i].draw();
            }
        }
    }

    private void trasladar(Vertice v){
        this.getGl().glTranslatef(v.getX(), v.getY(), v.getZ());
    }

    /**
     * @return the cilindros
     */
    public Cilindro[] getCilindros() {
        return cilindros;
    }

    /**
     * @param cilindros the cilindros to set
     */
    public void setCilindros(Cilindro[] cilindros) {
        this.cilindros = cilindros;
    }

}
