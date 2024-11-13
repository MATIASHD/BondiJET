package bondiJET;

import java.util.*;

public class Aerolinea implements IAerolinea {

    public Aerolinea(String nombre, String cuit){

        if(nombre.length() > 0) this.nombre = nombre;
        if(cuit.length() > 0) this.cuit = cuit;

        this.aeropuertos = new LinkedList<Aeropuerto>();
        this.vuelos = new HashMap<String, Vuelo>();
        this.clientes = new HashMap<Integer, Cliente>();

    }

    String nombre;
    String cuit;
    LinkedList<Aeropuerto> aeropuertos;
    Map<String, Vuelo> vuelos;
    Map<Integer, Cliente> clientes;
    
    public Aeropuerto getAeropuerto(String nombre){

        Aeropuerto aeropuertoSolicitado = null;

        for (Aeropuerto aeropuerto : aeropuertos) {
            
            if(aeropuerto.getNombre() == nombre) aeropuertoSolicitado = aeropuerto; 

        }

        return aeropuertoSolicitado;

    }

    public void registrarCliente(int dni, String nombre, String telefono) {

        if(!clientes.containsKey(dni)){
         
            clientes.put(dni, new Cliente(dni, nombre, telefono));
        
        }
    }

    public void registrarAeropuerto(String nombre, String pais, String provincia, String direccion) {
    
        Aeropuerto nuevAeropuerto = new Aeropuerto(nombre, pais, provincia, direccion);

        if(aeropuertoYaRegistrado(nuevAeropuerto)){
            
            aeropuertos.add(nuevAeropuerto);
        
        }

    }

    private boolean aeropuertoYaRegistrado(Aeropuerto aeropuertoBuscado){

        for (Aeropuerto aeropuerto : aeropuertos) {
            
            if(aeropuerto.equals(aeropuertoBuscado)) return true;

        }

        return false;

    }

    private Aeropuerto buscarAeropuertoNacional(String clave){

        Aeropuerto aeropuertoSolicitado = null;

        for (Aeropuerto aeropuerto : aeropuertos) {
            
            if(aeropuerto.getProvincia() == clave || aeropuerto.getNombre() == clave || aeropuerto.getDireccion() == clave){

                if(aeropuerto.getPais() == "Argentina") aeropuertoSolicitado = aeropuerto; 

            }
        }

        return aeropuertoSolicitado;
    }
   
    private Aeropuerto buscarAeropuertoInternacional(String clave){
        
        Aeropuerto aeropuertoSolicitado = null;
        
        for (Aeropuerto aeropuerto : aeropuertos) {
            
            if(aeropuerto.getProvincia() == clave || aeropuerto.getNombre() == clave || aeropuerto.getDireccion() == clave){
                
                if(aeropuerto.getPais() != "Argentina") aeropuertoSolicitado = aeropuerto; 
                
            }
        }
        
        return aeropuertoSolicitado;
    }

    private Aeropuerto buscarAeropuertoPorNombre(String nombre){

        Aeropuerto aeropuertoSolicitado = null;

        for (Aeropuerto aeropuerto : aeropuertos) {
            
            if(aeropuerto.getNombre() == nombre) aeropuertoSolicitado = aeropuerto;

        }

        return aeropuertoSolicitado;

    }
    
    private Aeropuerto[] buscarEscalas(Aeropuerto origen, String[] aeropuertosEscala){

        Aeropuerto[] escalas = new Aeropuerto[aeropuertosEscala.length];

        for(int i = 0; i < aeropuertosEscala.length; i++){

            escalas[i] = buscarAeropuertoPorNombre(aeropuertosEscala[i]);

            if(escalas[i] == null || !escalas[i].equals(origen)){

                System.out.println("ERROR: el aeropuerto escala no existe.");
                return null;

            }

        }

        return escalas;

    }
  
