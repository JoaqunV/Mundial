package controlador;
import java.lang.Math;
import modelo.Cancha;
import modelo.Pelota;
/**
 *
 * @author Escar
 * 
 *  Enfrentamiento, avanzar hace el calculo en base a las posiciones y objetivos de un jugador para avanzar
 *  Enfrentamiento calculoOp hace el calculo de oportunidad para los jugadores
 *  Enfrentamiento Disparo calculo del resultado final del disparo al arco retorna true si puede disparar, false si no puede
 *  Enfrentamiento Pase calculo del pase final, retorna true si se puede realizar, false si no puede
 */
public class Partido {
   
    public static void avanzar(Cancha cancha, int equipo, int jugador, Pelota pelota){
        float avance=cancha.getEquipoX(equipo).getJugadorX(jugador).getVelocidad();
        avance=avance*Factorf.factorF();
        
            int posX;
            posX=cancha.getEquipoX(equipo).getJugadorX(jugador).getPosX();
            
            int posY;
            posY=cancha.getEquipoX(equipo).getJugadorX(jugador).getPosY();

            int objX;
            objX=cancha.getEquipoX(equipo).getJugadorX(jugador).getObjetivoX();

            int objY;
            objY=cancha.getEquipoX(equipo).getJugadorX(jugador).getObjetivoY();
        
        int finX,finY;
        double angulo=Math.atan2(objY-posY, objX-posX); //calculo angulo entre puntos(radianes)
        finX=(int)(Math.cos(angulo)*avance)+posX;
        finY=(int)(Math.sin(angulo)*avance)+posY;
        if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()!="arquero"){
            if(!cancha.getEquipoX(equipo).isLocal()){ // direccion hacia la que avanzan los jugadores
                if(finX>objX){
                    cancha.getEquipoX(equipo).getJugadorX(jugador).setPosX(objX);
                }else {
                    cancha.getEquipoX(equipo).getJugadorX(jugador).setPosX(finX);
                }
                if(finY>objY){
                    cancha.getEquipoX(equipo).getJugadorX(jugador).setPosY(objY);
                }else{
                    cancha.getEquipoX(equipo).getJugadorX(jugador).setPosY(finY);
                }
            }else{
            if(finX<objX){
                    cancha.getEquipoX(equipo).getJugadorX(jugador).setPosX(objX);
            }else {
                cancha.getEquipoX(equipo).getJugadorX(jugador).setPosX(finX);
            }
            if(finY<objY){
                cancha.getEquipoX(equipo).getJugadorX(jugador).setPosY(objY);
            }else{
                cancha.getEquipoX(equipo).getJugadorX(jugador).setPosY(finY);
             }
            }
        }
        
