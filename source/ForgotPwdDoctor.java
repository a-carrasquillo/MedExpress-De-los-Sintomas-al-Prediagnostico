import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**GUI que nos permite modificar la contraseña de un médico
 *
 * @author a-carrasquillo
 * @author arivesan
 */
public class ForgotPwdDoctor extends javax.swing.JFrame {
    //data field
    private String id_medico;
    // constantes relacionadas a la base de datos
    private final String YOURPASSWORD = "YourPassWord";
    private final String DBUSER = "dbuser";
    
    /**Constructor por defecto
     * Crea un nuevo formulario ForgotPwdDoctor
     */
    public ForgotPwdDoctor() {
        initComponents();
        this.setLocationRelativeTo(null);
        // elimina el mensaje de error por defecto
        error.setText("");
    }
    
    /**Constructor especial 
     * 
     * @param id_medico - número de identificación del médico
     */
    public ForgotPwdDoctor(String id_medico) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.id_medico = id_medico;
        // elimina el mensaje de error por defecto
        error.setText("");
    }

    /**Método que nos permite recuperar el id del médico
     * 
     * @return cadena de caracteres que representa el id del médico
     */
    public String getIdMedico()
    {
        return id_medico;
    }
    
    /**Método que nos permite modificar el id del médico
     * 
     * @param id_medico - número de identificación del médico
     */
    public void setIdMedico(String id_medico)
    {
        this.id_medico = id_medico;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        pass_conf = new javax.swing.JPasswordField();
        submit = new javax.swing.JButton();
        especialidad = new javax.swing.JComboBox<>();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambio de Contraseña");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Nueva Contraseña:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Confirmar Contraseña:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Especialidad:");

        pass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pass.setText("123456");
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
        });

        pass_conf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pass_conf.setText("123456");
        pass_conf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pass_confMouseClicked(evt);
            }
        });

        submit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        submit.setText("Realizar Cambio");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        especialidad.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        especialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        error.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        error.setText("Mensaje de Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addGap(167, 167, 167))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(especialidad, 0, 228, Short.MAX_VALUE)
                    .addComponent(pass)
                    .addComponent(pass_conf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(especialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pass_conf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(error)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
        // eliminar la información por defecto del encasillado
        pass.setText("");
    }//GEN-LAST:event_passMouseClicked

    private void pass_confMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass_confMouseClicked
        // eliminar la información por defecto del encasillado
        pass_conf.setText("");
    }//GEN-LAST:event_pass_confMouseClicked

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // borrar el mensaje de error
        error.setText("");
        
        // recuperar los valores de los campos
        String esp = especialidad.getSelectedItem().toString();
        String password = String.valueOf(pass.getPassword());
        String conf_pass = String.valueOf(pass_conf.getPassword());
        
        // verificar que la contraseña sea igual al de confirmación
        if(!password.isEmpty()&&password.equals(conf_pass))
        {//las contraseñas coinciden
            // verificar que la especialidad no se encuentra vacía
            if(esp.isEmpty())
            {
                error.setText("¡Favor de no dejar nada en blanco!");
            }
            else
            {
                Connection coneccion = null;
                try
                {
                    coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedExpress?autoReconnect=true&useSSL=false",DBUSER,YOURPASSWORD);
                    // query para determinar la especialidad del médico
                    String query = "select Especialidad from MedExpress.Medicos natural join MedExpress.Especialidades where ID_Medico = '" + id_medico +"'";
                    Statement statement = coneccion.createStatement();
                    ResultSet result = statement.executeQuery(query);
                    // Determinar si hubo un resultado
                    while(result.next())
                    {
                        // extraer el resultado
                        String especialidad_db = result.getString("Especialidad");

                        // verificar que la especialidad obtenida del usuario coincide con la obtenida de la base de datos
                        if(especialidad_db.equals(esp))
                        {//la persona introdujo correctamente su información de recuperación
                            JOptionPane.showMessageDialog(null, "Su información ha sido verificada correctamente. Comenzando cambio de contraseña...");
                            
                            Connection coneccion2 = null;
                            PreparedStatement p_statement2 = null;
                            try
                            {
                                coneccion2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedExpress?autoReconnect=true&useSSL=false",DBUSER,YOURPASSWORD);
                                // query para actualizar la contraseña
                                String query2 = "update MedExpress.Medicos set Pwd = '" + password+"' where Id_Medico = '" + id_medico +"' ";
                                p_statement2 = coneccion2.prepareStatement(query2);

                                // actualizar la contraseña
                                if(p_statement2.executeUpdate() > 0)
                                {
                                    JOptionPane.showMessageDialog(null, "¡Actualización exitosa!" );
                                    // cerrar el GUI actual
                                    this.dispose();
                                    // crear una instancia de la GUI de inicio de sesión de los médicos
                                    LogDoctor doctor = new LogDoctor();
                                    // hacer visible el nuevo GUI
                                    doctor.setVisible(true);
                                }
                            }catch(SQLException e)
                            {
                                /*blank intentionally*/
                            }
                            finally
                            {
                                try
                                {
                                    if(p_statement2 != null)
                                        p_statement2.close();
                                    if(coneccion2 != null)
                                        coneccion2.close();
                                } catch(SQLException e) 
                                {
                                    /*blank intentionally*/
                                }
                            }                                               
                        }        
                    }
                    try{result.close();}catch(SQLException e){ /*blank intentionally*/}
                    try{statement.close();}catch(SQLException e) {/*blank intentionally*/}
                }catch(SQLException e)
                {
                    /*blank intentionally*/
                }
                finally
                {
                    try
                    {
                        if(coneccion != null)
                            coneccion.close();
                    } catch(SQLException e)
                    {
                        /*blank intentionally*/
                    }
                }
            }
        }
        else
            error.setText("¡Las contraseñas no coinciden!");
        
    }//GEN-LAST:event_submitActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPwdDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPwdDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPwdDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPwdDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPwdDoctor().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error;
    protected javax.swing.JComboBox<String> especialidad;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField pass_conf;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
