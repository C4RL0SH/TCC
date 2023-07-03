/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Funcionario;

/**
 *
 * @author Carlos
 */
public class FuncionarioDAO {
    public void salvar(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO funcionario(nome_funcionario,cpf_funcionario,rg_funcionario,email_funcionario,endereco_funcionario,telefone_funcionario,telefone2_funcionario	,idade_funcionario,data_nascimento_funcionario,sexo_funcionario,turno,cargo,salario,foto_funcionario,senha)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, f.getNome_funcionario());
            stmt.setString(2, f.getCpf_funcionario());
            stmt.setString(3, f.getRg_funcionario());
            stmt.setString(4, f.getEmail_funcionario());
            stmt.setString(5, f.getEndereco_funcionario());
            stmt.setString(6, f.getTelefone_funcionario());
            stmt.setString(7, f.getTelefone2_funcionario());
            stmt.setInt(8, f.getIdade_funcionario());
            stmt.setDate(9, new java.sql.Date (f.getData_nascimento_funcionario().getTime()));
            stmt.setString(10, f.getSexo_funcionario());
            stmt.setString(11, f.getTurno());
            stmt.setString(12, f.getCargo());
            stmt.setDouble(13, f.getSalario());
            stmt.setString(14, f.getFoto_funcionario());
            stmt.setString(15, f.getSenha());
            
            
      stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 }    
    
     public void atualizar(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionario SET nome_funcionario = ?,cpf_funcionario = ?,rg_funcionario = ?,email_funcionario = ?,endereco_funcionario = ?,telefone_funcionario = ?,telefone2_funcionario	 = ?,idade_funcionario = ?,data_nascimento_funcionario = ?,sexo_funcionario = ?,turno = ?,cargo = ?,salario = ?,foto_funcionario = ?, senha = ? WHERE id_funcionario = ?");
            stmt.setString(1, f.getNome_funcionario());
            stmt.setString(2, f.getCpf_funcionario());
            stmt.setString(3, f.getRg_funcionario());
            stmt.setString(4, f.getEmail_funcionario());
            stmt.setString(5, f.getEndereco_funcionario());
            stmt.setString(6, f.getTelefone_funcionario());
            stmt.setString(7, f.getTelefone2_funcionario());
            stmt.setInt(8, f.getIdade_funcionario());
            stmt.setDate(9, new java.sql.Date (f.getData_nascimento_funcionario().getDate()));
            stmt.setString(10, f.getSexo_funcionario());
            stmt.setString(11, f.getTurno());
            stmt.setString(12, f.getCargo());
            stmt.setDouble(13, f.getSalario());
            stmt.setString(14, f.getFoto_funcionario());
            stmt.setString(15, f.getSenha());
           
            
        stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 }

     public void excluir(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE id_funcionario = ?");        
            stmt.setInt(1, f.getIdade_funcionario());            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao deletar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 }
     
     public List<Funcionario> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();
                    
            while (rs.next()){
            
                Funcionario f = new Funcionario();
                f.setId_funcionario(rs.getInt("id_funcionario"));
                f.setNome_funcionario(rs.getString("nome_funcionario"));
                f.setCpf_funcionario(rs.getString("cpf_funcionario"));
                f.setRg_funcionario(rs.getString("rg_funcionario"));
                f.setEmail_funcionario(rs.getString("email_funcionario"));
                f.setEndereco_funcionario(rs.getString("endereco_funcionario"));
                f.setTelefone_funcionario(rs.getString("telefone_funcionario"));
                f.setTelefone2_funcionario(rs.getString("telefone2_funcionario"));
                f.setIdade_funcionario(rs.getInt("idade_funcionario"));
                f.setData_nascimento_funcionario(rs.getDate("data_nascimento_funcionario"));
                f.setSexo_funcionario(rs.getString("sexo_funcionario"));
                f.setTurno(rs.getString("turno"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getInt("salario"));
                f.setFoto_funcionario(rs.getString("foto_funcionario"));
                f.setSenha(rs.getString("senha"));
                funcionarios.add(f);
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return funcionarios;
    } 
     
     public boolean checkLogin(String Nome_funcionario, String Senha){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE nome_funcionario = ? and senha = ?");
            stmt.setString(1, Nome_funcionario);
            stmt.setString(2, Senha);
            rs = stmt.executeQuery();
                    
            if (rs.next()){
            
                check = true;
                
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    } 
}
