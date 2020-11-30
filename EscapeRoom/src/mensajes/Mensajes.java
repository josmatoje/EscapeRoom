package mensajes;

import inventario.Inventario;
import java.util.Scanner;
import mapa.Mapa;

public class Mensajes {

    public void Bienvenida() {
        System.out.println("----------------------------------------BIENVENIDO------------------------------------------------");
        System.out.println("");
        System.out.println("Esta usted antes el escape room más espectacular habido en la faz de la tierra.");
        System.out.println("Podrá usted repetirlo tantas veces como quiera realizando runs totalmente independientes una de la otra.");
        System.out.println("Tambien al salir puede volver a este programa si lo desea, eso es evidente.");
        System.out.println("Tendrá un inventario y una vida dependiendo de la dificultad qeu elija. Durante el juego ira encontrando objetos"
                + " inventario objetos usables cada eleccion un movimiento, perdrer vida y ganar, no todo será util");
        System.out.println("que le podrán ser utiles o incluso perjudiciales. Si te quedas sin espacio puedes sustituir el objeto deseado, eliminando");
        System.out.println("para siempre el objeto que elija, lo que podrá resultar en consecuencias catrostróficas incluso no pudiendo terminar la scape room.");
        System.out.println("Piensa en cada paso y pasatelo bien");
        System.out.println("Pues empecemos...");
    }

    public void Inicio() {
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("Te despiertas, en un cuarto muy oscuro, rodeado de botones de diferentes colores que no ");
        System.out.println("paran de brillar. Ya todo está perdido, viste como caían vuestras últimas naves en este ");
        System.out.println("maldito planeta y al parecer, la tuya tampoco fue una excepción. Aunque en el primer instante");
        System.out.println("te alegres por no haber muerto, se te cambia la cara en un instante al ver en tu ordenador");
        System.out.println("personal que se encuentra en tu mano derecha, que estás perdiendo sangre con cada movimiento");
        System.out.println("que das. Tras unos minutos de espera tu ordenador te indica que solo tienes una probabilidad ");
        System.out.println("del 2% de sobrevivir.");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
    }
    
