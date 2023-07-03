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
import modelo.Estoque;

/**
 *
 * @author Carlos
 */
public class EstoqueDAO {
    public void salvar(Estoque e){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO estoque(lote,secao,quantidade,chegada,saida,descricao)VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, e.getLote());
            stmt.setString(2, e.getSecao());
            stmt.setInt(3, e.getQuantidade());
            stmt.setDate(4, new java.sql.Date (e.getChegada().getTime()));
            stmt.setDate(5, new java.sql.Date (e.getSaida().getTime()));
            stmt.setString(6, e.getDescricao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 }


public void atualizar(Estoque e){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoque SET lote = ?,secao = ?,quantidade = ?,chegada = ?,saida = ?,descricao = ? WHERE id_estoque = ?");
            stmt.setInt(1, e.getLote());
            stmt.setString(2, e.getSecao());
            stmt.setInt(3, e.getQuantidade());
            stmt.setDate(4, new java.sql.Date (e.getChegada().getTime()));
            stmt.setDate(5, new java.sql.Date (e.getSaida().getTime()));
            stmt.setString(6, e.getDescricao());
            stmt.setInt(7, e.getId_estoque());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 }    

public void excluir(Estoque e){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM estoque WHERE id_estoque = ?");
            stmt.setInt(1, e.getId_estoque());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao deletar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 }    

public List<Estoque> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM estoque");
            rs = stmt.executeQuery();
                    
            while (rs.next()){
            
                Estoque e = new Estoque();
                e.setId_estoque(rs.getInt("id_estoque"));
                e.setLote(rs.getInt("lote"));
                e.setSecao(rs.getString("secao"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setChegada(rs.getDate("chegada"));
                e.setSaida(rs.getDate("saida"));
                e.setDescricao(rs.getString("descricao"));
                estoques.add(e);
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return estoques;
    } 
}
