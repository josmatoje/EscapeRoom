package juegos;

import comprobaciones.Comprobaciones;
import java.util.Random;
import java.util.Scanner;



public class Juego {
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
