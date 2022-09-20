#include "ColasCpp.h";

template<Class T>;

class ColasCpp{
    private:
    int arreglo[];
    int elementos;

    T elemento(int index) {
        	return (T) arreglo[index];
    	}

    public:
    ColasCpp(int Capacidad){
        elementos = 0;
        arreglo[] = arreglo[Capacidad];
    }

    bool esVacia(){
        return elementos == 0;
    }

    bool encolar(T elem){
    		if (esVacia()) {
			arreglo[0] = elem;
			elementos ++;
			return true;
		}
		else{
			for (int i = elementos; i>=0; i--){
				arreglo[i+1] = arreglo[i];
			}
			arreglo[0] = elem;
			elementos++;
			return true;
		}
    
    
    }

    T desencolar(){
        T aux = elemento(elementos);
		elementos--;
		return aux;
    }

	int elementos(){
        return elementos;
    }

	T primero() {
		return elemento(elementos-1);
	}

	
	void vaciar() {
		elementos = 0;
	}





}