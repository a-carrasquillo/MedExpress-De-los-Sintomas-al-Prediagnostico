import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/** GUI utilizado para mostrar las opciones que tiene un administrador
 * @author a-carrasquillo
 * @author a-rivera
 */
public class AdminUserForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminUserForm
     */
    // data fields
    private String id_admin;
    private List<String> id_pacientes;
    // constantes relacionadas a la base de datos
    private final String YOURPASSWORD = "YourPassWord";
    private final String DBUSER = "dbuser";
    
    // constructor
    public AdminUserForm() {
        initComponents();
    }
    
    // constructor especial
    public AdminUserForm(String id_admin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.id_admin = id_admin;
    }

    // getter
    public String getIdAdmin()
    {
        return id_admin;
    }
    
    // setter
    public void setIdAdmin(String id_admin)
    {
        this.id_admin = id_admin;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        change_profile = new javax.swing.JButton();
        sign_out = new javax.swing.JButton();
        adm_patients = new javax.swing.JButton();
        list_employees = new javax.swing.JButton();
        add_workplace = new javax.swing.JButton();
        welcome = new javax.swing.JLabel();
        remove_workplace = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Página Principal");

        change_profile.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        change_profile.setText("Cambiar Perfil del Lugar de Trabajo");
        change_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_profileActionPerformed(evt);
            }
        });

        sign_out.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sign_out.setText("Cerrar Sesión");
        sign_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_outActionPerformed(evt);
            }
        });

        adm_patients.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        adm_patients.setText("Admisión de Pacientes");
        adm_patients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adm_patientsActionPerformed(evt);
            }
        });

        list_employees.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        list_employees.setText("Lista de Empleados");
        list_employees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_employeesActionPerformed(evt);
            }
        });

        add_workplace.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add_workplace.setText("Agregar Lugar de Trabajo");
        add_workplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_workplaceActionPerformed(evt);
            }
        });

        welcome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("¿Qué desea hacer 'Nombre Adm'?");

        remove_workplace.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        remove_workplace.setText("Eliminar Lugar de Trabajo");
        remove_workplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_workplaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sign_out)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(change_profile, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                .addComponent(adm_patients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(list_employees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add_workplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(remove_workplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(welcome)
                .addGap(29, 29, 29)
                .addComponent(change_profile)
                .addGap(18, 18, 18)
                .addComponent(adm_patients)
                .addGap(18, 18, 18)
                .addComponent(list_employees)
                .addGap(18, 18, 18)
                .addComponent(add_workplace)
                .addGap(18, 18, 18)
                .addComponent(remove_workplace)
                .addGap(18, 18, 18)
                .addComponent(sign_out)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sign_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_outActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login_As log = new Login_As();
        log.setVisible(true);
        
    }//GEN-LAST:event_sign_outActionPerformed

    private void remove_workplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_workplaceActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(null, "Esta opción no se encuentra disponible por el momento, esta en desarrollo. Disculpe los inconvenientes.");
    }//GEN-LAST:event_remove_workplaceActionPerformed

    private void change_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_profileActionPerformed
        
        // verificar donde esta trabajando el admin
        
        Connection coneccion = null;
        // variable para almacenar el día  de la consulta a la BD
        String dia_consulta = " ";
        
        try
        {
           coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedExpress?autoReconnect=true&useSSL=false",DBUSER,YOURPASSWORD);
           // obtener el día de hoy
           String query = "select date_format(now(), '%W') dia";
           Statement statement = coneccion.createStatement();
           ResultSet result = statement.executeQuery(query);

            while(result.next())
            {
                // extraer el día  
                dia_consulta = result.getString("dia"); 
            }
            // encontrar el id del lugar donde esta trabajando actualmente el adm
           query = "Select ID_Facilidad from adm_fac_med a, trabaja t where a.id_empleado=t.id_empleado and a.id_empleado='"+id_admin+"' and curtime() between Hora_Entrada and Hora_Salida and t.dia_trab like '%"+dia_consulta+"%' ";
           statement = coneccion.createStatement();
           result = statement.executeQuery(query);
           // variable para almacenar el id de la facilidad
            String id_facilidad = "";
 
            while(result.next())
            {
                // extraer el id de la facilidad
                id_facilidad = result.getString("ID_Facilidad");   
            }
            // variable para guardar el tipo de facilidad
            String facilidad = "";
            // verificar si se logró recuperar un id de facilidad
            if(!id_facilidad.isEmpty())
            {
                 // verificar si la facilidad es una oficina o sala de emergencia
                switch (id_facilidad.charAt(0)) 
                {
                    case 'E':
                        // sala de emergencia, buscar en tabla de hospitales
                        facilidad="hospitales";
                        break;
                    case 'O':
                        // consultorio médico, buscar en la tabla de oficina médica
                        facilidad = "oficinas_medicas";
                        break;
                    default:
                        //error
                        JOptionPane.showMessageDialog(null, "Error. El ID de facilidad encontrado no corresponde a ninguno de los que debe.\nFavor de contactar al manejador de la BD");
                        break;
                }
                // crear una instancia para el GUI que permite cambiar el perfil de trabajo de una localidad enviarle el ID del adm para no perder quien es
                Change_Profile_Workplace cambio = new Change_Profile_Workplace(id_admin, id_facilidad,facilidad);
                // remover la información por defecto de la hora de apertura y cierre
                cambio.hora_abre.removeAllItems();
                cambio.hora_cierra.removeAllItems();
                // buscar la informacion actual del lugar 
                query = "select horario_apertura, horario_cierre, plan, num_tel, cap_est, cant_doc from "+facilidad + " where id_facilidad = '"+id_facilidad+"' ";
                statement = coneccion.createStatement();
                result = statement.executeQuery(query);
                // variables para almacenar la información de la facilidad médica 
                String hora_abre, hora_cierra, plan, telefono, estacionamiento, cant_doctores;

                while(result.next())
                {//sacando información
                       hora_abre = result.getString("horario_apertura");
                       hora_cierra = result.getString("horario_cierre");
                       plan = result.getString("plan");
                       telefono = result.getString("num_tel");
                       estacionamiento = result.getString("cap_est");
                       cant_doctores = result.getString("cant_doc");
                        
                       //enviar la informacion al GUI de cambio, 
                       cambio.hora_abre.addItem(hora_abre);
                       cambio.hora_cierra.addItem(hora_cierra);
                       cambio.planes.setText(plan);
                       cambio.telefono.setText(telefono);
                       cambio.cap_est.setValue(Integer.valueOf(estacionamiento));
                       cambio.cant_doctores.setValue(Integer.valueOf(cant_doctores));
                   }
                   // hacer dispose (eliminar) del GUI actual
                   this.dispose();
                   // hacer visible el otro GUI
                   cambio.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se puede modificar fuera de las horas de trabajo.");
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
                {
                       coneccion.close();
                }
            } catch(SQLException e)
            {
                 /*blank intentionally*/
            }
        }
    }//GEN-LAST:event_change_profileActionPerformed

    private void list_employeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_employeesActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(null, "Esta opción no se encuentra disponible por el momento, esta en desarrollo. Disculpe los inconvenientes.");
    }//GEN-LAST:event_list_employeesActionPerformed

    private void add_workplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_workplaceActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(null, "Esta opción no se encuentra disponible por el momento, esta en desarrollo. Disculpe los inconvenientes.");
    }//GEN-LAST:event_add_workplaceActionPerformed

    private void adm_patientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adm_patientsActionPerformed
        // crear una instancia del GUI que nos ayuda a ver la lista de pacientes de una facilidad
        List_Admission_Patient pacientes = new List_Admission_Patient(id_admin);
        // instanciar el ArrayList que contendrá los id de los pacientes
        id_pacientes = new ArrayList<>();
        
        Connection coneccion = null;
        
        // variable para almacenar el día de la consulta a la BD
        String dia_consulta = " ";
        
        try
        {
           coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedExpress?autoReconnect=true&useSSL=false",DBUSER,YOURPASSWORD);
           // obtener el día de hoy
           String query = "select date_format(now(), '%W') dia";
           Statement statement = coneccion.createStatement();
           ResultSet result = statement.executeQuery(query);
      
            while(result.next())
            {
                // extraer el día  
                dia_consulta = result.getString("dia"); 
            }
            // encontrar el id del lugar donde esta trabajando actualmente el administrador
           query = "Select ID_Facilidad from adm_fac_med a, trabaja t where a.id_empleado=t.id_empleado and a.id_empleado='"+id_admin+"' and curtime() between Hora_Entrada and Hora_Salida and t.dia_trab like '%"+dia_consulta+"%' ";
           statement = coneccion.createStatement();
           result = statement.executeQuery(query);
           // variable para almacenar el id de la facilidad
            String id_facilidad = "";
            while(result.next())
            {
                // extraer el id de la facilidad
                id_facilidad = result.getString("ID_Facilidad");
            }
            
            // verificar si se obtuvo el id de una facilidad
            if(!id_facilidad.isEmpty())
            {
               // encontrar la información básica del paciente
               query = "select p.id_paciente id, nombre, apellidos, fec_ingreso, hora_ingreso from ingresos i, pacientes p where atendido=0 and i.id_paciente=p.id_paciente and id_facilidad='"+id_facilidad+"' ";
               statement = coneccion.createStatement();
               result = statement.executeQuery(query);
               // variables para almacenar la información del paciente 
               String nombre="", apellidos, fecha, hora, nombre_completo;
                while(result.next())
                {
                    // extraer la información
                    id_pacientes.add(result.getString("id"));
                    nombre = result.getString("nombre");
                    apellidos = result.getString("apellidos");
                    fecha = result.getString("fec_ingreso");
                    hora = result.getString("hora_ingreso");
                    nombre_completo = nombre + " " + apellidos;
                    
                    // enviar la información a la tabla
                    pacientes.model.addRow(new Object[]{nombre_completo, fecha, hora});
                }
                // evaluar si hay pacientes sin atender en la localidad donde se encuentra trabajando el administrador
                if(!nombre.isEmpty())
                {//hay pacientes
                    pacientes.setId_Pacientes(id_pacientes);
                    this.dispose();
                    pacientes.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No hay pacientes sin atender por el momento.");
                } 
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usted no se encuentra en horas de trabajo. No puede revisar información fuera de sus horas laborales.");
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
                {
                    coneccion.close();
                }
            } catch(SQLException e)
            {
                 /*blank intentionally*/
            }
        }
    }//GEN-LAST:event_adm_patientsActionPerformed

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
            java.util.logging.Logger.getLogger(AdminUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_workplace;
    private javax.swing.JButton adm_patients;
    private javax.swing.JButton change_profile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton list_employees;
    private javax.swing.JButton remove_workplace;
    private javax.swing.JButton sign_out;
    protected javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
