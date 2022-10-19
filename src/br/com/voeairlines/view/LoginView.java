package br.com.voeairlines.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;

import br.com.voeairlines.controller.CadastroController;
import br.com.voeairlines.controller.LoginController;
import br.com.voeairlines.dao.ConnectionFactory;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;

public class LoginView extends JFrame {

	private JPanel contentPane;

	private JTextField txtUsuario;
	private JPasswordField pfSenha;
	private JButton btnCadastrar;
	private LoginController controller;

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}
	
	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}
	
	public JPasswordField getPfSenha() {
		return pfSenha;
	}
	
	public void setPfSenha(JPasswordField pfSenha) {
		this.pfSenha = pfSenha;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		
		controller = new LoginController(this);
		
		setResizable(false);
		setTitle("VoeAirlines - Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 258);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setForeground(Color.MAGENTA);
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblUsuario.setBounds(30, 38, 76, 33);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.MAGENTA);
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSenha.setBounds(30, 94, 76, 33);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtUsuario.setBounds(116, 40, 239, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(116, 99, 239, 30);
		contentPane.add(pfSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(SystemColor.activeCaption);
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controller.autenticar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
										
			}
			
		});
		btnEntrar.setBounds(116, 165, 116, 30);
		contentPane.add(btnEntrar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(SystemColor.activeCaption);
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroView telaDeCadastro = new CadastroView();
				telaDeCadastro.setVisible(true);
				
			}
		});
		btnCadastrar.setBounds(242, 165, 113, 30);
		contentPane.add(btnCadastrar);
	}
}
