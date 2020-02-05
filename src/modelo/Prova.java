package modelo;

public class Prova extends Lembrete{
	
	private String disciplina;

	public Prova(String disciplina, String data) {
		super(data);
		this.disciplina = disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public String toString() {
		return "\n Disciplina: " + disciplina + "\n Data: " + data;
	}
}
