
package br.ulbra.controller;

import br.ulbra.model.UsuarioDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica Yasmin
 */
public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    public UsuarioController(){
        usuarioDAO = new UsuarioDAO();
    }
    public boolean autenticar (String email, String senha){
        if (usuarioDAO.autenticar(email,senha)){
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta");
            return false;
        }
        public boolean adicionarUsuario(String nome, String email, String senha, String datan, int ativo){
        String sql = "INSERT into TBUSUARIO (nomeUsu, emailUsu, senhaUsu, dataNascUsu, ativoUsu, +"
                + "VALUES (?,?,?,?,?)";
        
    }
 }
    
