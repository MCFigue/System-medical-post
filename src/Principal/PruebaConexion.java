package Principal;
//librerias
import java.sql.*;
import Formatos.*;

public class PruebaConexion {
    //atributo
    public static Connection con;
    
    public static void main(String[] args) {
        
        try{
            //1. definimos el driver de conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. llamada al driverManager para que realice la conexion con la ruta,usuario,contraseña
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bduniversidad","root","");
            //mostramos un mensaje
            Mensajes.Mostrar("Conexion exitosa a la BDUniversidad");
        }catch(Exception ex){
            Mensajes.Mostrar("ERROR.. no se puede conectar con la BD...."+ex);
        }        
    }
    
}
