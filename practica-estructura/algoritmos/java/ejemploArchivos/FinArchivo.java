package ejemploArchivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import colecciones.pila.PilaArreglo;
import colecciones.pila.Pila;

//TODO: importar toda clase que crea necesaria

/**
* La clase {@code FinArchivo} implementa una aplicación simple para imprimir las últimas {@code n} líneas de un archivo.
* Esta clase usa parámetros que representan respectivamente el archivo y la cantidad de líneas a imprimir.
* @version 1.0
*/
public class FinArchivo {


	private static final String AYUDA = "--ayuda";

	/**
	* Dados un archivo existente y un entero positivo {@code n} &ge; {@code 0}, imprime por salida estándar las últimas {@code n} líneas.
	* Ejemplos de uso
	* Dado un archivo {@code lineas.txt} con el siguiente contenido
	* <pre>
	*	linea1
	*	linea2
	*	linea3
	* </pre>
	* <ul>
	* 	<li>Al ejecutar <pre>java FinArchivo lineas.txt 4</pre>, se debe imprimir el archivo completo.</li>
	* 	<li>Al ejecutar <pre>java FinArchivo lineas.txt 2</pre>, se debe imprimir
	*		<pre>
	*			linea2
	*			linea3
	*		</pre>.
	*	</li>
	* 	<li>Al ejecutar <pre>java FinArchivo lineas.txt 0</pre>, no se debe imprimir nada</li>
	* </ul>
	* @param args los argumentos conteniendo el archivo y un entero definiendo las últimas {@code n} líneas a imprimir.
	*/
	public static void main(String[] args) {
			if (args.length == 0) {
				System.err.println("Se espera al menos un argumento");
				mostrarUso();
				System.exit(1);
			}
			if (args.length == 1 && args[0].compareToIgnoreCase(AYUDA) == 0) {
				mostrarUso();
				System.exit(0);
			}
			if (args.length == 2) {
				Path rutaAlArchivo = Paths.get(args[0]);
				if (!rutaAlArchivo.toFile().exists()) {
					System.err.println("El archivo " + rutaAlArchivo.toString() + " no existe");
					System.exit(2);
				}
				if (!rutaAlArchivo.toFile().isFile()) {
					System.err.println("La ruta " + rutaAlArchivo.toString() + " no representa un archivo");
					System.exit(2);
				}
				if (!rutaAlArchivo.toFile().canRead()) {
					System.err.println("No se tienen permisos de lectura para el archivo " + rutaAlArchivo.toString());
					System.exit(2);
				}
				Integer n = null;
				try {
					n = Integer.parseInt(args[1]);
				} catch (NumberFormatException nfe) {
					System.err.println("Formato incorrecto para el argumento n (" + args[1] + "), se espera un entero");
					System.exit(2);
				}
				mostrarUltimasNLineas(rutaAlArchivo, n);
			} else {
				System.err.println("Uso incorrecto, se esperan 2 argumentos, se encontraron (" + args.length + ")");
				mostrarUso();
				System.exit(3);
			}
	}
	
	private static void mostrarUltimasNLineas(Path rutaAlArchivo, Integer n) {
		//TODO: agregar cualquier estructura que crea necesaria
		Pila pila = new <String>PilaArreglo(500);
		try {
			for (String linea : Files.readAllLines(rutaAlArchivo)){
				//System.out.println(linea);
			}
			File file = new File(String.valueOf(rutaAlArchivo));
			System.out.println("Ultimas " + n + " lineas ingresadas:");
			String linea2;
			BufferedReader br;
			br = new BufferedReader(new FileReader(file));
			while((linea2 = br.readLine()) != null){
				pila.apilar(linea2);
			}
			int i = 0;
			String res = "";
			while(i<n){
				res = res + pila.desapilar() + "\n";
				i++;
			}
			System.out.println(res);

		} catch (IOException ioe) {
			System.err.println("Ocurrió un problema durante la lectura del archivo");
			ioe.printStackTrace(System.err);
			System.exit(2);
		}
		//TODO: imprimir las últimas n líneas
	}
	
	private static void mostrarUso() {
		String uso = 	"FinArchivo\n" +
				"Muestra las últimas n líneas de un archivo.\n" +
				"Uso:\n" +
				"java FinArchivo --ayuda					:	muestra este mensaje.\n" +
				"java FinArchivo <ruta a un archivo> <entero mayor a 0>	:	imprime las últimas n de un archivo.\n"
		;
		System.out.println(uso);
	}

}
