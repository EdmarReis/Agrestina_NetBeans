/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author edmar_sr
 */
public class Dao {
    
    protected Connection conexao;
	
	public static Connection conector(){
		
		java.sql.Connection conexao = null;
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/agrestina";
		String usu = "root";
		String pass = "1996testE";
		
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, usu, pass);
			return conexao;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
    
}