    public void Sala(int sala, boolean nuevaSala, boolean objetosObtenidos[]) {

        System.out.println("");
        
        if (nuevaSala) { //si la sala no esta visitada, primer Mensaje 

            switch (sala) {

                case 0:
                    System.out.println("Al abrir los ojos observas muchos escombros y objetos destrozados,"
                            + "\n decides levantarte para observar un poco mejor la situación.");
                    break;

                case 1:
                    System.out.println("Entras en la cocina, sin fuerza ninguna pero el olor a salsa barbacoa te hace olvidar que estás perdiendo sangre con cada paso que das."
                            + "\n  Ese olor te lleva a un pobre gato quemándose en las tuberías.");
                break;
                
                case 2:
                    System.out.println("La cantina parece mucho mejor que la cocina,"
                            + "\n aunque también tengan sus zonas de quema por fuga de gas.");
                break;
                
                case 3:
                    System.out.println("Enoncontraste la enfermeria y parece que las maquinas de mantenimiento de"
                            + "\n vida parecen intactas. Aunque no se recomienda su uso sin el personal autorizado,"
                            + "\nesta ocasion de vida o muerte no te deja otra opcion. Con tu mirada nublada tardas unos minutos"
                            + "\nen entender el funcionamiento y como ponerla en analisis corporal completo. Al finalizar el"
                            + "\nanalisis la maquina encuentra todos tus problemas e te inivta a entrar en ella abriendo la puerta."
                            + "\nYa dentro, tras curar tus neuronas recuerdas que el comandante fuiste tu y que toda la flota"
                            + "\nfue a la muerte por tu decision suicida de ir a por todas. Finalmente tu corazon no resiste el "
                            + "\nimpacto emocional y se para. La maquina te lo vuelve a curar, mandandote al mismo pensamiento, lo "
                            + "\nque te causa otra muerte dolorosa y emocional y asi indefinidas veces, sin poder morir, sintiendo"
                            + "\nla angustia infinita de matarlos a todos.");
                break;
                
                case 4:
                    System.out.println("  Dentro de la sala todo parece como si no hubiera pasado nada y es que las paredes blindadas"
                            + "\n y la protección contra los rayos ionizantes dan su fruto");
                break;
                
                case 5:
                    System.out.println("Todo parece tranquilo, como si no hubiera pasado nada."
                            + "\n Ves varias habitaciones cerradas pero la mayoría están abiertas.");
                break;
                
                case 6:
                    System.out.println("Es la primera vez que entras aquí, ves muchas puertas cerradas"
                            + "\n de lo que entiendes son cosas de motores");
                break;
                default:
                    System.out.println("Algo ha salido mal");
            }

        }//fin if

        switch (sala) { //Se mostrará siempre, una breve descripcion de la sala para no perderse

            case 0:
                System.out.println(
                        " Delante tuya se abre el camino a tres puertas distintas, tus recuerdos te indican que a tu izquierda tienes la cocina con muchos alimentos y"
                        + "\n utensilios que te podrían ayudar en tu supervivencia y a tu derecha la sala de reuniones que tanto odiabas pero tanto poder directivo tenía. La puerta central  nunca la habías visto antes,"
                        + "\n te parece muy llamativa y surrealista, llena de colores que no pega nada con el interior de la nave."
                        + "\n además de eso localizas una estantería caída con algunos objetos pero no ves a la distancia que estas");
                break;

            case 1:
                System.out.println(
                        " Al fondo de la cocina localizas varios objetos aun sin quemarse,"
                        + "\n aun así no parecen de mucha utilidad");
                break;

            case 2:
                System.out.print(
                        "\n Inspeccionas la cantina y ves una silla de madera en la que se solían sentar los jefes a almorzar, ");

                if (objetosObtenidos[6]) {

                    System.out.print(
                            "restos de comida de algún soldado que estaría comiendo durante el ataque");

                }

                if (objetosObtenidos[7]) {

                    System.out.print(
                            "y algo parecido a las instrucciones de la nave en una mesa");

                }

                break;

            case 3:
                System.out.println("");//No hay nada sobre la enfermeria
                break;

            case 4:
                System.out.println(
                        "  Algo te huele mal al ver que no hay ningún documento importante."
                        + "\n Al parecer los jefes ejecutivos sabían de antes como iba a terminar todo esto y"
                        + "\n decidieron dejar la nave sin avisar a nadie y limpiar la zona de cualquier material útil,"
                        + "\n típico de comandantes del imperio que solo piensan en ellos mismos.");
                break;

            case 5:
                System.out.println(""); //Nada sobre lo dormitorios
                break;

            case 6:
                System.out.println(
                        "No hay mucho que hacer por aquí ya que está todo destrozados"
                        + "\n del impacto aunque si ves algunas cosas que puedes usar:");
                break;

        }// Fin switch        

    }//Fin clase Sala
    
    public void Menu(int sala) {

    System.out.println("");
    System.out.println("__________________________________________________");
        
        switch (sala) {

            case 0:
                System.out.println("        ********SALA DE MANDOS********");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("1. Inspeccionar estanteria");
                System.out.println("2. Avanzar hasta la cocina");
                System.out.println("3. Avanzar hasta la sala de reuniones");
                System.out.println("4. Avanzar hasta la puerta desconocida");
                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("5. Estado de la partida");
                System.out.println("6. Salir del juego");
                System.out.println("¿Qué vas a hacer?");
                break;

            case 1:
                System.out.println("        ************COCINA************");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("1. Inspeccionar la cocina");
                System.out.println("2. Avanzar hasta la cantina");
                System.out.println("3. Retroceder a la sala de mandos");
                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("4. Estado de la partida");
                System.out.println("5. Salir del juego");
                System.out.println("¿Qué vas a hacer?");
                break;

            case 2:
                System.out.println("        ************CANTINA************");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("1. Inspeccionar cantina");
                System.out.println("2. Avanzar hasta la puerta con Ventana");
                System.out.println("3. Retroceder a la cocina");
                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("4. Estado de la partida");
                System.out.println("5. Salir del juego");
                System.out.println("¿Qué vas a hacer?");
                break;

            case 3:/*Menú opcional/temporal
                System.out.println("        ***********ENFERMERIA***********");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("1. Inspeccionar enfermeria");
                System.out.println("2. Retroceder a la cantina");
                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("3. Estado de la partida");
                System.out.println("4. Salir del juego");
                System.out.println("¿Qué vas a hacer?");*/
                break;

            case 4:
                System.out.println("        *******SALA DE REUNIONES*******");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("1. Inspeccionar sala de reuniones");
                System.out.println("2. Avanzar hasta los dormitorios");
                System.out.println("3. Avanzar hasta la zona de motores");
                System.out.println("4. Retroceder hasta la sala de mandos");
                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("5. Estado de la partida");
                System.out.println("6. Salir del juego");
                System.out.println("¿Qué vas a hacer?");
                break;

            case 5:
                System.out.println("        *********DROMITORIOS*********");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("1. Inspeccionar dormitorios");
                System.out.println("2. Retroceder a la sala de reuniones");
                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("3. Estado de la partida");
                System.out.println("4. Salir del juego");
                System.out.println("¿Qué vas a hacer?");
                break;

            case 6:
                System.out.println("        ********ZONA DE MOTORES********");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("1. Inspeccionar zona de motores");
                System.out.println("2. Retroceder a la sala de reuniones");
                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("3. Estado de la partida");
                System.out.println("4. Salir del juego");
                System.out.println("¿Qué vas a hacer?");
                break;

            default:
                System.out.println("Algo ha salido mal");

        }

    }

