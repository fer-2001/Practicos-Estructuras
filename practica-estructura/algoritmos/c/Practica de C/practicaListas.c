
#include <stdio.h>
#include <stdlib.h>


struct notas{
    float puntaje;
};

struct nodo{
    struct notas info;
    struct nodo *next;
};

void crearLista(struct nodo **lista);
void insertarNota(struct nodo **lista, struct notas **dato1);
void free(void *ptr);
void suprimirCab(struct nodo **list);
int esVacia(struct nodo *lista);
float calcularPromedio(struct nodo *lista, int cant);

int main(){
    struct nodo *notasAlumnos;
    struct notas *dato;
    int cantidad;
    int i;
    crearLista(&notasAlumnos);
    printf("Inserte la cantidad de notas a cargar \n");
    scanf("%d", &cantidad);
    dato = (struct notas *)malloc (sizeof(struct notas));
    for(i = 0; i<cantidad; i = i + 1){
        printf("Ingrese la nota del alumno\n");
        scanf("%f", &(dato)->puntaje); 
        insertarNota(&notasAlumnos, &dato); 
    }
    printf("El promedio del alumno es: %2.f", calcularPromedio(notasAlumnos, cantidad));
    return 0;
}


void crearLista(struct nodo **lista){
    *lista = NULL;
}


void insertarNota(struct nodo **lista, struct notas **dato1){
    struct nodo *aux;
    aux=(struct nodo *)malloc (sizeof(struct nodo));
    aux->info = **dato1;
    aux->next = *lista;
    *lista = aux;
}

int esVacia(struct nodo *lista){
    if (lista = NULL){
        return 1;
    }
    else{
        return 0;
    }
}

void suprimirCab(struct nodo **list){
	struct nodo *aux;
	if(esVacia(*list) == 0){
		aux=*list;
		(*list) = (*list)->next;

        }
	else{
		printf("La lista esta vacia!\n");
	}	
}

void listar(struct nodo *lista){
    struct nodo *aux;
	aux = lista;
    while(aux != NULL){
        printf("%d\n", (aux->info).puntaje);
		aux=(aux)->next;
    }
}

float calcularPromedio(struct nodo *lista, int cant){
float sum;
sum = 0;
struct nodo *aux;
aux = lista;
while((aux->next) != NULL){
        sum= sum + (aux->info).puntaje;
		aux = (aux)->next;
    }
return(sum/cant);
}