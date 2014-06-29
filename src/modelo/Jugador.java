
package modelo;

/**
 *
 * @author Escar
 *  Modelo Jugador
 */
public class Jugador {
    String nombre;
    int velocidad;
    int energia;
    int pase;
    int disparo;
    int dribleo;
    int quite;
    int bloqueo;
    boolean titularidad;
    double oportunidad;
    boolean tieneBalon;
    int posX, posY;
    int objetivoX, objetivoY;
    String tipo; // delantero, medio, defensa, arquero
    
    public Jugador(String nombre, int velocidad, int energia, int pase, int disparo, int dribleo, int quite, int bloqueo,boolean titularidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.energia = energia;
        this.pase = pase;
        this.disparo = disparo;
        this.dribleo = dribleo;
        this.quite = quite;
        this.bloqueo = bloqueo;
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   

    public double getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(double oportunidad) {
        this.oportunidad = oportunidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getPase() {
        return pase;
    }

    public void setPase(int pase) {
        this.pase = pase;
    }

    public int getDisparo() {
        return disparo;
    }

    public void setDisparo(int disparo) {
        this.disparo = disparo;
    }

    public int getDribleo() {
        return dribleo;
    }

    public void setDribleo(int dribleo) {
        this.dribleo = dribleo;
    }

    public int getQuite() {
        return quite;
    }

    public void setQuite(int quite) {
        this.quite = quite;
    }

    public int getBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(int bloqueo) {
        this.bloqueo = bloqueo;
    }

    public boolean isTieneBalon() {
        return tieneBalon;
    }

    public void setTieneBalon(boolean tieneBalon) {
        this.tieneBalon = tieneBalon;
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

    public int getObjetivoX() {
        return objetivoX;
    }

    public void setObjetivoX(int objetivoX) {
        this.objetivoX = objetivoX;
    }

    public int getObjetivoY() {
        return objetivoY;
    }

    public void setObjetivoY(int objetivoY) {
        this.objetivoY = objetivoY;
    }

   
}
