
package modelo;

/**
 *
 * @author Escar
 *  Modelo Pelota
 */
public class Pelota {
    int posX, posY;
    boolean posecion; // algun jugador tiene el balon?

    public Pelota(int posX, int posY, boolean posecion) {
        this.posX = posX;
        this.posY = posY;
        this.posecion = posecion;
    }

    public Pelota() {
    }
    

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isPosecion() {
        return posecion;
    }

    public void setPosecion(boolean posecion) {
        this.posecion = posecion;
    }
    
    
}
