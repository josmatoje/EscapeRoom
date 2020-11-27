package inventario;

import comprobaciones.Comprobaciones;
import java.util.Scanner;
import mensajes.Mensajes;

public class Inventario {

    /*
    Descripcion: iserta un objeto definido por un valor en un array de enteros en el primer hueco disponible,
            en caso de no caber en ningún hueco pide una posicion en la que insertar el objeto eliminando el
            objeto que se sustituye.
    Precondiciones: el metodo entenderá como lugares disponibles para insertar todo espacio que 
            contenga un valor negativo. El entero 14 será insertado SIEMPRE en dos celdas pidiendo que se
            elimine un objeto en caso necesario
    Entradas: entero que define un objeto, teclado para pedir datos al usuario
    Entrada/Salida: array de enteros que define un inventario
    Postcondiciones: El array devuelto tendrá modificados entre nigún, un espacios o dos en el caso de introducir 
            el entero 14.
     */
    public int[] insertarObjeto(int objeto, int[] inventario, Scanner teclado, String[] nombreObjetos) {

        Mensajes mensaje = new Mensajes();
        Comprobaciones comp = new Comprobaciones();

        boolean insertado = false;
        int longitud = inventario.length;
        int objetoDoble = 14; //Objeto que ocupa dos posiciones se encuentra en la posicion 14;
        boolean mitadInsertada = false;
        int eliminar;

        for (int i = 0; i < longitud && !insertado; i++) {

            if (inventario[i] < 0) {

                inventario[i] = objeto;
                if (objeto == objetoDoble && !mitadInsertada)//Solo un objeto que ocupa dos huecos
                {
                    mitadInsertada = true;
                } else {
                    insertado = true;
                }
            }
        }

        //Si no se ha insertado significa que no hay espacio en el inventario
        if (!insertado) {

            System.out.println("No hay espacio suficiente para insertar el objeto");
            if (objeto == objetoDoble && !mitadInsertada) {
                System.out.println("¿Desea eliminar DOS de sus objetos para meter la sierra?");
            } else {
                System.out.println("¿Desea eliminar UNO de sus objeto?");
            }

            System.out.println("");
            if (comp.validacionSiNo(teclado)) {
                //repetir hasta insertar
                do {
                    System.out.println("");
                    mensaje.Inventario(inventario, nombreObjetos);
                    System.out.println("¿Que objeto desea eliminar? (Esto será permanente)");
                    System.out.println("(Introduzca el valor numerico)");
                    eliminar = teclado.nextInt();

                    //Comprobamos que no se va a sustituir por el mismo objeto (especialmente valido para objetos que ocupen doble)
                    if (inventario[eliminar - 1] != objeto) {

                        inventario[eliminar - 1] = objeto;//asignacion del nuevo objeto
                        if (objeto != objetoDoble || mitadInsertada)//Si el objeto es distinto al objeto doble o ya se ha insertado una mitad
                        {
                            insertado = true;
                        } else {
                            mitadInsertada = true;
                        }

                    } else {
                        System.out.println("Estas sutituyendo el objeto por si mismo. Seriedad por favor.");
                    }

                } while (!insertado);
            } else {//Caso de que no desee borrar ningún objeto, que borre la posible inserción de "medio" objeto que ocupe dos espacios
                if (mitadInsertada) {
                    System.out.println("Eliminando restos de la sierra");
                    for (int i = 0; i < longitud && mitadInsertada; i++) {
                        if (inventario[i] == objetoDoble) {
                            inventario[i] = -1;
                            mitadInsertada = false;

                        }
                    }
                }
            }

        }

        return inventario;
    }

    /*
    Signatura: public boolean comprobarInventario (int objeto, int [] inventario)
    Descripción: comprueba si un objeto está en el inventario y devuelve true en caso afirmativo y false
            en caso contrario
    Precondiciones: se debe introducir valores del programa EscapeRoom para garantizar un resultado optimo
    Entradas: entero que identifica al objeto, array de enteros que identifica al inventario con sus objetos
            correspondientes
    Salida: booleano indicando el resultado
    Postcondiciones: si se introducen objetos que no existen o el array inventario contiene otros datos al no
            encontrar similutedes por defecto devolverá false
     */
    public boolean comprobarInventario(int objeto, int[] inventario) {

        boolean guardado = false;

        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == objeto) {
                guardado = true;
                i = inventario.length;
            }
        }

        return guardado;
    }

}
