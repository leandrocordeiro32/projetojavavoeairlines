package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.voeairlines.model.UsuarioDTO;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void insert(UsuarioDTO usuario) throws SQLException {
		String sql = "INSERT INTO dados_Senhas(usuario, senha) VALUES(? , ?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, usuario.getUsuario());
		stmt.setString(2, usuario.getSenha());
		
		stmt.execute();
		
	}


	public boolean autenticarUsuario(UsuarioDTO usuario) throws SQLException {
		
		String sql = "SELECT * FROM dados_senhas WHERE usuario = ? and senha = ?";
		
		PreparedStatement stmt =  connection.prepareStatement(sql);
		
		stmt.setString(1, usuario.getUsuario());
		stmt.setString(2, usuario.getSenha());
		
		stmt.execute();

		ResultSet rs = stmt.getResultSet();
		
		return rs.next();
				
		//stmt.close();

	}


	
    /*int id;
    String usuario;
    String senha;
    
    public UsuarioDAO(){ 
    	ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperarConexao();
    } 
    public void adiciona(UsuarioDTO usuario){ 
    	
        String sql = "INSERT INTO dados_Senhas(usuario, senha) VALUES(?,?)";
        
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				JOptionPane.showMessageDialog(null, "Login efetuado com sucesso." , "VoeAirlines" , 1);
			} else {
				
				JOptionPane.showMessageDialog(null , "Usuário e/ou Senha Inválidos" , 
						"VoeAirlines" , JOptionPane.ERROR_MESSAGE);

			}
			
			stmt.close();
			//con.close();
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } */
}
