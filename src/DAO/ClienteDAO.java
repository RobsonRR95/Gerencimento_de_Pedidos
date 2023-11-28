
package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelo.Cliente;
import connection.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mk
 */
public class ClienteDAO implements OperacoesDAO {

    ArrayList<Cliente> cadastro = new ArrayList<>();
       
        /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	salva no final do ArrayList*/
    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente p = (Cliente) obj;
             System.out.println("entrou no inserir"); 
            try {
                Connection conn = ConexaoMySQL.getConexaoMySQL();
                    PreparedStatement ps;
                ps = conn.prepareStatement("INSERT INTO pessoas (cpf, rg, endereco, numero, estado, telefone, ativo, obs, bairro, cidade, apto, cep, nome) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setLong(1, p.getCpf());
                ps.setLong(2, p.getRg());
                ps.setString(3, p.getEndereco());
                ps.setInt(4,  p.getNumero());
                ps.setString (5, p.getEstado());
                ps.setLong(6, p.getTelefone());
                ps.setBoolean(7,  p.isAtivo());
                ps.setString(8, p.getObs());
                ps.setString(9, p.getBairro());
                ps.setString(10, p.getCidade());
                ps.setInt(11, p.getApto());
                ps.setLong(12, p.getCep());
                ps.setString(13, p.getNome());
                
                ps.executeUpdate(); 
                
                conn = ConexaoMySQL.getConexaoMySQL();
                    
                PreparedStatement ps1 = conn.prepareStatement("INSERT INTO clientes (fk_Cpf, qntPedidos, divida, credito) VALUES (?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);

                ps1.setDouble(1, p.getCpf());
                ps1.setDouble(2, p.getQntPedidos());
                ps1.setDouble(3, p.getDivida());
                ps1.setDouble(4, p.getCredito());
                
                int rowcount = ps1.executeUpdate(); 
                
                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        return true;
        }
        return false;
    }


    /*esse metodo recebe um objeto, verifica se não é nulo, 
	converte para Cliente ;
	busca o cod do cliente, 
	seta o Ativo como false e grava na mesma posição do ArrayList*/
    @Override
    public boolean excluir(Object obj) {
        if (obj !=null){
           Cliente pNovo = (Cliente) obj;
           int index = pNovo.getCodCliente() -1;
           pNovo.setAtivo(false);
           cadastro.set(index, pNovo);
           return true;
        }
        return false;
    }

    //Em obj está o critério de pesquisa
    //Em obj vai estar o nome da pessoa
    @Override
     public Object pesquisar(Object obj) {
        if (obj !=null){
            int cod = (int) obj;
            for (int i =0; i< cadastro.size(); i++){
                Cliente p = (Cliente) cadastro.get(i);
                if (cod==p.getCodCliente()){
                    return p;
                }
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
           Cliente pNovo = (Cliente) obj;
           int index = pNovo.getCodCliente() -1;
           cadastro.set(index, pNovo);
           return true;
        }
        return false;
    }
      
   /*esse metodo lista todas as posições do ArrayList*/  
    public void listar(){
        Iterator it = cadastro.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        
    }

    // esse metodo retorna o cadastro
    public ArrayList<Cliente> getCadastro() {
        return cadastro;
    }
    
    

}
