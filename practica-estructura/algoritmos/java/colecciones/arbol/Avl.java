package colecciones.arbol;

import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;




/**
 * Una implementación de {@code Diccionario} mediante nodos encadenados que preserva,
 * las propiedades de ABB y ademas mantiene el arbol balanceado, es decir,
 * las alturas de los subárboles izquierdo y derecho de cada nodo difieren como máximo en uno.
 * @param <T>  Tipo del valor asociado a los nodos del árbol, debe ser posible definir un orden total para los mismos.
 * @see NodoBinario
 */
public class Avl<T> implements Diccionario<T> {

    private NodoBinario<T> raiz;

    /**
     * Comparador usado para mantener el orden en un ABB, o null.
     */
    private final Comparator<? super T> comparador;


    /**
     * Construye un nuevo árbol vacío ordenado acorde al comparador dado.
     *
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     */
    public Avl(Comparator<? super T> comparador) {
        //throw new UnsupportedOperationException("TODO: implementar");
        this.comparador = comparador;
        raiz = new NodoBinario<T>();
    }

    /**
     * Construye un nuevo árbol con un elemento en la raiz, ordenado acorde al comparador dado.
     *
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     * @param valor de la raiz del nuevo arbol si no es null.
     */
    public Avl(Comparator<? super T> comparador, T valor) {
        this.comparador = comparador;
        raiz = new NodoBinario<T>(valor);
    }

    private Avl(Comparator<? super T> comparador, NodoBinario<T> raiz2) {
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
        //boolean control = true;
        //NodoBinario<T> aux = new NodoBinario<T>();
        //NodoBinario<T> aux2 = new NodoBinario<T>();

        insertar(elem,raiz);
        reCalcularAltura(raiz);
        /*
        if(comparador == null){
            throw new UnsupportedOperationException("comparador es null");
        }

        if(raiz.getValor() == null){
            raiz.setValor(elem);
            control = false;
        }

        aux = raiz;

            aux2 = aux;
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
            */ 
        


        /*
        reCalcularAltura(raiz);

        int balance = balance(aux2);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (aux2.getIzquierdo() != null && balance > 1 && comparador.compare(elem,(aux2.getIzquierdo()).getValor()) < 0){
            rightRotate(aux2);
        }
 
        // Right Right Case
        if (aux2.getDerecho() != null && balance < -1 && comparador.compare(elem, (aux2.getDerecho()).getValor()) > 0)
            leftRotate(aux2);
 
        // Left Right Case
        if (aux2.getIzquierdo() != null && balance > 1 && comparador.compare(elem,(aux2.getIzquierdo()).getValor()) > 0) {
            aux2.setIzquierdo(leftRotate(aux2.getIzquierdo()));
            if(aux2.getIzquierdo() != null){
               rightRotate(aux2); 
            }
            
        }
 
        // Right Left Case
        if (aux2.getDerecho() != null && balance < -1 && comparador.compare(elem,(aux2.getDerecho()).getValor()) < 0) {
            aux2.setIzquierdo(rightRotate(aux2.getDerecho()));
            leftRotate(aux2);
        }

        reCalcularAltura(raiz);
        */
    }

    private void insertar(T elem, NodoBinario<T> raiz1){
        int altHI;
        int altHD;
        if(comparador == null){
            throw new UnsupportedOperationException("comparador es null");
        }

        if(raiz1.getValor() == null){
            raiz1.setValor(elem);
        }

        if(raiz1.getIzquierdo() == null && (comparador.compare(raiz1.getValor(), elem) > 0)){
            NodoBinario<T> nodo1 = new NodoBinario<T>(elem);
            raiz1.setIzquierdo(nodo1);
        }
        if(raiz1.getDerecho() == null && (comparador.compare(raiz1.getValor(), elem) < 0)){
            NodoBinario<T> nodo1 = new NodoBinario<T>(elem);
            raiz1.setDerecho(nodo1);
        }
        if(raiz1.getIzquierdo() != null && (comparador.compare(raiz1.getValor(), elem) > 0)){
            raiz1 = raiz1.getIzquierdo();
            insertar(elem,raiz1);
        }
        if(raiz1.getDerecho() != null  && (comparador.compare(raiz1.getValor(), elem) < 0)){
            raiz1 = raiz1.getDerecho();
            insertar(elem,raiz1);
        }
        if((raiz1.getIzquierdo()) != null){
            altHI = (raiz1.getIzquierdo()).getAltura();
        }else{
            altHI = 0;
        }
        if((raiz1.getDerecho()) != null){
            altHD = (raiz1.getDerecho()).getAltura();
        }else{
            altHD=0;
        }
        raiz1.setAltura(1+(Math.max(altHI,altHD)));
        //System.out.println("Altura del nodo: " + raiz1.getValor() + " es: " + raiz1.getAltura());
        int balance = balance(raiz1);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && comparador.compare(elem,(raiz1.getIzquierdo()).getValor()) < 0){
            rightRotate(raiz1);
        }

