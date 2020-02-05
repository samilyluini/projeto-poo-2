package Teste;

import controle.ControladorLembrete;
import modelo.Lembrete;

public class teste {

	public static void main(String[] args) {
		Lembrete lembrete = new Lembrete("Esse � o t�tulo 1", "Essa � a descri��o", "Essa � a data");
		ControladorLembrete controladorLembretes = new ControladorLembrete();
		
		controladorLembretes.adicionarLembrete(lembrete);
		
		controladorLembretes.listarLembretes();
		
		lembrete = new Lembrete("Esse � o t�tulo 2", "Essa � a descri��o", "Essa � a data de in�cio", "Essa � a data de t�rmino");
		
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
