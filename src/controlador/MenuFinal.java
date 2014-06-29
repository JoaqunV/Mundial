package controlador;
import java.sql.SQLException;
import modelo.*;
import java.util.Scanner;

/**
 *
 * @author Escar
 */
public class MenuFinal { 
    
    public static void  partido1() throws SQLException{
        Scanner in = new Scanner ( System.in ); 
        ListaEquipos equipos = new ListaEquipos();
        equipos.ListaEquipos();
        int opcion1;
                do{
                System.out.println("\nDesea elegir los equipos");
                System.out.println("1. Si\n2. No");
                opcion1=in.nextInt();
                switch(opcion1){
                    case 1:{
                        int[] opcion2=new int[2];
                        System.out.println("\nSeleccione dos equipos");
                        System.out.println("1. Alemania\n2. Argelia\n3. Argentina\n4. Australia");
                        System.out.println("5. Belgica\n6. Bosnia y Herzegovina\n7. Brazil\n8. Camerun");
                        System.out.println("9. Chile\n10. Colombia\n11. Corea del Sur\n12. Costa de Marfil");
                        System.out.println("13. Costa Rica\n14. Croacia\n15. Ecuador\n16. España");
                        System.out.println("17. Estados Unidos\n18. Francia\n19. Ghana\n20. Grecia");
                        System.out.println("21. Honduras\n22. Inglaterra\n23. Iran\n24. Italia");
                        System.out.println("25. Japon\n26. Mexico\n27. Nigeria\n28. Paises Bajos");
                        System.out.println("29. Portugal\n30. Rusia\n31. Suiza\n32. Uruguay");
                        
                        do{
                            System.out.println("Equipo 1: ");
                            opcion2[0]=in.nextInt()-1;
                        }while(opcion2[0]>32);
                        
                        do{
                            System.out.println("Equipo 2; ");
                            opcion2[1]=in.nextInt()-1;
                        }while(opcion2[1]>32 || opcion2[1]==opcion2[0]);
                        
                        Pelota pelota=new Pelota();
                        Cancha cancha=new Cancha();
                        cancha.setEquipos(equipos.getEquipos(opcion2[0]), 0);
                        cancha.setEquipos(equipos.getEquipos(opcion2[1]), 1);
                        int[] n=SimularPartido.simularPartido(cancha, pelota, 0, 0);  // 0 0 arreglar formaciones
                        if(n[0]==0){
                            System.out.println("Equipo de "+equipos.getEquipos(opcion2[0]).getNombre().trim()+" gana a "+equipos.getEquipos(opcion2[1]).getNombre().trim()+" con "+equipos.getEquipos(opcion2[0]).getGoles()+" goles a "+equipos.getEquipos(opcion2[1]).getGoles());
                        }else if(n[0]==1){
                            System.out.println("Equipo de "+equipos.getEquipos(opcion2[1]).getNombre().trim()+" gana a "+equipos.getEquipos(opcion2[0]).getNombre().trim()+" con "+equipos.getEquipos(opcion2[1]).getGoles()+" goles a "+equipos.getEquipos(opcion2[0]).getGoles());
                        }else{
                            int comp=0;//comprobante
                            while(comp==0){
                                int[] penal;
                                penal=SimularPartido.penales(cancha);
                                cancha.getEquipoX(0).setGoles(cancha.getEquipoX(0).getGoles()+penal[0]);
                                cancha.getEquipoX(1).setGoles(cancha.getEquipoX(1).getGoles()+penal[1]);
                                if (cancha.getEquipoX(0).getGoles()>cancha.getEquipoX(1).getGoles()){
                                    n[0]=0;  
                                    comp=1;
                                 }else if(cancha.getEquipoX(1).getGoles()>cancha.getEquipoX(0).getGoles()){
                                        n[0]=1;
                                         comp=1;
                                }else{
                                    comp=0;
                                }
                            }
                            if(n[0]==0){
                                    System.out.println("Equipo de "+equipos.getEquipos(opcion2[0]).getNombre().trim()+" gana a "+equipos.getEquipos(opcion2[1]).getNombre().trim()+" con "+equipos.getEquipos(opcion2[0]).getGoles()+" goles a "+equipos.getEquipos(opcion2[1]).getGoles());
                            }else if(n[0]==1){
                                 System.out.println("Equipo de "+equipos.getEquipos(opcion2[1]).getNombre().trim()+" gana a "+equipos.getEquipos(opcion2[0]).getNombre().trim()+" con "+equipos.getEquipos(opcion2[1]).getGoles()+" goles a "+equipos.getEquipos(opcion2[0]).getGoles());
                            }
                        
                        }
                        break;
                    }
                    case 2:{
                        int[] opcion2=new int[2];
                        opcion2[0]=(int)(Math.random()*32);
                        do{
                        opcion2[1]=(int)(Math.random()*32);
                        }while(opcion2[0]==opcion2[1]);
                        
                        Pelota pelota=new Pelota();
                        Cancha cancha=new Cancha();
                        cancha.setEquipos(equipos.getEquipos(opcion2[0]), 0);
                        cancha.setEquipos(equipos.getEquipos(opcion2[1]), 1);
                        int[] n=SimularPartido.simularPartido(cancha, pelota, 0, 0);  // 0 0 arreglar formaciones
                        if(n[0]==0){
                            System.out.println("Equipo de "+equipos.getEquipos(opcion2[0]).getNombre().trim()+" gana a "+equipos.getEquipos(opcion2[1]).getNombre().trim()+" con "+equipos.getEquipos(opcion2[0]).getGoles()+" goles a "+equipos.getEquipos(opcion2[1]).getGoles());
                        }else if(n[0]==1){
                            System.out.println("Equipo de "+equipos.getEquipos(opcion2[1]).getNombre().trim()+" gana a "+equipos.getEquipos(opcion2[0]).getNombre().trim()+" con "+equipos.getEquipos(opcion2[1]).getGoles()+" goles a "+equipos.getEquipos(opcion2[0]).getGoles());
                        }else{
                            int comp=0;//comprobante
                            while(comp==0){
                                int[] penal;
                                penal=SimularPartido.penales(cancha);
                                cancha.getEquipoX(0).setGoles(cancha.getEquipoX(0).getGoles()+penal[0]);
                                cancha.getEquipoX(1).setGoles(cancha.getEquipoX(1).getGoles()+penal[1]);
                                if (cancha.getEquipoX(0).getGoles()>cancha.getEquipoX(1).getGoles()){
                                    n[0]=0;  
                                    comp=1;
                                 }else if(cancha.getEquipoX(1).getGoles()>cancha.getEquipoX(0).getGoles()){
                                        n[0]=1;
                                         comp=1;
                                }else{
                                    comp=0;
                                }
                            }
                            if(n[0]==0){
                                    System.out.println("Equipo de "+equipos.getEquipos(opcion2[0]).getNombre().trim()+" gana a "+equipos.getEquipos(opcion2[1]).getNombre().trim()+" con "+equipos.getEquipos(opcion2[0]).getGoles()+" goles a "+equipos.getEquipos(opcion2[1]).getGoles());
                            }else if(n[0]==1){
                                 System.out.println("Equipo de "+equipos.getEquipos(opcion2[1]).getNombre().trim()+" gana a "+equipos.getEquipos(opcion2[0]).getNombre().trim()+" con "+equipos.getEquipos(opcion2[1]).getGoles()+" goles a "+equipos.getEquipos(opcion2[0]).getGoles());
                            }
                        }
                        break;
                    }
                    default:{
                        System.out.println("Ingrese opcion valida");
                        opcion1=0;
                        break;
                    }
                            
                }
                }while(opcion1==0);
              
    }
    
