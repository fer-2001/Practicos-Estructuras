package testing;
import java.util.*;
import java.lang.Math.*;

/**
* Provee métodos para ordenar arreglos de objetos comparables.
* Los algoritmos de ordenamiento provistos por esta clase son:
* <ul>
* <li>Bubble sort.</li>
* <li>Selection sort.</li>
* <li>Shell sort.</li>
* <li>Quick sort.</li>
* <li>Merge sort.</li>
* <li>Radix sort.</li>
* </ul>
* El invariante que deben cumplir todos los arreglos {@code array} para ser utilizados como argumentos de los distintos algoritmos de ordenamiento es:
* <pre>
* array != null &amp;&amp; for (T elem : array) {elem != null}
* </pre>
*/
public class ArraySorter {

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Bubble Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
      boolean sorted = false;
      int n = array.length; 
      for (int pass = 1; (pass < n) && !sorted; ++pass) {
         sorted = true;
         for (int index = 0; index < n - pass; ++index) {
            int nextIndex = index + 1;
            if (array[index].compareTo(array[nextIndex]) > 0) {
               swap(array, index, nextIndex);
               sorted = false;
            }
         }
      }
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Selection Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("array is null, can't sort");
      //last = indice del ultimo elemento de la parte no ordenada
      for (int last = array.length - 1; last >= 1; last--) {
         //largest = posicion del elemento mas grande
         int largest = indexOfLargest(array, last + 1);
         swap(array, last, largest);
      }
   }


   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Shell Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void shellSort(T[] array) {
      int n = array.length ;

      if(array == null)
         throw new IllegalArgumentException("array is null, can't sort") ;


      for (int mid = n/2 ; mid > 0 ; mid /= 2)
      {
         for (int i = mid ; i < array.length ; i += 1)
         {
            T temp  = array[i] ;

            for (int j = i ; j >= mid && array[j-mid].compareTo(temp) > 0 ; j -= mid )
            {
               array[j] = temp ;
            }
         }
      }
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Quick Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void quickSort(T[] array) {
      throw new UnsupportedOperationException("TODO: implementar");

   }

   /*
   * Ordena un arreglo, usando el orden natural de sus elementos utilizando Merge Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   
   public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
      if(array== null) 
         throw new IllegalArgumentException("array is null, can't sort");
   


   }*/

   
   public  static Integer[] radixSort(Integer[] entrada)
   {
      if(entrada== null) 
         throw new IllegalArgumentException("array is null, can't sort") ;

      LinkedList[] aux = new LinkedList[10];

      //encuentro el indice del maximo integer
      int max = indexOfLargest(entrada, entrada.length);
      
      //calculo cuantos digitos tiene el maximo
      int DigitCiclar = countDigit(entrada[max]);

      //ciclo para crear las 10 listas enlazadas del arreglo
      for (int h = 0; h < 10 ; h++) aux[h] =  new LinkedList();

      //ciclo por cada digito del mayor
      for (int j = 0; j < DigitCiclar ; j++) {

         //ciclo para llenar el arreglo de listas
         for(int i = 0; i < entrada.length; i++)
            aux[digitAt(entrada[i],j)].add(entrada[i]);

         //ciclo para volver a cargar el arreglo original acomodado mediante el nuevo
         int k = 0;              // variable para las 10 posiciones del arreglo
         int l = 0;              // variable para todos los elementos del arreglo
         //recorre las 10 posiciones del arreglo de listas
         while(k < 10){
            //mientas la lista de indice[k] no este vacia, sigue reemplazando
            while( aux[k].size() != 0){
               entrada[l] = (int) aux[k].poll();
               l++;
            }
            k++;
         }
      }
      return entrada; 
   }


   /* (non-Javadoc)
   * Este método intercambia dos posiciones de un arreglo.
   */ 
   private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

   /* (non-Javadoc)
   * Este método retorna el indice del elemento mas grande. 
   */
   private static <T extends Comparable<? super T>> int indexOfLargest(T[] array, int n){
      int largest = 0;
      for (int i = 1; i < n; i++){
         if (array[i].compareTo(array[largest]) > 0){
            largest = i;
         }
      }  
      return largest;
   }

   public static int countDigit(Integer num)
   {

     if (num == 0) return num ++ ; 
     return (int)(Math.log10(num)+1) ;  
   }

   private static int digitAt(Integer num, int i){
      int output;
      Integer a=10;
      output = (int) (num/Math.pow(a,i)) % a;
      return output;
   }


   public static void mergeSort(Integer[] inputArray) {
       int inputLength = inputArray.length;
       // Caso base para cortar la recursion (tenemos un unico nodo en este punto)
       if (inputLength < 2) {
         return;
       }
       
       int midIndex = inputLength / 2;
       Integer[] leftHalf = new Integer[midIndex];
       Integer[] rightHalf = new Integer[inputLength - midIndex];
       
       for (int i = 0; i < midIndex; i++) {
         leftHalf[i] = inputArray[i];
       }
       for (int i = midIndex; i < inputLength; i++) {
         rightHalf[i - midIndex] = inputArray[i];
       }
       
       mergeSort(leftHalf);
       mergeSort(rightHalf);
       
       merge(inputArray, leftHalf, rightHalf);
    }

  private static void merge (Integer[] inputArray, Integer[] leftHalf, Integer[] rightHalf) {
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;
    
    int i = 0, j = 0, k = 0;
    
    while (i < leftSize && j < rightSize) {
      if (leftHalf[i] <= rightHalf[j]) {
        inputArray[k] = leftHalf[i];
        i++;
      }
      else {
        inputArray[k] = rightHalf[j];
        j++;
      }
      k++;
    }
    
    while (i < leftSize) {
      inputArray[k] = leftHalf[i];
      i++;
      k++;
    }
    
    while (j < rightSize) {
      inputArray[k] = rightHalf[j];
      j++;
      k++;
    }
    
  }



}