    public void MenuInteraccion(int sala, boolean[] objetosObtenidos, String[] nombreObjetos, int [] inventario) {

        Inventario inv = new Inventario();
        
        String todoCogido = "Ya has cogido todos los objetos de esta sala.";
        String objetoCogido = "Ya has obtenido este objeto";
        
        System.out.println("");
        System.out.println("__________________________________________________");
        
        switch (sala) {

            case 0:
                System.out.println("        ********SALA DE MANDOS********");
                System.out.println("__________________________________________________");
                System.out.println("Te acercas a la estanteria y ves:");
                if (!objetosObtenidos[0]) {
                    System.out.println("1. Unos restos de cables rotos.");
                } else {
                    System.out.println(objetoCogido);
                }

                if (!objetosObtenidos[1]) {
                    System.out.println("2. " + nombreObjetos[1]);
                } else {
                    System.out.println(objetoCogido);
                }
                if (!objetosObtenidos[2]) {
                    System.out.println("3. Una clave de acceso medio quemada");
                } else {
                    System.out.println(objetoCogido);
                }

                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("4. Volver al centro de la sala");
                System.out.println("5. Estado de la partida");
                System.out.println("6. Salir del juego");
                System.out.println("");
                System.out.println("¿Qué vas a hacer?");
                break;

            /*
               String[] nombreObjetos = new String[]{  
                                                0"Unos restos de cables rotos", 
                                                1"Una llave doblada con una M",
                                                2"Una clave de acceso medio quemada",
                                                3"Un trozo de pan galactico que no se pudre en 5 años",
                                                4"Una sarte de cobalto niquelado, vieja pero indestructible",
                                                5"Cuchillos de madera",
                                                "Comida enlatada",
                                                "Instrucciones de un jet antiguo",
                                                "Casco",
                                                9"Boligrafo",
                                                "Papel",
                                                11"Arma",
                                                "Codigo enfermera",
                                                13"Medicina coagulante",
                                                14"Sierra mecanica" };
             */
            case 1:
                System.out.println("        ************COCINA************");
                System.out.println("__________________________________________________");
                System.out.println("Decides investigar los objetos y te encuentras");
                if (!objetosObtenidos[3]) {
                    System.out.println("1. Un trozo de pan galactico que no se pudre en 5 años");
                } else {
                    System.out.println(objetoCogido);
                }
                if (!objetosObtenidos[4]) {
                    System.out.println("2. Una sarte de cobalto niquelado, vieja pero indestructible");
                } else {
                    System.out.println(objetoCogido);
                }
                if (!objetosObtenidos[5]) {
                    System.out.println("3. Cuchillos de madera");
                } else {
                    System.out.println(objetoCogido);
                }

                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("4. Volver al centro de la sala");
                System.out.println("5. Estado de la partida");
                System.out.println("6. Salir del juego");
                System.out.println("");
                System.out.println("¿Qué vas a hacer?");
                break;

            case 2:
                System.out.println("        ************CANTINA************");
                System.out.println("__________________________________________________");
                System.out.println("Ves los siguientes objetos");
                System.out.println("1. Una silla ergonomica vintage");
                
                if (!objetosObtenidos[6]) {
                    System.out.println("2. Comida enlatada ");
                } else {
                    System.out.println(objetoCogido);
                }
                if (!objetosObtenidos[7]) {
                    System.out.println("3. Instrucciones de un jet antiguo");
                } else {
                    System.out.println(objetoCogido);
                }

                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("4. Volver al centro de la sala");
                System.out.println("5. Estado de la partida");
                System.out.println("6. Salir del juego");
                System.out.println("");
                System.out.println("¿Qué vas a hacer?");
                break;

            case 3:/*Menú opcional/temporal
                System.out.println("        ***********ENFERMERIA***********");
                System.out.println("__________________________________________________");
                System.out.println("Te acercas a la estanteria y ves:");
                System.out.println("1. Unos restos de cables rotos.");
                System.out.println("2. Una llave doblada con una M");
                System.out.println("3. una clave de acceso medio quemada");
                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("4. Volver al centro de la sala");
                System.out.println("5. Estado de la partida");
                System.out.println("6. Salir del juego");
                System.out.println("");
                System.out.println("¿Qué vas a hacer?");*/
                break;

            case 4:
                System.out.println("        *******SALA DE REUNIONES*******");
                System.out.println("__________________________________________________");
                System.out.println("En la sala hay una mesa central con cajones mirando hacia cada silla pero todos estan cerrados menos el del comandante.");
                if (!objetosObtenidos[9] || !objetosObtenidos[8]) { // Casco y el boligrafo
                    System.out.println("1. Cajón del comandante");
                } else {
                    System.out.println(objetoCogido);
                }
                
                System.out.println("2. Mirar encima de la mesa");

                if (!objetosObtenidos[10]) {
                    System.out.println("3. Mirar debajo de la mesa");
                } else {
                    System.out.println(objetoCogido);
                }

                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("4. Volver al centro de la sala");
                System.out.println("5. Estado de la partida");
                System.out.println("6. Salir del juego");
                System.out.println("");
                System.out.println("¿Qué vas a hacer?");
                break;

            case 5:
                System.out.println("        *********DOMITORIOS*********");
                System.out.println("__________________________________________________");
                System.out.println("Ves delante tuya 4 habitaciones.");
                System.out.println("1. Ir a habitación 1");
                System.out.println("2. Ir a habitación 2");
                System.out.println("3. Ir a habitación 3");
                System.out.println("4. Ir a habitación 4");
                System.out.println("");

                System.out.println("Tambien puedes:");
                System.out.println("5. Volver al centro de la sala");
                System.out.println("6. Estado de la partida");
                System.out.println("7. Salir del juego");
                System.out.println("");
                System.out.println("¿Qué vas a hacer?");
                break;

            case 6:
                System.out.println("        ********ZONA DE MOTORES********");
                System.out.println("__________________________________________________");
                System.out.println("Esas cosas son:");
                System.out.println("1. Bidon de gasolina");
                if (!objetosObtenidos[14]) {
                    System.out.println("2. Sierra mecanica");
                } else {
                    System.out.println(objetoCogido);
                }
                System.out.println("");
                System.out.println("Tambien puedes:");
                System.out.println("3. Volver al centro de la sala");
                System.out.println("4. Estado de la partida");
                System.out.println("5. Salir del juego");
                System.out.println("");
                if(inv.comprobarInventario(7, inventario)){
                    System.out.println("6. Dirigirte a la X del mapa encontrado");
         
                    System.out.println("");
                }
                
                System.out.println("¿Qué vas a hacer?");
                break;

            default:
                System.out.println("Algo ha salido mal");
        }

    }
    
