package controlador;

import modelo.*;

/**
 *
 * @author Escar
 * 
 * AsignarForm se encarga de colocar los valores de la formacion elegida a cada jugador
 */

public class AsignarForm {
    public static void formacion(int forma, Equipo team, boolean local ){//forma representa cual estrategia se usa
        switch (forma){
            case 1:
                for(int i=0;i<11;i++){
                    int[][]pos=Estrategias.equilibrado(local);
                    team.getJugadorX(i).setPosX( pos[i][0] );
                    team.getJugadorX(i).setPosY( pos[i][1] );
                    if (i<2)
                        team.getJugadorX(i).setTipo("delantero");   
                    if (i>=2 && i<6)
                        team.getJugadorX(i).setTipo("medio");
                    if (i>=6 && i<10)
                        team.getJugadorX(i).setTipo("defensa"); 
                    if (i==10)
                        team.getJugadorX(i).setTipo("arquero"); 
                    
                }
                break;
            case 2:
                for(int i=0;i<11;i++){
                    int[][]pos=Estrategias.volanteEn(local);
                    team.getJugadorX(i).setPosX( pos[i][0] );
                    team.getJugadorX(i).setPosY( pos[i][1] );
                    if (i<2)
                        team.getJugadorX(i).setTipo("delantero");   
                    if (i>=2 && i<6)
                        team.getJugadorX(i).setTipo("medio");
                    if (i>=6 && i<10)
                        team.getJugadorX(i).setTipo("defensa"); 
                    if (i==10)
                        team.getJugadorX(i).setTipo("arquero"); 
                }
                break;
            case 3:
                for(int i=0;i<11;i++){
                    int[][]pos=Estrategias.ataque(local);
                   team.getJugadorX(i).setPosX( pos[i][0] );
                   team.getJugadorX(i).setPosY( pos[i][1] );
                   if (i<3)
                        team.getJugadorX(i).setTipo("delantero");   
                    if (i>=3 && i<6)
                        team.getJugadorX(i).setTipo("medio");
                    if (i>=6 && i<10)
                        team.getJugadorX(i).setTipo("defensa"); 
                    if (i==10)
                        team.getJugadorX(i).setTipo("arquero"); 
                }
                break;
            case 4:
                for(int i=0;i<11;i++){
                    int[][]pos=Estrategias.posesionBa(local);
                    team.getJugadorX(i).setPosX( pos[i][0] );
                    team.getJugadorX(i).setPosY( pos[i][1] );
                    if (i<1)
                        team.getJugadorX(i).setTipo("delantero");   
                    if (i>=1 && i<6)
                        team.getJugadorX(i).setTipo("medio");
                    if (i>=6 && i<10)
                        team.getJugadorX(i).setTipo("defensa"); 
                    if (i==10)
                        team.getJugadorX(i).setTipo("arquero"); 
                }
                break;
            case 5:
                for(int i=0;i<11;i++){
                    int[][]pos=Estrategias.laterales(local);
                    team.getJugadorX(i).setPosX( pos[i][0] );
                    team.getJugadorX(i).setPosY( pos[i][1] );
                    if (i<2)
                        team.getJugadorX(i).setTipo("delantero");   
                    if (i>=2 && i<7)
                        team.getJugadorX(i).setTipo("medio");
                    if (i>=7 && i<10)
                        team.getJugadorX(i).setTipo("defensa"); 
                    if (i==10)
                        team.getJugadorX(i).setTipo("arquero"); 
                }
                break;
            case 6:
                for(int i=0;i<11;i++){
                    int[][]pos=Estrategias.volantes(local);
                   team.getJugadorX(i).setPosX( pos[i][0] );
                    team.getJugadorX(i).setPosY( pos[i][1] );
                    if (i<3)
                        team.getJugadorX(i).setTipo("delantero");   
                    if (i>=3 && i<7)
                        team.getJugadorX(i).setTipo("medio");
                    if (i>=7 && i<10)
                        team.getJugadorX(i).setTipo("defensa"); 
                    if (i==10)
                        team.getJugadorX(i).setTipo("arquero"); 
                }
                break;
            case 7:
                for(int i=0;i<11;i++){
                    int[][]pos=Estrategias.defensaUno(local);
                   team.getJugadorX(i).setPosX( pos[i][0] );
                    team.getJugadorX(i).setPosY( pos[i][1] );
                    if (i<1)
                        team.getJugadorX(i).setTipo("delantero");   
                    if (i>=1 && i<5)
                        team.getJugadorX(i).setTipo("medio");
                    if (i>=5 && i<10)
                        team.getJugadorX(i).setTipo("defensa"); 
                    if (i==10)
                        team.getJugadorX(i).setTipo("arquero"); 
                }
                break;
            case 8:
                for(int i=0;i<11;i++){
                    int[][]pos=Estrategias.defensaDos(local);
                    team.getJugadorX(i).setPosX( pos[i][0] );
                    team.getJugadorX(i).setPosY( pos[i][1] );
                    if (i<2)
                        team.getJugadorX(i).setTipo("delantero");   
                    if (i>=2 && i<5)
                        team.getJugadorX(i).setTipo("medio");
                    if (i>=5 && i<10)
                        team.getJugadorX(i).setTipo("defensa"); 
                    if (i==10)
                        team.getJugadorX(i).setTipo("arquero"); 
                }
                break;
            default:
                int[][]pos=Estrategias.inicio(local);

                for(int i=0;i<11;i++){
                    team.getJugadorX(i).setPosX( pos[i][0] );
                    team.getJugadorX(i).setPosY( pos[i][1] );
                    if (i<2)
                        team.getJugadorX(i).setTipo("delantero");   
                    if (i>=2 && i<6)
                        team.getJugadorX(i).setTipo("medio");
                    if (i>=6 && i<10)
                        team.getJugadorX(i).setTipo("defensa"); 
                    if (i==10)
                        team.getJugadorX(i).setTipo("arquero"); 

                }
                break;//despues revisar
        }
    }
    
}
