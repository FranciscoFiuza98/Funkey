package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import model.Controlador;

public class Inicio extends JWindow {

	private int duration;

	public Inicio(int d) {
		duration = d;
	}
	
	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.white);

		int width = 720;
		int height = 480;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		Image img = new ImageIcon(this.getClass().getResource("/Inicio.png")).getImage();
		JLabel label = new JLabel(new ImageIcon(img));
		

		content.add(label, BorderLayout.CENTER);

		setVisible(true);

		try {
			Controlador.carregarFicheiroCliente();
			Controlador.carregarConfiguracao();
			Controlador.carregarFicheiroDivulgacao();
			Controlador.carregarSubscricao();
			
			Thread.sleep(duration);
		} catch (Exception e) {
		}

		setVisible(false);
	}

	public void showSplashAndLogin() {
		showSplash();
		Login frame = new Login();
		frame.setVisible(true);		
		dispose();
	}

	public static void main(String[] args) {
		Inicio splash = new Inicio(2000);
		splash.showSplashAndLogin();
	}
}
