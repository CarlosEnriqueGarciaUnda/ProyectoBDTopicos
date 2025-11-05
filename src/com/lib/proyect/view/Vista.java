package com.lib.proyect.view;

import javax.swing.*;

public class Vista {


    private JTextField textFieldNombre;
    private JTextField textFieldPrimerApellido;
    private JTextField textFieldSegundoApellido;
    private JTextField textFieldRFC;
    private JButton guardarButton;

    public Vista(){
        guardarButton.addActionListener(e -> validarCampos());
    }

    private void validarCampos() {
        if (textFieldNombre.getText().trim().isEmpty() ||
                textFieldPrimerApellido.getText().trim().isEmpty() ||
                textFieldSegundoApellido.getText().trim().isEmpty() ||
                textFieldRFC.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
        } else {
            // Aquí podrías guardar los datos o continuar con el flujo
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        }
    }
}
