package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.voeairlines.model.TipoAeronaveDTO;


public class TipoAeronaveDAO {

	private Connection connection;

	public TipoAeronaveDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void insert(TipoAeronaveDTO tipo) throws SQLException {
		
		String sql = "INSERT INTO aeronave_tipo (descricao) VALUES(?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, tipo.getDescricao());
		
		stmt.execute();
		
	}
	
	public ResultSet buscaID () {
		
		String sql = "SELECT * FROM aeronave_tipo ORDER BY descricao";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			return stmt.executeQuery();
			
		} catch (SQLException erro) {
			
			JOptionPane.showMessageDialog(null, "Erro Listar IDTipo" + erro.getMessage());
			return null;
		}
		

		
		
	}
}
