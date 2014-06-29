/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Escar
 */
public class FaseGrupos {
    Grupo[] grupos=new Grupo[8];
    
    public FaseGrupos(Grupo uno,Grupo dos,Grupo tres,Grupo cuatro,Grupo cinco, Grupo seis, Grupo siete, Grupo ocho) {
        grupos[0]=uno;
        grupos[1]=dos;
        grupos[2]=tres;
        grupos[3]=cuatro;
        grupos[4]=cinco;
        grupos[5]=seis;
        grupos[6]=siete;
        grupos[7]=ocho;
    }

    public Grupo getGrupos(int i) {
        return grupos[i];
    }

    public void setGrupos(Grupo grupos, int i) {
        this.grupos[i] = grupos;
    }
    
}
