package bondiJET;

import java.util.*;

public class Aerolinea {
	
	//Atributo
	private String nombre;
	private String cuit;
	private ArrayList<Aeropuerto> aeropuertos;
	private ArrayList<Vuelo> vuelos;
	private ArrayList<Cliente> clientes;
	
	//Constructor
    public Aerolinea(String nombre, String cuit){
        this.nombre = nombre;
        this.cuit = cuit;
        this.aeropuertos = new ArrayList<>();
        this.vuelos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }
    
    //Metodos
    public void registrarAeropuerto(String nombre, String pais, String provincia, String direccion) {
        aeropuertos.add(new Aeropuerto(nombre, pais, provincia, direccion));
     }
    
    public void registrarCliente(int dni, String nombre, String telefono) {
    	clientes.add(new Cliente(dni, nombre, telefono));
    }
    
    public String registrarVueloPublicoNacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, double[] precios, int[] cantAsientos) {
    	vuelos.add( new VueloNacional(origen,destino,fecha,tripulantes,valorRefrigerio,precios,cantAsientos));
    	return String.valueOf(vuelos.size() - 1);
    }
    
    public String registrarVueloPublicoInternacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, int seccion, double[] precios, int[] cantAsientos, String[] escalas) { 
    	vuelos.add( new VueloInternacional(origen,destino,fecha,tripulantes,valorRefrigerio,seccion,precios,cantAsientos, escalas));
    	return String.valueOf(vuelos.size() - 1);
    }
    
    public int venderPasaje(int dni, int codVuelo, int nroAsiento, boolean isOcupado) {
    	//El cliente esta registrado y BuscarCodigo de vuelo
    	if(buscarRegistrado(dni) && buscarCodVuelo(codVuelo)) {
    		
    	
    		
    	}
    	//BuscarNumeroDeAsiento
    	//VerificarSi estáOcupado
        return 0;
    }
    
    public boolean buscarRegistrado(int dni) {
    	for (Cliente cliente : clientes) {
			if(cliente.obtenerDNI() == dni) {
				return true;
			}
		}
    	return false;
    }
    public boolean buscarCodVuelo(int codVuelo) {
    	if(codVuelo < 0 || codVuelo >= vuelos.size()) {
    		return false;
    	}
    	if(vuelos.get(codVuelo) != null ) {
    		return true;
    	} 
    	return false;
    	
    }
    
    
    
    public Aeropuerto getAeropuerto(String key){  	
    	return aeropuertos.get(key);
    }
    
    
    public String VenderVueloPrivado(String origen, String destino, String fecha, int tripulantes, double precio,
            int dniComprador, int[] acompaniantes) {  
        return "";
    }
    public Map<Integer, String> asientosDisponibles(String codVuelo) {
        return null;
    }
    
    public List<String> consultarVuelosSimilares(String origen, String destino, String Fecha) {
        return null;
    }
    public void cancelarPasaje(int dni, String codVuelo, int nroAsiento) {
    }
    public void cancelarPasaje(int dni, int codPasaje) {
    }
    public List<String> cancelarVuelo(String codVuelo) {
        return null;
    }
    public double totalRecaudado(String destino) {
        return 0;
    }
    public String detalleDeVuelo(String codVuelo) {
        return "";
    }
}
