package bondiJET;

import java.util.*;

public class Pasajero {
	//Atributo
	private Cliente cliente;
    private int refrigeriosConsumidos;
    private List<Asiento> asientosAsignados = new ArrayList<>();
    
    //Constructor
    public Pasajero(Cliente cliente, int refrigerio, ArrayList<Asiento> asiento) {
    	this.cliente = cliente;
    	this.refrigeriosConsumidos = refrigerio;
        this.asientosAsignados = asiento;
    }

    //Metodo
    public boolean estaElAasiento(int numAsiento) {
    	for (Asiento asiento : this.asientosAsignados) {
    		if (asiento.numeroDeAsiento == numAsiento) {
    			return true;
    		};
    	}
    	return false;
    }
  
    public void asignarAsiento(Asiento asiento){
        this.asientosAsignados.add(asiento);
    }
    
    public Cliente obtenerCliente() {
    	return cliente;
    }


    public void AsignarRefrigerio(int consumision){
        refrigeriosConsumidos = consumision;
    }

    public int ObtenerRefrigerio(){
        return refrigeriosConsumidos;
    }

}
