package entrega2.tipos;

public record PriorityElement<E, P extends Comparable<P>>(E value, P priority) {

}
