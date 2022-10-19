package br.com.voeairlines.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.voeairlines.dao.ConnectionFactory;
import br.com.voeairlines.dao.UsuarioDAO;
import br.com.voeairlines.model.UsuarioDTO;
import br.com.voeairlines.view.CadastroView;
import br.com.voeairlines.view.LoginView;
import br.com.voeairlines.view.MenuView;

public class LoginController {

	private LoginView view;

	Connection con = new ConnectionFactory().recuperarConexao();

	public LoginController(LoginView view) {
		super();
		this.view = view;
	}

	public void autenticar() throws SQLException {
		
		//Buscar usuário da view
		String usuario = view.getTxtUsuario().getText();
		String senha = new String (view.getPfSenha().getPassword()).trim();
		
		UsuarioDTO usuarioAutentica = new UsuarioDTO(usuario,senha);

		//Verificar se existe no banco
				
		UsuarioDAO usuarioDao = new UsuarioDAO(con);
		
		boolean confirm = usuarioDao.autenticarUsuario(usuarioAutentica);
		
		if (confirm) { 		//Se exisitr, direcionar para o menu.

			
			JOptionPane.showMessageDialog(null, "Login efetuado com sucesso." , "VoeAirlines" , 1);
			
			new MenuView();

		} else {
			
			int cad = JOptionPane.showConfirmDialog(null, "Usuária/o e/ou Senha Inválidos!" +
					"\nDeseja cadastrar usuária/o?", "VoeAirlines",
					JOptionPane.YES_NO_CANCEL_OPTION);
				if (cad == JOptionPane.YES_OPTION) {
					
					CadastroView telaDeCadastro = new CadastroView();
					telaDeCadastro.setVisible(true);


				}
				
		/*JOptionPane.showMessageDialog(null , "Usuário e/ou Senha Inválidos" , 
				"VoeAirlines" , JOptionPane.ERROR_MESSAGE);*/
		
		}
	
	}
	
}
