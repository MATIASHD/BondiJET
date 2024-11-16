package bondiJET;

import java.util.*;

public class Aerolinea implements IAerolinea {

    public Aerolinea(String nombre, String cuit){

        if(nombre.length() < 0){
            throw new IllegalArgumentException("Error: el nombre ingresado no es válido.");
        }
        if(cuit.length() < 0){
            throw new IllegalArgumentException("Error: el CUIT ingresado no es válido.");
        }

        this.cuit = cuit;
        this.nombre = nombre;
        this.aeropuertos = new HashMap<String, Aeropuerto>();
        this.vuelos = new HashMap<String, Vuelo>();
        this.clientes = new HashMap<Integer, Cliente>();

    }

    String nombre;
    String cuit;
    Map<String, Aeropuerto> aeropuertos;
    Map<String, Vuelo> vuelos;
    Map<Integer, Cliente> clientes;
    
    public Aeropuerto getAeropuerto(String nombre){

        if(!aeropuertos.containsKey(nombre)){
            throw new NullPointerException("El aeropuerto ingresado no existe.");
        }
        
        Aeropuerto aeropuertoSolicitado = aeropuertos.get(nombre);
        
        return aeropuertoSolicitado;

    }

    public void registrarCliente(int dni, String nombre, String telefono) {

        try {
         
            if(!clientes.containsKey(dni)){
            
                clientes.put(dni, new Cliente(dni, nombre, telefono));
            
            }
            
        } catch (IllegalArgumentException ex) {
            throw ex;
        }
    }

    public void registrarAeropuerto(String nombre, String pais, String provincia, String direccion) {
    
        try {

            Aeropuerto nuewvoAeropuerto = new Aeropuerto(nombre, pais, provincia, direccion);

            if(!aeropuertos.containsKey(nombre)) aeropuertos.put(nombre, nuewvoAeropuerto);

        } catch (IllegalArgumentException ex) {
            throw ex;
        }
    }

    private Aeropuerto buscarAeropuertoNacional(String nombreAeropuerto){

        if(!aeropuertos.containsKey(nombreAeropuerto)){
            throw new NullPointerException("Error: no existe el aeropuerto solicitado.");
        }

        Aeropuerto aeropuertoSolicitado = aeropuertos.get(nombreAeropuerto);

        if(!aeropuertoSolicitado.getPais().equals("Argentina")){
            return null;
        }

        return aeropuertoSolicitado;
    }
   
    private Aeropuerto buscarAeropuertoInternacional(String nombreAeropuerto){
        
        if(!aeropuertos.containsKey(nombreAeropuerto)){
            throw new NullPointerException("Error: no existe el aeropuerto solicitado.");
        }

        Aeropuerto aeropuertoSolicitado = aeropuertos.get(nombreAeropuerto);

        if(aeropuertoSolicitado.getPais().equals("Argentina")){
            return null;
        }

        return aeropuertoSolicitado;
    }
   
    private Aeropuerto[] buscarEscalas(Aeropuerto origen, Aeropuerto destino, String[] aeropuertosEscala){

        Aeropuerto[] escalas = new Aeropuerto[aeropuertosEscala.length];

        try {
            
            for(int i = 0; i < aeropuertosEscala.length; i++){

                escalas[i] = aeropuertos.get(aeropuertosEscala[i]);

                if(escalas[i].equals(origen) || escalas[i].equals(destino)){

                    throw new RuntimeException("Error: una escala no pueden ser igual al origen ni al destino.");

                }

            }

            return escalas;

        } catch (NullPointerException ex) {
            throw ex;
        } catch (RuntimeException ex){
            throw ex;
        }

    }
  
    private Aeropuerto[] cargarEscalas(Aeropuerto origen, Aeropuerto destino, String[] escalas){

        if(escalas.length > 0){

            Aeropuerto[] aeropuertosEscala = null;
        
            aeropuertosEscala = buscarEscalas(origen, destino, escalas);
            
            return aeropuertosEscala;
    
        } else return null;
    }

