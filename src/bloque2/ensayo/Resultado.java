package bloque2.ensayo;

import java.util.Objects;

public class Resultado {
	    private final Atleta atleta;
	    private final String evento;
	    private final double marca;

	    public Resultado(Atleta atleta, String evento, double marca) {
	        this.atleta = atleta;
	        this.evento = evento;
	        this.marca = marca;
	    }
	    
	    public static Resultado of(Atleta atleta, String evento, double marca) {
	        return new Resultado(atleta, evento, marca);
	    }

	    public Atleta getAtleta() {
	        return atleta;
	    }

	    public String getEvento() {
	        return evento;
	    }

	    public double getMarca() {
	        return marca;
	    }

	    @Override
	    public String toString() {
	        return "Resultado: El atleta " + atleta.getNombre() + ", ha hecho " + evento + ", con una marca de " + marca;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Resultado resultado = (Resultado) o;
	        return Double.compare(resultado.marca, marca) == 0 && atleta.equals(resultado.atleta) && evento.equals(resultado.evento);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(atleta, evento, marca);
	    }

		public static void main(String[] args) {
			Atleta atleta = new Atleta("Juan", 25);
			Resultado resultado = new Resultado(atleta, "100m", 9.58);
			System.out.println(resultado);
			System.out.println(resultado.getAtleta());
			System.out.println(resultado.getEvento());
			System.out.println(resultado.getMarca());
		}
}
