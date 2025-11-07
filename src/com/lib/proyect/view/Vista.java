package com.lib.proyect.view;

import com.lib.proyect.model.Persona;
import com.lib.proyect.model.PersonaDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    private JPanel panelPrincipal;
    private JTextField textFieldNombre;
    private JTextField textFieldPrimerApellido;
    private JTextField textFieldSegundoApellido;
    private JTextField textFieldCURP;
    private JButton guardarButton;
    private JPanel panelCentral;

    private final PersonaDAO personaDAO = new PersonaDAO();

    public Vista() {
        setTitle("Registro de Persona - PostgreSQL");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPersona();
            }
        });
    }

    private void guardarPersona() {
        String nombre = textFieldNombre.getText().trim();
        String pApellido = textFieldPrimerApellido.getText().trim();
        String mApellido = textFieldSegundoApellido.getText().trim();
        String curp = textFieldCURP.getText().trim(); // Usamos CURP

        if (nombre.isEmpty() || pApellido.isEmpty() || mApellido.isEmpty() || curp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos (Nombre, Apellidos y CURP) deben estar llenos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Persona nuevaPersona = new Persona(nombre, pApellido, mApellido, curp);

        boolean guardadoExitoso = personaDAO.guardarPersona(nuevaPersona);

        if (guardadoExitoso) {
            JOptionPane.showMessageDialog(this, "¡Persona guardada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar. Revise la consola y el CURP.", "Error de DB", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        textFieldNombre.setText("");
        textFieldPrimerApellido.setText("");
        textFieldSegundoApellido.setText("");
        textFieldCURP.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Vista().setVisible(true);
        });
    }
}