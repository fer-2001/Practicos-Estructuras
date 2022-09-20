package colecciones.lista;


public class Elistas <T> implements Lista<T>{

    private Nodo<T> primero;
    private int elementos;

    public Elistas(){
        primero = null;
        elementos = 0;
    }

    @Override
    public boolean agregar(T elem) {
        insertar(elem,elementos);
        return true;
    }

    @Override
    public boolean agregarTodos(Lista<T> otraLista) {
       int limite = otraLista.elementos();
        for (int i = 0; i < limite; i++){
            insertar(otraLista.obtener(i), elementos);
        }
        return true;
    }

    @Override
    public boolean insertar(T elem, int indice) {
        if (indice > elementos){
            throw new NullPointerException("Indice fuera de rango");
        }
        if (indice == 0){
            Nodo aux = new Nodo(elem, primero);
            primero = aux;
            elementos++;
            return true;
        }
        if (indice > 0){
            Nodo aux;
            Nodo aux2;
            aux = primero;
            for (int i = 0; i < indice-1; i++){
                aux = aux.getSig();
            }
            aux2 = aux.getSig();
            Nodo ins = new Nodo(elem, aux2);
            aux.setSig(ins);
            elementos++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public T eliminar(int indice) {
        if (indice < 0 || indice > elementos){
            throw new NullPointerException("Indice fuera de rango");
        }
        if (indice == 0){
            T aux = (T) primero.getElemento();
            primero = primero.getSig();
            return aux;
        }
        else{
            Nodo aux;
            T auxiliar;
            Nodo aux2;
            aux = primero;
            for (int i = 1; i < indice-1; i++){
                aux = aux.getSig();
            }
            aux2 = aux.getSig();
            auxiliar = (T) aux2.getElemento();
            aux.setSig(aux2.getSig());
            elementos--;
            return auxiliar;
        }
    }

    @Override
    public T obtener(int indice) {
        if (indice < 0 || indice > elementos){
            throw new NullPointerException("Posicion fuera de alcance");
        }
        if (indice == 0){
            return (T) primero.getElemento();
        }
        else{
            Nodo aux;
            T elemento;
            aux = primero;
            for (int i = 1; i <= indice; i++){
                aux = aux.getSig();
            }
            elemento = (T) aux.getElemento();
            return elemento;
        }
    }

    @Override
    public Lista<T> subLista(int desdeInd, int hastaInd) {
        if (desdeInd < 0 || desdeInd > elementos || hastaInd < 0 || hastaInd > elementos || desdeInd > hastaInd){
            throw new NullPointerException("Verifique los valores de entrada");
        }
        Lista lista = new Elistas();
        int aux = desdeInd;
        while(aux < hastaInd){
            lista.agregar(obtener(aux));
            aux++;
        }
    return lista;
    }

    @Override
    public boolean contiene(T elem) {
        Nodo aux;
        aux = primero;
        while(aux.getSig() != null){
            if (aux.getElemento() == elem){
                return  true;
            }
            else{
                aux = aux.getSig();
            }
        }
        return false;
    }

    @Override
    public void vaciar() {
        primero = null;
        elementos = 0;
    }

    @Override
    public int elementos() {
        return elementos;
    }

    @Override
    public boolean esVacia() {
        return elementos == 0;
    }

    @Override
    public boolean repOK() {
        return cantidadCorrecta();
    }
    public void provocarCircular(){
        primero.setSig(primero);
    }
    private boolean esCircular(){
        Nodo aux;
        aux = primero;
        Nodo aux2 = aux.getSig();
        int j = 1;
        for(int i = 0; i<elementos; i++){
            while (j < elementos){
                if(aux == aux2){
                    return true;
                }
                aux2 = aux2.getSig();
            j++;
            }
            aux = aux.getSig();
            aux2 = aux.getSig();
            j = i + 2;
        }
    return false;
    }

    private boolean cantidadCorrecta(){
        int cantidadReal = 1;
        Nodo aux;
        aux = primero;
        while(aux.getSig() != null){
                cantidadReal++;
                aux = aux.getSig();

        }
        return cantidadReal == elementos;
    }

    @Override
    public String toString(){
    Nodo<T> aux;
    aux = primero;
    String resultado = "";
        while (aux != null){
            resultado = resultado + "[" + aux.getElemento() + "]";
            aux = (Nodo <T>) aux.getSig();
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
        if(!(otro instanceof Elistas)){
            return false;
        }
        Elistas aux = (Elistas) otro;
        if(aux.elementos != elementos){
            return false;
        }
        for (int i = 0; i < elementos; i++){
            if(aux.obtener(i) != this.obtener(i)){
                return false;
            }
        }
    return true;
    }
}
