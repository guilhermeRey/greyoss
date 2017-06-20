/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.geometria.solidos;

import rey.jogl.ReyJogl;

/**
 *
 * @author guirey
 */
public class Esfera
                extends Geometrico
{
    private double      raio;
    private int         partesH;
    private int         partesV;

    public Esfera(ReyJogl obj, double raio, int H, int V)
    {
        super(obj.getGl(), obj.getGlut());
        this.raio    = raio;
        this.partesH = H;
        this.partesV = V;
    }

    @Override
    public void draw()
    {
        this.getGlut().glutSolidSphere(this.raio, this.partesH, this.partesV);
    }

    /**
     * @return the raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     * @param raio the raio to set
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }

    /**
     * @return the partesH
     */
    public int getPartesH() {
        return partesH;
    }

    /**
     * @param partesH the partesH to set
     */
    public void setPartesH(int partesH) {
        this.partesH = partesH;
    }

    /**
     * @return the partesV
     */
    public int getPartesV() {
        return partesV;
    }

    /**
     * @param partesV the partesV to set
     */
    public void setPartesV(int partesV) {
        this.partesV = partesV;
    }

}
