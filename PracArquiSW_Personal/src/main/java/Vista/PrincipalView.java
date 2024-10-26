/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.SistemaController;
import Modelo.Personal;
import Modelo.PersonalModelo;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PrincipalView extends javax.swing.JFrame {
    private JButton boton; // Define el botón aquí
    private PersonalModelo personalModelo;
    private DefaultTableModel tableModel;
    private SistemaController controlador;
    private int selectedRow;

    /**
     * Creates new form PrincipalView
     */
   public PrincipalView() {
    initComponents();
    setLocationRelativeTo(null);
    
    // Inicializar el modelo de personal y el controlador
    personalModelo = new PersonalModelo();
    controlador = new SistemaController(personalModelo);
    setUpTableModel();
    actualizarTabla();
    
    // Agregar MouseListener para cargar datos en los campos al hacer clic en la tabla
    tbPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            cargarDatosDeFilaSeleccionada(tbPersonal.getSelectedRow());
        }
    });

    // Validación para permitir solo letras en el campo Nombre
    txtNombre.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE && c != '-' && c != '\'') {
                e.consume();
                JOptionPane.showMessageDialog(null, "Solo se permiten letras en el campo Nombre");
            }
        }
    });

    // Validación para permitir solo letras en el campo Apellido
    txtApellido.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE && c != '-' && c != '\'') {
                e.consume();
                JOptionPane.showMessageDialog(null, "Solo se permiten letras en el campo Apellido");
            }
        }
    });
}

    private void setUpTableModel() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("CÓDIGO");
        tableModel.addColumn("NOMBRE");
        tableModel.addColumn("APELLIDO");
        tableModel.addColumn("FECHA NACIMIENTO");
        tableModel.addColumn("FECHA CONTRATACION");
        tbPersonal.setModel(tableModel);
    }

    private void cargarDatosDeFilaSeleccionada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public class FechaUtil {
        public static String formatFecha(Date fecha) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.format(fecha);
        }
    }
private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
    cargarDatosDeFilaSeleccionada(); // Carga los datos de la fila seleccionada en los campos de texto
}

    private void actualizarTabla() {
        tableModel.setRowCount(0); // Limpia la tabla
        for (Personal personal : personalModelo.getListaPersonal()) {
            Object[] rowData = new Object[]{
                personal.getCodigo(),
                personal.getNombre(),
                personal.getApellido(),
                FechaUtil.formatFecha(personal.getFecha_nac()),
                FechaUtil.formatFecha(personal.getFecha_con())
            };
            tableModel.addRow(rowData);
        }
    }

    private void cargarDatosDeFilaSeleccionada(int filaSeleccionada) {
    if (filaSeleccionada != -1) {
        try {
            String codigo = tableModel.getValueAt(filaSeleccionada, 0).toString();
            String nombre = tableModel.getValueAt(filaSeleccionada, 1).toString();
            String apellido = tableModel.getValueAt(filaSeleccionada, 2).toString();
            String fechaNacStr = tableModel.getValueAt(filaSeleccionada, 3).toString(); // Obtener como String
            String fechaConStr = tableModel.getValueAt(filaSeleccionada, 4).toString(); // Obtener como String

            // Convertir de String a Date
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaNac = formatoFecha.parse(fechaNacStr);
            Date fechaCon = formatoFecha.parse(fechaConStr);

            // Completar los campos
            txtNombre.setText(nombre);
            txtApellido.setText(apellido);
            jdtNacimiento.setDate(fechaNac);
            jdtContratacion.setDate(fechaCon);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.");
    }
}




    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdtContratacion = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jdtNacimiento = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPersonal = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("NOMBRE:");

        txtNombre.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre.setBorder(null);

        jLabel3.setText("APELLIDO:");

        txtApellido.setBackground(new java.awt.Color(204, 204, 204));
        txtApellido.setBorder(null);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        jLabel6.setText("DATOS PERSONALES");

        jLabel4.setText("FECHA DE NACIMIENTO:");

        jLabel5.setText("FECHA DE CONTRATACIÓN:");

        jdtNacimiento.setBackground(new java.awt.Color(204, 204, 204));
        jdtNacimiento.setMaxSelectableDate(new java.util.Date(1136095298000L));
        jdtNacimiento.setMinSelectableDate(new java.util.Date(-189367102000L));

        tbPersonal.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        tbPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbPersonal);

        btnRegistrar.setBackground(new java.awt.Color(153, 255, 153));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(102, 204, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(255, 255, 153));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel1.setText("REGISTRO DE CONTRATACION DE PERSONAL");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jdtContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jdtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(btnRegistrar)
                                .addComponent(btnNuevo)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jdtContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 610, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String codigo = tableModel.getValueAt(selectedRow, 0).toString();
