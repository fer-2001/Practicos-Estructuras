#include "ColasCpp.h";
#ifndef ColasCpp_H
#define ColasCpp_H

template<class T>

class ColasCpp{
    private:
    int arreglo[];
    int size;
	T *stackPtr;

    public:
    ColasCpp(int = 10);
    ~ColasCpp(){
        delete[] stackPtr;
    }
    int encolar(const T&);
    int desencolar(T&);
    int colaVacia( ) const {size == 0};


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
    template <class T> ColasCpp<T>:: ColasCpp(int s){
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
#endif