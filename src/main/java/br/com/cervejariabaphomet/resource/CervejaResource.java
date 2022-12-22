package br.com.cervejariabaphomet.resource;

import br.com.cervejariabaphomet.entity.Cerveja;

public class CervejaResource {

	private String nome;
	
	private int idEstilo;
	
	private String descricao;
	
	private double abv;
	
	private double ibu;
	
	private double ebc;

	public String getNome() {
		return nome;
	}

	public int getIdEstilo() {
		return idEstilo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getAbv() {
		return abv;
	}

	public double getIbu() {
		return ibu;
	}

	public double getEbc() {
		return ebc;
	}

	public Cerveja toCerveja() {
		return new Cerveja(
				nome, 
				null, 
				descricao, 
				abv, 
				ibu, 
				ebc);
	}
}
