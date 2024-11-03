package bondiJET;

import java.util.*;
import java.util.Map;

public class Aerolinea implements IAerolinea {
	

	public Aerolinea(String nombre, String CUIT) {
		
		this.nombre = nombre;
		this.cuit = CUIT;
		
	}

    String nombre;
    String cuit;
    LinkedList<Aeropuerto> aeropuertos;
    LinkedList<Vuelo> vuelos;
    LinkedList<Cliente> clientes;

    public void registrarCliente(int dni, String nombre, String telefono) {

    }

    public void registrarAeropuerto(String nombre, String pais, String provincia, String direccion) {
    
    }

    public String registrarVueloPublicoNacional(String origen, String destino, String fecha, int tripulantes,
            double valorRefrigerio, double[] precios, int[] cantAsientos) {

        return "";
    }

    public String registrarVueloPublicoInternacional(String origen, String destino, String fecha, int tripulantes,
            double valorRefrigerio, int cantRefrigerios, double[] precios, int[] cantAsientos, String[] escalas) {
                
        return "";
    }

    public String VenderVueloPrivado(String origen, String destino, String fecha, int tripulantes, double precio,
            int dniComprador, int[] acompaniantes) {
    
        return "";
    }

    public Map<Integer, String> asientosDisponibles(String codVuelo) {

        return null;
    }

    public int venderPasaje(int dni, String codVuelo, int nroAsiento, boolean aOcupar) {

        return 0;
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