    public static void faseGrupo1() throws SQLException{
        Scanner in = new Scanner ( System.in ); 
        ListaEquipos equipos = new ListaEquipos();
        equipos.ListaEquipos();
        
        int opcion1;
                do{
                System.out.println("\nDesea elegir los grupos");
                System.out.println("1. Si\n2. No");
                opcion1=in.nextInt();
                switch(opcion1){
                    case 1:{
                        int[] grupo1=new int[4];
                        int[] grupo2=new int[4];
                        int[] grupo3=new int[4];
                        int[] grupo4=new int[4];
                        int[] grupo5=new int[4];
                        int[] grupo6=new int[4];
                        int[] grupo7=new int[4];
                        int[] grupo8=new int[4];
                        System.out.println("\nSeleccione 4 equipos por grupo");
                        System.out.println("1. Alemania\n2. Argelia\n3. Argentina\n4. Australia");
                        System.out.println("5. Belgica\n6. Bosnia y Herzegovina\n7. Brazil\n8. Camerun");
                        System.out.println("9. Chile\n10. Colombia\n11. Corea del Sur\n12. Costa de Marfil");
                        System.out.println("13. Costa Rica\n14. Croacia\n15. Ecuador\n16. España");
                        System.out.println("17. Estados Unidos\n18. Francia\n19. Ghana\n20. Grecia");
                        System.out.println("21. Honduras\n22. Inglaterra\n23. Iran\n24. Italia");
                        System.out.println("25. Japon\n26. Mexico\n27. Nigeria\n28. Paises Bajos");
                        System.out.println("29. Portugal\n30. Rusia\n31. Suiza\n32. Uruguay");
                        
                        do{
                            System.out.println("Grupo A:\nEquipo1 ");
                            grupo1[0]=in.nextInt()-1;
                            System.out.println("Equipo 2 ");
                            grupo1[1]=in.nextInt()-1;
                            System.out.println("Equipo 3 ");
                            grupo1[2]=in.nextInt()-1;
                            System.out.println("Equipo 4 ");
                            grupo1[3]=in.nextInt()-1;
                        }while(grupo1[0]>32 || grupo1[1]>32 || grupo1[2]>32 || grupo1[3]>32);
                        
                        do{
                            System.out.println("Grupo B:\nEquipo1 ");
                            grupo2[0]=in.nextInt()-1;
                            System.out.println("Equipo 2 ");
                            grupo2[1]=in.nextInt()-1;
                            System.out.println("Equipo 3 ");
                            grupo2[2]=in.nextInt()-1;
                            System.out.println("Equipo 4 ");
                            grupo2[3]=in.nextInt()-1;
                            for (int i=0;i<4;i++){
                                if(grupo2[0]==grupo1[i]){
                                    System.out.println("El equipo "+grupo2[0]+". "+equipos.getEquipos(grupo2[0]).getNombre()+"ya esta en otro grupo");
                                    grupo2[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo2[1]==grupo1[i]){
                                    System.out.println("El equipo "+grupo2[1]+". "+equipos.getEquipos(grupo2[1]).getNombre()+"ya esta en otro grupo");
                                    grupo2[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo2[2]==grupo1[i]){
                                    System.out.println("El equipo "+grupo2[2]+". "+equipos.getEquipos(grupo2[2]).getNombre()+"ya esta en otro grupo");
                                    grupo2[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo2[3]==grupo1[i]){
                                    System.out.println("El equipo "+grupo2[3]+". "+equipos.getEquipos(grupo2[3]).getNombre()+"ya esta en otro grupo");
                                    grupo2[0]=80;//obliga a saltar condicion para repetir
                                }
                            }
                        }while(grupo2[0]>32 || grupo2[1]>32 || grupo2[2]>32 || grupo2[3]>32);
                        
                        do{
                            System.out.println("Grupo C:\nEquipo1 ");
                            grupo3[0]=in.nextInt()-1;
                            System.out.println("Equipo 2 ");
                            grupo3[1]=in.nextInt()-1;
                            System.out.println("Equipo 3 ");
                            grupo3[2]=in.nextInt()-1;
                            System.out.println("Equipo 4 ");
                            grupo3[3]=in.nextInt()-1;
                            for (int i=0;i<4;i++){
                                if(grupo3[0]==grupo1[i] || grupo3[0]==grupo2[i]){
                                    System.out.println("El equipo "+grupo3[0]+". "+equipos.getEquipos(grupo3[0]).getNombre()+"ya esta en otro grupo");
                                    grupo3[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo3[1]==grupo1[i] || grupo3[1]==grupo2[i]){
                                    System.out.println("El equipo "+grupo3[1]+". "+equipos.getEquipos(grupo3[1]).getNombre()+"ya esta en otro grupo");
                                    grupo3[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo3[2]==grupo1[i] || grupo3[2]==grupo2[i]){
                                    System.out.println("El equipo "+grupo3[2]+". "+equipos.getEquipos(grupo3[2]).getNombre()+"ya esta en otro grupo");
                                    grupo3[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo3[3]==grupo1[i] || grupo3[3]==grupo2[i]){
                                    System.out.println("El equipo "+grupo3[3]+". "+equipos.getEquipos(grupo3[3]).getNombre()+"ya esta en otro grupo");
                                    grupo3[0]=80;//obliga a saltar condicion para repetir
                                }
                            }
                        }while(grupo3[0]>32 || grupo3[1]>32 || grupo3[2]>32 || grupo3[3]>32);
                        
                        do{
                            System.out.println("Grupo D:\nEquipo1 ");
                            grupo4[0]=in.nextInt()-1;
                            System.out.println("Equipo 2 ");
                            grupo4[1]=in.nextInt()-1;
                            System.out.println("Equipo 3 ");
                            grupo4[2]=in.nextInt()-1;
                            System.out.println("Equipo 4 ");
                            grupo4[3]=in.nextInt()-1;
                            for (int i=0;i<4;i++){
                                if(grupo4[0]==grupo1[i] || grupo4[0]==grupo2[i] || grupo4[0]==grupo3[i]){
                                    System.out.println("El equipo "+grupo4[0]+". "+equipos.getEquipos(grupo4[0]).getNombre()+"ya esta en otro grupo");
                                    grupo4[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo4[1]==grupo1[i] || grupo4[1]==grupo2[i] || grupo4[1]==grupo3[i]){
                                    System.out.println("El equipo "+grupo4[1]+". "+equipos.getEquipos(grupo4[1]).getNombre()+"ya esta en otro grupo");
                                    grupo4[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo4[2]==grupo1[i] || grupo4[2]==grupo2[i] || grupo4[2]==grupo3[i]){
                                    System.out.println("El equipo "+grupo4[2]+". "+equipos.getEquipos(grupo4[2]).getNombre()+"ya esta en otro grupo");
                                    grupo4[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo4[3]==grupo1[i] || grupo4[3]==grupo2[i] || grupo4[3]==grupo3[i]){
                                    System.out.println("El equipo "+grupo4[3]+". "+equipos.getEquipos(grupo4[3]).getNombre()+"ya esta en otro grupo");
                                    grupo4[0]=80;//obliga a saltar condicion para repetir
                                }
                            }
                        }while(grupo4[0]>32 || grupo4[1]>32 || grupo4[2]>32 || grupo4[3]>32);
                   
                        do{
                            System.out.println("Grupo E:\nEquipo1 ");
                            grupo5[0]=in.nextInt()-1;
                            System.out.println("Equipo 2 ");
                            grupo5[1]=in.nextInt()-1;
                            System.out.println("Equipo 3 ");
                            grupo5[2]=in.nextInt()-1;
                            System.out.println("Equipo 4 ");
                            grupo5[3]=in.nextInt()-1;
                            for (int i=0;i<4;i++){
                                if(grupo5[0]==grupo1[i] || grupo5[0]==grupo2[i] || grupo5[0]==grupo3[i] || grupo5[0]==grupo4[i]){
                                    System.out.println("El equipo "+grupo5[0]+". "+equipos.getEquipos(grupo5[0]).getNombre()+"ya esta en otro grupo");
                                    grupo5[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo4[1]==grupo1[i] || grupo4[1]==grupo2[i] || grupo4[1]==grupo3[i] || grupo5[0]==grupo4[i]){
                                    System.out.println("El equipo "+grupo5[1]+". "+equipos.getEquipos(grupo5[1]).getNombre()+"ya esta en otro grupo");
                                    grupo5[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo5[2]==grupo1[i] || grupo5[2]==grupo2[i] || grupo5[2]==grupo3[i] || grupo5[0]==grupo4[i]){
                                    System.out.println("El equipo "+grupo5[2]+". "+equipos.getEquipos(grupo5[2]).getNombre()+"ya esta en otro grupo");
                                    grupo5[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo5[3]==grupo1[i] || grupo5[3]==grupo2[i] || grupo5[3]==grupo3[i] || grupo5[0]==grupo4[i]){
                                    System.out.println("El equipo "+grupo5[3]+". "+equipos.getEquipos(grupo5[3]).getNombre()+"ya esta en otro grupo");
                                    grupo5[0]=80;//obliga a saltar condicion para repetir
                                }
                            }
                        }while(grupo5[0]>32 || grupo5[1]>32 || grupo5[2]>32 || grupo5[3]>32);
                        
                        do{
                            System.out.println("Grupo F:\nEquipo1 ");
                            grupo6[0]=in.nextInt()-1;
                            System.out.println("Equipo 2 ");
                            grupo6[1]=in.nextInt()-1;
                            System.out.println("Equipo 3 ");
                            grupo6[2]=in.nextInt()-1;
                            System.out.println("Equipo 4 ");
                            grupo6[3]=in.nextInt()-1;
                            for (int i=0;i<4;i++){
                                if(grupo6[0]==grupo1[i] || grupo6[0]==grupo2[i] || grupo6[0]==grupo3[i] || grupo6[0]==grupo4[i] || grupo6[0]==grupo5[i]){
                                    System.out.println("El equipo "+grupo6[0]+". "+equipos.getEquipos(grupo6[0]).getNombre()+"ya esta en otro grupo");
                                    grupo6[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo6[1]==grupo1[i] || grupo6[1]==grupo2[i] || grupo6[1]==grupo3[i] || grupo6[0]==grupo4[i] || grupo6[0]==grupo5[i]){
                                    System.out.println("El equipo "+grupo6[1]+". "+equipos.getEquipos(grupo6[1]).getNombre()+"ya esta en otro grupo");
                                    grupo6[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo6[2]==grupo1[i] || grupo6[2]==grupo2[i] || grupo6[2]==grupo3[i] || grupo6[0]==grupo4[i] || grupo6[0]==grupo5[i]){
                                    System.out.println("El equipo "+grupo6[2]+". "+equipos.getEquipos(grupo6[2]).getNombre()+"ya esta en otro grupo");
                                    grupo6[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo6[3]==grupo1[i] || grupo6[3]==grupo2[i] || grupo6[3]==grupo3[i] || grupo6[0]==grupo4[i] || grupo6[0]==grupo5[i]){
                                    System.out.println("El equipo "+grupo6[3]+". "+equipos.getEquipos(grupo6[3]).getNombre()+"ya esta en otro grupo");
                                    grupo6[0]=80;//obliga a saltar condicion para repetir
                                }
                            }
                        }while(grupo6[0]>32 || grupo6[1]>32 || grupo6[2]>32 || grupo6[3]>32);
                        
                        do{
                            System.out.println("Grupo G:\nEquipo1 ");
                            grupo7[0]=in.nextInt()-1;
                            System.out.println("Equipo 2 ");
                            grupo7[1]=in.nextInt()-1;
                            System.out.println("Equipo 3 ");
                            grupo7[2]=in.nextInt()-1;
                            System.out.println("Equipo 4 ");
                            grupo7[3]=in.nextInt()-1;
                            for (int i=0;i<4;i++){
                                if(grupo7[0]==grupo1[i] || grupo7[0]==grupo2[i] || grupo7[0]==grupo3[i] || grupo7[0]==grupo4[i] || grupo7[0]==grupo5[i] || grupo7[0]==grupo6[i]){
                                    System.out.println("El equipo "+grupo7[0]+". "+equipos.getEquipos(grupo7[0]).getNombre()+"ya esta en otro grupo");
                                    grupo7[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo7[1]==grupo1[i] || grupo7[1]==grupo2[i] || grupo7[1]==grupo3[i] || grupo7[1]==grupo4[i] || grupo7[1]==grupo5[i] || grupo7[1]==grupo6[i]){
                                    System.out.println("El equipo "+grupo7[1]+". "+equipos.getEquipos(grupo7[1]).getNombre()+"ya esta en otro grupo");
                                    grupo7[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo7[2]==grupo1[i] || grupo7[2]==grupo2[i] || grupo7[2]==grupo3[i] || grupo7[2]==grupo4[i] || grupo7[2]==grupo5[i] || grupo7[2]==grupo6[i]){
                                    System.out.println("El equipo "+grupo7[2]+". "+equipos.getEquipos(grupo7[2]).getNombre()+"ya esta en otro grupo");
                                    grupo7[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo7[3]==grupo1[i] || grupo7[3]==grupo2[i] || grupo7[3]==grupo3[i] || grupo7[3]==grupo4[i] || grupo7[3]==grupo5[i] || grupo7[3]==grupo6[i]){
                                    System.out.println("El equipo "+grupo7[3]+". "+equipos.getEquipos(grupo7[3]).getNombre()+"ya esta en otro grupo");
                                    grupo7[0]=80;//obliga a saltar condicion para repetir
                                }
                            }
                        }while(grupo7[0]>32 || grupo7[1]>32 || grupo7[2]>32 || grupo7[3]>32);
                        
                        do{
                            System.out.println("Grupo H:\nEquipo1 ");
                            grupo8[0]=in.nextInt()-1;
                            System.out.println("Equipo 2 ");
                            grupo8[1]=in.nextInt()-1;
                            System.out.println("Equipo 3 ");
                            grupo8[2]=in.nextInt()-1;
                            System.out.println("Equipo 4 ");
                            grupo8[3]=in.nextInt()-1;
                            for (int i=0;i<4;i++){
                                if(grupo8[0]==grupo1[i] || grupo8[0]==grupo2[i] || grupo8[0]==grupo3[i] || grupo8[0]==grupo4[i] || grupo8[0]==grupo5[i] || grupo8[0]==grupo6[i] || grupo8[0]==grupo7[i]){
                                    System.out.println("El equipo "+grupo8[0]+". "+equipos.getEquipos(grupo8[0]).getNombre()+"ya esta en otro grupo");
                                    grupo8[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo8[1]==grupo1[i] || grupo8[1]==grupo2[i] || grupo8[1]==grupo3[i] || grupo8[1]==grupo4[i] || grupo8[1]==grupo5[i] || grupo8[1]==grupo6[i] || grupo8[1]==grupo7[i]){
                                    System.out.println("El equipo "+grupo8[1]+". "+equipos.getEquipos(grupo8[1]).getNombre()+"ya esta en otro grupo");
                                    grupo8[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo8[2]==grupo1[i] || grupo8[2]==grupo2[i] || grupo8[2]==grupo3[i] || grupo8[2]==grupo4[i] || grupo8[2]==grupo5[i] || grupo8[2]==grupo6[i] || grupo8[2]==grupo7[i]){
                                    System.out.println("El equipo "+grupo8[2]+". "+equipos.getEquipos(grupo8[2]).getNombre()+"ya esta en otro grupo");
                                    grupo8[0]=80;//obliga a saltar condicion para repetir
                                }
                                if(grupo8[3]==grupo1[i] || grupo8[3]==grupo2[i] || grupo8[3]==grupo3[i] || grupo8[3]==grupo4[i] || grupo8[3]==grupo5[i] || grupo8[3]==grupo6[i] || grupo8[3]==grupo7[i]){
                                    System.out.println("El equipo "+grupo8[3]+". "+equipos.getEquipos(grupo8[3]).getNombre()+"ya esta en otro grupo");
                                    grupo8[0]=80;//obliga a saltar condicion para repetir
                                }
                            }
                        }while(grupo8[0]>32 || grupo8[1]>32 || grupo8[2]>32 || grupo8[3]>32);
                            
                        Grupo A= new Grupo("A", equipos.getEquipos(grupo1[0]),  equipos.getEquipos(grupo1[1]),  equipos.getEquipos(grupo1[2]),  equipos.getEquipos(grupo1[3]));
                        Grupo B= new Grupo("B", equipos.getEquipos(grupo2[0]),  equipos.getEquipos(grupo2[1]), equipos.getEquipos(grupo2[2]),  equipos.getEquipos(grupo2[3]));
                        Grupo C= new Grupo("C", equipos.getEquipos(grupo3[0]), equipos.getEquipos(grupo3[1]), equipos.getEquipos(grupo3[2]), equipos.getEquipos(grupo3[3]));
                        Grupo D= new Grupo("D", equipos.getEquipos(grupo4[0]), equipos.getEquipos(grupo4[1]), equipos.getEquipos(grupo4[2]), equipos.getEquipos(grupo4[3]));
                        Grupo E= new Grupo("E", equipos.getEquipos(grupo5[0]),  equipos.getEquipos(grupo5[1]),  equipos.getEquipos(grupo5[2]),  equipos.getEquipos(grupo5[3]));
                        Grupo F= new Grupo("F", equipos.getEquipos(grupo6[0]), equipos.getEquipos(grupo6[1]), equipos.getEquipos(grupo6[2]), equipos.getEquipos(grupo6[3]));
                        Grupo G= new Grupo("G", equipos.getEquipos(grupo7[0]), equipos.getEquipos(grupo7[1]), equipos.getEquipos(grupo7[2]), equipos.getEquipos(grupo7[3]));
                        Grupo H= new Grupo("H", equipos.getEquipos(grupo8[0]), equipos.getEquipos(grupo8[1]), equipos.getEquipos(grupo8[2]), equipos.getEquipos(grupo8[3]));
       
                            FaseGrupos fase = new FaseGrupos(A,B,C,D,E,F,G,H);
                            Equipo[] winners=SimularFaseGrupos.simular(fase);
                            
                                System.out.println("Ganadores Grupo "+A.getLetra()+": "+A.getGanadores()[0].getNombre().trim()+" con "+A.getGanadores()[0].getPuntos()+" pts, "+A.getGanadores()[1].getNombre().trim()+" con "+A.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+B.getLetra()+": "+B.getGanadores()[0].getNombre().trim()+" con "+B.getGanadores()[0].getPuntos()+" pts, "+B.getGanadores()[1].getNombre().trim()+" con "+B.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+C.getLetra()+": "+C.getGanadores()[0].getNombre().trim()+" con "+C.getGanadores()[0].getPuntos()+" pts, "+C.getGanadores()[1].getNombre().trim()+" con "+C.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+D.getLetra()+": "+D.getGanadores()[0].getNombre().trim()+" con "+D.getGanadores()[0].getPuntos()+" pts, "+D.getGanadores()[1].getNombre().trim()+" con "+D.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+E.getLetra()+": "+E.getGanadores()[0].getNombre().trim()+" con "+E.getGanadores()[0].getPuntos()+" pts, "+E.getGanadores()[1].getNombre().trim()+" con "+E.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+F.getLetra()+": "+F.getGanadores()[0].getNombre().trim()+" con "+F.getGanadores()[0].getPuntos()+" pts, "+F.getGanadores()[1].getNombre().trim()+" con "+F.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+G.getLetra()+": "+G.getGanadores()[0].getNombre().trim()+" con "+G.getGanadores()[0].getPuntos()+" pts, "+G.getGanadores()[1].getNombre().trim()+" con "+G.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+H.getLetra()+": "+H.getGanadores()[0].getNombre().trim()+" con "+H.getGanadores()[0].getPuntos()+" pts, "+H.getGanadores()[1].getNombre().trim()+" con "+H.getGanadores()[1].getPuntos()+" pts");
                            
                        
                        break;
                    }
                    case 2:{
                        Grupo A= new Grupo("A", equipos.getEquipos(0),  equipos.getEquipos(2),  equipos.getEquipos(3),  equipos.getEquipos(4));
                        Grupo B= new Grupo("B", equipos.getEquipos(9),  equipos.getEquipos(10), equipos.getEquipos(1),  equipos.getEquipos(11));
                        Grupo C= new Grupo("C", equipos.getEquipos(16), equipos.getEquipos(17), equipos.getEquipos(18), equipos.getEquipos(19));
                        Grupo D= new Grupo("D", equipos.getEquipos(24), equipos.getEquipos(25), equipos.getEquipos(26), equipos.getEquipos(27));
                        Grupo E= new Grupo("E", equipos.getEquipos(5),  equipos.getEquipos(6),  equipos.getEquipos(7),  equipos.getEquipos(8));
                        Grupo F= new Grupo("F", equipos.getEquipos(12), equipos.getEquipos(13), equipos.getEquipos(14), equipos.getEquipos(15));
                        Grupo G= new Grupo("G", equipos.getEquipos(20), equipos.getEquipos(21), equipos.getEquipos(22), equipos.getEquipos(23));
                        Grupo H= new Grupo("H", equipos.getEquipos(28), equipos.getEquipos(29), equipos.getEquipos(30), equipos.getEquipos(31));
       
                        FaseGrupos fase = new FaseGrupos(A,B,C,D,E,F,G,H);
                        Equipo[] winners=SimularFaseGrupos.simular(fase);
                        for(int i=0;i<16;i++){
                            System.out.println("Winner "+i+" "+winners[i].getNombre());
                        }
                        
                        
                                System.out.println("Ganadores Grupo "+A.getLetra()+": "+A.getGanadores()[0].getNombre().trim()+" con "+A.getGanadores()[0].getPuntos()+" pts, "+A.getGanadores()[1].getNombre().trim()+" con "+A.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+B.getLetra()+": "+B.getGanadores()[0].getNombre().trim()+" con "+B.getGanadores()[0].getPuntos()+" pts, "+B.getGanadores()[1].getNombre().trim()+" con "+B.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+C.getLetra()+": "+C.getGanadores()[0].getNombre().trim()+" con "+C.getGanadores()[0].getPuntos()+" pts, "+C.getGanadores()[1].getNombre().trim()+" con "+C.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+D.getLetra()+": "+D.getGanadores()[0].getNombre().trim()+" con "+D.getGanadores()[0].getPuntos()+" pts, "+D.getGanadores()[1].getNombre().trim()+" con "+D.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+E.getLetra()+": "+E.getGanadores()[0].getNombre().trim()+" con "+E.getGanadores()[0].getPuntos()+" pts, "+E.getGanadores()[1].getNombre().trim()+" con "+E.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+F.getLetra()+": "+F.getGanadores()[0].getNombre().trim()+" con "+F.getGanadores()[0].getPuntos()+" pts, "+F.getGanadores()[1].getNombre().trim()+" con "+F.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+G.getLetra()+": "+G.getGanadores()[0].getNombre().trim()+" con "+G.getGanadores()[0].getPuntos()+" pts, "+G.getGanadores()[1].getNombre().trim()+" con "+G.getGanadores()[1].getPuntos()+" pts");
                                System.out.println("Ganadores Grupo "+H.getLetra()+": "+H.getGanadores()[0].getNombre().trim()+" con "+H.getGanadores()[0].getPuntos()+" pts, "+H.getGanadores()[1].getNombre().trim()+" con "+H.getGanadores()[1].getPuntos()+" pts");
                            
                        
                        break;
                    }
                    
                    default:{
                        System.out.println("Ingrese opcion valida");
                        opcion1=0;
                        break;
                    }
                    
                }
                }while(opcion1==0);
        
    }
    
    public static void segundaFase1() throws SQLException{
        Scanner in = new Scanner ( System.in ); 
        ListaEquipos equipos = new ListaEquipos();
        equipos.ListaEquipos();
        int opcion1;
                do{
                System.out.println("\nDesea elegir los equipos");
                System.out.println("1. Si\n2. No");
                opcion1=in.nextInt();
                switch(opcion1){
                    case 1:{
                        int[] opcion2=new int[16];
                        System.out.println("Elige 16 equipos:\n");
                        System.out.println("1. Alemania\n2. Argelia\n3. Argentina\n4. Australia");
                        System.out.println("5. Belgica\n6. Bosnia y Herzegovina\n7. Brazil\n8. Camerun");
                        System.out.println("9. Chile\n10. Colombia\n11. Corea del Sur\n12. Costa de Marfil");
                        System.out.println("13. Costa Rica\n14. Croacia\n15. Ecuador\n16. España");
                        System.out.println("17. Estados Unidos\n18. Francia\n19. Ghana\n20. Grecia");
                        System.out.println("21. Honduras\n22. Inglaterra\n23. Iran\n24. Italia");
                        System.out.println("25. Japon\n26. Mexico\n27. Nigeria\n28. Paises Bajos");
                        System.out.println("29. Portugal\n30. Rusia\n31. Suiza\n32. Uruguay");
                        
                        
                        do{
                            System.out.println("Equipo 1: ");
                            opcion2[0]=in.nextInt()-1;
                            
                        }while(opcion2[0]>32);
                        
                        do{
                            System.out.println("Equipo 2: ");
                            opcion2[1]=in.nextInt()-1;
                            if(opcion2[0]==opcion2[1]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[1]=80; //salta condicion
                            }
                        }while(opcion2[1]>32);
                        
                        do{
                            System.out.println("Equipo 3: ");
                            opcion2[2]=in.nextInt()-1;
                            if(opcion2[2]==opcion2[1] || opcion2[2]==opcion2[0]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[2]=80; //salta condicion
                            }
                        }while(opcion2[2]>32);
                        
                        do{
                            System.out.println("Equipo 4: ");
                            opcion2[3]=in.nextInt()-1;
                            if(opcion2[3]==opcion2[0] || opcion2[2]==opcion2[1]|| opcion2[3]==opcion2[2]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[3]=80; //salta condicion
                            }
                        }while(opcion2[3]>32);
                        
                        do{
                            System.out.println("Equipo 5: ");
                            opcion2[4]=in.nextInt()-1;
                            if(opcion2[4]==opcion2[0] || opcion2[4]==opcion2[1]|| opcion2[4]==opcion2[2]|| opcion2[4]==opcion2[3]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[4]=80; //salta condicion
                            }
                        }while(opcion2[4]>32);
                        
                        do{
                            System.out.println("Equipo 6: ");
                            opcion2[5]=in.nextInt()-1;
                            if(opcion2[5]==opcion2[0] || opcion2[5]==opcion2[1]|| opcion2[5]==opcion2[2]|| opcion2[5]==opcion2[3]|| opcion2[5]==opcion2[4]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[5]=80; //salta condicion
                            }
                        }while(opcion2[5]>32);
                        
                        do{
                            System.out.println("Equipo 7: ");
                            opcion2[6]=in.nextInt()-1;
                            if(opcion2[6]==opcion2[0] || opcion2[6]==opcion2[1]|| opcion2[6]==opcion2[2]|| opcion2[6]==opcion2[3]|| opcion2[6]==opcion2[4]|| opcion2[6]==opcion2[5]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[6]=80; //salta condicion
                            }
                        }while(opcion2[6]>32);
                        
                        do{
                            System.out.println("Equipo 8: ");
                            opcion2[7]=in.nextInt()-1;
                            if(opcion2[7]==opcion2[0] || opcion2[7]==opcion2[1]|| opcion2[7]==opcion2[2]|| opcion2[7]==opcion2[3]|| opcion2[7]==opcion2[4]|| opcion2[7]==opcion2[5]|| opcion2[7]==opcion2[6]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[7]=80; //salta condicion
                            }
                        }while(opcion2[7]>32);
                        
                        do{
                            System.out.println("Equipo 9: ");
                            opcion2[8]=in.nextInt()-1;
                            if(opcion2[8]==opcion2[0] || opcion2[8]==opcion2[1]|| opcion2[8]==opcion2[2]|| opcion2[8]==opcion2[3]|| opcion2[8]==opcion2[4]|| opcion2[8]==opcion2[5]|| opcion2[8]==opcion2[6]|| opcion2[8]==opcion2[7]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[8]=80; //salta condicion
                            }
                        }while(opcion2[8]>32);
                        
                        do{
                            System.out.println("Equipo 10: ");
                            opcion2[9]=in.nextInt()-1;
                            if(opcion2[9]==opcion2[0] || opcion2[9]==opcion2[1]|| opcion2[9]==opcion2[2]|| opcion2[9]==opcion2[3]|| opcion2[9]==opcion2[4]|| opcion2[9]==opcion2[5]|| opcion2[9]==opcion2[6]|| opcion2[9]==opcion2[7]|| opcion2[9]==opcion2[8]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[9]=80; //salta condicion
                            }
                        }while(opcion2[9]>32);
                        
                        do{
                            System.out.println("Equipo 11: ");
                            opcion2[10]=in.nextInt()-1;
                            if(opcion2[10]==opcion2[0] || opcion2[10]==opcion2[1]|| opcion2[10]==opcion2[2]|| opcion2[10]==opcion2[3]|| opcion2[10]==opcion2[4]|| opcion2[10]==opcion2[5]|| opcion2[10]==opcion2[6]|| opcion2[10]==opcion2[7]|| opcion2[10]==opcion2[8]|| opcion2[10]==opcion2[9]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[10]=80; //salta condicion
                            }
                        }while(opcion2[10]>32);
                        
                        do{
                            System.out.println("Equipo 12: ");
                            opcion2[11]=in.nextInt()-1;
                            if(opcion2[11]==opcion2[0] || opcion2[11]==opcion2[1]|| opcion2[11]==opcion2[2]|| opcion2[11]==opcion2[3]|| opcion2[11]==opcion2[4]|| opcion2[11]==opcion2[5]|| opcion2[11]==opcion2[6]|| opcion2[11]==opcion2[7]|| opcion2[11]==opcion2[8]|| opcion2[11]==opcion2[9]|| opcion2[11]==opcion2[10]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[11]=80; //salta condicion
                            }
                        }while(opcion2[11]>32);
                        
                        do{
                            System.out.println("Equipo 13: ");
                            opcion2[12]=in.nextInt()-1;
                            if(opcion2[12]==opcion2[0] || opcion2[12]==opcion2[1]|| opcion2[12]==opcion2[2]|| opcion2[12]==opcion2[3]|| opcion2[12]==opcion2[4]|| opcion2[12]==opcion2[5]|| opcion2[12]==opcion2[6]|| opcion2[12]==opcion2[7]|| opcion2[12]==opcion2[8]|| opcion2[12]==opcion2[9]|| opcion2[12]==opcion2[10]|| opcion2[12]==opcion2[11]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[13]=80; //salta condicion
                            }
                        }while(opcion2[12]>32);
                        
                        do{
                            System.out.println("Equipo 14: ");
                            opcion2[13]=in.nextInt()-1;
                            if(opcion2[13]==opcion2[0] || opcion2[13]==opcion2[1]|| opcion2[13]==opcion2[2]|| opcion2[13]==opcion2[3]|| opcion2[13]==opcion2[4]|| opcion2[13]==opcion2[5]|| opcion2[13]==opcion2[6]|| opcion2[13]==opcion2[7]|| opcion2[13]==opcion2[8]|| opcion2[13]==opcion2[9]|| opcion2[13]==opcion2[10]|| opcion2[13]==opcion2[11]|| opcion2[13]==opcion2[12]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[13]=80; //salta condicion
                            }
                        }while(opcion2[13]>32);
                        
                        do{
                            System.out.println("Equipo 15: ");
                            opcion2[14]=in.nextInt()-1;
                            if(opcion2[14]==opcion2[0] || opcion2[14]==opcion2[1]|| opcion2[14]==opcion2[2]|| opcion2[14]==opcion2[3]|| opcion2[14]==opcion2[4]|| opcion2[14]==opcion2[5]|| opcion2[14]==opcion2[6]|| opcion2[14]==opcion2[7]|| opcion2[14]==opcion2[8]|| opcion2[14]==opcion2[9]|| opcion2[14]==opcion2[10]|| opcion2[14]==opcion2[11]|| opcion2[14]==opcion2[12]|| opcion2[14]==opcion2[13]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[14]=80; //salta condicion
                            }
                        }while(opcion2[14]>32);
                        
                        do{
                            System.out.println("Equipo 16: ");
                            opcion2[15]=in.nextInt()-1;
                            if(opcion2[15]==opcion2[0] || opcion2[15]==opcion2[1]|| opcion2[15]==opcion2[2]|| opcion2[15]==opcion2[3]|| opcion2[15]==opcion2[4]|| opcion2[15]==opcion2[5]|| opcion2[15]==opcion2[6]|| opcion2[15]==opcion2[7]|| opcion2[15]==opcion2[8]|| opcion2[15]==opcion2[9]|| opcion2[15]==opcion2[10]|| opcion2[15]==opcion2[11]|| opcion2[15]==opcion2[12]|| opcion2[15]==opcion2[13]|| opcion2[15]==opcion2[14]){
                                System.out.println("El equipo seleccionado ya esta inscrito");
                                opcion2[15]=80; //salta condicion
                            }
                        }while(opcion2[15]>32);
                        Equipo[] clasificados=new Equipo [16];
                        for(int i=0;i<16;i++){
                            clasificados[i]=equipos.getEquipos(opcion2[i]);
                        }
                        Equipo ganador;
                        ganador=SegundaFase.simular(clasificados);
                        System.out.println("\nEl ganador de la segunda Fase es "+ganador.getNombre().trim());
                        
                        break;
                    }
                    case 2:{
                        int[] opcion2=new int[16];
                        
                        opcion2[0]=(int)(Math.random()*32);
                        do{
                            opcion2[1]=(int)(Math.random()*32);
                            if(opcion2[0]==opcion2[1]){
                                opcion2[1]=80; //salta condicion
                            }
                        }while(opcion2[1]>32);
                        
                        do{
                            
                            opcion2[2]=(int)(Math.random()*32);
                            if(opcion2[2]==opcion2[1] || opcion2[2]==opcion2[0]){
                                opcion2[2]=80; //salta condicion
                            }
                        }while(opcion2[2]>32);
                        
                        do{
                            opcion2[3]=(int)(Math.random()*32);
                            if(opcion2[3]==opcion2[0] || opcion2[2]==opcion2[1]|| opcion2[3]==opcion2[2]){
                                opcion2[3]=80; //salta condicion
                            }
                        }while(opcion2[3]>32);
                        
                        do{
                            opcion2[4]=(int)(Math.random()*32);
                            if(opcion2[4]==opcion2[0] || opcion2[4]==opcion2[1]|| opcion2[4]==opcion2[2]|| opcion2[4]==opcion2[3]){
                                opcion2[4]=80; //salta condicion
                            }
                        }while(opcion2[4]>32);
                        
                        do{
                            opcion2[5]=(int)(Math.random()*32);
                            if(opcion2[5]==opcion2[0] || opcion2[5]==opcion2[1]|| opcion2[5]==opcion2[2]|| opcion2[5]==opcion2[3]|| opcion2[5]==opcion2[4]){
                                opcion2[5]=80; //salta condicion
                            }
                        }while(opcion2[5]>32);
                        
                        do{
                            opcion2[6]=(int)(Math.random()*32);
                            if(opcion2[6]==opcion2[0] || opcion2[6]==opcion2[1]|| opcion2[6]==opcion2[2]|| opcion2[6]==opcion2[3]|| opcion2[6]==opcion2[4]|| opcion2[6]==opcion2[5]){
                                opcion2[6]=80; //salta condicion
                            }
                        }while(opcion2[6]>32);
                        
                        do{
                            opcion2[7]=(int)(Math.random()*32);
                            if(opcion2[7]==opcion2[0] || opcion2[7]==opcion2[1]|| opcion2[7]==opcion2[2]|| opcion2[7]==opcion2[3]|| opcion2[7]==opcion2[4]|| opcion2[7]==opcion2[5]|| opcion2[7]==opcion2[6]){
                                opcion2[7]=80; //salta condicion
                            }
                        }while(opcion2[7]>32);
                        
                        do{
                            opcion2[8]=(int)(Math.random()*32);
                            if(opcion2[8]==opcion2[0] || opcion2[8]==opcion2[1]|| opcion2[8]==opcion2[2]|| opcion2[8]==opcion2[3]|| opcion2[8]==opcion2[4]|| opcion2[8]==opcion2[5]|| opcion2[8]==opcion2[6]|| opcion2[8]==opcion2[7]){
                                opcion2[8]=80; //salta condicion
                            }
                        }while(opcion2[8]>32);
                        
                        do{
                            opcion2[9]=(int)(Math.random()*32);
                            if(opcion2[9]==opcion2[0] || opcion2[9]==opcion2[1]|| opcion2[9]==opcion2[2]|| opcion2[9]==opcion2[3]|| opcion2[9]==opcion2[4]|| opcion2[9]==opcion2[5]|| opcion2[9]==opcion2[6]|| opcion2[9]==opcion2[7]|| opcion2[9]==opcion2[8]){
                                opcion2[9]=80; //salta condicion
                            }
                        }while(opcion2[9]>32);
                        
                        do{
                            opcion2[10]=(int)(Math.random()*32);
                            if(opcion2[10]==opcion2[0] || opcion2[10]==opcion2[1]|| opcion2[10]==opcion2[2]|| opcion2[10]==opcion2[3]|| opcion2[10]==opcion2[4]|| opcion2[10]==opcion2[5]|| opcion2[10]==opcion2[6]|| opcion2[10]==opcion2[7]|| opcion2[10]==opcion2[8]|| opcion2[10]==opcion2[9]){
                                opcion2[10]=80; //salta condicion
                            }
                        }while(opcion2[10]>32);
                        
                        do{
                            opcion2[11]=(int)(Math.random()*32);
                            if(opcion2[11]==opcion2[0] || opcion2[11]==opcion2[1]|| opcion2[11]==opcion2[2]|| opcion2[11]==opcion2[3]|| opcion2[11]==opcion2[4]|| opcion2[11]==opcion2[5]|| opcion2[11]==opcion2[6]|| opcion2[11]==opcion2[7]|| opcion2[11]==opcion2[8]|| opcion2[11]==opcion2[9]|| opcion2[11]==opcion2[10]){
                                opcion2[11]=80; //salta condicion
                            }
                        }while(opcion2[11]>32);
                        
                        do{
                            opcion2[12]=(int)(Math.random()*32);
                            if(opcion2[12]==opcion2[0] || opcion2[12]==opcion2[1]|| opcion2[12]==opcion2[2]|| opcion2[12]==opcion2[3]|| opcion2[12]==opcion2[4]|| opcion2[12]==opcion2[5]|| opcion2[12]==opcion2[6]|| opcion2[12]==opcion2[7]|| opcion2[12]==opcion2[8]|| opcion2[12]==opcion2[9]|| opcion2[12]==opcion2[10]|| opcion2[12]==opcion2[11]){
                                opcion2[13]=80; //salta condicion
                            }
                        }while(opcion2[12]>32);
                        
                        do{
                            opcion2[13]=(int)(Math.random()*32);
                            if(opcion2[13]==opcion2[0] || opcion2[13]==opcion2[1]|| opcion2[13]==opcion2[2]|| opcion2[13]==opcion2[3]|| opcion2[13]==opcion2[4]|| opcion2[13]==opcion2[5]|| opcion2[13]==opcion2[6]|| opcion2[13]==opcion2[7]|| opcion2[13]==opcion2[8]|| opcion2[13]==opcion2[9]|| opcion2[13]==opcion2[10]|| opcion2[13]==opcion2[11]|| opcion2[13]==opcion2[12]){
                                opcion2[13]=80; //salta condicion
                            }
                        }while(opcion2[13]>32);
                        
                        do{
                            opcion2[14]=(int)(Math.random()*32);
                            if(opcion2[14]==opcion2[0] || opcion2[14]==opcion2[1]|| opcion2[14]==opcion2[2]|| opcion2[14]==opcion2[3]|| opcion2[14]==opcion2[4]|| opcion2[14]==opcion2[5]|| opcion2[14]==opcion2[6]|| opcion2[14]==opcion2[7]|| opcion2[14]==opcion2[8]|| opcion2[14]==opcion2[9]|| opcion2[14]==opcion2[10]|| opcion2[14]==opcion2[11]|| opcion2[14]==opcion2[12]|| opcion2[14]==opcion2[13]){
                                opcion2[14]=80; //salta condicion
                            }
                        }while(opcion2[14]>32);
                        
                        do{
                            opcion2[15]=(int)(Math.random()*32);
                            if(opcion2[15]==opcion2[0] || opcion2[15]==opcion2[1]|| opcion2[15]==opcion2[2]|| opcion2[15]==opcion2[3]|| opcion2[15]==opcion2[4]|| opcion2[15]==opcion2[5]|| opcion2[15]==opcion2[6]|| opcion2[15]==opcion2[7]|| opcion2[15]==opcion2[8]|| opcion2[15]==opcion2[9]|| opcion2[15]==opcion2[10]|| opcion2[15]==opcion2[11]|| opcion2[15]==opcion2[12]|| opcion2[15]==opcion2[13]|| opcion2[15]==opcion2[14]){
                                opcion2[15]=80; //salta condicion
                            }
                        }while(opcion2[15]>32);
                        
                       
                        
                        
                        Equipo[] clasificados=new Equipo [16];
                        for(int i=0;i<16;i++){
                            clasificados[i]=equipos.getEquipos(opcion2[i]);
                        }
                        Equipo ganador;
                        ganador=SegundaFase.simular(clasificados);
                        System.out.println("\nEl ganador de la segunda Fase es "+ganador.getNombre().trim());
                        
                        
                        break;
                    }
                        
                    }
                }while(opcion1==0);
    }
    
    public static void mundial1() throws SQLException{
        Scanner in = new Scanner ( System.in ); 
        ListaEquipos equipos = new ListaEquipos();
        equipos.ListaEquipos();
        Grupo A= new Grupo("A", equipos.getEquipos(6),  equipos.getEquipos(13),  equipos.getEquipos(25),  equipos.getEquipos(7));
                Grupo B= new Grupo("B", equipos.getEquipos(15),  equipos.getEquipos(27), equipos.getEquipos(8),  equipos.getEquipos(3));
                Grupo C= new Grupo("C", equipos.getEquipos(9), equipos.getEquipos(19), equipos.getEquipos(11), equipos.getEquipos(24));
                Grupo D= new Grupo("D", equipos.getEquipos(31), equipos.getEquipos(12), equipos.getEquipos(21), equipos.getEquipos(23));
                Grupo E= new Grupo("E", equipos.getEquipos(30),  equipos.getEquipos(14),  equipos.getEquipos(17),  equipos.getEquipos(20));
                Grupo F= new Grupo("F", equipos.getEquipos(2), equipos.getEquipos(5), equipos.getEquipos(22), equipos.getEquipos(26));
                Grupo G= new Grupo("G", equipos.getEquipos(0), equipos.getEquipos(28), equipos.getEquipos(18), equipos.getEquipos(16));
                Grupo H= new Grupo("H", equipos.getEquipos(4), equipos.getEquipos(1), equipos.getEquipos(29), equipos.getEquipos(10));
       
                FaseGrupos fase = new FaseGrupos(A,B,C,D,E,F,G,H);
                Equipo[] winners=SimularFaseGrupos.simular(fase);
        
        
                for(int i=0;i<8;i++)
                    System.out.println("Ganadores grupo:"+fase.getGrupos(i).getLetra()+" "+fase.getGrupos(i).getGanadores()[0].getNombre().trim()+"="+fase.getGrupos(i).getGanadores()[0].getPuntos()+", "+fase.getGrupos(i).getGanadores()[1].getNombre().trim()+"= "+fase.getGrupos(i).getGanadores()[1].getPuntos());
        

        
                System.out.println("\n=================================\n");
 
                Equipo Ganadorsh =SegundaFase.simular(winners);
        
                System.out.println("El Equipo ganador del Mundial es: " + Ganadorsh.getNombre().trim() );
    }
    
    public static void menu() throws SQLException{
        Scanner in = new Scanner ( System.in ); 
        ListaEquipos equipos = new ListaEquipos();
        equipos.ListaEquipos();
    //////Entrada principal    
        int opcion;
        do{
        System.out.println("====Menu====");
        System.out.println("\n¿Que desea Hacer?");
        System.out.println("1. Simular un partido");
        System.out.println("2. Simular fase de grupos");
        System.out.println("3. Simular segunda fase");
        System.out.println("4. Simular mundial Brazil 2014");
        System.out.println("5. Salir");
        opcion=in.nextInt();
              
        switch(opcion){
            case 1:{
                MenuFinal.partido1();
                break;
            }    

            case 2:{
                MenuFinal.faseGrupo1();
               break; 
            }

            case 3:{
                MenuFinal.segundaFase1();
                break;
            }
            case 4:{
                MenuFinal.mundial1();
                break;
            }
        
        }
       }while(opcion!=5);
    
    }
}
