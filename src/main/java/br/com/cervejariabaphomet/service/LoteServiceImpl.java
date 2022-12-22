package br.com.cervejariabaphomet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejariabaphomet.dao.LoteDAO;
import br.com.cervejariabaphomet.entity.Lote;
import br.com.cervejariabaphomet.exception.CervejaNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;
import br.com.cervejariabaphomet.resource.LoteResource;

@Service
public class LoteServiceImpl implements LoteService {

	@Autowired
	private LoteDAO loteDAO;

	@Override
	public List<Lote> listar() {
		return loteDAO.listar();
	}

	@Override
	public Lote pesquisar(int id) {
		return loteDAO.pesquisar(id);
	}

	@Override
	public Lote inserir(LoteResource loteResource) throws CervejaNaoEncontradoException {
		return loteDAO.inserir(loteResource);
	}

	@Override
	public Lote atualizar(LoteResource loteJson, int id) throws CervejaNaoEncontradoException {
		return loteDAO.atualizar(loteJson, id);
	}

	@Override
	public void remover(int id) throws KeyNotFoundException {
		loteDAO.remover(id);
	}

	@Override
	public void valida(Lote lote) {
		// TODO Auto-generated method stub

	}

}
