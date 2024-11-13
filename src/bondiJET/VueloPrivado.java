package bondiJET;


import java.util.Map;

import javax.management.RuntimeErrorException;

public class VueloPrivado extends Vuelo{

    private Cliente comprador;
    private Cliente[] acompañantes;
    private int cantidadDeJets;
    private double PRECIO_X_JET;
    private int CANTIDAD_DE_ASIENTOS_X_JET;
    private double COSTE_TOTAL;
    
    public VueloPrivado(Cliente comprador, Cliente[] acompañantes, double precio,
                        int cantidadDeTripulantes, Aeropuerto origen, Aeropuerto destino, String fechaDeSalida){

        super(origen, destino, fechaDeSalida, cantidadDeTripulantes, 30.0, 1);

        if(comprador == null){
            throw new IllegalArgumentException("Error: el comprador no está registrado en el sistema.");
        }
        if(precio < 0){
            throw new IllegalArgumentException("Error: el precio es negativo o 0");
        }

        Seccion[] seccion = getSecciones();
        setSufijo("-PRI");

        seccion[0] = new Seccion("Seccion privada", precio);;

        this.comprador = comprador;
        this.acompañantes = acompañantes;
        this.cantidadDeJets = calcularJetsNecesarios(acompañantes.length);
        this.PRECIO_X_JET = precio;
        this.COSTE_TOTAL = calcularImpuesto(precio*cantidadDeJets);
    
    }

    
    public Cliente getComprador(){
        
        return comprador;

    }
    
    public double getPrecioPorJet(){
        
        return PRECIO_X_JET;

    }
    
    public Cliente[] getAcompañantes() {

        return acompañantes;
    
    }   
    
    private int calcularJetsNecesarios(int cantidadDeAcompañantes){
        
        int resultado = 0;
        
        if(cantidadDeAcompañantes <= 15){
            
            resultado = 1;
            
        } else {

            boolean bandera = true;
            int jets = 0;
            int acum = CANTIDAD_DE_ASIENTOS_X_JET;
            while(bandera == true){

                if(acum >= cantidadDeAcompañantes){
                    bandera = false;
                } else {

                    acum += 15;
                    jets++;

                }

            }

            resultado = jets;

        }

        return resultado;

    }

    public double getCosteTotal() {
        
        return COSTE_TOTAL;

    }

    @Override
    public void inicializarSecciones(double[] precios, int[] cantidadDeAsientos) {
    
        this.CANTIDAD_DE_ASIENTOS_X_JET = 15;

    }

    @Override
    public String toString() {
        
        return super.toString() + "PRIVADO " + "(" + cantidadDeJets + ")";

    }

    @Override
    public Map<Integer, String> getAsientosDisponibles() {
        throw new RuntimeException();
    }
}
