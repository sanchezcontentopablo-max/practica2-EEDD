package org.endes.entities;

/**
 * Clase Main.
 * Contiene el método principal del programa y permite
 * probar exhaustivamente el funcionamiento de la clase {@link Producto}.
 */
public class Main {

    /**
     * Método principal del programa.
     * Se prueban constructores, getters, setters
     * y métodos estáticos de la clase Producto de forma exhaustiva.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {

        System.out.println("=".repeat(60));
        System.out.println("    PRUEBA EXHAUSTIVA DE LA CLASE PRODUCTO");
        System.out.println("=".repeat(60));

        // ===== PRUEBA 1: Constructor por defecto =====
        System.out.println("\n--- PRUEBA 1: Constructor por defecto ---");
        Producto producto1 = new Producto();

        System.out.println("Producto creado con constructor por defecto:");
        mostrarProducto(producto1);

        // ===== PRUEBA 2: Uso de setters =====
        System.out.println("\n--- PRUEBA 2: Uso de setters en producto1 ---");
        producto1.setId(100);
        producto1.setNombre("Ratón Inalámbrico");
        producto1.setCategoria("Informática");
        producto1.setPrecio(15.5);
        producto1.setStock(5);
        producto1.setDisponible(true);
        producto1.setProveedor("Logitech");
        producto1.setPeso(0.15);

        System.out.println("Producto1 después de usar setters:");
        mostrarProducto(producto1);

        // ===== PRUEBA 3: Constructor completo =====
        System.out.println("\n--- PRUEBA 3: Constructor completo ---");
        Producto producto2 = new Producto(
                1,
                "Teclado Mecánico",
                "Informática",
                25.0,
                10,
                true,
                "Logitech",
                0.9
        );

        System.out.println("Producto2 creado con constructor completo:");
        mostrarProducto(producto2);

        // ===== PRUEBA 4: Métodos estáticos =====
        System.out.println("\n--- PRUEBA 4: Métodos estáticos ---");

        double precioBase1 = producto1.getPrecio();
        double precioConIVA1 = Producto.calcularPrecioConIVA(precioBase1);
        System.out.printf("Producto 1 - Precio base: %.2f€%n", precioBase1);
        System.out.printf("Producto 1 - Precio con IVA (21%%): %.2f€%n", precioConIVA1);
        System.out.println("Producto 1 - ¿Hay stock?: " +
                Producto.hayStock(producto1.getStock()));

        System.out.println();

        double precioBase2 = producto2.getPrecio();
        double precioConIVA2 = Producto.calcularPrecioConIVA(precioBase2);
        System.out.printf("Producto 2 - Precio base: %.2f€%n", precioBase2);
        System.out.printf("Producto 2 - Precio con IVA (21%%): %.2f€%n", precioConIVA2);
        System.out.println("Producto 2 - ¿Hay stock?: " +
                Producto.hayStock(producto2.getStock()));

        // ===== PRUEBA 5: Producto sin stock =====
        System.out.println("\n--- PRUEBA 5: Producto sin stock ---");
        Producto producto3 = new Producto(
                3,
                "Monitor 4K",
                "Informática",
                350.0,
                0,
                false,
                "Samsung",
                5.5
        );

        System.out.println("Producto3 (sin stock):");
        mostrarProducto(producto3);
        System.out.println("¿Hay stock del producto3?: " +
                Producto.hayStock(producto3.getStock()));

        // ===== RESUMEN FINAL =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("    RESUMEN DE PRUEBAS");
        System.out.println("=".repeat(60));
        System.out.println("✓ Constructor por defecto probado");
        System.out.println("✓ Constructor completo probado");
        System.out.println("✓ Todos los setters probados (8/8)");
        System.out.println("✓ Todos los getters probados (8/8)");
        System.out.println("✓ Métodos estáticos probados (2/2)");
        System.out.println("✓ Total productos creados: 3");
        System.out.println("=".repeat(60));
    }

    /**
     * Método auxiliar para mostrar todos los atributos de un producto.
     * Usa todos los getters disponibles.
     *
     * @param p el producto a mostrar
     */
    private static void mostrarProducto(Producto p) {
        System.out.println("  - ID: " + p.getId());
        System.out.println("  - Nombre: " + p.getNombre());
        System.out.println("  - Categoría: " + p.getCategoria());
        System.out.printf("  - Precio: %.2f€%n", p.getPrecio());
        System.out.println("  - Stock: " + p.getStock() + " unidades");
        System.out.println("  - Disponible: " + (p.isDisponible() ? "Sí" : "No"));
        System.out.println("  - Proveedor: " + p.getProveedor());
        System.out.printf("  - Peso: %.2f kg%n", p.getPeso());
    }
}
