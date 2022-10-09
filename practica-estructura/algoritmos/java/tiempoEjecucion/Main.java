package tiempoEjecucion;


public class Main{

	public static void main(String[] args){
		ListaSobreArreglosint arr = new ListaSobreArreglosint(11);
		arr.agregar(1);
		arr.agregar(2);
		arr.agregar(3);
		arr.agregar(4);
		arr.agregar(5);
		arr.agregar(6);
		arr.agregar(7);
		arr.agregar(8);
		arr.agregar(9);
		arr.agregar(10);
		System.out.println("El elemento buscado se encuentra en la posicion: "+ arr.buscar(9));

	}



}