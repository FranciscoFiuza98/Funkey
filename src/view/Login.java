package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Controlador;
import model.Utilizador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUtilizador;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controlador.carregarConfiguracao();
					Controlador.carregarFicheiroDivulgacao();
					Controlador.carregarFicheiroCliente();
					Controlador.carregarSubscricao();
					Login frame = new Login();
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
	public Login() {
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
		setTitle("FunKey");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 618);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Centrar a janela
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		JLabel lblUsername = new JLabel("Nome de Utilizador: ");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 17));
		lblUsername.setBounds(57, 190, 175, 14);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 17));
		lblPassword.setBounds(57, 254, 155, 14);
		contentPane.add(lblPassword);

		txtUtilizador = new JTextField("");
		txtUtilizador.setBounds(238, 183, 198, 30);
		contentPane.add(txtUtilizador);
		txtUtilizador.setColumns(10);

		//BOTAO ENTRAR
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(Color.DARK_GRAY);
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEntrar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				//Verifique se os campos estão preenchidos
				if (txtUtilizador.getText().equals("") || txtPassword.getText().equals(""))
				{
					JOptionPane.showMessageDialog(contentPane, "Verifique se os campos estão preenchidos");
				}
				//Login como admin
				else if (txtUtilizador.getText().equals("admin") && txtPassword.getText().equals("admin"))
				{
					JOptionPane.showMessageDialog(contentPane, "Bem vindo" + " " + txtUtilizador.getText()+ "!" );
					Subscricao frame = new Subscricao();
					frame.setVisible(true);
					dispose();
					
				}
				//Login como rececao
				else if (txtUtilizador.getText().equals("rececao") && txtPassword.getText().equals("1234"))
				{
					JOptionPane.showMessageDialog(contentPane, "Bem vindo" + " " + txtUtilizador.getText()+ "!" );
					DivulgacaoRececao frame = new DivulgacaoRececao();
					frame.setVisible(true);
					dispose();
				}
				else
				//Login como utilizador
				{
					int login = Controlador.Login(txtUtilizador.getText(), txtPassword.getText());
				
				if (login == 0)
				{
					JOptionPane.showMessageDialog(contentPane, "Password Incorreta" );
				}
				else if (login == 1)
				{
					JOptionPane.showMessageDialog(contentPane, "Utilizador Inválido" );
				}
				else
				{
					Utilizador cliente = Controlador.procurarClientePorLogin(txtUtilizador.getText());
					Controlador.setUtilizador(cliente);
					JOptionPane.showMessageDialog(contentPane, "Bem-Vindo" + " " + txtUtilizador.getText() + "!" );
					SubscricaoCliente frame = new SubscricaoCliente();
					frame.setVisible(true);
					dispose();
				}
				
				}
			}
			
		});
		btnEntrar.setBounds(115, 337, 198, 38);
		contentPane.add(btnEntrar);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(238, 247, 198, 30);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img2 = new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(0, 0, 1016, 583);
		contentPane.add(lblNewLabel);
	}
}
