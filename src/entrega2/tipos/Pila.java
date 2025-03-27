package entrega2.tipos;

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
}
