package colecciones.cola;

public class Nodo <T> {
    private T elemento;
    private Nodo<T> siguiente;


    public Nodo(Nodo sig, T elem){
        elemento = elem;
        siguiente = sig;
    }
    public Nodo(){
        siguiente = null;
        elemento = null;
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
