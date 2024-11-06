package bondiJET;

import java.util.*;

public class VueloInternacional extends Vuelo {
	//Atributo
	private ArrayList<Aeropuerto> aeropuertos;
	private ArrayList<Seccion> secciones;
	
	//Constructor
	public VueloInternacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, int seccion, double[] precios, int[] cantAsientos, String[] escalas) {
		super(tripulantes, origen, destino, fecha, cantAsientos);	
		this.aeropuertos = new ArrayList<>();
		this.secciones = new ArrayList<>();
	}
	
	//Metodos

	// (cantidadDeTripulantes, origen, destino, Salida, Llegada,cantidadDeAsientos){
}
