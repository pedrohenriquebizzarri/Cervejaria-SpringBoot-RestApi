package br.com.cervejariabaphomet.dao;

import java.util.List;

import br.com.cervejariabaphomet.entity.Estilo;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

public interface EstiloDAO{

	public List<Estilo> listar();
	
	public Estilo pesquisar(int id);
	
	public Estilo inserir(Estilo estilo) throws EstiloNaoEncontradoException;

	public Estilo atualizar(Estilo estilo, int id) throws EstiloNaoEncontradoException;
	
	public void remover(int id) throws KeyNotFoundException;
}
