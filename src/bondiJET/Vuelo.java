package bondiJET;

import java.util.*;

public abstract class Vuelo{
	//Atributo
	private int codigoDelVuelo;
    private int cantidadDeTripulantes;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private Date fechaYhoraDeSalida;
    private ArrayList<Pasajero> pasajeros;
    private int impuesto;
    
    //Constructor
    public Vuelo(int cantidadDeTripulantes, Aeropuerto origen, Aeropuerto destino, Date Salida,int cantidadDeAsientos){
        this.cantidadDeTripulantes = cantidadDeTripulantes;
        this.origen = origen;
        this.destino = destino;
        this.fechaYhoraDeSalida = Salida;
        this.pasajeros = new ArrayList<>();
    }

}
