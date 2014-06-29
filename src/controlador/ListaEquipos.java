package controlador;

import java.sql.SQLException;
import modelo.*;
/**
 *
 * @author Escar
 */
public class ListaEquipos {
    int n=32;//numero de equipos base datos
    Equipo[] equipos= new Equipo [n]; 
    
   public void ListaEquipos() throws SQLException{
       
        ConsultaSQL nombreEquipo = new ConsultaSQL();
        nombreEquipo.setResult("SELECT NOMBREEQUIPO, IDEQUIPO FROM EQUIPO");
        while(nombreEquipo.getResult().next()){
            String nombre=nombreEquipo.getResult().getString(1);
            int n=nombreEquipo.getResult().getInt(2)-1; //para coincidir con indices de codigo
            this.equipos[n]=new Equipo(nombre ,CreadorEquiposDesdeDB.crear(n));
            this.equipos[n].setId(n);
        }
    nombreEquipo.cerrarConexion();
            
        
    }
   


    public Equipo getEquipos(int i) {
        return equipos[i];
    }
}  

