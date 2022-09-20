package colecciones.vectores;
public class Main {
    public static void main(String[] args){
        Vectores v1 = new Vectores(3);
        v1.definirElemento(2,0);
        v1.definirElemento(2,1);
        v1.definirElemento(3,2);
        Vectores v2 = new Vectores(3);
        v2.definirElemento(2,0);
        v2.definirElemento(2,1);
        v1.suma(v2);
        v1.multEscalar(1);
        int res = v1.productoPunto(v1);
        System.out.println(v1);
        System.out.println("Resultado de producto punto: " + res);

    }
}
