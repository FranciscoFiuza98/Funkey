package view;
import model.Utilizador;
import model.Subscricao;
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
import java.io.FileNotFoundException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class ConsumoRececao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblConsumo;
	private DefaultTableModel tableModel;
	private DefaultComboBoxModel<String> dcbmQuarto = new DefaultComboBoxModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controlador.carregarFicheiroCliente();
					Controlador.carregarSubscricao();
					//Consumo frame = new Consumo(u);
					//frame.setVisible(true);
					//dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsumoRececao() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				try {
					Controlador.saveFileCliente();
					Controlador.saveFileDivulgacao();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		setIconImage(icon);
		setResizable(false);
		setTitle("FunKey-Consumo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Centrar a janela
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.controlHighlight);
		panel_6.setBounds(0, 558, 1016, 21);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblPoweredByFunkey = new JLabel("Powered by Funkey");
		lblPoweredByFunkey.setBounds(870, 0, 126, 14);
		lblPoweredByFunkey.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblPoweredByFunkey);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 13, 179, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
				DivulgacaoRececao frame = new DivulgacaoRececao();
				frame.setVisible(true);
				dispose();
			}
		});
		btnDivulgacao.setForeground(Color.ORANGE);
		btnDivulgacao.setFont(new Font("Arial", Font.BOLD, 15));
		btnDivulgacao.setBackground(Color.DARK_GRAY);
		
		JButton btnPerfil = new JButton("Perfil do Cliente");
		btnPerfil.setBounds(12, 246, 156, 37);
		panel.add(btnPerfil);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerfilRececao frame = new PerfilRececao();
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
				ConsultasRececao frame = new ConsultasRececao();
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
		btnConsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsumoRececao frame = new ConsumoRececao();
				frame.setVisible(true);
				dispose();
			}
		});
		btnConsumo.setBounds(12, 374, 156, 37);
		panel.add(btnConsumo);
		btnConsumo.setForeground(Color.ORANGE);
		btnConsumo.setFont(new Font("Arial", Font.BOLD, 15));
		btnConsumo.setBackground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 179, 579);
		panel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/este.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		

		JLabel lblQuarto = new JLabel("Quarto");
		lblQuarto.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblQuarto.setBounds(31, 32, 56, 21);
		contentPane.add(lblQuarto);
		
		
		JComboBox<String> cmbQuarto = new JComboBox<String>();
		dcbmQuarto.addElement("Quarto");
		cmbQuarto.setBounds(281, 141, 128, 22);
				for (Subscricao sub : Controlador.getSubscricoes()) {
					
					int cont = 0;
					
					for (int j = 1; j < dcbmQuarto.getSize(); j++)
					{
						if (Integer.parseInt(dcbmQuarto.getElementAt(j).toString()) == sub.getQuarto())
						{
							cont++;
						}
					}
					if (cont == 0)
					{
						dcbmQuarto.addElement(Integer.toString(sub.getQuarto()));
					}
				}
		cmbQuarto.setModel(dcbmQuarto);
		contentPane.add(cmbQuarto);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (cmbQuarto.getSelectedItem().toString().equals("Quarto"))
				{
					JOptionPane.showMessageDialog(null, "Escolha um quarto.");
				}
				else
				{
					int quarto = Integer.parseInt(cmbQuarto.getSelectedItem().toString());
					atualizarTabela(quarto);
					
				}
			}
		});
		btnProcurar.setForeground(new Color(255, 255, 255));
		btnProcurar.setBackground(Color.DARK_GRAY);
		btnProcurar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnProcurar.setBounds(438, 139, 116, 25);
		contentPane.add(btnProcurar);
		
		String[] colunas = {"Quarto ", "Tipologia", "Conteúdo", "Valor"};
		tableModel = new DefaultTableModel(colunas, 0);
		tblConsumo = new JTable();
		tblConsumo.setBackground(Color.LIGHT_GRAY);
		tblConsumo.setFont(new Font("Verdana", Font.PLAIN, 14));
		tblConsumo.setBounds(332, 136, 502, 276);
		tblConsumo.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(tblConsumo);
		scrollPane.setBounds(281, 194, 588, 246);
		contentPane.add(scrollPane);
		
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
				
				JLabel label = new JLabel("Consumo");
				label.setForeground(Color.DARK_GRAY);
				label.setFont(new Font("Verdana", Font.BOLD, 23));
				label.setBounds(515, 56, 133, 38);
				contentPane.add(label);
				
				JLabel lblBemvindo = new JLabel("New label");
				lblBemvindo.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblBemvindo.setBounds(773, 13, 368, 16);
				contentPane.add(lblBemvindo);
				lblBemvindo.setText("Bem Vindo rececao!");
	}

	private void atualizarTabela(int numeroQuarto) {
		tableModel.setRowCount(0);
		for (Subscricao s : Controlador.getSubscricoes())
		{
			if (numeroQuarto == s.getQuarto())
			{
			int quarto = s.getQuarto();
			String tipologia = s.getTipologia();
			String conteudo = s.getConteudo();
			Double valor = s.getValor();
			
			Object[] linha = {quarto, tipologia, conteudo, valor};
			tableModel.addRow(linha);
			}
		}
	}
}
