package colecciones.arbol;


import java.util.Comparator;

public class Main{



	public static void main(String[] args){
    	Comparator<Integer> comp = Comparator.naturalOrder();
    	ABB<Integer> arbol = new ABB<>(comp);
		/*
		arbol.insertar(5);
		arbol.insertar(6);
		arbol.insertar(3);
		arbol.insertar(4);
		arbol.insertar(2);
		arbol.insertar(8);
		arbol.insertar(7);
		arbol.insertar(0);
   
		arbol.insertar(15);
		arbol.insertar(20);
		arbol.insertar(6);
		arbol.insertar(3);
		arbol.insertar(9);
		arbol.insertar(1);
		arbol.insertar(4);
		arbol.insertar(7);
		arbol.insertar(12);
		arbol.insertar(18);
		arbol.insertar(17);
		arbol.insertar(24);
	
		*/

		arbol.insertar(340);
		arbol.insertar(346);
		arbol.insertar(151);
		arbol.insertar(79);
		arbol.insertar(17);
		arbol.insertar(4);
		arbol.insertar(34);
		arbol.insertar(77);
		arbol.insertar(137);
		arbol.insertar(104);
		arbol.insertar(268);
		arbol.insertar(180);
		arbol.insertar(153);
		arbol.insertar(188);
		arbol.insertar(306);
		arbol.insertar(292);
		arbol.insertar(278);
		arbol.insertar(273);
		arbol.insertar(331);
		arbol.insertar(308);
		arbol.insertar(322);
		//arbol.insertar();



		System.out.println("Mayor elemento: " + (arbol.mayorValor()));
		System.out.println("Menor elemento: " + (arbol.menorValor()));
		System.out.println("El elemento pertenece? " + arbol.pertenece(8));
		//arbol.borrar(4);
		//ABB<Integer> arbol2 = arbol.subArbolIzquierdo();
		System.out.println("Sucesor de 331: " + arbol.sucesor(331));
		System.out.println("Arbol en preOrder: " + arbol);
		//System.out.println("Arbol en preOrder: " + (arbol.subArbolDerecho()).aLista());

	}



}