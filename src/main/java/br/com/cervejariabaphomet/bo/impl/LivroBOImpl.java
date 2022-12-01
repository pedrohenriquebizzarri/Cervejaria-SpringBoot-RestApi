package br.com.cervejariabaphomet.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejariabaphomet.bo.LivroBO;
import br.com.cervejariabaphomet.dao.LivroDAO;
import br.com.cervejariabaphomet.entity.Livro;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

@Service
public class LivroBOImpl implements LivroBO{

	@Autowired
	private LivroDAO livroDAO;
	
	@Override
	public List<Livro> listar(){
		return livroDAO.listar();
	}

	@Override
	public Livro pesquisar(int id) {
		return livroDAO.pesquisar(id);
	}

	@Override
	public Livro inserir(Livro livro) {
		livroDAO.inserir(livro);
		return livro;
	}

	@Override
	public Livro atualizar(Livro livro, int id) {
		livro.setId(id);
		livroDAO.atualizar(livro);		
		return livro;
	}

	@Override
	public void remover(int id) throws KeyNotFoundException {
		livroDAO.remover(id);
		
	}
}
