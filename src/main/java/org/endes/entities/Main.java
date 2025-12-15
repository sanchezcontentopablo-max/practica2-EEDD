package org.endes.entities;

/**
 * Clase principal para probar el funcionamiento
 * de la clase Producto.
 */
public class Main {

    public static void main(String[] args) {

        // Producto creado con el constructor vacío
        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setNombre("Teclado");
        producto1.setPrecio(20.0);

        System.out.println("Producto 1:");
        System.out.println("Nombre: " + producto1.getNombre());
        System.out.println("Precio con IVA: "
                + Producto.calcularPrecioConIVA(producto1.getPrecio()));
        System.out.println("---------------------------");

        // Producto creado con el constructor completo
        Producto producto2 = new Producto(
                2,
                "Ratón",
                "Periféricos",
                15.0,
                10,
                true,                "Logitech",
                0.3
        );

        System.out.println("Producto 2:");
        System.out.println("Nombre: " + producto2.getNombre());
        System.out.println("¿Hay stock?: "
                + Producto.hayStock(producto2.getStock()));
    }
}
