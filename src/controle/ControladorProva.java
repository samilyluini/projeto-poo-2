package controle;

import java.util.ArrayList;

import modelo.IControladorProva;
import modelo.Lembrete;
import modelo.Prova;
import modelo.Trabalho;

public class ControladorProva implements IControladorProva{
	private ArrayList<Prova> provas;

	public ControladorProva() {
		provas = new ArrayList<Prova>();
	}

	
	public boolean adicionarProva(Prova prova) {
		if(prova != null) {
			provas.add(prova);
			
			return true;
		}
		
		return false;
	}

	public void listarProvas() {
		for (int i = 0; i < provas.size(); i++) {
			Prova prova = provas.get(i);
			
			System.out.println(prova);
			System.out.println("=====================================================");
		}
	}

	public Prova buscarProva(String texto) {
		for (Prova prova : provas) {
			if(prova.getDisciplina().contains(texto)) {
				return prova;
			}
		}
		
		return null;
	}

	public boolean removerProva(String texto) {
		Prova prova = buscarProva(texto);
		
		if(prova != null) {
			provas.remove(prova);
			return true;
		}
		
		return false;
	}

	public boolean alterarProva(String texto, String novaDisciplina, String novaData) {
		Prova prova = buscarProva(texto);
		
		if(prova != null) {
			prova.setDisciplina(novaDisciplina);
			prova.setData(novaData);
			return true;
		}
		
		return false;
	}
	
	

}
