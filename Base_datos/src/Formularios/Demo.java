/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Diego
 */
public class Demo extends javax.swing.JFrame {
private Connection conexion;     
private Statement st;     
private ResultSet rs; 


    /**
     * Creates new form Demo
     */
    public Demo() {
        initComponents();
        this.Conectar();
        this.deshabilitarDatos();
        Sletras(this.jtf_nombre_producto);
        Snum(this.jtf_existencias);
    }
    
 public void Conectar(){
         try{ 
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/demo_proyecto","root","utec");                     
            st=conexion.createStatement(); 

            rs=st.executeQuery("Select * from productos");             

            rs.next(); 
            
            
            this.jtf_id_producto.setText(rs.getString("id_producto"));                         
            this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));             
            this.jtf_existencias.setText(rs.getString("existencias")); 
            this.jcb_marca.addItem(rs.getString("marca"));
            this.jcb_marca.setSelectedItem(rs.getString("marca"));
            while(rs.next()){
                this.jcb_marca.addItem(rs.getString("marca"));
            }
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    } 
    public void deshabilitarDatos (){
        this.jtf_nombre_producto.setEnabled(false);
        this.jcb_marca.setEnabled(false);
        this.jtf_existencias.setEnabled(false);
    }
    public void habilitarDatos (){
        for(int i=0;i<jp_datos.getComponents().length;i++) {
        jp_datos.getComponent(i).setEnabled(true);
}
    }
    public void habilitarMovimientos(){
        for(int i=0;i<jp_controles_movimiento.getComponents().length;i++) {
        jp_controles_movimiento.getComponent(i).setEnabled(true);
        
}
    }
    public void deshabilitarMovimientos(){
        for(int i=0;i<jp_controles_movimiento.getComponents().length;i++) {
        jp_controles_movimiento.getComponent(i).setEnabled(false);
        
}
    }
    private void siguiente(){
    try{
            rs.next();
            this.jtf_id_producto.setText(rs.getString("id_producto"));                         
            this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));
            this.jcb_marca.setSelectedItem(rs.getString("marca"));
            this.jtf_existencias.setText(rs.getString("existencias")); 
        
    }
    catch(Exception err){
         JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
    }
}
    private void anterior(){
    try{
        
            rs.previous();
            this.jtf_id_producto.setText(rs.getString("id_producto"));                         
            this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));   
            this.jcb_marca.addItem(rs.getString("marca"));
            this.jcb_marca.setSelectedItem(rs.getString("marca"));
            this.jtf_existencias.setText(rs.getString("existencias")); 
        
    }
    catch(Exception err){
         JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
    }
}
    private void primero(){
    try{
        
            rs.first();
            this.jtf_id_producto.setText(rs.getString("id_producto"));                         
            this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));             
            this.jcb_marca.setSelectedItem(rs.getString("marca"));
            this.jtf_existencias.setText(rs.getString("existencias")); 
        
    }
    catch(Exception err){
         JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
    }
}
    private void ultimo(){
    try{
        
            rs.last();
            this.jtf_id_producto.setText(rs.getString("id_producto"));                         
            this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));             
            this.jcb_marca.setSelectedItem(rs.getString("marca"));
            this.jtf_existencias.setText(rs.getString("existencias")); 
        
    }
    catch(Exception err){
         JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
    }
}
    private void guardar(){
        
    try{
        String nombre = this.jtf_nombre_producto.getText();
        String existencias = this.jtf_existencias.getText();
        
        
        st.executeUpdate("Insert into productos(NOMBRE_PRODUCTO,MARCA)");
    }
    catch(Exception err){
         JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
    }
}
    private void borrar(){
        try{ 
           st.executeUpdate("delete from tabla1 where id_tabla1="+this.jtf_id_producto.getText());

           this.primero();

       } catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    } 
    public void nuevo (){
    this.jtf_id_producto.setEnabled(false);
        this.jtf_id_producto.setText("0");
        this.jtf_nombre_producto.setText(" ");
        this.jcb_marca.setSelectedIndex(0);
        this.jtf_existencias.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public void Sletras(JTextField a){
        a.addKeyListener(new KeyAdapter (){
        public void keyTyped(KeyEvent e){
            char c=e.getKeyChar();
            if(Character.isDigit(c)){
                e.consume();
            }
            }    
        });
    }
        public void Snum(JTextField a){
        a.addKeyListener(new KeyAdapter (){
        public void keyTyped(KeyEvent e){
            char c=e.getKeyChar();
            if(Character.isLetter(c)){
                e.consume();
            }
            }    
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_datos = new javax.swing.JPanel();
        jl_id_producto = new javax.swing.JLabel();
        jtf_id_producto = new javax.swing.JTextField();
        jl_nombre_producto = new javax.swing.JLabel();
        jtf_nombre_producto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_existencias = new javax.swing.JTextField();
        jcb_marca = new javax.swing.JComboBox<>();
        jp_controles_movimiento = new javax.swing.JPanel();
        jb_primero = new javax.swing.JButton();
        jb_anterior = new javax.swing.JButton();
        jb_siguiente = new javax.swing.JButton();
        jb_ultimo = new javax.swing.JButton();
        jp_controles = new javax.swing.JPanel();
        jb_nuevo = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_datos.setBackground(new java.awt.Color(0, 153, 51));

        jl_id_producto.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jl_id_producto.setForeground(new java.awt.Color(255, 255, 255));
        jl_id_producto.setText("ID");

        jtf_id_producto.setEnabled(false);

        jl_nombre_producto.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jl_nombre_producto.setForeground(new java.awt.Color(255, 255, 255));
        jl_nombre_producto.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca");

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Existencias");

        jtf_existencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_existenciasActionPerformed(evt);
            }
        });

        jcb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jp_datosLayout = new javax.swing.GroupLayout(jp_datos);
        jp_datos.setLayout(jp_datosLayout);
        jp_datosLayout.setHorizontalGroup(
            jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_datosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_nombre_producto)
                            .addComponent(jl_id_producto))
                        .addGap(34, 34, 34)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nombre_producto)))
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_datosLayout.setVerticalGroup(
            jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_datosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_id_producto)
                    .addComponent(jtf_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_nombre_producto)
                    .addComponent(jtf_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jp_controles_movimiento.setBackground(new java.awt.Color(255, 0, 51));

        jb_primero.setText("<");
        jb_primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_primeroActionPerformed(evt);
            }
        });

        jb_anterior.setText("<<");
        jb_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_anteriorActionPerformed(evt);
            }
        });

        jb_siguiente.setText(">>");
        jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_siguienteActionPerformed(evt);
            }
        });

        jb_ultimo.setText(">");
        jb_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ultimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_controles_movimientoLayout = new javax.swing.GroupLayout(jp_controles_movimiento);
        jp_controles_movimiento.setLayout(jp_controles_movimientoLayout);
        jp_controles_movimientoLayout.setHorizontalGroup(
            jp_controles_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_controles_movimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_primero, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jp_controles_movimientoLayout.setVerticalGroup(
            jp_controles_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_controles_movimientoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jp_controles_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_primero)
                    .addComponent(jb_anterior)
                    .addComponent(jb_siguiente)
                    .addComponent(jb_ultimo))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jp_controles.setBackground(new java.awt.Color(0, 153, 153));

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoActionPerformed(evt);
            }
        });

        jb_borrar.setText("Borrar");
        jb_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_borrarActionPerformed(evt);
            }
        });

        jb_modificar.setText("Modificar");
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });

        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_controlesLayout = new javax.swing.GroupLayout(jp_controles);
        jp_controles.setLayout(jp_controlesLayout);
        jp_controlesLayout.setHorizontalGroup(
            jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_controlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_guardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_controlesLayout.createSequentialGroup()
                        .addComponent(jb_borrar)
                        .addGap(26, 26, 26)
                        .addComponent(jb_modificar))
                    .addComponent(jb_cancelar))
                .addGap(23, 23, 23))
        );
        jp_controlesLayout.setVerticalGroup(
            jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_controlesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_borrar)
                    .addComponent(jb_modificar))
                .addGap(29, 29, 29)
                .addGroup(jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_guardar)
                    .addComponent(jb_cancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_controles_movimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp_controles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jp_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_controles_movimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_controles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_existenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_existenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_existenciasActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jb_primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_primeroActionPerformed
        this.primero();
    }//GEN-LAST:event_jb_primeroActionPerformed

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
        this.habilitarDatos();
        this.jtf_id_producto.setEnabled(false);
        this.deshabilitarMovimientos();
        
    }//GEN-LAST:event_jb_modificarActionPerformed

    private void jb_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_anteriorActionPerformed
        this.anterior();
    }//GEN-LAST:event_jb_anteriorActionPerformed

    private void jb_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siguienteActionPerformed
        this.siguiente();
    }//GEN-LAST:event_jb_siguienteActionPerformed

    private void jb_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ultimoActionPerformed
        this.ultimo();
    }//GEN-LAST:event_jb_ultimoActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        this.deshabilitarDatos();
        this.habilitarMovimientos();
        this.primero();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_borrarActionPerformed
        this.borrar();
    }//GEN-LAST:event_jb_borrarActionPerformed

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
        this.habilitarDatos();
        this.deshabilitarMovimientos();
        this.nuevo();
    }//GEN-LAST:event_jb_nuevoActionPerformed

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
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_anterior;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_primero;
    private javax.swing.JButton jb_siguiente;
    private javax.swing.JButton jb_ultimo;
    private javax.swing.JComboBox<String> jcb_marca;
    private javax.swing.JLabel jl_id_producto;
    private javax.swing.JLabel jl_nombre_producto;
    private javax.swing.JPanel jp_controles;
    private javax.swing.JPanel jp_controles_movimiento;
    private javax.swing.JPanel jp_datos;
    private javax.swing.JTextField jtf_existencias;
    private javax.swing.JTextField jtf_id_producto;
    private javax.swing.JTextField jtf_nombre_producto;
    // End of variables declaration//GEN-END:variables
}
