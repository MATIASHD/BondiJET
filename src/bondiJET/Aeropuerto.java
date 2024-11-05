package AppSource;

public class Aeropuerto {
	//Atributo
	private String nombre;
    private String pais;
    private String provincia;
    private String direccion;
    private Double recaudacion;

    //Constructor
    public Aeropuerto(String nombre, String pais, String provincia, String direccion) {
    
        if(nombre.length() > 0) this.nombre = nombre;
        if(pais.length() > 0) this.pais = pais;
        if(provincia.length() > 0) this.provincia = provincia;
        if(direccion.length() > 0) this.direccion = direccion;
        this.recaudacion = 0.0;

    }

    //Metodo
    public void nuevoAeropuerto(){
        
    }

    public String getNombre(){

        return "";
    }
    public String getProvincia(){

        return "";
    }
    public String getDireccion(){

        return "";
    }

    public double getRecaudacion(){

        return recaudacion;
    }

    public void setRecaudacion(double importe){

        recaudacion += importe;

    }

}
