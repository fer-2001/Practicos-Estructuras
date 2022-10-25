package arraySorter;
import java.util.Random;
import java.io.*;
import java.util.*;
/**
* Provee métodos para ordenar arreglos de objetos comparables.
* Los algoritmos de ordenamiento provistos por esta clase son:
* <ul>
* <li>Bubble sort.</li>
* <li>Selection sort.</li>
* <li>Shell sort.</li>
* <li>Quick sort.</li>
* <li>Merge sort.</li>
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
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Quick Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static void quickSort(Integer[] array) {
      if (array == null) throw new IllegalArgumentException("array is null, can't sort");
         quickSort(array, 0, array.length - 1);
   }

    /**
     *
     * @param array
     * @param lowIndex
     * @param highIndex
     */
  private static void quickSort(Integer[] array, int lowIndex, int highIndex) {
       if (lowIndex >= highIndex) {
         return;
       }
      // Genera una posicion aleatoria para el pivot
       int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
       Integer pivot = array[pivotIndex];
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

  private static int partition(Integer[] array, int lowIndex, int highIndex, Integer pivot) {
       int leftPointer = lowIndex;
       int rightPointer = highIndex - 1;

       while (leftPointer < rightPointer) {

         // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
         while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
           leftPointer++;
         }

         // Walk from the right until we find a number less than the pivot, or hit the left pointer.
         while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
           rightPointer--;
         }

         swap(array, leftPointer, rightPointer);
       }
       
      // En este punto leftPointer y rightPointer son lo mismo, se elige leftPointer por simplicidad para el resto de Op.
       if(array[leftPointer] > array[highIndex]) {
         swap(array, leftPointer, highIndex);
       }
       else {
         leftPointer = highIndex;
       }
       
       return leftPointer;
  }


   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Shell Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void shellSort(T[] array) {
      throw new UnsupportedOperationException("TODO: implementar");    
   }


   /**
   * Ordena un arreglo, usando el orden natural de sus elementos utilizando Merge Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
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

/*
    Metodo privado para realizar el ordenamiento por el metodo merge.
    Toma el arreglo de entrada, y dos arreglos "mitades" para realizar la recursividad.
    En el metodo publico solo se provee el arreglo de entrada.

*/

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

    /**
     * Ordena un arreglo contabilizando la cantidad de apariciones de un digito
      * @param array: Arreglo a ordenar
     * @param n: Largo del arreglo a ordenar
     * @param exp: Exponente en base 10
     */
public static void countingSort(Integer array[], int n, int exp)
    {
        Integer salida[] = new Integer[n]; // output array
        int i;
        Integer count[] = new Integer[10];
        Arrays.fill(count, 0);
 
        // Cuenta la cantidad de ocurrencias de cada numero
        for (i = 0; i < n; i++){
            count[(array[i] / exp) % 10]++;
            // (array[i] / exp) % 10 = Segun el numero, nos da la posicion a incrementar 
            // Ejemplo: Si array[i] = 7
            // 7/1  (Se divide por 1 porque es la primera pasada del ciclo)
            // 7 % 10 es 7
            // Entonces count[7] se incrementa en 1
        }
        System.out.println("Count:" + Arrays.toString(count));
 
        // Organiza el arreglo count para determinar la posicion final 
        // de los digitos
        for (i = 1; i < 10; i++)
            count[i] = count[i] + count[i - 1];
        // Puede verse como una sumatoria
 
        System.out.println("Count ordenado:" + Arrays.toString(count));

        // Construye en salida el arreglo que retorna el metodo
        for (i = n - 1; i >= 0; i--) {
            salida[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copia los valores del arreglo de salida al arreglo del parametro.
        for (i = 0; i < n; i++)
            array[i] = salida[i];
    }

    /**
     * Ordena un arreglo por el metodo radix. Por cada digito, realiza un ordenamiento hasta llegar
     * al numero maximo de digitos.
     * @param entrada arreglo que se desea ordenar
     * @return: el arreglo "entrada" en forma ordenada
     */
  public static Integer[] radixSort(Integer[] entrada){
    int max = indexOfLargest(entrada, entrada.length);
    max = entrada[max]; 
    for (int exp = 1; max / exp > 0; exp *= 10){
            countingSort(entrada, entrada.length, exp);
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

  private static void swap(Integer[] array, int index1, int index2) {
    Integer temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}