
package controlador;
import modelo.*;
/**
 *
 * @author Escar
 * 
 * SimularFaseGrupos simula el desarrollo de una fase de grupos de futbol
 * utilizando clasificacion por puntos para obtener 2 ganadores por grupo
 */
public class SimularFaseGrupos {
    public static Equipo[] simular(FaseGrupos fase){
        int[][] puntos=new int [4][2];
        Equipo[] ganadores=new Equipo[16];
        for (int i=0;i<8;i++){
            for(int j=1; j<4;j++){ // partidos equipo 0 sin repetir
                Cancha partido1= new Cancha();
                Pelota pelota1= new Pelota();
                partido1.setEquipos(fase.getGrupos(i).getEquipos(0), 0);
                partido1.setEquipos(fase.getGrupos(i).getEquipos(j), 1);
                //setear formacion en algun momento
                SimularPartido.simularPartido(partido1, pelota1, fase.getGrupos(i).getEquipos(0).getFormacion(), fase.getGrupos(i).getEquipos(j).getFormacion());
                String s="Grupo "+(i+1)+" "+fase.getGrupos(i).getEquipos(0).getNombre().trim()+" hizo "+fase.getGrupos(i).getEquipos(0).getGoles()+" goles vs "+fase.getGrupos(i).getEquipos(j).getNombre().trim()+" hizo "+fase.getGrupos(i).getEquipos(j).getGoles();
                Escribir.Escribir(s, true);
            }
            for(int j=2;j<4;j++){ // partidos equipo 1 sin repetir
                Cancha partido1= new Cancha();
                Pelota pelota1= new Pelota();
                partido1.setEquipos(fase.getGrupos(i).getEquipos(1), 0);
                partido1.setEquipos(fase.getGrupos(i).getEquipos(j), 1);
                //setear formacion en algun momento
                SimularPartido.simularPartido(partido1, pelota1, fase.getGrupos(i).getEquipos(1).getFormacion(), fase.getGrupos(i).getEquipos(j).getFormacion());
                String s="Grupo "+(i+1)+" "+fase.getGrupos(i).getEquipos(1).getNombre().trim()+" hizo "+fase.getGrupos(i).getEquipos(1).getGoles()+" goles vs "+fase.getGrupos(i).getEquipos(j).getNombre().trim()+" hizo "+fase.getGrupos(i).getEquipos(j).getGoles();
                Escribir.Escribir(s, true);
            }
            for(int j=3;j<4;j++){ // partidos equipo 2 y 3 sin repetir (for de bonito :B)
                Cancha partido1= new Cancha();
                Pelota pelota1= new Pelota();
                partido1.setEquipos(fase.getGrupos(i).getEquipos(2), 0);
                partido1.setEquipos(fase.getGrupos(i).getEquipos(j), 1);
                //setear formacion en algun momento
                SimularPartido.simularPartido(partido1, pelota1, fase.getGrupos(i).getEquipos(2).getFormacion(), fase.getGrupos(i).getEquipos(j).getFormacion());
                String s="Grupo "+(i+1)+" "+fase.getGrupos(i).getEquipos(2).getNombre().trim()+" hizo "+fase.getGrupos(i).getEquipos(2).getGoles()+" goles vs "+fase.getGrupos(i).getEquipos(j).getNombre().trim()+" hizo "+fase.getGrupos(i).getEquipos(j).getGoles();
                Escribir.Escribir(s, true);
            }
            for(int j=0;j<4;j++){
                puntos[j][0]=fase.getGrupos(i).getEquipos(j).getPuntos();
                puntos[j][1]=j;
            }
            
            
            
            for(int k=0;k<3;k++) {
                for(int f=0;f<3-k;f++) {
                    if (puntos[f][0]<puntos[f+1][0]) {
                        int aux, aux1;
                        aux=puntos[f][0];
                        aux1=puntos[f][1];
                        puntos[f][0]=puntos[f+1][0];
                        puntos[f][1]=puntos[f+1][1];
                        puntos[f+1][0]=aux;
                        puntos[f+1][1]=aux1;
                    }
                }
            }
            
            fase.getGrupos(i).setGanadores(fase.getGrupos(i).getEquipos(puntos[0][1]), fase.getGrupos(i).getEquipos(puntos[1][1]));
            //setear equipos ganadores falta
        }
        int k=0;
        for(int i=0;i<8;i++){
            ganadores[k]=fase.getGrupos(i).getGanadores()[0];
            k++;
            ganadores[k]=fase.getGrupos(i).getGanadores()[1];
            k++;
        }
        
        return ganadores;
    }
}
