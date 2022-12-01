package br.com.cervejariabaphomet.dao;

import java.util.List;

import br.com.cervejariabaphomet.exception.KeyNotFoundException;


public interface GenericDAO<T,K> {

	void inserir(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	T pesquisar(K codigo);
	
	List<T> listar();
	
}



