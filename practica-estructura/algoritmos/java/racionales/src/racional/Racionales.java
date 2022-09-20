package racional;
public class Racionales{
    // Variable denominador
    private long num;
    // Variable denominador
    private long den;

    /**
     * Constructor para la clase Racionales
     * @param num Representa al numerador del numero racional
     * @param den Representa al denominador del numero racional
     */

    public Racionales(long num, long den){
        this.num = num;
        this.den = den;
    }

    /**
     * Metodo para realizar suma de numeros racionales
     * @param r1 : Representa otro numero racional a sumar
     * @return Un numero racional
     */

    public Racionales sumaRacionales(Racionales r1){
        long aux1;
        long aux2;
        aux1 = (num * r1.getDen()) + (r1.getNum() * den);
        aux2 = den *r1.getDen();
        simplificar();
        Racionales resultado = new Racionales(aux1,aux2);
        return resultado;
    }

    /**
     * Metodo para realizar resta de numeros racionales
     * @param r1 : Representa otro numero racional a restar
     * @return Un numero racional
     */

    public Racionales restaRacionales(Racionales r1){
        long aux1;
        long aux2;
        aux1 = (num * r1.getDen()) - (r1.getNum() * den);
        aux2 = den *r1.getDen();
        simplificar();
        Racionales resultado = new Racionales(aux1,aux2);
        return resultado;
    }


    /**
     * Metodo privado para calcular el maximo comun divisor de un Racional
     * @return el maximo comun divisor de un racional
     */
    private long mcd() {
        long u = Math.abs(num); //valor absoluto del numerador
        long v = Math.abs(den); //valor absoluto del denominador
        if (v == 0) {
            return u;
        }
        long r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }

    /**
     * Metodo privado para simplificar los resultados de la fraccion. Utiliza otro metodo privado (mcm)
     */
    private void simplificar() {
        long n = mcd(); //se calcula el mcd de la fracción
        num = num / n;
        den = den / n;
    }

    /**
     * Metodo auxiliar para obtener el numerador de un numero racional
     * @return el valor del numerador
     */

    private long getNum(){
        return num;
    }

    /**
     * Metodo auxiliar para obtener el denominador de un numero racional
     * @return el valor del denominador
     */

    private long getDen(){
        return den;
    }

    /**
     * Funcion equals para identificar numeros racionales iguales
     * @param otro Objeto a comparar
     * @return : True en caso de que sea el mismo numero, false caso contrario
     */
    @Override
    public boolean equals(Object otro){
        if(otro == null){
            return  false;
        }
        if(otro == this){
            return true;
        }
        if(!(otro instanceof Racionales)){
            return false;
        }
        Racionales unRacional = (Racionales) otro;
        if(unRacional.getDen() != this.den){
            return false;
        }
        if(unRacional.getNum() != this.num){
            return false;
        }
        else{
            return true;
        }

    }

    /**
     * Metodo para imprimir por pantalla un numero racional
     * @return Representacion fraccionaria de un numero racional.
     */

    @Override
    public String toString(){
        if(num == 0){
            return "0";
        }
        if(num < 0 && den <0){
            return (num*-1) + "/" + (den *-1);
        }
        if(num < 0 && den >0){
            return "-" + (num*-1) + "/" + (den);
        }
        if(num > 0 && den <0){
            return "-" + (num) + "/" + (den *-1);
        }
        if(num > 0 && den == 1){
            return (num) + "";
        }
        if(num < 0 && den == 1){
            return "-" + (num);
        }
        return num + "/" + den;
    }

}

