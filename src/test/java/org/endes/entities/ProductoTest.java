package org.endes.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Producto")
class ProductoTest {

    private static final double DELTA = 1e-9;

    private Producto teclado;

    @BeforeEach
    void setUp() {
        teclado = new Producto(1, "Teclado Mecánico", "Informática", 25.0, 10, true, "Logitech", 0.9);
    }

    @Nested
    @DisplayName("Constructores")
    class Constructores {

        @Test
        @DisplayName("el constructor por defecto asigna valores neutros")
        void constructorPorDefecto() {
            Producto p = new Producto();

            assertAll(
                    () -> assertEquals(0, p.getId()),
                    () -> assertEquals("Sin nombre", p.getNombre()),
                    () -> assertEquals("Sin categoría", p.getCategoria()),
                    () -> assertEquals(0.0, p.getPrecio(), DELTA),
                    () -> assertEquals(0, p.getStock()),
                    () -> assertFalse(p.isDisponible()),
                    () -> assertEquals("Desconocido", p.getProveedor()),
                    () -> assertEquals(0.0, p.getPeso(), DELTA));
        }

        @Test
        @DisplayName("el constructor completo guarda todos los atributos")
        void constructorCompleto() {
            assertAll(
                    () -> assertEquals(1, teclado.getId()),
                    () -> assertEquals("Teclado Mecánico", teclado.getNombre()),
                    () -> assertEquals("Informática", teclado.getCategoria()),
                    () -> assertEquals(25.0, teclado.getPrecio(), DELTA),
                    () -> assertEquals(10, teclado.getStock()),
                    () -> assertTrue(teclado.isDisponible()),
                    () -> assertEquals("Logitech", teclado.getProveedor()),
                    () -> assertEquals(0.9, teclado.getPeso(), DELTA));
        }

        @Test
        @DisplayName("el constructor completo rechaza datos inválidos")
        void constructorCompletoValida() {
            assertThrows(IllegalArgumentException.class,
                    () -> new Producto(2, "Ratón", "Informática", -1, 5, true, "Logitech", 0.1));
        }
    }

    @Nested
    @DisplayName("Getters y setters")
    class GettersYSetters {

        @Test
        @DisplayName("los setters actualizan cada atributo")
        void settersActualizan() {
            Producto p = new Producto();
            p.setId(100);
            p.setNombre("Ratón Inalámbrico");
            p.setCategoria("Periféricos");
            p.setPrecio(15.5);
            p.setStock(5);
            p.setDisponible(true);
            p.setProveedor("Logitech");
            p.setPeso(0.15);

            assertAll(
                    () -> assertEquals(100, p.getId()),
                    () -> assertEquals("Ratón Inalámbrico", p.getNombre()),
                    () -> assertEquals("Periféricos", p.getCategoria()),
                    () -> assertEquals(15.5, p.getPrecio(), DELTA),
                    () -> assertEquals(5, p.getStock()),
                    () -> assertTrue(p.isDisponible()),
                    () -> assertEquals("Logitech", p.getProveedor()),
                    () -> assertEquals(0.15, p.getPeso(), DELTA));
        }

        @Test
        @DisplayName("el nombre se guarda sin espacios en los extremos")
        void nombreSinEspacios() {
            teclado.setNombre("   Monitor 4K  ");
            assertEquals("Monitor 4K", teclado.getNombre());
        }

        @ParameterizedTest(name = "nombre inválido: [{0}]")
        @NullAndEmptySource
        @ValueSource(strings = {" ", "\t", "   "})
        @DisplayName("rechaza nombres nulos o vacíos")
        void nombreInvalido(String nombre) {
            assertThrows(IllegalArgumentException.class, () -> teclado.setNombre(nombre));
        }

        @ParameterizedTest(name = "precio {0}")
        @ValueSource(doubles = {-0.01, -1, -1000})
        @DisplayName("rechaza precios negativos")
        void precioNegativo(double precio) {
            assertThrows(IllegalArgumentException.class, () -> teclado.setPrecio(precio));
            assertEquals(25.0, teclado.getPrecio(), DELTA, "el precio anterior se conserva");
        }

        @Test
        @DisplayName("rechaza stock negativo")
        void stockNegativo() {
            assertThrows(IllegalArgumentException.class, () -> teclado.setStock(-1));
        }

        @Test
        @DisplayName("rechaza peso negativo")
        void pesoNegativo() {
            assertThrows(IllegalArgumentException.class, () -> teclado.setPeso(-0.5));
        }

        @Test
        @DisplayName("acepta precio, stock y peso igual a cero")
        void aceptaCeros() {
            teclado.setPrecio(0);
            teclado.setStock(0);
            teclado.setPeso(0);
            assertAll(
                    () -> assertEquals(0.0, teclado.getPrecio(), DELTA),
                    () -> assertEquals(0, teclado.getStock()),
                    () -> assertEquals(0.0, teclado.getPeso(), DELTA));
        }
    }

    @Nested
    @DisplayName("Métodos estáticos")
    class MetodosEstaticos {

        @ParameterizedTest(name = "{0} € + IVA = {1} €")
        @CsvSource({
                "0,      0",
                "10,     12.1",
                "25,     30.25",
                "15.5,   18.755",
                "100,    121"
        })
        @DisplayName("calcularPrecioConIVA aplica el 21 %")
        void precioConIva(double base, double esperado) {
            assertEquals(esperado, Producto.calcularPrecioConIVA(base), 1e-6);
        }

        @Test
        @DisplayName("calcularPrecioConIVA rechaza precios negativos")
        void precioConIvaNegativo() {
            assertThrows(IllegalArgumentException.class, () -> Producto.calcularPrecioConIVA(-5));
        }

        @ParameterizedTest(name = "stock {0} -> {1}")
        @CsvSource({"-1, false", "0, false", "1, true", "500, true"})
        @DisplayName("hayStock solo es cierto con una unidad o más")
        void hayStock(int stock, boolean esperado) {
            assertEquals(esperado, Producto.hayStock(stock));
        }
    }

    @Nested
    @DisplayName("equals, hashCode y toString")
    class Identidad {

        @Test
        @DisplayName("dos productos con el mismo id son iguales")
        void mismoIdIguales() {
            Producto copia = new Producto(1, "Otro nombre", "Otra", 1.0, 1, false, "Otro", 1.0);
            assertEquals(teclado, copia);
            assertEquals(teclado.hashCode(), copia.hashCode());
        }

        @Test
        @DisplayName("productos con distinto id son distintos")
        void distintoIdDistintos() {
            Producto otro = new Producto(2, "Teclado Mecánico", "Informática", 25.0, 10, true, "Logitech", 0.9);
            assertNotEquals(teclado, otro);
        }

        @Test
        @DisplayName("un producto es igual a sí mismo y distinto de null u otro tipo")
        void casosBorde() {
            assertAll(
                    () -> assertEquals(teclado, teclado),
                    () -> assertNotEquals(null, teclado),
                    () -> assertNotEquals("Teclado", teclado));
        }

        @Test
        @DisplayName("toString muestra los datos principales")
        void toStringLegible() {
            assertEquals(
                    "Producto{id=1, nombre='Teclado Mecánico', categoria='Informática', "
                            + "precio=25.00, stock=10, disponible=true}",
                    teclado.toString());
        }
    }
}
