package bondiJET;

public class Cliente {

    public Cliente(int dni, String nombre, String telefono){

        if(dni > 0) this.dni = dni;
        if(validarNombre(nombre)) this.nombre = nombre;
        if(validarTelefono(telefono)) this.telefono = telefono;

    }

    private int dni;
    private String nombre;
    private String telefono;

    private boolean validarTelefono(String telefono){

        Boolean telefonoValido = telefono.length() > 0 && telefono.matches("[0-9]+");

        return telefonoValido;
    }

    private boolean validarNombre(String nombre){

        Boolean nombreValido = nombre.length() > 0 && nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ]+");

        return nombreValido;
    }

    public int getDni(){
        
        return dni;

    }

    public String getNombre(){

        return nombre;

    }

    public String getTelefono(){

        return telefono;

    }

    @Override
    public String toString() {
    
        return "Nombre: " + nombre + " DNI: " + dni + " Teléfono: " + telefono;
    }
}
