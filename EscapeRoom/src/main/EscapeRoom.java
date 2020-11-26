package main;

import java.util.Scanner;
import comprobaciones.Comprobaciones;
import inventario.Inventario;
import mensajes.Mensajes;

public class EscapeRoom {
    
    public static void main(String[] args) {
                
        Scanner teclado = new Scanner(System.in);
        
        Comprobaciones comp = new Comprobaciones();
        Mensajes mensaje = new Mensajes();
        Inventario inven = new Inventario();
        
        //Declaracion de variables
        boolean respuestaSiNo, dificil, acabarInspeccion, ganado, salirJuego;
        int sala, eleccion, vida, movimientos;
        
        int[] inventario;
        
        boolean[] objetosObtenidos = new boolean[15]; //Todos los objetos con la informacion de si han sido cogidos, para que no vuelvan a aparecer en la habitacion
        
        boolean[] nuevaSala = new boolean [7];//Indica si salas visitadas
        
        String[] nombreObjetos = new String[]{  "Unos restos de cables rotos", //No esta  10:Medicinas 11:Vacunas 12:Curas
                                                "Una llave doblada con una M",
                                                "Una clave de acceso medio quemada",
                                                "Un trozo de pan galactico que no se pudre en 5 años",
                                                "Una sarte de cobalto niquelado, vieja pero indestructible",
                                                "Cuchillos de madera",
                                                "Comida enlatada",
                                                "Instrucciones de un jet antiguo",
                                                "Casco",
                                                "Boligrafo",
                                                "Papel",
                                                "Arma",
                                                "Codigo enfermera",
                                                "Medicina coagulante",
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
        
        mensaje.Bienvenida();
        
        //do-while del escape room completo
        do{
            //Inicializacion de variables
            sala=0; eleccion=0;
            acabarInspeccion=false; ganado=false; salirJuego=false;
            
            for(boolean i:objetosObtenidos){
                i=false;
            }
            
            for(boolean i:nuevaSala){
                i=true;
            }
            
            dificil=comp.dificultad(teclado);
            if (dificil){
                vida = 3; movimientos = 80;  //movimiento = un minuto
                inventario = new int[4];
            }else{
                vida = 5; movimientos = 100;  //movimiento = un minuto
                inventario = new int[7];
            }
            
            for(int i:inventario){
                i=-1;
            }
            
            mensaje.Inicio();
            mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
            
            //repeticion salas-Menu principal salas
            do{
                
                eleccion=0;
                acabarInspeccion=false;
                
                mensaje.Sala(sala,nuevaSala[sala], objetosObtenidos);
                nuevaSala[sala]=false;
                mensaje.Menu(sala);//Mensajes del menu en funcion de la sala en la que estes
                
                eleccion=comp.eleccionMenuPrincipal(sala, teclado);//Valora si la eleccion es valida y la almacena
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
                            
                            case 3: mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
                            break;
                            
                            case 4: sala=6;
                            break;
                            
                            case 5: mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
                            break;
                            
                            case 6: mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
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
                                mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
                            break;
                            
                            case 1: mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
                            break;
                            
                            case 2: mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
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
                            
                            case 0: mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
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
                            
                            case 4: mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
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
                        
                    default: System.out.println("Algo ha salido mal");
                }
                movimientos--;
                
                if(eleccion==1){//Si eleccion del menu es 1 (podria ir en el switch case 1:)
                    
                    //Repeticion menu interno (de la sala) hasta que no "salga" de esta
                    do{
                        //Devolvemos las variables al estado neutro
                        eleccion=0;
                        acabarInspeccion=false;//No necesario pero nos asegurames de que esté en falso hasta que se desee salir
                        
                        mensaje.MenuInteraccion(sala, objetosObtenidos, nombreObjetos);//Mensaje de los menus internos de cada sala

                        eleccion=comp.eleccionMenuInteraccion(sala, teclado);
                    
                        switch (sala){
                            
                            case 0:
                                
                                switch (eleccion){
                                    
                                    case 1: 
                                        
                                        if(!objetosObtenidos[0]){
                                            System.out.println("Parecen unos cables que han sido arrancados de un procesador.");
                                            System.out.println("Parece que funcionan... puede que te sirvan de algo en un futuro.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if(comp.validacionSiNo(teclado)){
                                                System.out.println("Guardando en el inventario...");
                                                inventario=inven.insertarObjeto(0, inventario, teclado, nombreObjetos);
                                            }else{
                                                System.out.println("Estaba claro. ¿Para que iba a querer unos cables rotos?");
                                            }
                                        }else{
                                            System.out.println("Ya tienes el objeto.");
                                        }
                                        
                                    break;
                                    
                                    case 2:
                                        
                                        if(!objetosObtenidos[1]){
                                            System.out.println("Está un poco doblada pero creo que la podría arreglar sin gran dificultad.");
                                            System.out.println("Puedo probar a encajarla en alguna cerradura o buscar alguna M.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if(comp.validacionSiNo(teclado)){
                                                System.out.println("Guardando en el inventario...");
                                                inventario=inven.insertarObjeto(1, inventario, teclado, nombreObjetos);
                                            }else{
                                                System.out.println("Da igual, estoy demasiado cansado para arreglar esta maldita llave.");
                                            }
                                        }else{
                                            System.out.println("Ya tienes el objeto.");
                                        }
                                        
                                    break;
                                    
                                    case 3:
                                        
                                        if(!objetosObtenidos[2]){
                                            System.out.println("Me suena mucha esta clave, pero ahora mismo no logro recordar nada.");
                                            System.out.println("Hay una parte quemada y no se consigue ver toda la clave, podría recordarla más adelante.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if(comp.validacionSiNo(teclado)){
                                                System.out.println("Guardando en el inventario...");
                                                inventario=inven.insertarObjeto(2, inventario, teclado, nombreObjetos);
                                            }else{
                                                System.out.println("Ojalá fuera yo esa clave y me hubiera calcinado medio cuerpo en el accidente...");
                                            }
                                        }else{
                                            System.out.println("Ya tienes el objeto.");
                                        }
                                        
                                    break;
                                    
                                    case 4:
                                        acabarInspeccion=true;
                                    break;
                                    
                                    case 5:
                                        mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
                                        movimientos++;
                                    break;
                                    
                                    case 6:
                                        salirJuego=true;
                                    break;
                                    
                                    default: System.out.println("Algo ha salido mal");
                                    
                                }
                                
                            break;
                            
                            case 1:
                                
                                switch (eleccion){
                                    
                                    case 1: 
                                        
                                        if(!objetosObtenidos[3]){
                                            System.out.println("No parece especialmente apetecible, pero tampoc crees que esté malo.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if(comp.validacionSiNo(teclado)){
                                                System.out.println("Guardando en el inventario...");
                                                inventario=inven.insertarObjeto(3, inventario, teclado, nombreObjetos);
                                            }else{
                                                System.out.println("Si no se ha puesto malo puede quedarse aqui unos cuantos años más.");
                                            }
                                        }else{
                                            System.out.println("Ya tienes el objeto.");
                                        }
                                        
                                    break;
                                    
                                    case 2:
                                        
                                        if(!objetosObtenidos[4]){
                                            System.out.println("Desde luego esta sarten tiene más años que el mismo universo.");
                                            System.out.println("No creo que vaya a cocinar nada pero podría usarla de protección... o algo");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if(comp.validacionSiNo(teclado)){
                                                System.out.println("Guardando en el inventario...");
                                                inventario=inven.insertarObjeto(1, inventario, teclado, nombreObjetos);
                                            }else{
                                                System.out.println("Dejemosla aquí, que siga viendo el paso del tiempo.");
                                            }
                                        }else{
                                            System.out.println("Ya tienes el objeto.");
                                        }
                                        
                                    break;
                                    
                                    case 3:
                                        
                                        if(!objetosObtenidos[5]){
                                            System.out.println("Espera... ¿De madera? ¿No teniamos dinero para unos buenos cuchillos de titanio?");
                                            System.out.println("Bueno, al menos no está astillado. Si era capaz de cortar la carne tan dura de la cantina");
                                            System.out.println("podrá con cualquier cosa...");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if(comp.validacionSiNo(teclado)){
                                                System.out.println("Guardando en el inventario...");
                                                inventario=inven.insertarObjeto(5, inventario, teclado, nombreObjetos);
                                            }else{
                                                System.out.println("¿Pero desde cuando los cuchillos son de madera?");
                                            }
                                        }else{
                                            System.out.println("Ya tienes el objeto.");
                                        }
                                        
                                    break;
                                    
                                    case 4:
                                        acabarInspeccion=true;
                                    break;
                                    
                                    case 5:
                                        mensaje.Estado(vida, movimientos, inventario, nombreObjetos);
                                        movimientos++;
                                    break;
                                    
                                    case 6:
                                        salirJuego=true;
                                    break;
                                    
                                    default: System.out.println("Algo ha salido mal");
                                    
                                }
                                
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
                        
                        movimientos--;
                        
                    }while(!acabarInspeccion && vida>0 && movimientos>0 && !ganado && !salirJuego);//declarar otra variable en caso de estar en el switch del menu (case 1:)
                }
                
                
            }while(vida>0 && movimientos>0 && !ganado && !salirJuego);
        
            
            
            System.out.println("Desea volver a intentarlo?");
            respuestaSiNo = comp.validacionSiNo(teclado);
            
        }while(respuestaSiNo);
        
        mensaje.Salida();
        
        
        teclado.close();
        
    }
    
}
