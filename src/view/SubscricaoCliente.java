package view;
import model.Configuracao;
import model.Controlador;
import model.Utilizador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class SubscricaoCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private static final long serialVersionUID = 1L;
	private JTextField txtValor;
	private DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<Configuracao> dcbm2 = new DefaultComboBoxModel<Configuracao>();
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
					Controlador.carregarFicheiroCliente();
					Controlador.carregarConfiguracao();
					Controlador.carregarSubscricao();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SubscricaoCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					Controlador.saveFileSubscricao();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		setIconImage(icon);
		setResizable(false);
		setTitle("FunKey-Subscrição");
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
		btnSubscricao.setBounds(12, 189, 156, 37);
		panel.add(btnSubscricao);
		btnSubscricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubscricao.addMouseListener(new MouseAdapter() {
			
		});
		btnSubscricao.setFont(new Font("Arial", Font.BOLD, 15));
		btnSubscricao.setBackground(SystemColor.activeCaption);
		btnSubscricao.setForeground(Color.ORANGE);
		
		JButton btnDivulgacao = new JButton("Not\u00EDcias");
		btnDivulgacao.setBounds(12, 251, 156, 37);
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
				DivulgacaoCliente frame = new DivulgacaoCliente();
				frame.setVisible(true);
				dispose();
			}
		});
		btnDivulgacao.setForeground(Color.ORANGE);
		btnDivulgacao.setFont(new Font("Arial", Font.BOLD, 15));
		btnDivulgacao.setBackground(Color.DARK_GRAY);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.setBounds(12, 313, 156, 37);
		panel.add(btnConsultas);
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultasCliente frame = new ConsultasCliente();
				frame.setVisible(true);
				dispose();
			}
		});
		btnConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultas.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultas.setBackground(Color.DARK_GRAY);
			}
		});
		btnConsultas.setForeground(Color.ORANGE);
		btnConsultas.setFont(new Font("Arial", Font.BOLD, 15));
		btnConsultas.setBackground(Color.DARK_GRAY);
		
		JButton btnConsumo = new JButton("Consumo");
		btnConsumo.setBounds(12, 374, 156, 37);
		panel.add(btnConsumo);
		btnConsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsumoCliente frame = new ConsumoCliente();
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
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 13, 179, 554);
		panel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/este.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.controlHighlight);
		panel_6.setBounds(0, 558, 1016, 21);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblPoweredByFunkey = new JLabel("Powered by Funkey");
		lblPoweredByFunkey.setBounds(870, 0, 126, 14);
		lblPoweredByFunkey.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblPoweredByFunkey);
		JLabel lblTipologia = new JLabel("Tipo");
		lblTipologia.setFont(new Font("Arial", Font.BOLD, 16));
		lblTipologia.setBounds(312, 212, 93, 33);
		contentPane.add(lblTipologia);
		
		JComboBox cmbConteudo = new JComboBox();
		cmbConteudo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
				if (cmbConteudo.getSelectedIndex() != -1)
				{
					String conteudo = cmbConteudo.getSelectedItem().toString();
					int valor = Controlador.procurarValorConteudo(conteudo);
					txtValor.setText(Integer.toString(valor));
				}
			}
		});
		cmbConteudo.setFont(new Font("Verdana", Font.PLAIN, 15));
		cmbConteudo.setBounds(365, 263, 164, 22);
		cmbConteudo.setModel(dcbm);
		contentPane.add(cmbConteudo);
		
		
		
		JComboBox cmbTipologia = new JComboBox();
		cmbTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = dcbm.getSize() - 1; i >= 0 ; i--)
				{
					dcbm.removeElementAt(i);
				}
				
				for (Configuracao c : Controlador.getConfiguracoes())
				{
					if (cmbTipologia.getSelectedItem().toString().equals(c.getTipologia()))
					{
						dcbm.addElement(c.getConteudo());
					}
				}
				
				if (cmbConteudo.getSelectedIndex() != -1)
				{
					String conteudo = cmbConteudo.getSelectedItem().toString();
					int valor = Controlador.procurarValorConteudo(conteudo);
					txtValor.setText(Integer.toString(valor));
				}
				else
				{
					txtValor.setText("");
				}
				
				
			}
		});
		cmbTipologia.setModel(new DefaultComboBoxModel(new String[] {"Filmes", "Canais", "Document\u00E1rios", "S\u00E9ries", "Outros"}));
		cmbTipologia.setFont(new Font("Verdana", Font.PLAIN, 15));
		cmbTipologia.setBounds(365, 217, 164, 22);
		contentPane.add(cmbTipologia);
		
		
		JLabel lblBemvindo = new JLabel("New label");
		lblBemvindo.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblBemvindo.setBounds(773, 13, 368, 16);
		contentPane.add(lblBemvindo);
		String bemvindo = (Controlador.getUtilizador().getNome());
		lblBemvindo.setText("Bem Vindo "+ bemvindo.toString()+ "!");
		
		
		
		JLabel lblValor = new JLabel("Pre\u00E7o em euros");
		lblValor.setFont(new Font("Arial", Font.BOLD, 16));
		lblValor.setBounds(227, 316, 126, 16);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtValor.setBounds(365, 313, 164, 22);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnSubscrever = new JButton("Subscrever");
		btnSubscrever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quarto = Controlador.getUtilizador().getQuarto();
				String tipologia = cmbTipologia.getSelectedItem().toString();
				String conteudo = cmbConteudo.getSelectedItem().toString();
				double valor = Double.parseDouble(txtValor.getText());
				String data = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
				String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
				int selectedOption = JOptionPane.showConfirmDialog(null,
						"Tem a certeza que quer comprar este conteúdo?", "Message",
						JOptionPane.YES_NO_OPTION);
				if (selectedOption == JOptionPane.YES_OPTION) {
					Controlador.adicionarSubscricao(quarto, tipologia, conteudo, valor, data, hora);
				
				}
	
			}
			
		});
		btnSubscrever.setForeground(Color.WHITE);
		btnSubscrever.setBackground(Color.DARK_GRAY);
		btnSubscrever.setFont(new Font("Verdana", Font.BOLD, 16));
		btnSubscrever.setBounds(314, 387, 169, 33);
		contentPane.add(btnSubscrever);
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
				
				JLabel lblConteudo = new JLabel("Conte\u00FAdo");
				lblConteudo.setFont(new Font("Arial", Font.BOLD, 16));
				lblConteudo.setBounds(271, 266, 127, 16);
				contentPane.add(lblConteudo);
				
				JLabel label = new JLabel("Subscri\u00E7\u00E3o");
				label.setForeground(Color.DARK_GRAY);
				label.setFont(new Font("Verdana", Font.BOLD, 23));
				label.setBounds(526, 91, 147, 38);
				contentPane.add(label);
				
				String[] colunas = {"Tipologia", "Conteúdo", "Valor"};
				tableModel = new DefaultTableModel(colunas, 0);
				table = new JTable();
				table.setFont(new Font("Verdana", Font.PLAIN, 14));
				table.setBounds(617, 119, 346, 348);
				table.setModel(tableModel);
				contentPane.add(table);
				tableModel.setRowCount(0);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(580, 255, 398, 198);
				contentPane.add(scrollPane);
				
				JButton btnVerBibilioteca = new JButton("Ver Bibilioteca");
				btnVerBibilioteca.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						atualizarTabela();
					}
				});
				btnVerBibilioteca.setFont(new Font("Verdana", Font.PLAIN, 15));
				btnVerBibilioteca.setForeground(Color.DARK_GRAY);
				btnVerBibilioteca.setBounds(709, 198, 138, 30);
				contentPane.add(btnVerBibilioteca);
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