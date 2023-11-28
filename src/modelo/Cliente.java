/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import DAO.ClienteDAO;
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
        
       ArrayList<Cliente> c  = (ArrayList<Cliente>) obj;
        
       if (c != null) {
         this.codCliente = c.size();
       }
    }
    
    
}
