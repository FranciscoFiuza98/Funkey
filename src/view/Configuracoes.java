package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Configuracao;
import model.Controlador;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class Configuracoes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;
	private JTextField txtConteudo;
	private JTable table;
	private DefaultTableModel tableModel;
	private void close()
	{
		dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controlador.carregarConfiguracao();
					Configuracoes frame = new Configuracoes();
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
	public Configuracoes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				try {
					Controlador.saveFileCliente();
					Controlador.saveFileSubscricao();
					Controlador.saveFileDivulgacao();
					Controlador.saveFileConfiguracao();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		setIconImage(icon);
		setResizable(false);
		setTitle("FunKey-Configurações");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Centrar a janela
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 13, 179, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSubscricao = new JButton("Subscri\u00E7\u00E3o");
		btnSubscricao.setBounds(12, 118, 156, 37);
		panel.add(btnSubscricao);
		btnSubscricao.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Subscricao frame = new Subscricao();
				frame.setVisible(true);
				dispose();
			}
		});
		btnSubscricao.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnSubscricao.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSubscricao.setBackground(Color.DARK_GRAY);
			}
		});
		btnSubscricao.setFont(new Font("Arial", Font.BOLD, 15));
		btnSubscricao.setBackground(Color.DARK_GRAY);
		btnSubscricao.setForeground(Color.ORANGE);
		
		JButton btnDivulgacao = new JButton("Divulga\u00E7\u00E3o");
		btnDivulgacao.setBounds(12, 180, 156, 37);
		panel.add(btnDivulgacao);
		btnDivulgacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDivulgacao.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDivulgacao.setBackground(Color.DARK_GRAY);
			}
		});
		btnDivulgacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Divulgacao frame = new Divulgacao();
				frame.setVisible(true);
				dispose();
			}
		});
		btnDivulgacao.setForeground(Color.ORANGE);
		btnDivulgacao.setFont(new Font("Arial", Font.BOLD, 15));
		btnDivulgacao.setBackground(Color.DARK_GRAY);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 179, 579);
		panel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/este.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JButton btnPerfil = new JButton("Perfil do Cliente");
		btnPerfil.setBounds(12, 246, 156, 37);
		panel.add(btnPerfil);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perfil frame = new Perfil();
				frame.setVisible(true);
				dispose();
			}
		});
		btnPerfil.setForeground(Color.ORANGE);
		btnPerfil.setFont(new Font("Arial", Font.BOLD, 15));
		btnPerfil.setBackground(Color.DARK_GRAY);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.setBounds(12, 313, 156, 37);
		panel.add(btnConsultas);
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultas frame = new Consultas();
				frame.setVisible(true);
				dispose();
			}
		});
		btnConsultas.addMouseListener(new MouseAdapter() {
		});
		btnConsultas.setForeground(Color.ORANGE);
		btnConsultas.setFont(new Font("Arial", Font.BOLD, 15));
		btnConsultas.setBackground(Color.DARK_GRAY);
		
		JButton btnConsumo = new JButton("Consumo");
		btnConsumo.setBounds(12, 374, 156, 37);
		panel.add(btnConsumo);
		btnConsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consumo frame = new Consumo();
				frame.setVisible(true);
				dispose();
			}
		});
		btnConsumo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsumo.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConsumo.setBackground(Color.DARK_GRAY);
			}
		});
		btnConsumo.setForeground(Color.ORANGE);
		btnConsumo.setFont(new Font("Arial", Font.BOLD, 15));
		btnConsumo.setBackground(Color.DARK_GRAY);
		
		JButton btnConfiguracoes = new JButton("Configura\u00E7\u00F5es");
		btnConfiguracoes.setBounds(12, 437, 156, 37);
		panel.add(btnConfiguracoes);
		btnConfiguracoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfiguracoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		btnConfiguracoes.setForeground(Color.ORANGE);
		btnConfiguracoes.setFont(new Font("Arial", Font.BOLD, 15));
		btnConfiguracoes.setBackground(SystemColor.activeCaption);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.controlHighlight);
		panel_6.setBounds(0, 558, 1016, 21);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblPoweredByFunkey = new JLabel("Powered by Funkey");
		lblPoweredByFunkey.setBounds(870, 0, 126, 14);
		lblPoweredByFunkey.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblPoweredByFunkey);
		
		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblTipologia.setBounds(260, 159, 104, 21);
		contentPane.add(lblTipologia);
		
		JLabel lblConteudo = new JLabel("Conte\u00FAdo");
		lblConteudo.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblConteudo.setBounds(488, 162, 83, 14);
		contentPane.add(lblConteudo);
		
		JLabel lblValor = new JLabel("Pre\u00E7o");
		lblValor.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblValor.setBounds(719, 160, 54, 18);
		contentPane.add(lblValor);
		
		JLabel lblBemvindo = new JLabel("New label");
		lblBemvindo.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblBemvindo.setBounds(773, 13, 368, 16);
		contentPane.add(lblBemvindo);
		lblBemvindo.setText("Bem Vindo admin!");
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtValor.setBounds(583, 159, 124, 21);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JComboBox<Object> cbmTipologia = new JComboBox<Object>();
		cbmTipologia.setFont(new Font("Verdana", Font.PLAIN, 15));
		cbmTipologia.setModel(new DefaultComboBoxModel(new String[] {"Filmes", "Canais", "Document\u00E1rios", "S\u00E9ries", "Outros"}));
		cbmTipologia.setBounds(352, 160, 123, 20);
		contentPane.add(cbmTipologia);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String tipologia = (String) cbmTipologia.getSelectedItem();
				String conteudo = txtConteudo.getText();
				double valor = 0;
				try
				{
				 valor = Double.parseDouble(txtValor.getText());	
				 int a = Controlador.verificarConteudoRepetido(txtConteudo.getText());
					if (a == 1)
					{
						JOptionPane.showMessageDialog(contentPane, "Conteudo já existente!" );
					}
					else
					{
					Controlador.adicionarConteudo(tipologia, conteudo, valor);
					JOptionPane.showMessageDialog(contentPane, "Conteúdo criado com Sucesso!" );
					atualizarTabela();
					}
				}
				catch (NumberFormatException f)
				{
					JOptionPane.showMessageDialog(contentPane, "Dados inválidos");
				}
					
				
		}
	});
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAdicionar.setBackground(Color.DARK_GRAY);
		btnAdicionar.setBounds(439, 474, 149, 29);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(new Color(255, 255, 255));
		btnRemover.setBackground(Color.DARK_GRAY);
		btnRemover.setFont(new Font("Verdana", Font.BOLD, 16));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(null, "Selecione um conteúdo a remover.");
				}
				else
				{
					int indexLinha = table.getSelectedRow();
					String nome = (String) table.getValueAt(indexLinha, 1);
					int selectedOption = JOptionPane.showConfirmDialog(null,
							"Está prestes a remover uma configuração. Tem a certeza?", "Message",
							JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {
						Controlador.removerConteudoPorNome(nome);
						tableModel.removeRow(indexLinha);
					}
					
				}	
			}
		});
		
		
		btnRemover.setBounds(613, 474, 149, 29);
		contentPane.add(btnRemover);
		txtConteudo = new JTextField();
		txtConteudo.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtConteudo.setColumns(10);
		txtConteudo.setBounds(778, 159, 156, 21);
		contentPane.add(txtConteudo);
		//Botao de Logout
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedOption = JOptionPane.showConfirmDialog(null, "Tem a certeza que quer sair da conta atual?",
						"Message", JOptionPane.YES_NO_OPTION);
				if (selectedOption == JOptionPane.YES_OPTION) {
					Controlador.logout();
					Login frame = new Login();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(948, 488, 56, 57);
		contentPane.add(btnNewButton);
		Image img2 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));

		
		String[] colunas = {"Tipologia", "Conteúdo", "Valor"};
		tableModel = new DefaultTableModel(colunas, 0);
		table = new JTable();
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.setBounds(617, 119, 346, 348);
		table.setModel(tableModel);
		contentPane.add(table);
		tableModel.setRowCount(0);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(264, 207, 670, 236);
		contentPane.add(scrollPane);
		
		JLabel lblConfigurao = new JLabel("Configura\u00E7\u00E3o");
		lblConfigurao.setForeground(Color.DARK_GRAY);
		lblConfigurao.setFont(new Font("Verdana", Font.BOLD, 23));
		lblConfigurao.setBounds(492, 61, 187, 38);
		contentPane.add(lblConfigurao);
		atualizarTabela();
	}

	private void atualizarTabela() {
		tableModel.setRowCount(0);
		for (Configuracao c : Controlador.getConfiguracoes())
		{
			String tipologia = c.getTipologia();
			String conteudo = c.getConteudo();
			Double valor = c.getValor();
			
			Object[] linha = {tipologia, conteudo, valor};
			tableModel.addRow(linha);
		}
		
	}
}