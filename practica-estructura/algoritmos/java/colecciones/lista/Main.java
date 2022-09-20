package colecciones.lista;


public class Main {
    public static void main(String [] args){
        Lista eLista = new <String> Elistas();
        Lista eLista2 = new <String> Elistas();

        eLista.agregar("hola");
        eLista.agregar("hola");
        eLista.agregar("hola");
        eLista.agregar("hola");
        eLista.agregar("hola");
        eLista2.agregar("hola");
        eLista2.agregar("hola");
        eLista2.agregar("hola");
        //System.out.println(eLista.contiene(5));
        System.out.println(eLista);
        System.out.println(eLista2);
        eLista.agregarTodos(eLista2);
        System.out.println(eLista);
        System.out.println("Sub lista: " + eLista.subLista(1,4));
        //Integer aux = (Integer) eLista.eliminar(3);
        System.out.println("Cantidad de elementos: " + eLista.elementos());
        System.out.println("Elemento eliminado " + eLista.eliminar(6));
        System.out.println("Lista despúes de eliminar: " + eLista);
        System.out.println("Elemento del indice 4: " + eLista.obtener(4));
        System.out.println("La lista contiene el numero 8? " + eLista.contiene(8));
        System.out.println("Cantidad de elementos " + eLista.elementos());
        System.out.println(eLista.equals(eLista2));
        //eLista.provocarCircular();
        //System.out.println("Lista circular: " + eLista);
        System.out.println(eLista.repOK());



    }
}

