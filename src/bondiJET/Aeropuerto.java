package bondiJET;

public class Aeropuerto {

    public Aeropuerto(String nombre, String pais, String provincia, String direccion) {
    
        if(nombre.length() < 0){
            throw new IllegalArgumentException("Error: el nombre ingresado es inválido.");
        }
        if(pais.length() < 0){
            throw new IllegalArgumentException("Error: el pais ingresado es inválido.");
        }
        if(provincia.length() < 0){
            throw new IllegalArgumentException("Error: la provincia ingresada es inválida.");
        }
        if(direccion.length() < 0){
            throw new IllegalArgumentException("Error: la direción ingresada es inválida.");
        }
        
        this.nombre = nombre;
        this.pais = pais;
        this.provincia = provincia;
        this.direccion = direccion;
        this.recaudacion = 0.0;

    }

    private String nombre;
    private String pais;
    private String provincia;
    private String direccion;
    private Double recaudacion;

    public void nuevoAeropuerto(){
        
    }

    public void restarRecaudacion(double monto){

        recaudacion -= monto;

    }

    public void aumentarRecaudacion(double monto){

        recaudacion += monto;

    }

    public String getNombre(){

        return nombre;
    }
    public String getPais(){

        return pais;
    }
    public String getProvincia(){

        return provincia;
    }
    public String getDireccion(){

        return direccion;
    }
    public double getRecaudacion(){

        return recaudacion;
    }
    public void setRecaudacion(double importe){

        recaudacion += importe;

    }

    @Override
    public boolean equals(Object obj) {
        
        Aeropuerto aeropuerto = (Aeropuerto)obj;
        boolean resultado = false;
        
        if(nombre.equals(aeropuerto.getNombre()) && pais.equals(aeropuerto.getPais()) && provincia.equals(aeropuerto.getProvincia()) &&
            direccion.equals(aeropuerto.getDireccion()) && recaudacion == aeropuerto.getRecaudacion()) resultado = true;

        return resultado;

    }

    public static boolean compararDatos(Aeropuerto aeropuerto, String dato){

        if(aeropuerto.pais == dato || aeropuerto.nombre == dato || aeropuerto.direccion == dato || aeropuerto.provincia == dato) return true;

        return false;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();

        sb.append("Nombre: " + nombre + "\n");
        sb.append("Pais: " + pais + "\n");
        sb.append("Provincia: " + provincia + "\n");
        sb.append("Dirección: " + direccion + "\n");
        sb.append("Recaudación del destino: " + recaudacion  + "\n");

        return sb.toString();
    }

}
