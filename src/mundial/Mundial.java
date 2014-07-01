package mundial;

import controlador.*;
import java.sql.SQLException;
import modelo.*;
import vista.*;

/**
 * Integrates Nicolas Olivares, Luis Tapia, Joaquin Villagra
 * @author Escar
 */

public class Mundial 
{
    public static void main(String[] args) throws SQLException {
        
        VentanaP ventanaPrincipal = new VentanaP();
        //MenuFinal.menu();
        ventanaPrincipal.setVisible(true);
        
    }      
}
