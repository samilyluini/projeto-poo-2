package controle;

import java.util.ArrayList;

import modelo.IControladorLembrete;
import modelo.Lembrete;

public class ControladorLembrete implements IControladorLembrete {
	private ArrayList<Lembrete> lembretes;

	public ControladorLembrete() {
		lembretes = new ArrayList<Lembrete>();
	}
	
	public boolean adicionarLembrete(Lembrete lembrete) {
		if(lembrete != null) {
			lembretes.add(lembrete);
			
			return true;
		}
		
		return false;
	}
	
	public void listarLembretes() {
		for (int i = 0; i < lembretes.size(); i++) {
			Lembrete lembrete = lembretes.get(i);
			
			System.out.println(lembrete);
			System.out.println("=====================================================");
		}
	}
	
	public Lembrete buscarLembrete(String texto) {
		for (Lembrete lembrete : lembretes) {
			if(lembrete.getTitulo().contains(texto) || lembrete.getDescricao().contains(texto)) {
				return lembrete;
			}
		}
		
		return null;
	}
	
	public boolean removerLembrete(String texto) {
		Lembrete lembrete = buscarLembrete(texto);
		
		if(lembrete != null) {
			lembretes.remove(lembrete);
			return true;
		}
		
		return false;
	}

	public boolean alterarLembrete(String texto, String novoTitulo, String novaDescricao, String novaData) {
		Lembrete lembrete = buscarLembrete(texto);
		
		if(lembrete != null) {
			lembrete.setTitulo(novoTitulo);
			lembrete.setDescricao(novaDescricao);
			lembrete.setData(novaData);
			return true;
		}
		
		return false;
	}
	
	public boolean alterarLembrete(String texto, String novoTitulo, String novaDescricao, String novaDataInicio, String novaDataTermino) {
		Lembrete lembrete = buscarLembrete(texto);
		
		if(lembrete != null) {
			lembrete.setTitulo(novoTitulo);
			lembrete.setDescricao(novaDescricao);
			lembrete.setDataInicio(novaDataInicio);
			lembrete.setDataTermino(novaDataTermino);
			return true;
		}
		
		return false;
	}
}
