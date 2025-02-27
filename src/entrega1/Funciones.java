package entrega1;

public class Funciones {
	
	//FUNCIÓN 1
	public static String serie(Integer n, Integer k) {
		assert k > 0 : "¡OJO! K debe ser mayor que 0";
		assert n > 0 : "¡OJO! N debe ser mayor que 0";
		assert n>k : "¡OJO! N debe ser mayor que k";
		Integer s = 1;
		for (int i = 0; i <= k; i++) {
		s = s*(n - i + 1);
		}
		String s1 = String.format("El resultado del producto de %d y %d es %d", n, k, s);
		return s1;
	}

	//FUNCIÓN 2
	public static String Funcion2(Double a1, Double r, Double k) {
		Double s = a1;
        for (int i = 1; i < k; i++) {
        Double p = Math.pow(r, i);
        s = s *(a1 * p);
        }
        String s1 = String.format("El producto de la secuencia geométrica de %.2f, %.2f y %.2f es %.2f", a1, r, k, s);
        return s1;
    }
	
	//FUNCIÓN 3
	public static String numeroCombinatorio(Integer n, Integer k) {
		assert k > 0 : "¡OJO! K debe ser mayor que 0";
		assert n > 0 : "¡OJO! N debe ser mayor que 0";
		assert n>=k : "¡OJO! N debe ser mayor que k";
		Integer s = 1;
		for (int i = 0; i < k; i++) {
			s = s * (n - i) / (k - i);
		}
		String s1 = String.format("El número combinatorio de %d y %d es %d", n, k, s);
		return s1;
	}
	
	//FUNCIÓN 4
	//Para calcular el número S(n,k), se necesita el número combinatorio y factoriales.
	public static Double factorial(Double n) {
		Double s = 1.;
		for (int i = 1; i <= n; i++) {
			s = s * i;
		}
		return s;
	}
	
	public static Double numerocombinatorio (Double n, Double k) {
		assert k <= n: "¡OJO! K debe ser menor o igual que N";
		Double s = factorial(n) / (factorial(k) * factorial(n - k));
		return s;
	}
	
	public static String Funcion4(Double n, Double k) {
		assert k > 0 : "¡OJO! K debe ser mayor que 0";
		assert n > 0 : "¡OJO! N debe ser mayor que 0";
		assert n >= k : "¡OJO! N debe ser mayor que k";
		Double t1 = 1 / factorial(k);
		Double t5 = 0.0;
		for (Double i = 0.; i < k; i++) {
			Double t2 = numerocombinatorio(k+1, i+1);
			Double t3 = Math.pow(-1, i);
			Double t4 = Math.pow(k - i, n);
			t5 = t5 + (t2 * t3 * t4);
		}
		Double t6 = t1 * t5;
		String s3 = String.format("El número S(n,k) de %.2f y %.2f es %.2f", n, k, t6);
		return s3;
	}
	
    // FUNCIÓN 5
    public static String newtonMetodo(Double a, Double e) {
        Double x = a;
        for (Integer i = 0; i < 1000; i++) { 
            Double fx = 2 * Math.pow(x, 2);
            Double fpx = 4 * x; 
            if (Math.abs(fx) <= e) {
                break;
            }
            x = x - fx / fpx;
        }
        String s = String.format("Aplicando el método de Newton, la raíz cuadrada de %.2f es %.6f", a, x);
        return s;
    }
	
	//APARTADO DE LOS TEST DE CADA FUNCIÓN
	public static void main(String[] args) {
		System.out.println(serie(4, 2));
		System.out.println(Funcion2(3., 5., 2.));
		System.out.println(numeroCombinatorio(4, 2));
		System.out.println(Funcion4(4., 2.));
		System.out.println(newtonMetodo(3., 0.001));
	}
}

