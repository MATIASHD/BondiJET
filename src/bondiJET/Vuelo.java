package bondiJET;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public abstract class Vuelo{

    private static int contadorHash = 0;
    private String codigoDeVuelo;
    private int cantidadDeTripulantes;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private String fechaYhoraDeSalida;
    private double IMPUESTO;
    private Seccion[] secciones;
    private Map<Integer, Asiento> asientos;
    private Map<Integer, Pasajero> pasajeros;

    public Vuelo(Aeropuerto origen, Aeropuerto destino, String FechaDesalida, int tripulantes, double porcentajeDeImpuesto, int cantSecciones){

        if(!validarAeropuertos(origen, destino)){
            throw new IllegalArgumentException("Error: el aeropuerto de origen o destino es inválido.");
        }
        if(!validarFecha(FechaDesalida)){
            throw new IllegalArgumentException("Error: la fecha de salida es inválida.");
        }
        if(tripulantes <= 0){
            throw new IllegalArgumentException("Error: la cantidad de tripulantes no es válida.");
        }
        if(porcentajeDeImpuesto <= 0){
            throw new IllegalArgumentException("Error: el porcentaje de impuesto no puede ser negativo.");
        }

        this.secciones = new Seccion[cantSecciones];
        this.contadorHash++;
        this.codigoDeVuelo = "" + hashCode();
        this.origen = origen;
        this.destino = destino;
        this.fechaYhoraDeSalida = FechaDesalida;
        this.IMPUESTO = porcentajeDeImpuesto;
        this.asientos = new HashMap<Integer, Asiento>();
        this.pasajeros = new HashMap<Integer, Pasajero>();
    }

    public abstract void inicializarSecciones(double[] precios, int[] cantidadDeAsientos);

    public Seccion[] getSecciones(){

        return secciones;
    }

    public void setAsiento(Asiento asiento){

        asientos.put(asiento.getNumeroDeAsiento(), asiento);

    }
    
    public Map<Integer, Asiento> listaDePasajeros(){
    	return  this.asientos;
    }

    public void setSecciones(Seccion[] listaSecciones){

        this.secciones = listaSecciones;

    }

    private boolean validarFecha(String fecha){

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate fechaEntrada = LocalDate.parse(fecha, formateador);

            /**
             * Esta linea de código devuelve la fecha actual con el formato "dd/mm/yyyy", para descomentarla
             * y que funcione bien, se debe ajustar las fechas de salida de los vuelos en la clase principal
             * de otra manera, el método after() devolverá siempre "false" y no funcionará lo demás.
             *  
             * LocalDate fechaAct = LocalDate.now();
             *  
            **/

            // esta linea crea una fecha actual falsa, solo está a modo de ejemplo.
            LocalDate fechaActual = LocalDate.of(2024, 11, 5);

            if(fechaEntrada.isAfter(fechaActual)){
                return true;

            } else return false;

        } catch (DateTimeParseException ex) {

            System.out.println(ex);
            return false;
        }

    }

    public String getCodigo(){

        return codigoDeVuelo;

    }

    public void setSufijo(String apendice){

        this.codigoDeVuelo += apendice;

    }

    @Override
    public int hashCode() {
       
        return contadorHash;
    }

    private boolean validarAeropuertos(Aeropuerto origen, Aeropuerto destino){

        boolean resultado = false;

        if(destino != null && origen != null){

            if(!origen.equals(destino)){

                resultado = true;
            
            }
        }

        return resultado;

    }

    public double getImpuesto(){

        return IMPUESTO;

    }

    public int getCantidadDeTripulantes(){

        return cantidadDeTripulantes;

    }

    public String getFechaDeSalida(){

        return fechaYhoraDeSalida;

    }

    public Aeropuerto getOrigen(){

        return origen;
    }

    public Aeropuerto getDestino(){

        return destino;
    }

    public double calcularImpuesto(double subTotal){

        return subTotal += (subTotal*IMPUESTO)/100;

    }
    
    //Costo 
    public abstract double getCosteTotal();

    public Map<Integer, String> getAsientosDisponibles() {
        
        LinkedList<Asiento> asientosLibres = new LinkedList<Asiento>();
        Seccion[] secciones = getSecciones();
        Map<Integer, String> resultado = new HashMap<Integer,String>();

        for(int i = 0; i < secciones.length; i++){

            asientosLibres.addAll(secciones[i].getAsientosDisponibles());

            for(Asiento asiento: asientosLibres) {
                
                resultado.put(asiento.getNumeroDeAsiento(), secciones[i].getNombreSeccion());

            }
        }

        return resultado;
    }

    public static boolean fechasSimilares(String fecha1, String fecha2){
    
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

        try{

            Date fechaInicial = formato.parse(fecha1);
            Date fechaDelVuelo = formato.parse(fecha2);

            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaInicial);
            calendario.add(Calendar.DAY_OF_YEAR, 7);
            Date fechaFinal = calendario.getTime();

            if(!fechaDelVuelo.before(fechaInicial) && !fechaDelVuelo.after(fechaFinal)) return true;

        } catch(ParseException ex){
            System.err.println("Error: no se pudo comparar las fechas.");
        }

        return false;
    }

    public Map<Integer, Pasajero> getPasajeros(){

        return pasajeros;
    }

    public void agregarPasajero(Cliente comprador, int nroAsiento, boolean aOcupar){
    
        pasajeros.put(comprador.getDni(), new Pasajero(comprador));
        Asiento asiento = asientos.get(nroAsiento);
        System.out.println(asiento);
        if(asiento != null) {        	
        	asiento.comprar();
        	Seccion seccionElegida = buscarSeccionDeAsiento(nroAsiento);
        	destino.aumentarRecaudacion(seccionElegida.getPrecio());
        }
        if(aOcupar == true) asiento.ocupar(aOcupar);
        
    }   

    public void agregarPasajero(Pasajero pasajero){

            Cliente cliente = pasajero.getCliente();
            Seccion seccionVieja = null;
            Map<Integer, Asiento> asientosViejos = pasajero.getAsientos();
            
            
            for (Asiento asiento : asientosViejos.values()) {
                
                seccionVieja = buscarSeccionDeAsiento(asiento.getNumeroDeAsiento());
                break;

            }

            if(seccionVieja != null){
                
                pasajeros.put(cliente.getDni(), new Pasajero(cliente));
                
                for(Asiento asientoNuevo : seccionVieja.getAsientosDisponibles()){

                    asientoNuevo.comprar();
                    asientoNuevo.ocupar(true);
                }
            }

    
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(codigoDeVuelo + " - ");
        sb.append(origen.getNombre() + " - ");
        sb.append(destino.getNombre() + " - ");
        sb.append(fechaYhoraDeSalida + " - ");

        return sb.toString();

    }

    private double buscarPrecioDelAsiento(int nroAsiento){

        double precio = 0;

        for (Seccion seccion : secciones) {
            
            if(seccion.contieneElAsiento(nroAsiento)) precio = seccion.getPrecio();

        }

        return precio;

    }

    public boolean cancelarPasaje(int dni, int nroAsiento) {
        
        boolean resultado = false;

        if(pasajeros.containsKey(dni)){

            Pasajero pasajero = pasajeros.get(dni);

            if(pasajero.getAsiento(nroAsiento) != null){
            
                Asiento asientoACancelar = pasajero.getAsiento(nroAsiento);
                double montoAbonado = buscarPrecioDelAsiento(nroAsiento);
                
                destino.restarRecaudacion(montoAbonado);
                asientoACancelar.liberar();
                

                resultado = true;
            
            }

        }

        return resultado;
    }

    private Seccion buscarSeccionDeAsiento(int nroAsiento){

        Seccion seccionBuscada = null;

        for (Seccion seccion : secciones) {
            
            if(seccion.contieneElAsiento(nroAsiento)){

                seccionBuscada = seccion;

            }

        }

        return seccionBuscada;
    }

}