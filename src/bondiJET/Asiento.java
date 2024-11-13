package bondiJET;

public class Asiento {

    private int numeroDeAsiento;
    private boolean estaComprado;
    private boolean estaOcupado;

    public Asiento(int numeroAsiento, boolean comprado){

        if(numeroAsiento > 0) this.numeroDeAsiento = numeroAsiento;
        this.estaComprado = comprado;
        this.estaOcupado = false;
    }



    public int getNumeroDeAsiento(){
        
        return numeroDeAsiento;
    }

    public boolean getEstaComprado(){

        return estaComprado;
    }

    @Override
    public String toString() {
        
        return "" + numeroDeAsiento + " :" + estaComprado;

    }

    public void comprar(){

        estaComprado = true;
    }

    public void liberar(){

        estaComprado = false;
    }

    public void ocupar(Boolean aOcupar){

        estaOcupado = aOcupar;

    }

    public boolean getEstaOcupado(){

        return estaOcupado;
    }

}
