package arraySorter;
import java.util.Random;
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
   public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
      throw new UnsupportedOperationException("TODO: implementar");    
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
