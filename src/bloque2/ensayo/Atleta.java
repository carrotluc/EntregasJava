package bloque2.ensayo;

import java.util.Objects;

public class Atleta {
	    private final String nombre;
	    private final int edad;

	    public Atleta(String nombre, int edad) {
	        this.nombre = nombre;
	        this.edad = edad;
	    }

	    public static Atleta of(String nombre, int edad) {
	        return new Atleta(nombre, edad);
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    @Override
	    public String toString() {
	        return "Atleta: " + nombre + ", " + edad;
	    }

	    @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Atleta other = (Atleta) obj;
			return edad == other.edad && Objects.equals(nombre, other.nombre);
		}

	    @Override
		public int hashCode() {
			return Objects.hash(edad, nombre);
		}
	    
		public static void main(String[] args) {
			Atleta atleta1 = new Atleta("Juan", 25);
			Atleta atleta2 = new Atleta("Maria", 30);
			System.out.println(atleta1);
			System.out.println(atleta2);
			System.out.println(atleta1.equals(atleta2));
			System.out.println(atleta1.equals(atleta1));
			System.out.println(atleta1 == atleta2);	
			System.out.println(atleta1.hashCode());
		}
}
