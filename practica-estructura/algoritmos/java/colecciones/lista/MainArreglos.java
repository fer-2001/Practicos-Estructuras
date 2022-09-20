package colecciones.lista;

public class MainArreglos {
    public static void main(String [] args) {
        Lista array = new <Integer> Alistas(50);
        Integer dato = 5;
        array.agregar(7);
        array.agregar(8);
        array.agregar(dato);
        System.out.println(array);
        Integer elem = (Integer) array.eliminar(2);
        System.out.println("Valor eliminado " + elem);
        System.out.println("Contiene el valor 5? : " + array.contiene(5));
        System.out.println("Cantidad de elementos: " + array.elementos());
        array.insertar(6,2);
        array.subLista(1,3);
        System.out.println(array);
        //System.out.println(array.repOK());

    }
}
