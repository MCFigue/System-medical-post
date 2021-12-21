/*  C: create
    R: read
    U: update
    D: delete     */
package DAO;
//librerias
import Modelo.*;
import Formatos.*;
import Principal.*;
import java.sql.*;
public class CRUDEstudiante implements DAOEstudiante {
    //atributos
    Connection con; // lleva la conexion de la BD
    Statement st; // crea el espacio para la consulta
    ResultSet rs; // guarda el grupo resultado despues de la consulta (select)
    PreparedStatement consulta; // clase que prepara la consulta en sql para su ejecucion(insert,update,delete)    
    //constructor
    public CRUDEstudiante(){
        con = (new ConectarBD()).conexion; // realizamos la conexion a la BD y recuperamos la conexion en con
    }
    //implementacion de metodos   
    @Override
    public void ActualizarColeccionEstudiante() {        
        Main.Lista.LimpiarDatosLista();//llamada a metodo que eliminar lo registros de la coleccion
        EstudiantePregrado est; // objeto para recuperar los registros de la tabla de la BD
        try{
            st =  con.createStatement(); //crea espacio para la consulta y sus datos
            rs =  st.executeQuery("select * from estudiante"); //ejecuta la consulta y los registros los almacena en rs
            while(rs.next()){//next() retorna TRUE si hay registros en la consulta
                est = new EstudiantePregrado(); //creamos el objeto vacio
                est.setCodigo(rs.getString(1)); //recuperamos el codigo que esta en la columna 1
                est.setNombres(rs.getString(2)); //recuperamos el nombre que esta en la columna 2
                est.setDireccion(rs.getString(3)); //recuperamos el direccion que esta en la columna 3
                est.setCarrera(rs.getString(4));//recuperamos el carrera que esta en la columna 4
                est.setPension(rs.getDouble(5));
                Main.Lista.AgregarEstudiante(est);  //agregamos el objeto a la coleccion             
            }
            con.close(); //cerramos la conexion y liberamos espacio            
        }catch(Exception ex){
           Mensajes.Mostrar("Error al recuperar registros ...."+ex);
        }
    }    

    @Override
    public void InsertarEstudiante(EstudiantePregrado est) {        
        try{
            //preparamos la consulta y agregamos los parametros que deben ser actualizados en la consulta
            consulta =  con.prepareStatement("INSERT INTO estudiante VALUES(?,?,?,?,?);");
            //actualizamos los parametros con la informacion objeto EstudiantePregrado
            consulta.setString(1,est.getCodigo());
            consulta.setString(2,est.getNombres());
            consulta.setString(3,est.getDireccion());
            consulta.setString(4,est.getCarrera());
            consulta.setDouble(5,est.CalcPension());
            consulta.executeUpdate();//actualiza los parametros y ejecuta la consulta
            con.close();            
        }catch(Exception ex){
           Mensajes.Mostrar("Error al insertar registro..."+ex);
        }        
    }

    @Override
    public EstudiantePregrado RecuperarEstudiante(String cod) {
       EstudiantePregrado estpre = null;
        try{
            st= con.createStatement();
            rs =  st.executeQuery("SELECT * FROM estudiante WHERE codigo='"+cod+"';");
            if(rs.next()){
                estpre = new EstudiantePregrado();
                estpre.setCodigo(rs.getString(1));
                estpre.setNombres(rs.getString(2));
                estpre.setDireccion(rs.getString(3));
                estpre.setCarrera(rs.getString(4));
                estpre.setPension(rs.getDouble(5));                
            }
            con.close();
        }catch(Exception ex){
            Mensajes.Mostrar("Error no se puede recuperar el registro...");
        }           
        return estpre; 
    }

    @Override
    public void EliminarEstudiante(String cod) {
      try{
          consulta = con.prepareStatement("DELETE FROM estudiante WHERE codigo=?;");
          consulta.setString(1,cod);
          consulta.executeUpdate();
          Mensajes.Mostrar("Registro Eliminado.....");
          con.close();          
      }catch(Exception ex){
          Mensajes.Mostrar("ERROR: no se puede eliminar el registro..."+ex);
      }       
    }

    @Override
    public void ActualizarEstudiante(EstudiantePregrado nuevoest) {
      try{
          consulta =  con.prepareStatement("UPDATE estudiante SET nombres=?,direccion=?,carrera=?,pension=? WHERE codigo=?");
          consulta.setString(1,nuevoest.getNombres());
          consulta.setString(2,nuevoest.getDireccion());
          consulta.setString(3,nuevoest.getCarrera());
          consulta.setDouble(4,nuevoest.CalcPension());
          consulta.setString(5,nuevoest.getCodigo());
          consulta.executeUpdate();
          Mensajes.Mostrar("Registro actualizado!!!.");
          con.close();
      }catch(Exception ex){
          Mensajes.Mostrar("ERROR no se puede actualizar el registro..."+ex);
      }
    }

   
}
