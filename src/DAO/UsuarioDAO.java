package DAO;


import java.util.ArrayList;
import java.util.Iterator;
import modelo.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mk
 */
public class UsuarioDAO implements OperacoesDAO {

    ArrayList<Usuario> cadastro = new ArrayList<>();

    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Usuario p = (Usuario) obj;
            cadastro.add(p);
            return true;
        }
        return false;
    }

    @Override
    public boolean excluir(Object obj) {
        if (obj != null) {
            Usuario p = (Usuario) obj;
            cadastro.remove(p);
            return true;
        }
        return false;
    }

    @Override
    //Em obj está o critério de pesquisa
    //Em obj vai estar o nome da pessoa
    public Object pesquisar(Object obj) {
        if (obj !=null){
            String nome = (String) obj;
            for (int i =0; i< cadastro.size(); i++){
                Usuario p = (Usuario) cadastro.get(i);
                if (nome.equals(p.getNome())){
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    //Em obj está a Pessoa com os dados novos exceto o nome
    public boolean editar(Object obj) {
        if (obj !=null){
            Usuario pNovo = (Usuario) obj;
            Usuario pVelho = (Usuario) pesquisar(pNovo.getNome());
           int index = cadastro.indexOf(pVelho);
           cadastro.set(index, pNovo);
           return true;
        }
        return false;
    }
        
    public void listar(){
        Iterator it = cadastro.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        
    }

    public ArrayList<Usuario> getCadastro() {
        return cadastro;
    }
    
    

}
