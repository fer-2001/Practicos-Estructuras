#include <stdio.h>
#include <stdlib.h>

#define N 200


typedef struct{
	int a[N];
	int cant;	
}TLista;


// Perfiles de las funciones a programar

int es_vacia(TLista n);

void agregar(TLista *n, int elemento);

void insertar(TLista *n, int posicion, int elemento);

void fin(TLista *n, int elemento);

// elimina la cabeza de la lista (remueve el primer elemento).
/*  0 si es exitosa la operacion
 * -1 si la lista es vacia. */
int eliminar_comienzo(TLista *lista);

int eliminar(TLista *n, int posicion);

int obtener(TLista n, int posicion);

TLista reversa(TLista n);

// concatenacion de listas.
TLista concat(TLista *ini, TLista *cola);

// retorna la sub-lista comenzando en 'ini' y terminando en 'fin'
//TLista sub(TLista *lista, int ini, int fin );

// retorna el primer elemento de una lista no vacia.
int cabeza(TLista n);

// retorna todos los elementos de la lista menos el primero.
TLista cola(TLista *lista);

// muestra el contenido de la lista en la salida estandar 'std'
void mostrar(TLista lista);

//int reemplazar( tipo_lista lista, int elemento, int posicion);

//void intercarmbiar(tipo_lista lista, int posicion1, int posicion2);

//int buscar(tipo_lista lista, int posicion);

// -------------- COMIENZO DE DEFINICIONES -------------- //

int es_vacia(TLista n){
	if(n.cant == 0){
		return 1;
	}
	else{
		return 0;
	}

}
// Agrega un elemento al comienzo de la lista
void agregar(TLista *n, int elemento){
 	// Falta agregar un if de aviso por el tamaño del arreglo
	if (n->cant != 0){
	for(int ult = (n->cant); ult>-1; ult = ult-1){
		n->a[ult+1] = n->a[ult];
	}
	
	(n -> a[0]) = elemento;
	(n -> cant) = (n -> cant) + 1;		
	}

	else{
		(n -> a[0]) = elemento;
		(n -> cant) = (n -> cant) + 1;		
	}
}

void insertar(TLista *n, int posicion, int elemento){
		if ( posicion < 0){
		printf("Posicion invalida\n");
	};

	if(posicion == 0){
		agregar(n, elemento);
	};

	/* mueve el cursor a la posicion dada. */
	if(posicion < n->cant && posicion > 0){
	for(int i = n->cant; i > (posicion-1)  ; i = i-1){
		n->a[i+1] = n->a[i];
	}
	(n -> a[posicion]) = elemento;
	(n -> cant) = (n -> cant) + 1;
	};

	if(posicion >= (n->cant)){
		fin(n, elemento);
	};

}

// Inserta al final
void fin(TLista *n, int elemento){
	//int fin = n->cant;
	n->a[n->cant] = elemento;
	(n -> cant) = (n -> cant) + 1;
}

int eliminar_comienzo(TLista *n){
 	// Falta agregar un if de aviso por el tamaño del arreglo
	for(int i = 0; i<(n->cant-1); i++){
		n->a[i] = n->a[i+1];
	}
	(n -> cant) = (n -> cant) - 1;
	return 0;
}

int eliminar(TLista *n, int posicion){
	if ( posicion < 0 || posicion > n->cant ){
		return -1;
	};

	if (es_vacia(*n) == 1){
		return -1;
	}

	if (posicion == 0){
		eliminar_comienzo(n);
		return 0;
	}

	for(int i = posicion; i<(n->cant-1); i++){
		n->a[i] = n->a[i+1];
	}
	(n -> cant) = (n -> cant) - 1;
	return 0;
}


int obtener(TLista n, int posicion){
	return n.a[posicion];
}

int cabeza(TLista n){
	return n.a[0];
}

void mostrar(TLista n){
	printf( "[ " );

	for (int i = 0; i < (n.cant); i++ ){
		printf( "%i ", obtener(n,i));
	};

	printf( "]" );
}

// retorna todos los elementos de la lista menos el primero.
TLista cola(TLista *lista){
eliminar_comienzo(lista);
return *lista;
}

TLista reversa(TLista n){
	TLista *reversa;
	reversa->cant = 0;
	int j = 0;
	for (int i = n.cant-1; i >= 0; i = i-1){
		reversa->a[j] = (n.a[i]);
		reversa->cant = reversa->cant + 1;
		j++;
	}
return *reversa;
}

TLista concat(TLista *ini, TLista *cola){
	int tamanio = (ini->cant) + (cola->cant);
	int j = 0;
	for(int i = ini->cant; i<tamanio; i++){
		ini->a[i] = cola->a[j];
		j++;
		ini->cant = ini->cant + 1;
	}
	return *ini;
} 

void promedios(TLista lista){
	float notasAprob = 0;
	float notasDesaprob = 0;
	float vecesAprob = 0;

	for(int i = 0; i < lista.cant; i++){
		if (lista.a[i] >= 5){
			notasAprob = notasAprob + lista.a[i];
			vecesAprob = vecesAprob + 1;
		}
		if(lista.a[i] < 5 ){
			notasDesaprob = notasDesaprob + lista.a[i];
		}
	}

	printf("Promedio sin aplazos: %f \n", (notasAprob/vecesAprob));
	printf("Promedio con aplazos: %f \n", ((notasDesaprob + notasAprob) /(lista.cant)));


}


// ------------------------------ Definicion de main ------------------------------ //

int main( int argc, char * argv[] )
{
  
  TLista lista;
  lista.cant = (0);
	insertar(&lista, 0, 10);
	insertar(&lista, 1, 2);
	insertar(&lista, 2, 5);
	insertar(&lista, 3, 6);
	insertar(&lista, 4, 3);
	insertar(&lista, 5, 6);
	insertar(&lista, 6, 3);
	insertar(&lista, 7, 4);
	printf( "lista = " );
	mostrar( lista );
	printf("\n");
	
	promedios(lista);
	/*
	int positivos = 0;
	int negativos = 0;

	for(int i = 0; i < lista.cant; i++){
		if (lista.a[i] > 0){
			positivos = positivos +1;
		}
		else{
			negativos = negativos + 1;
		}
	}

	if (positivos > negativos){
		printf("Hay mas numeros enteros positivos que negativos\n");
	}
	else{
		printf("Hay mas numeros enteros negativos que positivos\n");
	}
*/

	

	
  return 0;
}



/*
	
	printf( "reversa( lista ) = " );
	mostrar(reversa(lista));
	printf("\n");


	printf( "Insertar en la lista original el valor 0 en la posicion 1 =" );
	insertar(&lista, 1, 0);
	
	// lista = [ 1, 0, 2, 3, 4 ]
	
	mostrar( lista );
	printf("\n");
*/