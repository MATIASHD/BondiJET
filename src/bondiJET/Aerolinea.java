package bondiJET;

import java.util.*;

public class Aerolinea {
	/*
	 * Usar Stringbulder
	 * iteradores y foreach
	 * herencia 
	 * polimorfismo
	 * sobreescritura
	 * sobrecarga
	 * interfaces
	 * clases astracta
	 * metodos astractos
	 */
	
	//Atributo
	private String nombre;
	private String cuit;
	private List<Aeropuerto> aeropuertos;
	private List<Vuelo> vuelos;
	private List<Cliente> clientes;
	
	//Constructor
    public Aerolinea(String nombre, String cuit){
        this.nombre = nombre;
        this.cuit = cuit;
        this.aeropuertos = new ArrayList<>();
        this.vuelos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }
    
    
    //Metodos
    //2
    public void registrarCliente(int dni, String nombre, String telefono) { 
    	 if(!isCliente(dni)) {    		 
    		 this.clientes.add(new Cliente(dni, nombre, telefono));
    	 }
    }
    
    public boolean isCliente(int dni) {
    	for (Cliente cliente : this.clientes) {
    		if(cliente.obtenerDNI() == dni) {    			
    			return true;
    		}
		}
    	return false;
    }
    
    
    //3
    public void registrarAeropuerto(String nombre, String pais, String provincia, String direccion) {
    	if (!isAeropuerto(nombre, direccion)) {			
    		this.aeropuertos.add(new Aeropuerto(nombre, pais, provincia, direccion));
		}
     }
    
    public boolean isAeropuerto(String nombre, String direccion) {
    	for (Aeropuerto aero : this.aeropuertos) {
    		if(aero.obtenerNombre() == nombre && aero.obtenerDireccion() == direccion) {    			
    			return true;
    		}
		}
    	return false;
    }
    
    //4
    public String registrarVueloPublicoNacional(String origen, String destino, String fecha, int horasDuracion, double valorRefrigerio, double[] precios, int[] cantAsientos) {
    	if(isValidoOrigenYDestino(origen, destino)) {    		
    		vuelos.add(new VueloNacional(generarCodVuelo(),origen,destino ,fecha,String.valueOf(horasDuracion),0,valorRefrigerio,precios,cantAsientos, 20));
    		return String.valueOf(generarCodVuelo());
    	}
    	return "";
    }
    public int generarCodVuelo() {
    	return this.vuelos.size();
    }
    
    public boolean isValidoOrigenYDestino(String origen, String destino) {
    	for (Aeropuerto aeropuerto : aeropuertos) {
			if (aeropuerto.obtenerNombre() == origen && aeropuerto.obtenerNombre() == destino ) {
				return true;
			}
		}
    	return false;
    }
    //5
    public String registrarVueloPublicoInternacional(String origen, String destino, String salida, int horasDuracion, double valorRefrigerio,int cantidadRefrigerios, double[] precios, int[] cantAsientos, String[] escalas) { 
    	if (isValidoOrigenYDestino(origen, destino)) {
    		vuelos.add(new VueloInternacional(generarCodVuelo(),10, origen, destino, salida, String.valueOf(horasDuracion), 10, 30,escalas, valorRefrigerio));	
    		return String.valueOf(generarCodVuelo());
    	}
    	
    	return "";
    }
    //6
    public String VenderVueloPrivado(String origen, String destino, String fecha,int horaDuracion, double precio, int dniComprador, int[] acompaniantes) {  
    	//Destinos validos
    	if (isValidoOrigenYDestino(origen, destino) && isCliente(dniComprador)) {
    		vuelos.add(new VueloPrivado(generarCodVuelo(),buscarCliente(dniComprador), acompaniantes, precio,10,origen,destino, fecha, 0,15, String.valueOf(horaDuracion),acompaniantes.length,0));	
    		return String.valueOf(generarCodVuelo());
    	}
    	//clientes registrados 
        return "";
    }
    
    //7
    public boolean buscarNumAsiento(int codVuelo, int nroAsiento) {
    	if(buscarCodVuelo(codVuelo)) {
    		for (Vuelo vuelo : vuelos){
    			//Si alguien tiene asignado el asiento, entonces no está disponible
    			if(vuelo.obtenerCodVuelo() == codVuelo && estaDisponibleElAsiento(vuelo, nroAsiento)) {
    				return true;
    			}
    		}
    		return false;
    	}
    	return false;
    }
    
