package bloque2.ensayo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import bloque2.ensayo.Resultado;


public class EstadisticasAtletas { 

    // Versión Imperativa
    public static Map<String, List<Resultado>> agruparResultadosPorEventoImperativo(List<Resultado> resultados) {
        Map<String, List<Resultado>> resultadosPorEvento = new java.util.HashMap<>();
        
        for (Resultado resultado : resultados) {
            String evento = resultado.getEvento();
            if (!resultadosPorEvento.containsKey(evento)) {
                resultadosPorEvento.put(evento, new java.util.ArrayList<>());
            }
            resultadosPorEvento.get(evento).add(resultado);
        }
        
        return resultadosPorEvento;
    }

    // Versión Funcional
    public static Map<String, List<Resultado>> agruparResultadosPorEventoFuncional(List<Resultado> resultados) {
        return resultados.stream()
                         .collect(Collectors.groupingBy(Resultado::getEvento));
    }
    
	public static void main(String[] args) {
		Atleta atleta1 = new Atleta("Juan", 25);
		Atleta atleta2 = new Atleta("Maria", 22);
		List<Resultado> resultados = List.of(
				new Resultado(atleta1, "100m", 9.58),
				new Resultado(atleta1, "200m", 19.19),
				new Resultado(atleta2, "100m", 10.00)
				);

		Map<String, List<Resultado>> resultadosImperativo = agruparResultadosPorEventoImperativo(resultados);
		Map<String, List<Resultado>> resultadosFuncional = agruparResultadosPorEventoFuncional(resultados);

		System.out.println("Resultados Imperativos: " + resultadosImperativo);
		System.out.println("Resultados Funcionales: " + resultadosFuncional);
	}
}
