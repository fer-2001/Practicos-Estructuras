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
      //probadorDeAlgoritmnos(1000000,k,s);
      //probadorDeAlgoritmnos(10000000,k,s); 

   }

   private static void probadorDeAlgoritmnos(int n, int k, String s){
         switch(s){
         case "MergeSort":
               Integer[] arreglo1 = ArrayGenerator.generarArregloDeLongitud(0, k, n);
               System.out.println("Arreglo ordenado con MergeSort de " + n + " elementos y en un rango de 0 y " + k + " valores: ");
               long inicio = System.nanoTime();
               ArraySorter.mergeSort(arreglo1); 
               long fin = System.nanoTime();
               if(n <= 1000000){
                  System.out.println((fin - inicio) + " ns \n");
               }
               else{
                  System.out.println((fin - inicio)/1000000000 + " segundos \n");
               }
         break;
         
         case "RadixSort":
               Integer[] arreglo2 = ArrayGenerator.generarArregloDeLongitud(0, k, n);
               System.out.println("Arreglo ordenado con radixSort de " + n + " elementos y en un rango de 0 y " + k + " valores: ");
               long inicio2 = System.nanoTime();
               ArraySorter.radixSort(arreglo2); 
               long fin2 = System.nanoTime();
               if(n <= 1000000){
                  System.out.println((fin2 - inicio2) + " ns \n");
               }
               else{
                  System.out.println((fin2 - inicio2)/1000000000 + " segundos \n");
               }            
         break;
         case "bubbleSort":
               Integer[] arreglo3 = ArrayGenerator.generarArregloDeLongitud(0, k, n);
               System.out.println("Arreglo ordenado con bubbleSort de " + n + " elementos y en un rango de 0 y " + k + " valores: ");
               long inicio3 = System.nanoTime();
               ArraySorter.bubbleSort(arreglo3); 
               long fin3 = System.nanoTime();
               if(n <= 1000000){
                  System.out.println((fin3 - inicio3) + " ns \n");
               }
               else{
                  System.out.println((fin3 - inicio3)/1000000000 + " segundos \n");
               }
         break;

      
   }
}

   @SuppressWarnings("unchecked")
    private static <E> E[] crearArreglo(int elementos) {
        return (E[]) new Object[elementos];
    }

}