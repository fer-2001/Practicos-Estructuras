package colecciones.arbol;


import java.util.Comparator;

public class Main{



	public static void main(String[] args){
    	Comparator<Integer> comp = Comparator.naturalOrder();
    	ABB<Integer> arbol = new ABB<>(comp);
	   	ABB<Integer> arbol2 = new ABB<>(comp);

		
		arbol.insertar(5);
		arbol.insertar(6);
		arbol.insertar(3);
		arbol.insertar(4);
		arbol.insertar(2);
		arbol.insertar(8);
		arbol.insertar(7);
		arbol.insertar(0);

		arbol2.insertar(5);
		arbol2.insertar(6);
		arbol2.insertar(3);
		arbol2.insertar(4);
		arbol2.insertar(2);
		arbol2.insertar(8);
		arbol2.insertar(7);
		arbol2.insertar(0);
   		
   		/*
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
    
		//<arbol.insertar(340);
		//arbol.insertar(346);
		//arbol.borrar(346);

		/*
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
		arbol.insertar(332);
*/


	/*
		arbol.insertar(50);
		arbol.insertar(51);
		arbol.insertar(52);
		arbol.insertar(53);
		arbol.insertar(54);
		arbol.insertar(55);
		arbol.insertar(56);
		arbol.insertar(57);
		arbol.insertar(58);
		arbol.insertar(49);
		arbol.insertar(48);
		arbol.insertar(47);
		arbol.insertar(46);
		arbol.insertar(45);
		arbol.insertar(44);
		arbol.insertar(43);
	*/


		//System.out.println("Mayor elemento: " + (arbol.mayorValor()));
		//System.out.println("Menor elemento: " + (arbol.menorValor()));
		//System.out.println("El elemento pertenece? " + arbol.pertenece(8));
		
		//System.out.println("Sucesor de 153: " + arbol.sucesor(153));
		//System.out.println("predecesor de 153: " + arbol.predecesor(153));
		//System.out.println("Arbol en preOrder: " + arbol);
		//Diccionario<Integer> arbol2 = arbol.subArbolIzquierdo();
		//System.out.println("Arbol2 en preOrder: " + arbol2);

		//arbol.borrar(153);
		
	
		//arbol.borrar(34);

		//System.out.println("Se borro el elemento 151");
		System.out.println("Arbol en preOrder: " + arbol);
		System.out.println("Altura del arbol: " + arbol.altura());
		System.out.println("Cantidad de elementos del arbol: " + arbol.elementos());
		System.out.println("Arbol y arbol2 son iguales?: " + arbol.equals(arbol2));
		//System.out.println("Balance del arbol (desde su raiz): " + arbol.balance());

		//System.out.println("Arbol en preOrder: " + (arbol.subArbolDerecho()).aLista());

	}



}