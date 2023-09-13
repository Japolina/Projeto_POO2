package br.ulbra.model;

/**
 *
 * @author Érica Yasmin
 */
public class Usuario {
    private int pk_usuario;
    private String nomeUsu;
    private String emailUsu;
    private String dataNascUsu;
    private int ativoUsu;
    private String senhaUsu;
    
    public int getPkUsuario(){
        return pk_usuario;
    }
    public void setPkUsuario(int pk_usuario){
        this.pk_usuario = pk_usuario;
    }
    public String getNomeUsu(){
        return nomeUsu;
    }
    public void setNomeUsu (String nomeUsu){
        this.nomeUsu = nomeUsu;
    }
    public String getEmailUsu(){
        return emailUsu;
    }
    public void setEmailUsu(String emailUsu){
        this.emailUsu = emailUsu;
    }
    public String getSenhaUsu(){
        return senhaUsu;
    }
    public void setSenhaUsu(String senhaUsu){
        this.senhaUsu = senhaUsu;
    }
    public String getDataNascUsu (){
        return dataNascUsu;
    }
    public void setDataNascUsu (String dataNascUsu){
        this.dataNascUsu = dataNascUsu;
    }
    public int isAtivoUsu(){
        return ativoUsu;
    }
    public void setAtivoUsu (int ativoUsu){
        this.ativoUsu = ativoUsu;
    }
    @Override
    public String toString(){
        return "Usuario{" + "pk_usuario=" + pk_usuario + ", nomeUsu=" + nomeUsu 
                + ", emailUsu=" + emailUsu + ", dataNascUsu=" + dataNascUsu
                + ", ativoUsu=" + ativoUsu + ", senhaUsu=" + senhaUsu + '}';
    }
}
