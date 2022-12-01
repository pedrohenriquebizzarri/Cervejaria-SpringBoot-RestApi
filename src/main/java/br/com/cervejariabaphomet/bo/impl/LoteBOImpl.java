package br.com.cervejariabaphomet.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejariabaphomet.bo.LoteBO;
import br.com.cervejariabaphomet.dao.CervejaDAO;
import br.com.cervejariabaphomet.dao.LoteDAO;
import br.com.cervejariabaphomet.entity.Cerveja;
import br.com.cervejariabaphomet.entity.Lote;
import br.com.cervejariabaphomet.entity.json.LoteJson;
import br.com.cervejariabaphomet.exception.CervejaNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

@Service
public class LoteBOImpl implements LoteBO {

	@Autowired
	private LoteDAO loteDAO;

	@Autowired
	private CervejaDAO cervejaDAO;

	@Override
	public List<Lote> listar() {
		return loteDAO.listar();
	}

	@Override
	public Lote pesquisar(int id) {
		return loteDAO.pesquisar(id);
	}

	@Override
	public Lote inserir(LoteJson loteJson) throws CervejaNaoEncontradoException {
		Cerveja cerveja = cervejaDAO.pesquisar(loteJson.getIdCerveja());

		if (cerveja == null) {
			throw new CervejaNaoEncontradoException();
		}

		Lote lote = new Lote();
		lote.setDescricao(loteJson.getDescricao());
		lote.setCerveja(cerveja);
		lote.setQuantidade(loteJson.getQuantidade());

		loteDAO.inserir(lote);
		return lote;
	}

	@Override
	public Lote atualizar(LoteJson loteJson, int id) throws CervejaNaoEncontradoException {
		Cerveja cerveja = cervejaDAO.pesquisar(loteJson.getIdCerveja());

		if (cerveja == null) {
			throw new CervejaNaoEncontradoException();
		}

		Lote lote = new Lote();
		lote.setDescricao(loteJson.getDescricao());
		lote.setCerveja(cerveja);
		lote.setQuantidade(loteJson.getQuantidade());

		lote.setId(id);
		loteDAO.atualizar(lote);
		return lote;
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
