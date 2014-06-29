/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;


import java.sql.SQLException;
import modelo.Jugador;
import modelo.ConsultaSQL;

/**
 *
 * @author Nicolas
 */
public class CreadorEquiposDesdeDB {
    
    public static Jugador[] crear(int idEquipo) throws SQLException{
        
        ConsultaSQL datosJugador = new ConsultaSQL();
        datosJugador.setResult("SELECT JUGADOR.IDEQUIPO,JUGADOR.NOMBREJUGADOR,JUGADOR.ENERGIAJUGADOR,JUGADOR.VELOCIDADJUGADOR,JUGADOR.PASEJUGADOR,JUGADOR.DISPAROJUGADOR,JUGADOR.DRIBLEOJUADOR,JUGADOR.QUITEJUGADOR,JUGADOR.BLOQUEOJUGADOR,JUGADOR.TITULARIDADJUGADOR FROM JUGADOR INNER JOIN EQUIPO ON (JUGADOR.IDEQUIPO= EQUIPO.IDEQUIPO) WHERE EQUIPO.IDEQUIPO="+String.valueOf(idEquipo+1));
       
        Jugador[] players = new Jugador[11];// arreglo con 11 jugadores vacio
                     
        int r=0;//contador qlo
        while(datosJugador.getResult().next()){//ciclo comienza con true y termina cuando no quedan filas de la tablas
            boolean titularidad = datosJugador.getResult().getBoolean(10);
            if (titularidad == true && r<11){            
            String nombreJugador = datosJugador.getResult().getString(2);//selecciono por orden los terminos extraidos de la tabla mediante la consulta
            //System.out.print("nombreJugador listo :D");System.out.print(nombreJugador);
            int energia= datosJugador.getResult().getInt(3);
            //System.out.print("energia listo :D");System.out.println(" "+String.valueOf(energia));
            int velocidad= datosJugador.getResult().getInt(4);
            //System.out.print("velocidad listo :D");System.out.println(" "+String.valueOf(velocidad));
            int pase=datosJugador.getResult().getInt(5);
            //System.out.print("pase listo :D");System.out.println(" "+String.valueOf(pase));
            int disparo=datosJugador.getResult().getInt(6);
            //System.out.print("disparo listo :D");System.out.println(" "+String.valueOf(disparo));
            int dribleo=datosJugador.getResult().getInt(7);
            //System.out.print("dribleo listo :D");System.out.println(" "+String.valueOf(dribleo));
            int quite=datosJugador.getResult().getInt(8);
            //System.out.print("quite listo :D");System.out.println(" "+String.valueOf(quite));
            int bloqueo=datosJugador.getResult().getInt(9);
            //System.out.print("bloqueo listo :D");System.out.println(" "+String.valueOf(bloqueo));

            players[r]=new Jugador(nombreJugador,velocidad,energia,pase,disparo,dribleo,quite,bloqueo,titularidad);
            //System.out.println("Jugador "+players[r].getNombre().trim() +"creado");//se agregan los jugadores con sus respectivas estadisticas al arreglod e jugadores
            //System.out.println("=====================================================");
            r++;
            }else{}
            
                       
        }
        
        /*baseDatos.setResult("SELECT EQUIPO.NOMBREEQUIPO FROM  EQUIPO WHERE EQUIPO.IDEQUIPO="+String.valueOf(idEquipo+1));
        String nombreEquipo = baseDatos.getResult().getString(1);
        System.out.println(nombreEquipo);*/
        
        
        datosJugador.cerrarConexion();
        
        return players;//nombres pls
    }
}
