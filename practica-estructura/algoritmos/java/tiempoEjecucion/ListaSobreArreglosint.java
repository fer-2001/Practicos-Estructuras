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

 // Agrega elementos (NO GARANTIZA QUE SE RESPETE ORDEN)
 	public boolean agregar(int elemento){
 		if(numItems == item.length){
 			throw new ArrayIndexOutOfBoundsException("Arreglo lleno");
 		}

 		item[numItems] = elemento;
 		numItems++;
 		return true;
 	}

// Hacer version de agregar de forma ordenada
 	/*
 	public boolean insertar(int elemento){
 		if(numItems == item.length){
 			throw new ArrayIndexOutOfBoundsException("Arreglo lleno");
 		}
 		
 		boolean cond = false;
 		// Busqueda de posicion para insertar el nuevo elemento


 		// Insercion del elemento en la posicion antes encontrada
 		if(i>=numItems){
 			item[numItems] = elemento;
 			numItems++;
 			return true;
 		}
 		else{
 			for(int j = numItems; j >= i-1; j--){
 				item[j+1] = item[j];
 			}
 			item[i] = elemento;
 		}
		*/
 		/*
 		if(numItems == 0){
 			agregar(elemento);
 			return true;
 		}
 		
        boolean cond = false;
         for(int j=0; j<numItems; j++){
 			if((elemento > item[j])){
 				cond = true;
 			}
 			else{
 				cond = false;
 			}
 		}

 		if(cond){
 			agregar(elemento);
 			return true;
 		}
 		

 		int i = numItems;
 		while(i >= 0 && item[i] > elemento){
 			item[i + 1] = item[i];
 			i--;
 		}
        
       
        item[i + 1] = elemento;

 	return true;

 	}*/

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

    @Override
    public String toString(){
        String resultado = "";
        for(int i=0; i<numItems; i++){
            resultado = resultado + "[" + item[i] + "]";
        }
        return resultado;
    }

}