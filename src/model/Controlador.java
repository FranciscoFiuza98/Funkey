package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.PrintWriter;

public class Controlador {

	private static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
	private static ArrayList<Subscricao> subscricoes = new ArrayList<Subscricao>();
	private static ArrayList<Configuracao> configuracoes = new ArrayList<Configuracao>();
	private static ArrayList<Divulgacao> divulgacoes = new ArrayList<Divulgacao>();
	private static Utilizador utilizador;

	// Getters and setters

	public static ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public static void setUtilizadores(ArrayList<Utilizador> utilizadores) {
		Controlador.utilizadores = utilizadores;
	}

	public static ArrayList<Subscricao> getSubscricoes() {
		return subscricoes;
	}

	public static void setSubscricoes(ArrayList<Subscricao> subscricoes) {
		Controlador.subscricoes = subscricoes;
	}

	public static ArrayList<Divulgacao> getDivulgacoes() {
		return divulgacoes;
	}

	public static void setDivulgacoes(ArrayList<Divulgacao> divulgacoes) {
		Controlador.divulgacoes = divulgacoes;
	}

	public static ArrayList<Configuracao> getConfiguracoes() {
		return configuracoes;
	}

	public static void setConfiguracoes(ArrayList<Configuracao> configuracoes) {
		Controlador.configuracoes = configuracoes;
	}

	public static Utilizador getUtilizador() {
		return utilizador;
	}

	public static void setUtilizador(Utilizador utilizador) {
		Controlador.utilizador = utilizador;
	}

	// Carregar os ficheiros .txt

	public static void carregarFicheiroDivulgacao() throws FileNotFoundException {
		File file = new File("divulgacao.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String linha = input.nextLine();
			String[] linhaSplit = linha.split("#");
			Divulgacao d = new Divulgacao(Integer.parseInt(linhaSplit[0]), linhaSplit[1]);
			divulgacoes.add(d);
		}
		input.close();
	}

	public static void carregarFicheiroCliente() throws FileNotFoundException {
		File file = new File("perfilcliente.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String linha = input.nextLine();
			String[] linhaSplit = linha.split("#");
			Utilizador u = new Utilizador(linhaSplit[0], Integer.parseInt(linhaSplit[1]), linhaSplit[2],
					Integer.parseInt(linhaSplit[3]), linhaSplit[4], linhaSplit[5], linhaSplit[6]);
			utilizadores.add(u);
		}
		input.close();
	}

	public static void carregarSubscricao() throws FileNotFoundException {
		File file = new File("subscricoes.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String linha = input.nextLine();
			String[] linhaSplit = linha.split("#");
			Subscricao s = new Subscricao(Integer.parseInt(linhaSplit[0]), (linhaSplit[1]), (linhaSplit[2]),
					Double.parseDouble(linhaSplit[3]), (linhaSplit[4]), (linhaSplit[5]));
			subscricoes.add(s);
		}
		input.close();
	}

	public static void carregarConfiguracao() throws FileNotFoundException {
		File file = new File("configuracoes.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String linha = input.nextLine();
			String[] linhaSplit = linha.split("#");
			Configuracao c = new Configuracao(linhaSplit[0], linhaSplit[1], Double.parseDouble(linhaSplit[2]));
			configuracoes.add(c);
		}
		input.close();
	}

	// Guardar nos ficheiros .txt

	public static void saveFileDivulgacao() throws FileNotFoundException {

		File file = new File("divulgacao.txt");
		PrintWriter out = new PrintWriter(file);
		for (Divulgacao div : divulgacoes) {
			out.println(div.getQuarto() + "#" + div.getTexto());
		}
		out.close();
	}

	public static void saveFileCliente() throws FileNotFoundException {

		File file = new File("perfilcliente.txt");
		PrintWriter out = new PrintWriter(file);
		for (Utilizador utilizadores : utilizadores) {
			out.println(utilizadores.getNome() + "#" + utilizadores.getContribuinte() + "#" + utilizadores.getEmail()
					+ "#" + utilizadores.getQuarto() + "#" + utilizadores.getPass() + "#" + utilizadores.getCheckin()
					+ "#" + utilizadores.getCheckout());
		}
		out.close();
	}

