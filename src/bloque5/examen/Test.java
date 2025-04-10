package bloque5.examen;

import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Cliente ana = Cliente.of("Ana", 5);
        Cliente juan = Cliente.of("Juan", 2);
        Cliente luis = Cliente.of("Luis", 7);
        
        Compra c1 = Compra.of(ana, "Agenda personalizada", 25.5);
        Compra c2 = Compra.of(juan, "Camiseta estampada", 60.0);
        Compra c3 = Compra.of(ana, "Taza con foto", 15.0);
        Compra c4 = Compra.of(luis, "Poster gigante", 80.0);

        ColaComprasPendientes cola = new ColaComprasPendientes();
        cola.add(c1);
        cola.add(c2);
        cola.add(c3);
        cola.add(c4);

        System.out.println("====== PRUEBA 1: BUSCAR COMPRA POR DESCRIPCIÓN ======");
        Compra resultadoBusqueda = cola.buscarCompraPorDescripcion("Camiseta estampada");
        if (resultadoBusqueda != null) {
            System.out.println("Compra encontrada: " + resultadoBusqueda);
        } else {
            System.out.println("No existe la compra que buscas");
        }

        System.out.println("\n====== PRUEBA 2: BUSCAR COMPRA POR DESCRIPCIÓN VACÍA ======");
        resultadoBusqueda = cola.buscarCompraPorDescripcion("");
        if (resultadoBusqueda == null) {
            System.out.println("No existe la compra que buscas");
        } else {
            System.out.println("Compra encontrada: " + resultadoBusqueda);
        }

        System.out.println("\n====== PRUEBA 3: BUSCAR COMPRA POR DESCRIPCIÓN INEXISTENTE ======");
        resultadoBusqueda = cola.buscarCompraPorDescripcion("Compra de bicicletas");
        if (resultadoBusqueda == null) {
            System.out.println("No existe la compra que buscas");
        } else {
            System.out.println("Compra encontrada: " + resultadoBusqueda);
        }

        System.out.println("\n====== PRUEBA 4: AGRUPAR COMPRAS POR CLIENTE (FUNCIONAL) ======");
        Map<Cliente, List<Compra>> comprasPorClienteFuncional = EstadisticasClientes.agruparComprasPorClienteFuncional(List.of(c1, c2, c3, c4));
        for (Map.Entry<Cliente, List<Compra>> entry : comprasPorClienteFuncional.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n====== PRUEBA 5: AGRUPAR COMPRAS POR CLIENTE (IMPERATIVA) ======");
        Map<Cliente, List<Compra>> comprasPorClienteImperativa = EstadisticasClientes.agruparComprasPorClienteImperativa(List.of(c1, c2, c3, c4));
        for (Map.Entry<Cliente, List<Compra>> entry : comprasPorClienteImperativa.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n====== PRUEBA 6: FILTRAR COMPRAS POR CLIENTE Y PRODUCTO ======");
        List<Compra> comprasFiltradas = cola.filtrarPorClienteYProducto(ana, "Taza");
        if (comprasFiltradas.isEmpty()) {
            System.out.println("No se encontraron compras con esos filtros");
        } else {
            for (Compra compra : comprasFiltradas) {
                System.out.println(compra);
            }
        }

        System.out.println("\n====== PRUEBA 7: FILTRAR COMPRAS POR CLIENTE Y PRODUCTO ======");
        comprasFiltradas = cola.filtrarPorClienteYProducto(juan, "Camiseta");
        if (comprasFiltradas.isEmpty()) {
            System.out.println("No se encontraron compras con esos filtros");
        } else {
            for (Compra compra : comprasFiltradas) {
                System.out.println(compra);
            }
        }

        System.out.println("\n====== PRUEBA 8: FILTRAR COMPRAS POR CLIENTE Y PRODUCTO INEXISTENTE ======");
        comprasFiltradas = cola.filtrarPorClienteYProducto(luis, "Zapatos");
        if (comprasFiltradas.isEmpty()) {
            System.out.println("No se encontraron compras con esos filtros");
        } else {
            for (Compra compra : comprasFiltradas) {
                System.out.println(compra);
            }
        }
    }
}
