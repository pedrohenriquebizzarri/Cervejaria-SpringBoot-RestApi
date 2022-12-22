package br.com.cervejariabaphomet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejariabaphomet.dao.CervejaDAO;
import br.com.cervejariabaphomet.entity.Cerveja;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;
import br.com.cervejariabaphomet.resource.CervejaResource;

@Service
public class CervejaServiceImpl implements CervejaService{

	@Autowired
	private CervejaDAO cervejaDAO;
	
	@Override
	public List<Cerveja> listar() {
		return cervejaDAO.listar();
	}

	@Override
	public Cerveja pesquisar(int id) {
		return cervejaDAO.pesquisar(id);
	}
	
	@Override
	public Cerveja inserir(CervejaResource cervejaResource) throws EstiloNaoEncontradoException {
		return cervejaDAO.inserir(cervejaResource);
	}

	@Override
	public Cerveja atualizar(CervejaResource cervejaJson, int id) throws EstiloNaoEncontradoException {
		return cervejaDAO.atualizar(cervejaJson, id);
	}

	@Override
	public void remover(int id) throws KeyNotFoundException {
		cervejaDAO.remover(id);
	}

	@Override
	public void valida(Cerveja cerveja) throws EstiloNaoEncontradoException {
		
	}

	
}
