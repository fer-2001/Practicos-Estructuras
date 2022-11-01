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
      if (array == null) throw new IllegalArgumentException("array is null, can't sort");
         quickSort(array, 0, array.length - 1);
   }

  private static <T extends Comparable<? super T>> void quickSort(T[] array, int lowIndex, int highIndex) {
       if (lowIndex >= highIndex) {
         return;
       }
      // Genera una posicion aleatoria para el pivot
       int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
       T pivot = array[pivotIndex];
       // Coloca el elemento pivot al final del arreglo (SIEMPRE) y luego realiza los intercambios
       swap(array, pivotIndex, highIndex);
       
       // Devuelve la posicion donde quedo el elemento ordenado(posicion final de ese elemento seguro)
       int leftPointer = partition(array, lowIndex, highIndex, pivot);

       // Valores menores al pivot elegido (del 0 a la posicion del leftPointer - 1) (Ordena la izq del pivot)
       quickSort(array, lowIndex, leftPointer - 1);
       // Valores mayores al pivot elegido (Del left pointer hasta el final del arreglo) (Ordena la derecha del pivot)
       quickSort(array, leftPointer + 1, highIndex);

  }

    /*
        (Non-javaDoc)
        Metodo privado que utiliza el metodo quicSort para realizar el ordenamiento por 
        medio de particiones.
     */

  private static <T extends Comparable<? super T>> int partition(T[] array, int lowIndex, int highIndex, T pivot) {
       int leftPointer = lowIndex;
       int rightPointer = highIndex - 1;

       while (leftPointer < rightPointer) {

         // Incrementa leftPointer hasta encontrar un numero mayor que el pivot o tener el mismo valor que el right pointer.
         while (array[leftPointer].compareTo(pivot) < 0 && leftPointer < rightPointer){
         
           leftPointer++;
         }

         // Incrementa rightPointer hasta encontrar un numero mayor que el pivot o tener el mismo valor que el left pointer.
         while (array[leftPointer].compareTo(pivot) > 0 && leftPointer < rightPointer) {
           rightPointer--;
         }

         swap(array, leftPointer, rightPointer);
       }
       
      // En este punto leftPointer y rightPointer son lo mismo, se elige leftPointer por simplicidad para el resto de Op.
       if(array[leftPointer].compareTo(array[highIndex]) > 0){
         swap(array, leftPointer, highIndex);
       }
       else {
         leftPointer = highIndex;
       }
       
       return leftPointer;
  }

   /**
   * Ordena un arreglo, usando el orden natural de sus elementos utilizando Merge Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
       int inputLength = array.length;
       // Caso base para cortar la recursion (tenemos un unico nodo en este punto)
       if (inputLength < 2) {
         return;
       }
       
       int midIndex = inputLength / 2;
       T[] leftHalf =  (T []) new Comparable[midIndex];
       T[] rightHalf = (T []) new Comparable[inputLength - midIndex];
       
       for (int i = 0; i < midIndex; i++) {
         leftHalf[i] = array[i];
       }
       for (int i = midIndex; i < inputLength; i++) {
         rightHalf[i - midIndex] = array[i];
       }
       
       mergeSort(leftHalf);
       mergeSort(rightHalf);
       
       merge(array, leftHalf, rightHalf);
    }

   /* (non-Javadoc)
   * Este método agrupa de forma ordenada las dos mitades producidas por el mergeSort 
   */
   private static <T extends Comparable<? super T>> void merge(T[] array, T[] leftHalf, T[] rightHalf) {
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;
    
    int i = 0, j = 0, k = 0;
    
    while (i < leftSize && j < rightSize) {
      if (leftHalf[i].compareTo(rightHalf[j]) < 0) {
        array[k] = leftHalf[i];
        i++;
      }
      else {
        array[k] = rightHalf[j];
        j++;
      }
      k++;
    }
    
    while (i < leftSize) {
      array[k] = leftHalf[i];
      i++;
      k++;
    }
    
    while (j < rightSize) {
      array[k] = rightHalf[j];
      j++;
      k++;
    }
    
  }

   /**
   * Ordena un arreglo, usando el orden natural de sus elementos utilizando Radix Sort.
   * @param Integer el tipo de los elementos del arreglo
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   
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

   /* (non-Javadoc)
   * Este método retorna la cantidad de digitos de un numero
   */
   private static int countDigit(Integer num)
   {

     if (num == 0) return num ++ ; 
     return (int)(Math.log10(num)+1) ;  
   }

   /* (non-Javadoc)
   * Este método retorna el digito de un numero en la posicion indicada
   */
   private static int digitAt(Integer num, int i){
      int output;
      Integer a=10;
      output = (int) (num/Math.pow(a,i)) % a;
      return output;
   }

   /* (non-Javadoc)
   * Este método intercambia dos posiciones de un arreglo.
   */ 
   private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }


}
