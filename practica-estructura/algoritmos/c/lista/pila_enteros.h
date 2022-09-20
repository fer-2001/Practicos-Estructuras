
// Objeto de un tipo incompleto.
typedef struct estructura_lista* tipo_lista;

//Retorna una lista vacía.
tipo_lista crear( void );

void vaciar(tipo_lista lista);

int elementosTotal(tipo_lista lista);

int tope(tipo_lista lista);

int desapilar(tipo_lista lista);

tipo_lista apilar( tipo_lista lista, int elemento);

int ins( tipo_lista lista, int elemento, int posicion);

void mostrar( tipo_lista lista );

tipo_lista agregar( tipo_lista lista, int elemento );

int obtener( tipo_lista lista, int posicion );

tipo_lista crear( void );