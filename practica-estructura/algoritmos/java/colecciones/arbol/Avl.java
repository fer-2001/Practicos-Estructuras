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

   
    /* ROTACION A DERECHA SIMPLE
    * Rota el subarbol pasado como parametro a la derecha 
    * @param root el subarbol
    * @return el subarbol rotado
    */
    private NodoBinario<T> rotRight (NodoBinario<T> root){    
      NodoBinario<T> result = root.getIzquierdo();  //result = hi del nodo
      root.setIzquierdo(result.getDerecho());      //Pone todos los mayores a la nueva raiz de hi de la vieja raiz
      result.setDerecho(root);                    //Baja la vieja raiz a hd de la nueva
      /* Actualiza alturas */
      root.setAltura(1+ Math.max(altura(root.getIzquierdo()), altura(root.getDerecho())));
      result.setAltura(1+ Math.max(altura(result.getIzquierdo()), altura(result.getDerecho())));
      return result; 
    }

    /* ROTACION A IZQUIERDA SIMPLE
    * Rota el subarbol pasado como parametro a la izquierda 
    * @param root el subarbol
    * @return el subarbol rotado
    */
    private  NodoBinario<T> rotLeft(NodoBinario<T> root){
      NodoBinario<T> result = root.getDerecho();    //result = hd del nodo
      root.setDerecho(result.getIzquierdo());      //Pone todos los menores a la nueva raiz de hd de la vieja raiz
      result.setIzquierdo(root);                  //Baja la vieja raiz a hi de la nueva
      /* Actualiza alturas */
      root.setAltura(1+ Math.max(altura(root.getIzquierdo()), altura(root.getDerecho())));
      result.setAltura(1+ Math.max(altura(result.getIzquierdo()), altura(result.getDerecho())));
      return result; 
    }

    /*
    * ROTACION RL
    * Rota a izquierda el subarbol derecho, lo setea nuevamente en su lugar y luego hace una rotacion a derecha sobre el
    * @param root el subarbol
    * @return el subarbol rotado
    */
    private  NodoBinario<T> rotRL (NodoBinario<T> root){
      NodoBinario<T> hd = root.getDerecho();
      root.setDerecho(rotRight (hd) );   //Se aplica rotacion derecha simple al hijo derecho del nodo (luego se "une" a el)
      return rotLeft( root );           //Se aplica rotacion izq simple al nodo desbalanceado (ahora como caso DER-DER)
    }

    /*
    * ROTACION LR
    * Rota a derecha el subarbol izquierdo, lo setea nuevamente en su lugar y luego hace una rotacion a izquierda sobre el
    * @param root el subarbol
    * @return el subarbol rotado
    */
    private  NodoBinario<T> rotLR (NodoBinario<T> root){
      NodoBinario<T> hi = root.getIzquierdo();
      root.setIzquierdo(rotLeft (hi) );    // Se aplica rotacion izq simple al hi del nodo (luego se "une" a el)
      return rotRight( root );            //Se aplica rotacion derecha simple al nodo desbalanceado (ahora como caso IZQ-IZQ)
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertar( T elem ) {
      if (comparador != null){
        NodoBinario<T> root = raiz;
        raiz = insertar(elem, root);
      }
      else throw new UnsupportedOperationException("Comparador null");    
    }

    /* Metodo de insertar inductivo privado sobrecargado con parametro nodo */
    private NodoBinario<T> insertar (T elem, NodoBinario<T> root){

      /* Insercion */
      if (root.getValor()==null) // Caso Base
        root = new NodoBinario<T>(elem);  
      
      else if (comparador.compare(elem, root.getValor())<0)       //Si el elem. es menor al valor del nodo se va al subarbol izquierdo
        root.setIzquierdo(insertar(elem, root.getIzquierdo()));  //Llama recursivamente hasta que entre por el caso base (hoja)

      else if (comparador.compare(elem, root.getValor())>0)    //Si el elem. es mayor al valor del nodo se va al subarbol derecho
        root.setDerecho(insertar(elem, root.getDerecho()));   //Llama recursivamente hasta que entre por el caso base (hoja)

      else throw new IllegalStateException("El elemento ya pertenece al arbol");  //Elemento existente (elem == root.getvalor)

      root.setAltura(1 + Math.max(altura(root.getIzquierdo()), altura(root.getIzquierdo()))); //Actualizo altura del nodo

        /* CHEQUEO DE BALANCE */
        if (balance(root)==(-2)){                      /* HD mas profundo */
          if (balance(root.getDerecho()) <= 0)        /* Caso DER-DER */
            root = rotLeft(root);                    /* Rot a IZQ simple */
                      
          else                                      /* CASO DER-IZQ */
            root = rotRL(root);                    /* Rot IZQ doble */
        }

        else if (balance(root)==2){                      /* HI mas profundo */
          if (balance(root.getIzquierdo())>=0)          /* Caso IZQ-IZQ */
            root = rotRight(root);                     /* Rot a DER simple */                    
          else                                        /* CASO IZQ-DER */
            root = rotLR(root);                      /* : Rot DER doble */
        }
        
      return root;
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
