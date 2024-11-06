package bondiJET;

import java.util.*;

public class VueloInternacional extends Vuelo {
	//Atributo
	private LinkedList<Aeropuerto> aeropuertos;
	private ArrayList<Seccion> secciones;
	
	//Constructor
	public VueloInternacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, int seccion, double[] precios, int[] cantAsientos, String[] escalas) {
		super(tripulantes, origen, destino, fecha, llegada, cantAsientos);	
	}
	
	//Metodos
	
}
