package br.ulbra.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno.saolucas
 */
public class GerenciadorConexao {

    private static final String URL = "jdbc:mysql://localhost:3306/dbprojeto";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private static GerenciadorConexao instancia;
    private Connection conexao;

    private GerenciadorConexao() {
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static synchronized GerenciadorConexao getInstancia() {
        try {
            if ((instancia == null) || (instancia.conexao.isClosed())) {
                instancia = new GerenciadorConexao();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciadorConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciadorConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciadorConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciadorConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
//-------------- MYSQL -----------------------------

//create database dbprojeto;
//use dbprojeto;
//
//create table tbusuario (
//	pk_usuario int primary key auto_increment,
//    nomeUsu varchar(60) not null,
//    emailUsu varchar(40) not null unique,
//    senhaUsu varchar(30) not null,
//    dataNascUsu varchar(10) not null,
//    ativoUsu tinyint not null
//);
//
//insert into tbusuario (nomeUsu, emailUsu, senhaUsu, dataNascUsu, ativoUsu) 
//values ("adm", "adm@adm.com", "123", "01/01/2000", 1);

//------------------ JOGOS ----------------------------
//create table tbJogos (
//pk_jogo int primary key auto_increment,
//nomeJogo varchar(80) not null,
//generoJogo varchar(30) not null,
//produtoraJogo varchar(40) not null,
//dataLanJogo varchar(10) not null,
//classfiJogo varchar(3) not null,
//imagemJogo blob(5242880),
//descricaoJogo varchar(1000) not null
// );