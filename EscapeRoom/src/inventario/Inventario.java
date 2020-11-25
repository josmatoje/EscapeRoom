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
    public int[] insertarObjeto (int objeto, int [] inventario, Scanner teclado, String [] nombreObjetos){
        
        Mensajes mensaje = new Mensajes();
        Comprobaciones comp = new Comprobaciones();
        
        boolean insertado = false;
        int longitud = inventario.length;
        boolean mitadInsertada = false;
        int eliminar;
        
        for(int i=0; i<longitud && !insertado; i++){
            
            if (inventario[i]<0){
                
                inventario[i]=objeto;
                if(objeto==14 && !mitadInsertada)//Solo un objeto que ocupa dos huecos
                    mitadInsertada=true;
                else
                    insertado=true;
            }
        }
        
        //
        if(!insertado){
            
            System.out.println("No hay espacio suficiente para insertar el objeto");
            if(objeto==14 && !mitadInsertada){
                System.out.println("¿Desea eliminar DOS de sus objetos?");
            }else{
                System.out.println("¿Desea eliminar UNO de sus objeto?");
            }
            
            System.out.println("");
            if(comp.validacionSiNo(teclado)){
                //repetir hasta insertar
                do{
                    System.out.println("");
                    mensaje.Inventario(inventario,nombreObjetos);
                    System.out.println("¿Que objeto desea eliminar? (Esto será permanente)");
                    System.out.println("(Introduzca el valor numerico)");
                    eliminar=teclado.nextInt();
                    
                    //Comprobamos que no se va a sustituir por el mismo objeto (especialmente valido para objetos que ocupen doble)
                    if(inventario[eliminar-1]!=objeto){
                        
                        inventario[eliminar-1]=objeto;//asignacion del nuevo objeto
                        if(objeto!=14 || mitadInsertada)//Si el objeto es distinto al objeto doble o ya se ha insertado una mitad
                            insertado=true;
                        else
                            mitadInsertada=true;
                        
                    }else{
                        System.out.println("Estas sutituyendo el objeto por si mismo. Seriedad por favor.");
                    }
                    
                }while(!insertado);
            }
            
        }
        
        return inventario;
    }
    
    
}
