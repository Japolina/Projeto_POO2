
package br.ulbra.model;

import br.ulbra.utils.Utils;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    public boolean adicionarJogo(Jogo j){
        String sql = "INSERT into TBJOGOS(nomeJogo, generoJogo, produtoraJogo, dataLanJogo, classfiJogo"
                + ", imagemJogo)"
                + " VALUES (?,?,?,?,?, ?)";

    try {
        byte[] iconBytes = Utils.iconToBytes(j.getImagemJogo());
        
    PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
    stmt.setString(1, j.getNomeJogo());
    stmt.setString(2, j.getGeneroJogo());
    stmt.setString(3, j.getProdutoraJogo());
    stmt.setString(4, j.getDataLanJogo());
    stmt.setString(5, j.getClassfiJogo());
    stmt.setBytes(6, iconBytes);
    stmt.executeUpdate();
    JOptionPane.showMessageDialog(null, "Jogo: " + j.getNomeJogo() + " inserido com sucesso!");
    return true;
} catch (SQLException e){
    JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());   
        }catch (IOException e){
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
                
                jogo.setPk_Jogo(rs.getInt("pk_jogo"));
                jogo.setGeneroJogo(rs.getString("generoJogo"));
                jogo.setProdutoraJogo(rs.getString("produtoraJogo"));
                jogo.setDataLanJogo(rs.getString("dataLanJogo"));
                jogo.setClassfiJogo(rs.getString("classfiJogo"));
                
                jogos.add(jogo);
            }
        } catch (SQLException ex){
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        return jogos;
    }
    
    public List<Jogo> readForDesc(int tipo, String desc){
        String sql;
        
        if(tipo == 0 || tipo == 1)
        sql = "SELECT * FROM tbjogos WHERE nomejogo LIKE ?";
        else
        sql = "SELECT * FROM tbjogos WHERE generojogo LIKE ?";
        
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Jogo> jogos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            
            if (tipo == 0 || tipo == 2)
            stmt.setString(1, desc+"%");
            else
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Jogo jogo = new Jogo();
                
                jogo.setPk_Jogo(rs.getInt("pk_jogo"));
                jogo.setGeneroJogo(rs.getString("generoJogo"));
                jogo.setProdutoraJogo(rs.getString("produtoraJogo"));
                jogo.setDataLanJogo(rs.getString("dataLanJogo"));
                jogo.setClassfiJogo(rs.getString("classfiJogo"));
            }
        }catch (SQLException ex){
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        return jogos;
    }
    
    public Jogo readForPk(int pk){
        String sql = "SELECT * FROM tbjogos WHERE pk_jogo = ?";
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jogo jogo = new Jogo();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk);
            
            rs = stmt.executeQuery();
         
            while (rs.next()){
                
                jogo.setPk_Jogo(rs.getInt("pk_jogo"));
                jogo.setGeneroJogo(rs.getString("generoJogo"));
                jogo.setProdutoraJogo(rs.getString("produtoraJogo"));
                jogo.setDataLanJogo(rs.getString("dataLanJogo"));
                jogo.setClassfiJogo(rs.getString("classfiJogo"));
                
                byte[] bytes = rs.getBytes("imagemJogo");
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                BufferedImage imagem = ImageIO.read(bis);
                
                jogo.setImagemJogo(new ImageIcon(imagem));
            }
        }catch (SQLException ex){
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        return jogo;
    }
    
    public static Icon fileParaIcon(File file){
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        return icon;
    }
    public static ImageIcon redimencionarIcon(Icon originalIcon,
            int largura, int altura){
        Image imagemOriginal = ((ImageIcon) originalIcon).getImage();
        Image novaImagem = imagemOriginal.getScaledInstance(
        largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(novaImagem);
    }
    
    public boolean alterarJogo(Jogo j){
            GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
            Connection con = gerenciador.getConexao();
            PreparedStatement stmt = null;
            
            try {
                
                byte[] iconBytes = Utils.iconToBytes(j.getImagemJogo());
                
                stmt = con.prepareStatement("UPDATE tbjogo SET nomejogo = ?,"
                +" generojogo = ?, produtorajogo = ?, datalanjogo = ?, classfijogo = ?"
                        + ", imagemjogo = ? WHERE pk_jogo = ?");
            stmt.setString(1, j.getNomeJogo());
            stmt.setString(2, j.getGeneroJogo());
            stmt.setString(3, j.getProdutoraJogo());
            stmt.setString(4, j.getDataLanJogo());
            stmt.setString(5, j.getClassfiJogo());
            stmt.setInt(6, j.getPk_jogo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            return true;
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            }finally {
                GerenciadorConexao.closeConnection(con, stmt);
            }
            return false;
        }
    
    public boolean excluirJogo(int pkjogo){
            GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
            Connection con = gerenciador.getConexao();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("DELETE FROM tbjogos WHERE pk_jogo = ?");
            
            stmt.setInt(1, pkjogo);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            return true;
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            }finally {
                GerenciadorConexao.closeConnection(con, stmt);
            }
            return false;
        }
}
