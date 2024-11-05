package AppSource;

import java.util.LinkedList;

public class VueloInternacional {
	//Atributo
	private LinkedList<Aeropuerto> aeropuerto;
	private LinkedList<Seccion> seccion;
	
	//Constructor
	public vueloNacional() {
		
	}
	
	//Metodos
	public void agregarEscala(Aeropuerto aeropuerto) {
		aeropuerto.add(aeropuerto);
	}
	public LinkedList<Aeropuerto> obtenerEscala(){
		return aerolinea;
	}
	public Seccion obtenerSecciones() {
		return seccion;
	}
	public double obtenerPrecioDelPasaje() {
		return 1;
	}
	public void organizarSecciones() {}
	public int obtenerAsientosDisponibles() {
		return 1;
	}
	
}
