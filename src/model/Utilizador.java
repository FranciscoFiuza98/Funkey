package model;

public class Utilizador 
{
	private String nome;
	private int contribuinte;
	private String email;
	private int quarto;
	private String pass;
	private String checkin;
	private String checkout;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getContribuinte() {
		return contribuinte;
	}
	public void setContribuinte(int contribuinte) {
		this.contribuinte = contribuinte;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCheckin() {
		return checkin;
	}
	public int getQuarto() {
		return quarto;
	}
	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public Utilizador(String nome, int contribuinte, String email, int quarto, String pass,  String checkin,
			String checkout) {
		super();
		this.nome = nome;
		this.contribuinte = contribuinte;
		this.email = email;
		this.quarto = quarto;
		this.pass = pass;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	@Override
	public String toString() {
		return "Utilizador [nome=" + nome + ", contribuinte=" + contribuinte + ", quarto=" + quarto + ", pass=" + pass
				+ ", email=" + email + ", checkin=" + checkin + ", checkout=" + checkout + "]";
	}
	
	
}