    @Override
    public String registrarVueloPublicoNacional(String origen, String destino, String fecha, int tripulantes,
                                                    double valorRefrigerio, double[] precios, int[] cantAsientos) {
                
        Aeropuerto AeropuertoOrigen = buscarAeropuertoNacional(origen);
        Aeropuerto AeropuertoDestino = buscarAeropuertoNacional(destino);

        try {

            VueloNacional nuevoVuelo = new VueloNacional(AeropuertoOrigen, AeropuertoDestino, fecha, tripulantes, precios, cantAsientos, valorRefrigerio);
    
            vuelos.put(nuevoVuelo.getCodigo(), nuevoVuelo);
    
            System.out.println("MIRA ACAAAA: "+nuevoVuelo.getCodigo() + nuevoVuelo.getDestino().getNombre());
            return nuevoVuelo.getCodigo();
            
        } catch (IllegalArgumentException ex) {
            throw ex;
        }
    }

    @Override
    public String registrarVueloPublicoInternacional(String origen, String destino, String fecha, int tripulantes,
            double valorRefrigerio, int cantRefrigerios, double[] precios, int[] cantAsientos, String[] escalas){
    
        Aeropuerto aeropuertoOrigen = buscarAeropuertoNacional(origen);
        Aeropuerto aeropuertoDestino = buscarAeropuertoInternacional(destino);
        Aeropuerto[] aeropuertosEscala = cargarEscalas(aeropuertoOrigen, aeropuertoDestino, escalas);

        try {
            
            VueloInternacional nuevoVuelo = new VueloInternacional(aeropuertoOrigen, aeropuertoDestino, fecha, tripulantes, valorRefrigerio, cantRefrigerios, precios, cantAsientos, aeropuertosEscala);

            vuelos.put(nuevoVuelo.getCodigo(), nuevoVuelo);

            return nuevoVuelo.getCodigo();

        } catch (IllegalArgumentException ex) {

            throw ex;

        }
    }

    private Cliente[] buscarAcompañantes(int[] DNI){

        Cliente[] acompañantes = new Cliente[DNI.length];

        for(int i = 0; i < DNI.length; i++){

            if(clientes.containsKey(DNI[i])){

            acompañantes[i] = clientes.get(DNI[i]);

            } else {

                System.out.println("No existe ningún cliente con el DNI: " + DNI[i]);

            }
        }

        return acompañantes;

    }

    @Override
    public String VenderVueloPrivado(String origen, String destino, String fecha, int tripulantes, double precio,
            int dniComprador, int[] acompaniantes) {
        
        if(!clientes.containsKey(dniComprador)){
            throw new IllegalArgumentException("Error: el dni ingresado no corresponde a ningún cliente registrado en el sistema.");
        }

        Cliente comprador = clientes.get(dniComprador);

        Cliente[] pAcompañantes = buscarAcompañantes(acompaniantes);

        Aeropuerto aeropuertoOrigen = buscarAeropuertoNacional(origen);
        Aeropuerto aeropuertoDestino = buscarAeropuertoNacional(destino);

        try {
            
            VueloPrivado nuevoVuelo = new VueloPrivado(comprador, pAcompañantes, precio, tripulantes, aeropuertoOrigen, aeropuertoDestino, fecha);

            vuelos.put(nuevoVuelo.getCodigo(), nuevoVuelo);
            aeropuertoDestino.aumentarRecaudacion(precio);

            return nuevoVuelo.getCodigo();

        } catch (IllegalArgumentException ex) {
            throw ex;
        }
    }

    @Override
    public List<String> consultarVuelosSimilares(String origen, String destino, String Fecha) {
        
        List<String> vuelosSimilares = new ArrayList<>();         

        for (Vuelo vuelo : vuelos.values()) {
            
            Aeropuerto aeropuertoOrigen = vuelo.getOrigen();
            Aeropuerto aeropuertoDestino = vuelo.getDestino();
            String fechaDeVuelo = vuelo.getFechaDeSalida();

            if(Aeropuerto.compararDatos(aeropuertoOrigen, origen) && Aeropuerto.compararDatos(aeropuertoDestino, destino)){

                if(Vuelo.fechasSimilares(Fecha, fechaDeVuelo)) vuelosSimilares.add("" + vuelo.getCodigo() + "");

            }
        }

        if(vuelosSimilares.size() == 0) vuelosSimilares.add("No hay vuelos similares.");

        return vuelosSimilares;

    }

