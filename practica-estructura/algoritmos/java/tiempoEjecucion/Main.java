package tiempoEjecucion;


public class Main{

	public static void main(String[] args){
		ListaSobreArreglosint arr = new ListaSobreArreglosint(20);
		arr.agregar(1);
		arr.agregar(2);
		arr.agregar(3);
		arr.agregar(4);
		arr.agregar(5);
		arr.agregar(6);
		arr.agregar(7);

		System.out.println("Arreglo: " + arr);
		System.out.println("El elemento buscado se encuentra en la posicion: "+ arr.buscar(5));

	}



}