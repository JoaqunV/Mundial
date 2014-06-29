
package controlador;
import modelo.*;
/**
 *
 * @author Escar
 */
public class SegundaFase {
    public static Equipo simular(Equipo[] clasificados){ //16 equipos
        Equipo[] octavosWin=new Equipo[8];
        Equipo[] cuartosWin=new Equipo[4];
        Equipo[] semisWin=new Equipo[2];
        Equipo finalWin;
        int[] win;
        int octWin=0;
        System.out.println("=========Octavos==========");
        for (int i=0;i<15;i=i+2){
                Cancha partido1= new Cancha();
                Pelota pelota1= new Pelota();
                clasificados[i].setGoles(0);
                clasificados[i+1].setGoles(0);
                partido1.setEquipos(clasificados[i], 0);
                partido1.setEquipos(clasificados[i+1], 1);
                
                //setear formacion en algun momento
                win=SimularPartido.simularPartido(partido1, pelota1, clasificados[i].getFormacion(), clasificados[i+1].getFormacion());
                if(win[0]!=2){
                    System.out.println("El equipo "+partido1.getEquipoX(win[0]).getNombre().trim()+" gana el partido con "+partido1.getEquipoX(win[0]).getGoles()+" goles vs "+partido1.getEquipoX(win[1]).getNombre().trim()+" con "+partido1.getEquipoX(win[1]).getGoles()+" goles");
                    octavosWin[octWin]=partido1.getEquipoX(win[0]);
                    octWin++;
                }else{
                    System.out.println("Empate van a penales");
                    int comp=0;//comprobante
                    while(comp==0){
                        int[] penal;
                        penal=SimularPartido.penales(partido1);
                        partido1.getEquipoX(0).setGoles(partido1.getEquipoX(0).getGoles()+penal[0]);
                        partido1.getEquipoX(1).setGoles(partido1.getEquipoX(1).getGoles()+penal[1]);
                        if (partido1.getEquipoX(0).getGoles()>partido1.getEquipoX(1).getGoles()){
                            win[0]=0;
                            win[1]=1;
                            comp=1;
                        }else if(partido1.getEquipoX(1).getGoles()>partido1.getEquipoX(0).getGoles()){
                            win[0]=1;
                            win[1]=0;
                            comp=1;
                        }else{
                            comp=0;
                        }
                    }
                    System.out.println("En penales el equipo "+partido1.getEquipoX(win[0]).getNombre().trim()+" gana el partido con "+partido1.getEquipoX(win[0]).getGoles()+" goles vs "+partido1.getEquipoX(win[1]).getNombre().trim()+" con "+partido1.getEquipoX(win[1]).getGoles()+" goles");
                    octavosWin[octWin]=partido1.getEquipoX(win[0]);
                    octWin++;
                }
        }
        int cuarWin=0;
        System.out.println("==========Cuartos==========");
        for(int i=0;i<7;i=i+2){
            Cancha partido1= new Cancha();
                Pelota pelota1= new Pelota();
                octavosWin[i].setGoles(0);
                octavosWin[i+1].setGoles(0);
                partido1.setEquipos(octavosWin[i], 0);
                partido1.setEquipos(octavosWin[i+1], 1);
                
                //setear formacion en algun momento
                win=SimularPartido.simularPartido(partido1, pelota1, clasificados[i].getFormacion(), clasificados[i+1].getFormacion());
                if(win[0]!=2){
                    System.out.println("El equipo "+partido1.getEquipoX(win[0]).getNombre().trim()+" gana el partido con "+partido1.getEquipoX(win[0]).getGoles()+" goles vs "+partido1.getEquipoX(win[1]).getNombre().trim()+" con "+partido1.getEquipoX(win[1]).getGoles()+" goles");
                    cuartosWin[cuarWin]=partido1.getEquipoX(win[0]);
                    cuarWin++;
                }else{
                    System.out.println("Empate van a penales");
                    int comp=0;//comprobante
                    while(comp==0){
                        int[] penal;
                        penal=SimularPartido.penales(partido1);
                        partido1.getEquipoX(0).setGoles(partido1.getEquipoX(0).getGoles()+penal[0]);
                        partido1.getEquipoX(1).setGoles(partido1.getEquipoX(1).getGoles()+penal[1]);
                        if (partido1.getEquipoX(0).getGoles()>partido1.getEquipoX(1).getGoles()){
                            win[0]=0;  
                            win[1]=1;
                            comp=1;
                        }else if(partido1.getEquipoX(1).getGoles()>partido1.getEquipoX(0).getGoles()){
                            win[0]=1;
                            win[1]=0;
                            comp=1;
                        }else{
                            comp=0;
                        }
                    }
                    System.out.println("En penales el equipo "+partido1.getEquipoX(win[0]).getNombre().trim()+" gana el partido con "+partido1.getEquipoX(win[0]).getGoles()+" goles vs "+partido1.getEquipoX(win[1]).getNombre().trim()+" con "+partido1.getEquipoX(win[1]).getGoles()+" goles");
                    cuartosWin[cuarWin]=partido1.getEquipoX(win[0]);
                    cuarWin++;
                }
        }
        
        int semiWin=0;
        System.out.println("========SemiFinal==========");
        for(int i=0;i<3;i=i+2){
                Cancha partido1= new Cancha();
                Pelota pelota1= new Pelota();
                cuartosWin[i].setGoles(0);
                cuartosWin[i+1].setGoles(0);
                partido1.setEquipos(cuartosWin[i], 0);
                partido1.setEquipos(cuartosWin[i+1], 1);
                
                //setear formacion en algun momento
                win=SimularPartido.simularPartido(partido1, pelota1, clasificados[i].getFormacion(), clasificados[i+1].getFormacion());
                if(win[0]!=2){
                    System.out.println("El equipo "+partido1.getEquipoX(win[0]).getNombre().trim()+" gana el partido con "+partido1.getEquipoX(win[0]).getGoles()+" goles vs "+partido1.getEquipoX(win[1]).getNombre().trim()+" con "+partido1.getEquipoX(win[1]).getGoles()+" goles");
                    semisWin[semiWin]=partido1.getEquipoX(win[0]);
                    semiWin++;
                }else{
                    System.out.println("Empate van a penales");
                    int comp=0;//comprobante
                    while(comp==0){
                        int[] penal;
                        penal=SimularPartido.penales(partido1);
                        partido1.getEquipoX(0).setGoles(partido1.getEquipoX(0).getGoles()+penal[0]);
                        partido1.getEquipoX(1).setGoles(partido1.getEquipoX(1).getGoles()+penal[1]);
                        if (partido1.getEquipoX(0).getGoles()>partido1.getEquipoX(1).getGoles()){
                            win[0]=0; 
                            win[1]=1;
                            comp=1;
                        }else if(partido1.getEquipoX(1).getGoles()>partido1.getEquipoX(0).getGoles()){
                            win[0]=1;
                            win[1]=0;
                            comp=1;
                        }else{
                            comp=0;
                        }
                    }
                    System.out.println("En penales el equipo "+partido1.getEquipoX(win[0]).getNombre().trim()+" gana el partido con "+partido1.getEquipoX(win[0]).getGoles()+" goles vs "+partido1.getEquipoX(win[1]).getNombre().trim()+" con "+partido1.getEquipoX(win[1]).getGoles()+" goles");
                    semisWin[semiWin]=partido1.getEquipoX(win[0]);
                    semiWin++;
                }
        }
        
        
                Cancha partido1= new Cancha();
                Pelota pelota1= new Pelota();
                semisWin[0].setGoles(0);
                semisWin[1].setGoles(0);
                partido1.setEquipos(semisWin[0], 0);
                partido1.setEquipos(semisWin[1], 1);
                System.out.println("=======Final=============");
                //setear formacion en algun momento
                win=SimularPartido.simularPartido(partido1, pelota1, clasificados[0].getFormacion(), clasificados[1].getFormacion());
                if(win[0]!=2){
                    System.out.println("El equipo "+partido1.getEquipoX(win[0]).getNombre().trim()+" gana el partido con "+partido1.getEquipoX(win[0]).getGoles()+" goles vs "+partido1.getEquipoX(win[1]).getNombre().trim()+" con "+partido1.getEquipoX(win[1]).getGoles()+" goles");
                    finalWin=partido1.getEquipoX(win[0]);
                    
                }else{
                    System.out.println("Empate van a penales");
                    int comp=0;//comprobante
                    while(comp==0){
                        int[] penal;
                        penal=SimularPartido.penales(partido1);
                        partido1.getEquipoX(0).setGoles(partido1.getEquipoX(0).getGoles()+penal[0]);
                        partido1.getEquipoX(1).setGoles(partido1.getEquipoX(1).getGoles()+penal[1]);
                        if (partido1.getEquipoX(0).getGoles()>partido1.getEquipoX(1).getGoles()){
                            win[0]=0; 
                            win[1]=1;
                            comp=1;
                        }else if(partido1.getEquipoX(1).getGoles()>partido1.getEquipoX(0).getGoles()){
                            win[0]=1;
                            win[1]=0;
                            comp=1;
                        }else{
                            comp=0;
                        }
                    }
                    System.out.println("En penales el equipo "+partido1.getEquipoX(win[0]).getNombre().trim()+" gana el partido con "+partido1.getEquipoX(win[0]).getGoles()+" goles vs "+partido1.getEquipoX(win[1]).getNombre().trim()+" con "+partido1.getEquipoX(win[1]).getGoles()+" goles");
                    finalWin=partido1.getEquipoX(win[0]);
                }
        
            
  
        
        return finalWin;
    }
}
