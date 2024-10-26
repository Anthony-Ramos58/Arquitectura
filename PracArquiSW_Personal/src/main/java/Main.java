/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xxx
 */
package com.mycompany.pracarquisw_personal;

import Controlador.SistemaController;
import Modelo.PersonalModelo;
import Vista.PrincipalView;

public class Main {
    public static void main(String[] args) {
        // Aquí va la lógica de tu aplicación
        System.out.println("Aplicación iniciada correctamente.");
    
        PersonalModelo personalModelo = new PersonalModelo();

        // Inicializar el controlador con el modelo
        SistemaController sistemaController = new SistemaController(personalModelo);

        // Inicializar la vista principal
        PrincipalView principalView = new PrincipalView();
        
        // Aquí puedes inicializar el controlador de la vista si es necesario
        // Ejemplo: principalView.setController(sistemaController);

        // Hacer la vista visible
        principalView.setVisible(true);
    }
}

