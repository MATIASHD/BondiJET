package bondiJET;

public class Aeropuerto {

    public Aeropuerto(String nombre, String pais, String provincia, String direccion) {
    
        if(nombre.length() > 0) this.nombre = nombre;
        if(pais.length() > 0) this.pais = pais;
        if(provincia.length() > 0) this.provincia = provincia;
        if(direccion.length() > 0) this.direccion = direccion;
        this.recaudacion = 0.0;

    }

    private String nombre;
    private String pais;
    private String provincia;
    private String direccion;
    private Double recaudacion;

    public void nuevoAeropuerto(){
        
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
            direccion.equals(aeropuerto.getDireccion()) && recaudacion.equals(aeropuerto.getRecaudacion())) resultado = true;

        return resultado;

    }

    public static boolean compararDatos(Aeropuerto aeropuerto, String dato){

        if(aeropuerto.pais == dato || aeropuerto.nombre == dato || aeropuerto.direccion == dato || aeropuerto.provincia == dato) return true;

        return false;
    }

}
