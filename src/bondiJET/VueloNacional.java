package bondiJET;
public class VueloNacional extends Vuelo {
	//Atributos
	private String[] secciones;
	private double[] valorSecciones;
	private double ValorRefrigerio;
	private int maxCantPasajero;
	
	
	//Constructor
    public VueloNacional(int codVuelo, String origen, String destino, String salida, String arrivo,
    		int tripulantes, double valorRefrigerio, double[] precios, int asientos, int[] cantAsientos, int impuestos){
    	
    	super(codVuelo, tripulantes, origen, destino, salida, arrivo, asientos, impuestos);
        this.secciones = new String[2];
        this.valorSecciones = new double[2];
        this.ValorRefrigerio = valorRefrigerio;
        this.maxCantPasajero = 0;
    }



}
