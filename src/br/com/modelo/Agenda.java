package br.com.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.negocio.Controle;

public class Agenda {

	public void cadastraCliente() {
		try {
			FileWriter fw = new FileWriter("agenda.txt");
			PrintWriter pw = new PrintWriter(fw);
			Controle controle = new Controle();

			System.out.println("❤CADASTRO DE CLIENTE❤");
			System.out.println("Nome: /n");
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
			 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
