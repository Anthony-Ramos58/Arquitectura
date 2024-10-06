/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.registro_modelo_vista_controlador;

import Vista.IRegistro;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel; // Importamos el TextureLookAndFeel

import javax.swing.UIManager;

/**
 *
 * @author Asus
 */
public class REGISTRO_Modelo_Vista_Controlador {

    public static void main(String[] args) {
        try {
            // Establecer el Look and Feel de Texture desde JTattoo
            UIManager.setLookAndFeel(new TextureLookAndFeel());
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