    private Aeropuerto[] cargarEscalas(Aeropuerto origen, String[] escalas){

        if(escalas.length > 0){

            Aeropuerto[] aeropuertosEscala = null;
        
            aeropuertosEscala = buscarEscalas(origen, escalas);
            
            return aeropuertosEscala;
    
        } else return null;
    }

    @Override
    public String registrarVueloPublicoNacional(String origen, String destino, String fecha, int tripulantes,
                                                    double valorRefrigerio, double[] precios, int[] cantAsientos) {
                
        Aeropuerto AeropuertoOrigen = buscarAeropuertoNacional(origen);
        Aeropuerto AeropuertoDestino = buscarAeropuertoNacional(destino);
        
        VueloNacional nuevoVuelo = new VueloNacional(AeropuertoOrigen, AeropuertoDestino, fecha, tripulantes, precios, cantAsientos, valorRefrigerio);

        String codigoDelDiccionario = nuevoVuelo.getCodigo() + "-PUB";
        vuelos.put(codigoDelDiccionario, nuevoVuelo);

        return codigoDelDiccionario;
    }

    @Override
    public String registrarVueloPublicoInternacional(String origen, String destino, String fecha, int tripulantes,
            double valorRefrigerio, int cantRefrigerios, double[] precios, int[] cantAsientos, String[] escalas){
    
        Aeropuerto aeropuertoOrigen = buscarAeropuertoNacional(origen);
        Aeropuerto aeropuertoDestino = buscarAeropuertoInternacional(destino);
        Aeropuerto[] aeropuertosEscala = null;

        if(escalas.length > 0) {

            aeropuertosEscala = cargarEscalas(aeropuertoOrigen, escalas);

        }

        VueloInternacional nuevoVuelo = new VueloInternacional(aeropuertoOrigen, aeropuertoDestino, fecha, tripulantes, valorRefrigerio, cantRefrigerios, precios, cantAsientos, aeropuertosEscala);

        String codigoDelDiccionario = nuevoVuelo.getCodigo() + "-PUB";
        vuelos.put(codigoDelDiccionario, nuevoVuelo);

        return codigoDelDiccionario;

    }

    private Cliente[] buscarAcompañantes(int[] DNI){

        Cliente[] acompañantes = new Cliente[DNI.length];

        for(int i = 0; i < DNI.length; i++){

            acompañantes[i] = clientes.get(DNI[i]);

        }



        return acompañantes;

    }

    @Override
    public String VenderVueloPrivado(String origen, String destino, String fecha, int tripulantes, double precio,
            int dniComprador, int[] acompaniantes) {
        
        Cliente comprador = clientes.get(dniComprador);
        Cliente[] pAcompañantes = buscarAcompañantes(acompaniantes);

        Aeropuerto aeropuertoOrigen = buscarAeropuertoNacional(origen);
        Aeropuerto aeropuertoDestino = buscarAeropuertoNacional(destino);

        VueloPrivado nuevoVuelo = new VueloPrivado(comprador, pAcompañantes, precio, tripulantes, aeropuertoOrigen, aeropuertoDestino, fecha);

        String codigoDelDiccionario = nuevoVuelo.getCodigo() + "-PRI";
        vuelos.put(codigoDelDiccionario, nuevoVuelo);

        return codigoDelDiccionario;
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

        Vuelo vuelo = vuelos.get(codVuelo + "-PUB");

        vuelo.cancelarPasaje(dni, nroAsiento);


    }

    @Override
    public void cancelarPasaje(int dni, int codPasaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarPasaje'");
    }

    @Override
    public List<String> cancelarVuelo(String codVuelo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarVuelo'");
    }

    @Override
    public double totalRecaudado(String destino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalRecaudado'");
    }

    @Override
    public String detalleDeVuelo(String codVuelo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'detalleDeVuelo'");
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
        
        Vuelo vuelo = vuelos.get(codVuelo);

        return vuelo.getAsientosDisponibles();
        
    }

}
