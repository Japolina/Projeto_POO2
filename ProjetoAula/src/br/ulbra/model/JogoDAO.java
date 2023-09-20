
package br.ulbra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica Yasmin
 * (nomeJogo, generoJogo, produtoraJogo, dataLanJogo, classfiJogo)
 */ 
public class JogoDAO {
    private GerenciadorConexao gerenciador;
    public JogoDAO() {
    this.gerenciador = GerenciadorConexao.getInstancia();
    }
    public boolean adicionarJogo(String nome, String genero, String produtora, String datalan, String classfi){
        String sql = "INSERT into TBJOGOS(nomeJogo, generoJogo, produtoraJogo, dataLanJogo, classfiJogo)"
                + " VALUES (?,?,?,?,?)";

    try {
    PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
    stmt.setString(1, nome);
    stmt.setString(2, genero);
    stmt.setString(3, produtora);
    stmt.setString(4, datalan);
    stmt.setString(5, classfi);
    stmt.executeUpdate();
    JOptionPane.showMessageDialog(null, "Jogo: " + nome + " inserido com sucesso!");
    return true;
} catch (SQLException e){
    JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());   
        }
    return false;
    }
    
    
    public List<Jogo> read(){
        String sql = "SELECT * FROM tbjogos";
        List<Jogo> jogos = new ArrayList<>();
        
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Jogo jogo = new Jogo();
                
                jogo.setPkJogo(rs.getInt("pk_jogo"));
                jogo.setGeneroJogo(rs.getString("generoJogo"));
                jogo.setProdutoraJogo(rs.getString("produtoraJogo"));
                jogo.setDataLan(rs.getString("dataLanJogo"));
                jogo.setClassfi(rs.getInt("classfiJogo"));
                
                jogo.add(jogo);
            }
        } catch (SQLException ex){
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        return jogos;
    }
}
