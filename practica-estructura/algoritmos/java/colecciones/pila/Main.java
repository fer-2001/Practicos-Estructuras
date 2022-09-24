package colecciones.pila;

public class Main {
    public static void main(String[] args){
        Pila <Integer> nuevaPila = new PilaListaE<Integer>();
        nuevaPila.apilar(2);
        nuevaPila.apilar(2);
        nuevaPila.apilar(2);
        System.out.println(nuevaPila);
        System.out.println("Tope de la pila: " + nuevaPila.tope());
        System.out.println("Longitud de la pila: " + nuevaPila.longitud());
        //Integer elem = (Integer) nuevaPila.desapilar();
        //System.out.println("Elemento desapilado : " + elem);
        System.out.println("El invariante de la clase se cumple? : " + nuevaPila.repOK());
    }
}

