package escaperoom;

import comprobaciones.Comprobaciones;

public class EscapeRoom {
    
    public static void main(String[] args) {
        
        //Declaracion de variables
        boolean respuestaSiNo;
        
        Comprobaciones comp = new Comprobaciones();
        
        //Mensajes de bienvenida
        System.out.println("");
        
        do{
            
            //Vida inicial y movimientos
            System.out.println("");

            //Menu principal
            System.out.println("---MENU PRINCIPAL---");
            System.out.println("");
        
            respuestaSiNo = comp.validacionSiNo();
            
        }while(respuestaSiNo);
        
    }
    
}
