/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import DAO.ClienteDAO;
import connection.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Convidado
 */
public class Cliente extends ModelPessoa {
    private int codCliente = 0;
    private int qntPedidos;
    private double divida;
    private double credito;
    

    public Cliente(String nome, long cpf) {
        super(nome, cpf);
    }

    public Cliente() {
        
    }
    
    
    
    /**
     *
     * @param codCliente
     */

   public void setCodCliente(int codCliente){
       this.codCliente = codCliente;
   }
    
    public int getCodCliente() {
        return codCliente;
    }

    public int getQntPedidos() {
        return qntPedidos;
    }

    public void setQntPedidos(int qntPedidos) {
        this.qntPedidos = qntPedidos;
    }

    public double getDivida() {
        return divida;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
    
    @Override
    public void gerarCod(Object obj ) {
        
    try (Connection conn = ConexaoMySQL.getConexaoMySQL()) {
            PreparedStatement ps = conn.prepareStatement("SELECT count(*) FROM clientes");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Extrai o valor do ResultSet e atribui à variável codCliente
                this.codCliente = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não consegui gerar o número do pedido");
            System.out.println(ex);
        }
    }
    
    
}
