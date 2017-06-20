/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.geometria.solidos;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import rey.jogl.ReyJogl;

/**
 * Classe que representa um cilindro
 * @author Urso
 */
public class Cilindro extends Geometrico {

    private double raio;
    private double altura;
    private int partesH;
    private int partesV;

    public Cilindro(GL gl){
        super(gl);
    }
    public Cilindro(GL gl, GLUT glut){
        super(gl, glut);
    }
    public Cilindro( double raio
                    ,double altura
                    ,int partesH
                    ,int partesV)
    {
        this.altura = altura;
        this.raio = raio;
        this.partesH = partesH;
        this.partesV = partesV;
    }
    public Cilindro( ReyJogl obj
                    ,double raio
                    ,double altura
                    ,int partesH
                    ,int partesV)
    {
        super(obj.getGl(), obj.getGlut());
        this.altura = altura;
        this.raio = raio;
        this.partesH = partesH;
        this.partesV = partesV;
    }

    @Override
    public void draw() {
        this.getGlut().glutSolidCylinder(this.getRaio()
                                        ,this.getAltura()
                                        ,this.getPartesH()
                                        ,this.getPartesV());
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
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
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
