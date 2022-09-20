package colecciones.lista;

public class Nodo <T> {
        private T elemento;
        private Nodo<T> siguiente;

        public Nodo (T elem, Nodo sig){
            elemento = elem;
            siguiente = sig;
        }
        public T getElemento(){
            return elemento;
        }
        public Nodo getSig(){
            return siguiente;
        }
        public void setElemento(T elem){
            elemento = elem;
        }
        public void setSig(Nodo sig){
            siguiente = sig;
        }
}
