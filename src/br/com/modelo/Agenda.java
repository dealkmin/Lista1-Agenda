package br.com.modelo;

import java.util.ArrayList;
import java.util.Collections;

import br.com.negocio.Controle;

public class Agenda {
	
	public ArrayList<Pessoa> pessoas =new ArrayList<Pessoa>();
	private String[] produtos = {"Corte de cabelo","Pintura de cabelo","Manicure","Pedicure","Corte de barba","Shampoo Antiqueda"};

	public void cadastraCliente() {
		Controle controle = new Controle();

		System.out.println("â�¤CADASTRO DE CLIENTEâ�¤");
		System.out.println("Nome:");
		String nome = controle.texto();

		System.out.println("Selecione o GÃªnero:");
		System.out.println("1- Feminino");
		System.out.println("2- Masculino");
		System.out.println("3- Outros");
		int op = 1000;
		controle = new Controle();
		op = controle.opcao();
		String genero = new String();
		switch (op) {
		case 1:
			genero = "Feminino";
			break;
		case 2:
			genero = "Masculino";
			break;
		case 3:
			genero = "Outros";
			break;
		}

		System.out.println("Digite o DDD:");
		controle = new Controle();
		String ddd = controle.texto();
		System.out.println("Digite o nÃºmero de telefone:");
		controle = new Controle();
		String numero = controle.texto();
		Telefone telefone = new Telefone();
		telefone.setDdd(ddd);
		telefone.setNumero(numero);

		System.out.println("Digite a data de nascimento no formato (dd/mm/aaaa)");
		controle = new Controle();
		String dataNascimento = controle.texto();

		Pessoa pessoa = new Pessoa(nome, dataNascimento, genero, telefone);
		pessoas.add(pessoa);
		System.out.println("Novo cliente cadastrado!");

	}
	
	public void imprimirNomeClientes() {
		System.out.println("Clientes cadastrados:");
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome());
		}
	}

	// Imprimir os clientes
	public void imprimirClientes() {
			Collections.sort(pessoas);
			for (Pessoa pessoa : pessoas) {
				System.out.println(pessoa.toString());
				System.out.println("Produtos Consumidos");
				for(int i = 0; i < 6; ++i) {
					System.out.println("*"+produtos[i] +" - Quantidade:"+ pessoa.getQtdProdutos(i));
				}
				System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~|\n");
			
			}
	}
	
	public void imprimirClientesPorGenero() {
		
	}
	
	public void editarClientes() {
		imprimirNomeClientes();
		if( !pessoas.isEmpty()) {
			System.out.println("Digite o nome do cliente que deseja editar:");
			Controle controle = new Controle();
			String nome = controle.texto();
			for (Pessoa pessoa : pessoas) {
				if(pessoa.getNome().equals(nome)) {
					pessoa.editaPessoa();
				}
			}
		}
	}
	//Excluir Cliente
		public void excluirCliente() {
			if(!pessoas.isEmpty()) {
				imprimirNomeClientes();
				System.out.println("Digite o nome do cliente que deseja excluir:");
				Controle controle = new Controle();
				String nome = controle.texto();
				for(Pessoa pessoa : pessoas) {
					if(pessoa.getNome().equals(nome)) {
						pessoas.remove(pessoa);
						System.out.println(pessoa.getNome() + " Excluido com Sucesso. \n ");
						return;
				}
			}
		}
	}
	public void comprar() {
		if(!pessoas.isEmpty()) {
			int i;
			System.out.println("PRODUTOS:");
			for(i=0; i<this.produtos.length; i++) {
				System.out.println("[" + i + "]" +produtos[i]);
			}
			
			System.out.println("-----------------------------");
			System.out.println("Digite o produto que deseja comprar:");
			Controle controle = new Controle();
			int produto = Integer.parseInt(controle.texto());
			System.out.println("Insira a quantidade:");
			controle = new Controle();
			int qtd = Integer.parseInt(controle.texto());
			
			imprimirNomeClientes();
			System.out.println("Selecione o cliente:");
			controle = new Controle();
			String cliente = controle.texto();
			
			for(Pessoa pessoa : pessoas) {
				if(pessoa.getNome().equals(cliente)) {
					pessoa.setQtdProdutos(produto , qtd);
					System.out.println("Produto Comprado!");
				}
			}
			System.out.println("Deseja continuar comprando? (S/N)");
			controle = new Controle();
			String op = controle.texto();
			if(op.equals("S")) {
				comprar();
			}
			else {
				System.out.println("Compra Finalizada!");
			}
			
		}else {
			System.out.println("Nenhum cliente cadastrado!");
		}
	}

}