String nombre = txtNombre.getText();
String apellido = txtApellido.getText();
Date fechaNac = jdtNacimiento.getDate();
Date fechaCon = jdtContratacion.getDate();

        if (fechaNac != null && fechaCon != null && sonFechasIguales(fechaNac, fechaCon)) {
            JOptionPane.showMessageDialog(this, "La fecha de nacimiento no puede ser igual a la fecha de contratación.");
            return; // Detener el proceso de registro si las fechas son iguales
        }
        if (!existePersonal(nombre, apellido)) {
            controlador.agregarPersonal(nombre, apellido, fechaNac, fechaCon);
            actualizarTabla();
            JOptionPane.showMessageDialog(this, "Personal registrado con éxito!");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "El personal con ese nombre y apellido ya existe.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
      int selectedRow = tbPersonal.getSelectedRow();
    if (selectedRow >= 0) {
        // Obtener el código del personal seleccionado
        String codigo = tableModel.getValueAt(selectedRow, 0).toString();
        
        // Obtener los datos del formulario
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        
        // Obtener las fechas desde los campos de fecha
        Date fechaNac = jdtNacimiento.getDate();
        Date fechaCon = jdtContratacion.getDate();

        // Validar que las fechas no sean iguales
        if (sonFechasIguales(fechaNac, fechaCon)) {
            JOptionPane.showMessageDialog(this, "Error: La fecha de nacimiento no puede ser igual a la fecha de contratación.");
            return; // Detener la ejecución si las fechas son iguales
        }

        // Validar que el nombre y el apellido no estén vacíos
        if (nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre y el apellido no pueden estar vacíos.");
            return; // Detener la ejecución si los campos están vacíos
        }

        // Intentar modificar los datos del personal en la base de datos
        boolean modificado = controlador.modificarPersonal(codigo, nombre, apellido, fechaNac, fechaCon);
        if (modificado) {
            // Actualizar el modelo de tabla
            tableModel.setValueAt(codigo, selectedRow, 0);
            tableModel.setValueAt(nombre, selectedRow, 1);
            tableModel.setValueAt(apellido, selectedRow, 2);
            tableModel.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(fechaNac), selectedRow, 3);
            tableModel.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(fechaCon), selectedRow, 4);

            JOptionPane.showMessageDialog(this, "Datos del personal modificados con éxito!");
            limpiarCampos(); // Limpiar los campos del formulario
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar los datos del personal en la base de datos.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un personal de la tabla para modificar.");
    }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = tbPersonal.getSelectedRow();
        if (selectedRow >= 0) {
            String codigo = tableModel.getValueAt(selectedRow, 0).toString();
            boolean eliminado = controlador.eliminarPersonal(codigo);
            if (eliminado) {
                actualizarTabla();
                JOptionPane.showMessageDialog(this, "Personal eliminado con éxito!");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar personal.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un personal de la tabla para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        jdtNacimiento.setDate(null);
        jdtContratacion.setDate(null);
    }

    private boolean existePersonal(String nombre, String apellido) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String nombreExistente = tableModel.getValueAt(i, 1).toString();
            String apellidoExistente = tableModel.getValueAt(i, 2).toString();
            if (nombreExistente.equalsIgnoreCase(nombre) && apellidoExistente.equalsIgnoreCase(apellido)) {
                return true;  // Retorna true si encuentra un duplicado
            }
        }
        return false;  // Retorna false si no encuentra duplicados
    }

    private boolean sonFechasIguales(Date fecha1, Date fecha2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(fecha1);
        cal2.setTime(fecha2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdtContratacion;
    private com.toedter.calendar.JDateChooser jdtNacimiento;
    private javax.swing.JTable tbPersonal;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
