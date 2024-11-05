package AppSource;

import java.util.*;

public class Pasajero {
	//Atributo
	private Cliente cliente;
    private LinkedList<Asiento> asientos;
    private int refrigeriosConsumidos;
    
    //Constructor
    public Pasajero(Cliente cliente, Asiento asiento){

        this.asientos = new LinkedList<Asiento>();
        this.refrigeriosConsumidos = 0;

        this.cliente = cliente;
        this.asientos.add(asiento);

    }

    //Metodo
    public void AsignarAsiento(Asiento asiento){

        asientos.add(asiento);

    }

    public Cliente ObtenerPasajero(){
        
        return cliente;
    }

    public Asiento ObtenerAsiento(int numeroDeAsiento){
        
        for (Asiento var : asientos) {
            
            if(var.numeroDeAsiento == numeroDeAsiento) return var; 

        }

        return null;
    }

    public void AsignarRefrigerio(int consumision){

        refrigeriosConsumidos += consumision;

    }

    public int ObtenerRefrigerio(){
        
        return refrigeriosConsumidos;
    }

}
