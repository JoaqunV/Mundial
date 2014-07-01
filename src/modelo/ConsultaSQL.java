
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nicolas
 * 
 * ConsultaSQL es la conexion directa que se tiene con el servidor sql y sus datos
 */
public class ConsultaSQL {

    private Connection conexion=null;
    private Statement sentencia = null;
    private ResultSet result= null;
    String url;
    String consulta;
    int update;
    
    
    public ConsultaSQL(){
        try {
            // nombre de la BD: Mundial // usuario: Escar // pass: easy
            url = "jdbc:derby://localhost:1527/Mundial;user=Escar;password=easy";
            conexion=DriverManager.getConnection(url);
            sentencia= conexion.createStatement();            
           // System.out.println("Conexion a Base de Datos "+url+" . . . . .Ok");

        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setResult(String textodeconsulta) throws SQLException{
        this.result= sentencia.executeQuery(textodeconsulta);
    }
    
    public ResultSet getResult() throws SQLException{
        return result;
    }
    
    public int getUpdate(String textodeupdate) throws SQLException{
        this.update = sentencia.executeUpdate(textodeupdate);
        return update;
    }
    
    public String getConsulta(){
        return consulta;
    }
    
  
    public Connection getConexion(){
        return conexion;
    }
    
    public Statement getSentencia(){
        return sentencia;
    }
                
    public Connection cerrarConexion(){
        try {
            conexion.close();
            // System.out.println("Cerrando conexion a "+url+" . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion=null;
        return conexion;
    }
    
    public Statement cerrarStatement(){
        try {
            sentencia.close();
             //System.out.println("Cerrando conexion a "+url+" . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        sentencia=null;
        return sentencia;
        

}
}

