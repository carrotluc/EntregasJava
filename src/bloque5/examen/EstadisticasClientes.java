package bloque5.examen;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.ArrayList;

public class EstadisticasClientes {

    // VERSIÓN FUNCIONAL
    public static Map<Cliente, List<Compra>> agruparComprasPorClienteFuncional(List<Compra> compras) {
        return compras.stream()
                .collect(Collectors.groupingBy(Compra::cliente));
    }

    // VERSIÓN IMPERATIVA
    public static Map<Cliente, List<Compra>> agruparComprasPorClienteImperativa(List<Compra> compras) {
        Map<Cliente, List<Compra>> comprasPorCliente = new HashMap<>();
        
        for (Compra compra : compras) {
            Cliente cliente = compra.cliente();
            comprasPorCliente.putIfAbsent(cliente, new ArrayList<>());
            comprasPorCliente.get(cliente).add(compra);
        }
        
        return comprasPorCliente;
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan", 5);
        Cliente cliente2 = new Cliente("Ana", 6);

        Compra compra1 = new Compra(cliente1, "Compra de alimentos", 50.0);
        Compra compra2 = new Compra(cliente2, "Compra de electrónica", 100.0);
        Compra compra3 = new Compra(cliente1, "Compra de ropa", 30.0);
        Compra compra4 = new Compra(cliente2, "Compra de electrónica", 70.0);

        List<Compra> compras = List.of(compra1, compra2, compra3, compra4);

        Map<Cliente, List<Compra>> comprasPorClienteFuncional = agruparComprasPorClienteFuncional(compras);
        System.out.println("Agrupación funcional:");
        comprasPorClienteFuncional.forEach((cliente, listaCompras) -> {
            System.out.println(cliente + ": " + listaCompras);
        });

        Map<Cliente, List<Compra>> comprasPorClienteImperativa = agruparComprasPorClienteImperativa(compras);
        System.out.println("\nAgrupación imperativa:");
        comprasPorClienteImperativa.forEach((cliente, listaCompras) -> {
            System.out.println(cliente + ": " + listaCompras);
        });
    }
}
