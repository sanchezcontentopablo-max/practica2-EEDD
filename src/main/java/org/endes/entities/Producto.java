package org.endes.entities;

/**
 * Clase Producto.
 * Representa un producto genérico para practicar los conceptos
 * básicos de Programación Orientada a Objetos como encapsulación,
 * constructores, getters/setters y métodos estáticos.
 */
public class Producto {
    /** Identificador del producto */
    private int id;

    /** Nombre del producto */
    private String nombre;

    /** Categoría del producto */
    private String categoria;

    /** Precio del producto */
    private double precio;

    /** Stock disponible */
    private int stock;

    /** Indica si el producto está disponible */
    private boolean disponible;

    /** Proveedor del producto */
    private String proveedor;

    /** Peso del producto */
    private double peso;

    /**
     * Constructor por defecto.
     * Inicializa el producto con valores básicos.
     */
    public Producto() {
        this.id = 0;
        this.nombre = "Sin nombre";
        this.categoria = "Sin categoría";
        this.precio = 0.0;
        this.stock = 0;
        this.disponible = false;
        this.proveedor = "Desconocido";
        this.peso = 0.0;
    }

    /**
     * Constructor completo.
     * Permite crear un producto indicando todos sus atributos.
     */
    public Producto(int id, String nombre, String categoria, double precio,
                    int stock, boolean disponible, String proveedor, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.disponible = disponible;
        this.proveedor = proveedor;
        this.peso = peso;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Calcula el precio final aplicando el IVA (21%).
     *
     * @param precio precio base
     * @return precio con IVA incluido
     */
    public static double calcularPrecioConIVA(double precio) {
        return precio * 1.21;
    }

    /**
     * Comprueba si existe stock disponible.
     *
     * @param stock cantidad a comprobar
     * @return true si hay stock, false en caso contrario
     */
    public static boolean hayStock(int stock) {
        return stock > 0;
    }
}
