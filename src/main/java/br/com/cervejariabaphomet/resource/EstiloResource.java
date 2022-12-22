package br.com.cervejariabaphomet.resource;

import br.com.cervejariabaphomet.entity.Estilo;

public class EstiloResource {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Estilo toEstilo() {
		return new Estilo();
	}
}
