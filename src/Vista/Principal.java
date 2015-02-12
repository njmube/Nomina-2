/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DataBaseFactory;
import Modelo.Empresa;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ARISTIZABAL
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    DataBaseFactory factory;
    Empresa empresa;

    public Principal(DataBaseFactory f) {
        factory = f;
        loadEmpresa();
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void loadEmpresa() {

        if (factory.getDataBase().Empresa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe crear una empresa", "Alera", JOptionPane.WARNING_MESSAGE);
            String nit = JOptionPane.showInputDialog(null, "Ingrese el NIT de la empresa", "NIT", JOptionPane.INFORMATION_MESSAGE);
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el NOMBRE de la empresa", "NOMBRE", JOptionPane.INFORMATION_MESSAGE);
            factory.getDataBase().Empresa.add(new String[]{nit, nombre});
            factory.getDataBase().actualizarEmpresa();
        }

        String[] fila = factory.getDataBase().Empresa.get(0);
        empresa = new Empresa();
        empresa.Nit = fila[0];
        empresa.Nombre = fila[1];
    }

    public void limpiar() {
        jpnContenido.removeAll();
        repaint();
    }

    public void setComponente(Component obj) {
        limpiar();
        jpnContenido.add(obj);
        obj.setSize(jpnContenido.getSize());
        obj.validate();
        obj.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnContenido = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiGestionEmpleado = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpnContenidoLayout = new javax.swing.GroupLayout(jpnContenido);
        jpnContenido.setLayout(jpnContenidoLayout);
        jpnContenidoLayout.setHorizontalGroup(
            jpnContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jpnContenidoLayout.setVerticalGroup(
            jpnContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        jMenu1.setText("Gestion");

        jmiGestionEmpleado.setText("Empleado");
        jmiGestionEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGestionEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiGestionEmpleado);

        jMenuItem1.setText("Detalle");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Detalle Fijo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Periodo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiGestionEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGestionEmpleadoActionPerformed
        // TODO add your handling code here:
        GestionEmpleado ge = new GestionEmpleado(factory);
        ge.setEmpresa(empresa);
        setComponente(ge);
    }//GEN-LAST:event_jmiGestionEmpleadoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        GestionDetalles gd = new GestionDetalles(factory);
        setComponente(gd);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        GestionDetalleFijo gdf = new GestionDetalleFijo(factory);
        setComponente(gdf);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        GestionPeriodo gp = new GestionPeriodo(factory);
        setComponente(gp);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jmiGestionEmpleado;
    private javax.swing.JPanel jpnContenido;
    // End of variables declaration//GEN-END:variables
}
