package Beans;

import com.google.gson.annotations.Expose;
import java.util.Date;


/**
 *
 * @author Julian
 */

public class PedidoBean {
    
    // VARIABLES
    @Expose
    private int id;
    @Expose
    private int id_usuario;
    @Expose
    private Date fecha;

    // CONSTRUCTORES
    public PedidoBean(int id) {
        this.id = id;
    }

    public PedidoBean() {
    }

    
    // MÉTODOS FUNCIONALES
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
