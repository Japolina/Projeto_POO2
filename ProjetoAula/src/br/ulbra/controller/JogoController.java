
package br.ulbra.controller;

import br.ulbra.model.Jogo;
import br.ulbra.model.JogoDAO;
import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.util.List;
import javax.swing.Icon;

/**
 *
    * @author Érica Yasmin
 */
public class JogoController {
    private JogoDAO  jogoDAO;
    
    public JogoController(){
        jogoDAO = new JogoDAO();
    }
    public boolean adicionarJogo(String nome, String genero, String produtora, String datalan, String classfi,
            Icon icone){
        try {
        return jogoDAO.adicionarJogo(nome, genero, produtora, datalan, classfi, icone);
        
        }catch (IOException ex){
            
            Logger.getLogger(
                    JogoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Jogo> readForDesc (int tipo, String desc){
        return jogoDAO.readForDesc(tipo, desc);
    }
    public Jogo readForPk (int pk){
        return jogoDAO.readForPk(pk);
    }
}
