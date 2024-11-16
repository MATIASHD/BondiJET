package bondiJET;

public class Cliente {

    public Cliente(int dni, String nombre, String telefono){

        if(dni < 0){
            throw new IllegalArgumentException("Error: el DNI ingresado es inválido.");
        }
        if(!validarNombre(nombre)){
            throw new IllegalArgumentException("Error: El nombre ingresado es inválido.");
        }
        if(!validarTelefono(telefono)){
            throw new IllegalArgumentException("Error: El teléfono ingresado es inválido.");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    private int dni;
    private String nombre;
    private String telefono;

    private boolean validarTelefono(String telefono){

        Boolean telefonoValido = telefono.length() > 0 && telefono.matches("^[+\\d-]+$");

        return telefonoValido;
    }

    private boolean validarNombre(String nombre){

        boolean nombreValido = nombre.length() > 0 && nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\d\\s]+$");
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