package com.juliana.clinica_USA.vista;

import com.juliana.clinica_USA.controller.PacientController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

public class PacienteVista {
    @Autowired
    PacientController pacientController;
    private JPanel panel1;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JButton agregarCitaButton;
    private JTable table1;
}