        if(cancha.getEquipoX(equipo).getJugadorX(jugador).isTieneBalon()){
            pelota.setPosX(finX);
            pelota.setPosY(finY);
        }
        
    }
    
    public static double calculoOp(Cancha cancha, int equipoA, int equipoD, int atacante, int defensivo){
        double op;
        int dis=cancha.getEquipoX(equipoA).getJugadorX(atacante).getDisparo();
        int xAta=cancha.getEquipoX(equipoA).getJugadorX(atacante).getPosX();
        int yAta=cancha.getEquipoX(equipoA).getJugadorX(atacante).getPosY();
        int xDef=cancha.getEquipoX(equipoD).getJugadorX(defensivo).getPosX();
        int yDef=cancha.getEquipoX(equipoD).getJugadorX(defensivo).getPosY();
        int arcoX, arcoY;
        if(cancha.getEquipoX(equipoA).isLocal()){
            arcoX=0; arcoY=80;
        }else{
            arcoX=219; arcoY=80;
        }
        double distanciaArc=Math.sqrt(Math.pow(xAta-arcoX, 2)+Math.pow(yAta-arcoY, 2));
        double distanciaJug=Math.sqrt(Math.pow(xAta-xDef, 2)+Math.pow(yAta-yDef, 2));
        
        op=dis-distanciaArc+distanciaJug;
       
        return op;
    }
   
    public static boolean Disparo(Cancha cancha, int equipoA, int jugadorA,int equipoD,int jugadorD, Pelota pelota) {
        float di=cancha.getEquipoX(equipoA).getJugadorX(jugadorA).getDisparo();
        di=di*Factorf.factorF();
        
     //centro arco, hay que usar el mas cercano al jugador pero da paja
        int arcoX, arcoY;
        if (cancha.getEquipoX(equipoD).isLocal()){//arreglar esta wea para elegir lado mas cerca
            arcoX=0;// de momento tomo solo el centro del arco creo xD
            arcoY=80;
        }else{
           arcoX=210; 
           arcoY=80;
        }
        int[] posJug=new int[2];
        float disJug, disparoFinal;
        posJug[0]=cancha.getEquipoX(equipoA).getJugadorX(jugadorA).getPosX();
        posJug[1]=cancha.getEquipoX(equipoA).getJugadorX(jugadorA).getPosY();
        disJug=(float)(Math.sqrt(Math.pow(arcoX-posJug[0], 2)+Math.pow(arcoY-posJug[1], 2)));
        
        disparoFinal=di-disJug;
        
        if (disparoFinal>0 && cancha.getEquipoX(equipoA).getJugadorX(jugadorA).isTieneBalon()){
            
            float bloque=(Factorf.factorF())* (cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getBloqueo()); 
            if ((disparoFinal-bloque)<=0){
                pelota.setPosX(cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getPosX()); 
                pelota.setPosY(cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getPosY());
                pelota.setPosecion(true);//probalbemente cambie a quien tiene el balon
                cancha.getEquipoX(equipoA).getJugadorX(jugadorA).setTieneBalon(false);
                cancha.getEquipoX(equipoD).getJugadorX(jugadorD).setTieneBalon(true);
                cancha.getEquipoX(equipoD).setAtacante();
                return false;
            
            }else{
               cancha.getEquipoX(equipoA).getJugadorX(jugadorA).setTieneBalon(false);
               cancha.getEquipoX(equipoA).setGoles(cancha.getEquipoX(equipoA).getGoles()+1);
               AsignarPosiciones.asigPos(cancha, equipoA, equipoD, 9, 9, cancha.getEquipoX(equipoA).isLocal(), cancha.getEquipoX(equipoD).isLocal());
               // System.out.println("reseteo de posiciones");
               return true;
            }
        }else{
            return false; //revisar esto condicion para que se lleve acabo disparo
        }
        
    }
    //jugadorA atacante, jugadorR recibe, jugadorD defensivo
    public static boolean Pase(Cancha cancha, int equipoA, int jugadorA, int jugadorR,int equipoD,int jugadorD, Pelota pelota){
        float pase=cancha.getEquipoX(equipoA).getJugadorX(jugadorA).getPase();
        pase=pase*Factorf.factorF();
        //se multiplican datos por valores aleatorios
        float bloque=(Factorf.factorF())* (cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getBloqueo());
        // obtienen posiciones de jugadores
        int[] posJug1=new int[2];
        int[] posJug2=new int[2];
        float disJug, paseFinal;
        posJug1[0]=cancha.getEquipoX(equipoA).getJugadorX(jugadorA).getPosX();
        posJug1[1]=cancha.getEquipoX(equipoA).getJugadorX(jugadorA).getPosY();
        posJug2[0]=cancha.getEquipoX(equipoA).getJugadorX(jugadorR).getPosX();
        posJug2[1]=cancha.getEquipoX(equipoA).getJugadorX(jugadorR).getPosY();
        //calculo distancia entre jugadores
        disJug=(float)(Math.sqrt(Math.pow(posJug2[0]-posJug1[0], 2)+Math.pow(posJug2[1]-posJug1[1], 2)));
        paseFinal=pase-disJug;
        if(paseFinal>0 && cancha.getEquipoX(equipoA).getJugadorX(jugadorA).isTieneBalon() ){ //condicion para realizar pase
            
            if(paseFinal-bloque<=0){
                pelota.setPosX(cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getPosX());
                pelota.setPosY(cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getPosY());
                pelota.setPosecion(true);//probalbemente cambie a quien tiene el balon
                cancha.getEquipoX(equipoA).getJugadorX(jugadorA).setTieneBalon(false);
                cancha.getEquipoX(equipoD).getJugadorX(jugadorD).setTieneBalon(true);
                cancha.getEquipoX(equipoD).setAtacante();
                
               // System.out.println("te quitaron el balon");
            }else{
                if((paseFinal-bloque>=disJug)){
                    pelota.setPosX(cancha.getEquipoX(equipoA).getJugadorX(jugadorR).getPosX());
                    pelota.setPosY(cancha.getEquipoX(equipoA).getJugadorX(jugadorR).getPosY());
                    pelota.setPosecion(true);//probalbemente cambie a quien tiene el balon
                    cancha.getEquipoX(equipoA).getJugadorX(jugadorA).setTieneBalon(false);
                    cancha.getEquipoX(equipoA).getJugadorX(jugadorR).setTieneBalon(true);
                    cancha.getEquipoX(equipoA).setAtacante();
                   
                }else{
                    if((paseFinal-bloque)>(1/2*disJug)){
                        cancha.getEquipoX(equipoA).getJugadorX(jugadorA).setTieneBalon(false);
                        pelota.setPosX( (int)(Math.random()*(cancha.getEquipoX(equipoA).getJugadorX(jugadorR).getPosX()+5)+(cancha.getEquipoX(equipoA).getJugadorX(jugadorR).getPosX()-5))    ); 
                        pelota.setPosY(  (int)(Math.random()*(cancha.getEquipoX(equipoA).getJugadorX(jugadorR).getPosY()+5)+(cancha.getEquipoX(equipoA).getJugadorX(jugadorR).getPosY()-5))   );
                        pelota.setPosecion(false);
                      
                    }else{
                        cancha.getEquipoX(equipoA).getJugadorX(jugadorA).setTieneBalon(false);
                        pelota.setPosX((int)(Math.random()*(cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getPosX()+5)+(cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getPosX()-5)) ); //revisar para calculo de matriz con centro en jugador que defiende
                        pelota.setPosY((int)(Math.random()*(cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getPosY()+5)+(cancha.getEquipoX(equipoD).getJugadorX(jugadorD).getPosY()-5)));
                        pelota.setPosecion(false);
                       
                    }
                }
            }
            return true;  
        }else{
            return false;
        }
    }
    
    
        
}
