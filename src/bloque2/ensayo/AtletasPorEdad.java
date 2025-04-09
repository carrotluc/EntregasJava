package bloque2.ensayo;

import java.util.List;
import java.util.stream.Collectors;
//import java.util.stream.Stream;
import java.util.Comparator;
//import java.util.ArrayList;
import entrega2.tipos.ListaOrdenada;

public class AtletasPorEdad extends ListaOrdenada<Atleta> { 
    
    public AtletasPorEdad() {
        super((a1, a2) -> Integer.compare(a1.getEdad(), a2.getEdad())); 
    }

    public List<Atleta> atletasEnRango(int edadMin, int edadMax) {
        return this.stream()
                   .filter(atleta -> atleta.getEdad() >= edadMin && atleta.getEdad() <= edadMax)
                   .collect(Collectors.toList());
    }

	public static void main(String[] args) {
		AtletasPorEdad atletas = new AtletasPorEdad();
		atletas.add(Atleta.of("Juan", 25));
		atletas.add(Atleta.of("Maria", 30));
		atletas.add(Atleta.of("Pedro", 20));
		atletas.add(Atleta.of("Ana", 35));
		List<Atleta> resultado = atletas.atletasEnRango(25, 30);
		System.out.println(resultado);
		List<Atleta> ordenados = atletas.stream().sorted(Comparator.comparingInt(Atleta::getEdad)).collect(Collectors.toList());
		System.out.println(ordenados);
	}
}

