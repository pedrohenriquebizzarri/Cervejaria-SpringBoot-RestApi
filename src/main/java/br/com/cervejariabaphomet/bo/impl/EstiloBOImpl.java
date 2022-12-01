package br.com.cervejariabaphomet.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejariabaphomet.bo.EstiloBO;
import br.com.cervejariabaphomet.dao.EstiloDAO;
import br.com.cervejariabaphomet.entity.Estilo;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

@Service
public class EstiloBOImpl implements EstiloBO{

	@Autowired
	private EstiloDAO estiloDAO;
	
	@Override
	public List<Estilo> listar() {
		return estiloDAO.listar();
	}

	@Override
	public Estilo pesquisar(int id) {
		return estiloDAO.pesquisar(id);
	}

	@Override
	public Estilo inserir(Estilo estilo) throws EstiloNaoEncontradoException {
		estiloDAO.inserir(estilo);
		return estilo;
	}

	@Override
	public Estilo atualizar(Estilo estilo, int id) throws EstiloNaoEncontradoException {
		estilo.setId(id);
		estiloDAO.atualizar(estilo);
		return estilo;
	}

	@Override
	public void remover(int id) throws KeyNotFoundException {
		estiloDAO.remover(id);
	}

	@Override
	public void valida(Estilo estilo) throws EstiloNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

}
