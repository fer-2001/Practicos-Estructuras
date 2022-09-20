package colecciones.pila;

import  java.util.Arrays;

public class PilaArregloDinamico<T> implements Pila<T>{
    private Object[] arreglo;
    private int elementos;

    public PilaArregloDinamico(int tamanio){
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
        if(elementos >= arreglo.length){
            int nuevaCapacidad = elementos*2;
            Object[] nuevoArreglo = new Object[nuevaCapacidad];
            for (int i = 0; i<elementos; i++){
                nuevoArreglo[i] = arreglo[i];
            }
            arreglo = nuevoArreglo;
            arreglo[elementos] = elem;
            elementos++;
            return true;
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
        return false;
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
        if(!(otro instanceof PilaArregloDinamico)){
            return false;
        }
        PilaArregloDinamico otraPila = (PilaArregloDinamico) otro;
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

    private T obtener(int indice){
        return (T) arreglo[indice];
    }

}
