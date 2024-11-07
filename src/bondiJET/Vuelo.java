package bondiJET;

import java.util.*;

public abstract class Vuelo{
	//Atributo
	private int codigoDelVuelo;
    private int cantidadDeTripulantes;
    private int cantidadDeAsientos;
    private String origen;
    private String destino;
    private String fechaDeSalida;
    private String fechaDeLlegada;
    private List<Pasajero> pasajeros;
    private int impuesto;
    
    //Constructor
    public Vuelo(int codVuelo, int cantidadDeTripulantes, String origen, String destino, String salida, String arrivo, int asientos, int impuestos){
    	this.codigoDelVuelo = codVuelo;
        this.cantidadDeTripulantes = cantidadDeTripulantes;
        this.cantidadDeAsientos = asientos;
        this.origen = origen;
        this.destino = destino;
        this.fechaDeSalida = salida;
        this.fechaDeLlegada = arrivo;
        this.pasajeros = new ArrayList<>();
        this.impuesto = impuestos;
    }
    
    public int obtenerCodDelVuelo() {
    	return this.codigoDelVuelo;
    }
    public int obtenerTripulantesTotales() {
    	return this.cantidadDeTripulantes;
    }
    public int obtenerTodosLosAsientos() {
    	return this.cantidadDeAsientos;
    }
    public String obtenerOrigen() {
    	return this.origen;
    }
    public String obtenerDestino() {
    	return this.destino;
    }
    public String obtenerFechaDelDespegue() {
    	return this.fechaDeSalida;
    }
    public String obtenerFechaDeArrivo() {
    	return this.fechaDeLlegada;
    }
    public List<Pasajero> obtenerListaDePasajero() {
    	return this.pasajeros;
    }
    public int obtenerImpuestos() {
    	return this.impuesto;
    }

}
