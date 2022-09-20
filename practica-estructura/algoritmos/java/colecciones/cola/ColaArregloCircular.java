package colecciones.cola;

public class ColaArregloCircular<T> implements Cola<T> {
    private static final int MAX = 7;
    private Object[] array;
    private int init;
    private int end;
    private int elements;

    public ColaArregloCircular(int capacity){
        array = (T[]) new Object[capacity];
        elements = 0;
        init = 0;
        end = 0;
    }

    public ColaArregloCircular(){
        array = (T[]) new Object[MAX];
        elements = 0;
        init = 0;
        end = 0;
    }

    @Override
    public boolean esVacia() {
        return elements == 0;
    }

    @Override
    public boolean encolar(T elem) {
        if(elements == MAX){
            throw new ArrayIndexOutOfBoundsException("Cola llena");
        }
        else{
            array[end] = elem;
            elements++;
            end = (end + 1) % MAX;
            return true;
        }
    }

    @Override
    public T desencolar() {
        if(elements == 0){
            throw new ArrayIndexOutOfBoundsException("La cola es vacia");
        }
        else{
            T result = (T) array[init];
            init = (init + 1) % MAX;
            elements--;
            return result;
        }
    }

    @Override
    public T primero() {
        return (T) array[init];
    }

    @Override
    public void vaciar() {
        elements = 0;
        init = 0;
        end = 0;
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
    public String toString() {
            String result = "";
            for(int i = 0; i<MAX; i++){
                result = result + "[" + array[i] + "]";
            }
            return result;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null){
            return false;
        }
        if(other == this){
            return true;
        }
        if (! (other instanceof ColaArregloCircular)){
            return false;
        }
        ColaArregloCircular otraCola = (ColaArregloCircular) other;
        if (otraCola.elementos() != elements){
            return false;
        }
        for(int i = 0; i < elements; i++){
            if(otraCola.elemento(i) != array[i]){
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private T elemento(int index) {
        return (T) array[index];
    }

}

