package br.com.cervejariabaphomet.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TB_ESTILO")
@SequenceGenerator(name = "estilo", sequenceName = "SQ_ESTILO", allocationSize = 1, initialValue = 1)
public class Estilo {

	@Id
	@Column(name="id_estilo", nullable = false)
	@GeneratedValue(generator="estilo",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "estilo", fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Cerveja> cervejas;

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

	public List<Cerveja> getCervejas() {
		return cervejas;
	}

	public void setCervejas(List<Cerveja> cervejas) {
		this.cervejas = cervejas;
	}
	
	
}
