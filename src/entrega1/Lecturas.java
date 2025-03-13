package entrega1;

import java.util.List;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
//import tools.File2;
import us.lsi.tools.File2;
public class Lecturas {
	
	// FUNCIÓN 6
	public static String sumaElementosFichero(String fichero, String sep, String cad) {
		Integer c = 0;
		List<String> lineas = File2.lineasDeFichero(fichero);
		String cadl = cad.toLowerCase();
		for (String linea : lineas) {
			String[] t = linea.split(sep); 
			for (String t2 : t) {
				if (t2.toLowerCase().equals(cadl)) {
					c++;
				}
			}
		}
		String s = String.format("El número de veces que aparece la palabra %s en el fichero es %d", cad, c);
		return s;
	}

	// FUNCIÓN 7
	public static String sumaLineasFichero(String fichero, String cad) {
		List<String> lineasc = new ArrayList<>();
		List<String> lineas = File2.lineasDeFichero(fichero);
		String cadl = cad.toLowerCase();
		for (String linea : lineas) {
			if (linea.toLowerCase().contains(cadl)) {
				lineasc.add(linea);
			}
		}
		String s = String.format("Las líneas que contienen la palabra %s son:\n%s", cad, lineasc);
		return s;
	}

	// FUNCIÓN 8
		public static String palabrasUnicas(String fichero) {
			Set<String> palabrasUnicas = new HashSet<>();
			List<String> lineas = File2.lineasDeFichero(fichero);
			for (String linea : lineas) {
				String[] palabras = linea.split(" ");
				for (String palabra : palabras) {
					palabrasUnicas.add(palabra);
				}
			}
			String s = String.format("Las palabras únicas del fichero son %s", palabrasUnicas);
			return s;
		}
		
	//FUNCIÓN 9
	public static String longitudMediaLineas(String fichero, String sep) {
		List<String> lineas = File2.lineasDeFichero(fichero);
		Double t = 0.0;
		Integer n = lineas.size();

		for (String linea : lineas) {
			String[] palabras = linea.split(sep);
			t += palabras.length;
		}
		Double m = t/n; 
		String s = String.format("La longitud media de las líneas del fichero es %.1f", m);
		return s;
	}
		
	//TestLecturas.java
	public static void main(String[] args) {
		System.out.println(sumaElementosFichero("resources/lin_quijote.txt", " ", "Quijote"));
		System.out.println(sumaLineasFichero("resources/lin_quijote.txt", "quijote"));
		System.out.println(palabrasUnicas("resources/archivo_palabras.txt"));
		System.out.println(longitudMediaLineas("resources/palabras_random.csv", ","));
		System.out.println("1" + "2" + '3');
	}
}
