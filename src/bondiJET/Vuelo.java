package bondiJET;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Vuelo{

    private static int contador = 0;
    private int codigoDeVuelo;
    private int cantidadDeTripulantes;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private String fechaYhoraDeSalida;
    private double IMPUESTO;
    private Seccion[] secciones;
    private Map<Integer, Asiento> asientos;
    private Map<Integer, Pasajero> pasajeros;

    public Vuelo(Aeropuerto origen, Aeropuerto destino, String FechaDesalida, int tripulantes, double porcentajeDeImpuesto, int cantSecciones){

        if(validarAeropuertos(origen, destino)){
            throw new IllegalArgumentException("Error: el aeropuerto de origen o destino es inválido.");
        }
        if(validarFecha(FechaDesalida) == false){
            throw new IllegalArgumentException("Error: la fecha de salida es inválida.");
        }
        if(tripulantes <= 0){
            throw new IllegalArgumentException("Error: la cantidad de tripulantes no es válida.");
        }
        if(porcentajeDeImpuesto <= 0){
            throw new IllegalArgumentException("Error: el porcentaje de impuesto no puede ser negativo.");
        }


        this.secciones = new Seccion[cantSecciones];
        this.contador++;
        this.codigoDeVuelo = hashCode();
        this.origen = origen;
        this.destino = destino;
        this.fechaYhoraDeSalida = FechaDesalida;
        this.IMPUESTO = porcentajeDeImpuesto;
        this.asientos = new HashMap<Integer, Asiento>();
        this.pasajeros = new HashMap<Integer, Pasajero>();
    }

    public void inicializarSecciones(double[] precios, int[] cantidadDeAsientos){

    }

    public Seccion[] getSecciones(){

        return secciones;
    }

    public void setAsiento(Asiento asiento){

        asientos.put(asiento.getNumeroDeAsiento(), asiento);

    }

    public void setSecciones(Seccion[] listaSecciones){

        this.secciones = listaSecciones;

    }

    private boolean validarFecha(String fecha){

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            
            Date fecha1 = formato.parse(fecha);

            Date fechaActual = new Date();
            String fechaActualStr = formato.format(fechaActual);
            Date fechaActualFormateada = formato.parse(fechaActualStr);

            if(fecha1.after(fechaActualFormateada)){

                return true;

            } else return false;

        } catch (ParseException ex) {

            System.out.println(ex);
            return false;
        }

    }

    public int getCodigo(){

        return codigoDeVuelo;

    }

    @Override
    public int hashCode() {
        
        return contador;
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
        asiento.comprar();
        if(aOcupar == true) asiento.ocupar(aOcupar);
        
    }   
    public void cancelarPasaje(int dni, int nroAsiento){

        pasajeros.remove(dni);

        Asiento asiento = asientos.get(nroAsiento);

        asiento.liberar();

        asiento.liberar();
    }
}