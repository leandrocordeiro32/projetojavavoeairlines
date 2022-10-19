package br.com.voeairlines.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.voeairlines.controller.AeronaveController;
import br.com.voeairlines.dao.TipoAeronaveDAO;
import br.com.voeairlines.model.TipoAeronaveDTO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.DefaultComboBoxModel;

public class AeronaveView extends JFrame implements ItemListener {

	private JPanel contentPane;


	private JTextField txtFabricante;
	private JTextField txtModelo;
	private JTextField txtCodigo;
	private JComboBox cbxTipo;
	private AeronaveController controller;
	
	Vector <Integer> IdTipo = new Vector<Integer>();

	
	public Vector<Integer> getIdTipo() {
		return IdTipo;
	}

	public void setIdTipo(Vector<Integer> cbxIdTipo) {
		this.IdTipo = cbxIdTipo;
	}
	
	public JComboBox getCbxTipo() {
		return cbxTipo;
	}

	public void setCbxTipo(JComboBox cbxTipo) {
		this.cbxTipo = cbxTipo;
	}

	public JTextField getTxtFabricante() {
		return txtFabricante;
	}
	
	public void setTxtFabricante(JTextField txtFabricante) {
		this.txtFabricante = txtFabricante;
	}
	
	public JTextField getTxtModelo() {
		return txtModelo;
	}
	
	public void setTxtModelo(JTextField txtModelo) {
		this.txtModelo = txtModelo;
	}
	
	public JTextField getTxtCodigo() {
		return txtCodigo;
	}
	
	public void setTxtCodigo(JTextField txtCodigo) {
		this.txtCodigo = txtCodigo;
	}
	

	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AeronaveView frame = new AeronaveView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AeronaveView() {
		
		controller = new AeronaveController(this);
		
		setTitle("VoeAirlines - Cadastro Aeronave");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFabricante.setBounds(43, 80, 86, 25);
		contentPane.add(lblFabricante);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipo.setBounds(43, 45, 86, 25);
		contentPane.add(lblTipo);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModelo.setBounds(43, 116, 86, 25);
		contentPane.add(lblModelo);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigo.setBounds(43, 152, 86, 25);
		contentPane.add(lblCodigo);
		
		cbxTipo = new JComboBox();
		cbxTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o tipo"}));
		cbxTipo.setBounds(154, 45, 211, 25);
		contentPane.add(cbxTipo);
		try {
			controller.restaurarComboBoxIDTipo(cbxTipo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	

		
		txtFabricante = new JTextField();
		txtFabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFabricante.setBounds(154, 80, 211, 25);
		contentPane.add(txtFabricante);
		txtFabricante.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModelo.setColumns(10);
		txtModelo.setBounds(154, 117, 211, 25);
		contentPane.add(txtModelo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(154, 152, 211, 25);
		contentPane.add(txtCodigo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.cadastraAeronave();
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar.setBounds(154, 202, 101, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AeronaveView.this.dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(265, 202, 101, 25);
		contentPane.add(btnCancelar);
		

		

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}



}
