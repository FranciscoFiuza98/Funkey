package model;

public class Divulgacao {
	
	private int quarto;
	private String texto;
	public int getQuarto() {
		return quarto;
	}
	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public String toString() {
		return "Divulgacao [quarto=" + quarto + ", texto=" + texto + "]";
	}
	public Divulgacao(int quarto, String texto) {
		super();
		this.quarto = quarto;
		this.texto = texto;
	}
}
