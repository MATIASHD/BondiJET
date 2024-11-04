package AppSource;

import java.util.*;

public class Cliente {

    public Cliente(int dni, String nombre, String telefono){

        if(dni > 0) this.dni = dni;
        if(nombre.length() > 0) this.nombre = nombre;
        if(telefono.length() > 0) this.telefono = telefono;

    }

    int dni;
    String nombre;
    String telefono;

    public int getDni(){
        
        return dni;

    }

    public String ObtenerNombre(){

        return nombre;

    }

    public String ObtenerTelefono(){

        return telefono;

    }

}
