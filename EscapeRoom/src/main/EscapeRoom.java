package main;

import comprobaciones.*;

public class EscapeRoom {
    
    public static void main(String[] args) {
        
        //Declaracion de variables
        boolean respuestaSiNo;
        
        Comprobaciones comp = new Comprobaciones();
        
        //Mensajes de bienvenida
        System.out.println("            --------------------------------BIENVENIDO----------------------------------------");
        System.out.println("");
        System.out.println("Este usted antes el escape room más espectacular habido en la faz de la tierra.");
        System.out.println("Podrá usted repetirlo tantas veces como quiera realizando runs totalmente independientes una de la otra.");
        System.out.println("Tambien al salir pouede volver a este programa si lo desea, eso es evidente.");
        System.out.println("Pues empecemos...");
        
        //do-while del escape room completo
        do{
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println("Te despiertas, en un cuarto muy oscuro, rodeado de botones de diferentes colores que no ");
            System.out.println("paran de brillar. Ya todo está perdido, viste como caían vuestras últimas naves en este ");
            System.out.println("maldito planeta y al parecer, la tuya tampoco fue una excepción. Aunque en el primer instante");
            System.out.println("te alegres por no haber muerto, se te cambia la cara en un instante al ver en tu ordenador");
            System.out.println("personal que se encuentra en tu mano derecha, que estás perdiendo sangre con cada movimiento");
            System.out.println("que das. Tras unos minutos de espera tu ordenador te indica que solo tienes una probabilidad ");
            System.out.println("del 2% de sobrevivir.");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            
            
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