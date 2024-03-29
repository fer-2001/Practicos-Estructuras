package colecciones.arbol;

import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
/**
 * Arbol binario de busqueda (ABB), es una implementación de {@code Diccionario} mediante nodos encadenados que preserva las propiedades de Diccionario.
 * @param <T> Tipo del valor asociado a los nodos del árbol, debe ser posible definir un orden total para los mismos.
 * @see NodoBinario
 */
public class ABB<T> implements Diccionario<T> {

    private NodoBinario<T> raiz;

    /**
     * Comparador usado para mantener el orden en un ABB, o null.
     */
    private final Comparator<? super T> comparador;

    /**
     * Construye un nuevo árbol vacío ordenado acorde al comparador dado.
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     */
    public ABB(Comparator<? super T> comparador) {
        this.comparador = comparador;
        raiz = new NodoBinario<T>();
    }

    /**
     * Construye un nuevo árbol con un elemento en la raiz, ordenado acorde al comparador dado.
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     * @param valor de la raiz del nuevo arbol si no es null.
     */
    public ABB(Comparator<? super T> comparador, T valor) {
       this.comparador = comparador;
       raiz = new NodoBinario<T>(valor);
    }

    private ABB(Comparator<? super T> comparador, NodoBinario<T> raiz2) {
        this.comparador = comparador;
        raiz = raiz2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertar(T elem) {
        // "Compare" se puede ver como la resta del primero con el segundo (ob1 - obj2)
        // -1 < 
        // 0 ==
       // 1 >
        boolean control = true;
        NodoBinario<T> aux = new NodoBinario<T>();

        if(comparador == null){
            throw new UnsupportedOperationException("comparador es null");
        }

        if(raiz == null){
            raiz = new NodoBinario<T>(elem);
            control = false;
        }


        if(raiz.getValor() == null){
            raiz.setValor(elem);
            control = false;
        }


        aux = raiz;
        while(control){
            if(aux.getIzquierdo() == null && (comparador.compare(aux.getValor(), elem) > 0)){
                NodoBinario<T> nodo1 = new NodoBinario<T>(elem);
                aux.setIzquierdo(nodo1);
                control = false;
            }
            if(aux.getDerecho() == null && (comparador.compare(aux.getValor(), elem) < 0)){
                NodoBinario<T> nodo1 = new NodoBinario<T>(elem);
                aux.setDerecho(nodo1);
                control = false;
            }
            if(aux.getIzquierdo() != null && (comparador.compare(aux.getValor(), elem) > 0)){
                aux = aux.getIzquierdo();
            }
            if(aux.getDerecho() != null  && (comparador.compare(aux.getValor(), elem) < 0)){
                aux = aux.getDerecho();
            }
        }

        reCalcularAltura(raiz);

    }

    private void reCalcularAltura(NodoBinario<T> raiz){

        NodoBinario<T> hi = new NodoBinario<T>();
        NodoBinario<T> hd = new NodoBinario<T>();

        raiz.setAltura(altura(raiz));

        if(raiz.getIzquierdo() != null){
            hi = raiz.getIzquierdo();
            reCalcularAltura(hi);            
        }
        if(raiz.getDerecho() != null){
            hd = raiz.getDerecho();
            reCalcularAltura(hd);            
        }
        
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public boolean pertenece(T elem) {
        return pertenece(elem, raiz);
    }

    private boolean pertenece(T elem, NodoBinario<T> raiz1) {
        

        if(raiz1 == null){
            return false;
        }
        else{
            if(comparador.compare(raiz1.getValor(), elem) < 0 && raiz1.getDerecho() != null){
                raiz1=raiz1.getDerecho();
                pertenece(elem,raiz1);
            }
           if(comparador.compare(raiz1.getValor(), elem) > 0 && raiz1.getIzquierdo() != null){
                raiz1=raiz1.getIzquierdo();
                pertenece(elem,raiz1);
            }
        }

        if(comparador.compare(raiz1.getValor(), elem) == 0){
                return true;
        }
        else{
            return false;
        }

    }
    /**
     * {@inheritDoc}
     */

@Override
public void borrar(T elem) {
         if (comparador != null){
             NodoBinario<T> root = raiz;
             raiz = borrar2(root, elem);
         } else
             throw new UnsupportedOperationException("comparador is nul");
    }
    private NodoBinario<T> borrar2(NodoBinario<T> nodo,T elem){
        if(nodo == null ){
            return nodo;
        }
        else{
            int i = comparador.compare(nodo.getValor(),elem);
            if(i < 0)
                nodo.setDerecho(borrar2(nodo.getDerecho(), elem));
            else if(i>0)
                nodo.setIzquierdo(borrar2(nodo.getIzquierdo(), elem));
            else{
                if(nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                    return null;
                } else if(nodo.getIzquierdo() == null) {
                    // nodo tiene hijo derecho
                    return nodo.getDerecho();
                } else if(nodo.getDerecho() == null) {
                    // nodo tiene hijo izquierdo
                    return nodo.getIzquierdo();
                } else {
                    // Nodo con 2 hijos
                    // buscamos el menor del subArbol derecho
                    T min = this.subArbolDerecho().menorValor();
                    nodo.setValor(min);
                    //Eliminamos el derecho
                    nodo.setDerecho(borrar2(nodo.getDerecho(), nodo.getDerecho().getValor()));
                }
            }
            return nodo;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void vaciar() {
        raiz = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T raiz() {
        return raiz.getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolIzquierdo() {
        NodoBinario<T> raiz2 = new NodoBinario<T>();
        raiz2 = raiz.getIzquierdo();
        ABB<T> arbolIzquierdo = new ABB<T>(comparador, raiz2);
        return arbolIzquierdo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolDerecho() {
        NodoBinario<T> raiz2 = new NodoBinario<T>();
        raiz2 = raiz.getDerecho();
        ABB<T> arbolDerecho = new ABB<T>(comparador, raiz2);
        return arbolDerecho;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int elementos() {
        return elementos(raiz); 
    }
    // Metodo privado para calcular la cantidad de elementos de un arbol (Recursiva en aumento)
    private int elementos(NodoBinario<T> raiz){
        int elementos = 0;

        NodoBinario<T> aux = new NodoBinario<T>();
        NodoBinario<T> aux2 = new NodoBinario<T>();

        if(raiz == null){
            return 0;
        }

        aux = raiz.getIzquierdo();
        aux2 = raiz.getDerecho();

        elementos = 1 + elementos + elementos(aux) + elementos(aux2);

        return elementos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int altura() {
        return altura(raiz);
    }

    // Metodo privado para calcular la altura de un arbol (Recursiva en aumento)
    private int altura(NodoBinario<T> raiz){
        int altura = 0;
        int altura2 = 0;
        NodoBinario<T> aux = new NodoBinario<T>();
        NodoBinario<T> aux2 = new NodoBinario<T>();

        if(raiz == null){
            return 0;
        }

        aux = raiz.getIzquierdo();
        aux2 = raiz.getDerecho();

        altura = 1 + altura + altura(aux);
        altura2 = 1 + altura2 + altura(aux2);

        return Math.max(altura,altura2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    /**
     * {@inheritDoc}
     */
    public T mayorValor(){
        // Por la logica de los ABB's, el elemento de más a la derecha es el mayor elemento del arbol
        boolean control = true;
        if(comparador == null){
            throw new UnsupportedOperationException("comparador es null");
        }

        NodoBinario<T> aux = new NodoBinario<T>();
        NodoBinario<T> aux2 = new NodoBinario<T>();

        aux = raiz;
        while(control){
            aux2 = aux;
            if(aux.getDerecho() == null || aux.getValor() == null){
                control = false;
                return aux2.getValor();
            }
            if( (comparador.compare( aux.getValor(), (aux.getDerecho()).getValor()) ) < 0){
                aux = aux.getDerecho();
            }

        }
        return aux.getValor();
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public T menorValor() {
        // Por la logica de los ABB's, el elemento de más a la izquierda es el menor elemento del arbol
        boolean control = true;
        if(comparador == null){
            throw new UnsupportedOperationException("comparador es null");
        }
        
        NodoBinario<T> aux = new NodoBinario<T>();
        aux = raiz;
        while(control){
            if( (comparador.compare( aux.getValor(), (aux.getIzquierdo()).getValor()) ) > 0){
                aux = aux.getIzquierdo();
            }
            if(aux.getIzquierdo() == null){
                control = false;
            }
        }
        return aux.getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T sucesor(T elem) {

        boolean control = true;
        NodoBinario<T> aux =  new NodoBinario<T>();
        NodoBinario<T> aux2 =  new NodoBinario<T>();

        if(comparador == null){
            throw new UnsupportedOperationException("Comparador es null");
        }

        T valorRaiz = raiz.getValor();
        aux = raiz;

        // Ciclo para encontrar al elemento que se paso como parametro
        while(control){
            // Aux2 conserva el nodo anterior al cambio de referencias
            aux2 = aux;
            
            if((comparador.compare(aux.getValor(), elem)) > 0){
                aux = aux.getIzquierdo();
            }

            if((comparador.compare(aux.getValor(), elem)) < 0){
                aux = aux.getDerecho();
            }


            if((comparador.compare(aux.getValor(), elem)) == 0){
                control = false;
            }            
        }
        // Se verifica si el nodo al que le calculamos el sucesor tiene hd
        if(aux.getDerecho() != null){
                aux = aux.getDerecho();
        }
        else{
            // Caso donde el nodo al que le calculamos sucesor no tenga hd (el maximo está entre su nodo raiz y el nodo raiz de todo el arbol)
            T mayor1 = raiz.getValor();
            T mayor2 = aux2.getValor();
            if( ((comparador.compare(mayor2, aux.getValor())) > 0) && (comparador.compare(mayor1, mayor2)) > 0){
                return mayor2;
            }
            else{
                return mayor1;
            }
        }

        // Ciclo en el caso de que el nodo tenga hd, se busca el elemento de más a la izquierda de dicho nodo
        while(aux.getIzquierdo() != null){
            aux = aux.getIzquierdo();
        }

        return aux.getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T predecesor(T elem) {

        boolean control = true;
        NodoBinario<T> aux =  new NodoBinario<T>();
        T aux2;
        if(comparador == null){
            throw new UnsupportedOperationException("Comparador es null");
        }

        T valorRaiz = raiz.getValor();
        aux = raiz;

        aux2 = menorValor(); // Poco eficiente
        
        // Ciclo para encontrar al elemento que se paso como parametro
        while(control){
            // Aux2 conserva el menor valor de forma parcial

            if((comparador.compare(aux.getValor(), elem)) > 0){
                aux = aux.getIzquierdo();
            }

            if(((comparador.compare(elem, aux.getValor())) > 0) && ((comparador.compare(aux2, aux.getValor())) < 0)){
                aux2 = aux.getValor();
            }

            if((comparador.compare(aux.getValor(), elem)) < 0){
                aux = aux.getDerecho();
            }

            if((comparador.compare(aux.getValor(), elem)) == 0){
                control = false;
            }            
        }
        // Se verifica si el nodo al que le calculamos el predecesor tiene hi
        if(aux.getIzquierdo() != null){
                aux = aux.getIzquierdo();
        }
        else{
            // Caso donde el nodo al que le calculamos predecesor no tenga hi (el maximo está en aux2)
            return aux2;
        }

        // Ciclo en el caso de que el nodo tenga hi, se busca el elemento de más a la derecha de dicho nodo
        while(aux.getDerecho() != null){
            aux = aux.getDerecho();
        }

        return aux.getValor();

    }

    /**
     * {@inheritDoc}
     */

    // Debe verificar dos cosas: Que el arbol realmente cumpla con el orden de un ABB, y que no tenga ciclos
    @Override
    public boolean repOK() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if(elementos() == 0){
            return "[]";
        }
        else{
            return "" + aLista();
        }
    }

    /**
     * {@inheritDoc}
     */
    // Debe cumplir: Misma altura, misma cantidad de elementos, pertenecer a la misma instancia, y tener los mismos elementos (ver como una lista)
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object other) {
        if(other == null){
            return false;
        }
        if(other == this){
            return true;
        }
        if(!(other instanceof Diccionario)){
            return false;
        }
        ABB<T> arbol2 = (ABB<T>) other;
        if(arbol2.elementos() != this.elementos()){
            return false;
        }
        if(arbol2.altura() != this.altura()){
            return false;
        }
        List<T> lista1 = this.aLista();
        List<T> lista2 = arbol2.aLista();
        if(!(lista1.equals(lista2))){
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> aLista() {
        return aLista(Orden.INORDER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> aLista(Orden orden) {
        List<T> elementos = new LinkedList<>();
        switch (orden) {
            case INORDER:
                elementos.add(raiz.getValor());
                return aListaInOrder(raiz, elementos);
            case PREORDER:
                return aListaPreOrder(raiz, elementos);
            case POSTORDER:
                return aListaPostOrder(raiz, elementos);
        }
        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido in order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaInOrder(NodoBinario<T> raiz, List<T> elementos) {

        NodoBinario<T> aux = new NodoBinario<T>();
        aux = raiz;
        if(aux == null){
            return elementos;
        }
        if(aux.getIzquierdo() != null){
            elementos.add((aux.getIzquierdo()).getValor());
        }
        aListaInOrder(aux.getIzquierdo(), elementos);
        if(aux.getDerecho() != null){
            elementos.add((aux.getDerecho()).getValor());
        }
        aListaInOrder(aux.getDerecho(), elementos);
        return elementos;

    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido pre order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPreOrder(NodoBinario<T> raiz, List<T> elementos) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido post order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPostOrder(NodoBinario<T> raiz, List<T> elementos) {
        throw new UnsupportedOperationException("TODO: implementar");
    }


}
