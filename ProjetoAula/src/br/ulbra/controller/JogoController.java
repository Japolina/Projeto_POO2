
package br.ulbra.controller;

import br.ulbra.model.JogoDAO;

/**
 *
    * @author Érica Yasmin
 */
public class JogoController {
    private JogoDAO  jogodao;
    
    public JogoController(){
        jogoDAO = new JogoDAO();
    }
    public boolean adicionarUsuario(String nome, String genero, String produtora, String datalan, String classfi){
        return jogoDAO.adicionarJogo(nome, genero, produtora, datalan, classfi);
    }
}
