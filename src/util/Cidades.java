/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Marcio Almeida
 */
public enum Cidades {
    OSORIO(1,"Osório","RS",95520000),
    TRAMANDAI(2,"Tramandaí","RS",955210000),
    XANGRILA(3,"Xangri-lá","RS",955220000),
    TORRES(4,"Torres","RS",95523000);
    
    private int valor;
    private String nome;
    private String estado;
    private long cep;

    private Cidades(int valor, String nome, String estado, long cep) {
        this.valor = valor;
        this.nome = nome;
        this.estado = estado;
        this.cep = cep;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Cidades{" + "valor=" + valor + ", nome=" + nome + ", estado=" + estado + ", cep=" + cep + '}';
    }
    
    
    
    
    
}
