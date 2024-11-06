package bondiJET;

import java.util.*;

public class VueloNacional extends Vuelo implements IVuelosPublicos{
	
	//Atributos
	private LinkedList<Seccion> secciones;
	
	//Constructor
    public VueloNacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, double[] precios, int[] cantAsientos){

        super(cantidadDeTripulantes, origen, destino, salida, llegada, cantidadDeAsientos);

        this.secciones = new LinkedList<Seccion>();
    }

    
    //Metodos
    @Override
    public void obtenerAsientosDisponibles() {
        
        int asientosDisponibles;

        for (Seccion seccion : secciones) {
            
           seccion.obtenerAsientosDisponibles();

        }

    }

    @Override
    public void organizarSecciones() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'organizarSecciones'");
    }

    @Override
    public Seccion obtenerSeccion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerSeccion'");
    }

    @Override
    public double calcularImpuesto(double subTotal) {

        throw new UnsupportedOperationException("Unimplemented method 'calcularImpuesto'");
    }

}
