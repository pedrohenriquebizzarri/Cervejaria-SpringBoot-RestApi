package br.com.cervejariabaphomet.service;

import java.util.List;

import br.com.cervejariabaphomet.entity.Estilo;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

public interface EstiloService {

	public List<Estilo> listar();
	
	public Estilo pesquisar(int id);
	
	public Estilo inserir(Estilo estilo) throws EstiloNaoEncontradoException;

	public Estilo atualizar(Estilo estilo, int id) throws EstiloNaoEncontradoException;
	
	public void remover(int id) throws KeyNotFoundException;
	
	public void valida(Estilo estilo) throws EstiloNaoEncontradoException;
}
