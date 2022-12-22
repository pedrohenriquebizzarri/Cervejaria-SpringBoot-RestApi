package br.com.cervejariabaphomet.service;

import java.util.List;

import br.com.cervejariabaphomet.entity.Lote;
import br.com.cervejariabaphomet.exception.CervejaNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;
import br.com.cervejariabaphomet.resource.LoteResource;

public interface LoteService {

	public List<Lote> listar();
	
	public Lote pesquisar(int id);
	
	public Lote inserir(LoteResource loteJson) throws CervejaNaoEncontradoException;

	public Lote atualizar(LoteResource loteJson, int id) throws CervejaNaoEncontradoException;
	
	public void remover(int id) throws KeyNotFoundException;
	
	public void valida(Lote lote);
}
