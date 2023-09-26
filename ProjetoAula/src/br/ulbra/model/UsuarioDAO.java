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
 */
public class UsuarioDAO {
    private GerenciadorConexao gerenciador;
    public UsuarioDAO() {
        this.gerenciador = GerenciadorConexao.getInstancia();
    }
    public boolean autenticar (String email, String senha){
        String sql = "SELECT * from TBUSUARIO WHERE emailUsu = ? and senhaUsu = ? and ativoUsu = 1";
        try {
            PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    public boolean adicionarUsuario(String nome, String email, String senha, String datan, int ativo){
        String sql = "INSERT into TBUSUARIO (nomeUsu, emailUsu, senhaUsu, dataNascUsu, ativoUsu)"
                + " VALUES (?,?,?,?,?)";

    try {
    PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
    stmt.setString(1, nome);
    stmt.setString(2, email);
    stmt.setString(3, senha);
    stmt.setString(4, datan);
    stmt.setInt(5, ativo);
    stmt.executeUpdate();
    JOptionPane.showMessageDialog(null, "Usuário: " + nome + " inserido com sucesso!");
    return true;
} catch (SQLException e){
    JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());   
        }
    return false;
    }
    public List<Usuario> read(){
        String sql = "SELECT * FROM tbusuario";
        List<Usuario> usuarios = new ArrayList<>();
        
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Usuario usuario = new Usuario();
                
                usuario.setPk(rs.getInt("pk_usuario"));
                usuario.setEmail(rs.getString("emailUsu"));
                usuario.setSenha(rs.getString("senhaUsu"));
                usuario.setDataNasc(rs.getString("dataNascUsu"));
                usuario.setAtivo(rs.getInt("ativoUsu"));
                
                usuarios.add(usuario);
            }
        } catch (SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }
    
    public List<Usuario> readForDesc(int tipo, String desc){
        String sql;
        
        if(tipo == 0 || tipo == 1)
        sql = "SELECT * FROM tbusuario WHERE nomeusu LIKE ?";
        else
        sql = "SELECT * FROM tbusuario WHERE emailusu LIKE ?";
        
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            
            if (tipo == 0 || tipo == 2)
            stmt.setString(1, desc+"%");
            else
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Usuario usuario = new Usuario();
                
                usuario.setPk(rs.getInt("pk_usuario"));
                usuario.setNome(rs.getString("nomeusu"));
                usuario.setEmail(rs.getString("emailusu"));
                usuario.setSenha(rs.getString("senhausu"));
                usuario.setDataNasc(rs.getString("datanascusu"));
                usuario.setAtivo(rs.getInt("ativousu"));
                usuarios.add(usuario);
            }
        }catch (SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }
    
    public Usuario readForPk(int pk){
        String sql = "SELECT * FROM tbusuario WHERE pk_usuario = ?";
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk);
            
            rs = stmt.executeQuery();
         
            while (rs.next()){
                
                usuario.setPk(rs.getInt("pk_usuario"));
                usuario.setNome(rs.getString("nomeusu"));
                usuario.setEmail(rs.getString("emailusu"));
                usuario.setSenha(rs.getString("senhausu"));
                usuario.setDataNasc(rs.getString("datanascusu"));
                usuario.setAtivo(rs.getInt("ativousu"));
            }
        }catch (SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        return usuario;
    }
    
        public boolean alterarUsuario(Usuario u){
            GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
            Connection con = gerenciador.getConexao();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("UPDATE tbusuario SET nomeusu = ?,"
                +" emailusu = ?, senhausu = ?, datanascusu = ?, ativousu = ? "
                +" WHERE pk_usuario = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getDataNasc());
            stmt.setInt(5, u.isAtivo());
            stmt.setInt(6, u.getPk());
            
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
        
        public boolean excluirUsuario(int pk){
            GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
            Connection con = gerenciador.getConexao();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("DELETE FROM tbusuario WHERE pk_usuario = ?");
            
            stmt.setInt(1, pk);
            
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
