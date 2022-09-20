// Programa hecho por Manuel Fernandez (C1)

#include <stdio.h>
#include <stdlib.h>

struct dato{
    char nombre[25];
    char apellido[25];
    int dni;
    int edad;
};

struct nodo {
    struct dato info;
    struct nodo *next;
};

 // Accion que crea una lista encadenada
void crear(struct nodo **list);
// Accion que inserta un elemento a la cabeza de una lista 
void insertarCab(struct nodo **list, struct dato **dato2);
// Accion que suprime un elemento a la cabeza de una lista 
void suprimirCab(struct nodo **list);
// Accion que verifica si una lista está vacia o no
int vacia(struct nodo *list);
// Accion que muestra el contenido de una lista
void listar(struct nodo *list);
// Menu de operaciones para usuario
void menuOpciones(int *opcion);
// Accion para liberar espacio de memoria
void free(void *ptr);

int main(){
	int op;
	struct nodo *q;
	struct dato *dato1;
	menuOpciones(&op);
	while(op != 5){
		if(op==1){
			crear(&q);
		}
		else if(op==2){
			// Ingreso de datos para cargar la lista
			dato1=(struct dato *)malloc (sizeof(struct dato));
			printf("Ingrese el nombre\n");fflush(stdout);
			scanf("%s", (dato1)->nombre);
			printf("Ingrese el apellido\n");fflush(stdout);
			scanf("%s", (dato1)->apellido);
			printf("Ingrese el DNI\n");	fflush(stdout);
			scanf("%d", &(dato1)->dni);
			printf("Ingrese su edad\n");
			scanf("%d",&(dato1)->edad);
			insertarCab(&q,&dato1);
			free(dato1);
		}
		else if(op==3){
			suprimirCab(&q);
		}
		else if(op==4){
			listar(q);
		}
		menuOpciones(&op);	
	}	
	return 0;
}

	
// Operacion 1
void crear(struct nodo **list){
	*list = NULL;
};

// Operacion 2
void insertarCab(struct nodo **list, struct dato **dato2){
	// Defino una variable nodo auxiliar
    struct nodo *aux;
    // Reservo el espacio en memoria (Pido memoria)
	aux=(struct nodo *)malloc (sizeof(struct nodo));
    // Copio el dato en la variable de tipo
	aux->info = **dato2;
    // Mi variable auxiliar apunta a la ex Cabeza de la lista
	aux->next= *list;
    // Mi variable original apunta nuevamente a la cabeza de la lista
	*list = aux;
}

int vacia(struct nodo *list){
	if(list == NULL){
		return 1;
	}
	else{
		return 0;
	}
}

// Operacion 3
void suprimirCab(struct nodo **list){
	struct nodo *aux;
	if(vacia(*list) == 0){
		aux=*list;
		*list = (*list)->next;
		free(aux);
	}
	else{
		printf("La lista esta vacia!\n");
	}	
}
// Operacion 4
void listar(struct nodo *list){
	struct nodo *aux;
	aux = list;
	while(aux != NULL){
		printf("%s\n", (aux->info).nombre);
		printf("%s\n", (aux->info).apellido);
		printf("%d\n", (aux->info).edad);
		printf("%d\n", (aux->info).dni);
		aux=aux->next;
	}
}

// Accion para mostrar por pantalla el menu de operaciones 
void menuOpciones(int *opcion){
	printf("Ingrese una opcion\n");
	printf("1. Crear lista\n");
	printf("2. Insertar elemento a la cabeza\n");
	printf("3. Suprimir elemento a la cabeza\n");
	printf("4. Mostrar lista completa\n");
	printf("5. Terminar la ejecucion\n");
	scanf("%d", opcion);
	printf("OPCION REALIZADA!\n");
}
