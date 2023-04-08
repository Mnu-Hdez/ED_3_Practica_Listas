package listaordinal;

import java.util.Iterator;
import java.util.LinkedList;

public class PruebasLista {
    public static void main(String[] args) {
        // Introducir aquí las pruebas pedidas en la práctica
        Producto mesaesc = new Producto("Mesa escritorio",185,2);
        Producto sillaof = new Producto("Silla oficina",(float)95.9,3);
        Producto mesaco = new Producto("Mesa cocina",125,1);
        Producto sillonrec = new Producto("Sillón reclinable",230,2);
        ListaOrdinal lista = new ListaOrdinal();
        lista.insertar(mesaesc);
        lista.insertar(sillaof);
        lista.insertar(mesaco);
        lista.insertar(sillonrec);
        lista.mostrar();
        lista.borrar(sillaof);
        System.out.println("Despues de eliminar las sillas de oficina:");
        lista.mostrar();
        Factura factura= new Factura("12345678B","17/03/2021");
        factura.añadirProducto(mesaesc);
        factura.añadirProducto(sillaof);
        factura.añadirProducto(mesaco);
        factura.añadirProducto(sillonrec);
        Producto silla1 = new Producto("Silla oficina",(float)95.9,1);
        factura.añadirProducto(silla1);
        factura.mostrar();
        Producto sillaofrest = new Producto("Silla oficina",(float)95.9,2);
        Producto sillnrest = new Producto("Sillón reclinable",230,3);
        int eliminados=0;
        eliminados += factura.eliminarProducto(sillaofrest);
        eliminados += factura.eliminarProducto(sillnrest);
        System.out.println();
        System.out.println("Se han eliminado "+ eliminados+" unidades");
        factura.mostrar();
        System.out.println();
        ListaOrdinal mayores= factura.mayoresPrecios(100);
        System.out.println("Se han obtenido "+mayores.getNumElementos()+" productos con precio mayor a 100 € por unidad");
        mayores.mostrar();
        System.out.println();
        FacturaBib facturabib = new FacturaBib("88888888A","08/08/2008");
        Producto arm1 = new Producto("Armario",385,5);
        Producto cam1=new Producto("Cama",255,3);
        Producto cam2=new Producto("Cama",255,2);
        Producto arm2=new Producto("Armario",385,1);
        facturabib.añadirProducto(arm1);
        facturabib.añadirProducto(cam1);
        facturabib.añadirProducto(cam2);
        facturabib.eliminarProducto(arm2);
        facturabib.mostrar();

        LinkedList<Producto> listita =facturabib.mayoresPrecios(250);
        System.out.println();
        System.out.println("Se han obtenido: "+ listita.size()+" productos con precio mayor a 250 € por unidad.");
        Iterator<Producto> it=listita.iterator();
        while (it.hasNext()){
            Producto elem=it.next();
            elem.mostrar();

        }
    }


}
