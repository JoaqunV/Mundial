package controlador;

import java.io.*;

/**
 * 
 * @author Escar
 * 
 * Leer se encarga de tomar los datos desde archivo.txt para ser mostrados en pantalla posteriormente
 */

public class Leer{
    public static String leer (){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String textofin="";

        try{
        // Apertura del fichero y creacion de BufferedReader para poder
        // hacer una lectura comoda (disponer del metodo readLine())
            archivo = new File ("archivo.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

        // Lectura del fichero
            String linea;
            
            while((linea=br.readLine())!=null)
                textofin=textofin+"\n"+linea;
        }
        catch(Exception e){
            e.printStackTrace();
        
        try{
            if( null!= fr ){
                fr.close();
            }
        }catch (Exception e2){ 
            e2.printStackTrace();
        }   
    }
        return textofin;
    }
}