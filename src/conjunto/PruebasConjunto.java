package conjunto;

public class PruebasConjunto {

    public static void main(String[] args) {

       Conjunto test = new Conjunto();
       test.insertar(4);
       test.insertar(6);
       test.insertar(2);
       test.insertar(4);
       test.insertar(-2);
       test.mostrar();
       int array[]= test.toArray();
        System.out.print("El array contiene: ");
       for(int i=0;i<array.length;i++){
           System.out.print(array[i]+"  ");
       }
    }

}
