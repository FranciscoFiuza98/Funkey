package view;
import model.Configuracao;
import model.Controlador;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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

public class Subscricao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtValor;
	private DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<Configuracao> dcbm2 = new DefaultComboBoxModel<Configuracao>();
	private JTextField textQuarto;
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
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
					Controlador.carregarSubscricao();
					Controlador.carregarConfiguracao();
					Subscricao frame = new Subscricao();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Subscricao() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					Controlador.saveFileSubscricao();
					Controlador.saveFileDivulgacao();
					Controlador.saveFileConfiguracao();
					Controlador.saveFileCliente();
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
		btnSubscricao.setBounds(12, 118, 156, 37);
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
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPerfil.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPerfil.setBackground(Color.DARK_GRAY);
			}
		});
		btnPerfil.setForeground(Color.ORANGE);
		btnPerfil.setFont(new Font("Arial", Font.BOLD, 15));
		btnPerfil.setBackground(Color.DARK_GRAY);
		
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
			public void actionPerformed(ActionEvent arg0) {
				Configuracoes frame = new Configuracoes();
				frame.setVisible(true);
				dispose();
			}
		});
		btnConfiguracoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfiguracoes.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConfiguracoes.setBackground(Color.DARK_GRAY);
			}
		});
		btnConfiguracoes.setForeground(Color.ORANGE);
		btnConfiguracoes.setFont(new Font("Arial", Font.BOLD, 15));
		btnConfiguracoes.setBackground(Color.DARK_GRAY);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 13, 179, 554);
		panel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/este.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		Image img3 = new ImageIcon(this.getClass().getResource("/subscricao.jpg")).getImage();
		
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
		lblTipologia.setBounds(251, 270, 93, 33);
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
		cmbConteudo.setBounds(322, 316, 172, 22);
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
					double valor = Controlador.procurarValorConteudo(conteudo);
					txtValor.setText(Double.toString(valor));
				}
				else
				{
					txtValor.setText("");
				}
				
				
			}
		});
		cmbTipologia.setModel(new DefaultComboBoxModel(new String[] {"Filmes", "Canais", "Document\u00E1rios", "S\u00E9ries", "Outros"}));
		cmbTipologia.setFont(new Font("Verdana", Font.PLAIN, 15));
		cmbTipologia.setBounds(322, 271, 172, 22);
		contentPane.add(cmbTipologia);
		
		
		
		
		
		JLabel lblValor = new JLabel("Pre\u00E7o");
		lblValor.setFont(new Font("Arial", Font.BOLD, 16));
		lblValor.setBounds(259, 351, 63, 33);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtValor.setBounds(322, 362, 172, 22);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnSubscrever = new JButton("Subscrever");
		btnSubscrever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quarto = Integer.parseInt(textQuarto.getText());
				String tipologia = cmbTipologia.getSelectedItem().toString();
				String conteudo = cmbConteudo.getSelectedItem().toString();
				double valor = Double.parseDouble(txtValor.getText());
				String data = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
				String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
				
				Controlador.adicionarSubscricao(quarto, tipologia, conteudo, valor, data, hora);
				JOptionPane.showMessageDialog(contentPane, "Subscrição concluída com sucesso!" );
	
			}
			
		});
		btnSubscrever.setForeground(Color.WHITE);
		btnSubscrever.setBackground(Color.DARK_GRAY);
		btnSubscrever.setFont(new Font("Verdana", Font.BOLD, 16));
		btnSubscrever.setBounds(325, 416, 169, 33);
		contentPane.add(btnSubscrever);
		
		JLabel lblQuarto = new JLabel("Quarto");
		lblQuarto.setFont(new Font("Arial", Font.BOLD, 16));
		lblQuarto.setBounds(241, 223, 69, 30);
		contentPane.add(lblQuarto);
		
		textQuarto = new JTextField();
		textQuarto.setBounds(322, 228, 172, 22);
		contentPane.add(textQuarto);
		textQuarto.setColumns(10);
		
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
				
				JLabel lblConteudo = new JLabel("Conteudo");
				lblConteudo.setFont(new Font("Arial", Font.BOLD, 16));
				lblConteudo.setBounds(217, 311, 93, 33);
				contentPane.add(lblConteudo);
				
				JLabel lblSubscrio = new JLabel("Subscri\u00E7\u00E3o");
				lblSubscrio.setForeground(Color.DARK_GRAY);
				lblSubscrio.setFont(new Font("Verdana", Font.BOLD, 23));
				lblSubscrio.setBounds(517, 112, 147, 38);
				contentPane.add(lblSubscrio);
				
				JLabel lblBemvindo = new JLabel("New label");
				lblBemvindo.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblBemvindo.setBounds(845, 27, 368, 16);
				contentPane.add(lblBemvindo);
				lblBemvindo.setText("Bem Vindo admin!");
				
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