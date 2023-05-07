/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import persistence.Dao;
import telas.Cadastro;
import telas.EstoqueTela;

/**
 *
 * @author edmar_sr
 */
public class EstoqueDAO {
    
    java.sql.Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    

    public String pesquisaEstoque(double codigo) {
        conexao = Dao.conector();
        String sql = "select estoque from produtos where codigo = ?";
        //double estoque = 0;
        String estoque = "";
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, codigo);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                //estoque = rs.getDouble("estoque");
                estoque = rs.getString("estoque");
            }//else{
            //    JOptionPane.showMessageDialog(null, "Código " + codigo + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            //    estoque = "";
            //}
            
        } catch (Exception e) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.INFO, "(EstoqueDAO)Erro ao pesquisar estoque!", "");
            JOptionPane.showMessageDialog(null, e, "(EstoqueDAO)Erro ao pesquisar o estoque!!!", JOptionPane.ERROR_MESSAGE);   
        } 
        
        //return Double.toString(estoque);
        return estoque;
    }

    public String AtualizaEstoque(double entradaSaida, String codigo) {
        
        conexao = Dao.conector();
        String sql = "update produtos set estoque = ? where codigo = ?";
        String estoqueAtual = pesquisaEstoque(Double.parseDouble(codigo));
        Double atualizado = Double.parseDouble(estoqueAtual) + entradaSaida;
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, atualizado);
            pst.setString(2, codigo);
            int result = pst.executeUpdate();
            
            if(result == 1){
                JOptionPane.showMessageDialog(null, "Estoque atualizado ");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro ao atualizar o estoque!", JOptionPane.ERROR_MESSAGE);
        }
        
        return pesquisaEstoque(Double.parseDouble(codigo));
        
    }

    public String pesquisaNome(String nome) {
        
        conexao = Dao.conector();
        String sql = "select nome from produtos where codigo = ?";
        String nomeResult = "";
        
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                nomeResult = rs.getString("nome");
            }
            
        } catch (Exception e) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.INFO, "(EstoqueDAO)Erro ao pesquisar nome!", "");
            JOptionPane.showMessageDialog(null, e, "(EstoqueDAO)Erro ao pesquisar o nome!!!", JOptionPane.ERROR_MESSAGE);   
        } 
        
        //return Double.toString(estoque);
        return nomeResult; 
    }
    
}
