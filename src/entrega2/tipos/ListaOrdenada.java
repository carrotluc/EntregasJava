package entrega2.tipos;

import java.util.Comparator;

public class ListaOrdenada<E> extends AgregadoLineal<E> {
	private Comparator<E> comparator;

	public ListaOrdenada(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public static <E> ListaOrdenada<E> of(Comparator<E> comparator) {
		return new ListaOrdenada<>(comparator);
	}
	
	private int indexOrder(E e) {
		int i = 0;
		while (i < elementos.size() && comparator.compare(elementos.get(i), e) < 0) {
			i++;
		}
		return i;
	}
	
	@Override
	public void add(E e) {
		int index = indexOrder(e);
        elementos.add(index, e);
	}

}
