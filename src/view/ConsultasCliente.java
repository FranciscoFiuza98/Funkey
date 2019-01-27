package view;

import model.Controlador;
import model.Subscricao;
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
import java.io.FileNotFoundException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class ConsultasCliente extends JFrame {

	private JPanel contentPane;
	private JTable tableConsultas;
	private DefaultTableModel tableModel;
	private JTextField textHospede;
	private JTextField textData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Consultas frame = new Consultas(u);
					// frame.setVisible(true);
					// dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultasCliente() {
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
		setTitle("FunKey-Consultas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Centrar a janela
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

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
				SubscricaoCliente frame = new SubscricaoCliente();
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
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConsultas.setBounds(12, 313, 156, 37);
		panel.add(btnConsultas);
		btnConsultas.addMouseListener(new MouseAdapter() {
		});
		btnConsultas.setForeground(Color.ORANGE);
		btnConsultas.setFont(new Font("Arial", Font.BOLD, 15));
		btnConsultas.setBackground(SystemColor.activeCaption);

		JButton btnConsumo = new JButton("Consumo");
		btnConsumo.setBounds(12, 374, 156, 37);
		panel.add(btnConsumo);
		btnConsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		lblNewLabel.setBounds(0, 0, 179, 579);
		panel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/este.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));

		JLabel lblBemvindo = new JLabel("New label");
		lblBemvindo.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblBemvindo.setBounds(773, 13, 368, 16);
		contentPane.add(lblBemvindo);
		String bemvindo = (Controlador.getUtilizador().getNome());
		lblBemvindo.setText("Bem Vindo "+ bemvindo.toString()+ "!");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.controlHighlight);
		panel_6.setBounds(0, 558, 1016, 21);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblPoweredByFunkey = new JLabel("Powered by Funkey");
		lblPoweredByFunkey.setBounds(870, 0, 126, 14);
		lblPoweredByFunkey.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblPoweredByFunkey);
		// Botao de Logout
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
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 217, 645, 214);
		contentPane.add(scrollPane);

		JComboBox cmbTipologia = new JComboBox();
		cmbTipologia.setModel(new DefaultComboBoxModel(
				new String[] { " ", "Filmes", "Canais", "Document\u00E1rios", "S\u00E9ries", "Outros" }));
		cmbTipologia.setBounds(546, 167, 123, 20);
		contentPane.add(cmbTipologia);

		textHospede = new JTextField();
		textHospede.setBounds(546, 167, 124, 20);
		contentPane.add(textHospede);
		textHospede.setColumns(10);

		textData = new JTextField();
		textData.setBounds(546, 167, 122, 20);
		contentPane.add(textData);
		textData.setColumns(10);

		textHospede.setVisible(false);
		cmbTipologia.setVisible(false);
		textData.setVisible(false);

		JLabel lblExemplo = new JLabel("Exemplo: 01-06-2017");
		lblExemplo.setBounds(546, 136, 134, 18);
		contentPane.add(lblExemplo);
		lblExemplo.setVisible(false);

		JComboBox cmbFiltros = new JComboBox();
		cmbFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cmbFiltros.getSelectedItem().toString().equals("Todos")) {
					lblExemplo.setVisible(false);
					String[] colunas = { "Tipologia", "Conteúdo" };
					tableModel = new DefaultTableModel(colunas, 0);
					tableConsultas = new JTable(tableModel);
					scrollPane.setViewportView(tableConsultas);
					tableConsultas.setBackground(SystemColor.menu);
					textHospede.setVisible(false);
					cmbTipologia.setVisible(false);
					textData.setVisible(false);

				} else if (cmbFiltros.getSelectedItem().toString().equals("Tipologia")) {
					lblExemplo.setVisible(false);
					String[] colunas = { "Tipologia", "Conteúdo", "Data", "Hora" };
					tableModel = new DefaultTableModel(colunas, 0);
					tableConsultas = new JTable(tableModel);
					scrollPane.setViewportView(tableConsultas);
					tableConsultas.setBackground(SystemColor.menu);
					textHospede.setVisible(false);
					cmbTipologia.setVisible(true);
					textData.setVisible(false);

				} else if (cmbFiltros.getSelectedItem().toString().equals("Data")) {
					lblExemplo.setVisible(true);
					String[] colunas = { "Tipologia", "Conteúdo", "Data", "Hora" };
					tableModel = new DefaultTableModel(colunas, 0);
					tableConsultas = new JTable(tableModel);
					scrollPane.setViewportView(tableConsultas);
					tableConsultas.setBackground(SystemColor.menu);
					textHospede.setVisible(false);
					cmbTipologia.setVisible(false);
					textData.setVisible(true);
				} else if (cmbFiltros.getSelectedItem().toString().equals("Perfil")) {
					lblExemplo.setVisible(false);
					String[] colunas = { "Nome", "Email", "Quarto", "Checkin", "Checkout" };
					tableModel = new DefaultTableModel(colunas, 0);
					tableConsultas = new JTable(tableModel);
					scrollPane.setViewportView(tableConsultas);
					tableConsultas.setBackground(SystemColor.menu);
					textHospede.setVisible(false);
					cmbTipologia.setVisible(false);
					textData.setVisible(false);
				}
			}
		});
		cmbFiltros.setModel(new DefaultComboBoxModel(new String[] { " ", "Todos", "Tipologia", "Data", "Perfil" }));
		cmbFiltros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbFiltros.setBackground(Color.WHITE);
		cmbFiltros.setToolTipText("");
		cmbFiltros.setBounds(414, 167, 124, 20);
		contentPane.add(cmbFiltros);

		String[] colunas = { "Quarto", "Tipologia", "Conteúdo", "Valor", "Data", "Hora" };
		tableModel = new DefaultTableModel(colunas, 0);
		tableConsultas = new JTable(tableModel);
		scrollPane.setViewportView(tableConsultas);
		tableConsultas.setBackground(SystemColor.menu);

		// Confirmar
		JButton btnConfirmar = new JButton("Procurar");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBackground(Color.DARK_GRAY);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbFiltros.getSelectedItem().equals("Todos")) {
					atualizarTabelaQuarto();
				} else if (cmbFiltros.getSelectedItem().equals("Tipologia")) {
					atualizarTabelaTipologia(cmbTipologia.getSelectedItem().toString());
				} else if (cmbFiltros.getSelectedItem().equals("Data")) {

					atualizarDataehora(textData.getText());
				} else if (cmbFiltros.getSelectedItem().equals("Perfil")) {
					atualizarPerfis();
				} else {
					JOptionPane.showMessageDialog(null, "Escolha uma opção!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnConfirmar.setBounds(681, 168, 107, 23);
		contentPane.add(btnConfirmar);
		
		JLabel label = new JLabel("Consulta");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Verdana", Font.BOLD, 23));
		label.setBounds(546, 67, 123, 38);
		contentPane.add(label);

	}

	// Atualizar tabelas
	private void atualizarPerfis() {
		tableModel.setRowCount(0);
		for (int i = 0; i < Controlador.getUtilizadores().size(); i++) {
			if (Controlador.getUtilizador().getQuarto() == Controlador.getUtilizadores().get(i).getQuarto()) {
				Utilizador uti = Controlador.getUtilizadores().get(i);
				int quarto = uti.getQuarto();
				String email = uti.getEmail();
				String nome = uti.getNome();
				String checkin = uti.getCheckin();
				String checkout = uti.getCheckout();

				Object[] data2 = { nome, email, quarto, checkin, checkout };
				tableModel.addRow(data2);
			}
		}
	}

	private void atualizarTabelaQuarto() {
		tableModel.setRowCount(0);

		for (int i = 0; i < Controlador.getSubscricoes().size(); i++) {
			Subscricao sub = Controlador.getSubscricoes().get(i);
			if (Controlador.getUtilizador().getQuarto() == Controlador.getSubscricoes().get(i).getQuarto()) {
				int quarto = sub.getQuarto();
				String tipologia = sub.getTipologia();
				String conteudo = sub.getConteudo();

				Object[] data2 = { tipologia, conteudo };
				tableModel.addRow(data2);
			}
		}
	}

	private void atualizarDataehora(String registo) {
		tableModel.setRowCount(0);

		for (int i = 0; i < Controlador.getSubscricoes().size(); i++) {
			Subscricao sub = Controlador.getSubscricoes().get(i);
			if (Controlador.getUtilizador().getQuarto() == Controlador.getSubscricoes().get(i).getQuarto()) {
				if (registo.equals(sub.getData())) {
					int quarto = sub.getQuarto();
					String tipologia = sub.getTipologia();
					String conteudo = sub.getConteudo();
					String data = sub.getData();
					String hora = sub.getHora();

					Object[] data3 = {tipologia, conteudo, data, hora };
					tableModel.addRow(data3);
				}
			}
		}

	}

	private void atualizarTabelaTipologia(Object tipologia) {
		tableModel.setRowCount(0);

		for (int i = 0; i < Controlador.getSubscricoes().size(); i++) {
			Subscricao sub = Controlador.getSubscricoes().get(i);
			if (Controlador.getUtilizador().getQuarto() == Controlador.getSubscricoes().get(i).getQuarto()) {
				if (sub.getTipologia().equals(tipologia)) {
					int quarto = sub.getQuarto();
					String conteudo = sub.getConteudo();
					String tipologia2 = sub.getTipologia();
					String data = sub.getData();
					String hora = sub.getHora();

					Object[] data4 = { tipologia2, conteudo, data, hora };
					tableModel.addRow(data4);
				}
			}
		}

	}
}