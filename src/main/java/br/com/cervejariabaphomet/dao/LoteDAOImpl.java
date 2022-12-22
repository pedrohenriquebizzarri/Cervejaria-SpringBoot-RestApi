package br.com.cervejariabaphomet.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cervejariabaphomet.entity.Cerveja;
import br.com.cervejariabaphomet.entity.Lote;
import br.com.cervejariabaphomet.exception.CervejaNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;
import br.com.cervejariabaphomet.repository.CervejaRepository;
import br.com.cervejariabaphomet.repository.LoteRepository;
import br.com.cervejariabaphomet.resource.LoteResource;

@Component
public class LoteDAOImpl implements LoteDAO {

	@Autowired
	private LoteRepository loteRepository;

	@Autowired
	private CervejaRepository cervejaRepository;

	@Override
	public List<Lote> listar() {
		return loteRepository.findAll();
	}

	@Override
	public Lote pesquisar(int id) {
		return loteRepository.findById(id).get();
	}

	@Override
	public Lote inserir(LoteResource loteResource) throws CervejaNaoEncontradoException {
		Cerveja cerveja = cervejaRepository.findById(loteResource.getIdCerveja()).get();

		if (cerveja == null) {
			throw new CervejaNaoEncontradoException();
		}

		Lote lote = loteResource.toLote();
		lote.setCerveja(cerveja);

		//TODO Substituir por valores do LoteResource
		Calendar dataFrabricao = Calendar.getInstance();
		dataFrabricao.set(Calendar.YEAR, 2022);
		dataFrabricao.set(Calendar.MONTH, 12);
		dataFrabricao.set(Calendar.DATE, 22);
		
		lote.setDataFabricacao(dataFrabricao);
		
		Calendar dataVencimento = Calendar.getInstance();
		dataVencimento.set(Calendar.YEAR, 2022);
		dataVencimento.set(Calendar.MONTH, 12);
		dataVencimento.set(Calendar.DATE, 22);
		
		lote.setDataVencimento(dataVencimento);
		
		loteRepository.save(lote);
		return lote;
	}

	@Override
	public Lote atualizar(LoteResource loteJson, int id) throws CervejaNaoEncontradoException {
		Cerveja cerveja = cervejaRepository.findById(loteJson.getIdCerveja()).get();

		if (cerveja == null) {
			throw new CervejaNaoEncontradoException();
		}

		Lote lote = new Lote();
		lote.setDescricao(loteJson.getDescricao());
		lote.setCerveja(cerveja);
		lote.setQuantidade(loteJson.getQuantidade());

		lote.setId(id);
		loteRepository.save(lote);
		return lote;
	}

	@Override
	public void remover(int id) throws KeyNotFoundException {
		loteRepository.deleteById(id);
	}

	@Override
	public void valida(Lote lote) {
		// TODO Auto-generated method stub

	}

}
