package comprobaciones;

import java.util.Scanner;

public class Comprobaciones {
    
    public boolean validacionSiNo () {
    
        char respuesta;
        boolean afirmativo;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduzca S (si)/ N (no)");
        respuesta=teclado.next().toLowerCase().charAt(0);

        while(respuesta!='s' && respuesta!='n'){
            System.out.println("Introduzca S o N");
            respuesta=teclado.next().toLowerCase().charAt(0);
        }
        
        afirmativo = respuesta=='s'; //Si respuesta=='s' afirmativo es true, en caso contrario es false
        
        
        return afirmativo;
    }
    
}
