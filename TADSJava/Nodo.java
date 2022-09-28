package TADSJava;

public class Nodo{
	private Object dato;
	private Nodo next;
	private Nodo back;

	public Nodo(){
		dato = null;
		next = null;
		back = null;
	}

	public Nodo getNext(){
		return next;
	}

	public Nodo getBack(){
		return back;
	}

	public Object getDato(){
		return dato;
	}

	public void setNext(Nodo sig){
		next = sig;
	}

	public void setBack(Nodo anterior){
		back = anterior;
	}

	public void setDato(Object elem){
		dato = elem;
	}

}