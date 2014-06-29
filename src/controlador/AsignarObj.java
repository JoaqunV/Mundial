
package controlador;
import modelo.*;
/**
 *
 * @author Escar
 * 
 *  AsignarObjse encarga de dar un objetivo a cada jugador en funcion de si tiene el balon y si es local
 */
public class AsignarObj { // arreglar para que los jugadores vuelvan a formacion o avancen hacia el arco si son del mismo equipo que tiene el balon
    public static void Objetivo(Cancha cancha, int equipo ,int jugador, Pelota pelota, int estrategia){
        int[][] p=new int[11][2];
        if(estrategia==1)
            p=Estrategias.equilibrado(cancha.getEquipoX(equipo).isLocal());
        if(estrategia==2)
            p=Estrategias.volanteEn(cancha.getEquipoX(equipo).isLocal());
        if(estrategia==3)
            p=Estrategias.ataque(cancha.getEquipoX(equipo).isLocal());
        if(estrategia==4)
            p=Estrategias.posesionBa(cancha.getEquipoX(equipo).isLocal());
        if(estrategia==5)
            p=Estrategias.laterales(cancha.getEquipoX(equipo).isLocal());
        if(estrategia==6)
            p=Estrategias.volantes(cancha.getEquipoX(equipo).isLocal());
        if(estrategia==7)
            p=Estrategias.defensaUno(cancha.getEquipoX(equipo).isLocal());
        if(estrategia==8)
            p=Estrategias.defensaDos(cancha.getEquipoX(equipo).isLocal());
        if(estrategia==9)
            p=Estrategias.inicio(cancha.getEquipoX(equipo).isLocal());
                    
        
        
        if(cancha.getEquipoX(equipo).getJugadorX(jugador).isTieneBalon()==true){
            if(cancha.getEquipoX(equipo).isLocal()==true){
                cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(0);
                cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(80); 
                //System.out.println("(jugador local hacia arco)");
            }else{
                cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(219);
                cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(80);
               // System.out.println("(jugador nolocal hacia arco)");
            }
        }else{
                if(cancha.getEquipoX(equipo).isLocal()==true){
                 //   System.out.println("Equipo Local");
                    if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="delantero" && pelota.getPosX()<60){  
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(pelota.getPosX());
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(pelota.getPosY());
                      //  System.out.println("(delantero va hacia pelota");
                    }else{
                        if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="delantero"){
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(p[jugador][0]);
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(p[jugador][1]);
                         //   System.out.println("(delantero va hacia posciocion  X:"+p[jugador][0]+"Y:"+p[jugador][1]);
                        }
                    }
                    if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="medio" && pelota.getPosX()>=60 && pelota.getPosX()<=160){  
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(pelota.getPosX());
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(pelota.getPosY());
                       // System.out.println("(medio va hacia pelota");
                    }else{
                        if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="medio"){
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(p[jugador][0]);
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(p[jugador][1]);
                         //   System.out.println("(medio va hacia pos");
                        }
                    }
                    if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="defensa" && pelota.getPosX()>160){  
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(pelota.getPosX());
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(pelota.getPosY());
                     //   System.out.println("(defensa va hacia pelota");
                    }else{
                        if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="defensa"){
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(p[jugador][0]);
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(p[jugador][1]);
                       //     System.out.println("(defensa va hacia pos");
                        }
                    }
                }else{
                    if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="delantero" && pelota.getPosX()>160){  
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(pelota.getPosX());
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(pelota.getPosY());
                 //       System.out.println("(delantero va hacia pelota");
                    }else{
                        if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="delantero"){
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(p[jugador][0]);
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(p[jugador][1]);
                        //    System.out.println("(delantero va hacia posciocion  X:"+p[jugador][0]+"Y:"+p[jugador][1]);
                        }
                    }
                    if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="medio" && pelota.getPosX()>=60 && pelota.getPosX()<=160){  
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(pelota.getPosX());
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(pelota.getPosY());
                     //   System.out.println("(medio va hacia pelota");
                    }else{
                        if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="medio"){
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(p[jugador][0]);
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(p[jugador][1]);
                      //      System.out.println("(medio va hacia pos");
                        }
                    }
                    if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="defensa" && pelota.getPosX()>60){  
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(pelota.getPosX());
                        cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(pelota.getPosY());
                    //    System.out.println("(defensa va hacia pelota");
                    }else{
                        if(cancha.getEquipoX(equipo).getJugadorX(jugador).getTipo()=="defensa"){
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoX(p[jugador][0]);
                            cancha.getEquipoX(equipo).getJugadorX(jugador).setObjetivoY(p[jugador][1]);
                       //     System.out.println("(defensa va hacia pos");
                        }
                    
                    }
                }
            
        }
        
    }
}
