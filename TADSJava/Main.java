package TADSJava;

public class Main{
	public static void main(String args[]){
		ListaConjuntos xs = new ListaConjuntos();
		Integer aux = 2;
		xs.ins(aux);
		xs.ins(aux);
		aux = 5;
		xs.ins(aux);
		 aux = 6;
		xs.ins(aux);
		System.out.println(xs);
		ListaConjuntos ys = new ListaConjuntos();
		ys.ins(8);
		ys.ins(9);
		ys.ins(10);
		xs.union(ys);
		System.out.println(xs);
	}
}
