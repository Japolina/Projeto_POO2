/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicMenuBarUI;

/**
 *
 * @author aluno.saolucas
 */
public class FRMenu extends javax.swing.JFrame {

    /**
     * Creates new form FRMenu
     */
    public FRMenu() {
        initComponents();
        this.setLocationRelativeTo(null);

        jMenuBar1.setOpaque(true);
        jMenuBar1.setUI(new BasicMenuBarUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });

        miCadUsuario.setOpaque(true);
        miCadUsuario.setBackground(Color.RED);
        miCadUsuario.setForeground(Color.BLACK);
        jMenuBar1.setBackground(Color.BLACK);
        
    }
//    menubar.setBackground(Color.RED); menu.setBackground(Color.yellow); menubar.setOpaque(true); menu.setOpaque(true);;
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miCadUsuario = new javax.swing.JMenuItem();
        miCadJogos = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        conUsuario = new javax.swing.JMenuItem();
        conJogos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("[ULBRA] - Menu Principal");
        setMinimumSize(new java.awt.Dimension(810, 510));
        setPreferredSize(new java.awt.Dimension(810, 510));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(84, 84, 84));
        jPanel1.setMinimumSize(new java.awt.Dimension(820, 520));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ulbra/img/phoenix.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 140, 256, 256);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ulbra/img/fundo.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-90, 0, 960, 460);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 520);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("Cadastros");

        miCadUsuario.setText("Usuários");
        miCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(miCadUsuario);

        miCadJogos.setText("Jogos");
        miCadJogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadJogosActionPerformed(evt);
            }
        });
        jMenu1.add(miCadJogos);

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        jMenu1.add(miSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Conultas");

        conUsuario.setText("Usuários");
        conUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(conUsuario);

        conJogos.setText("Jogos");
        conJogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conJogosActionPerformed(evt);
            }
        });
        jMenu2.add(conJogos);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");

        miSobre.setText("Sobre");
        miSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSobreActionPerformed(evt);
            }
        });
        jMenu3.add(miSobre);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCadJogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadJogosActionPerformed
        new FRCadJogos(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_miCadJogosActionPerformed

    private void miCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadUsuarioActionPerformed
        new FRCadUsu(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_miCadUsuarioActionPerformed

    private void conUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conUsuarioActionPerformed
        new FRConsu(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_conUsuarioActionPerformed

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_miSairActionPerformed

    private void miSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSobreActionPerformed
        new FRSobre(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_miSobreActionPerformed

    private void conJogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conJogosActionPerformed
        new FRConJogos (this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_conJogosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem conJogos;
    private javax.swing.JMenuItem conUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem miCadJogos;
    private javax.swing.JMenuItem miCadUsuario;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miSobre;
    // End of variables declaration//GEN-END:variables
}
