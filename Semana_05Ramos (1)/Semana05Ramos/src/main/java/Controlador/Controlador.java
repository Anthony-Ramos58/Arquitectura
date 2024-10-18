package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import Vista.datos_Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    private PersonaDAO dao;
    private Persona p;
    private datos_Persona vista;
    private DefaultTableModel modelo;

    public Controlador(datos_Persona v) {
        this.vista = v;
        this.dao = new PersonaDAO();  // Inicializar DAO
        this.p = new Persona();  // Inicializar objeto Persona

        // Agregar los listeners a los botones usando los getters
        this.vista.getBtnListar().addActionListener(this);
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnEditar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnListar()) {
            listar(vista.getTblDatos());
        }
        if (e.getSource() == vista.getBtnGuardar()) {
            agregar();
        }
        if (e.getSource() == vista.getBtnEditar()) {
            editar();
        }
        if (e.getSource() == vista.getBtnEliminar()) {
            eliminar();
        }
    }

    public void limpiarCampos() {
        vista.getTxtId().setText("");
        vista.getTxtNombres().setText("");
        vista.getTxtCorreo().setText("");
        vista.getTxtTelefono().setText("");
    }

    // Método para listar datos
    public void listar(javax.swing.JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        for (Persona p : dao.listar()) {
            modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getCorreo(), p.getTelefono()});
        }
    }

    // Método para agregar una nueva persona
public void agregar() {
    String nombre = vista.getTxtNombres().getText();
    String correo = vista.getTxtCorreo().getText();
    String telefono = vista.getTxtTelefono().getText();
    p.setNombre(nombre);
    p.setCorreo(correo);
    p.setTelefono(telefono);
    int resultado = dao.agregar(p);
    if (resultado == 1) {
        vista.mostrarMensaje("Persona agregada correctamente");
        listar(vista.getTblDatos());
        limpiarCampos();  // Limpiar los campos después de guardar
    } else {
        vista.mostrarMensaje("Error al agregar la persona");
    }
}


    // Método para editar una persona
    public void editar() {
        int fila = vista.getTblDatos().getSelectedRow();
        if (fila == -1) {
            vista.mostrarMensaje("Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt(vista.getTxtId().getText());
            String nombre = vista.getTxtNombres().getText();
            String correo = vista.getTxtCorreo().getText();
            String telefono = vista.getTxtTelefono().getText();
            p.setId(id);
            p.setNombre(nombre);
            p.setCorreo(correo);
            p.setTelefono(telefono);
            int resultado = dao.actualizar(p);
            if (resultado == 1) {
                vista.mostrarMensaje("Persona actualizada correctamente");
                listar(vista.getTblDatos());
            } else {
                vista.mostrarMensaje("Error al actualizar la persona");
            }
        }
    }

    // Método para eliminar una persona
    public void eliminar() {
        int fila = vista.getTblDatos().getSelectedRow();
        if (fila == -1) {
            vista.mostrarMensaje("Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt(vista.getTblDatos().getValueAt(fila, 0).toString());
            dao.eliminar(id);
            vista.mostrarMensaje("Persona eliminada correctamente");
            listar(vista.getTblDatos());
        }
    }
}
