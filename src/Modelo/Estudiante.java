package Modelo;
public abstract class Estudiante {
   //atributos
    private String codigo;   
    private String nombres;    
    private String direccion;
   //constructor
    public Estudiante(){ }
    public Estudiante(String codigo, String nombres, String direccion) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.direccion = direccion;
    }
    // metodos getter y setter
    public String getCodigo()               {    return codigo;             }
    public void setCodigo(String codigo)    {    this.codigo = codigo;      }
    public String getNombres()              {    return nombres;            }
    public void setNombres(String nombres)  {    this.nombres = nombres;    }
    public String getDireccion()            {    return direccion;          }
    public void setDireccion(String direccion) { this.direccion = direccion;}
    //metodo abstracto
    public abstract double CalcPension();  
    
}
