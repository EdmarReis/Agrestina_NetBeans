/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.swing.JOptionPane;
import persistence.Dao;

/**
 *
 * @author edmar_sr
 */
public class ProdutoDAO {
    
    java.sql.Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void alterarProduto(String preco, String produto, String descricao, String unidade, String caminhoFoto, String codigo, boolean ativo, boolean inativo) {
    //public void alterarProduto(String preco, String produto, String descricao, String unidade, String caminhoFoto, String codigo) {    
        conexao = Dao.conector();
        String sql = "update produtos set preco = ?, nome = ?, descricao = ?, unidade = ?, foto = ?, ativo = ? where codigo = ?";
        //String sql = "update produtos set preco = ?, nome = ?, descricao = ?, unidade = ?, foto = ? where codigo = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, preco);
            pst.setString(2, produto);
            pst.setString(3, descricao);
            pst.setString(4, unidade);
            //pst.setString(5, txtFoto.getText());
            pst.setString(5, caminhoFoto);
            pst.setString(7, codigo);
            if(ativo){
                pst.setBoolean(6, true);
            }
            if(inativo){
                pst.setBoolean(6, false);
            }
            int alteracao = pst.executeUpdate();

            if (alteracao > 0) {
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma alteração foi realizada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro ao alterar!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void salvarProduto(String codigo, String preco, String descricao, String produto, String unidade, String caminhoFoto, boolean ativo, boolean inativo) {
    //public void salvarProduto(String codigo, String preco, String descricao, String produto, String unidade, String caminhoFoto) {    
        conexao = Dao.conector();
        String sql = "insert into produtos (codigo,preco,descricao,nome,unidade,foto,estoque,ativo) values (?,?,?,?,?,?,?,?)";
        //String sql = "insert into produtos (codigo,preco,descricao,nome,unidade,foto,estoque,ativo) values (?,?,?,?,?,?,0,true)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, codigo);
            pst.setString(2, preco);
            pst.setString(3, descricao);
            pst.setString(4, produto);
            pst.setString(5, unidade);
            pst.setString(7, "0");
            pst.setString(6, caminhoFoto);
            if(ativo){
                pst.setBoolean(8, true);
            }
            if(inativo){
                pst.setBoolean(8, false);
            }
            pst.execute();

            JOptionPane.showMessageDialog(null, "Produto incluído com sucesso");

        } catch (SQLIntegrityConstraintViolationException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Código ja existe no banco ou algum registro obrigatório não foi preenchido. " + "\n" + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro ao salvar!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
