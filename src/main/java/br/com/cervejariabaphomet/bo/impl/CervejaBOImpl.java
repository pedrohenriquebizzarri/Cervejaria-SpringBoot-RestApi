package br.com.cervejariabaphomet.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejariabaphomet.bo.CervejaBO;
import br.com.cervejariabaphomet.dao.CervejaDAO;
import br.com.cervejariabaphomet.dao.EstiloDAO;
import br.com.cervejariabaphomet.entity.Cerveja;
import br.com.cervejariabaphomet.entity.Estilo;
import br.com.cervejariabaphomet.entity.json.CervejaJson;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

@Service
public class CervejaBOImpl implements CervejaBO{

	@Autowired
	private CervejaDAO cervejaDAO;
	
	@Autowired
	private EstiloDAO estiloDAO;
	
	@Override
	public List<Cerveja> listar() {
		return cervejaDAO.listar();
	}

	@Override
	public Cerveja pesquisar(int id) {
		return cervejaDAO.pesquisar(id);
	}
	
	@Override
	public Cerveja inserir(CervejaJson cervejaJson) throws EstiloNaoEncontradoException {
		Estilo estilo = estiloDAO.pesquisar(cervejaJson.getIdEstilo());
		
		if(estilo == null) {
			throw new EstiloNaoEncontradoException();
		}
		
		Cerveja cerveja = new Cerveja(
				cervejaJson.getNome(), 
				estilo, 
				cervejaJson.getDescricao(), 
				cervejaJson.getAbv(), 
				cervejaJson.getIbu(), 
				cervejaJson.getEbc());
		
		cervejaDAO.inserir(cerveja);
		
		return cerveja;
	}

	@Override
	public Cerveja atualizar(CervejaJson cervejaJson, int id) throws EstiloNaoEncontradoException {
		Estilo estilo = estiloDAO.pesquisar(cervejaJson.getIdEstilo());
		
		if(estilo == null) {
			throw new EstiloNaoEncontradoException();
		}
		
		Cerveja cerveja = new Cerveja(
				cervejaJson.getNome(), 
				estilo, 
				cervejaJson.getDescricao(), 
				cervejaJson.getAbv(), 
				cervejaJson.getIbu(), 
				cervejaJson.getEbc());
		
		cerveja.setId(id);
		cervejaDAO.atualizar(cerveja);
		return cerveja;
	}

	@Override
	public void remover(int id) throws KeyNotFoundException {
		cervejaDAO.remover(id);
	}

	@Override
	public void valida(Cerveja cerveja) throws EstiloNaoEncontradoException {
		
	}

	
}
