// TPila.H
// Plantilla simple de clase pila
#ifndef TPila_H
#define TPila_H
template <class T>
class Pila{       
    private:int size; // # de elementos en la pila
    int tope;
    T *stackPtr; // puntero a la pila
public: Pila(int = 10); //longitud por defecto 10
~Pila( ) //Destructor
{    delete [ ] stackPtr; } 
int push(const T&); // pone un elemento en la pila
int pop(T&); // saca un elemento de la pila
int PilaVacia( ) const { return tope == -1; }
int PilaLLena( ) const { return tope == size - 1;}                   //Llena = 1
};

template <class T> Pila<T> :: Pila(int s)
{   size = s;
    tope = -1; // Pila vacia
    stackPtr = new T[size];
}
template <class T> int Pila<T> :: push(const T &valor)
{
    if (!PilaLLena( ))
    {   stackPtr[++tope] = valor;
    return 1; // push correcto}
    return 0; // push no correcto
    }
}
template <class T> int Pila<T> :: pop(T &ValorPop)
{
        if (!PilaLLena( ))
        {     ValorPop = stackPtr[tope--];   
        return 1;
        }
        return 0;
}
#endif