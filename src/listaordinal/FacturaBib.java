package listaordinal;
import java.util.Iterator;
import java.util.LinkedList;
//revisar los metodos mostrar!!muy importante!!
public class FacturaBib {
    private String dni;
    private String fecha;
    private LinkedList<Producto> listaProductos;
    private boolean cobrada;

    public FacturaBib(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new  LinkedList<Producto>();
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

    public void añadirProducto(Producto producto) { //bien modificado(probar)
        if(listaProductos.contains(producto)){
        Iterator<Producto> it= listaProductos.iterator();
        Producto elem= it.next();
        //busca el producto con equals
        while (!elem.equals(producto)){ //hasta que encuentre el producto
           elem= it.next();
        }
        //cuando lo encuentra, suma las cantidades y lo guarda en producto
        elem.setUnidades(producto.getUnidades()+elem.getUnidades());
        }else listaProductos.add(producto);
    }

    public void mostrar() { //modificar para respaldar linkedlist
        System.out.println("FACTURA de: "+dni+"."+" Fecha: "+fecha);
        Iterator<Producto> it= listaProductos.iterator();
        if(!listaProductos.isEmpty()) {
            while (it.hasNext()) {
                Producto elem = it.next();
                elem.mostrar();
            }

        }else System.out.println("lista vacia");
        System.out.println("IMPORTE TOTAL: "+importeTotal());
    }

    public float importeTotal() { //funciona
        Iterator<Producto> it= listaProductos.iterator();
        float total=0;
        while(it.hasNext()){
            Producto elem = it.next();
            total=total+ (elem.getPrecio()* elem.getUnidades());
        }
        return total;
    }

    public int eliminarProducto(Producto producto) { //parece que funciona
        int cant=0;
        if(listaProductos.contains(producto)){
        Iterator<Producto> it= listaProductos.iterator();
        Producto elem= it.next();
        while(!elem.equals(producto)){
            elem=it.next();
        }

        if(elem.getUnidades()<=producto.getUnidades()){
            cant= elem.getUnidades();
            listaProductos.remove(producto);

        }else {
            elem.setUnidades(elem.getUnidades() - producto.getUnidades());
            cant= elem.getUnidades();
        }
      }
        return cant;
    }

    public LinkedList<Producto> mayoresPrecios(float precio) {
        LinkedList<Producto> mayores = new LinkedList<Producto>();//parece que habría que modificarlo
        Iterator<Producto> it = listaProductos.iterator();
        while (it.hasNext()) {
            Producto elem = it.next();
            if (elem.getPrecio() > precio)
                mayores.add(elem);
        }
        return mayores;
    }
}
