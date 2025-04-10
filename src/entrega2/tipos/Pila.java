package entrega2.tipos;

import java.util.stream.Stream;

public class Pila<E> extends AgregadoLineal<E> {
	public Pila() {
        super();
    }
	
	@Override
	public void add(E e) {
		elementos.add(e);
	}
	
	public E top() {
		if (elementos.isEmpty()) {
			throw new IllegalStateException("La pila está vacía");
		}
		return elementos.get(elementos.size() - 1);
    }

	//Ensayo (bloque2.ensayo)
	public Stream<E> stream() {
		return elementos.stream();
	}
}
