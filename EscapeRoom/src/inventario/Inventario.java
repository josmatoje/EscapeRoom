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
                    if(inventario[eliminar-1]!=objeto){
                        
                        if(inventario[eliminar-1]!=8){//casco no se puede desequipar
                            inventario[eliminar-1]=objeto;//asignacion del nuevo objeto
                            if(objeto!=objetoDoble || mitadInsertada)//Si el objeto es distinto al objeto doble o ya se ha insertado una mitad
                                insertado=true;
                            else
                                mitadInsertada=true;
                        }else{
                            System.out.println("No consigues quitarte el casco, tendrás que dejar atrás otro objeto.");
                        }
                        
                    }else{
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
    
    /*
    Signatura: public int usarObjeto (int [] inventario, String [] objetos, Scanner teclado)
    Descripción: el metodo pregunta si se quiere usar un objeto y en caso afirmativo selecciona un objeto del 
            inventario del jugador (validado) y devuelve la posicion donde se encuentra en el array
    Precondiciones: se debe introducir valores del programa EscapeRoom para garantizar un resultado optimo.
            Solo se puede llamar a este metodo si existe un objeto usable en el inventario (3, 6, 10, 13)
    Entradas:  array de enteros que identifica al inventario con sus objetos correspondientes
            y array de cadenas con los nombres de cada objeto
    Salida: entero que indica que objeto del inventario se quiere usar
    Postcondiciones: debe devolver un objeto usable, no puedes no seleccionar nigun objeto tras decidir usar alguno
    */
    public int seleccionarUsable (int [] inventario, String [] objetos, Scanner teclado){
        
        Comprobaciones comp = new Comprobaciones();
        Mensajes mensaje = new Mensajes();
        
        int usar = -1;
        
        System.out.println("¿Desea usar algun objeto?");
        if(comp.validacionSiNo(teclado)){
            System.out.println("¿Que objeto desea usar?");
            do{
                mensaje.Inventario(inventario, objetos);
                if(usar!=-1)
                    System.out.println("Introduzca un objeto usable");
                usar=teclado.nextInt();
                if(inventario.length==5)
                    usar=comp.valorEntrenym(usar, 1, 5, teclado);
                else//Modo normal --> longitud = 7
                    usar=comp.valorEntrenym(usar, 1, 7, teclado);
                usar--;
            }while((inventario[usar]!=3 || inventario[usar]!=6 || inventario[usar]!=10 || inventario[usar]!=13));
            //Si usar <0 al comprobar bucle dara error en el array
        }
        
        return usar;
        
    }
    /*
    Signatura: public boolean usarLata (int [] inventario, Scanner teclado)
    Descripcion: este metodo comprueba que puedas abrir la lata de comida con los objetos de tu inventario
    Precondiciones: deben usarse valores correspondientes a un inventario del juego EscapeRoom
    Entrada: array de enteros que representan el inventario y un objeto del tpo Scanner
    Salida: un boleano que será true en caso de tener un cuchillo en el inventario
    Postcondiciones: este metodo no modifica valores en el programa principal
    */
    public boolean usarLata (int [] inventario, Scanner teclado){
        
        Comprobaciones comp = new Comprobaciones();
        
        boolean usado=false;
        
        if(comprobarInventario(5, inventario)){//si tiene el cuchillo
            System.out.println("¿Quieres usar el cuchillo para comerte la lata?");//Implementar:(probabilidad baja de romper cuchillo)
            if(comp.validacionSiNo(teclado)){
                usado=true;
                System.out.println("La comida de tus sueños no es especialmente nutritiva pero te da la sensacion de ser");
                System.out.println("mucho más agil");
                System.out.println("Ganas uno de vida (+1) y cinco movimientos (+5)");
            }
        }else{
            System.out.println("No tienes nada para poder abrirla en tu inventario.");
        }
        
        return usado;
    }
    
    public String usarPapel (Scanner teclado){
        
        String mensaje = "Papel: \"";
        
        System.out.println("¿Que frase quiere apuntar?");
        teclado.nextLine();
        mensaje+=teclado.nextLine()+"\"";
        System.out.println("Ahora en tu inventario aparecerá tu objeto seguido de una frase.");
        System.out.println(mensaje);
        
        return mensaje;
    }
    /*
    Signatura: public int[] eliminarObjeto (int objeto, int [] inventario)
    Descripcion: este metodo elimina un objeto del array inventario y lo devuelve sin este
    Precondiciones: deben usarse valores correspondientes a un inventario del juego EscapeRoom
    Entrada:  un objeto de tipo entero que representa el objeto a eliminar
    Entrada/Salida: un array de enteros que representa el inventario y sale sin el objeto pasado por parametros
    Postcondiciones: --
    */
    public int[] eliminarObjeto (int objeto, int [] inventario){
        
        for(int i=0; i<inventario.length; i++){
            if(inventario[i]==objeto){
                inventario[i]=-1;
                if(objeto!=14){
                    i=inventario.length;
                }
            }
        }
        
        return inventario;
    }
    
}
