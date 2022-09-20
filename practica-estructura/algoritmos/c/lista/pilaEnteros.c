#include <stdio.h>
#include <stdlib.h>
#include "pila_enteros.h"

/*
	Implementacion de PILAS POLIMORTIFCAS (NO LE DEN BOLA A LOS NOMBRES DE LOS STRUCTS SALU2) 
	usando la estructura de nodos (listas linkables).
 */

typedef struct lista_enlazada* nodo;

struct lista_enlazada{
	void *valor;
	struct lista_enlazada *siguiente;
};

/* estructura_lista es la implementacion del tipo_lista 
 declarado en lista_enteros.h.
*/
struct estructura_lista{
	nodo cabeza;
	int elementos;
};

nodo crear_nodo(void *elemento ){
	nodo linkable = ( nodo ) malloc ( sizeof( struct lista_enlazada ) );

	linkable->valor = elemento;
	linkable->siguiente    = NULL;

	return linkable;
}


int desapilar(tipo_lista lista){
	lista->cabeza = lista->siguiente;
	return lista;
}

// Mal el tipo de retorno
int tope(tipo_lista lista){
	nodo cursor = lista->cabeza;
	int posicion = lista->elementos;
	for ( int i = 0; i < posicion; i++){
		cursor = cursor->siguiente;
	};
	return cursor->valor;
}


int elementosTotal(tipo_lista lista){
	return lista->elementos;
}

void vaciar(tipo_lista lista){
	lista->cabeza = NULL;
}


// Equivalente a apilar
tipo_lista agregar( tipo_lista lista, void *elemento ){
	nodo linkable = crear_nodo( elemento );

	linkable->siguiente = lista->cabeza;
	lista->cabeza = linkable;
	lista->elementos = (lista->elementos) + 1;

	return lista;
}


tipo_lista crear( void ){
	tipo_lista lista = ( tipo_lista ) malloc ( sizeof( struct estructura_lista ) );

	lista->cabeza = NULL;
	lista->elementos = 0;

	return lista;
}