/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;



import modelo.Cliente;
import connection.ConnectionFactory;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Carlos
 */
public class ClienteDAO {
    
    public void salvar(Cliente c){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente(nome_cliente,cpf_cliente,rg_cliente,email_cliente,endereco_cliente,telefone_cliente,idade_cliente,data_nascimento_cliente,sexo_cliente)VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNome_cliente());
            stmt.setString(2, c.getCpf_cliente());
            stmt.setString(3, c.getRg_cliente());
            stmt.setString(4, c.getEmail_cliente());
            stmt.setString(5, c.getEndereco_cliente());
            stmt.setString(6, c.getTelefone_cliente());
            stmt.setInt(7, c.getIdade_cliente());
            stmt.setDate(8, new java.sql.Date (c.getData_nascimento_cliente().getDate()));
            stmt.setString(9,c.getSexo_cliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void atualizar(Cliente c){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome_cliente = ?,cpf_cliente = ?,rg_cliente = ?,email_cliente = ?,endereco_cliente = ?,telefone_cliente = ?,idade_cliente = ?,data_nascimento_cliente = ?,sexo_cliente = ? WHERE id_cliente = ?");
            stmt.setString(1, c.getNome_cliente());
            stmt.setString(2, c.getCpf_cliente());
            stmt.setString(3, c.getRg_cliente());
            stmt.setString(4, c.getEmail_cliente());
            stmt.setString(5, c.getEndereco_cliente());
            stmt.setString(6, c.getTelefone_cliente());
            stmt.setInt(7, c.getIdade_cliente());
            stmt.setDate(8, new java.sql.Date (c.getData_nascimento_cliente().getDate()));
            stmt.setString(9,c.getSexo_cliente());
            stmt.setInt(10, c.getId_cliente());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void excluir(Cliente c){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
            stmt.setInt(1, c.getId_cliente());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao deletar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Cliente> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
                    
            while (rs.next()){
            
                Cliente c = new Cliente();
                
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNome_cliente(rs.getString("nome_cliente"));
                c.setCpf_cliente(rs.getString("cpf_cliente"));
                c.setRg_cliente(rs.getString("rg_cliente"));
                c.setEmail_cliente(rs.getString("email_cliente"));
                c.setData_nascimento_cliente(rs.getDate("data_nascimento_cliente"));
                c.setIdade_cliente(rs.getInt("idade_cliente"));
                c.setTelefone_cliente(rs.getString("telefone_cliente"));
                c.setEndereco_cliente(rs.getString("endereco_cliente"));
                c.setSexo_cliente(rs.getString("sexo_cliente"));
            
                clientes.add(c);
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    } 
}
