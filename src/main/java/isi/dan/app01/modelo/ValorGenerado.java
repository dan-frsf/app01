package isi.dan.app01.modelo;

import java.time.Instant;

public class ValorGenerado {
    
    private Integer valor;
    private Instant fechaGeneracion;
    private Integer minimo;
    private Integer maximo;
    private String usuario;
    
    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
    public Instant getFechaGeneracion() {
        return fechaGeneracion;
    }
    public void setFechaGeneracion(Instant fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
    public Integer getMinimo() {
        return minimo;
    }
    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }
    public Integer getMaximo() {
        return maximo;
    }
    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "ValorGenerado [valor=" + valor + ", fechaGeneracion=" + fechaGeneracion + ", minimo=" + minimo
                + ", maximo=" + maximo + ", usuario=" + usuario + "]";
    }

    
}