    /*
    Signatura: public int Estado(int vida, int movimientos,int [] inventario, String [] objetos, Scanner teclado)
    Descripcion: Imprime la vida, los movimientos restantes y los objetos que se encuentren en el inventario 
            y en caso de haber un objeto usable y querer usarlo devuelve un entero con la posicion de este en el inventario.
                En caso contrario devuelve -1.
    Precondiciones: el array de cadena introducido debe ser el existente en el programa de escape room
    Entradas: entero que define la vida, entero con los movimientos, array de enteros de objetos que hay en el inventario, 
                array de cadenas con los nombres de cada objeto y un objeto del tipo Scanner
    Salida: entero con la posicion en el inventario del objeto que se quiere usar
    Postcondiciones: el valor devuelto se corresponde con alguna posicion del inventario
    */
    /*
        SWITCH DE ELECCION DESPUES DEL MENU DE ESTADO
            es necesario que esté en el main por la multitud de datos diferentes que existen
    
    
        eleccion=mensaje.Estado(vida, movimientos, inventario, nombreObjetos, teclado);
        if(eleccion!=-1){

            switch (inventario[eleccion]){

                case 3:
                    vida++;
                    escudo++;
                    System.out.println("Sientes como es pequeño trozo de pan te revitaliza mucho más de lo que esperabas.");
                    System.out.println("Ganas uno de vida (+1) y un escudo (+1)");
                    inventario[eleccion]=-1;
                break;

                case 6:
                    if(inven.usarLata(inventario, teclado)){
                        vida++;
                        movimientos+=5;
                        inventario[eleccion]=-1;
                        //if(Math.random()<0.2){
                            //buscar cuchillo y romper
                        //}                                                 
                    }
                break;

                case 10:
                    nombreObjetos[10]=inven.usarPapel(teclado);
                break;

                case 13:
                    movimientos+=10;
                    System.out.println("Te la inyectas sin pensarlo demasiado y esperas unos segundos. No notas nada pero te");
                    System.out.println("fijas en que tus heridas ya no sangran como antes. Digamos que estas más espeso de lo normal.");
                    System.out.println("Ganas diez movimientos (+10)");
                    inventario[eleccion]=-1;
                break;

            }
        }
    */
    public int Estado(int vida, int movimientos,int [] inventario, String [] objetos, int sala, boolean [] nuevaSala, Scanner teclado) {
        
        Inventario inv = new Inventario();
        Mapa mapa = new Mapa();
        
        int usar=-1;
        
        System.out.println("");
        System.out.println("______________________________________________________");
        System.out.println("Tienes ");

        for (int i = 0; i < vida; i++) {
            System.out.print("[-]");
        }

        System.out.print(" vidas");

        System.out.println(" y sangre para " + movimientos + " moviemientos");
        System.out.println("______________________________________________________");
        System.out.println("");
        mapa.imprimirMapa(sala, nuevaSala);
        System.out.println("");
        if(Inventario(inventario,objetos)){
            usar=inv.seleccionarUsable(inventario, objetos, teclado);
        }
        System.out.println("");
        
        return usar;
    }
    
