package tiempoEjecucion;

public class ListaSobreArreglos<T extends Comparable>{
	public static final int MAX_LIST = 100;
	private T item[];
 	private int numItems;

 	public ListaSobreArreglos(int cant){
 		item = (T[]) new Object[cant];
 		numItems = 0;
 }

  	public ListaSobreArreglos(){
 		item = (T[]) new Object[MAX_LIST];
 		numItems = 0;
 }

 	public boolean agregar(T elemento){
 		if(numItems == item.length){
 			throw new ArrayIndexOutOfBoundsException("Arreglo lleno");
 		}
 		item[numItems] = (T) elemento;
 		numItems++;
 	}

 	public void vaciar(){
 		numItems = 0;
 	}

 	public boolean esVacia(){
 		return numItems == 0;
 	}

 	public Integer buscar(T x){
 		// Verificacion de que el elemento buscado sea el ultimo
 		if (item[numItems] == x){
 			return (Integer) item[numItems];
 		}
 		int cant = 0;
		Integer pos = (-1);
		int izq = 0;
		int der = numItems;
		int medio;
		while(izq <= der){
			 medio = (izq + der) / 2;
			 T aux = obtener(medio);
			if (aux == x){
				pos = medio;
				return pos;
			}
			if(aux > x){
				der = medio -1;
			}
			if(aux > x){
				izq = medio + 1;
			}
			cant++;
		}
		System.out.println("Cantidad de pasos realizada: " + cant);
 	}

    @SuppressWarnings("Unchecked")
    private T obtener(int indice){
        return (T) item[indice];
    }


}