  //VerificarSi estáOcupado
    public boolean asientosDisponibles(String codVuelo) {
    	for(Pasajero pasajero: vuelo.obtenerListaDePasajeros()) {
    		//BuscarNumeroDeAsiento
    		if(pasajero.isAsientoAsignado(numAsiento) == null) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean buscarRegistrado(int dni) {
    	for (Cliente cliente : clientes) {
			if(cliente.obtenerDNI() == dni) {
				return true;
			}
		}
    	return false;
    }
    //8
    public int venderPasaje(int dni, String codVuelo, int nroAsiento, boolean isPreferencial) {
    	Cliente cliente = buscarCliente(dni);
    	Pasajero pasajero = new Pasajero(cliente);
    	//El cliente esta registrado y BuscarCodigo de vuelo
    	if(buscarRegistrado(dni) && buscarCodVuelo(codVuelo)) {
    		if(buscarNumAsiento(codVuelo, nroAsiento)) {
    			////////////////////////
    			/// SE VENDE EL PASAJE
    			////////////////////////
    			for (Vuelo vuelo : vuelos){
        			if(vuelo.obtenerCodVuelo() == codVuelo) {
        				vuelo.obtenerListaDePasajeros().add(pasajero.asignarAsiento(nroAsiento));
        			}
        		}
    		}
    	
    		
    	}

    }
    //9
    public int venderPasajeVueloInternacional(int dni, int codVuelo, int nroAsiento, String seccion) {
    	Cliente cliente = buscarCliente(dni);
    	Pasajero pasajero = new Pasajero(cliente);
    	//El cliente esta registrado y BuscarCodigo de vuelo
    	if(buscarRegistrado(dni) && buscarCodVuelo(codVuelo)) {
    		if(buscarNumAsiento(codVuelo, nroAsiento)) {
    			////////////////////////
    			/// SE VENDE EL PASAJE
    			////////////////////////
    			for (Vuelo vuelo : vuelos){
        			if(vuelo.obtenerCodVuelo() == codVuelo) {
        				vuelo.obtenerListaDePasajeros().add(pasajero.asignarAsiento(nroAsiento));
        			}
        		}
    		}
    	
    		
    	}

    }
    //10
    public int venderPasajeVueloPrivado(Cliente cliente, ArrayList<Pasajero> pasajero) { //Si supera la capacidad se crea otro vuelo
    	Cliente cliente = buscarCliente(dni);
    	Pasajero pasajero = new Pasajero(cliente);
    	//El cliente esta registrado y BuscarCodigo de vuelo
    	if(buscarRegistrado(dni) && buscarCodVuelo(codVuelo)) {
    		if(buscarNumAsiento(codVuelo, nroAsiento)) {
    			////////////////////////
    			/// SE VENDE EL PASAJE
    			////////////////////////
    			for (Vuelo vuelo : vuelos){
        			if(vuelo.obtenerCodVuelo() == codVuelo) {
        				vuelo.obtenerListaDePasajeros().add(pasajero.asignarAsiento(nroAsiento));
        			}
        		}
    		}
    	
    		
    	}

    }
    //11
    public List<String> consultarVuelosSimilares(String origen, String destino, String Fecha) {
    	//Devulve una lista con la lista de los vuelos similares por origen, destino y los proximos 7 dias
        return null;
    }
    //12
    //Tiene que ser O(1)
    public void cancelarPasaje(int dni, String codVuelo, int nroAsiento) {
    //Vuelve a estar a la venta
    //Pasajero cliente registrado
    }
    //13
    public List<String> cancelarVuelo(String codVuelo) {
    	//reprogramar Cambiar fecha
    	//return devulve los codigo del pasaje sin reasignar
    	//reporgramar vuelos al igual destinos, sin importar las escalas, se debe informar
        return null;
    }
    //14
    public double totalRecaudado(String destino) {
        return 0;
    }
    
    public String detalleDeVuelo(String codVuelo) {
    	StringBuilder sb = new StringBuilder();
    	
    	return "";
    	public class EjemploStringBuilder { //Usar StringBuilder para detalle
    	    public static void main(String[] args) {
    	        
    	        sb.append("Hola");
    	        sb.append(" ");
    	        sb.append("Mundo");
    	        
    	        System.out.println(sb.toString()); // Salida: Hola Mundo
    	    }
    	}
    }
    
   /*
    * Funciones auxiliares
    *  
    */
    
    public Cliente buscarCliente(int dni) {
    	for (Cliente cliente : clientes) {
			if(cliente.obtenerDNI() == dni) {
				return cliente;
			}
		}
    	return null;
    }
    
    public boolean buscarCodVuelo(int codVuelo) {
    	if(codVuelo < 0 || codVuelo >= vuelos.size()) {
    		return false;
    	}
    	for(Vuelo vuelo : this.vuelos) {
			if (vuelo.obtenerCodDelVuelo() == codVuelo) {
				return true;
			}
		}
    	return false;
    }
    
    
    
    public Aeropuerto getAeropuerto(String key){  	
    	return aeropuertos.get(key);
    }
    
    
    
    public Map<Integer, String> asientosDisponibles(String codVuelo) {
        return null;
    }
    
    
    
    
    
    
    
}
