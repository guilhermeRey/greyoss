/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.geometria;

/**
 *
 * @author guirey
 */
public class Intervalo {
    private float min;
    private float max;

    public Intervalo(float min, float max)
    {
        this.min = min;
        this.max = max;
    }

    public boolean estaDentro(float num, boolean inclusivo){
        return inclusivo ? num >= getMin() && num <= getMax() : num > getMin() && num < getMax();
    }

    /**
     * @return the min
     */
    public float getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(float min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public float getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(float max) {
        this.max = max;
    }

    

}
