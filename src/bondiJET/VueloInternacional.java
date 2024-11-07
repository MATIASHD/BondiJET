package bondiJET;

import java.util.*;

public class VueloInternacional extends Vuelo{
	//Atributo
	private List<String> aeropuertos = new ArrayList<>();
	private String[] secciones;
	private double[] valorSecciones;
	private double ValorRefrigerio;
	private int maxCantPasajero;
	
	//Constructor
	public VueloInternacional(int codVuelo, int tripulantes, String origen, String destino, String salida, String fechaArrivo, int cantTotalAsiento, int impuestos,
			ArrayList<String> escalas, double ValorRefrigerio) {
		super(codVuelo, tripulantes, origen, destino, salida, fechaArrivo, cantTotalAsiento, impuestos);
		this.ValorRefrigerio = ValorRefrigerio;
		this.aeropuertos = escalas;
		this.secciones = new String[3];
		this.valorSecciones = new double[2];
		this.maxCantPasajero = 0;
	}
	
	public double precioTotal() {
    	return (this.obtenerImpuestos() *(this.ValorRefrigerio* this.refrigerioTotalPorVuelo()))/100 ;
    
    }

}