    @Override
    public void cancelarPasaje(int dni, String codVuelo, int nroAsiento) {

        if(!vuelos.containsKey(codVuelo)){
            throw new IllegalArgumentException("El código de vuelo ingresado no existe en el sistema.");
        }
        if(!clientes.containsKey(dni)){
            throw new IllegalArgumentException("El DNI ingresado no corresponde a ningún cliente del sistema.");
        }

        Vuelo vuelo = vuelos.get(codVuelo);

        vuelo.cancelarPasaje(dni, nroAsiento);


    }

    @Override
    public void cancelarPasaje(int dni, int codPasaje) {
    }

    @Override
    public List<String> cancelarVuelo(String codVuelo) {
        
        LinkedList<String> a = new LinkedList<>();

        if(vuelos.containsKey(codVuelo)){
            
            Vuelo vuelo = vuelos.get(codVuelo);
            Aeropuerto destino1 = vuelo.getDestino();
            List<Vuelo> vuelosConMismoDestino = buscarVueloPorDestino(destino1.getNombre());
            
            //esto tiene que devolver la lista de pasajeros que no se pudieron reasignar.
            reprogramarVuelo(vuelo, vuelosConMismoDestino);
        

        
        }

        return a;
    }

    private void reprogramarVuelo(Vuelo vueloInicial, List<Vuelo> vuelosConMismoDestino){

        Map<Integer, Pasajero> pasajeros = vueloInicial.getPasajeros();

        for (Vuelo vuelo : vuelosConMismoDestino) {
            
            for (Pasajero pasajero : pasajeros.values()) {

                vuelo.agregarPasajero(pasajero);
                
            }

        }

    }

    private List<Vuelo> buscarVueloPorDestino(String nombre){

        LinkedList<Vuelo> vuelosConMismoDestino = new LinkedList<>();

        for (Vuelo vuelo : vuelos.values()) {
            
            Aeropuerto aeropuerto = vuelo.getDestino();
            String nombreAeropuerto = aeropuerto.getNombre();

            if(nombreAeropuerto.equals(nombre)) vuelosConMismoDestino.add(vuelo);

        }

        return vuelosConMismoDestino;
    }

    @Override
    public double totalRecaudado(String destino) {
        
        Aeropuerto aeropuertoSolicitado = getAeropuerto(destino);

        return aeropuertoSolicitado.getRecaudacion();
    }

    @Override
    public String detalleDeVuelo(String codVuelo) {
        
        String detalleString = "Error: el código de vuelo ingresado es inválido";

        if(vuelos.containsKey(codVuelo)){

            Vuelo vuelo = vuelos.get(codVuelo);
            detalleString = vuelo.toString();
        }

        return detalleString;
    }

    @Override
    public int venderPasaje(int dni, String codVuelo, int nroAsiento, boolean aOcupar) {
        
        if(!clientes.containsKey(dni) || clientes.get(dni) == null){
            throw new IllegalArgumentException("Error: solo los clientes registrados pueden comprar pasajes.");
        }
        if(!vuelos.containsKey(codVuelo) || vuelos.get(codVuelo) == null){
            throw new IllegalArgumentException("Error: el vuelo ingresado no existe.");
        }

        Cliente comprador = clientes.get(dni);
        Vuelo vuelo = vuelos.get(codVuelo);

        vuelo.agregarPasajero(comprador, nroAsiento, aOcupar);

        return 1;
    }

    @Override
    public Map<Integer, String> asientosDisponibles(String codVuelo) {
        
        if(!vuelos.containsKey(codVuelo)){
            throw new IllegalArgumentException("Error: el código de vuelo ingresado es inválido.");
        }
        
        Vuelo vuelo = vuelos.get(codVuelo);
        Map<Integer, String> asientosDisponibles = vuelo.getAsientosDisponibles();
        
        return asientosDisponibles;
        
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();

        sb.append("\n-------------------------Vuelos registrados-------------------------\n\n");

        for (Vuelo vuelo : vuelos.values()) {

            sb.append(vuelo.toString() + "\n");
            
        }

        sb.append("\n-------------------------Clientes registrados-------------------------\n\n");

        for (Cliente cliente : clientes.values()) {
            
            sb.append(cliente.toString() + "\n");

        }

        sb.append("\n-------------------------Aeropuertos registrados-------------------------\n\n");

        for (Aeropuerto aeropuerto : aeropuertos.values()) {
            
            sb.append(aeropuerto.toString() + "\n");

        }

        return sb.toString();

    }

}
