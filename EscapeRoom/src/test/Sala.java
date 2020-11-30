/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Scanner;
import comprobaciones.Comprobaciones;

import juegos.Juego;


public class Sala {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        boolean llaveRecta = false;
        Comprobaciones comp = new Comprobaciones();
        Juego juego = new Juego();
           
        
        
        
         do {

                                                llaveRecta = juego.Llave(teclado);
                                                if (llaveRecta) {

                                                    System.out.println("De los mejores momentos de tu vida, te has sentido un verdadero troglodita de la prehistoria descubriendo las herramientas");
                                                  
                                                } else {
                                                    System.out.println("No lo has conseguido y has perdido tres movimientos,deseas volver a repetirlo?");
  
                                                }

                                            } while (!llaveRecta && comp.validacionSiNo(teclado));
        
        
        
    }
    
    
}
