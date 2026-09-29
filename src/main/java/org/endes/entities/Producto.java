package org.endes.entities;

import java.util.Locale;
import java.util.Objects;

/**
 * Representa un producto de un catálogo o inventario.
 *
 * <p>La clase sirve para practicar los conceptos básicos de la Programación
 * Orientada a Objetos: encapsulación, constructores, getters/setters,
 * validación de datos y métodos estáticos de utilidad.</p>
 *
 * <p>Todas las modificaciones pasan por los setters, que validan los datos
 * para que un producto nunca quede en un estado incoherente (precio, stock o
 * peso negativos, o un nombre vacío).</p>
 *
 * @author Pablo Sánchez Contento
 * @version 1.0.0
 */
public class Producto {

    /** Tipo general de IVA aplicado en España (21 %). */
    public static final double IVA = 0.21;

    /** Identificador del producto. */
    private int id;

    /** Nombre comercial del producto. Nunca es nulo ni vacío. */
    private String nombre;

    /** Categoría a la que pertenece el producto. */
    private String categoria;

    /** Precio base sin impuestos, en euros. Nunca es negativo. */
    private double precio;

    /** Unidades disponibles en almacén. Nunca es negativo. */
    private int stock;

    /** Indica si el producto está a la venta. */
    private boolean disponible;

    /** Empresa que suministra el producto. */
    private String proveedor;

    /** Peso del producto en kilogramos. Nunca es negativo. */
    private double peso;

    /**
     * Constructor por defecto.
     *
     * <p>Crea un producto con valores neutros: sin nombre, sin categoría,
     * sin stock y no disponible.</p>
     */
    public Producto() {
        this(0, "Sin nombre", "Sin categoría", 0.0, 0, false, "Desconocido", 0.0);
    }

    /**
     * Constructor completo.
     *
     * @param id         identificador del producto
     * @param nombre     nombre comercial; no puede ser nulo ni estar vacío
     * @param categoria  categoría del producto
     * @param precio     precio base sin IVA, en euros; no puede ser negativo
     * @param stock      unidades disponibles; no puede ser negativo
     * @param disponible {@code true} si el producto está a la venta
     * @param proveedor  empresa que suministra el producto
     * @param peso       peso en kilogramos; no puede ser negativo
     * @throws IllegalArgumentException si algún dato no es válido
     */
    public Producto(int id, String nombre, String categoria, double precio,
                    int stock, boolean disponible, String proveedor, double peso) {
        setId(id);
        setNombre(nombre);
        setCategoria(categoria);
        setPrecio(precio);
        setStock(stock);
        setDisponible(disponible);
        setProveedor(proveedor);
        setPeso(peso);
    }

    /**
     * Devuelve el identificador del producto.
     *
     * @return el identificador
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador del producto.
     *
     * @param id nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return el nombre, nunca nulo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del producto. Se eliminan los espacios de los extremos.
     *
     * @param nombre nuevo nombre; no puede ser nulo ni estar vacío
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.strip();
    }

    /**
     * Devuelve la categoría del producto.
     *
     * @return la categoría
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Cambia la categoría del producto.
     *
     * @param categoria nueva categoría
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Devuelve el precio base del producto, sin IVA.
     *
     * @return el precio en euros
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Cambia el precio base del producto.
     *
     * @param precio nuevo precio sin IVA, en euros
     * @throws IllegalArgumentException si el precio es negativo
     */
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo: " + precio);
        }
        this.precio = precio;
    }

    /**
     * Devuelve las unidades disponibles en almacén.
     *
     * @return el stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Cambia las unidades disponibles en almacén.
     *
     * @param stock nuevo stock
     * @throws IllegalArgumentException si el stock es negativo
     */
    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo: " + stock);
        }
        this.stock = stock;
    }

    /**
     * Indica si el producto está a la venta.
     *
     * @return {@code true} si está disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Marca el producto como disponible o no disponible.
     *
     * @param disponible {@code true} para ponerlo a la venta
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Devuelve el proveedor del producto.
     *
     * @return el proveedor
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Cambia el proveedor del producto.
     *
     * @param proveedor nuevo proveedor
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Devuelve el peso del producto.
     *
     * @return el peso en kilogramos
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Cambia el peso del producto.
     *
     * @param peso nuevo peso en kilogramos
     * @throws IllegalArgumentException si el peso es negativo
     */
    public void setPeso(double peso) {
        if (peso < 0) {
            throw new IllegalArgumentException("El peso no puede ser negativo: " + peso);
        }
        this.peso = peso;
    }

    /**
     * Calcula el precio final aplicando el IVA general ({@value #IVA}).
     *
     * @param precio precio base, en euros; no puede ser negativo
     * @return precio con IVA incluido
     * @throws IllegalArgumentException si el precio es negativo
     */
    public static double calcularPrecioConIVA(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo: " + precio);
        }
        return precio * (1 + IVA);
    }

    /**
     * Comprueba si una cantidad de unidades supone que hay stock.
     *
     * @param stock cantidad a comprobar
     * @return {@code true} si hay al menos una unidad
     */
    public static boolean hayStock(int stock) {
        return stock > 0;
    }

    /**
     * Dos productos son iguales si tienen el mismo identificador.
     *
     * @param o objeto con el que comparar
     * @return {@code true} si ambos productos tienen el mismo {@code id}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Producto otro)) {
            return false;
        }
        return id == otro.id;
    }

    /**
     * Código hash coherente con {@link #equals(Object)}.
     *
     * @return hash basado en el identificador
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Representación legible del producto, útil para depurar.
     *
     * @return texto con los datos principales del producto
     */
    @Override
    public String toString() {
        return String.format(Locale.ROOT,
                "Producto{id=%d, nombre='%s', categoria='%s', precio=%.2f, stock=%d, disponible=%s}",
                id, nombre, categoria, precio, stock, disponible);
    }
}
