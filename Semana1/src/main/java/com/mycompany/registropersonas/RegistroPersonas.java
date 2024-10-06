/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.registropersonas;

import Vista.IRegistro;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author ACER
 */
public class RegistroPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // Establecer el Look and Feel antes de crear el JFrame
            UIManager.setLookAndFeel(new  HiFiLookAndFeel()); // Cambia el Look and Feel según prefieras
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IRegistro().setVisible(true);
            }
        });
    }
}