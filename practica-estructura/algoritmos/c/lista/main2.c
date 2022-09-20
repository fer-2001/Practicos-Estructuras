#include <stdio.h>
#include <stdlib.h>
#include "pila_enteros.h"	
#include "lista_enteros.h"

/* ejemplo para manipular pilas rey */


int main( int argc, char * argv[] )
{
  
  tipo_lista lista = crear( );
	
	apilar(lista, 1);
	apilar(lista, 2);
	apilar(lista, 3);
	apilar(lista, 4);
	desapilar(lista);
	
	// lista = [ 1, 2, 3, 4 ]
	
	printf( "lista = " );
	mostrar( lista );
	printf("\n");

  return 0;
}

	
/*

	
	printf("Valor antiguo de la posicion 3: %d \n", reemplazar(lista, 5, 3));
  mostrar( lista );
	printf("\n");

	printf("Se intercambia la pos 1 con la 2\n");
	intercarmbiar(lista,1,2);
  mostrar( lista );
	printf("\n");


	// reversa( lista ) = [ 4, 3, 2, 1 ]
	
	printf( "reversa( lista ) = " );
	mostrar( reversa( lista ) );
	printf("\n");
	
	tipo_lista xs = concat( lista, reversa( lista ) );
	
	// xs = [ 1, 2, 3, 4, 4, 3, 2, 1 ]
	
	printf( "concatenamos la lista y su reversa = " );
	mostrar( xs );
	printf("\n");

	printf( "Insertar en la lista original el valor 0 en la posicion 1 =" );
	
	ins( lista, 0, 1 );
	
	// lista = [ 1, 0, 2, 3, 4 ]
	
	mostrar( lista );
	printf("\n");
	
	*/