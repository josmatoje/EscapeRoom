
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
    
    public void Menu(int habitacion){
        
        
        
    }
    
    public void Estado (int vida, int movimiento){
        
        System.out.println("Tienes ");

        for (int i = 0; i < vida; i++) {
            System.out.print("[-]");
        }

        System.out.print(" vidas");

        System.out.println(" y sangre para " + movimientos+" moviemientos");
       
    }
    
    public void Salida (){
        
        System.out.println("El camino más corto era...");//COmpletar
        
        System.out.println("Esperamos que vuelva pronto.");
        System.out.println("¡Que la fuerza te acompañe!");
        
    }
    
    
    public void mensajeNuevaSala(int sala, boolean salaVisitada[]){

        
          switch(sala){
          
              case 0: System.out.println("Al abrir los ojos observas muchos escombros y objetos destrozados,"
                      + " decides levantarte para observar un poco mejor la situación.");
              
              case 1: System.out.println("Entras en la cocina, sin fuerza ninguna pero el olor a salsa barbacoa te hace olvidar que estás perdiendo sangre con cada paso que das."
                      + "  Ese olor te lleva a un pobre gato quemándose en las tuberías.");
              
              case 2: System.out.println("La cantina parece mucho mejor que la cocina,"
                      + " aunque también tengan sus zonas de quema por fuga de gas.");
              
              case 3: System.out.println("Enoncontraste la enfermeria y parece que las maquinas de mantenimiento de"
                      + " vida parecen intactas. Aunque no se recomienda su uso sin el personal autorizado,"
                      + "esta ocasion de vida o muerte no te deja otra opcion. Con tu mirada nublada tardas unos minutos"
                      + "en entender el funcionamiento y como ponerla en analisis corporal completo. Al finalizar el"
                      + "analisis la maquina encuentra todos tus problemas e te inivta a entrar en ella abriendo la puerta."
                      + "Ya dentro, tras curar tus neuronas recuerdas que el comandante fuiste tu y que toda la flota"
                      + "fue a la muerte por tu decision suicida de ir a por todas. Finalmente tu corazon no resiste el "
                      + "impacto emocional y se para. La maquina te lo vuelve a curar, mandandote al mismo pensamiento, lo "
                      + "que te causa otra muerte dolorosa y emocional y asi indefinidas veces, sin poder morir, sintiendo"
                      + "la angustia infinita de matarlos a todos.");
               
              case 4: System.out.println("  Dentro de la sala todo parece como si no hubiera pasado nada y es que las paredes blindadas"
                      + " y la protección contra los rayos ionizantes dan su fruto");
          
          
              case 5: System.out.println("Todo parece tranquilo, como si no hubiera pasado nada."
                      + " Ves varias habitaciones cerradas pero la mayoría están abiertas.");
          
              
              case 6: System.out.println("Es la primera vez que entras aquí, ves muchas puertas cerradas"
                      + " de lo que entiendes son cosas de motores");
          
          }
        
        
    
    }
    
      public void mensajeSala(int sala, boolean salaVisitada[], boolean objetosObtenidos[]){

        
        
        if( !salaVisitada[sala]){ //si la sala no esta visitada, primer Mensaje 
        
          switch(sala){
          
              case 0: System.out.println(
                      "Al abrir los ojos observas muchos escombros y objetos destrozados,"
                      + " decides levantarte para observar un poco mejor la situación.");
              
              break;
              
              
              case 1: System.out.println(
                      "Entras en la cocina, sin fuerza ninguna pero el olor a salsa barbacoa te hace olvidar que estás perdiendo sangre con cada paso que das."
                      + "  Ese olor te lleva a un pobre gato quemándose en las tuberías.");

              break;
              
              
              
              case 2: System.out.println(
                      "La cantina parece mucho mejor que la cocina,"
                      + " aunque también tengan sus zonas de quema por fuga de gas.");
           
              break;
              
              
              case 3: System.out.println(
                      "Enoncontraste la enfermeria y parece que las maquinas de mantenimiento de"
                      + " vida parecen intactas. Aunque no se recomienda su uso sin el personal autorizado,"
                      + "esta ocasion de vida o muerte no te deja otra opcion. Con tu mirada nublada tardas unos minutos"
                      + "en entender el funcionamiento y como ponerla en analisis corporal completo. Al finalizar el"
                      + "analisis la maquina encuentra todos tus problemas e te inivta a entrar en ella abriendo la puerta."
                      + "Ya dentro, tras curar tus neuronas recuerdas que el comandante fuiste tu y que toda la flota"
                      + "fue a la muerte por tu decision suicida de ir a por todas. Finalmente tu corazon no resiste el "
                      + "impacto emocional y se para. La maquina te lo vuelve a curar, mandandote al mismo pensamiento, lo "
                      + "que te causa otra muerte dolorosa y emocional y asi indefinidas veces, sin poder morir, sintiendo"
                      + "la angustia infinita de matarlos a todos.");
               
              break;
              
              
              
              case 4: System.out.println(
                      " Dentro de la sala todo parece como si no hubiera pasado nada y es que las paredes blindadas"
                      + " y la protección contra los rayos ionizantes dan su fruto");

              break;
              
              
            
              
          
              case 5: System.out.println(
                      "Todo parece tranquilo, como si no hubiera pasado nada."
                      + " Ves varias habitaciones cerradas pero la mayoría están abiertas.");
          
              break;
              
              
              
              
              case 6: System.out.println(
                      "Es la primera vez que entras aquí, ves muchas puertas cerradas"
                      + " de lo que entiendes son cosas de motores");
              break;
          
          }//Fin switch primer Mensaje 
          
          
          
          
          
        } //Fin if
        
               /*  
         0:Llaves
        1:Cables
        2:Claves de acceso
        
        3:Comida
        4:Sarten
        5:Cuchillos
        
        --Silla (no objeto)
        6:Restos de comida
        7:Instrucciones de una nave
       
        8: Casco
        9: Boligrafo
        10: Papel
        
        11: Arma
        12: Codigo enfermera
        13: Medicina coagulante
        14: Combustible
        15: Sierra mecanica
          */
               
               
               switch(sala){ //Se mostrará siempre, una breve descripcion de la sala para no perderse
          
              case 0: System.out.println(
                      " Delante tuya se abre el camino a tres puertas distintas, tus recuerdos te indican que a tu izquierda tienes la cocina con muchos alimentos y"
                      + " utensilios que te podrían ayudar en tu supervivencia y a tu derecha la sala de reuniones que tanto odiabas pero tanto poder directivo tenía. La puerta central  nunca la habías visto antes,"
                      + " te parece muy llamativa y surrealista, llena de colores que no pega nada con el interior de la nave."
                      + " además de eso localizas una estantería caída con algunos objetos pero no ves a la distancia que estas");
              break;
              
              
               case 1: System.out.println(
                       " Al fondo de la cocina localizas varios objetos aun sin quemarse,"
                       + " aun así no parecen de mucha utilidad");
              break;
              
              
               case 2: System.out.print(
                       " Inspeccionas la cantina y ves una silla de madera en la que se solían sentar los jefes a almorzar, ");
                    
               if(objetosObtenidos[6]){
                    
                   System.out.print(
                           "restos de comida de algún soldado que estaría comiendo durante el ataque");
                    
                    }
               
               
                if(objetosObtenidos[7]){
                    
                   System.out.print(
                           "y algo parecido a las instrucciones de la nave en una mesa");
                    
                    }
                      
                  
              break;
              
              
              
               case 3: System.out.println("");//No hay nada sobre la cocina
              break;
              
              
              
              
                case 4: System.out.println(
                        "  Algo te huele mal al ver que no hay ningún documento importante."
                        + " Al parecer los jefes ejecutivos sabían de antes como iba a terminar todo esto y"
                       + " decidieron dejar la nave sin avisar a nadie y limpiar la zona de cualquier material útil,"
                        + " típico de comandantes del imperio que solo piensan en ellos mismos.");
              break;
              
              
               case 5: System.out.println(""); //Nada sobre lo dormitorios
              break;
              
              
              
                case 6: System.out.println(
                        "No hay mucho que hacer por aquí ya que está todo destrozados"
                        + " del impacto aunque si ves algunas cosas que puedes usar:");
              break;
          
     
          
          }// Fin switch

    }//Fin metodo MensajeSala
    
    
    



}
