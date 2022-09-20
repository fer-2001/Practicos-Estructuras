#include <stdio.h>
#include <stdlib.h>

typedef struct lista_enlazada* nodo;

struct lista_enlazada{
	void* valor;
	struct lista_enlazada *siguiente;
};

/* estructura_lista es la implementacion del tipo_lista 
 declarado en lista_enteros.h.
*/
typedef struct estructura_lista{
	nodo cabeza;
	int elementos;
};

nodo crear_nodo( int elemento ){
	nodo linkable = ( nodo ) malloc ( sizeof( struct lista_enlazada ) );

	linkable->valor = elemento;
	linkable->siguiente    = NULL;

	return linkable;
}

int main(int argc, char *argv[]) {
	int x;
	 char s;
	nodo p, q;
	/*x= 2;
	p = &x;
	printf("%d\n", *(int *) p);
	s = 's';
	p = &s;	
	printf("%c\n", *(char *) p);*/
	p = crear_nodo ('s');
	q = crear_nodo(2);
	p->siguiente = q;
	printf("%c\n",  p->valor);
	printf("%i\n",  q->valor);
	p = p->siguiente;
	printf("%i\n",  p->valor);
}


