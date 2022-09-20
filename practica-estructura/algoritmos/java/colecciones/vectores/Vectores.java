package colecciones.vectores;
public class Vectores implements Vector {
    private int[] arreglo;
    private int elementos;

    public Vectores(int tamanio) {
        arreglo = new int[tamanio];
        elementos = 0;
    }


    private int getElemento(int indice){
        return arreglo[indice];
    }

    public void definirElemento(int valor, int posicion){
        arreglo[posicion] = valor;
        elementos++;
    }

    @Override
    public void suma(Vectores v1) {
        if(!(this.aridadCompatible(v1))){
            throw new ArrayIndexOutOfBoundsException("Vectores de diferente dimension");
        }
        else{
            for(int i = 0; i < elementos; i++){
                arreglo[i] = arreglo[i] + v1.getElemento(i);
            }
        }
    }

    @Override
    public void multEscalar(int n) {
        if(elementos == 0){
            throw new ArrayIndexOutOfBoundsException("Vector nulo");
        }
        for(int i = 0; i < elementos; i++){
            arreglo[i] = arreglo[i] * n;
        }
    }

    @Override
    public int productoPunto(Vectores v1) {
        int resultado = 0;
        if(!(this.aridadCompatible(v1))){
            throw new ArrayIndexOutOfBoundsException("Vectores de diferente dimension");
        }
        else{
            for(int i = 0; i < elementos; i++){
                int aux;
                aux = arreglo[i] * v1.getElemento(i);
                resultado = resultado + aux;
            }
        }
        return resultado;
    }


    public String toString(){
        String resultado = "";
        for(int i = 0; i < elementos; i++){
            if (i == elementos-1){
                resultado = resultado + arreglo[i];
            }
            else{
                resultado = resultado + arreglo[i] + ",";
            }
        }
        resultado = "(" + resultado + ")";
        return resultado;
    }

    @Override
    public boolean equals(Object otro){
        return true;
    }

    private boolean aridadCompatible(Vectores v1){
        return elementos == v1.elementos;
    }
}
