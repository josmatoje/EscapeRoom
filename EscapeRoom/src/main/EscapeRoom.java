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
        boolean respuestaSiNo, dificil, acabarInspeccion, ganado, salirJuego, visitaLucia;
        int sala, eleccion, vida, escudo, municion, movimientos;
        
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
            sala=0; eleccion=0; escudo=0; municion=0;
            acabarInspeccion=false; ganado=false; salirJuego=false; visitaLucia=false;
            
            for(boolean i:objetosObtenidos){
                i=false;
            }
            
            for(boolean i:nuevaSala){
                i=true;
            }
            
            dificil=comp.dificultad(teclado);
            if (dificil){
                vida = 3; movimientos = 80;
                inventario = new int[4];
            }else{
                vida = 4; movimientos = 100;
                escudo=1;
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
                nuevaSala[sala]=false;//Si no se habia visitado aun se actualiza a 
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
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 4: sala=0;
                            break;
                            
                            case 5:
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 6:
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
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
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 2: 
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
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
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 1: 
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego=comp.validacionSiNo(teclado);
                            break;
                            
                            case 2: System.out.println("Algo ha salido mal");
                            break;
                            
                            case 3: System.out.println("Algo ha salido mal");
                            break;
                            
                            case 4: 
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
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
                        
                        mensaje.MenuInteraccion(sala, objetosObtenidos, nombreObjetos, inventario);//Mensaje de los menus internos de cada sala

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
                                                inventario=inven.insertarObjeto(0, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if(inven.comprobarInventario(0, inventario))
                                                        objetosObtenidos[0]=true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
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
                                                inventario=inven.insertarObjeto(1, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if(inven.comprobarInventario(1, inventario))
                                                        objetosObtenidos[1]=true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
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
                                                inventario=inven.insertarObjeto(2, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if(inven.comprobarInventario(2, inventario))
                                                        objetosObtenidos[2]=true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
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
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                        System.out.println("Tu progreso se perderá por completo");
                                        if(comp.validacionSiNo(teclado)){
                                            salirJuego=true;
                                        }
                                    break;
                                    
                                    default: System.out.println("Algo ha salido mal");
                                    
                                }
                                
                            break;
                            
                            case 1:
                                
                                switch (eleccion){
                                    
                                    case 1: 
                                        
                                        if(!objetosObtenidos[3]){
                                            System.out.println("No parece especialmente apetecible, pero tampoc crees que esté malo.");
                                            System.out.println("¿Quieres comertelo? (usar)");
                                            if(comp.validacionSiNo(teclado)){
                                                objetosObtenidos[3]=true;
                                                vida++;
                                                escudo++;
                                                System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                                System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                            }else{
                                                System.out.println("¿Deseas guardarlo en tu inventario?");
                                                if(comp.validacionSiNo(teclado)){
                                                    System.out.println("Guardando en el inventario...");
                                                    inventario=inven.insertarObjeto(3, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                    //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                    if(inven.comprobarInventario(3, inventario))
                                                        objetosObtenidos[3]=true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }else{
                                                    System.out.println("Si no se ha puesto malo puede quedarse aqui unos cuantos años más.");
                                                }
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
                                                inventario=inven.insertarObjeto(4, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if(inven.comprobarInventario(4, inventario)){
                                                        objetosObtenidos[4]=true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                        System.out.println("Te sientes más pesado, pero tambien más protegido.");
                                                        System.out.println("Ganas un escudo (+1)");
                                                        escudo++;
                                                    }
                                                
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
                                                inventario=inven.insertarObjeto(5, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if(inven.comprobarInventario(5, inventario))
                                                        objetosObtenidos[5]=true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
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
                                        System.out.println("¿Estás seguro de que deseas salir?");
                                        System.out.println("Tu progreso se perderá por completo");
                                        salirJuego=comp.validacionSiNo(teclado);
                                    break;
                                    
                                    default: System.out.println("Algo ha salido mal");
                                    
                                }
                                
                            break;
                            
                            case 2:
                                
                                switch (eleccion){
                                    
                                    case 1: 
                                        
                                        System.out.println("A pesar de lo enclenque que parece esta silla podría aguantar hasta ");
                                        System.out.println("diez veces tu peso, pero sin duda no llegarás muy lejos con ella.");
                                        System.out.println("");
                                        System.out.println("Se te ocurre que puedes moverla a algunos lugares...");
                                        
                                        do{
                                            System.out.println("Mover silla a:");
                                            System.out.println("1. Puerta con ventana");
                                            System.out.println("2. Mesa central");
                                            System.out.println("3. Altillo");
                                            System.out.println("4. Dejar silla");
                                            
                                            //Asignamos valor introducido por teclado y validamos para la seleccion de mover silla
                                            eleccion=comp.valorEntre1y4(teclado.nextInt(), teclado);//GUAU como funke esta vaina
                                            
                                            switch(eleccion){
                                                
                                                case 1:
                                                    System.out.println("Te acercas a la puerta y ves que la enfermera yace muerta en el interior.");
                                                    if(visitaLucia){
                                                        System.out.println("vete olvidando de poder abrir esa caja del dormitorio con la llave...");
                                                        System.out.println("alcanzas a ver como reluce en su cuello.");
                                                    }
                                                break;
                                                
                                                case 2:
                                                    System.out.println("¿Quieres subir a la mesa?");
                                                    if(comp.validacionSiNo(teclado)){
                                                        System.out.println("Te crees el rey de la nave y empiezas a bailar, nadie puede pararte, eres tú");
                                                        System.out.println("y la música que no para de sonar en tu cabeza. Ves que el mundo se paraliza a tu");
                                                        System.out.println("alrededor mientras tu no dejas de bailar. La mesa es tuya y nadie puede bajarte de ahi");
                                                        System.out.println(".");
                                                        System.out.println(".");
                                                        System.out.println(".");
                                                        System.out.println("Después de perder 10 movimientos te replanteas tus metas y aspiraciones y continuas");
                                                        System.out.println("buscando la forma de salvar tu vida (-10 movimientos)");
                                                        movimientos-=10;
                                                    }
                                                break;
                                                
                                                case 3://Bug intencionado, si repites esta accion puedes conseguir más munición
                                                    System.out.println("¿Quieres subir al altillo?");
                                                    if(comp.validacionSiNo(teclado)){
                                                        System.out.print("Ves una caja de munición");
                                                        if(objetosObtenidos[11])
                                                            System.out.print(" que parece que le vale a tu arma.");
                                                        System.out.println("");
                                                        System.out.println("Que lastima solo queda una bala... (+1 municion)");
                                                        municion++;
                                                        if(municion>5)
                                                            System.out.println("Efectivamente, has encontrado un bug. Puedes aprovecharlo si crees que será util, pero te recuerdo que estás perdiendo turnos............................................................................... xD");
                                                    }
                                                break;
                                               
                                                case 4:
                                                    System.out.println("Dejas la silla exactamente donde estaba porque recuerdas que al jefe no le gustaba que le");
                                                    System.out.println("su silla... cierto, no crees que te vaya a ver pero quien sabe.");
                                                break;
                                                
                                                default: System.out.println("Algo ha salido mal");
                                                
                                            }
                                            //Se resta movimientos cada vez que se haga algo con la silla
                                            movimientos--;
                                            
                                        }while(eleccion!=4 && movimientos>0 && vida>0);
                                        
                                    break;
                                    
                                    case 2:
                                        
                                        if(!objetosObtenidos[6]){
                                            System.out.println("Es una de tus comidas favoritas, que lastima que no puedas abrirla para comertela...");
                                            if(objetosObtenidos[5]){//si ha visto el cuchillo
                                                System.out.println("¡¡¡EEEEEEHH!!! Ese cuchillo de madera podría abrirla");
                                                for(int i=1; i<inventario.length; i++){
                                                    if(inventario[i]==5){//si tiene el cuchillo
                                                        System.out.println("¿Quieres usar el cuchillo para comerte la lata? (probabilidad baja de romper cuchillo)");
                                                        if(comp.validacionSiNo(teclado)){
                                                            objetosObtenidos[6]=true;
                                                            vida++;
                                                            movimientos+=5;
                                                            System.out.println("La comida de tus sueños no es especialmente nutritiva pero te da la sensacion de ser");
                                                            System.out.println("mucho más agil");
                                                            System.out.println("Ganas uno de vida (+1) y cinco movimientos (+5)");
                                                        }
                                                    }
                                                }
                                            }
                                            //Si no se ha comido el objeto
                                            if(!objetosObtenidos[6]){
                                                System.out.println("¿Deseas guardarlo en tu inventario?");
                                                if(comp.validacionSiNo(teclado)){
                                                    System.out.println("Guardando en el inventario...");
                                                    inventario=inven.insertarObjeto(3, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                    //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                    if(inven.comprobarInventario(6, inventario))
                                                        objetosObtenidos[6]=true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }else{
                                                    System.out.println("Con todo el dolor de mi corazón te dejo aquí. Pero cuando me recupere volveré a por ti.");
                                                }
                                            }
                                        }else{
                                            System.out.println("Ya tienes el objeto.");
                                        }
                                        
                                    break;
                                    
                                    case 3:
                                        
                                        if(!objetosObtenidos[7]){
                                            System.out.println("Ves un esquema de la zona de motores de lo que sin duda es tu nave.");
                                            System.out.println(" Hay marcado una señal con una X… Eso suele significar algo.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if(comp.validacionSiNo(teclado)){
                                                System.out.println("Guardando en el inventario...");
                                                inventario=inven.insertarObjeto(7, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if(inven.comprobarInventario(7, inventario))
                                                        objetosObtenidos[7]=true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                            }else{
                                                System.out.println("Esto no es una pelicula de piratas, no tengo tiempo de buscar tesoros.7");
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
                                        System.out.println("¿Estás seguro de que deseas salir?");
                                        System.out.println("Tu progreso se perderá por completo");
                                        salirJuego=comp.validacionSiNo(teclado);
                                    break;
                                    
                                    default: System.out.println("Algo ha salido mal");
                                    
                                }
                                
                            break;
                            
                            case 3:
                                System.out.println("¡HAS GANADO!");
                                ganado=true;
                                /*
                                    Desarrollar
                                */
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
