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
			return elementos.get(0);
		}
		return null;
    }
}
