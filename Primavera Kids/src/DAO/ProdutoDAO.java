    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Produto;

/**
 *
 * @author Carlos
 */
public class ProdutoDAO {
    
    public void salvar(Produto p){
        
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto(nome_produto,nome_fornecedor,data_registro,categoria,quantidade,tamanho,preco_produto,preco_compra,desconto)VALUES(?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, p.getNome_produto());
            stmt.setString(2, p.getNome_fornecedor());                        
            stmt.setDate(3, new java.sql.Date (p.getData_registro().getTime()));
            stmt.setString(4, p.getCategoria());
            stmt.setInt(5, p.getQuantidade());
            stmt.setString(6, p.getTamanho());
            stmt.setDouble(7, p.getPreco_produto());
            stmt.setDouble(8, p.getPreco_compra());
            stmt.setInt(9, p.getDesconto());
            
            
        stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 }
    
    public void atualizar(Produto p){
        
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET nome_produto = ?,nome_fornecedor = ?,data_registro = ?,categoria = ?,quantidade = ?,tamanho = ?,preco_produto = ?,preco_compra = ?,desconto = ? WHERE codigo_produto = ?");
            stmt.setString(1, p.getNome_produto());
            stmt.setString(2, p.getNome_fornecedor());                        
            stmt.setDate(3, new java.sql.Date (p.getData_registro().getTime()));
            stmt.setString(4, p.getCategoria());
            stmt.setInt(5, p.getQuantidade());
            stmt.setString(6, p.getTamanho());
            stmt.setDouble(7, p.getPreco_produto());
            stmt.setDouble(8, p.getPreco_compra());
            stmt.setInt(9, p.getDesconto());
            stmt.setInt(10, p.getCodigo_produto());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 }
    
    public void excluir(Produto p){
        
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE codigo_produto = ?");
            stmt.setInt(1, p.getCodigo_produto());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao deletar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 }
    
    public List<Produto> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();
                    
            while (rs.next()){
            
                Produto p = new Produto();
                
                p.setCodigo_produto(rs.getInt("codigo_produto"));
                p.setNome_produto(rs.getString("nome_produto"));
                p.setNome_fornecedor(rs.getString("nome_fornecedor"));                
                p.setData_registro(rs.getDate("data_registro"));
                p.setCategoria(rs.getString("categoria"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setTamanho(rs.getString("tamanho"));
                p.setPreco_produto(rs.getDouble("preco_produto"));
                p.setPreco_compra(rs.getDouble("preco_compra"));
                p.setDesconto(rs.getInt("desconto"));
            
                produtos.add(p);
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    } 
}
