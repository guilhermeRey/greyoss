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
public class RobotArm
                extends RobotPart
{
    private Cilindro cilindro;

    public RobotArm(Cilindro cilindro, CorAlfa cor, Vertice pos)
    {
        super(cor, pos);
        this.cilindro = cilindro;
    }

    @Override
    public void drawPart() {
        this.cilindro.draw();
    }

    /**
     * @return the cilindro
     */
    public Cilindro getCilindro() {
        return cilindro;
    }

    /**
     * @param cilindro the cilindro to set
     */
    public void setCilindro(Cilindro cilindro) {
        this.cilindro = cilindro;
    }
}
