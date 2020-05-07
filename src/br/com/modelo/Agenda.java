package br.com.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import br.com.negocio.Controle;

public class Agenda {
	
	public ArrayList<Pessoa> pessoas =new ArrayList<Pessoa>();

	public void cadastraCliente() {
		try {
			FileWriter fw = new FileWriter("agenda.txt");
			PrintWriter pw = new PrintWriter(fw);
			Controle controle = new Controle();

			System.out.println("❤CADASTRO DE CLIENTE❤");
			System.out.println("Nome:");
			String nome = controle.texto();

			System.out.println("Selecione o Gênero:");
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
			System.out.println("Digite o número de telefone:");
			controle = new Controle();
			String numero = controle.texto();
			Telefone telefone = new Telefone();
			telefone.setDdd(ddd);
			telefone.setNumero(numero);
			
			System.out.println("Digite a data de nascimento no formato (dd/mm/aaaa)");
			controle = new Controle();
			String dataNascimento = controle.texto();
			
			Pessoa pessoa = new Pessoa(nome,dataNascimento,genero,telefone);
			pessoas.add(pessoa);
			System.out.println("Novo cliente cadastrado!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void imprimirNomeClientes() {
		System.out.println("Clientes cadastrados:");
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome());
		}
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

}
