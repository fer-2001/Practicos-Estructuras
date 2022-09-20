#include <iostream>
#include "Tpila.h"
using namespace std;
int main( )
{Pila<float> PilaFloat(5);      // Se crea un objeto tipo pila float con 5 elementos
float f = 0;
cout << "--- Pila de tipo Float --- " << endl;
cout << "Introduciendo elementos a la pila " << endl;
while(PilaFloat.push(f))        // Si es 1 fue exitoso
{      cout << f << " ";
        f +=1.1;
}

cout << endl << "La pila esta llena. No se puede meter otro elemento: " << f                     << endl;
cout << "Sacando elementos de la pila..." << endl;

while ( PilaFloat.pop(f))    cout << f << " " << endl;
cout << "\nLa pila esta vacia.\n";

Pila<int> PilaInt;          // Se crea un objeto tipo pila Entero con n
int i=1;
cout << "--- Pila de tipo Int --- " << endl;
cout << "Introduciendo elementos a la pila " << endl;
while (PilaInt.push(i))     // retorna 1 si fue exitoso
{       cout << i << " "; 
        i++;
        }
cout << "La pila esta llena. No se puede meter: " << i << endl;
cout << "Sacando elementos de la pila..." << endl;

while ( PilaInt.pop(i)) cout << i << " ";
cout << "\nLa pila esta vacia \n";
system("pause > nul");
return 0;
}