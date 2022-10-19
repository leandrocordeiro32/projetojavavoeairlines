package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String url = "jdbc:mysql://localhost/db_senhas?useTimeZone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "#Marilyn666";
	
	Connection con;
	
	public Connection recuperarConexao() {
		try {
			
			con = DriverManager.getConnection(url , user , password);
		
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		return con;
		
	}
	

}
