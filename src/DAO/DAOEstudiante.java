package DAO;
import Modelo.*;
public interface DAOEstudiante {
    public void InsertarEstudiante(EstudiantePregrado est);
    public EstudiantePregrado RecuperarEstudiante(String cod);
    
    public void EliminarEstudiante(String cod);
        
    
    public void ActualizarEstudiante(EstudiantePregrado nuevoest);
    
    public void ActualizarColeccionEstudiante(); // actualiza la coleccion con los registros de la tabla
}
