package colecciones.cola;

public class ColaListaEnlazada <T> implements Cola<T> {
    private Nodo<T> primero;
    private int elementos;

    public ColaListaEnlazada(){
        primero = null;
        elementos = 0;
    }

    @Override
    public boolean esVacia() {
        return elementos == 0;
    }

    @Override
    public boolean encolar(T elem) {
        Nodo aux = new Nodo(primero, elem);
        primero = aux;
        elementos++;
        return true;
    }

    @Override
    public T desencolar() {
        Nodo aux = primero;
        for (int i = 1; i < (elementos - 1); i++){
            aux = aux.getSiguiente();
        }
        Nodo aux2 = aux.getSiguiente();
        T salida = (T) aux2.getElemento();
        aux.setSiguiente(aux2.getSiguiente());
        elementos--;
        return salida;
    }

    @Override
    public T primero() {
        Nodo aux = primero;
        while (aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        T salida = (T) aux.getElemento();
        return salida;
    }

    @Override
    public void vaciar() {
        primero = null;
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
        Nodo<T> aux = primero;
        String resultado = "";
        while (aux.getSiguiente() != null){
            resultado = resultado + "[" + aux.getElemento() + "]";
            aux = aux.getSiguiente();
        }
        return resultado + "[" + aux.getElemento() + "]";
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
        if(!(other instanceof ColaListaEnlazada)){
            return false;
        }
        ColaListaEnlazada otraCola = (ColaListaEnlazada) other;
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
