package AppSource;

import java.util.*;

public class VueloPrivado extends Vuelo{
	
	//Atributos
	private Cliente comprador;
    private LinkedList<Cliente> acompañantes;
    private int cantidadDeJets;
    private double PrecioPorJet;
    private int cantidadDeAsientosPorJet;
    private double costeTotal;
    
    //Constructor
    public VueloPrivado(Cliente comprador, LinkedList<Cliente> acompañantes, double precio,
                        int cantidadDeTripulantes, Aeropuerto origen, Aeropuerto destino, Date salida, Date llegada){

        super(cantidadDeTripulantes, origen, destino, salida, llegada, acompañantes.size());

        this.comprador = comprador;
        this.acompañantes = acompañantes;

        this.cantidadDeJets = calcularJetsNecesarios(acompañantes.size());
        this.PrecioPorJet = precio;
        this.cantidadDeAsientosPorJet = 15;
        this.costeTotal = calcularImpuesto(precio*cantidadDeJets);
    
    }

    
    //Metodos
    private int calcularJetsNecesarios(int cantidadDeAcompañantes){
        
        int resultado = 0;

        if(acompañantes.size() <= 15){

            resultado = 1;

        } else {

            boolean bandera = true;
            int i = 1;
            int acum = cantidadDeAsientosPorJet;
            while(bandera == true){

                if(acum >= acompañantes.size()){
                    bandera = false;
                } else {

                    acum += 15;
                    i++;

                }

            }

            resultado = i;

        }

        return resultado;

    }

    public int obtenerAsientosDisponibles() {

        return cantidadDeAsientosPorJet * cantidadDeJets - acompañantes.size();

    }

    @Override
    public double calcularImpuesto(double subTotal) {
        
        return subTotal += (subTotal*20)/100;

    }

    @Override
    public double obtenerValorDelPasaje(Seccion area) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerValorDelPasaje'");
    }

    @Override
    public void borrarPasajeroYAsiento(Pasajero pasajero, Asiento asiento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarPasajeroYAsiento'");
    }

    @Override
    public Pasajero obtenerListaDePasajeros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerListaDePasajeros'");
    }

    @Override
    public Aeropuerto obtenerOrigen() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerOrigen'");
    }

    @Override
    public Aeropuerto obtenerDestino() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDestino'");
    }

}
