package br.com.cervejariabaphomet.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cervejariabaphomet.entity.Cerveja;
import br.com.cervejariabaphomet.entity.Estilo;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;
import br.com.cervejariabaphomet.repository.CervejaRepository;
import br.com.cervejariabaphomet.repository.EstiloRepository;
import br.com.cervejariabaphomet.resource.CervejaResource;

@Component
public class CervejaDAOImpl implements CervejaDAO{

	@Autowired
	private CervejaRepository cervejaRepository;
	
	@Autowired
	private EstiloRepository estiloRepository;
	
	@Override
	public List<Cerveja> listar() {
		return cervejaRepository.findAll();
	}

	@Override
	public Cerveja pesquisar(int id) {
		return cervejaRepository.findById(id).get();
	}

	@Override
	public Cerveja inserir(CervejaResource cervejaResource) throws EstiloNaoEncontradoException {
		Optional<Estilo> estilo = estiloRepository.findById(cervejaResource.getIdEstilo());
		
		if(estilo == null) {
			throw new EstiloNaoEncontradoException();
		}
		
		Cerveja cerveja = cervejaResource.toCerveja();
		cerveja.setEstilo(estilo.get());
		
		return cervejaRepository.save(cerveja);
	}

	@Override
	public Cerveja atualizar(CervejaResource cervejaJson, int id) throws EstiloNaoEncontradoException {
		Optional<Estilo> estilo = estiloRepository.findById(cervejaJson.getIdEstilo());
		
		if(estilo == null) {
			throw new EstiloNaoEncontradoException();
		}
		
		Cerveja cerveja = new Cerveja(
				cervejaJson.getNome(), 
				estilo.get(), 
				cervejaJson.getDescricao(), 
				cervejaJson.getAbv(), 
				cervejaJson.getIbu(), 
				cervejaJson.getEbc());
		
		cerveja.setId(id);
		cervejaRepository.save(cerveja);
		return cerveja;
	}

	@Override
	public void remover(int id) throws KeyNotFoundException {
		cervejaRepository.deleteById(id);
		
	}

	@Override
	public void valida(Cerveja cerveja) throws EstiloNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

}
