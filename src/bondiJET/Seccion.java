package bondiJET;


import java.util.*;

public class Seccion {

    public Seccion(String nombreDeSeccion, int numeroDeSeccion, double precio){

        this.nombreDeSeccion = nombreDeSeccion;
        this.numeroDeSeccion = numeroDeSeccion;
        this.precio = precio;
        asientos = new HashMap<>();

    }

    public Seccion(String nombre, double precio){

        this.nombreDeSeccion = nombre;
        this.precio = precio;
    }

    private String nombreDeSeccion;
    private int numeroDeSeccion;
    private double precio;
    private int cantidadDeAsientos;
    private Map<Integer, Asiento> asientos;

    public void setPrecio(double precioDeSeccion){

        precio = precioDeSeccion;
    }

    public int getNumeroDeSeccion(){
        
        return numeroDeSeccion;
    }
    
    public double getPrecio(){
        
        return precio;
    }
    
    public Map<Integer, Asiento> getListaDeAsientos(){
        
        return asientos;
    }

    public LinkedList<Asiento> getAsientosDisponibles(){

        LinkedList<Asiento> asientosLibres = new LinkedList<>();
            
        for(int i = 0; i < asientos.size(); i++){

            Asiento asiento = asientos.get(i);

            if(asiento.getEstaComprado() == true) asientosLibres.addLast(asiento);

        }

        return asientosLibres;

    }

    public int getCantidadDeAsientos(){

        return asientos.size();
    }

    public void AgregarAsiento(Asiento nuevoAsiento){
        
        asientos.put(nuevoAsiento.getNumeroDeAsiento(), nuevoAsiento);

    }

    public Asiento buscarAsiento(int numeroDeAsiento){

        for (Asiento asiento : asientos.values()) {
            
            if(asiento.getNumeroDeAsiento() == numeroDeAsiento);

            return asiento;

        }

        System.out.println("No existe un asiento con el número "+ numeroDeAsiento +"!");

        return null;

    }

    @Override
    public String toString() {
        
        return nombreDeSeccion + " " + numeroDeSeccion + " $" + precio;
    }
    
    public String getNombreSeccion(){

        return nombreDeSeccion;
    }
}
