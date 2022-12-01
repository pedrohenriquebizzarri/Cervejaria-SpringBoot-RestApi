package br.com.cervejariabaphomet.bo;

import java.util.List;

import br.com.cervejariabaphomet.entity.Cerveja;
import br.com.cervejariabaphomet.entity.json.CervejaJson;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

public interface CervejaBO {

	public List<Cerveja> listar();
	
	public Cerveja pesquisar(int id);
	
	public Cerveja inserir(CervejaJson cervejaJson) throws EstiloNaoEncontradoException;

	public Cerveja atualizar(CervejaJson cervejaJson, int id) throws EstiloNaoEncontradoException;
	
	public void remover(int id) throws KeyNotFoundException;
	
	public void valida(Cerveja cerveja) throws EstiloNaoEncontradoException;
}
