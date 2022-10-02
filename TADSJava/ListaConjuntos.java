package TADSJava;

public class ListaConjuntos implements Conjuntos{
	private Nodo lista;
	private int elementos;

	public ListaConjuntos(){
		lista = new Nodo();
		elementos = 0;
	}

	public void ins(Object elem){
		if (elementos==0){
			Nodo aux = new Nodo();
			aux.setDato(elem);
			lista = aux;
			elementos++;
		}
		else{
			if (!pertenece(elem)){
				int i = 0;
				Nodo aux2;
				aux2 = lista;
				while(i < elementos){
					aux2 = aux2.getNext();
					i++;
				}
				Nodo aux = new Nodo();
				aux.setDato(elem);
				aux.setBack(aux2);
				aux2.setNext(aux);
				elementos++;
			}
		}
	}

	private boolean pertenece(Object elem){
		Nodo aux = new Nodo();
		aux = lista;
		while(aux != null){
			if(aux.getDato() == elem){
				return true;
			}
			aux = aux.getNext();
		}
		return false;
	}

	private int getElementos(){
		return elementos;
	}

	private Nodo getCabeza(){
		return lista;
	}

	public void union(ListaConjuntos ys){
		Nodo aux = ys.getCabeza();
		for(int i = 0; i < ys.getElementos()-1; i++){
			Object dato = aux.getDato();
			System.out.println("Valor del dato:" + dato);
			aux = aux.getNext();
			ins(dato);
			this.elementos++;
		}
	}

	@Override
	public String toString(){
	Nodo aux;
    aux = lista;
    String resultado = "{";
        while (aux != null){
            resultado = resultado + aux.getDato() + ",";
            aux = aux.getNext();
        }
    return resultado + "}";
    }
}


