package modelo;

/**
 *
 * @author Escar
 *  Modelo equipo con nombre, 11 jugadores, goles del equipo, si es local y si es atacante
 */
public class Equipo {
    int id;
    String nombre;
    Jugador[] jugadores=new Jugador[11];
    int goles;
    int formacion;
    boolean local; //arriba?
    boolean atacante; //posecion del balon
    int puntos;

    public Equipo(String nombre, Jugador[] jugadores) {
        this.nombre = nombre;
        this.jugadores =jugadores;
    }
    
    public Equipo(Jugador jugadorX, int i){
        this.jugadores[i]=jugadorX;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getFormacion() {
        return formacion;
    }

    public void setFormacion(int formacion) {
        this.formacion = formacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador getJugadorX(int i) {
        return jugadores[i];
    }

    public void setJugadores(Jugador jugadores, int i) {
        this.jugadores[i] = jugadores;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public boolean isAtacante() {
        return atacante;
    }

    public void setAtacante() {
        for(int i=0; i<11;i++){
            if (this.jugadores[i].isTieneBalon()==true){
                this.atacante = true;
            }
        }
        
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return nombre.trim();
    }
    
    
    
}
