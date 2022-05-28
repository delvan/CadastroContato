package com.java.view.br;

import java.sql.SQLException;
import java.util.ArrayList;

import com.java.contato.br.Contato;
import com.java.repository.br.ContatoRepository;

public class Text {

	public static void main(String[] args) {

		ContatoRepository repository = new ContatoRepository();

		ArrayList<Contato> contatos = new ArrayList<Contato>();

		Contato contato = new Contato();

		contato.setNome("Idelvan");
		contato.setIdade(22);
		contato.setEmail("delvanpj@gmail.com");
		contatos.add(contato);

		contato.setNome("Thais");
		contato.setIdade(20);
		contato.setEmail("thais@gmail.com");
		contatos.add(contato);

		// System.out.println(contatos);

		/*
		 * 
		 * //Add Contatos for (Contato cont : contatos) {
		 * 
		 * repository.addContato(cont);
		 * 
		 * }
		 * 
		 */

		try {
			ArrayList<Contato> contatos2 = repository.listarContatos();

			for (Contato contato2 : contatos2) {

				System.out.println(contato2 + "\n");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
