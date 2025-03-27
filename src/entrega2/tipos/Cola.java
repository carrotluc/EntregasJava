package entrega2.tipos;

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

}
