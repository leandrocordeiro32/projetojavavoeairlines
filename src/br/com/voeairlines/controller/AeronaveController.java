package br.com.voeairlines.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.com.voeairlines.dao.AeronaveDAO;
import br.com.voeairlines.dao.ConnectionFactory;
import br.com.voeairlines.dao.TipoAeronaveDAO;
import br.com.voeairlines.model.AeronaveDTO;
import br.com.voeairlines.model.TipoAeronaveDTO;
import br.com.voeairlines.view.AeronaveView;
import br.com.voeairlines.view.TipoAeronaveView;

public class AeronaveController {

	private AeronaveView view;

	// Vector<Integer> idTipo = new Vector<Integer>();

	Connection con = new ConnectionFactory().recuperarConexao();

	public AeronaveController(AeronaveView view) {
		super();
		this.view = view;
	}

	public void cadastraAeronave() {

		int tipo = view.getCbxTipo().getSelectedIndex();
		String fabricante = view.getTxtFabricante().getText();
		String modelo = view.getTxtModelo().getText();
		String codigo = view.getTxtCodigo().getText();

		AeronaveDTO aeronaveNovo = new AeronaveDTO(tipo, fabricante, modelo, codigo);

		if (fabricante.length() == 0 || modelo.length() == 0 || codigo.length() == 0) {

			JOptionPane.showMessageDialog(null, "Informe os dados necessários para realizar o cadastro!");
			
		} else {
			try {

				AeronaveDAO aeronaveDao = new AeronaveDAO(con);
				aeronaveDao.insert(aeronaveNovo);

				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.",
						"VoeAirlines - Voando sempre com você", 1);

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Selecione o tipo de aeronave" , "VoeAirlines" , JOptionPane.NO_OPTION);
			}

		}
	}

	public void restaurarComboBoxIDTipo(JComboBox cbxTipo) throws SQLException {

		TipoAeronaveDAO tipoID = new TipoAeronaveDAO(con);
		ResultSet rs = tipoID.buscaID();

		while (rs.next()) {

			view.getIdTipo().addElement(rs.getInt(1));
			cbxTipo.addItem(rs.getString(2));
			view.getCbxTipo().getSelectedItem();
		}
	}

}

/*
 * public void restaurarComboBoxIDTipo(JComboBox cbxTipo) throws SQLException {
 * 
 * 
 * TipoAeronaveDAO tipoID = new TipoAeronaveDAO(con); ResultSet rs =
 * tipoID.buscaID();
 * 
 * while(rs.next()) {
 * 
 * view.getIdTipo().addElement(rs.getInt(1)); cbxTipo.addItem(rs.getString(2));
 * } }
 */
