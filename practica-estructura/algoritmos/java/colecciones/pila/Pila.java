package colecciones.pila;
/**
 * Esta clase representa una pila de elementos del tipo LIFO (Last in, firt out) donde el primer elemento insertado
 * es el ultimo en salir, y el ultimo elemento apilado es el primero en salir.
 *
 * Las operaciones disponibles para esta estructura son:
 * <li> esVacia     : Verifica si la pila es vacia
 * <li> vaciar      : Vacia la pila
 * <li> longitud    : Retorna la longitud de la pila
 * <li> apilar      : Apila un elemento
 * <li> desapilar   : Desapila un elemento
 * <li> tope        : Retorna el tope de la pila
 * <li> toString    : Retorna una representacion en forma de cadena
 * <li> equals      : Permite evaluar si otra instancia de pila es igual a esta
 *
 * @param <T> Tipo generico para implementar la pila
 */
public interface Pila <T> {

    /**
     * Metodo para saber si la pila es vacia o no
     * @return True si la píla es vacia, false caso contrario
     */
    public boolean esVacia();

    /**
     * Metodo para vaciar la pila
     */
    public void vaciar();

    /**
     * Metodo para devolver la longitud de la pila (Cantidad de elementos)
     * @return longitud de la pila
     */
    public int longitud();

    /**
     * Metodo para apilar un elemento a la pila
     * @Param elem el elemento a apilar
     */
    public boolean apilar(T elem);

    /**
     * Metodo para desapilar un elemento de la pila
     * @return el elemento a desapilar
     */
    public T desapilar();

    /**
     * Metodo para acceder al tope de la pila
     * @return el tope de la pila
     */
    public T tope ();

    @Override
    public String toString();

    @Override
    public boolean equals(Object otro);

    public boolean repOK();
}
