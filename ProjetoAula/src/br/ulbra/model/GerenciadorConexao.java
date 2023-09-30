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
//nomeJogo varchar(100) not null,
//generoJogo varchar(30) not null,
//produtoraJogo varchar(40) not null,
//dataLanJogo varchar(10) not null,
//classfiJogo varchar(3) not null,
//imagemJogo blob(5242880),
//descricaoJogo varchar(1000) not null
// );

//---------------texto jogo-----------------------
// Resident evil 2
//Resident Evil 2 Remake é o retorno do clássico da Capcom de PlayStation 1 para PS4, PC (Steam) e Xbox One com lançamento em 25 de janeiro. Leon e Clair estão de volta na história, assim como no original, porém novos elementos de jogabilidade e perspectiva de visão que começou a ser utilizada em Resident Evil 4 foram adicionados. Na análise a seguir, o jogo de terror assombra com gráficos realistas, zumbis inéditos, Mister X e uma Racoon City reformulada.
//
// Valorant
//Valorant é um jogo FPS da Riot Games, a mesma desenvolvedora do League of Legends (LoL), disponível paradownload grátis no PC (Windows). O título conta com um elenco de personagens com habilidades específicas e mapas, onde o objetivo é ativar um bomba ou defender um território. Os times começam a partida com ataque ou defesa, e trocam de lado na décima segunda rodada. Vence a equipe que fizer 13 pontos primeiro, e os jogos têm até 24 rounds. O game tem uma economia parecida com a do CS:GO e disponibiliza diversos armamentos para compra no início de cada rodada. Veja miras (crosshair) de Valorant, com configurações de pro players para usar no jogo, neste tutorial. Os personagens têm habilidades específicas que também podem ser liberadas na loja. Confira melhores personagens de Valorant e suas habilidades para iniciantes.

//Red Dead Redemption 2
//A história se passa em 1899 em uma representação ficcional do oeste, meio-oeste e sul dos Estados Unidos e acompanha o fora da lei Arthur Morgan, que precisa lidar com o declínio do Velho Oeste e sobreviver à perseguição de forças governamentais, gangues rivais e outros adversários. Red Dead Redemption 2 é um jogo de faroeste de ação-aventura ambientado em um mundo aberto e jogado a partir de uma perspectiva de terceira e primeira pessoa, com componentes de singleplayer e multiplayer online. O jogo tem novas opções, ausentes no jogo anterior. 
