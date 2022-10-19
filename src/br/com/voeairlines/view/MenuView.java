package br.com.voeairlines.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuView implements ActionListener {
	
	JLabel jlab;
	
	public MenuView () {
		
		JFrame jfrm = new JFrame ("VoeAirlines - Gerenciamento de Atividades");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(500 , 300);
		jfrm.setLocationRelativeTo(null);
		jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Criar um rótulo que exibirá a opção feita no menu
		
		jlab = new JLabel();
		
		//Criar a barra de menu
		
		JMenuBar jmbAero = new JMenuBar();
		JMenuBar jmbTipo = new JMenuBar();

		
		//Criar o menu
		
		JMenu jmAeronave = new JMenu ("Aeronave");
		
		//Criar os itens de menu
		
		JMenuItem jmiCadastrarAero = new JMenuItem("Cadastrar");
		JMenuItem jmiPesquisarAero = new JMenuItem("Pesquisar");
		JMenuItem jmiDeletarAero = new JMenuItem("Deletar");
		
		jmAeronave.add(jmiCadastrarAero);
		jmAeronave.add(jmiPesquisarAero);
		jmAeronave.add(jmiDeletarAero);
		
		jmbAero.add(jmAeronave);
		
		
		JMenu jmTipoAeronave = new JMenu ("Tipo");
		
		//Criar os itens de menu
		
		JMenuItem jmiCadastrarTipoAero = new JMenuItem("Cadastrar");
		JMenuItem jmiPesquisarTipoAero = new JMenuItem("Pesquisar");
		JMenuItem jmiDeletarTipoAero = new JMenuItem("Deletar");
		
		jmTipoAeronave.add(jmiCadastrarTipoAero);
		jmTipoAeronave.add(jmiPesquisarTipoAero);
		jmTipoAeronave.add(jmiDeletarTipoAero);
		
		jmbTipo.add(jmTipoAeronave);
		
		//Adicionar o menubar ao formulário
		
		jfrm.add(jmbAero);
		jfrm.add(jmbTipo);
		jfrm.setVisible(true);

		//Designar açoes aos itens de menu
		//Aeronave
		
		//Cadastrar
		jmiCadastrarAero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				AeronaveView telaDeCadastro = new AeronaveView();
				telaDeCadastro.setVisible(true);
			}
		});
		//Tipo de Aeronave
		
		//Cadastrar
		jmiCadastrarTipoAero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				TipoAeronaveView telaDeCadastro = new TipoAeronaveView();
				telaDeCadastro.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	
	}

}
