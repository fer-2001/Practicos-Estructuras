#include <stdio.h>

#define MAX 40

typedef struct{
	float n[MAX];
	int cant;
}TData;

void cargarLista (TData *lista, int tamanio);
float rendimientoAcademico (TData list);

int main(){
    int cantNotas;
    TData notasAlumno;
    printf("Ingrese la cantidad de notas del alumno \n");
    scanf("%d", &cantNotas);
    cargarLista( &notasAlumno, cantNotas);
    printf("El promedio del alumno es: %2.f \n", rendimientoAcademico(notasAlumno));
    return 0;
}


void cargarLista (TData *lista, int tamanio){
    int j;
    (lista->cant) = tamanio;
    float valor;
    for (j = 0; j < tamanio; j++){
    printf("Ingrese la nota del alumno\n");
    scanf("%f", &valor);
    lista->n[j] = valor;
    }
}

float rendimientoAcademico (TData list){
float sumaNotas = 0;
int i;
for (i = 0; i < (list.cant); i++){
    sumaNotas = sumaNotas + list.n[i];
}
return (sumaNotas/list.cant);
}