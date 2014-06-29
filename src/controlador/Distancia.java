package controlador;
import modelo.*;
/**
 *
 * @author Escar
 * 
 *  Distancia, distanciaConJBalon calcula la distancia entre todos los jugadores y el que posee el balon
 *  Distancia, ordenarPorcercania ordena las distancias de menor a mayor
 */
public class Distancia { // arreglar ordenarPorcercania
    public static double[][] distanciaConJBalon(Jugador player,Cancha cancha){
        int x1=player.getPosX(), y1=player.getPosY();
        double[][] dis=new double[22][3];//filas numero de jugadores totales columnas dis;numero;equipo) 
        for(int i=0;i<11;i++){
            int x2=cancha.getEquipoX(0).getJugadorX(i).getPosX(), y2=cancha.getEquipoX(0).getJugadorX(i).getPosY();
            dis[i][0]=Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
            dis[i][1]=i;
            dis[i][2]=0;
        }
        for(int i=0;i<11;i++){
            int x2=cancha.getEquipoX(1).getJugadorX(i).getPosX(), y2=cancha.getEquipoX(1).getJugadorX(i).getPosY();
            dis[i+11][0]=Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
            dis[i+11][1]=i;
            dis[i+11][2]=1;
        }
 
     return dis;   
    }
    
    public static double[][] ordenarPorCercania(double[][] dis){//arreglar
        double[][] ordenado=new double[11][2];
        ordenado[0][0]=dis[0][0]; ordenado[0][1]=dis[0][1];
         for(int i=0;i<11;i++){
              int min=i;
                   for(int j=i+1;j<11;j++)     {
                       if(ordenado[j][0]<ordenado[min][0])      {
                       min=j;
                       }
                                              }
                  if(i!=min){
                       double aux[]=new double[2]; 
                       aux[0]=ordenado[i][0]; aux[1]=ordenado[i][1];
                       ordenado[i][0]=ordenado[min][0]; ordenado[i][1]=ordenado[min][1];
                       ordenado[min][0] = aux[0]; ordenado[min][1]=aux[1];
                  }
         }
        return ordenado;
    }
}
