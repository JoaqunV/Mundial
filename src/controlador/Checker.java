
package controlador;
import modelo.*;
/**
 *
 * @author Escar
 * checker revisa si se produce un enfrentamiento y si es que algun jugador posee el balon
 */
public class Checker {
    public static boolean checkEnfrentamiento(Cancha cancha, int x, int y){
        int[][] dimension=cancha.getDimension();
        for (int i=(x-4);i<x+4;i++){
            for(int j=(y-4);j<(y+4);j++){
                if(dimension[i][j]==1 || dimension[i][j]==2){
                    return true;  //true igual conflicto posiciones
                }
            }
        }
        return false;
    }
    
    public static void checkPelota(Jugador jugador, Pelota pelota){
        if(pelota.isPosecion()==false){
            if(pelota.getPosX()==jugador.getPosX() && pelota.getPosY()==jugador.getPosY()){
                pelota.setPosecion(true);
                jugador.setTieneBalon(true);
            
            }
        }
    }
}
