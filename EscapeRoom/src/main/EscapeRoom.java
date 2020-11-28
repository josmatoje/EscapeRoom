package main;

import java.util.Scanner;
import comprobaciones.Comprobaciones;
import inventario.Inventario;
import mensajes.Mensajes;
import juegos.Juego;

public class EscapeRoom {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Comprobaciones comp = new Comprobaciones();
        Mensajes mensaje = new Mensajes();
        Inventario inven = new Inventario();
        Juego juego = new Juego();

        //Declaracion de variables
        boolean respuestaSiNo, dificil, acabarInspeccion, ganado, salirJuego, visitaLucia, candadoRoto, revistaX, llaveRecta;
        int sala, eleccionMenu, eleccion, vida, escudo, municion, movimientos;
        String clave, claveEnfermeria;

        int[] inventario;

        boolean[] objetosObtenidos = new boolean[15]; //Todos los objetos con la informacion de si han sido cogidos, para que no vuelvan a aparecer en la habitacion

        boolean[] nuevaSala = new boolean[7];//Indica si salas visitadas

        String[] nombreObjetos = new String[]{"Unos restos de cables rotos", //No esta  10:Medicinas 11:Vacunas 12:Curas
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
            "Sierra mecanica"};

        mensaje.Bienvenida();

        //do-while del escape room completo
        do {
            //Inicializacion de variables
            sala = 0;
            eleccionMenu = 0;
            eleccion = 0;
            escudo = 0;
            municion = 0;
            acabarInspeccion = false;
            ganado = false;
            salirJuego = false;
            visitaLucia = false;
            candadoRoto = false;
            revistaX = false;
            clave = "     ";
            claveEnfermeria = "g34rd9j4r439r34fi44z";//Podemos hacer un subprograma que genere claves
            nombreObjetos[10] = "Papel";

            for (boolean i : objetosObtenidos) {
                i = false;
            }

            for (boolean i : nuevaSala) {
                i = true;
            }

            dificil = comp.dificultad(teclado);
            if (dificil) {
                vida = 3;
                movimientos = 80;
                inventario = new int[5];
            } else {
                vida = 4;
                movimientos = 100;
                escudo = 1;
                inventario = new int[7];
            }

            for (int i : inventario) {
                i = -1;
            }

            mensaje.Inicio();
            mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);