        // Right Right Case
        if (balance < -1 && comparador.compare(elem, (raiz1.getDerecho()).getValor()) > 0)
            leftRotate(raiz1);

        // Left Right Case
        if (raiz1.getIzquierdo() != null && balance > 1 && comparador.compare(elem,(raiz1.getIzquierdo()).getValor()) > 0) {
            raiz1.setIzquierdo(leftRotate(raiz1.getIzquierdo()));
            rightRotate(raiz1); 
            
            
        }

        // Right Left Case
        if (balance < -1 && comparador.compare(elem,(raiz1.getDerecho()).getValor()) < 0) {
            raiz1.setIzquierdo(rightRotate(raiz1.getDerecho()));
            leftRotate(raiz1);
        }            
    }


    private void reCalcularAltura(NodoBinario<T> raiz){

        NodoBinario<T> hi = new NodoBinario<T>();
        NodoBinario<T> hd = new NodoBinario<T>();

        raiz.setAltura(1+altura(raiz));

        if(raiz.getIzquierdo() != null){
            hi = raiz.getIzquierdo();
            reCalcularAltura(hi);            
        }
        if(raiz.getDerecho() != null){
            hd = raiz.getDerecho();
            reCalcularAltura(hd);            
        }
        
    }

    // Fuente: https://www.geeksforgeeks.org/insertion-in-an-avl-tree/
    private NodoBinario<T> leftRotate(NodoBinario<T> x) {
        int altHI1;
        int altHD1;
        int altHI2;
        int altHD2;

        NodoBinario<T> y = x.getDerecho();
        NodoBinario<T> z = y.getIzquierdo();
 
        // Perform rotation
        y.setIzquierdo(x);
        x.setDerecho(z);
 
        //  Update heights
        //x.height = max(height(x.left), height(x.right)) + 1;
        //y.height = max(height(y.left), height(y.right)) + 1;
        
        if((y.getIzquierdo()) != null){
            altHI1 = (y.getIzquierdo()).getAltura();
        }else{
            altHI1 = 0;
        }
        if((y.getDerecho()) != null){
            altHD1 = (y.getDerecho()).getAltura();
        }else{
            altHD1=0;
        }

        if((x.getIzquierdo()) != null){
            altHI2 = (x.getIzquierdo()).getAltura();
        }else{
            altHI2 = 0;
        }
        if((x.getDerecho()) != null){
            altHD2 = (x.getDerecho()).getAltura();
        }else{
            altHD2=0;
        }


        y.setAltura((Math.max(altHI1, altHD1)) +1);
        x.setAltura((Math.max(altHI2, altHD2)) +1);
        // Return new root
        return y;
    }

    private NodoBinario<T> rightRotate(NodoBinario<T> y) {
        int altHI1;
        int altHD1;
        int altHI2;
        int altHD2;
        // y se supone que es el nodo anterior al insertado
        NodoBinario<T> x = y.getIzquierdo();
        NodoBinario<T> z = x.getDerecho();
 
        // Perform rotation
        x.setDerecho(y);
        y.setIzquierdo(z);
 
        // Update heights
        //y.height = max((y.left), height(y.right)) + 1;
        //x.height = max(height(x.left), height(x.right)) + 1;

        if((y.getIzquierdo()) != null){
            altHI1 = (y.getIzquierdo()).getAltura();
        }else{
            altHI1 = 0;
        }
        if((y.getDerecho()) != null){
            altHD1 = (y.getDerecho()).getAltura();
        }else{
            altHD1=0;
        }

        if((x.getIzquierdo()) != null){
            altHI2 = (x.getIzquierdo()).getAltura();
        }else{
            altHI2 = 0;
        }
        if((x.getDerecho()) != null){
            altHD2 = (x.getDerecho()).getAltura();
        }else{
            altHD2=0;
        }


        y.setAltura((Math.max(altHI1, altHD1)) +1);
        x.setAltura((Math.max(altHI2, altHD2)) +1);

        // Return new root
        return x;
    }

    /**
     * {@inheritDoc}
     */
    public boolean pertenece(T elem) {

        boolean control = true;
        if(comparador == null){
            throw new UnsupportedOperationException("comparador es null");
        }

        if(raiz == null){
            return false;
        }

        NodoBinario<T> aux = new NodoBinario<T>();
        aux = raiz;
       
        while(control){
            if(aux.getDerecho() == null && aux.getIzquierdo() == null){
                return false;
            }
            if((comparador.compare(aux.getValor(), elem) > 0) && aux.getIzquierdo() != null){
                aux = aux.getIzquierdo();
            }  
            if((comparador.compare(aux.getValor(), elem) < 0) && aux.getDerecho() != null){
                aux = aux.getDerecho();
            }    
            if((comparador.compare(aux.getValor(), elem) == 0)){
                control = false;
            }
        }
        return true;

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void borrar(T elem) {
        
        boolean control = true;
        NodoBinario<T> aux =  new NodoBinario<T>();
        NodoBinario<T> aux2 =  new NodoBinario<T>();

        if(comparador == null){
            throw new UnsupportedOperationException("Comparador es null");
        }

        aux = raiz;
        // Busqueda del elemento a buscar
        while(control){
            // Aux2 conserva el nodo anterior a aux
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

        // Caso de borrado de una hoja
        if (aux.getDerecho() == null && aux.getIzquierdo() == null){    
            if((aux2.getDerecho()) != null  && comparador.compare(((aux2.getDerecho()).getValor()), aux.getValor()) == 0){
                aux2.setDerecho(null);
            }
            else{
                aux2.setIzquierdo(null);
            }  
        }else{
            // Caso nodo con solamente hijo a la izquierda
            if(aux.getDerecho() == null && aux.getIzquierdo() != null){
                aux.setValor((aux.getIzquierdo()).getValor());
                aux.setIzquierdo(null);
            }
            // Caso nodo con solamente hijo a la derecha
            if(aux.getDerecho() != null && aux.getIzquierdo() == null){
                aux.setValor((aux.getDerecho()).getValor());
                aux.setDerecho(null);
            }
            // Caso del nodo que tiene sus dos hijos con nodos            
            if(aux.getDerecho() != null && aux.getIzquierdo() != null){
              Avl<T> arbolIzquierdo = new Avl<T>(comparador, aux.getIzquierdo());
              T mayor = arbolIzquierdo.mayorValor();
              aux.setValor(mayor);
              arbolIzquierdo.borrar(mayor);
            }  
        }
        reCalcularAltura(raiz);    
    }

    /**{@inheritDoc}*/
    @Override
    public void vaciar() {
        raiz = null;
    }

    /**{@inheritDoc}*/
    @Override
    public T raiz() {
        return raiz.getValor();
    }

    /**{@inheritDoc}*/
    @Override
    public Avl<T> subArbolIzquierdo() {
        NodoBinario<T> raiz2 = new NodoBinario<T>();
        raiz2 = raiz.getIzquierdo();
        Avl<T> arbolIzquierdo = new Avl<T>(comparador, raiz2);
        return arbolIzquierdo;
    }

    /**{@inheritDoc}*/
    @Override
    public Avl<T> subArbolDerecho() {
        NodoBinario<T> raiz2 = new NodoBinario<T>();
        raiz2 = raiz.getDerecho();
        Avl<T> arbolDerecho = new Avl<T>(comparador, raiz2);
        return arbolDerecho;    
    }

    /**{@inheritDoc}*/
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

    /**{@inheritDoc}*/
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

    /**{@inheritDoc}*/
    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    /**{@inheritDoc}*/
    @Override
    public T mayorValor(){
        // Por la logica de los ABB's, el elemento de más a la derecha es el mayor elemento del arbol
        boolean control = true;
        if(comparador == null){
            throw new UnsupportedOperationException("comparador es null");
        }

        NodoBinario<T> aux = new NodoBinario<T>();
        aux = raiz;
        while(control){
            if( (comparador.compare( aux.getValor(), (aux.getDerecho()).getValor()) ) < 0){
                aux = aux.getDerecho();
            }
            if(aux.getDerecho() == null){
                control = false;
            }
        }
        return aux.getValor();
    }

    /**{@inheritDoc}*/
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

    /**{@inheritDoc}*/
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

    /**{@inheritDoc}*/
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
     * obtiene el balance del arbol, es decir, la diferencia de altura de sus subarboles.
     * @return diferencia de altura de los subarboles.
     */
    public int balance(){
        System.out.println("Altura HI: " + (raiz.getIzquierdo()).getAltura());
        System.out.println("Altura HI: " + (raiz.getDerecho()).getAltura());

        return (raiz.getIzquierdo()).getAltura() - (raiz.getDerecho()).getAltura();
    }

    private int balance(NodoBinario<T> raiz){
        int altHi;
        int altHd;
        if(raiz.getIzquierdo() != null){
            altHi = (raiz.getIzquierdo()).getAltura();
        }
        else{
            altHi=0;
        }
        if(raiz.getDerecho() != null){
            altHd = (raiz.getDerecho()).getAltura();
        }
        else{
            altHd=0;
        }
       
        return altHi - altHd;
    }

    /**{@inheritDoc}*/
    @Override
    public boolean repOK() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**{@inheritDoc}*/
    @Override
    public String toString() {
       return "" + aLista();
    }

    /**{@inheritDoc}*/
    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**{@inheritDoc}*/
    @Override
    public List<T> aLista() {
        return aLista(Orden.INORDER);
    }

    /**{@inheritDoc}*/
    @Override
    public List<T> aLista(Orden orden) {
        List<T> elementos = new LinkedList<>();
        switch (orden) {
            case INORDER : 
                elementos.add(raiz.getValor());
                return aListaInOrder(raiz, elementos);
            case PREORDER : return aListaPreOrder(raiz, elementos);
            case POSTORDER : return aListaPostOrder(raiz, elementos);
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
