/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Convidado
 */
public class Usuario extends ModelPessoa {
    
    private int codUsuario;
    private String nomeUsuario;
    private String senha;
    private String dataCadastro;

    public Usuario(String nomeUsuario, String senha, String dataCadastro) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }
    
    public Usuario(){
        
    }

    @Override
    public void gerarCod(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
