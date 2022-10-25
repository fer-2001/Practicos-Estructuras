package arraySorter;

import java.util.Arrays;

/**
* Clase ejecutable para demostrar el uso de {@code ArraySorter}
* @see arraySorter.ArraySorter
* @see arraySorter.ArrayGenerator
*/
public class Main {

   public static void main(String[] args) {

      Integer[] arreglo1 = ArrayGenerator.generarArregloDeLongitud(0, 10, 10);
      System.out.println("Arreglo random, tamaño 10 y valores entre 0 y 100:\n" + Arrays.toString(arreglo1));
      ArraySorter.radixSort(arreglo1);
      System.out.println("Arreglo ordenado con mergeSort:\n" + Arrays.toString(arreglo1));

   }

   @SuppressWarnings("unchecked")
    private static <E> E[] crearArreglo(int elementos) {
        return (E[]) new Object[elementos];
    }

}
