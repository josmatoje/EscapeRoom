package main;

import comprobaciones.*;
import mensajes.*;

public class EscapeRoom {
    
    public static void main(String[] args) {
        
        //Declaracion de variables
        boolean respuestaSiNo;
        int zona=0;
        
        Comprobaciones comp = new Comprobaciones();
        Mensajes mensaje = new Mensajes();
        
        mensaje.mensajeBienvenida();
        
        //do-while del escape room completo
        do{
            
            mensaje.mensajeInicio();
            
            //If-else de dificultad
            int movimientos = 120, vida = 100;  //movimiento por minuto vida puede no ser necesaria(?) por como planteamos el juego
            
            
            
            //Vida inicial y movimientos
            System.out.println("");

            mensaje.mensajesMenu(zona);
        
            respuestaSiNo = comp.validacionSiNo();
            
        }while(respuestaSiNo);
        
        System.out.println("Esperamos que vuelva pronto.");
        System.out.println("¡Que la fuerza te acompañe!");
        
    }
    
}
