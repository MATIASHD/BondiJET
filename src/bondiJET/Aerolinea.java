package bondiJET;

import java.util.*;

public class Aerolinea implements IAerolinea {
	//Atributo
	private String nombre;
	private String cuit;
	private HashMap<String, Aeropuerto> aeropuertos;
	private LinkedList<Vuelo> vuelos;
	private LinkedList<Cliente> clientes;
	
	//Constructor
    public Aerolinea(String nombre, String cuit){
        this.nombre = nombre;
        this.cuit = cuit;
        this.aeropuertos = new HashMap<String, Aeropuerto>();
        this.vuelos = new LinkedList<Vuelo>();
        this.clientes = new LinkedList<Cliente>();
    }

   //Metodos
    
    public Aeropuerto getAeropuerto(String key){
    	
    	return aeropuertos.get(key);
    	
    }
    
    public void registrarCliente(int dni, String nombre, String telefono) {

        clientes.add(new Cliente(dni, nombre, telefono));

    }

    public void registrarAeropuerto(String nombre, String pais, String provincia, String direccion) {
    
        aeropuertos.put(nombre, new Aeropuerto(nombre, pais, provincia, direccion));

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

/*
    public void CrearAerolinea(String nombre, int cuit){

    }

    public void RegistrarCliente(String nombre, int teléfono, int DNI){

    }

    public void RegistrarAeropuerto(String nombre, String provincia, String direccion){

    }

    public void RegistrarVueloNacional(){

    }

    public void RegistrarVueloInternacional(){

    }

    public void RegistrarVueloPrivado(Cliente cliente, LinkedList<Cliente> listaDeClientes){

    }

    public String DameAsientosDisponibles(int codigoDelVuelo){

        return "";
    }

    public void VenderPasajeNacional(int dniPasajero, int codigoVuelo, int numAsiento, int seccion){

        return;
    }

    public void VenderPasajeInternacional( int dniPasajero, int codigoVuelo, int numAsiento, int seccion ){

    }

    public Vuelo BuscarVuelo(int codigoDeVuelo){

        return null;
    }

    public void CancelarPasaje(Vuelo vuelo, Cliente pasajero, int asiento){

    }

    public void CancelarVuelo(){
        
    }

    public void RecaudadoPorDestino(){

    }
*/
}
