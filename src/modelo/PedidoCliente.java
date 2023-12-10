package modelo;

// @author Robson Rosa

public class PedidoCliente {
    
    private int fk_codPedido;
    private int fk_codCliente;

    public PedidoCliente(int fk_codPedido, int fk_codCliente) {
        this.fk_codPedido = fk_codPedido;
        this.fk_codCliente = fk_codCliente;
    }

    public PedidoCliente() {
    }

    public int getFk_codPedido() {
        return fk_codPedido;
    }

    public void setFk_codPedido(int fk_codPedido) {
        this.fk_codPedido = fk_codPedido;
    }

    public int getFk_codCliente() {
        return fk_codCliente;
    }

    public void setFk_codCliente(int fk_codCliente) {
        this.fk_codCliente = fk_codCliente;
    }

    @Override
    public String toString() {
        return "PedidoCliente{" + "fk_codPedido=" + fk_codPedido + ", fk_codCliente=" + fk_codCliente + '}';
    }
    
    
}
