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

        String[] NUM_ADIVINAR = new String[]{"000", "011", "101", "001"};// Segun habitacion, tiene un codigo.

        String[] NUMERO_ESCRITO = new String[]{"4369864 al  1100010001010000010*** ", "123123 al 11110000011110***", "5356437 al 10100011011101110010***", "535001 al 10000010100111011"};

        System.out.println("El ordenador ha perdido lo ultimo 3 bits de los numeros de las habitaciones en binario. ");
        System.out.println("Si lo recuperas se te dará acceso a esa habitacion, si no de te bloqueará por 2 minutos lo que te hará perder 3 movimientos");

        System.out.println("Para la habitacion " + habitacion + " se corresponde el siguiente numero y el siguiente fragmento de binario");
        System.out.println(NUMERO_ESCRITO[habitacion - 1]);
        System.out.println("Adivina los ultimo 3 digitos");

        numeroEscrito = teclado.nextLine();
        if (numeroEscrito.equals(NUM_ADIVINAR[habitacion - 1])) {

            adivinado = true;
            System.out.println("Enhorabuena, has conseguido abrir la puerta");
        }else{
            System.out.println("Alguien deberia de repasar la conversion de decimal a binario y lo sabe");
        }

        return adivinado;
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
