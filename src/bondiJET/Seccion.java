package bondiJET;

import java.util.ArrayList;
import java.util.List;

public class Seccion {

	//Atributo
    private String nombre;
    private double precio;
    private List<Asiento> asientos = new ArrayList<>();

    //Construtor
    public Seccion(String nombre, double precio, List<Asiento> asientos) {
    	this.nombre = nombre;
    	this.precio = precio;
    	this.asientos = asientos;
    }
    
    //Metodo
    public String ObtenerNombreDeLaSeccion(){
        return this.nombre;
    }
    public double ObtenerPrecio(){
        return this.precio;
    }
    public List<Asiento> ObtenerListaDeAsientos(){
        return this.asientos;
    }
    
    public void agregarAsiento(Asiento asiento) {
    	asientos.add(asiento);
    }
        
}
