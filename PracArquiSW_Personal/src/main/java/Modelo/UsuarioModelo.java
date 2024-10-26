/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * 
 */
public class UsuarioModelo {
    private ArrayList<Usuario> listaUsuarios;
    
    public UsuarioModelo() {
        listaUsuarios = new ArrayList<>();
    }
    
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
}
