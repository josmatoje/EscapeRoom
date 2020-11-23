
package mensajes;

public class Mensajes {
    
    public void Bienvenida(){
        System.out.println("----------------------------------------BIENVENIDO------------------------------------------------");
        System.out.println("");
        System.out.println("Esta usted antes el escape room más espectacular habido en la faz de la tierra.");
        System.out.println("Podrá usted repetirlo tantas veces como quiera realizando runs totalmente independientes una de la otra.");
        System.out.println("Tambien al salir puede volver a este programa si lo desea, eso es evidente.");
        System.out.println("Pues empecemos...");
    }
    
    public void Inicio(){
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
    }
    
    public void Sala(int sala, boolean[] nuevaSala){
        
        
    }
    
    public void Menu(int sala){
        
        switch(sala){
            
            case 0:
                System.out.println("        ********SALA DE MANDOS********");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("¿Qué vas a hacer?");
                System.out.println("1. Inspeccionar estanteria");
                System.out.println("2. Avanzar hasta la cocina");
                System.out.println("3. Avanzar hasta la sala de reuniones");
                System.out.println("4. Avanzar hasta la puerta desconocida");
                System.out.println("");
                System.out.println("5. Estado de la partida");
                System.out.println("6. Salir del juego");
            break;
            
            case 1:
                System.out.println("        ************COCINA************");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("¿Qué vas a hacer?");
                System.out.println("1. Inspeccionar la cocina");
                System.out.println("2. Avanzar hasta la cantina");
                System.out.println("3. Retroceder a la sala de mandos");
                System.out.println("");
                System.out.println("4. Estado de la partida");
                System.out.println("5. Salir del juego");
            break;
            
            case 2:
                System.out.println("        ************CANTINA************");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("¿Qué vas a hacer?");
                System.out.println("1. Inspeccionar cantina");
                System.out.println("2. Avanzar hasta la enfermeria");//O poner otra cosa para que no se sepa
                System.out.println("3. Retroceder a la cocina");
                System.out.println("");
                System.out.println("4. Estado de la partida");
                System.out.println("5. Salir del juego");
            break;
            
            case 3:/*Menú opcional/temporal
                System.out.println("        ***********ENFERMERIA***********");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("¿Qué vas a hacer?");
                System.out.println("1. Inspeccionar enfermeria");
                System.out.println("2. Retroceder a la cantina");
                System.out.println("");
                System.out.println("3. Estado de la partida");
                System.out.println("4. Salir del juego");*/
            break;
            
            case 4:
                System.out.println("        *******SALA DE REUNIONES*******");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("¿Qué vas a hacer?");
                System.out.println("1. Inspeccionar sala de reuniones");
                System.out.println("2. Avanzar hasta los dormitorios");
                System.out.println("3. Avanzar hasta la zona de motores");
                System.out.println("4. Retroceder hasta la sala de mandos");
                System.out.println("");
                System.out.println("5. Estado de la partida");
                System.out.println("6. Salir del juego");
            break;
            
            case 5:
                System.out.println("        *********DROMITORIOS*********");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("¿Qué vas a hacer?");
                System.out.println("1. Inspeccionar dormitorios");
                System.out.println("2. Retroceder a la sala de reuniones");
                System.out.println("");
                System.out.println("3. Estado de la partida");
                System.out.println("4. Salir del juego");
            break;
            
            case 6:
                System.out.println("        ********ZONA DE MOTORES********");
                System.out.println("__________________________________________________");
                System.out.println("Cada acción que elijas es un paso que gastas...");
                System.out.println("¿Qué vas a hacer?");
                System.out.println("1. Inspeccionar zona de motores");
                System.out.println("2. Retroceder a la sala de reuniones");
                System.out.println("");
                System.out.println("3. Estado de la partida");
                System.out.println("4. Salir del juego");
            break;
            
        }
        
    }
    
    public void Estado (int vida, int movimiento){
        
        
        
    }
    
    public void Salida (){
        
        System.out.println("El camino más corto era...");//Completar
        
        System.out.println("Esperamos que vuelva pronto.");
        System.out.println("¡Que la fuerza te acompañe!");
        
    }
}
