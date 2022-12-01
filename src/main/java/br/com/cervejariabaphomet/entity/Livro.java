package br.com.cervejariabaphomet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRO_TESTE")
@SequenceGenerator(name = "livro", sequenceName = "SQ_LIVRO_TESTE", allocationSize = 1, initialValue = 1)
public class Livro {

	@Id
	@Column(name="id_livro", nullable = false)
	@GeneratedValue(generator="livro",strategy=GenerationType.SEQUENCE)
    private int id;

    private String nome;

    public Livro() {
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
    
}
