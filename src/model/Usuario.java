/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author edmar_sr
 */
public class Usuario {
    
    private String nomeUsuario;
    private int perfilUsuario;
     

    public String getNome() {
        return nomeUsuario;
    }

    public void setNome(String nomeCliente) {
        this.nomeUsuario = nomeCliente;
    }
    
    public int getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(int perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
    
}
