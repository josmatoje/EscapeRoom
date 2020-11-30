package comprobaciones;

import java.util.Scanner;

public class Comprobaciones {
    
    /*
    Metodo que pregunta Si o No y devuelve true en caso de seleccionar si o false en caso contrario
        Signatura: public boolean validacionSiNo () 
        Precondiciones: --
        Entrada: objeto de la clase Scanner
        Salida: boleano 
        Postcondiciones:--
    */
    public boolean validacionSiNo (Scanner teclado) {
    
        char respuesta;
        boolean afirmativo;
        
        
        System.out.println("Introduzca S (si)/ N (no)");
        respuesta=teclado.next().toLowerCase().charAt(0);

        while(respuesta!='s' && respuesta!='n'){
            System.out.println("Introduzca S o N");
            respuesta=teclado.next().toLowerCase().charAt(0);
        }
        
        afirmativo = respuesta=='s'; //Si respuesta=='s' afirmativo es true, en caso contrario es false
        
        return afirmativo;
    }
    
    public boolean dificultad(Scanner teclado){
        
        System.out.println("Por defecto el juego está en dificultad media.");
        System.out.println("¿Desea jugar en modo dificl (menos vida y menos turnos)?");
        
        return validacionSiNo(teclado);
    }
    
    public int eleccionMenuPrincipal(int sala, Scanner teclado){
        
        int eleccion=0;
        
        eleccion=teclado.nextInt();
        
        switch(sala){
            case 0: valorEntre1y6(eleccion, teclado);
            break;
            
            case 1: valorEntre1y5(eleccion, teclado);
            break;
            
            case 2: valorEntre1y5(eleccion, teclado);
            break;
            
            case 3: 
                System.out.println("Enfermeria - No action");
            break;
            
            case 4: valorEntre1y6(eleccion, teclado);
            break;
            
            case 5: valorEntre1y4(eleccion, teclado);
            break;
            
            case 6: valorEntre1y4(eleccion, teclado);
            break;
            
        }
        
        return eleccion;
    }
    
    public int eleccionMenuInteraccion(int sala, Scanner teclado){
        
        int eleccion=0;
        
        eleccion=teclado.nextInt();
        
        /*
        Usamos if-else porque con un switch se repetiria más codigo
        Solucion subprogramas que sean while(eleccion<a || eleccion>b) y se llamen en funcion del 
        numero de elecciones que tenga el menu
        */
        if (sala==5){
            valorEntre1y7(eleccion, teclado);
        }else{
            valorEntre1y6(eleccion, teclado);
        }
        
        return eleccion;
    }
    /*
    Metodos que comprueban si el valor dado está entre uno y un valor 
        Signatura: public int valorEntre1y... (int eleccion, Scanner teclado) 
        Precondiciones: --
        Entrada: objeto de la clase Scanner
        Entrada/Salida: Entero que representa la eleccion (validada al salir) 
        Postcondiciones: el numero debe ser >0 y menos o igual que el valor maximo
    */

    public int valorEntrenym(int eleccion, int valorInicial, int valorFinal Scanner teclado){
        while(eleccion<=valorInicial || eleccion>=valorFinal){
            System.out.println("Introduzca un valor válido (de " + valorInicial + " a " + valorFinal + "): ");
            eleccion=teclado.nextInt();
        }
        return eleccion;
    }

    public int valorEntre1y3(int eleccion, Scanner teclado){
        while(eleccion<1 || eleccion>3){
            System.out.println("Introduzca un valor válido (de 1 a 3): ");
            eleccion=teclado.nextInt();
        }
        return eleccion;
    }
    
    
    public int valorEntre1y4 (int eleccion, Scanner teclado){
        while(eleccion<1 || eleccion>4){
                System.out.println("Introduzca un valor válido (de 1 a 4): ");
                eleccion=teclado.nextInt();
            }
        return eleccion;
    }
    
    public int valorEntre1y5 (int eleccion, Scanner teclado){
        while(eleccion<1 || eleccion>5){
                System.out.println("Introduzca un valor válido (de 1 a 5): ");
                eleccion=teclado.nextInt();
            }
        return eleccion;
    }
    
    public int valorEntre1y6 (int eleccion, Scanner teclado){
        while(eleccion<1 || eleccion>6){
                System.out.println("Introduzca un valor válido (de 1 a 6): ");
                eleccion=teclado.nextInt();
            }
        return eleccion;
    }
    
    public int valorEntre1y7 (int eleccion, Scanner teclado){
        while(eleccion<1 || eleccion>7){
                System.out.println("Introduzca un valor válido (de 1 a 7): ");
                eleccion=teclado.nextInt();
            }
        return eleccion;
    }
    
}
