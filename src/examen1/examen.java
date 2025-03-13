package examen1;
import us.lsi.tools.File2;
import java.util.List;
import java.util.ArrayList;

public class examen {
    
	//ACTIVIDAD A
    public static Integer productoImpares(Integer n) {
        assert n != null : "El número no puede ser null";
        assert n > 0 : "El número debe ser mayor que 0";
        
        Integer p = 1;
        Integer pi = 1;
        
        for (Integer i = 0; i < n; i++) {
            p *= pi;
            pi += 2; 
        }
        return p;
    }
    
    //ACTIVIDAD B
	public static Double sumaGeometricaAlternada(Double a1, Double r, int k) {
		assert a1 > 0 : "El primer término debe ser mayor que 0";
		assert r > 0 : "La razón debe ser mayor que 0";
		if (k <= 0) {
			throw new IllegalArgumentException("El número debe ser mayor que 0");
		}
		Double s = 0.0;
		for (int n = 0; n <k; n++) {
			s += Math.pow(-1, n-1) * a1 * Math.pow(r, n);
			}
		return s;
		}
  
	//ACTIVIDAD C
	public static Integer combinatorioSinMultiplosDeTres(Integer n, Integer k) {
		assert n >= k : "El primer número debe ser menor que el segundo";
		assert n > 0 : "El primer número debe ser mayor que 0";
		assert k > 0 : "El segundo número debe ser mayor que 0";
		Integer num = 1;
		Integer den = 1;
		for (Integer i = n; i > (n - k); i--) {
			if (i % 3 != 0) {
				num *= i;
			}
		}
		for (Integer i = k; i > 0; i--) {
			if (i % 3 != 0) {
				den *= i;
			}
		}
		return num / den;
		
	}
	
	//ACTIVIDAD D
	public static List<String> filtrarLineasConsecutivas(String file, List<String> palabra) {
	    List<String> res = new ArrayList<>();
	    try {
	        List<String> lineas = File2.lineasDeFichero(file); 
	        for (String linea : lineas) {
	            for (int i = 0; i < palabra.size() - 1; i++) {  
	                String palabra1 = palabra.get(i);
	                String palabra2 = palabra.get(i + 1);
	                if (linea.contains(palabra1 + " " + palabra2)) {
	                	//Si queremos que no importe el orden añadimos: || linea.contains(palabra2 + " " + palabra1)
	                    res.add(linea);  
	                    break; 
	                }
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error en la lectura del fichero");
	    }
	    return res;  
	}

	
	//TEST DE LOS MÉTODOS
    public static void main(String[] args) {
        Integer n = 5; 
        System.out.println("El producto de los primeros " + n + " números impares es: " + productoImpares(n));
        Double a1 = 2.0;
        Double r = 3.0;
        int k = 4;
        System.out.println("La suma de los primeros " + k + " términos de la serie geométrica alternada es: " + sumaGeometricaAlternada(a1, r, k));
        Integer n1 = 10;
        Integer k1 = 3;
        System.out.println("El número combinatorio de " + n1 + " sobre " + k1 + " sin múltiplos de 3 es: " + combinatorioSinMultiplosDeTres(n1, k1));
        String file = "resources/archivo_palabras.txt";
        List<String> palabras = List.of("salud", "proyecto");
        System.out.println("Las líneas que contienen las palabras consecutivas son: " + filtrarLineasConsecutivas(file, palabras));
    }
    
}

