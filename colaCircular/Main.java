package colaCircular;

public class Main {
    public static void main (String arg [] ){
        ColaArregloCircular nuevaCola = new ColaArregloCircular();
        nuevaCola.encolarFin(1);
        //nuevaCola.desencolar();
        nuevaCola.encolarInic(3);
        nuevaCola.encolarFin(4);
        System.out.println(nuevaCola);
    }

}