import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**GUI utilizado para mostrar los médicos disponibles
 *  en un momento dado en una facilidad médica
 *
 * @author a-carrasquillo
 */
public class Medicos_Disponibles extends javax.swing.JFrame {
    // data fields
    protected DefaultTableModel model;
    private List<String> id_medico;
    // constantes relacionadas a la base de datos
    private final String YOURPASSWORD = "YourPassWord";
    private final String DBUSER = "dbuser";
    
    /**Constructor por defecto
     * Crea un nuevo formulario medicos_disponibles
     */   
    public Medicos_Disponibles() {
        initComponents();
        this.setLocationRelativeTo(null);
        // nos permite designar el tipo de modelo de la tabla
        model = new DefaultTableModel();
        // asigna el modelo a la lista de médicos disponibles
        lista_medicos_disp.setModel(model);
        // añade las columnas a la tabla
        model.addColumn("Nombre");
        model.addColumn("Especialidad");
        // elimina el mensaje de error por defecto
        error.setText("");
    }

    /**Método que nos permite modificar la lista 
     * con los números de identificación de los médicos
     * 
     * @param id_medico - lista con los números de identificación de los médicos
     */
    public void setId_Medico(List<String> id_medico) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lista_medicos_disp = new javax.swing.JTable();
        see_comments = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Médicos Disponibles");

        lista_medicos_disp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lista_medicos_disp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Especialidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        lista_medicos_disp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(lista_medicos_disp);

        see_comments.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        see_comments.setText("Ver Comentarios");
        see_comments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                see_commentsActionPerformed(evt);
            }
        });

        error.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        error.setText("Mensaje de Error");

        close.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        close.setText("Cerrar");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(see_comments))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(see_comments)
                    .addComponent(close))
                .addGap(5, 5, 5)
                .addComponent(error)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void see_commentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_see_commentsActionPerformed
        // determinar la fila seleccionada por el paciente
        int fila = lista_medicos_disp.getSelectedRow();
        // evaluar que se haya escogido una fila
        if (fila<0)
        {
            error.setText("Por favor escoger un médico para poder ver las reseñas.");
        }
        else
        {
            Connection coneccion = null;
            try
            {
                coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedExpress?autoReconnect=true&useSSL=false",DBUSER,YOURPASSWORD);
                // query que extraer los comentarios sobre el médico
                String query = "select fecha_comentario, hora_comentario, comentarios, rating_numerico from comentarios where ID_Med_OM_SE = '"+ id_medico.get(fila)+"'";
                Statement statement = coneccion.createStatement();
                ResultSet result = statement.executeQuery(query);
                
                // instanciar el GUI que nos permite ver los ratings de un médico en específico
                Ratings_List ratings = new Ratings_List();
                
                // variables que almacenan la información de las reseñas
                String fecha = "", hora, comentario, rating_num;
                // recorrer los resultados
                while(result.next())
                {
                    // extraer la información del resultado
                    fecha = result.getString("fecha_comentario");
                    hora =  result.getString("hora_comentario");
                    comentario = result.getString("comentarios");
                    rating_num =  result.getString("rating_numerico");
                    // pasar la información a la tabla que muestra las reseñas
                    ratings.model.addRow(new Object[]{fecha, hora, comentario, rating_num});
                }
                // evaluar si hay reseñas
                if(!fecha.isEmpty())
                // hay reseñas,  hacer visible el GUI nuevo
                    ratings.setVisible(true);
                else
                // no hay reseñas
                    JOptionPane.showMessageDialog(null, "No hay reseñas disponibles para este médico.");
                
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
    }//GEN-LAST:event_see_commentsActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // cerrar el GUI actual
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed

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
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medicos_Disponibles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JLabel error;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTable lista_medicos_disp;
    private javax.swing.JButton see_comments;
    // End of variables declaration//GEN-END:variables
}
