package bloque5.examen;

import entrega2.tipos.Pila;
import java.util.List;
import java.util.stream.Collectors;

public class HistorialCompras extends Pila<Compra> {

	    public double totalGastadoPor(Cliente cliente) {
	        return this.elements().stream()
	            .filter(compra -> compra.cliente().equals(cliente))
	            .mapToDouble(Compra::importe)
	            .sum();
	    }

	    public List<Compra> comprasMayoresA(double cantidad) {
	        return this.elements().stream()
	            .filter(compra -> compra.importe() > cantidad)
	            .collect(Collectors.toList());
	    }
	    
		public static void main(String[] args) {
			HistorialCompras historial = new HistorialCompras();
			Cliente cliente1 = Cliente.of("Juan", 5);
			Cliente cliente2 = Cliente.of("Ana", 3);

			Compra compra1 = Compra.of(cliente1, "Compra de alimentos", 50.0);
			Compra compra2 = Compra.of(cliente1, "Compra de ropa", 30.0);
			Compra compra3 = Compra.of(cliente2, "Compra de electrónica", 100.0);

			historial.add(compra1);
			historial.add(compra2);
			historial.add(compra3);

			System.out.println("Total gastado por Juan: " + historial.totalGastadoPor(cliente1));
			System.out.println("Compras mayores a 40: " + historial.comprasMayoresA(40));
			System.out.println("Compras mayores a 30: " + historial.comprasMayoresA(30));
			System.out.println("Compras mayores a 100: " + historial.comprasMayoresA(100));
			System.out.println("Compras mayores a 0: " + historial.comprasMayoresA(0));

			Compra ultimaCompra = historial.elements().get(historial.elements().size() - 1);
			System.out.println("Última compra realizada: " + ultimaCompra);
			
		}
	}

