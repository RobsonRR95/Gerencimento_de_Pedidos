
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

    ArrayList<Pedido> cadastro = new ArrayList<>();
       
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
           Pedido cNovo = (Pedido) obj;
           
           
           try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("UPDATE pedidos SET ativo='1' WHERE codPedido=?");
                                                                    
                 
                ps.setInt(1, cNovo.getCodPedido());
                                 
                ps.executeUpdate();        
                     
                conn.close();
     
                return true;            
                 
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui excluir o Pedido");
                System.out.println(ex);
           } 
        }
        return false;
    }

    //Em obj está o critério de pesquisa
    //Em obj vai estar o nome da pessoa
    //@Override
     public Object pesquisar(Object obj) {
        if (obj !=null){
            int cod = (int) obj;
            
            
             try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM pedidos WHERE codPedido=?");
                 
                ps.setInt(1, cod);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    
                Pedido c  = new Pedido();
                    
                c.setCodPedido(rs.getInt(1));
                c.setQtd_produto(rs.getFloat(2));
                c.setValor_produtos(rs.getInt(3));
                c.setEntrega(rs.getDate(4));
                c.setPagamento(rs.getBoolean(5));
                c.setData_pagamento(rs.getDate(6)); 
                                       
                    return c;
                }         
                    
                conn.close();
                
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui conectar o no BD");
                System.out.println(ex);
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
           Pedido p = (Pedido) obj;
           
           
           try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("UPDATE pedidos SET Qtd_produto=?, Valor_produtos=?, Pagamento=?, Data_pagamento=? WHERE codPedido=?");
                  
                ps.setInt(1, p.getCodPedido());
                ps.setFloat(2, p.getQtd_produto());
                ps.setFloat(3, p.getValor_produtos());
                ps.setDate(4, (Date) p.getEntrega());
                ps.setBoolean(5, p.isPagamento());
                ps.setDate(6, (Date) p.getData_pagamento()); 
                                 
                ps.executeUpdate();        
                     
                conn.close();
     
                return true;            
                 
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui alterar o pedido");
                System.out.println(ex);
           }
        }
        return false;
    }
      
   /*esse metodo lista todas as posições do ArrayList*/  
    public ArrayList<Pedido>list(){
        System.out.println("Entrou no listar pedidos");

        ArrayList <Pedido> minhaLista = new ArrayList<Pedido>();

            try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM pedidos");             
                ResultSet rs = ps.executeQuery();

                    while(rs.next()){  
                    Pedido c  = new Pedido ();
                    
                    c.setCodPedido(rs.getInt(1));
                    c.setQtd_produto(rs.getFloat(2));
                    c.setValor_produtos(rs.getInt(3));
                    c.setEntrega(rs.getDate(4));
                    c.setPagamento(rs.getBoolean(5));
                    c.setData_pagamento(rs.getDate(6));   
                    
                        System.out.println(c.getCodPedido());
                    
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
    public ArrayList<Pedido> getCadastro() {
        return cadastro;
    }

    @Override
    public Object pesquisar(long cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}

    

