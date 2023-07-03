/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Cliente {
    private int id_cliente;
    private String nome_cliente;
    private String cpf_cliente;
    private String rg_cliente;
    private String email_cliente;
    private String endereco_cliente;
    private String telefone_cliente;
    private int idade_cliente;
    private Date data_nascimento_cliente;
    private String sexo_cliente;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getRg_cliente() {
        return rg_cliente;
    }

    public void setRg_cliente(String rg_cliente) {
        this.rg_cliente = rg_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getEndereco_cliente() {
        return endereco_cliente;
    }

    public void setEndereco_cliente(String endereco_cliente) {
        this.endereco_cliente = endereco_cliente;
    }
    
    

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    public int getIdade_cliente() {
        return idade_cliente;
    }

    public void setIdade_cliente(int idade_cliente) {
        this.idade_cliente = idade_cliente;
    }

    public Date getData_nascimento_cliente() {
        return data_nascimento_cliente;
    }

    public void setData_nascimento_cliente(Date data_nascimento_cliente) {
        this.data_nascimento_cliente = data_nascimento_cliente;
    }

    public String getSexo_cliente() {
        return sexo_cliente;
    }

    public void setSexo_cliente(String sexo_cliente) {
        this.sexo_cliente = sexo_cliente;
    }


    
    
}
