
package test;

import comprobaciones.Comprobaciones;
import inventario.Inventario;
import java.util.Scanner;
import juegos.Juego;
import mensajes.Mensajes;

public class inventario {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        Comprobaciones comp = new Comprobaciones();
        Mensajes mensaje = new Mensajes();
        Inventario inven = new Inventario();
        Juego juego = new Juego();
        
        int[] inventario;
        inventario = new int[5];
        
        String[] nombreObjetos = new String[]{"Unos restos de cables rotos",
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
        
        for(int i=0; i<inventario.length; i++){
            inventario[i]=7;
        }
        
        mensaje.Inventario(inventario, nombreObjetos);
        
    }
    
}
