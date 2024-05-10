package isi.dan.app01.dto;

public class ValorGeneradoDTO {
    public Integer minimo;
    public Integer maximo;
    public String usuario;
    public Integer valorGenerado;
    
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
    public Integer getValorGenerado() {
        return valorGenerado;
    }
    public void setValorGenerado(Integer valorGenerado) {
        this.valorGenerado = valorGenerado;
    }
    @Override
    public String toString() {
        return "ValorGeneradoDTO [minimo=" + minimo + ", maximo=" + maximo + ", usuario=" + usuario + ", valorGenerado="
                + valorGenerado + "]";
    }

    
}
