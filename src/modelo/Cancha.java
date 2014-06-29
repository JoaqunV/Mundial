package modelo;

/**
 *
 * @author Escar
 *  Modelo de cancha con dimiension de esta y dos equipos 
 */
public class Cancha {
    int[][] dimension=new int[220][155];
    Equipo[] equipos= new Equipo[2];  //dudando de esta wea sera necesario aqui? podria estar en partido nomas

    public Cancha(){
        
    }
    
    public Equipo getEquipoX(int i) {
        return equipos[i];
    }

    public void setEquipos(Equipo equipo, int i) {
        this.equipos[i] = equipo;
    }

    public void setPos(Equipo equipo1, Equipo equipo2){
        int x,y;
        for(int i=0;i<11;i++){
            x=equipo1.getJugadorX(i).getPosX();
            y=equipo1.getJugadorX(i).getPosY();
            this.dimension[x][y]=1;
            x=equipo2.getJugadorX(i).getPosX();
            y=equipo2.getJugadorX(i).getPosY();
            this.dimension[x][y]=2;
        }
    }

    public int[][] getDimension() {
        return dimension;
    }

    public void setDimension(int[][] dimension) {
        this.dimension= new int[220][155];
        this.dimension = dimension;
    }
     
}
