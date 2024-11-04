package AppSource;

import java.util.*;

public abstract class Vuelo{

    public Vuelo(int cantidadDeTripulantes, Aeropuerto origen, Aeropuerto destino, Date Salida, Date Llegada,
                int cantidadDeAsientos){

        this.cantidadDeTripulantes = cantidadDeTripulantes;
        this.origen = origen;
        this.destino = destino;
        this.fechaYhoraDeSalida = Salida;
        this.fechaYhoraDeLlegada = Llegada;

    }

    private int codigoDelVuelo;
    private int cantidadDeTripulantes;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private Date fechaYhoraDeSalida;
    private Date fechaYhoraDeLlegada;
    private LinkedList<Pasajero> pasajeros;
    private int impuesto;

    public double obtenerValorDelPasaje(Seccion area){

        return 0;
    }

    public void borrarPasajeroYAsiento(Pasajero pasajero, Asiento asiento){

    }
    
    public Pasajero obtenerListaDePasajeros(){

        return null;
    }
    
    public Aeropuerto obtenerOrigen(){

        return null;
    }
    
    public Aeropuerto obtenerDestino(){

        return null;
    }

    public abstract double calcularImpuesto(double subTotal);

}
