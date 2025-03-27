package entrega2.tipos;

import java.util.Comparator;
import java.util.List;
//import java.util.ArrayList;
import java.util.stream.Collectors;

public class ColaPrioridad<E, P extends Comparable<P>> extends Cola<PriorityElement<E, P>> {
	public ColaPrioridad() {
		super();
	}

	public static <E, P extends Comparable<P>> ColaPrioridad<E, P> ofPriority() {
		return new ColaPrioridad<>();
	}

	@Override
	public void add(PriorityElement<E, P> element) {
		super.add(element);
	}

	public void add(E value, P priority) {
		super.add(new PriorityElement<>(value, priority));
	}

	public List<E> valuesAsList() {
		return elementos.stream().sorted(Comparator.comparing(PriorityElement::priority)).map(PriorityElement::value)
				.collect(Collectors.toList());
	}

	public void decreasePriority(E value, P newPriority) {
		for (int i = 0; i < elementos.size(); i++) {
			if (elementos.get(i).value().equals(value)) {
				elementos.set(i, new PriorityElement<>(value, newPriority));
				elementos.sort(Comparator.comparing(PriorityElement::priority));
				return;
			}
		}
	}

	public E removeValue() {
		PriorityElement<E, P> element = remove();
		if (element != null) {
			return element.value();
		} else {
			throw new IllegalStateException("La cola está vacía");
		}

	}

	public void addAllValues(List<E> values, P priority) {
		for (E value : values) {
			add(value, priority);
		}
	}
}
