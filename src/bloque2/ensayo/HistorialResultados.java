package bloque2.ensayo;

import entrega2.tipos.Pila;
//import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

public class HistorialResultados extends Pila<Resultado> {

	    public double mejorMarcaDe(Atleta atleta) {
	        return this.stream()
	                   .filter(resultado -> resultado.getAtleta().equals(atleta))
	                   .mapToDouble(Resultado::getMarca)
	                   .min()
	                   .orElse(Double.MAX_VALUE); 
	    }

	    public List<Resultado> resultadosMejoresQue(double marca) {
	        return this.stream()
	                   .filter(resultado -> resultado.getMarca() < marca)
	                   .collect(Collectors.toList());
	    }
	    
		public static void main(String[] args) {
			HistorialResultados historial = new HistorialResultados();
			Atleta atleta1 = new Atleta("Juan", 25);
			Atleta atleta2 = new Atleta("Maria", 30);
			historial.add(Resultado.of(atleta1, "100m", 9.58));
			historial.add(Resultado.of(atleta2, "200m", 19.19));
			historial.add(Resultado.of(atleta1, "400m", 43.03));
			System.out.println("Mejor marca de Juan: " + historial.mejorMarcaDe(atleta1));
			System.out.println("Resultados mejores que 10: " + historial.resultadosMejoresQue(10));
			System.out.println("Resultados mejores que 20: " + historial.resultadosMejoresQue(20));
			System.out.println("Resultados mejores que 30: " + historial.resultadosMejoresQue(30));
			System.out.println("Resultados mejores que 40: " + historial.resultadosMejoresQue(40));
		}
	}
