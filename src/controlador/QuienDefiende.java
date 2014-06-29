package controlador;

import modelo.*;
import java.lang.Math;

/**
 *
 * @author Escar
 * 
 *  QuienDefiende busca al jugador que defiende contra el jugador con balon
 */
public class QuienDefiende {
    public static int quien(Jugador player, Equipo equipoD){
        int x1=player.getPosX(), y1=player.getPosY();
        double[] dis=new double[11];
        for(int i=0;i<11;i++){
            int x2=equipoD.getJugadorX(i).getPosX(), y2=equipoD.getJugadorX(i).getPosY();
            dis[i]=Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
        }
        double cercano=dis[0];
        for(int i=0;i<11;i++)
            if(cercano>dis[i]){
                cercano=dis[i];
            }
        int j=0;
        for(int i=0;i<11;i++){
            if (cercano==dis[i])
                j=i;
        }
        return j;
    }
}
