package colecciones.pila;

public class PilaArreglo<T> implements Pila<T>{
    private Object[] arreglo;
    private int elementos;
    public PilaArreglo(int tamanio){
        if(tamanio < 0){
            throw new IllegalArgumentException("Valor imposible");
        }
        arreglo = new Object[tamanio];
        int elementos = 0;
    }

    @Override
    public boolean esVacia() {
        return elementos == 0;
    }

    @Override
    public void vaciar() {
        elementos = 0;
    }

    @Override
    public int longitud() {
        return elementos;
    }

    @Override
    public boolean apilar(T elem) {
        if(elementos > arreglo.length){
            return false;
        }
        arreglo[elementos] = elem;
        elementos++;
        return true;
    }

    @Override
    public T desapilar() {
        T aux = (T) arreglo[elementos-1];
        elementos--;
        return aux;
    }

    @Override
    public T tope() {
        return (T) arreglo[elementos-1];
    }

    @Override
    public boolean repOK(){
        return (apilaCorrectamente() && topeCorrecto() && vaciaCorrectamente());
    }

    private boolean apilaCorrectamente(){
        Pila pilaPrueba = new <Integer> PilaArreglo(5);
        Integer aux = 0;
        pilaPrueba.apilar(aux);
        Integer resultado = (Integer) pilaPrueba.desapilar();
        return aux.equals(resultado);
    }

    private boolean topeCorrecto(){
        Pila pilaPrueba = new <Integer> PilaArreglo(5);
        Integer aux = 0;
        pilaPrueba.apilar(aux);
        Integer aux2 = (Integer) pilaPrueba.tope();
        return aux.equals(aux2);
    }

    private boolean vaciaCorrectamente(){
        Pila pilaPrueba = new <Integer> PilaArreglo(5);
        Integer aux = 0;
        pilaPrueba.apilar(aux);
        pilaPrueba.vaciar();
        return pilaPrueba.esVacia();
    }

    @Override
    public String toString(){
        String resultado = "";
        for(int i=elementos-1; i>-1; i--){
            resultado = resultado + "[" + arreglo[i] + "]" + "\n";
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
        if(!(otro instanceof PilaArreglo)){
            return false;
        }
        PilaArreglo otraPila = (PilaArreglo) otro;
        if(otraPila.longitud() != elementos){
            return false;
        }
        for(int i = 0 ; i<elementos; i++){
           if(otraPila.obtener(i) != this.obtener(i)){
               return false;
           }
        }
    return true;
    }

    @SuppressWarnings("Unchecked")
    private T obtener(int indice){
        return (T) arreglo[indice];
    }
}
