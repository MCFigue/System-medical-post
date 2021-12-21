package DAO;
import java.sql.*;
import Formatos.*;       
public class ConectarBD implements Parametros{
    public Connection conexion;
    public ConectarBD(){
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(ruta,usuario,clave);            
        }catch(Exception ex){
            Mensajes.Mostrar("ERROR al conectar BD .."+ex);
        }        
    }   
}
