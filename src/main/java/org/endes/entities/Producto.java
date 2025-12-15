package org.endes.entities;

/**
 * Clase Producto.
 * Se utiliza para practicar conceptos básicos de POO
 * como encapsulación, constructores y métodos.
 */
public class Producto {

    // Atributos del producto
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    private boolean disponible;
    private String proveedor;
    private double peso;

    /**
     * Constructor vacío.
     * Se usa cuando no conocemos los datos al crear el objeto.
     */
    public Producto() {
    }

    /**
     * Constructor completo.
     * Permite crear un producto con todos sus datos.
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
     * Calcula el precio final aplicando el IVA.
     */
    public static double calcularPrecioConIVA(double precio) {
        return precio * 1.21;
    }

    /**
     * Comprueba si hay stock disponible.
     */
    public static boolean hayStock(int stock) {
        return stock > 0;
    }
}
