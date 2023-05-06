/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author edmar_sr
 */
public class Cliente {
    
    public String nomeCliente;
    public String endereco;
    public String cpf_cnpj;
    public String telefone;
    public String email;

    public String getNome() {
        return nomeCliente;
    }

    public void setNome(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente() {
    }

    public Cliente(String nomeCliente, String endereco, String cpf_cnpj, String telefone, String email) {
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return nomeCliente;
    }
    
    
}
