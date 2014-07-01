package controlador;
import modelo.*;
/**
 *
 * @author Escar
 * 
 *  VerPos muestra por pantalla lo que ocurre en cancha
 *  muestra un dibujo con la posicion aproximada de los jugadores 
 *  SOLO SE USA PARA REVISION 
 */
public class VerPos {
    public static void ver(Cancha cancha){
        int[][] dimension=new int[220][155];
        int x,y;
        for(int i=0;i<11;i++){
            
            x=cancha.getEquipoX(0).getJugadorX(i).getPosX();
            y=cancha.getEquipoX(0).getJugadorX(i).getPosY();
            dimension[x][y]=1;
            x=cancha.getEquipoX(1).getJugadorX(i).getPosX();
            y=cancha.getEquipoX(1).getJugadorX(i).getPosY();
            dimension[x][y]=2;
        }
        cancha.setDimension(dimension);
        
        for(int i=0;i<220;i=i+1){
            for(int j=0;j<155;j=j+1){
                System.out.print(cancha.getDimension()[i][j]);
            }
            System.out.print("\n");
        }
        
    }
}
