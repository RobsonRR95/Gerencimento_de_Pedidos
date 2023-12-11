
package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ModelPessoa;
import connection.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pedido;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mk
 */
public class PedidoDAO implements OperacoesDAO {

    ArrayList<Cliente> cadastro = new ArrayList<>();
       
        /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Pedido ;
	salva no final da tabela Pedido*/
    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Pedido p = (Pedido) obj;
             System.out.println("entrou no inserir Pedido"); 
            try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                    PreparedStatement ps;
                ps = conn.prepareStatement("INSERT INTO pedidos (qtd_produto, valor_produtos, entrega, pagamento, data_pagamento) VALUES (?,?,?,?,?)");
                //ps.setInt(1, p.getCodPedido());
                ps.setFloat(1, p.getQtd_produto());
                ps.setFloat(2, p.getValor_produtos());
                // Converter java.util.Date para java.sql.Date
                java.sql.Date sqlDataEmtrega = new java.sql.Date(p.getEntrega().getTime());
                ps.setDate(3, sqlDataEmtrega);
                ps.setBoolean(4, p.isPagamento());
                // Converter java.util.Date para java.sql.Date
                java.sql.Date sqlDataPagamento = new java.sql.Date(p.getData_pagamento().getTime());
                ps.setDate(5, sqlDataPagamento);
                
                ps.executeUpdate(); 
                
                conn = ConexaoMySQL.getConexaoMySQL();
                              
                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return true;
        }
        return false;
    }


    /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	busca o cod do cliente, 
	seta o Ativo como false e grava na mesma posição da tabela cliente*/
    @Override
    public boolean excluir(Object obj) {
        if (obj !=null){
           Cliente cNovo = (Cliente) obj;
           
           
           try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("UPDATE pessoas SET ativo='1', inativo=? WHERE cpf=?");
                                                                    
                ps.setString(1,cNovo.getInativo()); 
                ps.setLong(2, cNovo.getCpf());
                
                                 
                int rowCount = ps.executeUpdate();  
                
                
                conn.close();
     
                return true;            
                 
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui excluir o cliente");
                System.out.println(ex);
           } 
        }
        return false;
    }

    //Em obj está o critério de pesquisa
    //Em obj vai estar o nome da pessoa
    @Override
     public Object pesquisar(long cpf) {
        //if (obj !=null){
            //int cod = (int) obj;
            
            
             try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM pessoas WHERE cpf=?");
                 
                ps.setLong(1, cpf);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    
                    cpf = rs.getLong(1);
                    String nome = rs.getString(3);
                    
                    Cliente c  = new Cliente(nome, cpf);
                    
                    c.setRg(rs.getLong(2));
                    c.setEndereco(rs.getString(4));
                    c.setNumero(rs.getInt(5));
                    c.setEstado(rs.getString(6));
                    c.setTelefone(rs.getLong(7));
                    c.setAtivo(rs.getBoolean(8));
                    c.setObs(rs.getString(9));
                    c.setBairro(rs.getString(10));
                    c.setCidade(rs.getString(11));
                    c.setApto(rs.getInt(12));
                    c.setCep(rs.getInt(13));
                                       
                    return c;
                }         
                    
                conn.close();
                
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui conectar o no BD");
                System.out.println(ex);
           } 
            for (int i =0; i< cadastro.size(); i++){
                Cliente p = (Cliente) cadastro.get(i);
                if (cpf==p.getCodCliente()){
                    return p;
                }
            }
        
        return null;
    }


    /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	busca o cod do cliente, 
	seta o objeto todo na mesma posição do ArrayList*/
    @Override
    public boolean editar(Object obj) {
        if (obj !=null){
           Cliente cNovo = (Cliente) obj;
           
           
           try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("UPDATE pessoas SET rg=?, nome=?, endereco=?, numero=?, estado=?, telefone=?, ativo=?, obs=?, bairro=?, cidade=?, apto=?, cep=? WHERE cpf=?");
                  
                
                ps.setLong(1, cNovo.getRg());
                ps.setString(2, cNovo.getNome());
                ps.setString(3, cNovo.getEndereco());
                ps.setInt(4, cNovo.getNumero());
                ps.setString(5, cNovo.getEstado());
                ps.setLong(6,cNovo.getTelefone());
                ps.setBoolean(7, cNovo.isAtivo());
                ps.setString(8, cNovo.getObs());
                ps.setString(9,cNovo.getBairro());
                ps.setString(10, cNovo.getCidade());
                ps.setInt(11, cNovo.getApto());
                ps.setLong(12, cNovo.getCep());
                ps.setLong(13, cNovo.getCpf());
                                 
                int rowCount = ps.executeUpdate();        
                     
                conn.close();
     
                return true;            
                 
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui alterar o cliente");
                System.out.println(ex);
           }
        }
        return false;
    }
      
   /*esse metodo lista todas as posições do ArrayList*/  
    public ArrayList<Cliente> list(){

        ArrayList <Cliente> minhaLista = new ArrayList<Cliente>();

            try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM pessoas");             
                ResultSet rs = ps.executeQuery();
                
                PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM clientes");             
                ResultSet rs2 = ps2.executeQuery();
                
                Cliente c  = new Cliente();
                
                while(rs.next() && rs2.next()){ 
                    long cpf = rs.getLong(1);
                    c = new Cliente(rs.getString(3), cpf);
                    //c.setNome(rs.getString(3));
                    c.setRg(rs.getLong(2));
                    c.setEndereco(rs.getString(4));
                    c.setNumero(rs.getInt(5));
                    c.setEstado(rs.getString(6));
                    c.setTelefone(rs.getLong(7));
                    c.setAtivo(rs.getBoolean(8));
                    c.setObs(rs.getString(9));
                    c.setBairro(rs.getString(10));
                    c.setCidade(rs.getString(11));
                    c.setApto(rs.getInt(12));
                    c.setCep(rs.getInt(13));
                    c.setInativo(rs.getString(14));
                    
                    c.setCodCliente(rs2.getInt(1));
                    c.setQntPedidos(rs2.getInt(3));
                    c.setDivida(rs2.getFloat(4));
                    c.setCredito(rs2.getFloat(5));
                   
                    minhaLista.add(c);
                    
                }   
               
                conn.close();
                
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui listar os clientes");
                System.out.println(ex);
           } 
            
         return minhaLista; 
    }

    // esse metodo retorna o cadastro
    public ArrayList<Cliente> getCadastro() {
        return cadastro;
    }
    
    

}
