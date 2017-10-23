package Beans;

import com.google.gson.annotations.Expose;

/**
 *
 * @author Julian
 */
public class ProductoBean {

    // VARIABLES
    @Expose
    private int id;
    @Expose
    private String nombre;
    @Expose
    private int cantidad;
    @Expose
    private double precio;

    // CONSTRUCTORES
    public ProductoBean(int id) {
        this.id = id;
    }

    public ProductoBean() {
    }

    
    // MÉTODOS FUNCIONALES
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
