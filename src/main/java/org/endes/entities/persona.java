package org.endes.entities;

/**
 * Clase persona.
 * Representa una entidad sencilla que permite practicar los conceptos
 * básicos de Programación Orientada a Objetos:
 * encapsulación, constructores, getters/setters y métodos estáticos.
 */
public class persona {

    /** Identificador de la persona */
    private int id;

    /** Nombre de la persona */
    private String nombre;

    /** Categoría asociada a la persona */
    private String categoria;

    /** Precio asociado (valor genérico para la práctica) */
    private double precio;

    /** Stock disponible */
    private int stock;

    /** Indica si la persona está disponible */
    private boolean disponible;

    /** Proveedor asociado */
    private String proveedor;

    /** Peso asociado */
    private double peso;

    /**
     * Constructor por defecto.
     * Inicializa la persona con valores básicos para evitar
     * atributos sin definir.
     */
    public persona() {
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
     * Permite crear una persona indicando todos sus atributos.
     *
     * @param id identificador de la persona
     * @param nombre nombre de la persona
     * @param categoria categoría asociada
     * @param precio precio asignado
     * @param stock stock disponible
     * @param disponible indica si está disponible
     * @param proveedor proveedor asociado
     * @param peso peso asignado
     */
    public persona(int id, String nombre, String categoria, double precio,
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

    /** @return identificador de la persona */
    public int getId() {
        return id;
    }

    /** @param id nuevo identificador */
    public void setId(int id) {
        this.id = id;
    }

    /** @return nombre de la persona */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return categoría */
    public String getCategoria() {
        return categoria;
    }

    /** @param categoria nueva categoría */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /** @return precio */
    public double getPrecio() {
        return precio;
    }

    /** @param precio nuevo precio */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /** @return stock disponible */
    public int getStock() {
        return stock;
    }

    /** @param stock nuevo stock */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /** @return true si está disponible */
    public boolean isDisponible() {
        return disponible;
    }

    /** @param disponible nueva disponibilidad */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /** @return proveedor */
    public String getProveedor() {
        return proveedor;
    }

    /** @param proveedor nuevo proveedor */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    /** @return peso */
    public double getPeso() {
        return peso;
    }

    /** @param peso nuevo peso */
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
