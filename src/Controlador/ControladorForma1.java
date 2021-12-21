package Controlador;
//librerias
import Modelo.*;
import Vista.*;
import Principal.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import DAO.*;

public class ControladorForma1 implements ActionListener{
    //atributos
    private Forma1 vista;
    private EstudiantePregrado est;
    private DefaultComboBoxModel cbm;
    private String codbuscado;
    //constructor
    public ControladorForma1(Forma1 f1){
        this.vista =  f1; //actualiza el formulario de la clase con la Forma1
        //actualizamos el listener en el boton grabar,consultar,actualizar y eliminar
        this.vista.jbtnGrabar.addActionListener(this); 
        this.vista.jbtnConsultar.addActionListener(this);
        this.vista.jbtnActualizar.addActionListener(this);
        this.vista.jbtnEliminar.addActionListener(this);
        //llamada metodos para cargar el combo       
        CargarCombo();
        //llamada al metodo actualizar tabla de la coleccion
        Main.Lista.MostrarEnTabla(vista.jtblListaEstudiantes);
    }
     
    public void CargarCombo(){
        //actualizamos el combo con las carrera
        cbm = new DefaultComboBoxModel();
        vista.jcbxCarrera.setModel(cbm);
        cbm.addElement(Carreras.carrera1);
        cbm.addElement(Carreras.carrera2);
        cbm.addElement(Carreras.carrera3);
    }
   
    @Override
    public void actionPerformed(ActionEvent arg0) {
        
       //verifica que objeto tiene el evento 
       if(arg0.getSource() == vista.jbtnGrabar){
           LecturaDeDatos();
           
           CRUDEstudiante crud =  new CRUDEstudiante();
           crud.InsertarEstudiante(est);
                      
           //enviamos el objeto a la coleccion
           //Main.Lista.AgregarEstudiante(est);
           //mostramos el estudiante en la tabla
           Main.Lista.MostrarEnTabla(vista.jtblListaEstudiantes);           
           //limpiamos los objetos
           LimpiarEntradas();           
       } else if(arg0.getSource() == vista.jbtnConsultar){
            codbuscado = JOptionPane.showInputDialog("Ingrese el código a buscar....");
            //indicebuscado = Main.Lista.BuscarEstudiante(codbuscado);
            
            CRUDEstudiante crud =  new CRUDEstudiante();
            est = crud.RecuperarEstudiante(codbuscado);
            
            if(est==null){
                JOptionPane.showMessageDialog(null,"El codigo "+codbuscado+" no existe en la colección");
            }else{
                //recuperar el estudiante en la posicion del indice buscado de la coleccion
                // EstudiantePregrado e = Main.Lista.RecuperarEstudiante(indicebuscado);
                //mostramos los datos de ese estudiante
                vista.jtxtCodigo.setText(est.getCodigo());
                vista.jtxtNombres.setText(est.getNombres());
                vista.jtxtDireccion.setText(est.getDireccion());
                if(est.getCarrera().equals(Carreras.carrera1))  vista.jcbxCarrera.setSelectedIndex(0);
                else if(est.getCarrera().equals(Carreras.carrera2))  vista.jcbxCarrera.setSelectedIndex(1);
                 else if(est.getCarrera().equals(Carreras.carrera3)) vista.jcbxCarrera.setSelectedIndex(2);                              
            }           
       }else if(arg0.getSource() ==  vista.jbtnActualizar){
             LecturaDeDatos(); // leemos los datos actuales
             //Main.Lista.ActualizarEstudiante(indicebuscado, est); //llamamos al metodo que actualiza el objeto
             
             CRUDEstudiante crud = new CRUDEstudiante();
             crud.ActualizarEstudiante(est);
                          
             Main.Lista.MostrarEnTabla(vista.jtblListaEstudiantes);//actualizamos la tabla 
             LimpiarEntradas();
       }else if(arg0.getSource() == vista.jbtnEliminar){
           int respuesta = JOptionPane.showConfirmDialog(null, 
                "Esta seguro de eliminar el registro?", "Confirmación...",JOptionPane.YES_NO_CANCEL_OPTION);           
           // 0=yes, 1=no, 2=cancel
           if(respuesta == 0){           
               //Main.Lista.EliminarEstudiante(indicebuscado); //eliminamos el objeto de la coleccion
                           
               CRUDEstudiante crud = new CRUDEstudiante();
               crud.EliminarEstudiante(codbuscado);
               
               Main.Lista.MostrarEnTabla(vista.jtblListaEstudiantes);//actualizamos la tabla 
               LimpiarEntradas(); //limpiamos las entradas
           }else{
               vista.jbtnConsultar.requestFocus();
           }          
       }     
    }//fin actionPerformed   
    
    void LecturaDeDatos(){
        est = new EstudiantePregrado(); //creamos el objeto
        //actualiazamos los datos con la informacion del formulario desde VISTA
        est.setCodigo(vista.jtxtCodigo.getText());
        est.setNombres(vista.jtxtNombres.getText());
        est.setDireccion(vista.jtxtDireccion.getText());
        est.setCarrera(vista.jcbxCarrera.getSelectedItem().toString());
    }
    
    
    void LimpiarEntradas(){
        vista.jtxtCodigo.setText("");
        vista.jtxtNombres.setText("");
        vista.jtxtDireccion.setText("");
        vista.jcbxCarrera.setSelectedIndex(0);
        vista.jtxtCodigo.requestFocus();
    }    

   
}
