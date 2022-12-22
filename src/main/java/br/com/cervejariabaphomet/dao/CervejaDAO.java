package br.com.cervejariabaphomet.dao;

import java.util.List;

import br.com.cervejariabaphomet.entity.Cerveja;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;
import br.com.cervejariabaphomet.resource.CervejaResource;

public interface CervejaDAO {

	public List<Cerveja> listar();

	public Cerveja pesquisar(int id);

	public Cerveja inserir(CervejaResource cervejaResource) throws EstiloNaoEncontradoException;

	public Cerveja atualizar(CervejaResource cervejaResource, int id) throws EstiloNaoEncontradoException;

	public void remover(int id) throws KeyNotFoundException;

	public void valida(Cerveja cerveja) throws EstiloNaoEncontradoException;
}
