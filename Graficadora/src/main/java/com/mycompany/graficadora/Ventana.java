package com.mycompany.graficadora;

import java.awt.Color;
import javax.swing.DefaultListModel;

public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Graphics
     */
    private Lienzo lienzo;
    private int idActual;
    private int caso; //Variable Switch para dibujar continuo o segementado.
    DefaultListModel<Integer> modeloLista = new DefaultListModel<>();
    private int idUltimo;

    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null); // Para centrar el frame
        lienzo = new Lienzo(this.jPanel1);
        idActual = 0;
        caso = 0;
        idUltimo = 0;
        lista_Figuras.setModel(modeloLista);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonMOVER = new javax.swing.JButton();
        jButtonESCALAR = new javax.swing.JButton();
        btn_triangulo = new javax.swing.JButton();
        btn_circunferencia = new javax.swing.JButton();
        btn_ROTAR = new javax.swing.JButton();
        jButtonPINTAR = new javax.swing.JButton();
        bnt_dibSegmentado = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_Figuras = new javax.swing.JList<>();
        fondo = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Cuadrado");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setEnabled(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButtonMOVER.setText("Mover");
        jButtonMOVER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMOVERMouseClicked(evt);
            }
        });
        getContentPane().add(jButtonMOVER, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, -1, -1));

        jButtonESCALAR.setText("Escalar");
        jButtonESCALAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonESCALARMouseClicked(evt);
            }
        });
        jButtonESCALAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonESCALARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonESCALAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, -1, -1));

        btn_triangulo.setText("Triangulo");
        btn_triangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trianguloActionPerformed(evt);
            }
        });
        getContentPane().add(btn_triangulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        btn_circunferencia.setText("Circunferencia");
        btn_circunferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_circunferenciaMouseClicked(evt);
            }
        });
        btn_circunferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_circunferenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_circunferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));

        btn_ROTAR.setText("Rotar");
        btn_ROTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ROTARActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ROTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, -1, -1));

        jButtonPINTAR.setText("Pintar");
        jButtonPINTAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPINTARMouseClicked(evt);
            }
        });
        getContentPane().add(jButtonPINTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, -1, -1));

        bnt_dibSegmentado.setText("DibujarSegmentado");
        bnt_dibSegmentado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_dibSegmentadoActionPerformed(evt);
            }
        });
        getContentPane().add(bnt_dibSegmentado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, -1, -1));

        jLabel4.setText("Grosor");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 520, 60, -1));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1060, 600));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, -1, -1));
        lista_Figuras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_FigurasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista_Figuras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 150, 360));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, 1060, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Punto a = new Punto(2, 2);
        idUltimo++;
        Cuadrado c = new Cuadrado(a, idUltimo, 6);
        lienzo.aniadir(c);
        lienzo.ReDibujar(caso);
        modeloLista.addElement(c.getID()); 
        lista_Figuras.setSelectedValue(c.getID(), true);
        idActual = idUltimo;
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonMOVERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMOVERMouseClicked
        lienzo.getFigure(idActual).traslacion(5, 5);
        lienzo.ReDibujar(caso);
    }//GEN-LAST:event_jButtonMOVERMouseClicked

    private void jButtonESCALARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonESCALARMouseClicked
        
    }//GEN-LAST:event_jButtonESCALARMouseClicked

    private void btn_circunferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_circunferenciaActionPerformed
        idUltimo++;
        Circunferencia circ = new Circunferencia(idUltimo, 100, 100, 15);
        lienzo.aniadir(circ);
        lienzo.ReDibujar(caso);
        modeloLista.addElement(circ.getID());
        
        lista_Figuras.setSelectedValue(circ.getID(), true);
        idActual = idUltimo;
    }//GEN-LAST:event_btn_circunferenciaActionPerformed

    private void btn_circunferenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_circunferenciaMouseClicked
        
    }//GEN-LAST:event_btn_circunferenciaMouseClicked

    private void jButtonESCALARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonESCALARActionPerformed
        lienzo.getFigure(idActual).escalar(1.5);
        lienzo.ReDibujar(caso);
    }//GEN-LAST:event_jButtonESCALARActionPerformed

    private void btn_trianguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trianguloActionPerformed
        idUltimo++;
        Triangulo tri = new Triangulo(idUltimo, 20);
        lienzo.aniadir(tri);
        lienzo.ReDibujar(caso);
        modeloLista.addElement(tri.getID());
        
        lista_Figuras.setSelectedValue(tri.getID(), true);
        idActual = idUltimo;
    }//GEN-LAST:event_btn_trianguloActionPerformed

    private void btn_ROTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ROTARActionPerformed
        lienzo.getFigure(idActual).rotar(45.0);
        lienzo.ReDibujar(caso);
    }//GEN-LAST:event_btn_ROTARActionPerformed

    private void bnt_dibSegmentadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_dibSegmentadoActionPerformed
        lienzo.DibujarSegmentado(lienzo.getFigure(idActual));
        if(caso == 0){
            caso++;
            lienzo.ReDibujar(caso);
        }else{
            caso--;
            lienzo.ReDibujar(caso);
        }
    }//GEN-LAST:event_bnt_dibSegmentadoActionPerformed

    private void jButtonPINTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPINTARMouseClicked
        lienzo.getFigure(idActual).color = Color.YELLOW;
        lienzo.ReDibujar(caso);
    }//GEN-LAST:event_jButtonPINTARMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        switch (jComboBox1.getSelectedIndex()){
            case 0: //No
                lienzo.getFigure(idActual).grosor = false;
                break;
            case 1: //Si
                lienzo.getFigure(idActual).grosor = true;
                break;
        }
        lienzo.ReDibujar(caso);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void lista_FigurasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_FigurasMouseClicked
        
        int indiceElemento = lista_Figuras.locationToIndex(evt.getPoint());
        idActual = modeloLista.getElementAt(indiceElemento);
    }//GEN-LAST:event_lista_FigurasMouseClicked
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_dibSegmentado;
    private javax.swing.JButton btn_ROTAR;
    private javax.swing.JButton btn_circunferencia;
    private javax.swing.JButton btn_triangulo;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonESCALAR;
    private javax.swing.JButton jButtonMOVER;
    private javax.swing.JButton jButtonPINTAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Integer> lista_Figuras;
    // End of variables declaration//GEN-END:variables
}
