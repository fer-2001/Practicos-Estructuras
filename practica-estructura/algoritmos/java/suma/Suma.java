package suma;


public class Suma{
	public static void main(String args[]){

		long inicio = System.nanoTime();
        suma2(15000);
        long fin = System.nanoTime();             
        System.out.println((fin - inicio) + " ms");
	}
	
	public static int suma (int n) {
		if (n == 0) return 0 ;
		return (n + suma (n - 1) ) ;
	}


	public static int suma1 (int n) {
		return (n * (n + 1) / 2) ;
	}


	public static int suma2 (int n) 
	{
		if (n == 0) return 0 ;
		return suma (n) + suma2 (n-1);
	}
}





