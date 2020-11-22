package main;

import comprobaciones.*;
import mensajes.*;

public class EscapeRoom {
    
    public static void main(String[] args) {
        
        //Declaracion de variables
        boolean respuestaSiNo;
        int zona=0;
        String objeto1="", objeto2="";//Declaracion de todos los objetos
        String[] objetos= new String[10];
        
        Comprobaciones comp = new Comprobaciones();
        Mensajes mensaje = new Mensajes();
        
        mensaje.Bienvenida();
        
        //do-while del escape room completo
        do{
            
            mensaje.Inicio();
            
            //If-else de dificultad
            int movimientos = 120, vida = 100;  //movimiento por minuto vida puede no ser necesaria(?) por como planteamos el juego
            
            
            
            //Vida inicial y movimientos
            System.out.println("");

            mensaje.Menu(zona);
        
            
            
            System.out.println("Desea volver a intentarlo?");
            respuestaSiNo = comp.validacionSiNo();
            
        }while(respuestaSiNo);
        
        mensaje.Salida();
        
        
    }
    
}
