package modelo;

// @author Robson Rosa

import java.util.Date;


public class Pedido {

    private int codPedido;
    private float qtd_produto;
    private float valor_produtos;
    private Date entrega;
    private boolean pagamento;
    private Date data_pagamento;

    public Pedido(int codPedido, float qtd_produto, float valor_produtos, Date entrega, boolean pagamento, Date data_pagamento) {
        this.codPedido = codPedido;
        this.qtd_produto = qtd_produto;
        this.valor_produtos = valor_produtos;
        this.entrega = entrega;
        this.pagamento = pagamento;
        this.data_pagamento = data_pagamento;
    }

    public Pedido() {
    }

    /**
     * @return the codPedido
     */
    public int getCodPedido() {
        return codPedido;
    }

    /**
     * @param codPedido the codPedido to set
     */
    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    /**
     * @return the qtd_produto
     */
    public float getQtd_produto() {
        return qtd_produto;
    }

    /**
     * @param qtd_produto the qtd_produto to set
     */
    public void setQtd_produto(float qtd_produto) {
        this.qtd_produto = qtd_produto;
    }

    /**
     * @return the valor_produtos
     */
    public float getValor_produtos() {
        return valor_produtos;
    }

    /**
     * @param valor_produtos the valor_produtos to set
     */
    public void setValor_produtos(float valor_produtos) {
        this.valor_produtos = valor_produtos;
    }

    /**
     * @return the entrega
     */
    public Date getEntrega() {
        return entrega;
    }

    /**
     * @param entrega the entrega to set
     */
    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    /**
     * @return the pagamento
     */
    public boolean isPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * @return the data_pagamento
     */
    public Date getData_pagamento() {
        return data_pagamento;
    }

    /**
     * @param data_pagamento the data_pagamento to set
     */
    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codPedido=" + codPedido + ", qtd_produto=" + qtd_produto + ", valor_produtos=" + valor_produtos + ", entrega=" + entrega + ", pagamento=" + pagamento + ", data_pagamento=" + data_pagamento + '}';
    }
    
    
}
