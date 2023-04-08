package listaordinal;

import java.util.Stack;

public class Factura {
    private String dni;
    private String fecha;
    private ListaOrdinal listaProductos;
    private boolean cobrada;

    public Factura(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new ListaOrdinal();
        cobrada = false;
    }

    public String getDNI() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean estaCobrada() {
        return cobrada;
    }

    public void cobrada() {
        cobrada = true;
    }

    public void añadirProducto(Producto producto) { //bien
        if(listaProductos.contiene(producto)){
        Iterador it= listaProductos.getIterador();
        Producto elem= it.next();
        //busca el producto con equals
        while (!elem.equals(producto)){ //hasta que encuentre el producto
           elem= it.next();
        }
        //cuando lo encuentra, suma las cantidades y lo guarda en producto
        elem.setUnidades(producto.getUnidades()+elem.getUnidades());
        }else listaProductos.insertar(producto);
    }

    public void mostrar() { //bien
        System.out.println("FACTURA de: "+dni+"."+" Fecha: "+fecha);
        Iterador it= listaProductos.getIterador();
        if(!listaProductos.vacia()) {
            while (it.hasNext()) {
                Producto elem = it.next();
                elem.mostrar();
            }

        }else System.out.println("lista vacia");
        System.out.println("IMPORTE TOTAL: "+importeTotal());
    }

    public float importeTotal() { //funciona
        Iterador it= listaProductos.getIterador();
        float total=0;
        while(it.hasNext()){
            Producto elem = it.next();
            total=total+ (elem.getPrecio()* elem.getUnidades());
        }
        return total;
    }

    public int eliminarProducto(Producto producto) { //parece que funciona
        int cant=0;
        if(listaProductos.contiene(producto)){
        Iterador it= listaProductos.getIterador();
        Producto elem= it.next();
        while(!elem.equals(producto)){
            elem=it.next();
        }

        if(elem.getUnidades()<=producto.getUnidades()){
            cant= elem.getUnidades();
            listaProductos.borrar(producto);

        }else {
            elem.setUnidades(elem.getUnidades() - producto.getUnidades());
            cant= elem.getUnidades();
        }
      }
        return cant;
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        ListaOrdinal mayores = new ListaOrdinal();
        Iterador it = listaProductos.getIterador();
        while (it.hasNext()) {
            Producto elem = it.next();
            if (elem.getPrecio() > precio)
                mayores.insertar(elem);
        }
        return mayores;
    }
}
