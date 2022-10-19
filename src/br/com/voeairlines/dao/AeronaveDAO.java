package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.voeairlines.model.AeronaveDTO;

public class AeronaveDAO {

	private Connection connection;

	public AeronaveDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void insert(AeronaveDTO aeronave) throws SQLException {
		
		String sql = "INSERT INTO aeronave (idTipo , fabricante , modelo , codigo) VALUES(? , ? , ? , ?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setInt(1, aeronave.getIdTipo());
		stmt.setString(2, aeronave.getFabricante());
		stmt.setString(3, aeronave.getModelo());
		stmt.setString(4, aeronave.getCodigo());	
		
		stmt.execute();
		
	}
}
