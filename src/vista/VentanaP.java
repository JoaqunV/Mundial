

package vista;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Escar
 * 
 * VentanaP es la ventana padre utilizada como menu y base para llamar a las demas ventanas
 * se muestra por pantalla y permite interaccion con el usuario
 * 
 */

public class VentanaP extends javax.swing.JFrame {
    

    public VentanaP() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        botonPartido = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FIFA World Cup Brasil 2014 Simulator");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setResizable(false);

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(1024, 700));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(1024, 700));
        jLayeredPane1.setName("Mundial Brazil 2014 Simulator"); // NOI18N
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonPartido.setFont(new java.awt.Font("Brazil 2014", 0, 36)); // NOI18N
        botonPartido.setText("Partido");
        botonPartido.setToolTipText("");
        botonPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPartidoActionPerformed(evt);
            }
        });
        jLayeredPane1.add(botonPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 220, 50));

        jButton2.setFont(new java.awt.Font("Brazil 2014", 0, 36)); // NOI18N
        jButton2.setText("Grupos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 220, 50));

        jButton3.setFont(new java.awt.Font("Brazil 2014", 0, 24)); // NOI18N
        jButton3.setText("Segunda Fase");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 220, 50));

        jButton4.setFont(new java.awt.Font("Brazil 2014", 0, 36)); // NOI18N
        jButton4.setText("Mundial");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 220, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/banner_02.jpg"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 270));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/logo-copa.png"))); // NOI18N
        jLayeredPane1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/futbol2.gif"))); // NOI18N
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 400, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLayeredPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPartidoActionPerformed
        try {
            VentanaPartidos window=new VentanaPartidos(this,true);
            window.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonPartidoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            VentanaGrupos window=new VentanaGrupos(this,true);
            window.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            VentanaSegunda window=new VentanaSegunda(this,true);
            window.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            VentanaMundial window=new VentanaMundial(this,true);
            window.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPartido;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
