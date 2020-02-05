package modelo;

public interface IControladorLembrete {
	
	boolean adicionarLembrete(Lembrete lembrete);
	void listarLembretes();
	Lembrete buscarLembrete(String texto);
	boolean removerLembrete(String texto);
	boolean alterarLembrete(String texto, String novoTitulo, String novaDescricao, String novaData);
	boolean alterarLembrete(String texto, String novoTitulo, String novaDescricao, String novaDataInicio, String novaDataTermino);

}
