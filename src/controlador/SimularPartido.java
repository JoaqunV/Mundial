/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import modelo.*;
import java.lang.Math;
        
/**
 *
 * @author Escar
 * 
 * SimularPartido simula un partido de futbol con sus respectivas caracteristicas 
 */
public class SimularPartido {
    Pelota pelota=new Pelota();
    Cancha cancha=new Cancha();
    public static int[]  simularPartido(Cancha cancha, Pelota pelota, int formacionA, int formacionB){
        int[] equipoGanador= new int[2]; 
        int comienza=(int)(Math.random()*2+1); //1 o 2
        //Primer tiempo
        if (comienza==1){
            cancha.getEquipoX(0).getJugadorX(0).setTieneBalon(true);
            cancha.getEquipoX(0).setAtacante();
            cancha.getEquipoX(0).setLocal(true);
            cancha.getEquipoX(1).setLocal(false);
        }else{
            cancha.getEquipoX(1).getJugadorX(0).setTieneBalon(true);
            cancha.getEquipoX(1).setAtacante();
            cancha.getEquipoX(1).setLocal(true);
            cancha.getEquipoX(0).setLocal(false);

        }
        
        cancha.getEquipoX(0).setFormacion(formacionA);
        cancha.getEquipoX(1).setFormacion(formacionB);
        AsignarPosiciones.asigPos(cancha,0,1,formacionA,formacionB,cancha.getEquipoX(0).isLocal(), cancha.getEquipoX(1).isLocal() ); // posiciones iniciales 
       
       if (comienza==1){
            pelota= new Pelota(cancha.getEquipoX(0).getJugadorX(0).getPosX(),cancha.getEquipoX(0).getJugadorX(0).getPosY(),true);
       }else{
            pelota= new Pelota(cancha.getEquipoX(1).getJugadorX(0).getPosX(),cancha.getEquipoX(1).getJugadorX(0).getPosY(),true);    
                
        }
        for(int i=0;i<1000;i++){ //utilizamos mas turnos de los normales para que se pueda derrallorar de mejor manera los partidos
           
            AsignarOp.asignar(cancha);
            SimularTurno.turno(cancha, pelota);
            
        }
        
        
        //SegundoTiempo tiempo
        if (comienza!=1){
            cancha.getEquipoX(0).getJugadorX(0).setTieneBalon(true);
            cancha.getEquipoX(0).setAtacante();
            cancha.getEquipoX(0).setLocal(true);
            cancha.getEquipoX(1).setLocal(false);
        }else{
            cancha.getEquipoX(1).getJugadorX(0).setTieneBalon(true);
            cancha.getEquipoX(1).setAtacante();
            cancha.getEquipoX(1).setLocal(true);
            cancha.getEquipoX(0).setLocal(false);

        }
        
        cancha.getEquipoX(0).setFormacion(formacionA);
        cancha.getEquipoX(1).setFormacion(formacionB);
        AsignarPosiciones.asigPos(cancha,0,1,formacionA,formacionB,cancha.getEquipoX(0).isLocal(), cancha.getEquipoX(1).isLocal() ); // posiciones iniciales 
       if (comienza!=1){
            pelota= new Pelota(cancha.getEquipoX(0).getJugadorX(0).getPosX(),cancha.getEquipoX(0).getJugadorX(0).getPosY(),true);
       }else{
            pelota= new Pelota(cancha.getEquipoX(1).getJugadorX(0).getPosX(),cancha.getEquipoX(1).getJugadorX(0).getPosY(),true);    
                
        }
        for(int i=1000;i<2000;i++){
            
            AsignarOp.asignar(cancha);
            SimularTurno.turno(cancha, pelota);
            
        }
        
        
        if(cancha.getEquipoX(0).getGoles()>cancha.getEquipoX(1).getGoles()){
            equipoGanador[0]=0;
            equipoGanador[1]=1;
            cancha.getEquipoX(0).setPuntos(cancha.getEquipoX(0).getPuntos()+3);
        }else{
            if(cancha.getEquipoX(1).getGoles()>cancha.getEquipoX(0).getGoles()){
                 equipoGanador[0]=1;
                 equipoGanador[1]=0;
                 
                 
                 cancha.getEquipoX(1).setPuntos(cancha.getEquipoX(1).getPuntos()+3);
            }else{
                equipoGanador[0]=2;
                cancha.getEquipoX(0).setPuntos(cancha.getEquipoX(0).getPuntos()+1);
                cancha.getEquipoX(1).setPuntos(cancha.getEquipoX(1).getPuntos()+1);
            }
        }
        return equipoGanador;
    }
    
    public static int[] penales(Cancha cancha){
        int goles[]=new int[2];
        do{
        goles[0]=0;goles[1]=0;
        for(int i=0;i<5;i++){
            int disparo1=(int)(Factorf.factorF()*cancha.getEquipoX(0).getJugadorX(0).getDisparo());
            int bloqueo1=(int)(Factorf.factorF()*cancha.getEquipoX(1).getJugadorX(10).getBloqueo());
            if(disparo1>bloqueo1)
                goles[0]=goles[0]+1;

            int disparo2=(int)(Factorf.factorF()*cancha.getEquipoX(1).getJugadorX(0).getDisparo());
            int bloqueo2=(int)(Factorf.factorF()*cancha.getEquipoX(0).getJugadorX(10).getBloqueo());
            if(disparo2>bloqueo2)
                goles[1]=goles[1]+1;
            
            if(Math.abs(goles[0]-goles[1])==3){
                return goles;
            }
        }
        }while(goles[0]==goles[1]);
        return goles;
    }
}
