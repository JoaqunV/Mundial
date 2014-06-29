package controlador;

import java.io.*;
/**
 *
 * @author Escar
 * 
 *  Leer lee el archivo de la base de datos y lo separa
 */

 //lectura solo de jugadores!!!!
public class Leer {
   public static String[][] leer(String nombreArchivo) {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      String texto="";
 
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("..\\Mundial\\"+nombreArchivo+".txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
             texto=texto+linea;
             texto=texto+"\n";
         }
         
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      String[] separado, masSeparado; 
      separado= texto.split("\n");
      String[][] chevere=new String [separado.length][8]; // 8 es igual al numero de parametros que entra
      for (int i=0; i<separado.length; i++){
          masSeparado=separado[i].split(";");
            for(int j=0; j<masSeparado.length;j++)
                    chevere[i][j]=masSeparado[j];
      }
      
      return chevere;
   }
}