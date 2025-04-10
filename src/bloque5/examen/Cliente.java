package bloque5.examen;

import java.util.Objects;

public record Cliente(String nombre, int antigüedad) {

    public static Cliente of(String nombre, int antigüedad) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        if (antigüedad < 0) {
            throw new IllegalArgumentException("La antigüedad no puede ser negativa.");
        }
        return new Cliente(nombre, antigüedad);
    }

    @Override
    public String toString() {
        return "Cliente[nombre=" + nombre + ", antigüedad=" + antigüedad + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente other)) return false;
        return this.nombre.equals(other.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    
	public static void main(String[] args) {
		Cliente cliente1 = Cliente.of("Juan", 5);
		Cliente cliente2 = Cliente.of("Ana", 3);
		//Cliente cliente3 = Cliente.of("", 10);
		//Cliente cliente4 = Cliente.of("Juan", -1);

		System.out.println(cliente1);
		System.out.println(cliente2);
		//System.out.println(cliente3);
		//System.out.println(cliente4);

		System.out.println(cliente1.equals(cliente2));
		System.out.println(cliente1.equals(Cliente.of("Juan", 10)));
		System.out.println(cliente1.hashCode() == Cliente.of("Juan", 10).hashCode());
		
	}
}

