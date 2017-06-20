/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.geometria.solidos;

import rey.geometria.Vertice;

/**
 *
 * @author Guilherme
 */
public class Tetraedro {
    private Vertice origem;
    private Vertice A;
    private Vertice B;
    private Vertice C;

    public Tetraedro(Vertice origem, Vertice A, Vertice B, Vertice C)
    {
        this.origem = origem;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    /**
     * @return the origem
     */
    public Vertice getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    /**
     * @return the A
     */
    public Vertice getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(Vertice A) {
        this.A = A;
    }

    /**
     * @return the B
     */
    public Vertice getB() {
        return B;
    }

    /**
     * @param B the B to set
     */
    public void setB(Vertice B) {
        this.B = B;
    }

    /**
     * @return the C
     */
    public Vertice getC() {
        return C;
    }

    /**
     * @param C the C to set
     */
    public void setC(Vertice C) {
        this.C = C;
    }
}
