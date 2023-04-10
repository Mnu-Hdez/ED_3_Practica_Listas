package conjunto;

public class Conjunto {

    private Nodo inicio;
    private int numElementos;

    public Conjunto() {
        inicio = null;
        numElementos = 0;
    }

    public boolean vacio() {
        return inicio == null;
    }

    /**
     * Inserta el dato en la posición que le corresponde
     */
    public boolean insertar(int dato) {
        if (dato >= 0) {
            Nodo anterior = null;
            Nodo actual = inicio;
            while ((actual != null) && (actual.getDato() < dato)) {  // Buscar posición de inserción
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if ((actual == null) || (actual.getDato() > dato)) {  // Insertar antes de actual
                Nodo nuevo = new Nodo(dato, actual);
                if (actual == inicio) {  // insertar al principio de la lista
                    inicio = nuevo;
                } else {
                    anterior.setSiguiente(nuevo);
                }
                numElementos++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * Determina si la clave recibida como parámetro existe en la lista.
     */
    public boolean contiene(int dato) {
        Nodo actual = inicio;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            actual = actual.getSiguiente();
        }
        return (actual != null) && (actual.getDato() == dato);
    }

    /**
     * Elimina de la lista el alumno con número de matrícula clave,
     * en caso de existir.
     */
    public boolean borrar(int dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getDato() > dato)) {  // No existe clave
            return false;
        } else {  // Clave encontrada
            if (actual == inicio) {    // eliminar el primero de la lista
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            numElementos--;
            return true;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void mostrar() {
        if (this.vacio()) {
            System.out.println ("Conjunto vacío");
        } else {
            System.out.print("[ " + inicio.getDato());
            Nodo actual = inicio.getSiguiente();
            while (actual != null) {
                System.out.print(", " + actual.getDato());
                actual = actual.getSiguiente();
            }
            System.out.println(" ]");
        }
    }



    public int[] toArray() {
           int[] enteros = new int[numElementos];
        if(numElementos>0) {
            int p = 0;
            Nodo actual = inicio;

            while (actual != null) {
                enteros[p] = actual.getDato();
                actual = actual.getSiguiente();
                p++;
            }
        }
        return enteros;   // Línea puesta para evitar error. Eliminarla al codificar el método
    }


    public int mayor() {
        int mayor = -1;
        if(numElementos>0){
            Nodo actual = inicio;
            while (actual!=null){
            if (actual.getDato()>mayor){mayor= actual.getDato();}
            actual=actual.getSiguiente();
            }
        }
        return mayor;
    }

    public Conjunto subconjunto(int inferior, int superior) {
        Conjunto sub = new Conjunto();
        Nodo actual=inicio;
        if(inferior>superior){
            int aux;
            aux=superior;
            superior=inferior;
            inferior= aux;
        }
        while(actual!=null && actual.getDato()<=superior){
            if(actual.getDato()>=inferior){
                int elem= actual.getDato();
                sub.insertar(elem);
            }
            actual=actual.getSiguiente();
        }
        return sub;
    }

    public boolean equals(Conjunto conjunto) {
       boolean flag = true;
       if(this.numElementos!=conjunto.numElementos){
           flag=false;
       }else{
           Nodo act1= this.inicio;
           Nodo act2= conjunto.inicio;
           while(act1!=null && act2!=null && flag){
               if(act1.getDato()!=act2.getDato()){  flag=false; }
               act1=act1.getSiguiente();
               act2=act2.getSiguiente();

           }
       }
        return flag;
    }


}
