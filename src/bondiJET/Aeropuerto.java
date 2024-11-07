package bondiJET;

public class Aeropuerto {
	//Atributo
	private String nombre;
	private String pais;
    private String provincia;
    private String direccion;


    //Constructor
    public Aeropuerto(String nombre, String pais, String provincia, String direccion) {
    	this.pais = pais;
        this.nombre = nombre;
        this.provincia = provincia;
        this.direccion = direccion;
    }

    //Metodo
    public String obtenerNombre(){
        return this.nombre;
    }
    public String obtenerProvincia(){
        return this.provincia;
    }
    public String obtenerDireccion(){
        return this.direccion;
    }
    
}
