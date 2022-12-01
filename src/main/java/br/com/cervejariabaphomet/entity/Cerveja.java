package br.com.cervejariabaphomet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TB_CERVEJA")
@SequenceGenerator(name = "cerveja", sequenceName = "SQ_CERVEJA", allocationSize = 1, initialValue = 1)
public class Cerveja {

	@Id
	@Column(name="id_cerveja", nullable = false)
	@GeneratedValue(generator="cerveja",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@JoinColumn(name = "id_estilo", nullable = false)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Estilo estilo;
	
	@Column(name="descricao", nullable = false)
	private String descricao;
	
	@Column(name="abv", nullable = false)
	private double abv;
	
	@Column(name="ibu", nullable = false)
	private double ibu;
	
	@Column(name="ebc", nullable = false)
	private double ebc;
	
	@OneToMany(mappedBy = "cerveja", fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Lote> lotes;

	public Cerveja() {
		
	}

	public Cerveja(String nome, Estilo estilo, String descricao, double abv, double ibu, double ebc) {
		super();
		this.nome = nome;
		this.estilo = estilo;
		this.descricao = descricao;
		this.abv = abv;
		this.ibu = ibu;
		this.ebc = ebc;
	}

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

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

	public double getIbu() {
		return ibu;
	}

	public void setIbu(double ibu) {
		this.ibu = ibu;
	}

	public double getEbc() {
		return ebc;
	}

	public void setEbc(double ebc) {
		this.ebc = ebc;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}
	
}
