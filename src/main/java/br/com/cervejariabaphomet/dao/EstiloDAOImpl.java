package br.com.cervejariabaphomet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cervejariabaphomet.entity.Estilo;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;
import br.com.cervejariabaphomet.repository.EstiloRepository;

@Component
public class EstiloDAOImpl implements EstiloDAO{

	@Autowired
	private EstiloRepository estiloRepository;

	@Override
	public List<Estilo> listar() {
		return estiloRepository.findAll();
	}

	@Override
	public Estilo pesquisar(int id) {
		return estiloRepository.findById(id).get();
	}

	@Override
	public Estilo inserir(Estilo estilo) throws EstiloNaoEncontradoException {
		return estiloRepository.save(estilo);
	}

	@Override
	public Estilo atualizar(Estilo estilo, int id) throws EstiloNaoEncontradoException {
		estilo.setId(id);
		return estiloRepository.save(estilo);
	}

	@Override
	public void remover(int id) throws KeyNotFoundException {
		estiloRepository.deleteById(id);;
	}
	
	
}