	public static void saveFileSubscricao() throws FileNotFoundException {

		File file = new File("subscricoes.txt");
		PrintWriter out = new PrintWriter(file);
		for (Subscricao subscricoes : subscricoes) {
			out.println(subscricoes.getQuarto() + "#" + subscricoes.getTipologia() + "#" + subscricoes.getConteudo()
					+ "#" + subscricoes.getValor() + "#" + subscricoes.getData() + "#" + subscricoes.getHora());
		}
		out.close();
	}

	public static void saveFileConfiguracao() throws FileNotFoundException {

		File file = new File("configuracoes.txt");
		PrintWriter out = new PrintWriter(file);
		for (Configuracao configuracoes : configuracoes) {
			out.println(
					configuracoes.getTipologia() + "#" + configuracoes.getConteudo() + "#" + configuracoes.getValor());
		}

		out.close();
	}

	// VERIFICÕES

	// Login
	public static int Login(String utilizador, String password) {
		int login = 0;

		for (Utilizador u : utilizadores) {
			if (u.getNome().equals(utilizador) && !u.getPass().equals(password)) {
				login = 1;
			} else if (u.getNome().equals(utilizador) && u.getPass().equals(password)) {
				login = 2;
				break;
			}
		}
		return login;

	}
	// Conteudo Repetido

	public static int verificarConteudoRepetido(String conteudo) {
		int a = 0;
		for (Configuracao c : configuracoes) {
			if (c.getConteudo().equals(conteudo)) {
				a = 1;
			}
		}
		return a;

	}
	// Nome Repetido

	public static int verificarNomeRepetido(String nome) {
		int a = 0;
		for (Utilizador u : utilizadores) {
			if (u.getNome().equals(nome)) {
				a = 1;
			}
		}
		return a;

	}
	// Quarto repetido
	
		public static int verificarQuartoRepetido(int quarto) {
			int q = 0;
			for (Utilizador u : utilizadores) {
				if (u.getQuarto() == quarto ) {
					q = 1;
				}
			}
			return q;

		}

	// Adicionar

	public static void adicionarCliente(String nome, int contribuinte, int quarto, String pass, String email,
			String checkin, String checkout) {

		Utilizador u = new Utilizador(nome, contribuinte, email, quarto, pass, checkin, checkout);
		utilizadores.add(u);

	}

	public static void adicionarDivulgacao(int quarto, String texto) {

		Divulgacao d = new Divulgacao(quarto, texto);
		divulgacoes.add(d);

	}

	public static void adicionarConteudo(String tipologia, String conteudo, double valor) {

		Configuracao c = new Configuracao(tipologia, conteudo, valor);
		configuracoes.add(c);

	}

	public static void adicionarSubscricao(int quarto, String tipologia, String conteudo, double valor, String data,
			String hora) {

		Subscricao c = new Subscricao(quarto, tipologia, conteudo, valor, data, hora);
		subscricoes.add(c);

	}

	// Remover

	public static void removerConteudoPorNome(String nome) {

		for (int i = 0; i < configuracoes.size(); i++) {
			Configuracao conteudo = configuracoes.get(i);

			if (conteudo.getConteudo() == nome) {
				configuracoes.remove(conteudo);
			}
		}
	}
	
	public static void removerConta (String nome)
	{
		for (int i = 0; i < utilizadores.size(); i++) {
			Utilizador utilizador = utilizadores.get(i);
			
			if (utilizador.getNome() == nome)
			{
				utilizadores.remove(i);
			}
		}
	}
	public static void removerSubscricoes (int quarto)
	{
		for (int i = 0; i < subscricoes.size(); i++) {
			Subscricao subscricao = subscricoes.get(i);
			
			
			if (subscricao.getQuarto() == quarto)
			{
				subscricoes.remove(i);
				i--;
			}
		}
	}

	// Procurar

	public static int procurarValorConteudo(String conteudo) {

		int valor = 0;
		for (Configuracao c : configuracoes) {
			if (c.getConteudo().equals(conteudo)) {
				valor = (int) c.getValor();
			}
		}
		return valor;
	}

	public static Utilizador procurarClientePorLogin(String login) {
		for (Utilizador u : utilizadores)

		{
			if (u.getNome().equals(login)) {
				return u;
			}

		}
		return null;

	}

	public static String procurarDiv(int quarto) {

		for (Divulgacao d : divulgacoes) {
			if (d.getQuarto() == quarto) {
				return d.getTexto();
			}
		}
		return null;
	}

	// Fazer logout
	public static void logout() {
		utilizador = null;
	}

}
