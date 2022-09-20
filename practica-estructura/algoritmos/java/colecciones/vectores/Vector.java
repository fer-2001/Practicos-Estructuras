package colecciones.vectores;
/**
 * @author Manuel Fernandez
 *  La interface {@code Vector} representa una secuencia de objetos.
 * Las operaciones ofrecidas por cualquier implementacion de esta clase son:
 * <li> suma                             :Suma dos vectores y almacena el resultado en la instancia de invocacion
 * <li> multEscalar                      : Multiplica los valores del vector por un valor entero "n"
 * <li> productoPunto                    : Multiplica dos vectores y devuelve el producto punto de ellos (Int)
 * <li> definirElemento                  : Nos permite settear el valor del vector en una posicion dada
 * @Version 1.0
 */
public interface Vector {

    /**
     * Metodo para definir componentes de un vector
     * @param valor entero de una de las posiciones del vector
     * @param posicion del par del vector a insertar
     */
    public void definirElemento(int valor, int posicion);

    /**
     * Metodo para realizar la suma de dos vectores
     * @param v1 vector a sumar
     */
    public void suma(Vectores v1);

    /**
     * Metodo para multiplicar un vector por un escalar n
     * @Param n valor entero por el cual se multiplica al vector
     */
    public void multEscalar(int n);

    /**
     * Metodo para realizar el producto punto entre dos vectores
     * @param v1 vector
     * @return el valor entero de la operacion producto punto
     */
    public int productoPunto(Vectores v1);

    @Override
    public String toString();

    @Override
    public boolean equals(Object otro);
}