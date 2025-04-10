package bloque5.examen;

public record Compra(Cliente cliente, String descripcion, double importe) {

    public static Compra of(Cliente cliente, String descripcion, double importe) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía.");
        }
        if (importe < 0) {
            throw new IllegalArgumentException("El importe no puede ser negativo.");
        }
        return new Compra(cliente, descripcion, importe);
    }

    @Override
    public String toString() {
        return "Compra [Nombre de cliente= " + cliente.nombre() +
               ", descripción= " + descripcion +
               ", importe= " + String.format("%.2f", importe) + " €]";
    }

	public static void main(String[] args) {
		Cliente cliente1 = Cliente.of("Juan", 5);
		Compra compra1 = Compra.of(cliente1, "Compra de alimentos", 50.0);
		System.out.println(compra1);
		
		Compra compra2 = Compra.of(cliente1, "Compra de ropa", 30.0);
		System.out.println(compra2);
		Compra compra3 = Compra.of(cliente1, "Compra de electrónica", 100.0);
		System.out.println(compra3);

		// Test con valores inválidos
		// Compra compra2 = Compra.of(null, "Compra de ropa", 30.0);
		// Compra compra3 = Compra.of(cliente1, "", 30.0);
		// Compra compra4 = Compra.of(cliente1, "Compra de electrónica", -10.0);
		
	}
}
