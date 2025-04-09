package bloque2.ensayo;

import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Atleta carlos = Atleta.of("Carlos", 28);
        Atleta maria = Atleta.of("María", 24);
        Atleta elena = Atleta.of("Elena", 31);

        Resultado r1 = Resultado.of(carlos, "Maratón 10K", 45.32);
        Resultado r2 = Resultado.of(maria, "Triatlón Sprint", 72.15);
        Resultado r3 = Resultado.of(carlos, "Media Maratón", 95.45);
        Resultado r4 = Resultado.of(elena, "Maratón 10K", 42.18);

        List<Resultado> resultados = List.of(r1, r2, r3, r4);

        Map<String, List<Resultado>> agrupadosImperativo = EstadisticasAtletas.agruparResultadosPorEventoImperativo(resultados);

        Map<String, List<Resultado>> agrupadosFuncional = EstadisticasAtletas.agruparResultadosPorEventoFuncional(resultados);

        System.out.println("Agrupados (Imperativo):");
        agrupadosImperativo.forEach((evento, lista) -> {
            System.out.println("Evento: " + evento);
            lista.forEach(resultado -> System.out.println("  - " + resultado));
        });

        System.out.println("\nAgrupados (Funcional):");
        agrupadosFuncional.forEach((evento, lista) -> {
            System.out.println("Evento: " + evento);
            lista.forEach(resultado -> System.out.println("  - " + resultado));
        });
    }
}
