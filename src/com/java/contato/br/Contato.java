package com.java.contato.br;

public class Contato {

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", idade=" + idade + ", email=" + email + "]";
	}

	private int id;

	private String nome;

	private int idade;

	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}