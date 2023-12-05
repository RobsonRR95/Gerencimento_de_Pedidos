package modelo;


/**
*
* @author Marcio
*/
public abstract class ModelPessoa {

    private String nome;
    private long cpf;
    private long rg;
    private String endereco;
    private int numero;
    private String estado;
    private long telefone;
    private String sexo;
    private boolean ativo;
    private String obs;
    private String bairro;
    private String cidade;
    private int apto;
    private long cep;

    public long getRg() {
        return rg;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getApto() {
        return apto;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setApto(int apto) {
        this.apto = apto;
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
 
    public void setNome(String pNome){
        this.nome = pNome;
    }
   
    public String getNome(){
        return this.nome;
    }

 
    public void setCpf(long pCpf){
        this.cpf = pCpf;
    }
 
    public long getCpf(){
        return this.cpf;
    }

  
    public void setEnderco(String pEnderco){
        this.endereco = pEnderco;
    }
 
    public String getEnderco(){
        return this.endereco;
    }

  
    public void setSexo (String pSexo){
        this.sexo = pSexo;
    }
  
    public String getSexo(){
        return this.sexo;
    }

  
    public void setAtivo(boolean pAtivo){
        this.ativo = pAtivo;
    }
   
    public boolean isAtivo(){
        return this.ativo;
    }

    @Override
    public String toString() {
        return "ModelPessoa{" + "nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", endereco=" + endereco + ", numero=" + numero + ", estado=" + estado + ", obs=" + obs + ", bairro=" + bairro + ", cidade=" + cidade + ", apto=" + apto + ", telefone=" + telefone + ", sexo=" + sexo + ", ativo=" + ativo + '}';
    }

    public abstract void gerarCod(Object obj);
    
      public ModelPessoa(){
    }   
    
    public ModelPessoa(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}
