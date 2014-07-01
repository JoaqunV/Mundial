package controlador;

/**
 * 
 * @author Escar
 * 
 * Escribir se encarga de registrar los aconteciientos en archivo.txt 
 * 
 */


import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Escar
 */
public class Escribir {
 
    public static void Escribir( String linea, boolean continuar)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("archivo.txt", continuar);
            pw = new PrintWriter(fichero);
 
            pw.println(linea);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
    

