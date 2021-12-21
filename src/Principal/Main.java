
package Principal;
//librerias
import Controlador.*;
import Vista.*;
import Colecciones.*;

public class Main {
    
    public static Forma1 f1;
    public static ControladorForma1 controlF1;     
    
    public static ListaEstudiantes Lista;
    
    public static void main(String[] args) {
        
      f1 =  new Forma1();
      f1.setVisible(true);
      f1.setLocationRelativeTo(null);   
      
      Lista = new ListaEstudiantes();
      
      controlF1 = new ControladorForma1(f1);
      
   
    }    
}

