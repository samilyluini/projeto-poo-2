package modelo;

public interface IControladorTrabalho {

	boolean adicionarTrabalho(Trabalho trabalho);
	void listarTrabalhos();
	Lembrete buscarTrabalho(String texto);
	boolean removerTrabalho(String texto);
	boolean alterarTrabalho(String texto, String novoTema, String novaDisciplina, String novaData);
	
}
