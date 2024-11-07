package bondiJET;

import java.util.*;

public class VueloPrivado extends Vuelo{
	//"Aeroparque", "Bariloche", "07/01/2025", 4, 450000, 98765432, acompaniantes
	//Atributos
	private Cliente comprador;
    private List<Cliente> acompañantes;
    private int cantidadDeJets;
    private double PrecioPorJet;
    private int cantidadDeAsientosPorJet;
    
    //Constructor
    public VueloPrivado(int codVuelo,Cliente comprador, ArrayList<Cliente> acompañantes, double precioPorJet,int cantidadDeTripulantes, String origen, String destino, String salida, int impuestos,
    		int tripulantes, String fechaArrivo, int cantTotalAsiento){
    	super(codVuelo, tripulantes, origen, destino, salida, fechaArrivo, cantTotalAsiento, impuestos);
        this.comprador = comprador;
        this.acompañantes = acompañantes;
        this.cantidadDeJets = 0;
        this.PrecioPorJet = precioPorJet;
        this.cantidadDeAsientosPorJet = 15;
    }
    
    public double precioFinal() {
    	return 1.0;
    }
    public void sumarJet() {
    	this.cantidadDeJets++;
    }
    public double precioTotal() {
    	return (this.obtenerImpuestos() * (this.PrecioPorJet * this.cantidadDeJets))/100 ;
    
    }
}
