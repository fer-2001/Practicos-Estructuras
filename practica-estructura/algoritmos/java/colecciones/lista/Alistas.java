package colecciones.lista;

public class Alistas <T> implements Lista <T>{
    private final  static int MAX = 100;
    private Object[] arreglo;
    private int elementos;

    public Alistas(){
        arreglo = (T[]) new Object [MAX];
        elementos = 0;
    }

    public Alistas(int tamanio){
        arreglo = (T[]) new Object[tamanio];
        elementos = 0;
    }

    public boolean agregar(T elem) {
        if (elementos == arreglo.length){
            throw new ArrayIndexOutOfBoundsException("Arreglo lleno");
        }
        if (elementos < arreglo.length){
            arreglo[elementos] = elem;
            elementos++;
            return true;
        }
        else {
           return false;
        }
    }


    public boolean agregarTodos(Lista otraLista) {
        int totalElems = elementos + otraLista.elementos();
        int j = 0;

        if(otraLista.esVacia()){
            return  true;
        }

        if(totalElems < arreglo.length){
        for (int i = elementos; i < totalElems; i++){
            arreglo[i] = otraLista.obtener(j);
            elementos++;
            j++;
        }
        return true;
        }

        else{
            return false;
        }
    }


    public boolean insertar(T elem, int indice) {
        if(indice < 0 || indice > arreglo.length){
            throw new ArrayIndexOutOfBoundsException("Posicion invalida");
        }
        if (indice >= elementos) {
            agregar(elem);
            return true;
        }
        if(indice < elementos && indice > 0){
        for(int j = elementos; j > (indice-1)  ; j = j-1){
                arreglo[j+1] = arreglo[j];
        }
        arreglo[indice] = elem;
        elementos++;
        return true;
        }
        else{
            return false;
        }
    }


    public T eliminar(int indice) {
        if(indice < 0 || indice > elementos){
            throw new ArrayIndexOutOfBoundsException("No se pude eliminar un elemento que no existe") ;
        }
        if(elementos == 0){
            throw new ArrayIndexOutOfBoundsException("El arreglo está vacio");
        }
        T aux = obtener(indice);
        for(int i = indice; i < elementos-1; i++){
            arreglo[i] = arreglo[i+1];
        }
        elementos--;
        return aux;
    }


    public T obtener(int indice) {
        if(indice < 0 || indice > elementos){
            throw new ArrayIndexOutOfBoundsException("No se pude eliminar un elemento que no existe") ;
        }
        return (T) arreglo[indice];
    }


    public Lista subLista(int desdeInd, int hastaInd) {
        if (desdeInd < 0 || desdeInd > elementos || hastaInd < 0 || hastaInd > elementos || desdeInd > hastaInd){
            throw new ArrayIndexOutOfBoundsException("Verifique los valores de entrada");
        }
        Lista aux = new Alistas(this.elementos);
        for(int i = desdeInd; i < hastaInd; i++){
            T elemento = (T) arreglo[i];
            aux.agregar(elemento);
        }
        return aux;
    }


    public boolean contiene(Object elem) {
        for (int i = 0 ; i < elementos; i++){
            if(arreglo[i] == elem){
                return true;
            }
        }
        return false;
    }


    public void vaciar() {
    elementos = 0;
    }


    public int elementos() {
        return elementos;
    }


    public boolean esVacia() {
        return elementos == 0;
    }


    public boolean repOK() {
        return cantidadCorrecta() && !(esCircular());
    }

    private boolean cantidadCorrecta(){
        int cantidadReal = 0;
        while(arreglo[cantidadReal] != null){
            cantidadReal++;
        }
        return cantidadReal == elementos;
    }
    /*
    private boolean esCircular(){
        int aux = arreglo[0].hashCode();
        boolean result = true;
        for(int i = 1; i < elementos;i++){
            if (aux == arreglo[i].hashCode()){
                result = false;
            }
        }
        return result;
    }

    */
    public boolean esCircular(){
        return true;
    }

    @Override
    public String toString(){
        String resultado = "";
        for(int i=0; i < elementos; i++){
            T mostrar = (T) arreglo[i];
            float aux = arreglo[i].hashCode();
            resultado = resultado + "[" + mostrar + "]";
        }
        resultado = resultado + "\n";
        return resultado;
    }

    @Override
    public boolean equals(Object otro){
        if(otro == null){
            return false;
        }
        if(this == otro){
         return true;
        }
        if(!(otro instanceof Alistas)){
            return false;
        }
        Alistas otraLista = (Alistas) otro;
        if(this.elementos != otraLista.elementos()){
            return false;
        }
        for (int i = 0; i < elementos; i++){
            if (arreglo[i] != otraLista.obtener(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void provocarCircular() {
    }
}