            //repeticion salas-Menu principal salas
            do {
                clave = "     ";
                eleccionMenu = 0;
                acabarInspeccion = false;

                mensaje.Sala(sala, nuevaSala[sala], objetosObtenidos);
                nuevaSala[sala] = false;//Si no se habia visitado aun se actualiza a 
                mensaje.Menu(sala);//Mensajes del menu en funcion de la sala en la que estes

                eleccionMenu = comp.eleccionMenuPrincipal(sala, teclado);//Valora si la eleccion es valida y la almacena
                //switch de acciones segun la eleccion tomada en la sala en la que se encuentre
                switch (eleccionMenu) {

                    case 1:
                        System.out.println("Investigando sala...");
                        break;

                    case 2:
                        switch (sala) { //En cada sala habra diferentes funciones para el mismo numero

                            case 0:
                                sala = 1;
                                break;

                            case 1:
                                sala = 2;
                                break;

                            case 2:
                                sala = 3;
                                break;

                            case 3:
                                sala = 2;
                                break;

                            case 4:
                                sala = 5;
                                break;

                            case 5:
                                sala = 4;
                                break;

                            case 6:
                                sala = 4;
                                break;

                            default:
                                System.out.println("Algo ha salido mal");
                        }
                        break;

                    case 3:
                        switch (sala) {

                            case 0:
                                sala = 4;
                                break;

                            case 1:
                                sala = 0;
                                break;

                            case 2:
                                sala = 1;
                                break;

                            case 3: //NO seria el case 5?

                                eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                if (eleccion != -1) {

                                    switch (inventario[eleccion]) {

                                        case 3:
                                            vida++;
                                            escudo++;
                                            System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                            System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                            inventario[eleccion] = -1;
                                            break;

                                        case 6:
                                            if (inven.usarLata(inventario, teclado)) {
                                                vida++;
                                                movimientos += 5;
                                                inventario[eleccion] = -1;
                                                /*if(Math.random()<0.2){
                                                    //buscar cuchillo y romper
                                                }*/
                                            }
                                            break;

                                        case 10:
                                            nombreObjetos[10] = inven.usarPapel(teclado);
                                            break;

                                        case 13:
                                            movimientos += 10;
                                            System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                            System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                            System.out.println("Ganas diez movimientos (+10)");
                                            inventario[eleccion] = -1;
                                            break;

                                    }
                                }

                                break;

                            case 4:
                                if (nuevaSala[sala]) {//SI nunca has entrado tienes que hacer el juego

                                    System.out.println("Vaya, la puerta se encuentra cerrada, pero tiene una m Gigante pintada. Te acuerdas que todas las puertas importantes con letras");
                                    System.out.println("se abrian con su respectiva llave y con la misma letra.");
                                    if (inven.comprobarInventario(1, inventario)) { // Si tienes la llave doblada

                                        System.out.println("Menos mal que tenias una llave guardada, aunque no estuviera muy bien, se puede arreglar dandole golpes");
                                        System.out.println("Quieres intentar ponerla bien? Te va a cansar, pero la recompensa es incierta");
                                        if (comp.validacionSiNo(teclado)) {

                                            do {

                                                llaveRecta = juego.Llave(teclado);
                                                if (llaveRecta) {

                                                    System.out.println("De los mejores momentos de tu vida, te has sentido un verdadero troglodita de la prehistoria descubriendo las herramientas");
                                                    sala = 6;
                                                } else {
                                                    System.out.println("No lo has conseguido y has perdido tres movimientos,deseas volver a repetirlo?");
  
                                                }

                                            } while (!llaveRecta && comp.validacionSiNo(teclado));



                                        }

                                    } else {
                                        System.out.println(" Una pena que no tengas una parecida, no puedes abrirla");
                                    }

                                } else {

                                    sala = 6;

                                }

                                break;

                            case 5:

                                eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                if (eleccion != -1) {

                                    switch (inventario[eleccion]) {

                                        case 3:
                                            vida++;
                                            escudo++;
                                            System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                            System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                            inventario[eleccion] = -1;
                                            break;

                                        case 6:
                                            if (inven.usarLata(inventario, teclado)) {
                                                vida++;
                                                movimientos += 5;
                                                inventario[eleccion] = -1;
                                                /*if(Math.random()<0.2){
                                                    //buscar cuchillo y romper
                                                }*/
                                            }
                                            break;

                                        case 10:
                                            nombreObjetos[10] = inven.usarPapel(teclado);
                                            break;

                                        case 13:
                                            movimientos += 10;
                                            System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                            System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                            System.out.println("Ganas diez movimientos (+10)");
                                            inventario[eleccion] = -1;
                                            break;

                                    }
                                }

                                break;

                            case 6:

                                eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                if (eleccion != -1) {

                                    switch (inventario[eleccion]) {

                                        case 3:
                                            vida++;
                                            escudo++;
                                            System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                            System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                            inventario[eleccion] = -1;
                                            break;

                                        case 6:
                                            if (inven.usarLata(inventario, teclado)) {
                                                vida++;
                                                movimientos += 5;
                                                inventario[eleccion] = -1;
                                                /*if(Math.random()<0.2){
                                                    //buscar cuchillo y romper
                                                }*/
                                            }
                                            break;

                                        case 10:
                                            nombreObjetos[10] = inven.usarPapel(teclado);
                                            break;

                                        case 13:
                                            movimientos += 10;
                                            System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                            System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                            System.out.println("Ganas diez movimientos (+10)");
                                            inventario[eleccion] = -1;
                                            break;

                                    }
                                }

                                break;

                            default:
                                System.out.println("Algo ha salido mal");
                        }
                        break;

                    case 4:
                        switch (sala) {

                            case 0:
                                System.out.println("Te das un golpe muy fuerte que te despierta de la contusión y ");
                                System.out.println("te das cuenta de no era una puerta si no una simple alucinación");
                                System.out.println("");
                                System.out.println("Pierdes uno de vida (-1)");
                                vida--;
                                break;

                            case 1:

                                eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                if (eleccion != -1) {

                                    switch (inventario[eleccion]) {

                                        case 3:
                                            vida++;
                                            escudo++;
                                            System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                            System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                            inventario[eleccion] = -1;
                                            break;

                                        case 6:

                                            if (inven.usarLata(inventario, teclado)) {
                                                vida++;
                                                movimientos += 5;
                                                inventario[eleccion] = -1;
                                                //if(Math.random()<0.2){
                                                //buscar cuchillo y romper
                                                //}                                                 
                                            }

                                            break;

                                        case 10:
                                            nombreObjetos[10] = inven.usarPapel(teclado);
                                            break;

                                        case 13:

                                            movimientos += 10;
                                            System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                            System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                            System.out.println("Ganas diez movimientos (+10)");
                                            inventario[eleccion] = -1;

                                            break;
                                    }
                                }

                                break;

                            case 2:

                                eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                if (eleccion != -1) {

                                    switch (inventario[eleccion]) {

                                        case 3:
                                            vida++;
                                            escudo++;
                                            System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                            System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                            inventario[eleccion] = -1;
                                            break;

                                        case 6:

                                            if (inven.usarLata(inventario, teclado)) {
                                                vida++;
                                                movimientos += 5;
                                                inventario[eleccion] = -1;
                                                //if(Math.random()<0.2){
                                                //buscar cuchillo y romper
                                                //}                                                 
                                            }

                                            break;

                                        case 10:
                                            nombreObjetos[10] = inven.usarPapel(teclado);
                                            break;

                                        case 13:

                                            movimientos += 10;
                                            System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                            System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                            System.out.println("Ganas diez movimientos (+10)");
                                            inventario[eleccion] = -1;

                                            break;
                                    }
                                }

                                break;

                            case 3:
                                System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego = comp.validacionSiNo(teclado);
                                break;

                            case 4:
                                sala = 0;
                                break;

                            case 5:
                                System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego = comp.validacionSiNo(teclado);
                                break;

                            case 6:
                                System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego = comp.validacionSiNo(teclado);
                                break;

                            default:
                                System.out.println("Algo ha salido mal");
                        }
                        break;

                    case 5:
                        switch (sala) {

                            case 0:

                                eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                if (eleccion != -1) {

                                    switch (inventario[eleccion]) {

                                        case 3:
                                            vida++;
                                            escudo++;
                                            System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                            System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                            inventario[eleccion] = -1;
                                            break;

                                        case 6:

                                            if (inven.usarLata(inventario, teclado)) {
                                                vida++;
                                                movimientos += 5;
                                                inventario[eleccion] = -1;
                                                //if(Math.random()<0.2){
                                                //buscar cuchillo y romper
                                                //}                                                 
                                            }

                                            break;

                                        case 10:
                                            nombreObjetos[10] = inven.usarPapel(teclado);
                                            break;

                                        case 13:

                                            movimientos += 10;
                                            System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                            System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                            System.out.println("Ganas diez movimientos (+10)");
                                            inventario[eleccion] = -1;

                                            break;
                                    }
                                }

                                break;

                            case 1:
                                System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego = comp.validacionSiNo(teclado);
                                break;

                            case 2:
                                System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego = comp.validacionSiNo(teclado);
                                break;

                            case 3:
                                System.out.println("Algo ha salido mal");
                                break;

                            case 4:

                                eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                if (eleccion != -1) {

                                    switch (inventario[eleccion]) {

                                        case 3:
                                            vida++;
                                            escudo++;
                                            System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                            System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                            inventario[eleccion] = -1;
                                            break;

                                        case 6:

                                            if (inven.usarLata(inventario, teclado)) {
                                                vida++;
                                                movimientos += 5;
                                                inventario[eleccion] = -1;
                                                //if(Math.random()<0.2){
                                                //buscar cuchillo y romper
                                                //}                                                 
                                            }

                                            break;

                                        case 10:
                                            nombreObjetos[10] = inven.usarPapel(teclado);
                                            break;

                                        case 13:

                                            movimientos += 10;
                                            System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                            System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                            System.out.println("Ganas diez movimientos (+10)");
                                            inventario[eleccion] = -1;

                                            break;
                                    }
                                }

                                break;

                            case 5:
                                System.out.println("Algo ha salido mal");
                                break;

                            case 6:
                                System.out.println("Algo ha salido mal");
                                break;

                            default:
                                System.out.println("Algo ha salido mal");
                        }
                        break;

                    case 6:
                        switch (sala) {
                            case 0:
                                System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego = comp.validacionSiNo(teclado);
                                break;

                            case 1:
                                System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego = comp.validacionSiNo(teclado);
                                break;

                            case 2:
                                System.out.println("Algo ha salido mal");
                                break;

                            case 3:
                                System.out.println("Algo ha salido mal");
                                break;

                            case 4:
                                System.out.println("¿Estas seguro de querer abandonar la partida?");
                                System.out.println("Tu progreso se perderá por completo");
                                salirJuego = comp.validacionSiNo(teclado);
                                break;

                            case 5:
                                System.out.println("Algo ha salido mal");
                                break;

                            case 6:
                                System.out.println("Algo ha salido mal");
                                break;

                            default:
                                System.out.println("Algo ha salido mal");
                        }
                        break;

                    default:
                        System.out.println("Algo ha salido mal");
                }
                movimientos--;

                if (eleccionMenu == 1) {//Si eleccion del menu es 1 (podria ir en el switch case 1:)

                    //Repeticion menu interno (de la sala) hasta que no "salga" de esta
                    do {
                        //Devolvemos las variables al estado neutro
                        eleccionMenu = 0;
                        eleccion = 0;
                        acabarInspeccion = false;//No necesario pero nos asegurames de que esté en falso hasta que se desee salir

                        mensaje.MenuInteraccion(sala, objetosObtenidos, nombreObjetos, inventario);//Mensaje de los menus internos de cada sala

                        eleccionMenu = comp.eleccionMenuInteraccion(sala, teclado);

                        switch (sala) {

                            case 0:

                                switch (eleccionMenu) {

                                    case 1:

                                        if (!objetosObtenidos[0]) {
                                            System.out.println("Parecen unos cables que han sido arrancados de un procesador.");
                                            System.out.println("Parece que funcionan... puede que te sirvan de algo en un futuro.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(0, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(0, inventario)) {
                                                    objetosObtenidos[0] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }
                                            } else {
                                                System.out.println("Estaba claro. ¿Para que iba a querer unos cables rotos?");
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 2:

                                        if (!objetosObtenidos[1]) {
                                            System.out.println("Está un poco doblada pero creo que la podría arreglar sin gran dificultad.");
                                            System.out.println("Puedo probar a encajarla en alguna cerradura o buscar alguna M.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(1, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(1, inventario)) {
                                                    objetosObtenidos[1] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }
                                            } else {
                                                System.out.println("Da igual, estoy demasiado cansado para arreglar esta maldita llave.");
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 3:

                                        if (!objetosObtenidos[2]) {
                                            System.out.println("Me suena mucha esta clave, pero ahora mismo no logro recordar nada.");
                                            System.out.println("Hay una parte quemada y no se consigue ver toda la clave, podría recordarla más adelante.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(2, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(2, inventario)) {
                                                    objetosObtenidos[2] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }
                                            } else {
                                                System.out.println("Ojalá fuera yo esa clave y me hubiera calcinado medio cuerpo en el accidente...");
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 4:
                                        acabarInspeccion = true;
                                        break;

                                    case 5:

                                        eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                        if (eleccion != -1) {

                                            switch (inventario[eleccion]) {

                                                case 3:
                                                    vida++;
                                                    escudo++;
                                                    System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                                    System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                                    inventario[eleccion] = -1;
                                                    break;

                                                case 6:

                                                    if (inven.usarLata(inventario, teclado)) {
                                                        vida++;
                                                        movimientos += 5;
                                                        inventario[eleccion] = -1;
                                                        //if(Math.random()<0.2){
                                                        //buscar cuchillo y romper
                                                        //}                                                 
                                                    }

                                                    break;

                                                case 10:
                                                    nombreObjetos[10] = inven.usarPapel(teclado);
                                                    break;

                                                case 13:

                                                    movimientos += 10;
                                                    System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                                    System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                                    System.out.println("Ganas diez movimientos (+10)");
                                                    inventario[eleccion] = -1;

                                                    break;
                                            }
                                        }

                                        break;

                                    case 6:
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                        System.out.println("Tu progreso se perderá por completo");
                                        if (comp.validacionSiNo(teclado)) {
                                            salirJuego = true;
                                        }
                                        break;

                                    default:
                                        System.out.println("Algo ha salido mal");

                                }

                                break;

                            case 1:

                                switch (eleccionMenu) {

                                    case 1:

                                        if (!objetosObtenidos[3]) {
                                            System.out.println("No parece especialmente apetecible, pero tampoc crees que esté malo.");
                                            System.out.println("¿Quieres comertelo? (usar)");
                                            if (comp.validacionSiNo(teclado)) {
                                                objetosObtenidos[3] = true;
                                                vida++;
                                                escudo++;
                                                System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                                System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                            } else {
                                                System.out.println("¿Deseas guardarlo en tu inventario?");
                                                if (comp.validacionSiNo(teclado)) {
                                                    System.out.println("Guardando en el inventario...");
                                                    inventario = inven.insertarObjeto(3, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                    //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                    if (inven.comprobarInventario(3, inventario)) {
                                                        objetosObtenidos[3] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                    }
                                                } else {
                                                    System.out.println("Si no se ha puesto malo puede quedarse aqui unos cuantos años más.");
                                                }
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 2:

                                        if (!objetosObtenidos[4]) {
                                            System.out.println("Desde luego esta sarten tiene más años que el mismo universo.");
                                            System.out.println("No creo que vaya a cocinar nada pero podría usarla de protección... o algo");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(4, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(4, inventario)) {
                                                    objetosObtenidos[4] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                    System.out.println("Te sientes más pesado, pero tambien más protegido.");
                                                    System.out.println("Ganas un escudo (+1)");
                                                    escudo++;
                                                }

                                            } else {
                                                System.out.println("Dejemosla aquí, que siga viendo el paso del tiempo.");
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 3:

                                        if (!objetosObtenidos[5]) {
                                            System.out.println("Espera... ¿De madera? ¿No teniamos dinero para unos buenos cuchillos de titanio?");
                                            System.out.println("Bueno, al menos no está astillado. Si era capaz de cortar la carne tan dura de la cantina");
                                            System.out.println("podrá con cualquier cosa...");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(5, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(5, inventario)) {
                                                    objetosObtenidos[5] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }
                                            } else {
                                                System.out.println("¿Pero desde cuando los cuchillos son de madera?");
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 4:
                                        acabarInspeccion = true;
                                        break;

                                    case 5:

                                        eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                        if (eleccion != -1) {

                                            switch (inventario[eleccion]) {

                                                case 3:
                                                    vida++;
                                                    escudo++;
                                                    System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                                    System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                                    inventario[eleccion] = -1;
                                                    break;

                                                case 6:

                                                    if (inven.usarLata(inventario, teclado)) {
                                                        vida++;
                                                        movimientos += 5;
                                                        inventario[eleccion] = -1;
                                                        //if(Math.random()<0.2){
                                                        //buscar cuchillo y romper
                                                        //}                                                 
                                                    }

                                                    break;

                                                case 10:
                                                    nombreObjetos[10] = inven.usarPapel(teclado);
                                                    break;

                                                case 13:

                                                    movimientos += 10;
                                                    System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                                    System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                                    System.out.println("Ganas diez movimientos (+10)");
                                                    inventario[eleccion] = -1;

                                                    break;
                                            }
                                        }

                                        break;

                                    case 6:
                                        System.out.println("¿Estás seguro de que deseas salir?");
                                        System.out.println("Tu progreso se perderá por completo");
                                        salirJuego = comp.validacionSiNo(teclado);
                                        break;

                                    default:
                                        System.out.println("Algo ha salido mal");

                                }

                                break;

                            case 2:

                                switch (eleccionMenu) {

                                    case 1:

                                        System.out.println("A pesar de lo enclenque que parece esta silla podría aguantar hasta ");
                                        System.out.println("diez veces tu peso, pero sin duda no llegarás muy lejos con ella.");
                                        System.out.println("");
                                        System.out.println("Se te ocurre que puedes moverla a algunos lugares...");

                                        do {
                                            System.out.println("Mover silla a:");
                                            System.out.println("1. Puerta con ventana");
                                            System.out.println("2. Mesa central");
                                            System.out.println("3. Altillo");
                                            System.out.println("4. Dejar silla");

                                            //Asignamos valor introducido por teclado y validamos para la seleccion de mover silla
                                            eleccion = comp.valorEntre1y4(teclado.nextInt(), teclado);//GUAU como funke esta vaina

                                            switch (eleccion) {

                                                case 1:
                                                    System.out.println("Te acercas a la puerta y ves que la enfermera yace muerta en el interior.");
                                                    if (visitaLucia) {
                                                        System.out.println("vete olvidando de poder abrir esa caja del dormitorio con la llave...");
                                                        System.out.println("alcanzas a ver como reluce en su cuello.");
                                                    }
                                                    break;

                                                case 2:
                                                    System.out.println("¿Quieres subir a la mesa?");
                                                    if (comp.validacionSiNo(teclado)) {
                                                        System.out.println("Te crees el rey de la nave y empiezas a bailar, nadie puede pararte, eres tú");
                                                        System.out.println("y la música que no para de sonar en tu cabeza. Ves que el mundo se paraliza a tu");
                                                        System.out.println("alrededor mientras tu no dejas de bailar. La mesa es tuya y nadie puede bajarte de ahi");
                                                        System.out.println(".");
                                                        System.out.println(".");
                                                        System.out.println(".");
                                                        System.out.println("Después de perder 10 movimientos te replanteas tus metas y aspiraciones y continuas");
                                                        System.out.println("buscando la forma de salvar tu vida (-10 movimientos)");
                                                        movimientos -= 10;
                                                    }
                                                    break;

                                                case 3://Bug intencionado, si repites esta accion puedes conseguir más munición
                                                    System.out.println("¿Quieres subir al altillo?");
                                                    if (comp.validacionSiNo(teclado)) {
                                                        System.out.print("Ves una caja de munición");
                                                        if (objetosObtenidos[11]) {
                                                            System.out.print(" que parece que le vale a tu arma.");
                                                        }
                                                        System.out.println("");
                                                        System.out.println("Que lastima solo queda una bala... (+1 municion)");
                                                        municion++;
                                                        if (municion > 5) {
                                                            System.out.println("Efectivamente, has encontrado un bug. Puedes aprovecharlo si crees que será util, pero te recuerdo que estás perdiendo turnos............................................................................... xD");
                                                        }
                                                    }
                                                    break;

                                                case 4:
                                                    System.out.println("Dejas la silla exactamente donde estaba porque recuerdas que al jefe no le gustaba que le");
                                                    System.out.println("su silla... cierto, no crees que te vaya a ver pero quien sabe.");
                                                    break;

                                                default:
                                                    System.out.println("Algo ha salido mal");

                                            }
                                            //Se resta movimientos cada vez que se haga algo con la silla
                                            movimientos--;

                                        } while (eleccion != 4 && movimientos > 0 && vida > 0);

                                        break;

                                    case 2:

                                        if (!objetosObtenidos[6]) {
                                            System.out.println("Es una de tus comidas favoritas, que lastima que no puedas abrirla para comertela...");
                                            if (objetosObtenidos[5])//si ha visto el cuchillo
                                            {
                                                System.out.println("¡¡¡EEEEEEHH!!! Ese cuchillo de madera podría abrirla");
                                            }
                                            //Si usa objeto
                                            if (inven.usarLata(inventario, teclado)) {
                                                objetosObtenidos[6] = true;
                                                vida++;
                                                movimientos += 5;
                                            }
                                            //Si no se ha comido el objeto
                                            if (!objetosObtenidos[6]) {
                                                System.out.println("¿Deseas guardarlo en tu inventario?");
                                                if (comp.validacionSiNo(teclado)) {
                                                    System.out.println("Guardando en el inventario...");
                                                    inventario = inven.insertarObjeto(3, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                    //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                    if (inven.comprobarInventario(6, inventario)) {
                                                        objetosObtenidos[6] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                    }
                                                } else {
                                                    System.out.println("Con todo el dolor de mi corazón te dejo aquí. Pero cuando me recupere volveré a por ti.");
                                                }
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 3:

                                        if (!objetosObtenidos[7]) {
                                            System.out.println("Ves un esquema de la zona de motores de lo que sin duda es tu nave.");
                                            System.out.println(" Hay marcado una señal con una X… Eso suele significar algo.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(7, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(7, inventario)) {
                                                    objetosObtenidos[7] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }
                                            } else {
                                                System.out.println("Esto no es una pelicula de piratas, no tengo tiempo de buscar tesoros.7");
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 4:
                                        acabarInspeccion = true;
                                        break;

                                    case 5:

                                        eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                        if (eleccion != -1) {

                                            switch (inventario[eleccion]) {

                                                case 3:
                                                    vida++;
                                                    escudo++;
                                                    System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                                    System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                                    inventario[eleccion] = -1;
                                                    break;

                                                case 6:

                                                    if (inven.usarLata(inventario, teclado)) {
                                                        vida++;
                                                        movimientos += 5;
                                                        inventario[eleccion] = -1;
                                                        //if(Math.random()<0.2){
                                                        //buscar cuchillo y romper
                                                        //}                                                 
                                                    }

                                                    break;

                                                case 10:
                                                    nombreObjetos[10] = inven.usarPapel(teclado);
                                                    break;

                                                case 13:

                                                    movimientos += 10;
                                                    System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                                    System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                                    System.out.println("Ganas diez movimientos (+10)");
                                                    inventario[eleccion] = -1;

                                                    break;
                                            }
                                        }

                                        break;

                                    case 6:
                                        System.out.println("¿Estás seguro de que deseas salir?");
                                        System.out.println("Tu progreso se perderá por completo");
                                        salirJuego = comp.validacionSiNo(teclado);
                                        break;

                                    default:
                                        System.out.println("Algo ha salido mal");

                                }

                                break;

                            case 3:
                                System.out.println("¡HAS GANADO!");
                                ganado = true;
                                /*
                                    Desarrollar
                                 */
                                break;

                            case 4:

                                switch (eleccionMenu) {

                                    case 1:

                                        System.out.println("Al abrirlo no hay nada interesante.");
                                        if (!objetosObtenidos[9]) {
                                            System.out.println("Solo ves un bolígrafo de plomo con el que solía firmar las leyes que se decidían en su mesa.");
                                        }
                                        if (!objetosObtenidos[8]) {
                                            System.out.println("Lo único que te parece curioso es un casco de titanio que se encuentra en perfecto estado, debajo de la silla. ");
                                        }
                                        System.out.println("Al parecer el comandante no era tan perfecto como decía.");

                                        if (!objetosObtenidos[9]) {
                                            System.out.println("¿Deseas guardar el boligrafo en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(9, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(9, inventario)) {
                                                    objetosObtenidos[9] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }
                                            } else {
                                                System.out.println("Era del jefe, está feo robarle a un muerto.");
                                            }
                                        }

                                        if (!objetosObtenidos[8]) {
                                            System.out.println("¿Deseas ponerte el casco (guardar en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Poniendo casco...");
                                                inventario = inven.insertarObjeto(8, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(8, inventario)) {
                                                    objetosObtenidos[8] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                    escudo++;
                                                    System.out.println("Te sientes protegido, ganas un escudo (+1 escudo)");
                                                }
                                            } else {
                                                System.out.println("No creo que me quepa en la cabeza.");
                                            }
                                        }

                                        break;

                                    case 2:
                                        System.out.println("Todo está igual de limpio que cuando entraste, debes confiar un poco más en ti y no ");
                                        System.out.println("perder energía en movimientos inútiles.");
                                        break;

                                    case 3:

                                        if (!objetosObtenidos[10]) {
                                            System.out.println("Te encuentras un papel en blanco. Podrías utilizarlo para escribir algo, porque no ");
                                            System.out.println("puedes confiar ni en tu memoria ni en tu cabeza.");
                                            System.out.println("¿Deseas guardarlo en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(10, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(10, inventario)) {
                                                    objetosObtenidos[10] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }
                                            } else {
                                                System.out.println("Bueno, mi memoria nunca me ha fallado.");
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 4:
                                        acabarInspeccion = true;
                                        break;

                                    case 5:

                                        eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                        if (eleccion != -1) {

                                            switch (inventario[eleccion]) {

                                                case 3:
                                                    vida++;
                                                    escudo++;
                                                    System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                                    System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                                    inventario[eleccion] = -1;
                                                    break;

                                                case 6:

                                                    if (inven.usarLata(inventario, teclado)) {
                                                        vida++;
                                                        movimientos += 5;
                                                        inventario[eleccion] = -1;
                                                        //if(Math.random()<0.2){
                                                        //buscar cuchillo y romper
                                                        //}                                                 
                                                    }

                                                    break;

                                                case 10:
                                                    nombreObjetos[10] = inven.usarPapel(teclado);
                                                    break;

                                                case 13:

                                                    movimientos += 10;
                                                    System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                                    System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                                    System.out.println("Ganas diez movimientos (+10)");
                                                    inventario[eleccion] = -1;

                                                    break;
                                            }
                                        }

                                        break;

                                    case 6:
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                        System.out.println("Tu progreso se perderá por completo");
                                        if (comp.validacionSiNo(teclado)) {
                                            salirJuego = true;
                                        }
                                        break;

                                    default:
                                        System.out.println("Algo ha salido mal");

                                }

                                break;

                            case 5:

                                switch (eleccion) {

                                    case 1:

                                        System.out.print("La habitación de George, la reconoces por su caos organizado");
                                        if (!objetosObtenidos[11]) {
                                            System.out.println(" pero principalmente por");
                                            System.out.println("el arma que llevaba consigo siempre. Se nota que salió corriendo cuando ocurrió el");
                                            System.out.println("desastre porque sabes que nunca la abandonaría ahí. ");
                                            System.out.println("¿Deseas guardar el arma en tu inventario?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Vaya, parece que no tiene balas.");
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(11, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(11, inventario)) {
                                                    objetosObtenidos[11] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }
                                            } else {
                                                System.out.println("Di no a las armas.");
                                            }
                                        } else {
                                            System.out.println("");//Salto de linea en caso de no describir
                                            System.out.println("Ya has cogido todos los objetos de esta habitación.");
                                        }

                                        break;

                                    case 2:

                                        System.out.println("Esta es la habitación de Josema, la reconoces porque es la habitación de un completo loco.");
                                        System.out.println("No es que esté desorganizada, es que tiene el colchón en el suelo, las mantas hechas un gurruño, ");
                                        System.out.println("botellas por el suelo e incluso pintadas en las paredes. De hecho todas las pintadas siguen un ");
                                        System.out.println("patrón, 41020. No sabes que es, solo sabes que si no fuera el único ingeniero de motores de la");
                                        System.out.println("nave lo habrían tirado por la borda en más de una ocasión. ");

                                        break;

                                    case 3:

                                        System.out.println("La habitación de Lucia,la enfermera, médica y todo lo relacionado con la salud en esta nave.");
                                        System.out.println("Todo está tan ordenado como siempre, aunque te llama la atención que el cajón de la cómoda ");
                                        System.out.println("tiene un candado. Recuerdas que llevaba siempre una llave al cuello, lo cual es raro porque");
                                        System.out.println("la enfermería no se abre con una llave común. Seguro que esa llave abre este candado. ");

                                        if (candadoRoto) {
                                            System.out.println("Clave de la enfermeria: " + claveEnfermeria);//Podemos modificarla
                                        } else {
                                            if (inven.comprobarInventario(14, inventario)) {
                                                System.out.println("Vaya, parece que este puede ser el momento de usar alguna de mis herramientas.");
                                                System.out.println("¿Quieres usar la sierra mecánica para abrir este candado?");
                                                if (comp.validacionSiNo(teclado)) {
                                                    for (int i = 0; i < inventario.length; i++) {
                                                        if (inventario[i] == 14) {
                                                            inventario[i] = -1;
                                                            candadoRoto = true;
                                                            i = inventario.length;
                                                        }
                                                    }
                                                    System.out.println("¡Funcionó! Veamos que hay dentro... Nada.");
                                                    System.out.println("Pero al sacar el cajón de la desesperación ves unos numeros y letras grabados");
                                                    System.out.println("donde pone claramente");
                                                    System.out.println("Clave de la enfermeria: " + claveEnfermeria);//Podemos modificarla
                                                } else {
                                                    System.out.println("Tardaria mucho tiempo en cortar este candado... No será tan importate lo que haya dentro jajajaja");
                                                }
                                            }
                                        }

                                        visitaLucia = true;
                                        break;

                                    case 4:

                                        System.out.println("Aquí descansaba nuestro gran amigo manu.");
                                        if (!objetosObtenidos[13]) {
                                            System.out.println("Lo das por muerto ya que era hemofílico y en un accidente como este no hay muchas");
                                            System.out.println("esperanzas de que sobreviva. De hecho ves su dosis diaria de medicina coagulante ");
                                            System.out.println("intacta sobre su cómoda. Él nunca dejaría que se le pasara la hora de su inyección.");

                                            System.out.println("¿Quieres inyectarte la medicina? (usar)");
                                            if (comp.validacionSiNo(teclado)) {
                                                objetosObtenidos[13] = true;
                                                movimientos += 10;
                                                System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                                System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                                System.out.println("Ganas diez movimientos (+10)");
                                            } else {
                                                System.out.println("¿Deseas guardar la medicina coagulante en tu inventario?");
                                                if (comp.validacionSiNo(teclado)) {
                                                    System.out.println("Guardando en el inventario...");
                                                    inventario = inven.insertarObjeto(13, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                    //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                    if (inven.comprobarInventario(13, inventario)) {
                                                        objetosObtenidos[13] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                    }
                                                } else {
                                                    System.out.println("¡No puede haber muerto!¿Y si vuelve y le hace falta?");
                                                    System.out.println("La dejaré aquí en su sitio.");
                                                }
                                            }
                                        } else {
                                            System.out.println("Ya has cogido todos los objetos de esta habitación.");
                                        }

                                        break;
                                    case 5:
                                        acabarInspeccion = true;
                                        break;

                                    case 6:

                                        eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                        if (eleccion != -1) {

                                            switch (inventario[eleccion]) {

                                                case 3:
                                                    vida++;
                                                    escudo++;
                                                    System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                                    System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                                    inventario[eleccion] = -1;
                                                    break;

                                                case 6:

                                                    if (inven.usarLata(inventario, teclado)) {
                                                        vida++;
                                                        movimientos += 5;
                                                        inventario[eleccion] = -1;
                                                        //if(Math.random()<0.2){
                                                        //buscar cuchillo y romper
                                                        //}                                                 
                                                    }

                                                    break;

                                                case 10:
                                                    nombreObjetos[10] = inven.usarPapel(teclado);
                                                    break;

                                                case 13:

                                                    movimientos += 10;
                                                    System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                                    System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                                    System.out.println("Ganas diez movimientos (+10)");
                                                    inventario[eleccion] = -1;

                                                    break;
                                            }
                                        }

                                        break;

                                    case 7:
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                        System.out.println("Tu progreso se perderá por completo");
                                        if (comp.validacionSiNo(teclado)) {
                                            salirJuego = true;
                                        }
                                        break;

                                    default:
                                        System.out.println("Algo ha salido mal");

                                }

                                break;

                            case 6:

                                switch (eleccionMenu) {

                                    case 1:

                                        System.out.println("Es un bidón. Tiene algo líquido dentro. Huele a Gasolina. ¿Sabrá también a gasolina?");
                                        System.out.println("Ojalá tener un mechero para salir de dudas…. ");
                                        System.out.println("No puedes guardar el bidón de gasolina pero puedes probarlo.");
                                        System.out.println("¿Quieres probarla?");
                                        if (comp.validacionSiNo(teclado)) {
                                            System.out.println("Toses bastante e incluso vomitas. Después de recuperar el sentido te das cuenta de ");
                                            System.out.println("la estupidez que acabas de hacer y te planteas si de verdad quieres seguir viviendo.");
                                            System.out.println("");
                                            System.out.println("(Mensaje de los programadores: de verdad pensabamos que nadie iba a hacer esto)");
                                            System.out.println("");
                                            vida -= 2;
                                            movimientos -= 10;
                                            System.out.println("Pierdes dos de vida (-2) y diez movimientos (-10)");
                                        }

                                        break;

                                    case 2:

                                        if (!objetosObtenidos[14]) {
                                            System.out.println("Parece que funciona perfectamente, aunque es bastante grande. Pero sin duda sería capaz de ");
                                            System.out.println("cortar cualquier cosa.");
                                            System.out.println("¿Deseas guardarla en tu inventario (ocupa dos espacios)?");
                                            if (comp.validacionSiNo(teclado)) {
                                                System.out.println("Guardando en el inventario...");
                                                inventario = inven.insertarObjeto(14, inventario, teclado, nombreObjetos);//Con este metodo no sabemos si se ha insertado el objeto
                                                //Comprobamos que se ha introducido finalmente el objeto en el inventario para realizar las acciones
                                                if (inven.comprobarInventario(14, inventario)) {
                                                    objetosObtenidos[14] = true;//No se le asigna el valor de comprobarInventario ya que el no estar en el inventario no implica que si esté en la habitación
                                                }
                                            } else {
                                                System.out.println("Es demasiado grande y no voy a ponerme a desmantelar la nave.");
                                            }
                                        } else {
                                            System.out.println("Ya has cogido el objeto.");
                                        }

                                        break;

                                    case 3:
                                        acabarInspeccion = true;
                                        break;

                                    case 4:

                                        eleccion = mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
                                        if (eleccion != -1) {

                                            switch (inventario[eleccion]) {

                                                case 3:
                                                    vida++;
                                                    escudo++;
                                                    System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                                                    System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                                                    inventario[eleccion] = -1;
                                                    break;

                                                case 6:

                                                    if (inven.usarLata(inventario, teclado)) {
                                                        vida++;
                                                        movimientos += 5;
                                                        inventario[eleccion] = -1;
                                                        //if(Math.random()<0.2){
                                                        //buscar cuchillo y romper
                                                        //}                                                 
                                                    }

                                                    break;

                                                case 10:
                                                    nombreObjetos[10] = inven.usarPapel(teclado);
                                                    break;

                                                case 13:

                                                    movimientos += 10;
                                                    System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                                                    System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                                                    System.out.println("Ganas diez movimientos (+10)");
                                                    inventario[eleccion] = -1;

                                                    break;
                                            }
                                        }

                                        break;

                                    case 5:
                                        System.out.println("¿Estas seguro de querer abandonar la partida?");
                                        System.out.println("Tu progreso se perderá por completo");
                                        if (comp.validacionSiNo(teclado)) {
                                            salirJuego = true;
                                        }
                                        break;

                                    case 6:

                                        if (revistaX) {
                                            System.out.println("Emmmmmmmm no, no vas a encontrar más revistas.");
                                            System.out.println("Por cierto, acabas de perder un movimiento extra, eso te pasa");
                                            System.out.println("Por intentar saltarte las normas (-1 movimientos)");
                                            movimientos--;
                                        } else {
                                            if (inven.comprobarInventario(7, inventario)) {
                                                System.out.println("Encuentras escondida detrás de una caldera una cajita con");
                                                System.out.println("un candado de combinación de 5 dígitos.");
                                                do {
                                                    System.out.println("¿Quieres introducir una clave de 5 digitos?");
                                                    respuestaSiNo = comp.validacionSiNo(teclado);
                                                    if (respuestaSiNo) {
                                                        System.out.println("Venga, probemos suerte:");
                                                        clave = teclado.nextLine();

                                                        if (clave.equals("41020")) {
                                                            System.out.println("No puede ser, se está abriendo");
                                                            System.out.println(".");
                                                            System.out.println(".");
                                                            System.out.println(".");
                                                            System.out.println(".");
                                                            System.out.println("Al abrirla encuentras una revista XXX , ahora entiendes lo de la gran X… ");

                                                            System.out.println("Ya que estamos ¿Quieres echarle un vistazo?");
                                                            if (comp.validacionSiNo(teclado)) {
                                                                System.out.println("Oyes la voz de tu abuela regañandote y rapidamente la sueltas.");
                                                                System.out.println("Justo cae por una grieta que había debajo tuya y ni siquiera la oyes caer.");
                                                                System.out.println("Parece que nunca podrás ver esa revista, lo bueno es que tendrás más tiempo");
                                                                System.out.println("para buscar la enfermeria y no morir :)");
                                                            } else {
                                                                System.out.println("Rompes la revista en mil pedazos y te centras en tu verdadera");
                                                                System.out.println("misión, no morir.");
                                                            }

                                                            revistaX = true;

                                                        } else {
                                                            System.out.println("Parece que no se abre.");
                                                        }
                                                    }

                                                    movimientos--;

                                                } while (!revistaX && respuestaSiNo);
                                            } else {
                                                //Mensaje casual
                                                System.out.println("¿Que demonios? ¿Como has encontrado esto?");
                                                System.out.println("Voy a llamar a los desarrolladores a ver si arreglan esto...");
                                            }
                                        }

                                        break;

                                    default:
                                        System.out.println("Algo ha salido mal");

                                }

                                break;

                            default:
                                System.out.println("Algo ha salido mal");
                        }

                        movimientos--;

                    } while (!acabarInspeccion && vida > 0 && movimientos > 0 && !ganado && !salirJuego);//declarar otra variable en caso de estar en el switch del menu (case 1:)
                }

            } while (vida > 0 && movimientos > 0 && !ganado && !salirJuego);

            mensaje.FinPartida(vida, movimientos, dificil, ganado, salirJuego);

            System.out.println("Desea volver a intentarlo?");

        } while (comp.validacionSiNo(teclado));

        mensaje.Salida();

        teclado.close();

    }

}
