package bondiJET;

import java.util.ArrayList;
import java.util.LinkedList;

public class Seccion {

	//Atributo
    private String nombre;
    private double precio;
    private ArrayList<Asiento> asientos;

    //Construtor
    public Seccion(String nombre, double precio) {
    	this.nombre = nombre;
    	this.precio = precio;
    	this.asientos = new  ArrayList<>();
    }
    
    //Metodo
    public String ObtenerNombreDeLaSeccion(){
        return this.nombre;
    }
    public double ObtenerPrecio(){
        return this.precio;
    }
    public ArrayList<Asiento> ObtenerListaDeAsientos(){
        return asientos;
    }
    
    public void agregarAsiento(Asiento asiento) {
    	asientos.add(asiento);
    }
        
}
