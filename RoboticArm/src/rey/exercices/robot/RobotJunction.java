/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.exercices.robot;

import rey.geometria.Vertice;
import rey.geometria.solidos.Cilindro;
import rey.geometria.solidos.Esfera;
import rey.jogl.CorAlfa;

/**
 *
 * @author guirey
 */
public class RobotJunction
        extends RobotPart
{
    private Cilindro forma;

    public RobotJunction(Cilindro esfera, CorAlfa cor, Vertice pos)
    {
        super(cor, pos);
        this.forma = esfera;
    }

    @Override
    public void drawPart() {
        this.forma.draw();
    }

    /**
     * @return the esfera
     */
    public Cilindro getEsfera() {
        return forma;
    }

    /**
     * @param esfera the esfera to set
     */
    public void setEsfera(Cilindro esfera) {
        this.forma = esfera;
    }

}
