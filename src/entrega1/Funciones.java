package entrega1;

public class Funciones {
	
	//FUNCIÓN 1
	public static Integer serie(Integer n, Integer k) {
		assert k > 0 : "¡OJO! K debe ser mayor que 0";
		assert n > 0 : "¡OJO! N debe ser mayor que 0";
		assert n>k : "¡OJO! N debe ser mayor que k";
		Integer s = 1;
		for (int i = 0; i <= k; i++) {
		s = s*(n - i + 1);
		}
		return s;
	}

	//FUNCIÓN 2
	public static Double Funcion2(Double a1, Double r, Double k) {
		Double s = a1;
        for (int i = 1; i < k; i++) {
        s = s *(a1 * Math.pow(r, i));
        }
        return s;
    }
	
	//FUNCIÓN 3
	public static Double numeroCombinatorio(Integer n, Integer k) {
		assert k > 0 : "¡OJO! K debe ser mayor que 0";
		assert n > 0 : "¡OJO! N debe ser mayor que 0";
		assert n>=k : "¡OJO! N debe ser mayor que k";
		Double s = 1.;
		for (int i = 0; i < k; i++) {
			s = s * (n - i) / (k - i);
		}
		return s;
	}
	}

