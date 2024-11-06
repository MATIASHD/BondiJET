package bondiJET;

import java.util.*;

public class Pasajero {
	//Atributo
	private Cliente cliente;
    private int refrigeriosConsumidos;
    private ArrayList<Asiento> asientosAsignados;
    
    //Constructor
    public Pasajero(Cliente cliente) {
    	this.cliente = cliente;
        this.asientosAsignados = new ArrayList<>();
    }

    //Metodo
    public void asignarAsiento(Asiento asiento){
        this.asientosAsignados.add(asiento);
    }
    public Asiento isAsientoAsignado(int numeroDeAsiento){
        for (Asiento asiento : this.asientosAsignados) {
            if(asiento.obtenerNumAsiento() == numeroDeAsiento) {
            	return asiento;
            }
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    

    public Cliente ObtenerPasajero(){
        
        return cliente;
    }
    

    

    public void AsignarRefrigerio(int consumision){

        refrigeriosConsumidos += consumision;

    }

    public int ObtenerRefrigerio(){
        
        return refrigeriosConsumidos;
    }

}
