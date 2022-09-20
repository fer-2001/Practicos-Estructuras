package main;
import racional.Racionales;

public class Main {

    public static void main(String[] args){
        Racionales r1 = new Racionales(1,5);
        Racionales r2 = new Racionales( 1,2);
        System.out.println(r1.equals(r2));
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1.sumaRacionales(r2));
        Racionales aux = r2.restaRacionales(r1);
        System.out.println(aux);
    }


}
