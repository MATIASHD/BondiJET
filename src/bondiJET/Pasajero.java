package bondiJET;

import java.util.*;

public class Pasajero {

    private Cliente cliente;
    private int refrigeriosConsumidos;
    private Map<Integer, Asiento> asientos;

    public Pasajero(Cliente cliente){

        if(cliente == null){
            throw new IllegalArgumentException("Error: Cliente nulo.");
        }

        this.refrigeriosConsumidos = 0;
        this.cliente = cliente;
        this.asientos = new HashMap<Integer, Asiento>();

    }

    public boolean eliminarAsiento(int nroAsiento){

        
        if(asientos.containsKey(nroAsiento)){
            
            asientos.remove(nroAsiento);
            return true;
        }

        return false;

    }

    public Asiento getAsiento(int nroAsiento){

        return asientos.get(nroAsiento);
    }

    public Map<Integer, Asiento> getAsientos() {

        return asientos;
    
    }

    public boolean agregarAsiento(Asiento asiento){

        if(asientos.containsKey(asiento.getNumeroDeAsiento())) return false;

        asientos.put(asiento.getNumeroDeAsiento(), asiento);
        return true;

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