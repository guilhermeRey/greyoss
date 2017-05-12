/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.geometria;

public class Vertice {
    private float x;
    private float y;
    private float z;

    public Vertice(){}
    public Vertice(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static float distDoisVertices(Vertice[] vertices)
    {
        return (float) Math.sqrt(Math.pow((vertices[1].x - vertices[0].x), 2) + Math.pow((vertices[1].y - vertices[0].y), 2));
    }

    public static float distDoisVertices(Vertice A, Vertice B)
    {
        return (float) Math.sqrt(Math.pow((B.x - A.x), 2) + Math.pow((B.y - A.y), 2));
    }

    public static Vertice verticePontoMedio(Vertice A, Vertice B)
    {
        return new Vertice(
                 (float) ((A.getX() + B.getX()) / 2)
                ,(float) ((A.getY() + B.getY()) / 2)
                ,(float) ((A.getZ() + B.getZ()) / 2)
                );
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public float getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(float z) {
        this.z = z;
    }


}
