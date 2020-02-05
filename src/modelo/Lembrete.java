package modelo;

public class Lembrete {
	private String titulo;
	private String descricao;
	protected String data;
	private String dataInicio;
	private String dataTermino;
	
	public Lembrete(String data) {
		this.data = data;
	}
	
	public Lembrete(String titulo, String descricao, String data) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
	}
	public Lembrete(String titulo, String descricao, String dataInicio, String dataTermino) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getDatainicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String toString() {
		if(data == null) {
			return "\n Título: " + titulo + "\n Descrição: " + descricao + "\n Período: " + dataInicio + " - " + dataTermino;
		}
		return "\n Título: " + titulo + "\n Descrição: " + descricao + "\n Data: " + data;
	}
	
	
}
