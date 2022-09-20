package colecciones.cola;

public class Main {
    public static void main (String arg [] ){
        Cola nuevaCola = new <Integer> ColaArregloCircular();
        nuevaCola.encolar(1);
        nuevaCola.encolar(2);
        nuevaCola.encolar(3);
        nuevaCola.encolar(4);
        nuevaCola.encolar(5);
        nuevaCola.encolar(6);
        nuevaCola.encolar(7);
        nuevaCola.encolar(7);

        /*
        Cola nuevaCola2 = new <Integer> ColaListaEnlazada();
        nuevaCola2.encolar(1);
        nuevaCola2.encolar(2);
        nuevaCola2.encolar(3);
        nuevaCola2.encolar(4);
        */
        System.out.println("Primer elemento de la cola: " + nuevaCola.primero());
        System.out.println("Cantidad de elementos = " + nuevaCola.elementos());
        System.out.println("La cola es vacia? Respuesta: " + nuevaCola.esVacia());
        System.out.println(nuevaCola);
        //System.out.println("Son iguales? Respuesta: " + nuevaCola.equals(nuevaCola2));
       //System.out.println("Elemento desencolado: " + nuevaCola.desencolar());
        //nuevaCola.encolar(7);
        ///System.out.println("Elemento desencolado: " + nuevaCola.desencolar());
        //System.out.println(nuevaCola);
        // nuevaCola.vaciar();
        //System.out.println("Cola vacia" + nuevaCola);
    }

}
