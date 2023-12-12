
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
import modelo.PedidoCliente;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mk
 */
public class PedidoClienteDAO {

    ArrayList<PedidoCliente> cadastro = new ArrayList<>();
       
        /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	salva no final da tabela cliente*/

    public boolean inserir(Object obj) {
        if (obj != null) {
            PedidoCliente pc = (PedidoCliente) obj;
             System.out.println("entrou no inserir PedidoCliente"); 
            try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                    PreparedStatement ps;
                ps = conn.prepareStatement("INSERT INTO pedido_cliente (fk_codPedido, fk_codCliente) VALUES (?,?)");
                
                ps.setInt(1,  pc.getFk_codPedido());
                ps.setInt(2,  pc.getFk_codCliente());
                
                ps.executeUpdate(); 
                
                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(PedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return true;
        }
        return false;
    }


    /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	busca o cod do cliente, 
	seta o Ativo como false e grava na mesma posição da tabela cliente*/

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

     public Object pesquisar(Object obj) {
        if (obj !=null){
            int cod = (int) obj;
            
            
             try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("SELECT fk_codCliente FROM pedido_cliente WHERE fk_codPedido = ?");
                 
                ps.setInt(1, cod);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    
                PedidoCliente c  = new PedidoCliente();
                    
                c.setFk_codCliente(rs.getInt(1));
                c.setFk_codPedido(cod);
                
                                       
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
    public ArrayList<PedidoCliente> list(){

        ArrayList<PedidoCliente> minhaLista = new ArrayList<PedidoCliente>();

            try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM pedido_cliente");             
                ResultSet rs = ps.executeQuery();
                             
                PedidoCliente pc  = new PedidoCliente();
                
                while(rs.next()){ 
                    
                    pc.setFk_codPedido(rs.getInt(1));
                    pc.setFk_codCliente(rs.getInt(2));
                    
                    minhaLista.add(pc);
                    
                }   
               
                conn.close();
                
           } catch (SQLException ex) {
                System.out.println("Erro: Não consegui listar os clientes");
                System.out.println(ex);
           } 
            
         return minhaLista; 
    }

    // esse metodo retorna o cadastro
    public ArrayList<PedidoCliente> getCadastro() {
        return cadastro;
    }

    

}
