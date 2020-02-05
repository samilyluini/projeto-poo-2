package visualizacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import controle.ControladorLembrete;
import controle.ControladorProva;
import controle.ControladorTrabalho;
import modelo.Lembrete;
import modelo.Prova;
import modelo.Trabalho;

public class Menu {

	public static void main(String[] args) {

		Lembrete lembrete;
		Trabalho trabalho;
		Prova prova;
		ControladorLembrete controladorLembrete = new ControladorLembrete();
		ControladorTrabalho controladorTrabalho = new ControladorTrabalho();
		ControladorProva controladorProva = new ControladorProva();
		
		int valor = 0;

		Scanner ler = new Scanner(System.in);
		
		System.out.println("=====================================================");
		System.out.println("== BEM-VINDO(A) AO NOSSO GERENCIADOR DE LEMBRETES! ==");
		
		try {
		do {
			System.out.println("=====================================================");
			System.out.println("=========Selecione uma das opções abaixo:============");
			System.out.println();
			System.out.println("| Opção '1' - Cadastrar Lembrete                    |");
			System.out.println("| Opção '2' - Buscar Lembrete                       |");
			System.out.println("| Opção '3' - Alterar Lembrete                      |");
			System.out.println("| Opção '4' - Deletar Lembrete                      |");
			System.out.println("| Opção '5' - Listar Lembretes                      |");
			System.out.println("| Opção '0' - Sair                                  |");
			System.out.println("=====================================================");

			valor=ler.nextInt();
			
			if(valor==0) {
				break;
			}

			switch (valor) {

				case 1:
					System.out.println("| Opção '1' - Cadastrar Trabalho                    |");
					System.out.println("| Opção '2' - Cadastrar Prova                       |");
					System.out.println("| Opção '3' - Cadastrar Outro                       |");
					int opcao = ler.nextInt();
					ler.nextLine();
					
					switch(opcao) {
						case 1:
							System.out.println("Digite o tema do trabalho: ");
							String tema = ler.nextLine();
							System.out.println("Digite a disciplina: ");
							String disciplina = ler.nextLine();
							System.out.println("Digite a data de entrega: ");
							String data = ler.nextLine();
							
							trabalho = new Trabalho(tema, disciplina, data);
							controladorTrabalho.adicionarTrabalho(trabalho);
							break;
						case 2: 
							System.out.println("Digite a disciplina: ");
							String disciplina1 = ler.nextLine();
							System.out.println("Digite a data: ");
							String data1 = ler.nextLine();
							
							prova = new Prova(disciplina1, data1);
							controladorProva.adicionarProva(prova);
							break;
						case 3:
							System.out.println("Digite o título: ");
							String titulo = ler.nextLine();
							System.out.println("Digite a descrição: ");
							String descricao = ler.nextLine();
							System.out.println("Deseja criar um lembrete com data fixa [F] ou período [P] ?");
							String opData = ler.nextLine().toUpperCase();
							
							if(opData.equals("F")) {
								System.out.println("Digite a data: ");
								String data2 = ler.nextLine();
								
								lembrete = new Lembrete(titulo, descricao, data2);
								controladorLembrete.adicionarLembrete(lembrete);
							}
							else if(opData.equals("P")) {
								System.out.println("Digite a data de início: ");
								String dataInicio = ler.nextLine();
								System.out.println("Digite a data de término: ");
								String dataTermino = ler.nextLine();
								
								lembrete = new Lembrete(titulo, descricao, dataInicio, dataTermino);
								controladorLembrete.adicionarLembrete(lembrete);
							}
							else {
								System.out.println("Opção inexistente!");
							}
							break;
					}
					break;
				case 2:
					ler.nextLine();
					
					System.out.println("| Opção '1' - Buscar Trabalho                       |");
					System.out.println("| Opção '2' - Buscar Prova                          |");
					System.out.println("| Opção '3' - Buscar Outro                          |");
					System.out.println("| Opção '4' - Buscar em todos                       |");
					int opcao2 = ler.nextInt();
					ler.nextLine();
					
					System.out.println("Digite o texto a ser buscado: ");
					String texto = ler.nextLine();
					
					switch(opcao2) {
						case 1:
							trabalho = controladorTrabalho.buscarTrabalho(texto);
							
							if(trabalho != null) {
								System.out.println("=====================================================");
								System.out.println(trabalho);
							}
						break;
						
						case 2: 
							prova = controladorProva.buscarProva(texto);
							
							if(prova != null) {
								System.out.println("=====================================================");
								System.out.println(prova);
							}
						break;
						
						case 3:
							lembrete = controladorLembrete.buscarLembrete(texto);
							
							if(lembrete != null) {
								System.out.println("=====================================================");
								System.out.println(lembrete);
							}
						break;
						
						case 4:
							lembrete = controladorLembrete.buscarLembrete(texto);
							trabalho = controladorTrabalho.buscarTrabalho(texto);
							prova = controladorProva.buscarProva(texto);
							
							if(lembrete != null) {
								System.out.println("=====================================================");
								System.out.println(lembrete);
							}
							if(trabalho != null) {
								System.out.println("=====================================================");
								System.out.println(trabalho);
							}
							if(prova != null) {
								System.out.println("=====================================================");
								System.out.println(prova);
							}
						break;
					}
					
					break;
	
				case 3:
					System.out.println("| Opção '1' - Alterar Trabalho                      |");
					System.out.println("| Opção '2' - Alterar Prova                         |");
					System.out.println("| Opção '3' - Outro                                 |");
					int opcao1 = ler.nextInt();
					
					
					ler.nextLine();
					
					System.out.println("Digite o texto a ser buscado: ");
					String texto1 = ler.nextLine();
					
					switch(opcao1) {
						case 1:
							trabalho = controladorTrabalho.buscarTrabalho(texto1);
							
							System.out.println(trabalho.toString());
							
							System.out.println("\n Deseja alterar esse lembrete? (S/N) ");
							String alt = ler.nextLine().toUpperCase();
							
							if(alt.equals("S")) {
								System.out.println("Digite o novo tema do trabalho: ");
								String novoTema = ler.nextLine();
								System.out.println("Digite a nova disciplina: ");
								String novaDisciplina = ler.nextLine();
								System.out.println("Digite a nova data de entrega: ");
								String novaData = ler.nextLine();
								
								controladorTrabalho.alterarTrabalho(texto1, novoTema, novaDisciplina, novaData);
							}
						break;
						
						case 2:
							prova = controladorProva.buscarProva(texto1);
							
							System.out.println(prova.toString());
							
							System.out.println("\n Deseja alterar esse lembrete? (S/N) ");
							String alt1 = ler.nextLine().toUpperCase();
							
							if(alt1.equals("S")) {
								System.out.println("Digite a nova disciplina: ");
								String novaDisciplina = ler.nextLine();
								System.out.println("Digite a nova data: ");
								String novaData = ler.nextLine();
								
								controladorProva.alterarProva(texto1, novaDisciplina, novaData);
							}
						break;
						
						case 3:
							lembrete = controladorLembrete.buscarLembrete(texto1);
							
							System.out.println(lembrete.toString());
							
							System.out.println("\n Deseja alterar esse lembrete? (S/N) ");
							String alt2 = ler.nextLine().toUpperCase();
							
							if(alt2.equals("S")) {
								System.out.println("Digite o novo título: ");
								String novoTitulo = ler.nextLine();
								System.out.println("Digite a nova descrição: ");
								String novaDescricao = ler.nextLine();
								System.out.println("Deseja criar um lembrete com data fixa [F] ou período [P] ?");
								String opData = ler.nextLine().toUpperCase();
								
								if(opData == "F") {
									System.out.println("Digite a data: ");
									String novaData = ler.nextLine();
									
									controladorLembrete.alterarLembrete(texto1, novoTitulo, novaDescricao, novaData);
								}
								else if(opData == "P") {
									System.out.println("Digite a data de início: ");
									String novaDataInicio = ler.nextLine();
									System.out.println("Digite a data de término: ");
									String novaDataTermino = ler.nextLine();
									
									controladorLembrete.alterarLembrete(texto1, novoTitulo, novaDescricao, novaDataInicio, novaDataTermino);
								}
								else {
									System.out.println("Opção inexistente!");
								}
					
							}
							break;
						default:
							System.out.println("Opção inexistente!");
							break;
						
					}
					break;

				case 4:
					ler.nextLine();
					
					System.out.println("| Opção '1' - Deletar Trabalho                      |");
					System.out.println("| Opção '2' - Deletar Prova                         |");
					System.out.println("| Opção '3' - Deletar Outro                         |");
					int opcao3 = ler.nextInt();
					
					ler.nextLine();
					
					System.out.println("Digite o texto a ser buscado: ");
					String texto2 = ler.nextLine();
					
					switch(opcao3) {
					case 1:
						trabalho = controladorTrabalho.buscarTrabalho(texto2);
						
						if(trabalho != null) {
							System.out.println("=====================================================");
							System.out.println(trabalho);
							System.out.println("=====================================================");
							
							System.out.println("Tem certeza que deseja excluir este lembrete? (S/N)");
							String alt2 = ler.nextLine().toUpperCase();
							
							if(alt2.equals("S")) {
								boolean trabalhoRemovido;
								
								trabalhoRemovido=controladorTrabalho.removerTrabalho(texto2);
								
								if(trabalhoRemovido == true) {
									System.out.println("Lembrete removido com sucesso!");
								}
								
								
							}
							else if(alt2.equals("N")) {
								break;
							}
								
							else {
								System.out.println("Opção inexistente!");
							}
						}
						break;
					case 2:
						prova = controladorProva.buscarProva(texto2);
						
						if(prova != null) {
							System.out.println("=====================================================");
							System.out.println(prova);
							System.out.println("=====================================================");
							
							System.out.println("Tem certeza que deseja excluir este lembrete? (S/N)");
							String alt2 = ler.nextLine().toUpperCase();
							
							if(alt2.equals("S")) {
								boolean provaRemovida;
								
								provaRemovida=controladorProva.removerProva(texto2);
								
								if(provaRemovida == true) {
									System.out.println("Lembrete removido com sucesso!");
								}
								
								
							}
							else if(alt2.equals("N")) {
								break;
							}
								
							else {
								System.out.println("Opção inexistente!");
							}
						}
						break;
					case 3:
						lembrete = controladorLembrete.buscarLembrete(texto2);
						
						if(lembrete != null) {
							System.out.println("=====================================================");
							System.out.println(lembrete);
							System.out.println("=====================================================");
							
							System.out.println("Tem certeza que deseja excluir este lembrete? (S/N)");
							String alt2 = ler.nextLine().toUpperCase();
							
							if(alt2.equals("S")) {
								boolean lembreteRemovido;
								
								lembreteRemovido=controladorLembrete.removerLembrete(texto2);
								
								if(lembreteRemovido == true) {
									System.out.println("Lembrete removido com sucesso!");
								}
								
								
							}
							else if(alt2.equals("N")) {
								break;
							}
								
							else {
								System.out.println("Opção inexistente!");
							}
						}
						break;
					default:
						System.out.println("Opção inexistente!");
						break;
					}
					
					break;

				case 5:
					ler.nextLine();
					
					System.out.println("| Opção '1' - Listar Trabalhos                      |");
					System.out.println("| Opção '2' - Listar Provas                         |");
					System.out.println("| Opção '3' - Listar Outros                         |");
					System.out.println("| Opção '4' - Listar todos                          |");
					int opcao4 = ler.nextInt();
					
					ler.nextLine();
					
						switch(opcao4) {
							case 1:
								System.out.println("===================== TRABALHOS ====================");
								controladorTrabalho.listarTrabalhos();
								break;
							case 2:
								System.out.println("====================== PROVAS ======================");
								controladorProva.listarProvas();
								break;
							case 3:
								System.out.println("================= OUTROS LEMBRETES =================");
								controladorLembrete.listarLembretes();
								break;
							case 4:
								System.out.println("====================== PROVAS ======================");
								controladorProva.listarProvas();
								System.out.println("===================== TRABALHOS ====================");
								controladorTrabalho.listarTrabalhos();
								System.out.println("================= OUTROS LEMBRETES =================");
								controladorLembrete.listarLembretes();
								break;
						}
					
					break;
				default:
					System.out.println("Opção inexistente!");
					ler.nextLine();
					break;
				}

			 	System.out.println();
				System.out.println("Pressione enter para voltar ao menu");
				ler.nextLine();

			
		}
		while (valor != 0);
			System.out.println("=====================================================");
			System.out.println("===========OBRIGADO POR USAR O PROGRAMA!=============");
			System.out.println("=====================================================");
	} catch (InputMismatchException e) {
		System.out.println("Insira um tipo inteiro");
	}// try catch
	}
		
}

