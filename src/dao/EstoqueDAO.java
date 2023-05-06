/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import persistence.Dao;

/**
 *
 * @author edmar_sr
 */
public class EstoqueDAO {
    
    java.sql.Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //conexao = Dao.conector();

    public String pesquisaEstoque(double codigo) {
        conexao = Dao.conector();
        String sql = "select estoque from produtos where codigo = ?";
        double estoque = 0;
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, codigo);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                estoque = rs.getDouble("estoque");
            }else{
                JOptionPane.showMessageDialog(null, "Código " + codigo + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro ao pesquisar o estoque!", JOptionPane.ERROR_MESSAGE);
        }
        return Double.toString(estoque);
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
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Estoque atualidado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro ao atualiza o estoque!", JOptionPane.ERROR_MESSAGE);
        }
        
        return pesquisaEstoque(Double.parseDouble(codigo));
        
    }
    
}