package br.ulbra.model;

/**
 *
 * @author Érica Yasmin
 */
public class Usuario extends Pessoa {
    
    private String dataNasc;
    private String senha;
    
    
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getDataNasc (){
        return dataNasc;
    }
    public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
    }
    
    @Override
    public String toString(){
        return "Usuario{" + "pk_usuario=" + getPk() + ", nomeUsu=" + getNome() 
                + ", emailUsu=" + getEmail() + ", dataNascUsu=" + getDataNasc()
                + ", ativoUsu=" + isAtivo() + ", senhaUsu=" + getSenha() + '}';
    }
    
}
