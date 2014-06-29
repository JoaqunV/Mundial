package modelo;

/**
 *
 * @author Escar
 */
public class Grupo {
    String letra;
    Equipo [] equipos=new Equipo[4];
    Equipo[] ganadores=new Equipo[2];

    public Grupo(String letra) {
        this.letra = letra;
    }
    
    public Grupo(String letra,Equipo equipo1,Equipo equipo2,Equipo equipo3,Equipo equipo4){
        this.letra= letra;
        this.equipos[0]=equipo1;
        this.equipos[1]=equipo2;
        this.equipos[2]=equipo3;
        this.equipos[3]=equipo4;
    }

    public Equipo[] getGanadores() {
        return ganadores;
    }

    public void setGanadores(Equipo ganadores1, Equipo ganadores2) {
        this.ganadores[0] = ganadores1;
        this.ganadores[1] = ganadores2;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Equipo getEquipos(int i) {
        return equipos[i];
    }

    public void setEquipos(Equipo equipo, int i) {
        this.equipos[i] = equipo;
    }

    

    
}
