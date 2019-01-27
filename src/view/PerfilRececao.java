package view;
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
import java.io.FileNotFoundException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PerfilRececao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableConsultas;
	private DefaultTableModel tableModel;
	private JTextField txtNome;
	private JTextField txtContribuinte;
	private JTextField txtEmail;
	private JTextField txtQuarto;
	private JTextField txtPass;
	private JPanel panel_1;
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
					//Controlador.carregarConfiguracao();
					Controlador.carregarFicheiroCliente();
					PerfilRececao frame = new PerfilRececao();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PerfilRececao() {
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
		setTitle("FunKey-Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Centrar a janela
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(604, 208, 417, 214);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
				
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.controlHighlight);
		panel_6.setBounds(0, 558, 1011, 21);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblBemvindo = new JLabel("New label");
		lblBemvindo.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblBemvindo.setBounds(773, 13, 368, 16);
		contentPane.add(lblBemvindo);
		lblBemvindo.setText("Bem Vindo rececao!");
		
		JLabel lblPoweredByFunkey = new JLabel("Powered by Funkey");
		lblPoweredByFunkey.setBounds(870, 0, 126, 14);
		lblPoweredByFunkey.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblPoweredByFunkey);
		
		JLabel lblNomeCompleto = new JLabel("Nome");
		lblNomeCompleto.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNomeCompleto.setBounds(451, 101, 138, 33);
		contentPane.add(lblNomeCompleto);
		
		JLabel lblContribuinte = new JLabel("N\u00FAmero de Contribuinte");
		lblContribuinte.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblContribuinte.setBounds(451, 230, 206, 16);
		contentPane.add(lblContribuinte);
		
		JLabel lblQuarto = new JLabel("Quarto");
		lblQuarto.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblQuarto.setBounds(451, 184, 56, 22);
		contentPane.add(lblQuarto);
		
		JLabel lblPass = new JLabel("Palavra-Passe");
		lblPass.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPass.setBounds(451, 148, 120, 16);
		contentPane.add(lblPass);
		
		JLabel lblEmail = new JLabel("Contacto de Email");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblEmail.setBounds(451, 264, 156, 22);
		contentPane.add(lblEmail);
		
		JLabel lblCheckIn = new JLabel("Check-In");
		lblCheckIn.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCheckIn.setBounds(380, 337, 77, 16);
		contentPane.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("Check-Out");
		lblCheckOut.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCheckOut.setBounds(380, 383, 92, 16);
		contentPane.add(lblCheckOut);
		
		txtNome = new JTextField();
		txtNome.setBounds(665, 108, 325, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtContribuinte = new JTextField();
		txtContribuinte.setColumns(10);
		txtContribuinte.setBounds(665, 229, 325, 22);
		contentPane.add(txtContribuinte);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(666, 266, 325, 22);
		contentPane.add(txtEmail);
		
		txtQuarto = new JTextField();
		txtQuarto.setColumns(10);
		txtQuarto.setBounds(665, 186, 56, 22);
		contentPane.add(txtQuarto);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(665, 147, 174, 22);
		contentPane.add(txtPass);
		JComboBox cbmDia = new JComboBox();
		cbmDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbmDia.setFont(new Font("Verdana", Font.PLAIN, 14));
		cbmDia.setBounds(594, 337, 56, 20);
		contentPane.add(cbmDia);
		
		JComboBox cbmMes = new JComboBox();
		cbmMes.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbmMes.setFont(new Font("Verdana", Font.PLAIN, 14));
		cbmMes.setBounds(679, 337, 56, 20);
		contentPane.add(cbmMes);
		
		JComboBox cbmAno = new JComboBox();
		cbmAno.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017", "2018"}));
		cbmAno.setFont(new Font("Verdana", Font.PLAIN, 14));
		cbmAno.setBounds(764, 336, 77, 20);
		contentPane.add(cbmAno);
		
		JComboBox cbmDia1 = new JComboBox();
		cbmDia1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbmDia1.setFont(new Font("Verdana", Font.PLAIN, 14));
		cbmDia1.setBounds(594, 384, 56, 20);
		contentPane.add(cbmDia1);
		
		JComboBox cbmMes1 = new JComboBox();
		cbmMes1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbmMes1.setFont(new Font("Verdana", Font.PLAIN, 14));
		cbmMes1.setBounds(679, 384, 56, 20);
		contentPane.add(cbmMes1);
		
		JComboBox cbmAno1 = new JComboBox();
		cbmAno1.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017", "2018"}));
		cbmAno1.setFont(new Font("Verdana", Font.PLAIN, 14));
		cbmAno1.setBounds(764, 384, 77, 20);
		contentPane.add(cbmAno1);
		
		JButton btnGuardar = new JButton("Guardar Dados");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String nome = txtNome.getText();
					int contribuinte = Integer.parseInt(txtContribuinte.getText());
					int quarto = Integer.parseInt(txtQuarto.getText());
					String pass = txtPass.getText();
					String email = txtEmail.getText();
					String checkin = cbmDia.getSelectedItem() + "-" + cbmMes.getSelectedItem() + "-" + cbmAno.getSelectedItem();
					String checkout = cbmDia1.getSelectedItem() + "-" + cbmMes1.getSelectedItem() + "-" + cbmAno1.getSelectedItem();
					
					
					if (txtNome.getText().equals("") || txtContribuinte.getText().equals("")|| txtPass.getText().equals("")|| txtQuarto.getText().equals("")|| txtEmail.getText().equals("") )
					{
						JOptionPane.showMessageDialog(contentPane, "Preencha todos os campos!" );
					}
					else
					{
					 int q = Controlador.verificarQuartoRepetido(Integer.parseInt(txtQuarto.getText()));
					 int a = Controlador.verificarNomeRepetido(txtNome.getText());
					if (a == 1 || q == 1)
					{
						JOptionPane.showMessageDialog(contentPane, "Cliente já existente!" );
					}
					else
					{
						Controlador.adicionarCliente(nome, contribuinte, quarto, pass, email, checkin, checkout);
						JOptionPane.showMessageDialog(contentPane, "Cliente criado com Sucesso!" );
					
					}
					}
					
				} catch (NumberFormatException f) {
				
					JOptionPane.showMessageDialog(contentPane, "Dados inválidos");
				}
				
	
			}
			
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setBounds(827, 499, 169, 33);
		contentPane.add(btnGuardar);
		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(10, 13, 179, 532);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnPerfil = new JButton("Perfil do Cliente");
		btnPerfil.setBounds(12, 246, 156, 37);
		panel_1.add(btnPerfil);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perfil frame = new Perfil();
				frame.setVisible(true);
				dispose();
			}
		});
		btnPerfil.setForeground(Color.ORANGE);
		btnPerfil.setFont(new Font("Arial", Font.BOLD, 15));
		btnPerfil.setBackground(SystemColor.activeCaption);
		
		JButton btnDivulgacao = new JButton("Divulga\u00E7\u00E3o");
		btnDivulgacao.setBounds(12, 180, 156, 37);
		panel_1.add(btnDivulgacao);
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
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.setBounds(12, 313, 156, 37);
		panel_1.add(btnConsultas);
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultasRececao frame = new ConsultasRececao();
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
		panel_1.add(btnConsumo);
		btnConsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsumoRececao frame = new ConsumoRececao();
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
		panel_1.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/este.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(216, 101, 212, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setBounds(40, 0, 212, 183);
		panel.add(lblNewLabel_1);
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
				btnNewButton.setBounds(934, 23, 56, 57);
				contentPane.add(btnNewButton);
				Image img3 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
				btnNewButton.setIcon(new ImageIcon(img3));
				
				JLabel label = new JLabel("Perfil");
				label.setForeground(Color.DARK_GRAY);
				label.setFont(new Font("Verdana", Font.BOLD, 23));
				label.setBounds(533, 30, 77, 38);
				contentPane.add(label);
				
				String[] colunas = {"Quartos Ocupados", "Checkin", "Checkout"};
				tableModel = new DefaultTableModel(colunas, 0);
				tableConsultas = new JTable(tableModel);
				scrollPane.setViewportView(tableConsultas);
				tableConsultas.setBackground(SystemColor.menu);
				
				JLabel lblNewLabel_2 = new JLabel("Ver quartos dispon\u00EDveis");
				lblNewLabel_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						atualizarTabelaQuarto();
						scrollPane.setVisible(true);			
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						scrollPane.setVisible(false);
					}
				});
				lblNewLabel_2.setBounds(733, 189, 156, 16);
				contentPane.add(lblNewLabel_2);
	}
	//ATUALIZAR TABELA DOS QUARTOS
	private void atualizarTabelaQuarto() {
		tableModel.setRowCount(0);			
		for (int i = 0; i < Controlador.getUtilizadores().size(); i++) {
			Utilizador uti = Controlador.getUtilizadores().get(i);
				int quarto = uti.getQuarto();
				String checkin = uti.getCheckin();
				String checkout = uti.getCheckout();
				
				Object[] data2 = {quarto, checkin, checkout};
				tableModel.addRow(data2);
		}
	}
				
	}