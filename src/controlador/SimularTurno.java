package controlador;

import modelo.*;
/**
 *
 * @author Escar
 * 
 *  SimularPartido llama a las demas funciones y evalua los movimientos de los jugadores por turno
 */
public class SimularTurno {
    public static void turno(Cancha prueba1, Pelota pelota)
    {
        //defino que equipo ataca y cual defiende
        int atacante, defensor;
        if(prueba1.getEquipoX(0).isAtacante())
        {
            atacante=0; defensor=1;
        }
        else
        {
            atacante=1; defensor=0;
        }
        //
        
        
        int jugConBalon=0;
        double[]ops=new double[11]; //arreglo con las oportunidades
        // obtengo todas las oportunidades de mis compañeros de equipo
        for(int j=0;j<11;j++)
        {
            ops[j]=prueba1.getEquipoX(atacante).getJugadorX(j).getOportunidad();
            //encuentro al jugador con el balon
            if(prueba1.getEquipoX(atacante).getJugadorX(j).isTieneBalon()==true)
            {
                jugConBalon=j; 
            }
        }
        int jugMasOP=AsignarOp.mayor(ops);
        //calculo distancia de todos los jugadores con el que tiene el balon
        double[][] dis=new double[22][3]; // filas jugadores, columnas dis;jugador;equipo
        dis=Distancia.distanciaConJBalon(prueba1.getEquipoX(atacante).getJugadorX(jugConBalon), prueba1);
        //dis=Distancia.ordenarPorCercania(dis); // ordeno las distancias para tomar desde el mas cercano MALO
        String comprobante;
        for(int i=0;i<22;i++)
        {
            //se llaman por orden las acciones
            AsignarObj.Objetivo(prueba1,(int)dis[i][2],(int)dis[i][1] , pelota, prueba1.getEquipoX((int)dis[i][2]).getFormacion());
            if(Partido.Disparo(prueba1, (int)dis[i][2], (int)dis[i][1], defensor, 10, pelota)==true)
            {
              //  System.out.println("Jugador: "+dis[i][1]+" posX="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getPosX()+" posY="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getPosY()+" OBJX="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getObjetivoX()+" OBJY="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getObjetivoY()+" Tipo:"+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getTipo()); 
               // comprobante="\n//\n//\nDisparo";
             //   System.out.println(comprobante);
            }
            else
            {
                if(Partido.Pase(prueba1, (int)dis[i][2], (int)dis[i][1], jugMasOP, defensor, QuienDefiende.quien(prueba1.getEquipoX(atacante).getJugadorX(jugConBalon), prueba1.getEquipoX(defensor)), pelota)==true)
                {
                    //System.out.println("Jugador: "+dis[i][1]+" posX="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getPosX()+" posY="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getPosY()+" OBJX="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getObjetivoX()+" OBJY="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getObjetivoY()+" Tipo:"+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getTipo()); 
                   // comprobante="pase";
                  //  System.out.println(comprobante+" a jugador en x="+pelota.getPosX()+" Y="+pelota.getPosY());
                }
                else
                {
                  // System.out.println("Jugador: "+dis[i][1]+" posX="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getPosX()+" posY="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getPosY()+" OBJX="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getObjetivoX()+" OBJY="+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getObjetivoY()+" Tipo:"+prueba1.getEquipoX((int)dis[i][2]).getJugadorX((int)dis[i][1]).getTipo()); 
                  //  comprobante="avanzar";
                  //  System.out.println(comprobante);
                   
                   Partido.avanzar(prueba1, (int)dis[i][2], (int)dis[i][1], pelota);
                }
            }
        
        }

        

    }
}
