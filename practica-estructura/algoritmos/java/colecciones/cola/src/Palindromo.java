package colecciones.cola;

public class Palindromo {

    public static void main(String[] args){
        String entrada = args[0];
        ColaArregloFijo<Character> cola = new ColaArregloFijo(20);
        int lim = entrada.length();
        for(int i = 0; i < lim; i++){
            cola.encolar(entrada.charAt(i));
        }

        ColaArregloFijo<Character> nuevaCola = new ColaArregloFijo(20);
        for(int j = lim-1; j>-1; j--){
            nuevaCola.encolar(entrada.charAt(j));
        }
        
        System.out.println("Cola dada vuelva: " + nuevaCola);
        System.out.println("Cola original: " + cola);

        if(nuevaCola.equals(cola)){
            System.out.println("Es palindromo");
        }
        else{
            System.out.println("NO es palindromo");

        }

    }
}
