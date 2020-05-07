package br.com.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		try {
			this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
		} catch(ParseException e) {
			e.printStackTrace();	
		}
		
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
