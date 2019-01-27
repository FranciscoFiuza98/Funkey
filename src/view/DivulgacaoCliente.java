package view;

import model.Utilizador;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class DivulgacaoCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					Controlador.carregarFicheiroDivulgacao();
					Controlador.saveFileConfiguracao();
					Controlador.saveFileSubscricao();
					Controlador.carregarFicheiroCliente();
					DivulgacaoCliente frame = new DivulgacaoCliente();
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
	public DivulgacaoCliente() {
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
		setTitle("FunKey-Divulgação");
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
			
			@Override
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
		btnDivulgacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDivulgacao.setForeground(Color.ORANGE);
		btnDivulgacao.setFont(new Font("Arial", Font.BOLD, 15));
		btnDivulgacao.setBackground(SystemColor.activeCaption);
		
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
		lblNewLabel.setBounds(0, 0, 179, 578);
		panel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/este.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		
		JLabel lblBemvindo = new JLabel("New label");
		lblBemvindo.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblBemvindo.setBounds(773, 13, 368, 16);
		contentPane.add(lblBemvindo);
		String bemvindo = (Controlador.getUtilizador().getNome());
		lblBemvindo.setText("Bem Vindo "+ bemvindo.toString()+ "!");
		
		
		int quarto = Controlador.getUtilizador().getQuarto();
		for (int i = 0; i < Controlador.getDivulgacoes().size(); i++ )
		if (Controlador.procurarDiv(quarto) != null)
		{
			String texto = Controlador.procurarDiv(quarto);
			textPane.setText(texto);
		}
		
		
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBackground(SystemColor.activeCaption);
		textPane.setBounds(282, 103, 658, 332);
		contentPane.add(textPane);
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
				
				JLabel lblNotificaes = new JLabel("Notifica\u00E7\u00F5es");
				lblNotificaes.setForeground(Color.DARK_GRAY);
				lblNotificaes.setFont(new Font("Verdana", Font.BOLD, 23));
				lblNotificaes.setBounds(531, 52, 185, 38);
				contentPane.add(lblNotificaes);
	}
}