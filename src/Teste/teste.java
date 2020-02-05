package Teste;

import controle.ControladorLembrete;
import modelo.Lembrete;

public class teste {

	public static void main(String[] args) {
		Lembrete lembrete = new Lembrete("Esse é o título 1", "Essa é a descrição", "Essa é a data");
		ControladorLembrete controladorLembretes = new ControladorLembrete();
		
		controladorLembretes.adicionarLembrete(lembrete);
		
		controladorLembretes.listarLembretes();
		
		lembrete = new Lembrete("Esse é o título 2", "Essa é a descrição", "Essa é a data de início", "Essa é a data de término");
		
		controladorLembretes.adicionarLembrete(lembrete);
		
		controladorLembretes.listarLembretes();
		
		lembrete = controladorLembretes.buscarLembrete("2");
		System.out.println(lembrete.toString());
		
		controladorLembretes.alterarLembrete("1", "novo titulo", "nova Descricao", "nova Data");
		
		controladorLembretes.listarLembretes();
		
		controladorLembretes.removerLembrete("novo");
		
		controladorLembretes.listarLembretes();
	
	}

}
