package bloque5.examen;

import entrega2.tipos.Cola;
import java.util.List;
import java.util.stream.Collectors;

public class ColaComprasPendientes extends Cola<Compra> {

	public Compra buscarCompraPorDescripcion(String descripcion) {
		if (descripcion == null || descripcion.isEmpty()) {
			return null; 
		}
		for (Compra compra : this.elements()) { 
			if (compra.descripcion().equalsIgnoreCase(descripcion)) {
				return compra;
			}
		}
		return null; 
	}

    public List<Compra> filtrarPorClienteYProducto(Cliente cliente, String producto) {
        return this.elements().stream()
            .filter(compra -> compra.cliente().equals(cliente) && compra.descripcion().contains(producto))
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ColaComprasPendientes cola = new ColaComprasPendientes();

        Cliente cliente1 = new Cliente("Juan", 5);
        Cliente cliente2 = new Cliente("Ana", 6);

        Compra compra1 = new Compra(cliente1, "Compra de alimentos", 50.0);
        Compra compra2 = new Compra(cliente2, "Compra de electrónica", 100.0);
        Compra compra3 = new Compra(cliente1, "Compra de ropa", 30.0);
        Compra compra4 = new Compra(cliente2, "Compra de electrónica", 70.0);

        cola.add(compra1);
        cola.add(compra2);
        cola.add(compra3);
        cola.add(compra4);

        System.out.println("Resultado de buscarCompraPorDescripcion (existe):");
        Compra resultadoBusqueda = cola.buscarCompraPorDescripcion("Compra de electrónica");
        System.out.println(resultadoBusqueda); 
        
        System.out.println("\nResultado de buscarCompraPorDescripcion (no existe):");
        cola.buscarCompraPorDescripcion("Compra de juguetes"); 
        
        System.out.println("\nResultado de filtrarPorClienteYProducto:");
        List<Compra> resultadoFiltro = cola.filtrarPorClienteYProducto(cliente2, "electrónica");
        for (Compra compra : resultadoFiltro) {
            System.out.println(compra);
        }
    }
}
