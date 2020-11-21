package main;

import comprobaciones.*;
import mensajes.*;

public class EscapeRoom {
    
    public static void main(String[] args) {
        
        //Declaracion de variables
        boolean respuestaSiNo;
        
        Comprobaciones comp = new Comprobaciones();
        Mensajes mensaje = new Mensajes();
        
        //Mensajes de bienvenida
        System.out.println("            --------------------------------BIENVENIDO----------------------------------------");
        System.out.println("");
        System.out.println("Este usted antes el escape room más espectacular habido en la faz de la tierra.");
        System.out.println("Podrá usted repetirlo tantas veces como quiera realizando runs totalmente independientes una de la otra.");
        System.out.println("Tambien al salir pouede volver a este programa si lo desea, eso es evidente.");
        System.out.println("Pues empecemos...");
        
        //do-while del escape room completo
        do{
            
            mensaje.mensajeInicio();
            
            //If-else de dificultad
            int movimientos = 120, vida = 100;  //movimiento por minuto vida puede no ser necesaria(?) por como planteamos el juego
            
            //Vida inicial y movimientos
            System.out.println("");

            //Menu principal
            System.out.println("---MENU PRINCIPAL---");
            System.out.println("");
        
            respuestaSiNo = comp.validacionSiNo();
            
        }while(respuestaSiNo);
        
        System.out.println("Esperamos que vuelva pronto.");
        System.out.println("¡Que la fuerza te acompañe!");
        
    }
    
}
