package main;

import comprobaciones.*;
import java.util.Scanner;
import mensajes.*;

public class EscapeRoom {
    
    public static void main(String[] args) {
        
        //Declaracion de variables
        boolean respuestaSiNo, dificil, ganado, salirJuego;
        int sala, eleccion, vida, movimientos;
        
        int[] inventario;
        
        boolean[] objetosObtenidos = new boolean[16]; //Todos los objetos con la informacion de si han sido cogidos, para que no vuelvan a aparecer en la habitacion
        
        boolean[] nuevaSala = new boolean [7];//Indica si salas visitadas
        
        String[] nombreObjetos = new String[]{  "Llaves", //No esta  10:Medicinas 11:Vacunas 12:Curas
                                                "Cables",
                                                "Claves de acceso",
                                                "Comida",
                                                "Sarten",
                                                "Cuchillos",
                                                "Restos de comida",
                                                "Instrucciones de una nave",
                                                "Casco",
                                                "Boligrafo",
                                                "Papel",
                                                "Arma",
                                                "Codigo enfermera",
                                                "Medicina coagulante",
                                                "Combustible",
                                                "Sierra mecanica" };
        /*
        0:Llaves
        1:Cables
        2:Claves de acceso
        
        3:Comida
        4:Sarten
        5:Cuchillos
        
        --Silla (no objeto)
        6:Restos de comida
        7:Instrucciones de una nave
       
        8: Casco
        9: Boligrafo
        10: Papel
        
        11: Arma
        12: Codigo enfermera
        13: Medicina coagulante
        14: Combustible
        15: Sierra mecanica
       
        */
        
        Scanner teclado = new Scanner(System.in);
        
        Comprobaciones comp = new Comprobaciones();
        Mensajes mensaje = new Mensajes();
        
        mensaje.Bienvenida();
        
        //do-while del escape room completo
        do{
            //Inicializacion de variables
            sala=0; eleccion=0;
            ganado=false; salirJuego=false;
            
            dificil=comp.dificultad(teclado);
            if (dificil){
                vida = 3; movimientos = 80;  //movimiento = un minuto
                inventario = new int[4];
            }else{
                vida = 5; movimientos = 120;  //movimiento = un minuto
                inventario = new int[7];
            }
            
            for(int i:inventario){
                i=-1;
            }
            for(boolean i:objetosObtenidos){
                i=false;
            }
            for(boolean i:nuevaSala){
                i=false;
            }
            
            mensaje.Inicio();
            //Vida inicial y movimientos
            //System.out.println("Comienzas con ");
            mensaje.Estado(vida, movimientos);
            
            do{//repeticion salas-Menu principal salas
                
                mensaje.Sala(sala,nuevaSala[sala], objetosObtenidos);
                mensaje.Menu(sala);//Mensajes del menu en funcion de la sala en la que estes
                
                eleccion=comp.eleccionMenuPrincipal(sala);//Valora si la eleccion es valida y la almacena
                //switch de acciones segun la eleccion tomada en la sala en la que se encuentre
                switch (eleccion){
                    
                    case 1:
                        System.out.println("Investigando sala...");
                    break;
                    
                    case 2:
                        switch (sala){
                            
                            case 0: sala=1;
                            break;
                            
                            case 1: sala=2;
                            break;
                            
                            case 2: sala=3;
                            break;
                            
                            case 3: sala=2;
                            break;
                            
                            case 4: sala=5;
                            break;
                            
                            case 5: sala=4;
                            break;
                            
                            case 6: sala=4;
                            break;
                            
                            default: System.out.println("Algo ha salido mal");
                        }
                    break;
                    
                    case 3:
                        switch (sala){
                            
                            case 0: sala=4;
                            break;
                            
                            case 1: sala=0;
                            break;
                            
                            case 2: sala=1;
                            break;
                            
                            case 3: mensaje.Estado(vida, movimientos);
                            break;
                            
                            case 4: sala=6;
                            break;
                            
                            case 5: mensaje.Estado(vida, movimientos);
                            break;
                            
                            case 6: mensaje.Estado(vida, movimientos);
                            break;
                            
                            default: System.out.println("Algo ha salido mal");
                        }
                    break;
                    
                    case 4:
                        switch (sala){
                            
                            case 0: 
                                System.out.println("Te das un golpe muy fuerte que te despierta de la contusión y ");
                                System.out.println("te das cuenta de no era una puerta si no una simple alucinación");
                                System.out.println("");
                                System.out.println("PIERDES UNO DE VIDA");
                                vida--;
                            break;
                            
                            case 1: mensaje.Estado(vida, movimientos);
                            break;
                            
                            case 2: mensaje.Estado(vida, movimientos);
                            break;
                            
                            case 3: 
                                System.out.println("¿Estás seguro de que deseas salir?");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 4: sala=0;
                            break;
                            
                            case 5:
                                System.out.println("¿Estás seguro de que deseas salir?");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 6:
                                System.out.println("¿Estás seguro de que deseas salir?");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            default: System.out.println("Algo ha salido mal");
                        }
                    break;
                    
                    case 5:
                        switch (sala){
                            
                            case 0: mensaje.Estado(vida, movimientos);
                            break;
                            
                            case 1: 
                                System.out.println("¿Estás seguro de que deseas salir?");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 2: 
                                System.out.println("¿Estás seguro de que deseas salir?");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 3: System.out.println("Algo ha salido mal");
                            break;
                            
                            case 4: mensaje.Estado(vida, movimientos);
                            break;
                            
                            case 5: System.out.println("Algo ha salido mal");
                            break;
                            
                            case 6: System.out.println("Algo ha salido mal");
                            break;
                            
                            default: System.out.println("Algo ha salido mal");
                        }
                    break;
                    
                    case 6:
                        switch (sala){
                            
                            case 0: 
                                System.out.println("¿Estás seguro de que deseas salir?");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 1: 
                                System.out.println("¿Estás seguro de que deseas salir?");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 2: System.out.println("Algo ha salido mal");
                            break;
                            
                            case 3: System.out.println("Algo ha salido mal");
                            break;
                            
                            case 4: 
                                System.out.println("¿Estás seguro de que deseas salir?");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 5:System.out.println("Algo ha salido mal");
                            break;
                            
                            case 6:System.out.println("Algo ha salido mal");
                            break;
                            
                            default: System.out.println("Algo ha salido mal");
                        }                        
                    break;
                        
                    default:
                }
                movimientos--;
                
                if(eleccion==1){//Si eleccion del menu es 1 (podria ir en el switch case 1:)
                    
                    mensaje.MenuInteraccion(sala, objetosObtenidos);//Mensaje de los menus internos de cada sala
                    
                    eleccion=comp.eleccionMenuInteraccion(sala);
                    
                    //Repeticion menu interno (de la sala) hasta que no "salga" de esta
                    do{
                        
                        switch (eleccion){
                            
                            case 0:
                                
                            break;
                            
                            case 1:
                                
                            break;
                            
                            case 2:
                                
                            break;
                            
                            case 3:
                                
                            break;
                            
                            case 4:
                                
                            break;
                            
                            case 5:
                                
                            break;
                            
                            case 6:
                                
                            break;
                            
                            default: System.out.println("Algo ha salido mal");
                        }
                        
                    }while(eleccion!=1);//declarar otra variable en caso de estar en el switch del menu (case 1:)
                }
                
                
            }while(vida>0 && movimientos>0 && !ganado && !salirJuego);
        
            
            
            System.out.println("Desea volver a intentarlo?");
            respuestaSiNo = comp.validacionSiNo(teclado);
            
        }while(respuestaSiNo);
        
        mensaje.Salida();
        
        
        teclado.close();
        
    }
    
}
