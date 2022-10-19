package br.com.voeairlines.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.voeairlines.dao.ConnectionFactory;
import br.com.voeairlines.dao.UsuarioDAO;
import br.com.voeairlines.model.UsuarioDTO;
import br.com.voeairlines.view.CadastroView;

public class CadastroController {

	private CadastroView view;

	Connection con = new ConnectionFactory().recuperarConexao();

	public CadastroController(CadastroView view) {
		super();
		this.view = view;
	}
	
	public void salvaUsuario() {
		
		
		String usuario = view.getTxtUsuario().getText();
		String senha = new String (view.getTxtSenha().getPassword()).trim();
		

		UsuarioDTO usuarioNovo = new UsuarioDTO(usuario,senha);

		if (usuario.length() == 0 || senha.length() == 0) {
			
			JOptionPane.showMessageDialog(null, " Informe usuária/o e/ou a senha para realizar o cadastro!");
			
		} else {
		
		try {
			
			UsuarioDAO usuarioDao = new UsuarioDAO(con);
			usuarioDao.insert(usuarioNovo);
			
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.", 
					"VoeAirlines - Voando sempre com você" ,1);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	}
}
