package AppSource;

import java.util.LinkedList;

public class Seccion {

    String nombreDelAera;
    int numeroDeSeccion;
    double precio;
    LinkedList<Asiento> asientos;

    public int ObtenerNumeroDeSeccion(){
        
        return 0;
    }
    public double Precio(){
        
        return 0;
    }
    public LinkedList<Asiento> ObtenerListaDeAsientos(){
        
        return null;
    }
    public void ObtenerCantidadDeAsientos(){

    }
        
    public String obtenerAsientosDisponibles(){

        for (Asiento asiento : asientos) {
            
            if(asiento.estaLibre) System.out.println(asiento.toString());

        }

        return "";

    }

    public void AgregarAsiento(){
        
    }

    @Override
    public String toString() {
        
        return nombreDelAera + " " + numeroDeSeccion + " $" + precio;
    }
    
}
