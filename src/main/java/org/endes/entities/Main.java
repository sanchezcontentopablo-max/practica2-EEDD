package org.endes.entities;

/**
 * Clase Main.
 * Contiene el método principal del programa y permite
 * probar el funcionamiento de la clase {@link Producto}.
 */
public class Main {

    /**
     * Método principal del programa.
     * Se prueban constructores, getters, setters
     * y métodos estáticos de la clase Producto.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {

        // Constructor por defecto
        Producto producto1 = new Producto();

        // Constructor completo
        Producto producto2 = new Producto(
                1,
                "Teclado",
                "Informática",
                25.0,
                10,
                true,
                "Logitech",
                0.9
        );

        // Uso de setters
        producto1.setNombre("Ratón");
        producto1.setCategoria("Informática");
        producto1.setPrecio(15.5);
        producto1.setStock(5);
        producto1.setDisponible(true);

        // Uso de getters
        System.out.println("Producto 1: " + producto1.getNombre());
        System.out.println("Precio base: " + producto1.getPrecio());

        // Métodos estáticos
        System.out.println("Precio con IVA del producto 2: "
                + Producto.calcularPrecioConIVA(producto2.getPrecio()));

        System.out.println("¿Hay stock del producto 2?: "
                + Producto.hayStock(producto2.getStock()));
    }
}
