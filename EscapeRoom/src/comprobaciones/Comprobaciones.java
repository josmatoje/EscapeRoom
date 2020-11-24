package comprobaciones;

import java.util.Scanner;

public class Comprobaciones {
    
    
    /*
    Metodo que pregunta Si o No y devuelve true en caso de seleccionar si o false en caso contrario
        Signatura: public boolean validacionSiNo () 
        Precondiciones: --
        Entrada: --
        Salida: boleano 
        Postcondiciones:--
    */
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
        
        teclado.close();
        
        return afirmativo;
    }
    
    public boolean dificultad(){
        
        System.out.println("Por defecto el juego está en dificultad media.");
        System.out.println("¿Desea jugar en modo dificl (menos vida y menos turnos)?");
        
        return validacionSiNo();
    }
    
    public int eleccionMenuPrincipal(int sala){
        
        int eleccion=0;
        Scanner teclado = new Scanner(System.in);
        
        eleccion=teclado.nextInt();
        
        if (sala==0 || sala ==4){
            while(eleccion<1 || eleccion>6){
                System.out.println("Introduzca un valor válido (de 1 a 6): ");
                teclado.nextInt();
            }
        }else{
            if(sala==1||sala==2){
                while(eleccion<1 || eleccion>5){
                    System.out.println("Introduzca un valor válido (de 1 a 5): ");
                    teclado.nextInt();
                }
            }else{
                while(eleccion<1 || eleccion>4){
                    System.out.println("Introduzca un valor válido (de 1 a 4): ");
                    teclado.nextInt();
                }
            }
        }
        
        teclado.close();
        
        return eleccion;
    }
    
    public int eleccionMenuInteraccion(int sala){
        
        int eleccion=0;
        Scanner teclado = new Scanner(System.in);
        
        eleccion=teclado.nextInt();
        
        //Valorar cada menu
        
        teclado.close();
        
        return eleccion;
    }
    
}
