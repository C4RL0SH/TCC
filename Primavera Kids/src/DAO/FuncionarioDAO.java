
package DAO;


import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Funcionario;
import GUI.funcionario;
import java.text.SimpleDateFormat;

/**
 *
 * @author Carlos
 */
public class FuncionarioDAO {
    public void salvar(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO funcionario(nome_funcionario,email_funcionario,cpf_funcionario,rg_funcionario,data_nascimento_funcionario,idade_funcionario,telefone_funcionario,telefone2_funcionario,endereco_funcionario,sexo_funcionario,turno,cargo,salario,senha,foto_funcionario)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, f.getNome_funcionario());
            stmt.setString(2, f.getEmail_funcionario());
            stmt.setString(3, f.getCpf_funcionario());
            stmt.setString(4, f.getRg_funcionario());           
            stmt.setDate(5, new java.sql.Date (f.getData_nascimento_funcionario().getTime()));
            stmt.setInt(6, f.getIdade_funcionario());            
            stmt.setString(7, f.getTelefone_funcionario());
            stmt.setString(8, f.getTelefone2_funcionario());
            stmt.setString(9, f.getEndereco_funcionario());
            stmt.setString(10, f.getSexo_funcionario());
            stmt.setString(11, f.getCargo());
            stmt.setString(12, f.getTurno());            
            stmt.setDouble(13, f.getSalario());
            stmt.setString(14, f.getSenha());
            stmt.setString(15, f.getFoto_funcionario());
            
            
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
            stmt = con.prepareStatement("UPDATE funcionario SET nome_funcionario = ?,email_funcionario= ?,cpf_funcionario = ?,rg_funcionario = ?,data_nascimento_funcionario = ?,idade_funcionario = ?,telefone_funcionario = ?,telefone2_funcionario = ?,endereco_funcionario = ?,sexo_funcionario = ?,turno = ?,cargo = ?,salario = ?,senha = ?,foto_funcionario = ? WHERE id_funcionario = ?");
            stmt.setString(1, f.getNome_funcionario());
            stmt.setString(2, f.getEmail_funcionario());
            stmt.setString(3, f.getCpf_funcionario());
            stmt.setString(4, f.getRg_funcionario());            
            stmt.setDate(5, new java.sql.Date (f.getData_nascimento_funcionario().getTime()));
            stmt.setInt(6, f.getIdade_funcionario());            
            stmt.setString(7, f.getTelefone_funcionario());
            stmt.setString(8, f.getTelefone2_funcionario());
            stmt.setString(9, f.getEndereco_funcionario());
            stmt.setString(10, f.getSexo_funcionario());
            stmt.setString(11, f.getCargo());
            stmt.setString(12, f.getTurno());            
            stmt.setDouble(13, f.getSalario());
            stmt.setString(14, f.getSenha());
            stmt.setString(15, f.getFoto_funcionario());
           
            
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
            stmt.setInt(1, f.getId_funcionario());            
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
                f.setEmail_funcionario(rs.getString("email_funcionario"));
                f.setCpf_funcionario(rs.getString("cpf_funcionario"));
                f.setRg_funcionario(rs.getString("rg_funcionario"));
                f.setData_nascimento_funcionario(rs.getDate("data_nascimento_funcionario"));
                f.setIdade_funcionario(rs.getInt("idade_funcionario"));                
                f.setTelefone_funcionario(rs.getString("telefone_funcionario"));
                f.setTelefone2_funcionario(rs.getString("telefone2_funcionario"));
                f.setEndereco_funcionario(rs.getString("endereco_funcionario"));                
                f.setSexo_funcionario(rs.getString("sexo_funcionario"));
                f.setCargo(rs.getString("cargo"));
                f.setTurno(rs.getString("turno"));                
                f.setSalario(rs.getDouble("salario"));
                f.setSenha(rs.getString("senha"));
                f.setFoto_funcionario(rs.getString("foto_funcionario"));
                
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
