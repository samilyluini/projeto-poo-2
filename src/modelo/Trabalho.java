package modelo;

public class Trabalho extends Lembrete{
	private String tema;
	private String disciplina;
	
	public Trabalho(String tema, String disciplina, String data) {
		super(data);
		this.tema = tema;
		this.disciplina = disciplina;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public String toString() {
		return "\n Tema: " + tema + "\n Disciplina: " + disciplina + "\n Data: " + data;
	}
}
