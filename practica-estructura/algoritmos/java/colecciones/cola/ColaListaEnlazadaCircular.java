package colecciones.cola;

public class ColaListaEnlazadaCircular<T> implements Cola<T> {
    private Nodo fin;
    private int elements;

    public ColaListaEnlazadaCircular(T elem){
        fin = new Nodo(fin,elem);
        elements++;
    }

    public ColaListaEnlazadaCircular(){
        fin = new Nodo();
        elements = 0;
    }
    @Override
    public boolean esVacia() {
        return elements == 0;
    }

    @Override
    public boolean encolar(T elem) {
        if(esVacia()){
            Nodo aux = new Nodo();
            aux.setSiguiente(aux);
            aux.setElemento(elem);
            fin = aux;
            elements++;
            return true;
        }
        else{

            Nodo aux = new Nodo();
            aux.setSiguiente(fin.getSiguiente());
            aux.setElemento(elem);
            fin.setSiguiente(aux);
            fin = aux;
            elements++;
            return true;
        }
    }

    @Override
    public T desencolar() {
        if(esVacia()){
            throw new NullPointerException("Cola vacia");
        }
        else{
            T resultado = (T) (fin.getSiguiente()).getElemento();
            fin.setSiguiente(fin.getSiguiente().getSiguiente());
            elements--;
            return resultado;
        }
    }

    @Override
    public T primero() {
            if (esVacia()) {
                throw new NullPointerException("Cola vacia");
            } else {
                T resultado = (T) (fin.getSiguiente()).getElemento();
                return resultado;
            }
    }


    @Override
    public void vaciar(){
        elements = 0;
        fin = null;
    }

    @Override
    public int elementos() {
        return elements;
    }

    @Override
    public boolean repOK() {
        return false;
    }

    @Override
    public String toString(){
        Nodo<T> aux = fin;
        String resultado = "";
        int i = 0;
        while (i < elements){
            resultado = resultado + "[" + aux.getElemento() + "]";
            aux = aux.getSiguiente();
            i++;
        }
        return resultado;
    }

}
