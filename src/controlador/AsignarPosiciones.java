package controlador;
import modelo.*;
/**
 *
 * @author Escar
 * 
 *  AsignarPosiciones llama a AsignarForm con los parametros necesarion para las diferentes formaciones
 *  y los coloca en la cancha
 */
public class AsignarPosiciones {
    public static void asigPos(Cancha cancha, int atacante,int defensivo, int forA,int forD, boolean locaA, boolean locaB){  //modificar paramnetros para funcionar con cualquier wea
        AsignarForm.formacion(forA, cancha.getEquipoX(atacante), locaA);
        AsignarForm.formacion(forD, cancha.getEquipoX(defensivo), locaB);

        int[][] dimension=new int[220][155];
       
        for(int i=0;i<11;i++){
          int x,y;   
            x=cancha.getEquipoX(atacante).getJugadorX(i).getPosX();
            y=cancha.getEquipoX(atacante).getJugadorX(i).getPosY();

            dimension[x][y]=1;
        }    
        for(int i=0;i<11;i++){
            int x,y;
            x=cancha.getEquipoX(defensivo).getJugadorX(i).getPosX();
            y=cancha.getEquipoX(defensivo).getJugadorX(i).getPosY();

            dimension[x][y]=2;
        }
        
        cancha.setDimension(dimension);

    }
    
    
    
}
