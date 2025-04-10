package entrega2.tipos;

import java.util.stream.Stream;

public class Cola<E> extends AgregadoLineal<E> {
	public Cola() {
		super();
	}
	
	public static <E> Cola<E> of() {
		return new Cola<E>();
	}
	
	@Override
	public void add(E e) {
		elementos.add(e);
	}

	//Ensayo (bloque2.ensayo)
	public Stream<E> stream() {
		return elementos.stream();
	}
}
