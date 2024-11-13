package bondiJET;

import java.util.*;

public class Pasajero {

    private Cliente cliente;
    private int refrigeriosConsumidos;

    public Pasajero(Cliente cliente){

        if(cliente == null){
            throw new IllegalArgumentException("Error: Cliente nulo.");
        }

        this.refrigeriosConsumidos = 0;
        this.cliente = cliente;

    }

    public Cliente getDatos(){
        
        return cliente;
    }

    public void AsignarRefrigerio(int consumision){

        refrigeriosConsumidos += consumision;

    }

    public int getRefrigerio(){
        
        return refrigeriosConsumidos;
    }

    @Override
    public String toString() {
        
        return "Datos del pasajero: Nombre: " + cliente.getNombre() + " DNI: " + cliente.getDni() + " telefono: " + cliente.getTelefono() + " refrigerios consumidos: " + refrigeriosConsumidos;

    }

}
