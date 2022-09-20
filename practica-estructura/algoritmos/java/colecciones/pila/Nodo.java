package colecciones.pila;

public class Nodo <T> {
    private T elemento;
    private Nodo<T> siguiente;


    public Nodo(Nodo sig, T elem){
        elemento = elem;
        siguiente = sig;
    }

    public T getElemento(){
        return elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setElemento(T elem){
        elemento = elem;
    }

    public void setSiguiente(Nodo sig){
        siguiente = sig;
    }
}
