package br.com.cervejariabaphomet.bo;

import java.util.List;

import br.com.cervejariabaphomet.entity.Livro;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

public interface LivroBO {

	public List<Livro> listar();
	
	public Livro pesquisar(int id);
	
	public Livro inserir(Livro livro);
	
	public Livro atualizar(Livro livro, int id);
	
	public void remover(int id) throws KeyNotFoundException;
}
