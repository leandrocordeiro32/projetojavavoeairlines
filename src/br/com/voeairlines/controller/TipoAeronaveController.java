package br.com.voeairlines.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.voeairlines.dao.ConnectionFactory;
import br.com.voeairlines.dao.TipoAeronaveDAO;
import br.com.voeairlines.model.TipoAeronaveDTO;
import br.com.voeairlines.view.TipoAeronaveView;


public class TipoAeronaveController {
	
	private TipoAeronaveView view;

	Connection con = new ConnectionFactory().recuperarConexao();

	public TipoAeronaveController(TipoAeronaveView view) {
		super();
		this.view = view;
	}
	
	public void cadastraTipoAeronave() {
		
		
		String descricao = view.getTxtDescricao().getText();
		
		TipoAeronaveDTO tipoNovo = new TipoAeronaveDTO(descricao);

		if (descricao.length() == 0) {
			
			JOptionPane.showMessageDialog(null, "Informe a descrição da aeronave para realizar o cadastro!");
			
		} else {
		
		try {
			
			TipoAeronaveDAO tipoDao = new TipoAeronaveDAO(con);
			tipoDao.insert(tipoNovo);
			
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.", 
					"VoeAirlines - Voando sempre com você" ,1);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
 

	}
}