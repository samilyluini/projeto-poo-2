package controle;

import java.util.ArrayList;

import modelo.IControladorTrabalho;
import modelo.Lembrete;
import modelo.Trabalho;

public class ControladorTrabalho implements IControladorTrabalho{
	private ArrayList<Trabalho> trabalhos;
	
	public ControladorTrabalho() {
		trabalhos = new ArrayList<Trabalho>();
	}

	public boolean adicionarTrabalho(Trabalho trabalho) {
		if(trabalho != null) {
			trabalhos.add(trabalho);
			
			return true;
		}
		
		return false;
	}

	public void listarTrabalhos() {
		for (int i = 0; i < trabalhos.size(); i++) {
			Trabalho trabalho = trabalhos.get(i);
			
			System.out.println(trabalho);
			System.out.println("=====================================================");
		}
	}

	public Trabalho buscarTrabalho(String texto) {
		for (Trabalho trabalho : trabalhos) {
			if(trabalho.getTema().contains(texto) || trabalho.getDisciplina().contains(texto)) {
				return trabalho;
			}
		}
		
		return null;
	}

	public boolean removerTrabalho(String texto) {
		Trabalho trabalho = buscarTrabalho(texto);
		
		if(trabalho != null) {
			trabalhos.remove(trabalho);
			return true;
		}
		
		return false;
	}

	public boolean alterarTrabalho(String texto, String novoTema, String novaDisciplina, String novaData) {
		Trabalho trabalho = buscarTrabalho(texto);
		
		if(trabalho != null) {
			trabalho.setTema(novoTema);
			trabalho.setDisciplina(novaDisciplina);
			trabalho.setData(novaData);
			return true;
		}
		
		return false;
	}
}
