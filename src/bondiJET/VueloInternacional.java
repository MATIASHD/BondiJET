package bondiJET;


public class VueloInternacional extends Vuelo{

    private Aeropuerto[] escalas;
    private int CANTIDAD_DE_REFRIGERIOS;
    private double PRECIO_DEL_REFRIGERIO;

    public VueloInternacional(Aeropuerto origen, Aeropuerto destino, String salida, int cantidadDeTripulantes, 
                            double valorRefrigerio, int cantRefrigerios, double[] precios, int[] cantAsientos, Aeropuerto[] escalas){
            
            super(origen, destino, salida, cantidadDeTripulantes, 20.0, 3);

            if(cantAsientos.length == 0 || cantAsientos[0] <= 0 || cantAsientos[1] <= 0 || cantAsientos[2] <= 0){
                throw new IllegalArgumentException("Error: cantidad de asientos inválida.");
            }
            if(cantRefrigerios <= 0){
                throw new IllegalArgumentException("Error: la cantidad de refrigerios es inválida.");
            }
            if(valorRefrigerio < 0){
                throw new IllegalArgumentException("Error: el precio del refrigerio no puede ser negativo");
            }

            inicializarSecciones(precios, cantAsientos);
            setSufijo("-PUB");
            
            this.escalas = escalas;
            this.CANTIDAD_DE_REFRIGERIOS = cantRefrigerios;
            this.PRECIO_DEL_REFRIGERIO = valorRefrigerio;
            
    }
    @Override
    public double getCosteTotal() {
        return 0;

    }

    @Override
    public void inicializarSecciones(double[] precios, int[] cantidadDeAsientos){

        Seccion[] secciones = getSecciones();

        secciones[0] = new Seccion("Clase Turista", 0, precios[0]);
        secciones[1] = new Seccion("Clase Ejecutivo", 1, precios[1]);
        secciones[2] = new Seccion("Primera clase", 2, precios[2]);
        
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
    
    public Aeropuerto[] getEscalas(){

        return escalas;

    }

    public Asiento buscarAsiento(int numeroDeAsiento){

        Seccion[] secciones = getSecciones();
        Asiento asientoSolicitado = null;

        for (Seccion seccion : secciones) {
            
            asientoSolicitado = seccion.buscarAsiento(numeroDeAsiento);

        }

        return asientoSolicitado;

    }

    public Seccion getSeccion(int numeroDeseccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSeccion'");
    }

    public double getValorDelPasaje(int numeroDeSeccion) {
        
        Seccion[] secciones = getSecciones();
        
        return secciones[numeroDeSeccion].getPrecio(); 

    }

    @Override
    public String toString() {
        
        return super.toString() + "INTERNACIONAL";

    }
}
