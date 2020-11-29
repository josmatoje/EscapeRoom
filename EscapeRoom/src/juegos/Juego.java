package juegos;


import comprobaciones.Comprobaciones;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    /*
    Signatura: public boolean Binario(Scanner teclado)
    Descripcion: El usuario se le pondrá un numero en decimal y otro igual en binario del cuál tendrá que adivinar los cuatro ultimos digitos.
    Precondiciones: 
    Entradas: scanner, numero de la habitacion
    Salidas: si has conseguido abrir la puerta.
    
     */
    public boolean Binario(Scanner teclado, int habitacion) {

        boolean adivinado = false;
        
        String numeroEscrito;

        String[] NUM_ADIVINAR = new String[]{"000", "000", "010", "100"};// Segun habitacion, tiene un codigo.

        String[] NUMERO_ESCRITO = new String[]{"129 a 10000***", "96 a 1100***", "98 a 1100***", "260 al 10000010100111***"};

        System.out.println("El ordenador ha perdido lo ultimo 3 bits de los numeros de las habitaciones en binario. ");
        System.out.println("Si lo recuperas se te dará acceso a esa habitacion, si no de te bloqueará por 2 minutos lo que te hará perder 3 movimientos");

        System.out.println("Para la habitacion " + habitacion + " se corresponde el siguiente numero y el siguiente fragmento de binario");
        System.out.println(NUMERO_ESCRITO[habitacion - 1]);
        System.out.println("Adivina los ultimo 3 digitos");

        teclado.nextLine();//"Resetea el teclado" (reset no funciona)
        numeroEscrito = teclado.nextLine();
        
        if (numeroEscrito.equals(NUM_ADIVINAR[habitacion - 1])) {

            adivinado = true;
            System.out.println("Enhorabuena, has conseguido abrir la puerta eres un verdadero hacker");
        }else{
            System.out.println("Alguien deberia de repasar la conversion de decimal a binario y lo sabe");
        }

        return adivinado;
     
    }
    
    /*
    Signatura:  public boolean Cables(Scanner teclado)
    Descripcion: Mostrara en pantalla un array de strings que van a ser dividos por saltos de linea segun el numero de strings que se lleve * 2
    El usuario debera de adivinar que el unico sitio unido al nucleo es el 1
    Entradas: Scanner
    Salidas: Si se ha comletado el juego
    
    */
    
    
    
    public boolean Cables(Scanner teclado){
    
        boolean completado = false;
        int camino;
        Comprobaciones comp = new Comprobaciones();
        
        
        System.out.println("Los cables se han roto y tienes que seguir la trazada del a camino de las letras hasta el nucle e indicarle a tu ordenador que numero de bateria es la indicada (3, 2, 1)");
        System.out.println("La señal no va muy bien  por lo que la imagen de la trazada va por partes,");
        System.out.println("");
        System.out.println("Deseas empezar? Pulse S");
        
        if(comp.validacionSiNo(teclado)) //SI quiere empezar el juego
       
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        String[] imagen = new String[]{
"dddddddddddddddddddddddxc.      .cxdddddddddddddddddddddddo'           .okkkkkkkkkkkkkkkkkkkkkkkkkkk\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMO.      '0MMMMMMMMMMMMMMMMMMMMMMMMN:           '0MMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMO.      '0MMMMMMMMMMMMMMMMMMMMMMMMN:           '0MMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMM   CAMINO  MMMMMMO.      '0MMMMMM   CAMINO   MMMMMMN:           '0MMMMMMMMM   CAMINO    MMMMM\n" +
"MMMMMMN0ONMXOKWWKOXMMMMMO.      '0MMMMMNOdKMMMMMNkoxXMMMMMN:           '0MMMMMMMMMMMMMMWNWMMMMMMMMMM\n" +
"MMMMMMO  kWo ;XX; dMMMMMO.      '0MMMMMX   MMMMM0   xMMMMMN:           '0MMMMMMMMMMMMMNo'xWMMMMMMMMM\n" +
"MMMMMMO  kWo ;XK, oMMMMMO.      '0MMMMMX;  MMMMMO. .xMMMMMN:           '0MMMMMMMMMMMMMX; lWMMMMMMMMM\n" +
"MMMMMMO  kWo ;XK; oMMMMMO.      '0MMMMMX;  MMMMMO. .xMMMMMN:           '0MMMMMMMMMMMMMX; lWMMMMMMMMM\n" +
"MMMMMMO  kMo ;XK; oMMMMMO.      '0MMMMMX;  MMMMMO. .xMMMMMN:           '0MMMMMMMMMMMMMX; lWMMMMMMMMM\n" +
"MMMMMM0  OMd  XX  dMMMMMO.      '0MMMMMX   MMMMMK   OMMMMMN:           '0MMMMMMMMMMMMMX; lWMMMMMMMMM\n" +
"MMMMMMWKKNMN0XWWX0NMMMMMO.      '0MMMMMMWNWMMMMMWNNNWMMMMMN:           '0MMMMMMMMMMMMMWOd0MMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMO.      '0MMMMMMMMMMMMMMMMMMMMMMMMN:           '0MMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMO.      '0MMMMMMMMMMMMMMMMMMMMMMMMN:           '0MMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMO.      '0MMMMMMMMMMMMMMMMMMMMMMMMN:           '0MMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMW0xxxxxxxxxxxxxxxxxxxc.      .;ccccccllkWMMMMWkccccccccc.           .cooooooooooooxXMMMMKdooooooo\n", // coma
"MMMN:                                     :NMMMMN:                                   '0MMMMx.       \n" +
"MMMN:                                     :NMMMMNc .   ......   ....                 '0MMMMx.       \n" +
"MMMN:                                     :NMMMMWX000000000000000000x'               '0MMMMx.       \n" +
"MMMN:                                     :NMMMMMMMMMMMMMMMMMMMMMMMMK,               '0MMMMx.       \n" +
"MMMN:                                     :XWWWWWWWWWWWWWWWWWWWWMMMMK,               '0MMMMx.       \n" +
"MMMNl............                         .''''''''''''''''''''dWMMMX;               '0MMMMx.       \n" +
"MMMMXKKKKKKKKKKKKo.                                            :NMMMX;               '0MMMMx.       \n" +
"MMMMMMMMMMMMMMMMMx.                                            cNMMMX;               '0MMMMx.       \n" +
"WWWWNNNNNNWMMMMMMx.      .,;;;;;;;;;;;;;;;;;;;;;;;,.           :NMMMX;               '0MMMMx.       \n" +
"'''''..'.;OMMMMMMd       ;XMWMMMMMMMMMMWWMWWWMMMMNK:           cNMMMX;               '0MMMMx.       \n" +
"         .xMMMMMMd       ;XMMMWWWWWWWWWWNNNWWWWMMNK:           cNMMMX;               '0MMMMx.       \n" +
"         .xMMMMMMd       ;XMMNo'''''''''''''';OMMWN0xddxddddddx0WMMMX;               '0MMMMx.       \n" +
"         .xMMMMMMd       ;XMMX;              .xMMMMMMMMMMMMMMMMMMMMMX;               '0MMMMx.       \n", // coma
"         .xMMMMMMd       ;XMMX;               :xxxxxxxxxxxxxxxxxkkkkd'               '0MMMMx.       \n" +
"         .xMMMMMMd       ;XMMX;                                                :kxkkxONMMMMx.       \n" +
"         .xMMMMMMd       ;XMMX:                                               .xMMMMMMMMMMMx.       \n" +
".'''''''';OMMMMMMd       ;XMMN:                                                dMMMMMMNXXXXo.       \n" +
"kNNNNNNNNWWMMMMMMd       ;XMMX:                                                dMMMMMWo.....        \n" +
"OMMMMMMMMMMMMMMMMd       ;XMMNo'''''''''''''''''.                              dMMMMMN:             \n" +
"OMMMMMMMMMMMMMMMMd       ;XMMMWNNNNNNNNNNNNNNNNNd          .:lllllllllllllllllo0MMMMMN:             \n" +
"lkxkkkkkxkXMMMMMMd       ;XMMMMMMMMMMMMMMMMMMMMMO;'''''.   ,KMMMMMMMMMMMMMMMMMMMMMMMMN:             \n" +
"         .xMMMMMMd       ;XMMMMMMMMMMMMMMMMMMMMMWWWWWWX:   ,KMMMMMMMMMMMMMMMMMMMMMMMMN:             \n" +
"         .xMMMMMMd       ;XMMMMMMMMMMMMMMMMMMMMMMMMMMMN:   .dOOOOOOOOOOOOOOOOOOXMMMMMN:             \n" +
"         '0MMMMMMd       .:ccccccccccccccccccccdNMMMMMN:                      .dMMMMMN:             \n" +
"         ,KMMMMMMd                             ,KMMMMMN:                       dMMMMMN:             \n" +
"         ,KMMMMMMd        ....                 ,KMMMMMN:                       dMMMMMN:             \n" +
"         ;KMMMMMMd      .oKKK0;                ,KMMMMMN:                       dMMMMMN:             \n", // coma 
"     :OOOKWMWx:;:.      .xMMMWc                ,KMMMMMN:                       dMMMMMNc             \n" +
"     oMMMMMMX;          .xMMMWc                ,KMMMMMNc                       dMMMMMW0xxxxxxxxxxxxx\n" +
"     oMMMMMMX;          .xMMMWc                ,KMMMMMWKOOOOOOOOOOOOOc         dMMMMMMMMMMMMMMMMMMMM\n" +
"     oMMMMMMX;          .xMMMWc                ,KMMMMMMMMMMMMMMMMMMMMd.        dMMMMMMMMMMMMMMMMMMMM\n" +
"     oMMMMMMX;          .kMMMWo................:KMMMMMWXOOOOOOOOO00OOc         oNNNNNNXXXXXXXNMMMMMM\n" +
"     oMMMMMMX;          .OMMMMX0000000000000000XWMMMMMNc                       ..............dMMMMMN\n" +
"     oMMMMMMX;          .OMMMMMMMMMMMMMMMMMMMMMMMMMMMMN:                                     lWMMMMN\n" +
"     oMMMMMMX;          .OMMMMMMMMMMMMMMMMMMMMMMMMMMMMN:                                     lWMMMMN\n" +
"     oMMMMMMX;           ,::::::::::::::::::::ckWMMMMMX;             .:llllll:.              lWMMMMN\n" +
"     oWMMMMMX;                                 cWMMMMMK,             '0MMMMMM0'              lWMMMMN\n" +
"     dMMMMMMWOooddoodxxxxxxxxxxxxxxxxxxxxc.    cWMMMMMK,             '0MMMMMM0'              lWMMMMN\n" +
"    .xMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO.    cWMMMMMK,             '0MMMMMM0'              lWMMMMN\n" +
"     ;oooooooooooooodddddddddddddddddxXMMk.    cWMMMMMK,             '0MMMMMM0'              lWMMMMN\n",
"                                     .xMMd     cWMMMMMK,      ;ddddddkNMMMMMMNkdddddddddddddd0MMMMMN\n" +
"                                     .xMMd     cWMMMMMK,     .xMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN\n" +
"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOl.  .xMMd     cWMMMMMK,     .xMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMk.  .xMMd     ,xkkkXMNO:.   .xMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN\n" +
"MMMMMMMMMMN0kdolllodx0NWMMMMMMMMMk.  .xMMd         .dMMMk.    dMMMO:;;;;;;:;xNMMMOc;;;;;;;;;:kMMMMMN\n" +
"MMMMMMMXx:..          .:dKWMMMMMMk.  .oKKl          dMMMk.    dMMMd         ;XMMMd           lWMMMMN\n" +
"MMMMMXo.                 .lKMMMMMk.   ....          dMMMk.    dMMMo         ;XMMMd           lWMMMMN\n" +
"MMMWO'                     'kWMMMk.                 oWWk'     ;kkk;         ;XMMM0c.         lWMMMMN\n" +
"MMM0'                       .OMMMk.                 lWWc                    ;XMMMMWl         'lllllc\n" +
"MMWo         NUCLEO          lWMMk.     ............oWWo...............     ;XMMMMWl                \n" +
"MMWl                         cNMMk.   'x000000000000XMMX000000000000000o.   ;KWMMMWl                \n" +
"MMMk.                       .xMMMk.   ,ONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNx.    'oXMMWl                \n" +
"MMMNo.                      lNMMMk.                                           ;KMMWl                \n" +
"MMMMNk,                   'xNMMMM0c;;;;;;;;;;;;;,. ...........................:XMMWd... .cdddddl.   \n" +
"MMMMMMXx;.             .;dXMMMMMMMWMMMMMMMMMMMMMWX0000000000000000000000000000XWMMMX0000KNMMMMMK,   \n" +
"MMMMMMMMWKko:;''..',:oxKWMMMMMMMMXxoooooooodxxxkKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM0'   \n" +
"MMMMMMMMMMMMMWNXXXNWMMMMMMMMMMMMMk.                                                                    "};
        
        
        
        
        
        for (int i = 0; i < imagen.length; i++) {
            System.out.println(imagen[i]);
            for (int j = 0; j < i*2; j++) {
                System.out.println("");
            }
        }
        
        
        System.out.println("POr cual camino deberia de ir la electricidad? 3, 2 o 1");
        camino = teclado.nextInt();
        camino = comp.valorEntre1y3(camino, teclado);
        if(camino == 1){
        
            completado = true;
            System.out.println("Lo has conseguido, aunque a tu cerebro le falten 3 litros de sangre sigue viendo minimamente");
        
        }else{
        
            System.out.println("Hay que ser muy malo para fallar en una cosa tan facil");
        
        }
          
    return completado;
    
    }


    /*
    Signatura:  public boolean Llave(Scanner teclado)
    Descripcion: Juego de la llave, se controlara mediante un bucle controlado por bandera o flag y contado. Si se consigue restar/sumar la cantidad exacta 
    a al dobladez o se llega al maximo de 5 intentos
    Precondiciones: 
    Entradas:scanner
    Salidas: si la llave sigue doblada o no 
    
    
     */
    public boolean Llave(Scanner teclado) {

        Random rd = new Random();

        int dobladez, signo, golpe, golpes = 5;
        boolean firme = false;
        char lado;
        Comprobaciones comp = new Comprobaciones();
        String[] estado = new String[]{"totalmente a la izquierda", "mucho a la izquierda", "medio a la izquierda", " un poco a la izquierda", "casi nada a la izquierda", "perfectamente", "casi nada a la derecha", " un poco a la derecha", "medio a la derecha", "mucho a la derecha", "totalmente a la derecha"};

        do {
            dobladez = rd.nextInt(10);
        } while (dobladez == 5);

        System.out.println("La llave esta  doblada " + estado[dobladez] + "tu objetivo  es mediante golpes, ponerla bien. \n"
                + " La fuerza que puedes emplear en cada golpe puede ser de maximo 5 de potencia, pero tienes que"
                + " tener cuidado ya que puedes pasarte y se puede doblar para el otro lado. \n"
                + " Tienes un maximo de 5 golpes antes de cansarte y perder 3 pasos. ");

        do {

            System.out.println("La llave se encuentra " + estado[dobladez] + ". De cuanta potencia quieres que sea tu proximo golpe(maximo 5)? Ten en cuenta que solo te quedan " + golpes + " golpes");
            golpe = teclado.nextInt();
            golpe = comp.valorEntre1y5(golpe, teclado);

            do {
                System.out.println("Hacia que lado? d)derecha o i)izquierda?");
                lado = Character.toUpperCase(teclado.next().charAt(0));
            } while (lado != 'I' && lado != 'D');

            if (lado == 'I') {

                dobladez = dobladez - golpe;

            } else {

                dobladez = dobladez + golpe;

            }

            if (dobladez > 10 || dobladez < 0) { // Se se pasa con el golpe que lo ponga random

                do {
                    dobladez = rd.nextInt(10);
                } while (dobladez == 5);

            }

            --golpes;

            if (dobladez == 5) {

                firme = true;

                System.out.println("Lo has conseguido, menuda precision.");

            }

        } while (!firme && golpes > 0);

        return firme;
    }
}
