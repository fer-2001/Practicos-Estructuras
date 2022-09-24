package colecciones.pila;

public class PilaListaE <T> implements Pila<T>{
    private Nodo<T> tope;
    private int elementos;


    @Override
    public boolean esVacia() {
        return elementos == 0;
    }

    @Override
    public void vaciar() {
        tope = null;
    }

    @Override
    public int longitud() {
        return elementos;
    }

    @Override
    public boolean apilar(T elem) {
        //Nodo aux = new Nodo(tope, elem);
        Nodo aux = new Nodo();
        aux.setSiguiente(tope);
        aux.setElemento(elem);
        tope = aux;
        elementos++;
        return true;
    }

    @Override
    public T desapilar() {
        if(elementos == 0){
            throw new NullPointerException("Pila vacia");
        }
        T aux = tope.getElemento();
        tope.setSiguiente(tope.getSiguiente());
        elementos--;
        return aux;
    }

    @Override
    public T tope() {
        return tope.getElemento();
    }

    @Override
    public String toString(){
        String resultado;
        Nodo aux = tope;
        resultado = "";
        for(int i=elementos-1; i>-1; i--){
            resultado = resultado + "[" + aux.getElemento() + "]" + "\n";
            aux = aux.getSiguiente();
        }
        return resultado;
    }

    @Override
    public boolean equals(Object otro){
        if(otro == null){
            return false;
        }
        if(otro == this){
            return true;
        }
        if(!(otro instanceof PilaListaE)){
            return false;
        }
        PilaListaE otraPila = (PilaListaE) otro;
        if(otraPila.longitud() != elementos){
            return false;
        }
        for(int i = 0; i<elementos; i++){
            if(otraPila.obtener(i) != this.obtener(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean repOK(){
        return false;
    }


    private T obtener(int indice) {
        if (indice < 0 || indice > elementos){
            throw new NullPointerException("Posicion fuera de alcance");
        }
        if (indice == 0){
            return (T) tope.getElemento();
        }
        else{
            Nodo aux;
            T elemento;
            aux = tope;
            for (int i = 1; i <= indice; i++){
                aux = aux.getSiguiente();
            }
            elemento = (T) aux.getElemento();
            return elemento;
        }
    }
}
