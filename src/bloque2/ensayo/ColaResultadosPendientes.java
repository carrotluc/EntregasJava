package bloque2.ensayo;

import java.util.List;
import java.util.stream.Collectors;
import entrega2.tipos.Cola;

public class ColaResultadosPendientes extends Cola<Resultado> {

    public Resultado buscarResultadoPorEvento(String nombreEvento) {
        return this.stream()
                   .filter(resultado -> resultado.getEvento().equals(nombreEvento))
                   .findFirst()
                   .orElse(null); 
    }

    public List<Resultado> filtrarPorAtletaYEvento(Atleta atleta, String evento) {
        return this.stream()
                   .filter(resultado -> resultado.getAtleta().equals(atleta) && resultado.getEvento().equals(evento))
                   .collect(Collectors.toList());
    }
    
	public static void main(String[] args) {
		ColaResultadosPendientes cola = new ColaResultadosPendientes();
		Atleta atleta1 = new Atleta("Juan", 25);
		Atleta atleta2 = new Atleta("Maria", 30);
		cola.add(Resultado.of(atleta1, "100m", 9.58));
		cola.add(Resultado.of(atleta2, "200m", 19.19));
		cola.add(Resultado.of(atleta1, "400m", 43.03));

		System.out.println("Buscar resultado por evento '100m': " + cola.buscarResultadoPorEvento("100m"));
		System.out
				.println("Filtrar por atleta 'Juan' y evento '400m': " + cola.filtrarPorAtletaYEvento(atleta1, "400m"));
	}
}

