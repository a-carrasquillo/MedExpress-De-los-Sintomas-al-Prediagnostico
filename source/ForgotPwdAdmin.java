import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**GUI que nos permite modificar la contraseña de un administrador
 *
 * @author a-carrasquillo
 * @author arivesan
 */
public class ForgotPwdAdmin extends javax.swing.JFrame {
    //data field
    private String id_adm;
    // constantes relacionadas a la base de datos
    private final String YOURPASSWORD = "YourPassWord";
    private final String DBUSER = "dbuser";
    
    /** Constructor por defecto
     * Crea un nuevo formulario ForgotPwdAdmin
     */
    public ForgotPwdAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        // elimina el mensaje de error por defecto
        error.setText("");
    }
    
    /** Constructor especial
     * 
     * @param id_adm -  número de identificación del administrador
     */
    public ForgotPwdAdmin(String id_adm) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.id_adm = id_adm;
        // elimina el mensaje de error por defecto
        error.setText("");
    }
       
    /**Método que nos permite recuperar el id del adminstrador
     * 
     * @return cadena de caracteres que representa el id del administrador
     */
    public String getIdAdm()
    {
        return id_adm;
    }
    
    /**Método que nos permite modificar el id del administrador
     * 
     * @param id_adm - número de identificación del administrador
     */
    public void setIdAdm(String id_adm)
    {
        this.id_adm = id_adm;
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
        pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        pass_conf = new javax.swing.JPasswordField();
        submit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambio de Contraseña");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Nueva Contraseña:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Confirmar Contraseña:");

        pass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pass.setText("12345678");
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        pass_conf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pass_conf.setText("12345678");
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

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Apellidos:");

        name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lastname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        error.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        error.setText("Mensaje de Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(178, 178, 178)
                    .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap(182, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addComponent(lastname, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pass_conf))
                    .addGap(34, 34, 34)))
            .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_conf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // borrar el mensaje de error
        error.setText("");
        
        // recuperar los valores de los campos 
        String nombre = name.getText();
        String apellidos = lastname.getText();
        String password = String.valueOf(pass.getPassword());
        String pass_ver = String.valueOf(pass_conf.getPassword());
         
        Connection coneccion = null;
        // verificar que las contraseñas coinciden
        if (password.equals(pass_ver))
        {
            // verificar si dejo algo en blanco
            if(password.isEmpty()||nombre.isEmpty()||apellidos.isEmpty())
            {
                error.setText("Favor de no dejar espacios en blanco!");
            }
            else
            {
                try
                {
                    coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedExpress?autoReconnect=true&useSSL=false",DBUSER,YOURPASSWORD);
                    // buscar el nombre y apellidos del administrador basados en el número de identificación
                    String query = "select Nombre, Apellidos from MedExpress.adm_fac_med where ID_Empleado ='" + id_adm +"'";
                    Statement statement = coneccion.createStatement();
                    ResultSet result = statement.executeQuery(query);

                    // verificar si hubo resultados
                    while(result.next())
                    { 
                        // extraer el nombre y apellidos del resultado 
                        String nombre_db = result.getString("Nombre");
                        String apellidos_db = result.getString("Apellidos");
                        
                        // verificar que el nombre y apellidos recuperados de la base de datos coinciden con los recuperados del usuario
                        if(nombre_db.equals(nombre)&&apellidos_db.equals(apellidos))
                        {//el usuario introdujo correctamente su información de recuperación
                            // eliminar el mensaje de error
                            error.setText("");
                            JOptionPane.showMessageDialog(null, "Su información ha sido verificada correctamente. Comenzando cambio de contraseña...");
                                 
                            PreparedStatement p_statement2 = null;
                            try
                            {    
                                // query para cambiar la contraseña
                                String query2 = "update MedExpress.adm_fac_med set Pwd = '" + password+"' where Id_Empleado = '" + id_adm +"' ";
                                p_statement2 = coneccion.prepareStatement(query2);
                                
                                // actualizar la contraseña
                                if(p_statement2.executeUpdate() > 0)
                                {
                                    JOptionPane.showMessageDialog(null, "¡Actualización exitosa!" );
                                    // cerrar el GUI actual
                                    this.dispose();
                                    // crear una instancia del GUI de inicio de sesión de administradores
                                    LogAdmin adm = new LogAdmin();
                                    // hacer visible el nuevo GUI
                                    adm.setVisible(true);
                                }
                             }catch(SQLException e)
                            {
                                /*blank intentionally*/
                             }
                             finally
                             {
                                 try{
                                     if(p_statement2 != null)
                                        p_statement2.close();
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
                    try{
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

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
        // eliminar la información por defecto del encasillado
        pass.setText("");
    }//GEN-LAST:event_passMouseClicked

    private void pass_confMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass_confMouseClicked
        // eliminar la información por defecto del encasillado
        pass_conf.setText("");
    }//GEN-LAST:event_pass_confMouseClicked

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
            java.util.logging.Logger.getLogger(ForgotPwdAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPwdAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPwdAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPwdAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPwdAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField pass_conf;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
