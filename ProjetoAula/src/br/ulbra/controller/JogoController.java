
package br.ulbra.controller;

import br.ulbra.model.Jogo;
import br.ulbra.model.JogoDAO;
import java.util.List;

/**
 *
    * @author Érica Yasmin
 */
public class JogoController {
    private JogoDAO  jogoDAO;
    
    public JogoController(){
        jogoDAO = new JogoDAO();
    }
    public boolean adicionarJogo(Jogo j){
        
        return jogoDAO.adicionarJogo(j);
    }
    
    public List<Jogo> readForDesc (int tipo, String desc){
        return jogoDAO.readForDesc(tipo, desc);
    }
    public Jogo readForPk (int pk) {
        return jogoDAO.readForPk(pk);
    }
    public boolean excluirJogo(int pkjogo){
         return jogoDAO.excluirJogo(pkjogo);
     }
    public boolean alterarJogo(Jogo j){
         return jogoDAO.alterarJogo(j);
     }
    public boolean carregarJogo (int pkjogo){
        return jogoDAO.carregarJogo(pkjogo);
    }
}
