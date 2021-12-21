package Colecciones;
//librerias
import Modelo.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;

import DAO.*;

public class ListaEstudiantes implements Impresiones{
   //atributos
   private ArrayList<EstudiantePregrado> Lista;
   //constructor
   public ListaEstudiantes(){
       Lista = new ArrayList();
   }
   //metodos para la manipulacion de los objetos de la coleccion
   //** metodo que permite agregar objetos a la coleccion
   public void AgregarEstudiante(EstudiantePregrado est){
       Lista.add(est);
   }
   //** metodo para recuperar un estudiante de la lista
   public EstudiantePregrado RecuperarEstudiante(int pos){
       return Lista.get(pos);
   }
   //** metodo para eliminar un objeto de la Lista
   public void EliminarEstudiante(int pos){
       Lista.remove(pos);
   }
   //** metodo que actualiza un objeto de la lista
   public void ActualizarEstudiante(int pos,EstudiantePregrado estactual){
       Lista.set(pos,estactual);
   }
   //** metodo que busca un estudiante su codigo y retorna su posicion
   public int BuscarEstudiante(String codbuscado){
       for(int i=0; i<Lista.size();i++){
           if(codbuscado.equalsIgnoreCase(Lista.get(i).getCodigo()))
               return i;// si existe retornamos la posicion           
       }
       return -1; // el codigo buscado no existe en la lista
   }  
   @Override
    public void MostrarEnTabla(JTable tabla) {    
        
      CRUDEstudiante crud = new CRUDEstudiante();
      crud.ActualizarColeccionEstudiante();
                
      //seguido se actualiza el JTable.  
      DefaultTableModel mt =  new DefaultTableModel(null,encabezado1);   
      tabla.setModel(mt);
      //mostramos en la tabla los registros de la coleccion
      for(int i=0; i<Lista.size() ; i++){
          mt.addRow(Lista.get(i).RegistroEst(i+1));
      }      
    }  
    public void LimpiarDatosLista(){
        Lista.clear();
    }
}
