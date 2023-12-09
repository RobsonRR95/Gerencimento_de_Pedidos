/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import javax.swing.DefaultComboBoxModel;
import util.Cidades;

    public class CidadesComboBoxModel extends DefaultComboBoxModel<String>{
        public CidadesComboBoxModel(){
            for(Cidades cidade : Cidades.values()){
                addElement(cidade.getNome());
            }
        }

   

    
}
    

