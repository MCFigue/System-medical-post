package Modelo;

import javax.swing.JTable;

public interface Impresiones {
    //constante
    String[] encabezado1={"Num","Codigo","Nombres","Direccion","Carrera","Pension"};
    //Metodo abstracto
    public void MostrarEnTabla(JTable tabla);    
}
