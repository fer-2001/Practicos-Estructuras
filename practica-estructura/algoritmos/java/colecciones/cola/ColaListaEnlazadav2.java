package colecciones.cola;

public class ColaListaEnlazadav2 <T> implements Cola<T> {
    private Nodo<T> primero; // Primer elemento en ingresar a la cola (o proximo elemento a salir)
    private Nodo<T> ultimo; // Ultimo elemento ingresado a la cola
    private int elementos;

    public ColaListaEnlazadav2(){
        this.primero = new Nodo();
        this.ultimo = new Nodo();
        elementos = 0;
    }

    @Override
    public boolean esVacia() {
        return elementos == 0;
    }

    @Override
    public boolean encolar(T elem) {
        if(elementos == 0){
            Nodo aux = new Nodo();
            aux.setElemento(elem);
            ultimo = aux;
            primero = aux;
            elementos++;
        }
        else{
        Nodo aux = new Nodo();
        aux.setElemento(elem);
        aux.setSiguiente(ultimo);
        ultimo = aux;
        elementos++;
        }
        return true;
    }

    @Override
    public T desencolar() {
        Nodo aux = ultimo;
        for (int i = 1; i < (elementos - 1); i++){
            aux = aux.getSiguiente();
        }
        T desencolado = (T) primero.getElemento();
        primero = aux;
        elementos--;
        return desencolado;
    }

    @Override
    public T primero() {
        T salida = (T) primero.getElemento();
        return salida;
    }

    @Override
    public void vaciar() {
        ultimo = null;
        elementos = 0;
    }

    @Override
    public int elementos() {
        return elementos;
    }

    @Override
    public boolean repOK() {
        return false;
    }

    @Override
    public String toString(){
        Nodo<T> aux = ultimo;
        String resultado = "";
        int i = 0;
        while (i < elementos){
            resultado = resultado + "[" + aux.getElemento() + "]";
            aux = aux.getSiguiente();
            i++;
        }
        return resultado;
    }
    
    private T obtener(int indice) {
        if (indice < 0 || indice > elementos){
            throw new NullPointerException("Posicion fuera de alcance");
        }
        if (indice == 0){
            return (T) primero.getElemento();
        }
        else{
            Nodo aux;
            T elemento;
            aux = primero;
            for (int i = 1; i <= indice; i++){
                aux = aux.getSiguiente();
            }
            elemento = (T) aux.getElemento();
            return elemento;
        }
    }
    
    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        if(other == this){
            return true;
        }
        if(!(other instanceof ColaListaEnlazadav2)){
            return false;
        }
        ColaListaEnlazadav2 otraCola = (ColaListaEnlazadav2) other;
        if (otraCola.elementos != elementos){
            return false;
        }
        for(int i = 0; i < elementos; i++){
            if(otraCola.obtener(i) != this.obtener(i)){
                return false;
            }
        }
        return true;
    }


}
