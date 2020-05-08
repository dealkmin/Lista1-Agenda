package br.com.app;

import br.com.modelo.Agenda;
import br.com.modelo.Menu;
import br.com.negocio.AsciiArt;
import br.com.negocio.Controle;

public class AgendaApplication {

	public static void main(String[] args) {
		AsciiArt.printAsciiArt("Grupo World Beauty");
		Menu menu = new Menu();
		Agenda agenda = new Agenda();
		int op = 1000;
		while(op !=0) {
			menu.imprimirMenu();
			Controle controle = new Controle();
			op = controle.opcao();
			switch(op) {
			case 1:
				agenda.cadastraCliente();
				break;
			case 2:
				agenda.imprimirNomeClientes();
				break;
			case 3:
				agenda.editarClientes();
				break;
			case 4:
				agenda.excluirCliente();
				break;
			case 5:
				agenda.comprar();
				break;
				
			}
			
		}
	}

}
