package colecciones.arbol;


import java.util.Comparator;

public class Main{



	public static void main(String[] args){
    	Comparator<Integer> comp = Comparator.naturalOrder();
    	ABB<Integer> arbol = new ABB<>(comp);
		arbol.insertar(5);
		arbol.insertar(6);
		arbol.insertar(3);
		arbol.insertar(4);
		arbol.insertar(2);
		arbol.insertar(8);
		arbol.insertar(0);
		System.out.println("Mayor elemento: " + (arbol.mayorValor()));
		System.out.println("Menor elemento: " + (arbol.menorValor()));
		System.out.println("El elemento pertenece? " + arbol.pertenece(8));
		//arbol.borrar(4);
		//ABB<Integer> arbol2 = arbol.subArbolIzquierdo();
		System.out.println("Arbol en preOrder: " + arbol.aLista());
		//System.out.println("Arbol en preOrder: " + (arbol.subArbolDerecho()).aLista());

	}



}