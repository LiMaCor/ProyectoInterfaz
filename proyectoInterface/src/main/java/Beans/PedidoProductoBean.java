/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import com.google.gson.annotations.Expose;

/**
 *
 * @author Kysuke
 */
public class PedidoProductoBean {

    @Expose
    private int id_pedido;
    @Expose
    private int id_producto;
    @Expose
    private int cantidad;

    public PedidoProductoBean(int id_pedido, int id_producto) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
    }

    public PedidoProductoBean() {
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
