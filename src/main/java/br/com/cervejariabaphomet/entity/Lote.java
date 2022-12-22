package br.com.cervejariabaphomet.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_LOTE")
@SequenceGenerator(name = "lote", sequenceName = "SQ_LOTE", allocationSize = 1, initialValue = 1)
public class Lote {

	@Id
	@Column(name = "id_lote", nullable = false)
	@GeneratedValue(generator = "lote", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "descricao", nullable = true)
	private String descricao;

	@JoinColumn(name = "id_cerveja")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cerveja cerveja;

	@Column(name = "quantidade", nullable = false)
	private int quantidade;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_fabricacao", nullable = false)
	private Calendar dataFabricacao;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_vencimento")
	private Calendar dataVencimento;
	
	public Lote() {

	}

	public Lote(String descricao, Cerveja cerveja, int quantidade, Calendar dataFabricacao, Calendar dataVencimento) {
		super();
		this.descricao = descricao;
		this.cerveja = cerveja;
		this.quantidade = quantidade;
		this.dataFabricacao = dataFabricacao;
		this.dataVencimento = dataVencimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	
	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	
}
