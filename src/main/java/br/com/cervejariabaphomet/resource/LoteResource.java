package br.com.cervejariabaphomet.resource;

import br.com.cervejariabaphomet.entity.Lote;

public class LoteResource {

	private String descricao;
	
	private int idCerveja;
	
	private int quantidade;
	
	//private Date dataFrabricacao;
	
	//private Date dataVencimento;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdCerveja() {
		return idCerveja;
	}

	public void setIdCerveja(int idCerveja) {
		this.idCerveja = idCerveja;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	/*
	public Date getDataFrabricacao() {
		return dataFrabricacao;
	}

	public void setDataFrabricacao(Date dataFrabricacao) {
		this.dataFrabricacao = dataFrabricacao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}*/

	public Lote toLote() {
		return new Lote(descricao, null, quantidade, null, null);
	}
}
