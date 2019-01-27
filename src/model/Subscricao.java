package model;

public class Subscricao {

	private int quarto;
	private double valor;
	private String tipologia;
	private String conteudo;
	private String data;
	private String hora;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getQuarto() {
		return quarto;
	}
	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Subscricao(int quarto, String tipologia, String conteudo, double valor, String data, String hora) {
		super();

		this.quarto = quarto;
		this.tipologia = tipologia;
		this.conteudo = conteudo;
		this.valor = valor;
		this.data = data;
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "Subscricao [quarto=" + quarto + ", valor=" + valor + ", tipologia=" + tipologia + ", conteudo="
				+ conteudo + "]";
	}
	
	
}