    /*
    Signatura: public boolean Inventario (int [] inventario, String [] objetos)
    Descripcion: Imprime los objetos que se encuentren en el inventario y devuelve true en caso de haber objetos usables
    Precondiciones: el array de cadena introducido debe ser el existente en el programa de escape room
    Entradas: array de enteros de objetos que hay en el inventario y array de cadenas con los nombres de cada objeto
    Salida: boleano que es true en caso de existir un objeto usable en tu inventario
    */
    public boolean Inventario (int [] inventario, String [] objetos){
        
        boolean existeUsable=false;
        
        System.out.println("En tu inventario tienes:");
        for(int i=0; i<inventario.length; i++){
            if(inventario[i]>=0){
                System.out.println("\t"+(i+1)+". " + objetos[inventario[i]]);
                if(inventario[i]==3 || inventario[i]==6 || inventario[i]==10 || inventario[i]==13){
                    existeUsable=true;
                }
            }
        }
        
        return existeUsable;
    }

    public void FinPartida(int vida, int movimientos,boolean dificil, boolean ganado, boolean salirJuego){
        System.out.println("");
        if(ganado){
            System.out.println("Enhorabuena, lo has logrado. Parece increible que lo hayas conseguido.");
        }else{
            System.out.println("No esperabamos que ganaras pero tampoco que quedaras así...");
            if (vida<0)
                System.out.println("Agotaste toda tu vida en el juego y en la vida real.");
            if (movimientos<0)
                System.out.println("Agotaste todos tus movimientos, más rápido la proxima vez.");
            if(salirJuego)
                System.out.println("Entendemos que te hayas desesperado.");
            if (dificil)
                System.out.println("Puedes probar a jugar en modo normal.");
        }
    }
    
    public void Salida() {

        System.out.println("");
        System.out.println("El camino más corto era:");
        System.out.println("Inspeccionar sala de mandos/ coger llave doblada/ volver al centro de la sala/ ir a sala reuniones/");
        System.out.println("ir a zona motores/ inspeccionar zona motores/ coger sierra mecanica/ volver al centro de la sala/");
        System.out.println("volver a sala de reuniones/ ir a dormitorios/ir a habitacion 3/ romper candado comoda (sabemos codigo)/");
        System.out.println("                                    (No es necesario papel pero facilita el paso de recordar el codigo)");
        System.out.println("volver al centro de la sala/ volver a sala de reuniones/ volver a sala de mandos/ ir a cocina/");
        System.out.println("volver a empujar puerta/ ir a cantina/ ir a enfermeria/ introducir codigo/ FIN");
        System.out.println("");
        System.out.println("Esperamos que vuelva pronto.");
        System.out.println("¡Que la fuerza te acompañe!");

    }

}
