package bondiJET;

public class Cliente {
	//Atributo
	private int dni;
    private String nombre;
    private String telefono;

    //Constructor
    public Cliente(int dni, String nombre, String telefono){
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    //Metodo
    public int obtenerDNI(){
        return dni;
    }

    public String obtenerNombre(){
        return nombre;
    }

    public String obtenerTelefono(){
        return telefono;
    }

}
