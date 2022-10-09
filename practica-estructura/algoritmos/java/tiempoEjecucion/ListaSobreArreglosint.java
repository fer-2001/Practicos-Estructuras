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
 		// Verificacion de que el elemento buscado sea el ultimo
 		if (item[numItems-1] == x){
 			return numItems-1;
 		}
 		// Posicion del elemento buscado
		Integer pos = (-1);
		// Indices de más a la izquierda
		int izq = 0;
		// Indices de más a la derecha
		int der = numItems;
		// Indice del medio
		int medio;
		while(izq <= der){
			cant++;
			medio = (izq + der) / 2;
			if (item[medio] == x){
				pos = medio;
				return pos;
			}
			if(item[medio] > x){
				der = medio -1;
			}
			if(item[medio] < x){
				izq = medio + 1;
			}	
		}		
		return pos;
 	}

    @SuppressWarnings("Unchecked")
    private int obtener(int indice){
        return item[indice];
    }


}