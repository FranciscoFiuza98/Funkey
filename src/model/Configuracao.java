package model;
public class Configuracao {
	
	private String tipologia;
	private String conteudo;
	private double valor;
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
	public double getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Configuracao(String tipologia, String conteudo, double valor) {
		super();
		this.tipologia = tipologia;
		this.conteudo = conteudo;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Configuracao [tipologia=" + tipologia + ", conteudo=" + conteudo + ", valor=" + valor + "]";
	}
	
}
