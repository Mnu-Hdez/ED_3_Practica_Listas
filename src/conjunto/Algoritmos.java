package conjunto;

public class Algoritmos {
    public Conjunto interseccion(Conjunto conjunto1, Conjunto conjunto2){
        Conjunto inter = new Conjunto();
        if(!conjunto1.vacio()&&!conjunto2.vacio()){
         int[] array = conjunto1.toArray();
         for(int i=0;i<conjunto1.getNumElementos();i++){
             int elem= array[i];
             if(conjunto2.contiene(elem)){
                 inter.insertar(elem);
             }
         }
        }
        return inter;
    }


}
