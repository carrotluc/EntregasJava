package entrega2.tipos;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		System.out.println("===== INICIANDO PRUEBAS DE ESTRUCTURAS LINEALES =====");

		System.out.println("\n----- Prueba de ListaOrdenada -----");
		ListaOrdenada<Integer> listaOrdenada = ListaOrdenada.of(Comparator.<Integer>naturalOrder());
		System.out.println("Añadiendo elementos: 5, 2, 8, 1, 3");
		listaOrdenada.add(5);
		listaOrdenada.add(2);
		listaOrdenada.add(8);
		listaOrdenada.add(1);
		listaOrdenada.add(3);
		System.out.println("Elementos en la lista: " + listaOrdenada.elements());
		System.out.println("Tamaño de la lista: " + listaOrdenada.size());
		System.out.println("Eliminando el primer elemento: " + listaOrdenada.remove());
		System.out.println("Elementos después de eliminar: " + listaOrdenada.elements());
		System.out.println("Añadiendo elementos en lote: 4, 6, 7");
		listaOrdenada.addAll(Arrays.asList(4, 6, 7));
		System.out.println("Elementos después de añadir lote: " + listaOrdenada.elements());
		System.out.println("Eliminando todos los elementos: " + listaOrdenada.removeAll());
		System.out.println("¿Está vacía? " + listaOrdenada.isEmpty());

		System.out.println("\nPrueba con strings:");
		ListaOrdenada<String> listaOrdenadaStrings = ListaOrdenada.of(Comparator.<String>naturalOrder());
		listaOrdenadaStrings.addAll(Arrays.asList("apple", "banana", "cherry", "date"));
		System.out.println("Elementos ordenados: " + listaOrdenadaStrings.elements());

		System.out.println("\n----- Prueba de ListaOrdenadaSinRepeticion -----");
		ListaOrdenadaSinRepeticion<Integer> listaSinRepeticion = ListaOrdenadaSinRepeticion
				.of(Comparator.<Integer>naturalOrder());
		System.out.println("Añadiendo elementos: 5, 2, 8, 1, 3, 5, 2");
		listaSinRepeticion.addAll(Arrays.asList(5, 2, 8, 1, 3, 5, 2));
		System.out.println("Elementos en la lista: " + listaSinRepeticion.elements());
		System.out.println("Tamaño de la lista: " + listaSinRepeticion.size());
		System.out.println("Se esperan 5 elementos únicos ordenados");
		System.out.println("Eliminando el primer elemento: " + listaSinRepeticion.remove());
		System.out.println("Elementos después de eliminar: " + listaSinRepeticion.elements());
		System.out.println("Añadiendo elementos en lote: 4, 6, 7, 4");
		listaSinRepeticion.addAll(Arrays.asList(4, 6, 7, 4));
		System.out.println("Elementos después de añadir lote: " + listaSinRepeticion.elements());
		System.out.println("Se espera que el 4 aparezca solo una vez");

		System.out.println("\n----- Prueba de Cola (FIFO) -----");
		Cola<String> cola = Cola.of();
		System.out.println("Añadiendo elementos: 'primero', 'segundo', 'tercero'");
		cola.addAll(Arrays.asList("primero", "segundo", "tercero"));
		System.out.println("Elementos en la cola: " + cola.elements());
		System.out.println("Tamaño de la cola: " + cola.size());
		System.out.println("Desencolando elementos:");
		System.out.println("Desencolado: " + cola.remove());
		System.out.println("Cola restante: " + cola.elements());
		System.out.println("Desencolado: " + cola.remove());
		System.out.println("Cola restante: " + cola.elements());
		System.out.println("Desencolado: " + cola.remove());
		System.out.println("Cola restante: " + cola.elements());
		System.out.println("¿Está vacía? " + cola.isEmpty());
		try {
			cola.remove();
		} catch (Exception e) {
			System.out.println(
					"Excepción correctamente lanzada al intentar desencolar de una cola vacía: " + e.getMessage());
		}

		System.out.println("\n----- Prueba de Pila (LIFO) -----");
		Pila<Double> pila = new Pila<>();
		System.out.println("Añadiendo elementos: 1.1, 2.2, 3.3");
		pila.addAll(Arrays.asList(1.1, 2.2, 3.3));
		System.out.println("Elementos en la pila: " + pila.elements());
		System.out.println("Tamaño de la pila: " + pila.size());
		System.out.println("Elemento en el tope: " + pila.top());
		System.out.println("Desapilando elementos:");
		System.out.println("Desapilado: " + pila.remove());
		System.out.println("Pila restante: " + pila.elements());
		System.out.println("Desapilado: " + pila.remove());
		System.out.println("Pila restante: " + pila.elements());
		System.out.println("Desapilado: " + pila.remove());
		System.out.println("Pila restante: " + pila.elements());
		System.out.println("¿Está vacía? " + pila.isEmpty());
		try {
			pila.top();
		} catch (Exception e) {
			System.out.println(
					"Excepción correctamente lanzada al intentar acceder al tope de una pila vacía: " + e.getMessage());
		}

		System.out.println("\n----- Prueba de ColaPrioridad -----");
		ColaPrioridad<String, Integer> colaPrioridad = ColaPrioridad.ofPriority();
		System.out.println("Añadiendo elementos con prioridad:");
		colaPrioridad.add("Crítico", 1);
		colaPrioridad.add("Normal", 3);
		colaPrioridad.add("Urgente", 2);
		colaPrioridad.add("Bajo", 4);
		System.out.println("Elementos en la cola por prioridad: " + colaPrioridad.valuesAsList());
		System.out.println("Elementos con sus prioridades: " + colaPrioridad.elements());
		System.out.println("Tamaño de la cola: " + colaPrioridad.size());
		System.out.println("Cambiando la prioridad de 'Normal' de 3 a 1:");
		colaPrioridad.decreasePriority("Normal", 1);
		System.out.println("Elementos con prioridad actualizada: " + colaPrioridad.elements());
		System.out.println("Desencolando elementos por prioridad:");
		System.out.println("Desencolado: " + colaPrioridad.removeValue());
		System.out.println("Cola restante: " + colaPrioridad.valuesAsList());
		System.out.println("Desencolado: " + colaPrioridad.removeValue());
		System.out.println("Cola restante: " + colaPrioridad.valuesAsList());
		System.out.println("Desencolado: " + colaPrioridad.removeValue());
		System.out.println("Cola restante: " + colaPrioridad.valuesAsList());
		System.out.println("Desencolado: " + colaPrioridad.removeValue());
		System.out.println("Cola restante: " + colaPrioridad.valuesAsList());
		System.out.println("¿Está vacía? " + colaPrioridad.isEmpty());
		try {
			colaPrioridad.removeValue();
		} catch (Exception e) {
			System.out.println(
					"Excepción correctamente lanzada al intentar desencolar de una cola vacía: " + e.getMessage());
		}

		System.out.println("\nPrueba con addAll:");
		colaPrioridad.addAllValues(Arrays.asList("Tarea A", "Tarea B", "Tarea C"), 2);
		System.out.println("Elementos añadidos en lote con prioridad 2: " + colaPrioridad.valuesAsList());
		colaPrioridad.add("Tarea Urgente", 1);
		System.out.println("Después de añadir 'Tarea Urgente' con prioridad 1: " + colaPrioridad.valuesAsList());

		System.out.println("\n===== TODAS LAS PRUEBAS COMPLETADAS =====");
	}
}
