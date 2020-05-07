package br.com.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.negocio.Controle;

public class Pessoa {

	private String nome;
	private Date dataNascimento;
	private String genero;
	private Telefone telefone;
	
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	
	public Pessoa(String nome, String dataNascimento, String genero, Telefone telefone) {
		this.nome=nome;
		this.genero = genero;
		this.telefone =telefone;
		this.dataNascimento = formataDataNascimento(dataNascimento);
	}
	
	public Date formataDataNascimento(String dataString) {
		
		Date dataFormatada = new Date();
		try {
			dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}
	
	public void editaPessoa() {
		int op = 1000;
		while(op != 5) {
			System.out.println("1- Editar o nome.");
			System.out.println("2- Editar o telefone.");
			System.out.println("3- Editar a data de nascimento.");
			System.out.println("4- Editar o gênero.");
			System.out.println("5- Sair.");
			Controle controle = new Controle();
			op = controle.opcao();
			switch(op) {
			case 1:
				alteraNome();
				break;
			case 2:
				alteraTelefone();
				break;
			case 3:
				alteraDataNascimento();
				break;
			case 4:
				alteraGenero();
				break;
			
			}
			
		}

	}
	
	public void alteraNome() {
		System.out.println("Digite o novo nome:");
		Controle controle = new Controle();
		String novoNome = controle.texto();
		this.setNome(novoNome);
		System.out.println("Nome alterado com sucesso!");
	}
	
	public void alteraTelefone() {
		System.out.println("Digite o ddd:");
		Controle controle = new Controle();
		String ddd = controle.texto();
		System.out.println("Digite o número:");
		controle = new Controle();
		String numero = controle.texto();
		Telefone telefone = new Telefone();
		telefone.setDdd(ddd);
		telefone.setNumero(numero);
		this.setTelefone(telefone);
		System.out.println("Telefone alterado com suceso!");
	}
	
	public void alteraDataNascimento() {
		System.out.println("Digite a nova data de nascimento:");
		Controle controle = new Controle();
		String novaData = controle.texto();
		this.dataNascimento = formataDataNascimento(novaData);
		System.out.println("Data de Nascimento alterada com sucesso!");
				
	}
	
	public void alteraGenero() {
		System.out.println("Selecione o Gênero:");
		System.out.println("1- Feminino");
		System.out.println("2- Masculino");
		System.out.println("3- Outros");
		int op = 1000;
		Controle controle = new Controle();
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
		this.setGenero(genero);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

}
