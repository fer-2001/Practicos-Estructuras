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

		System.out.println("Arbol en inorder: " + arbol.aLista());
	}



}