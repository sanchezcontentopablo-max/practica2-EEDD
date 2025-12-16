package org.endes.entities;

import org.endes.entities.persona;

public class main {

    public static void main(String[] args) {

        // Objeto usando el constructor por defecto
        persona persona1 = new persona();

        // Objeto usando el constructor completo
        persona persona2 = new persona(
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
        persona1.setNombre("Ratón");
        persona1.setCategoria("Informática");
        persona1.setPrecio(15.5);
        persona1.setStock(5);
        persona1.setDisponible(true);

        // Uso de getters
        System.out.println("Persona 1: " + persona1.getNombre());
        System.out.println("Precio base: " + persona1.getPrecio());

        // Uso de métodos estáticos
        System.out.println("Precio con IVA de la persona 2: "
                + persona.calcularPrecioConIVA(persona2.getPrecio()));

        System.out.println("¿Hay stock de la persona 2?: "
                + persona.hayStock(persona2.getStock()));
    }
}
