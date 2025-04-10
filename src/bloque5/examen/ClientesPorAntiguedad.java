package bloque5.examen;

import entrega2.tipos.ListaOrdenada;
//import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class ClientesPorAntiguedad extends ListaOrdenada<Cliente> {

    public ClientesPorAntiguedad() {
        super((c1, c2) -> Integer.compare(c2.antigüedad(), c1.antigüedad()));
    }

    public List<Cliente> topClientes(int n) {
        List<Cliente> resultado = new ArrayList<>();
        for (int i = 0; i < n && i < this.size(); i++) {
            resultado.add(this.elements().get(i));
        }
        return resultado;
    }
    
	public static void main(String[] args) {
		ClientesPorAntiguedad lista = new ClientesPorAntiguedad();
		lista.add(Cliente.of("Juan", 5));
		lista.add(Cliente.of("Ana", 3));
		lista.add(Cliente.of("Pedro", 7));
		lista.add(Cliente.of("Luis", 2));
	
		System.out.println("Clientes con más o  5 años de antigüedad:");
			for (Cliente cliente : lista.topClientes(lista.size())) {
				if (cliente.antigüedad() >= 5) {
					System.out.println(cliente);
				}
			}

		System.out.println("\nTop 3 clientes:");
		List<Cliente> topClientes = lista.topClientes(3);
		for (Cliente cliente : topClientes) {
			System.out.println(cliente);
		
		//lista.add(null);
		// lista.topClientes(-1);
		// lista.topClientes(10);
		}
	}
}
