package bondiJET;

public class VueloNacional extends Vuelo{

    private int CANTIDAD_DE_REFRIGERIOS;
    private double PRECIO_DEL_REFRIGERIO;

    public VueloNacional(Aeropuerto origen, Aeropuerto destino, String salida, int cantidadDeTripulantes, double[] precios, int[] cantAsientos, double valorRefrigerio){

        super(origen, destino, salida, cantidadDeTripulantes, 20.0, 2);

        double PORCENTAJE_DE_IMPUESTO = 30;
        if(cantAsientos.length == 0 || cantAsientos[0] <= 0 || cantAsientos[1] <= 0){
            throw new IllegalArgumentException("Error: cantidad de asientos inválida.");
        }
        if(valorRefrigerio < 0){
            throw new IllegalArgumentException("Error: el precio del refrigerio no puede ser negativo");
        }
        
        inicializarSecciones(precios, cantAsientos);
        setSufijo("-PUB");

        CANTIDAD_DE_REFRIGERIOS = 1;
        if(valorRefrigerio >= 0) this.PRECIO_DEL_REFRIGERIO = valorRefrigerio;
        
    }

    @Override
    public void inicializarSecciones(double[] precios, int[] cantidadDeAsientos){

        Seccion[] secciones = getSecciones();
        
        secciones[0] = new Seccion("Clase Turista", 0, precios[0]);
        secciones[1] = new Seccion("Clase Ejecutivo", 1, precios[1]);

        secciones = cargarAsientos(secciones, cantidadDeAsientos);

        setSecciones(secciones);
    }

    private Seccion[] cargarAsientos(Seccion[] secciones, int[] cantDeAsientosXSeccion){

        int CANTIDAD_TOTAL_DE_ASIENTOS = cantDeAsientosXSeccion[0] += cantDeAsientosXSeccion[1];
        int j = 0;
        for(int i = 1; i <= CANTIDAD_TOTAL_DE_ASIENTOS; i++){

            if(i <= cantDeAsientosXSeccion[j]){

                agregarAsiento(secciones[j], i);

            } else {

                j++;

            }

        }

        return secciones;

    }

    private void agregarAsiento(Seccion seccion, int NUMERO_DE_ASIENTO){
        
        boolean ESTADO_INICIAL = false;

        Asiento asiento = new Asiento(NUMERO_DE_ASIENTO, ESTADO_INICIAL);
        
        seccion.AgregarAsiento(asiento);
        super.setAsiento(asiento);
    }

    public Seccion getSeccion(int numeroDeSeccion) {
        
        Seccion seccionSolicitada = null;

        for (Seccion seccion : getSecciones()) {

            if(seccion.getNumeroDeSeccion() == numeroDeSeccion) seccionSolicitada = seccion;
            
        }

        return seccionSolicitada;
    }

    public double getValorDelPasaje(int numeroDeSeccion){

        try {
            
            Seccion seccionSolicitada = buscarSeccion(numeroDeSeccion);
            return seccionSolicitada.getPrecio();

        } catch (Exception e) {
            
            throw e;

        }

    }

    private Seccion buscarSeccion(int numeroDeSeccion){

        Seccion[] secciones = getSecciones();

        for (Seccion seccion : secciones) {
            
            if(seccion.getNumeroDeSeccion() == numeroDeSeccion) return seccion;

        }

        return null;

    }

    @Override
    public String toString() {
        
        return super.toString() + "NACIONAL";

    }
}
