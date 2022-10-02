package colaCircular;


public class ColaArregloCircular implements ColaCircular{
	private static final int MAX = 5;
	private Object[] array;
	private int init;
	private int end;
	private int elementos;

	public ColaArregloCircular(){
		array = new Object[MAX];
		init = 0;
		end = 0;
	}


    public boolean encolarFin(Object elem) {
        if(elementos == MAX){
            throw new ArrayIndexOutOfBoundsException("Cola llena");
        }
        else{
            System.out.println("Valor de end (al entrar de encolarFin): " + end);
            array[end] = elem;
            elementos++;
            end = (end + 1) % MAX;
            return true;
        }
    }

    @Override
    public Object desencolar() {
        if(elementos == 0){
            throw new ArrayIndexOutOfBoundsException("La cola es vacia");
        }
        else{
            Object result = array[init];
            init = (init + 1) % MAX;
            elementos--;
            return result;
        }
    }


	public boolean encolarInic(Object elem){
		if(elementos == array.length){
			throw new ArrayIndexOutOfBoundsException("Cola llena, desencole un elemento para continuar");
		}
		if(elementos == 0){
			array[init] = elem;
			end = (end + 1) % MAX;
		}
		else{
			int i = (end - 1);
			while(i >= init){
				array[i+1] = array[i];
				end = (end + 1) % MAX;
				i--;
			}
			array[init] = elem;
			end = (end + 1) % MAX;
		}
		System.out.println("Valor de end (al salir de encolarInc): " + end);
	return true;
	}

	public boolean desencolarFin(){
		return false;
	}


	public String toString(){
        String result = "";
        for(int i = 0; i<MAX; i++){
            result = result + "[" + array[i] + "]";
        }
        return result;
	}

}