package controlador;

import modelo.*;

/**
 *
 * @author Escar
 * AsignarOp calcula la op de cada jugador teniendo cuenta al jugador mas cercano
 */

public class AsignarOp {
    public static void asignar(Cancha cancha){
        for(int j=0;j<11;j++){
            int defensa=QuienDefiende.quien( cancha.getEquipoX(0).getJugadorX(j), cancha.getEquipoX(1));//obtiene que jugardor esta mas cerca del atacante
            cancha.getEquipoX(0).getJugadorX(j).setOportunidad(Partido.calculoOp(cancha, 0,1,j,defensa));
            
        }
      
        for(int j=0;j<11;j++){
            int defensa=QuienDefiende.quien( cancha.getEquipoX(1).getJugadorX(j), cancha.getEquipoX(0));
            cancha.getEquipoX(1).getJugadorX(j).setOportunidad(Partido.calculoOp(cancha, 1,0,j,defensa));
   
        }
    }
    
    public static int mayor(double[] arreglo){
        double mayor;
        int pos;
        mayor=arreglo[0];
        pos=0;
        for(int i=0 ;i<arreglo.length;i++){
            if(arreglo[i]>mayor){
                mayor=arreglo[i];
                pos=i;
            }
        }
                                 
       return pos;
    }
}
