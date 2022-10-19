package br.com.voeairlines.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.voeairlines.controller.CadastroController;
import br.com.voeairlines.dao.ConnectionFactory;
import br.com.voeairlines.dao.UsuarioDAO;
import br.com.voeairlines.model.UsuarioDTO;

public class CadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private CadastroController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroView frame = new CadastroView();
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
	public CadastroView() {
		
		controller = new CadastroController(this);
		
		setResizable(false);
		setTitle("VoeAirlines - Cadastro de Usuário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 395, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		JLabel lbNovoUsuario = new JLabel("Usuário");
		lbNovoUsuario.setForeground(Color.MAGENTA);
		lbNovoUsuario.setFont(new Font("Verdana", Font.PLAIN, 18));
		lbNovoUsuario.setBounds(27, 57, 77, 23);
		contentPane.add(lbNovoUsuario);
		
		JLabel lbNovaSenha = new JLabel("Senha");
		lbNovaSenha.setForeground(Color.MAGENTA);
		lbNovaSenha.setFont(new Font("Verdana", Font.PLAIN, 18));
		lbNovaSenha.setBounds(27, 113, 77, 23);
		contentPane.add(lbNovaSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtUsuario.setBounds(114, 57, 231, 23);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtSenha.setBounds(114, 113, 231, 23);
		contentPane.add(txtSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.salvaUsuario();
				
			}
		});
		
		btnSalvar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSalvar.setBounds(167, 169, 116, 23);
		contentPane.add(btnSalvar);
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(JPasswordField txtSenha) {
		this.txtSenha = txtSenha;
	}
	

}
