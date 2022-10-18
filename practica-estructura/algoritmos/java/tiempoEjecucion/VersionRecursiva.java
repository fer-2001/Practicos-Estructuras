package tiempoEjecucion;

public class ListaSobreArreglosint{
	public static final int MAX_LIST = 100;
	private int item[];
 	private int numItems;

 	public ListaSobreArreglosint(int cant){
 		item = new int[cant];
 		numItems = 0;
 }

  	public ListaSobreArreglosint(){
 		item = new int[MAX_LIST];
 		numItems = 0;
 }

 	public boolean agregar(int elemento){
 		if(numItems == item.length){
 			throw new ArrayIndexOutOfBoundsException("Arreglo lleno");
 		}

 		item[numItems] = elemento;
 		numItems++;
 		return true;
 	}

 	public void vaciar(){
 		numItems = 0;
 	}

 	public boolean esVacia(){
 		return numItems == 0;
 	}


 	public Integer buscar(int x){
 		int izq = 0;
 		int der = item.length;
 		Integer output = buscar(x,izq,der);
 		return output;
 	}

 	public Integer buscar(int x, int izq, int der){
 		// Verificacion de que el elemento buscado sea el ultimo
 		if (item[numItems-1] == x){
 			return numItems-1;
 		}
 		// Posicion del elemento buscado
		//Integer pos = (-1);
		// Indice del medio
		Integer medio = (izq+der) / 2;
			
			if(der < izq){
				return -2;
			}

			if(item[medio] < x){
				buscar(x, izq, medio-1);
			}	


			if(item[medio] > x){
				buscar(x, medio+1, der);
			}

			if (item[medio] == x){
				return medio;
			}
		
		return -1;
 	}

    @SuppressWarnings("Unchecked")
    private int obtener(int indice){
        return item[indice];
    }


}