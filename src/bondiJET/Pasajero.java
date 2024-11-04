package AppSource;

import java.util.*;

public class Pasajero {

    public Pasajero(Cliente cliente, Asiento asiento){

        this.asientos = new LinkedList<Asiento>();
        this.refrigeriosConsumidos = 0;

        this.cliente = cliente;
        this.asientos.add(asiento);

    }

    Cliente cliente;
    LinkedList<Asiento> asientos;
    int refrigeriosConsumidos;

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
