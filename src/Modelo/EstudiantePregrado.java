package Modelo;
public class EstudiantePregrado extends Estudiante implements Carreras,MontoPensiones {
    //atributos
    private String carrera;
    private double pension;
    private static int cont=0;
    //constructor
    public EstudiantePregrado(){
         cont++;
    }
    //metodos getter y setter
     public String getCarrera()             {   return carrera;          }
     public void setCarrera(String carrera) {   this.carrera = carrera;   }
     public double getPension()             {   return pension;           }
     public void setPension(double pension) {   this.pension = pension;   }     
    //definicion de los metodos abstractos    
    @Override
    public double CalcPension() {
        switch(carrera){
            case carrera1: pension=pension1; break;
            case carrera2: pension=pension2; break;
            case carrera3: pension=pension3; break;
            default: return 0;
        } 
        return pension;
    } 
    public Object[] RegistroEst(int num) {
       Object Registro[] = {num,super.getCodigo(),super.getNombres(),super.getDireccion(),carrera,pension};   
       return Registro;
    }   
}
