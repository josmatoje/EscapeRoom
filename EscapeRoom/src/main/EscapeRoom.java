package main;

import comprobaciones.*;
import mensajes.*;

public class EscapeRoom {
    
    public static void main(String[] args) {
        
        //Declaracion de variables
        boolean respuestaSiNo;
        int zona=0;
        
        int[] inventario = new int[10];
        
        boolean[] objetosUsos= new boolean[20]; //Todos los objetos con la informacion de si han sido cogidos, para que no vuelvan a aparecer en la habitacion
        
        String[] nombreObjetos = new String[]{ "Llaves", //No esta  10:Medicinas 11:Vacunas 12:Curas
                                                "Cables",
                                               "Claves de acceso",
                                                "Comida",
                                                "Sarten",
                                                "Cuchillos",
                                                "Restos de comida",
                                                "Instrucciones de una nave",
                                                 "Casco",
                                                "Boligrafo",
                                                 "Papel",
                                                "Arma",
                                                "Codigo enfermera",
                                                "Medicina coagulante",
                                                "Combustible",
                                                 "Sierra mecanica" };
        /*
        1:Llaves
        2:Cables
        3:Claves de acceso
        
        4:Comida
        5:Sarten
        6:Cuchillos
        
        7:Silla
        8:Restos de comida
        9:Instrucciones de una nave
        
        10: Casco
        11: Boligrafo
        12: Papel
        
        13: Arma
        14: Codigo enfermera
        15: Medicina coagulante
        16: Combustible
        17: Sierra mecanica //" sitios
       
        */
        
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
