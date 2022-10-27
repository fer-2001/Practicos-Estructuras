package testing;

import java.util.Arrays;

/**
* Clase ejecutable para demostrar el uso de {@code ArraySorter}
* @see arraySorter.ArraySorter
* @see arraySorter.ArrayGenerator
*/
public class Main {

   public static void main(String[] args) {
      int k = 10000;
      String s = "RadixSort"; 
      probadorDeAlgoritmnos(100,k,s);
      probadorDeAlgoritmnos(1000,k,s);
      probadorDeAlgoritmnos(10000,k,s);
      probadorDeAlgoritmnos(100000,k,s);
      probadorDeAlgoritmnos(1000000,k,s);
      probadorDeAlgoritmnos(10000000,k,s);
      s = "MergeSort"; 
      probadorDeAlgoritmnos(100,k,s);
      probadorDeAlgoritmnos(1000,k,s);
      probadorDeAlgoritmnos(10000,k,s);
      probadorDeAlgoritmnos(100000,k,s);
      probadorDeAlgoritmnos(1000000,k,s);
      probadorDeAlgoritmnos(10000000,k,s);
      s = "bubbleSort"; 
      probadorDeAlgoritmnos(100,k,s);
      probadorDeAlgoritmnos(1000,k,s);
      probadorDeAlgoritmnos(10000,k,s);
      probadorDeAlgoritmnos(100000,k,s);
      probadorDeAlgoritmnos(1000000,k,s);
      //probadorDeAlgoritmnos(10000000,k,s);

   }

   @SuppressWarnings("unchecked")
    private static <E> E[] crearArreglo(int elementos) {
        return (E[]) new Object[elementos];
    }

   private static void probadorDeAlgoritmnos(int n, int k, String s){
         switch(s){
         case "MergeSort":
            if(n <= 1000000){
               Integer[] arreglo1 = ArrayGenerator.generarArregloDeLongitud(0, k, n);
               System.out.println("Arreglo ordenado con MergeSort de " + n + " elementos y en un rango de 0 y " + k + " valores: ");
               long inicio = System.nanoTime();
               ArraySorter.mergeSort(arreglo1); 
               long fin = System.nanoTime();
               System.out.println((fin - inicio) + " ns \n");
            }
            else{
               Integer[] arreglo1 = ArrayGenerator.generarArregloDeLongitud(0, k, n);
               System.out.println("Arreglo ordenado con MergeSort de " + n + " elementos y en un rango de 0 y " + k + " valores: ");
               long inicio = System.currentTimeMillis();
               ArraySorter.mergeSort(arreglo1); 
               long fin = System.currentTimeMillis();
               double tiempo = (double) ((fin - inicio)/1000);
               System.out.println(tiempo +" segundos\n");
            }
         break;
         case "RadixSort":
            if(n <= 1000000){
               Integer[] arreglo1 = ArrayGenerator.generarArregloDeLongitud(0, k, n);
               System.out.println("Arreglo ordenado con RadixSort de " + n + " elementos y en un rango de 0 y " + k + " valores: ");
               long inicio = System.nanoTime();
               ArraySorter.radixSort(arreglo1); 
               long fin = System.nanoTime();
               System.out.println((fin - inicio) + " ns \n");
            }
            else{
               Integer[] arreglo1 = ArrayGenerator.generarArregloDeLongitud(0, k, n);
               System.out.println("Arreglo ordenado con RadixSort de " + n + " elementos y en un rango de 0 y " + k + " valores: ");
               long inicio = System.currentTimeMillis();
               ArraySorter.radixSort(arreglo1); 
               long fin = System.currentTimeMillis();
               double tiempo = (double) ((fin - inicio)/1000);
               System.out.println(tiempo +" segundos\n");
            }
         break;
         case "bubbleSort":
            if(n < 100000){
               Integer[] arreglo1 = ArrayGenerator.generarArregloDeLongitud(0, k, n);
               System.out.println("Arreglo ordenado con bubbleSort de " + n + " elementos y en un rango de 0 y " + k + " valores: ");
               long inicio = System.nanoTime();
               ArraySorter.bubbleSort(arreglo1); 
               long fin = System.nanoTime();
               System.out.println((fin - inicio) + " ns \n");
            }
            else{
               Integer[] arreglo1 = ArrayGenerator.generarArregloDeLongitud(0, k, n);
               System.out.println("Arreglo ordenado con bubbleSort de " + n + " elementos y en un rango de 0 y " + k + " valores: ");
               long inicio = System.currentTimeMillis();
               ArraySorter.bubbleSort(arreglo1); 
               long fin = System.currentTimeMillis();
               double tiempo = (double) ((fin - inicio)/1000);
               System.out.println(tiempo +" segundos\n");
            }
         break;

      
   }
}

}