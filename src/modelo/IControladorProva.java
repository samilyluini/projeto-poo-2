package modelo;

public interface IControladorProva {

	boolean adicionarProva(Prova prova);
	void listarProvas();
	Lembrete buscarProva(String texto);
	boolean removerProva(String texto);
	boolean alterarProva(String texto, String novaDisciplina, String novaData);
	
}
