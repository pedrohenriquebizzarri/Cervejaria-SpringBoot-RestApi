package br.com.cervejariabaphomet.bo;

import java.util.List;

import br.com.cervejariabaphomet.entity.Lote;
import br.com.cervejariabaphomet.entity.json.LoteJson;
import br.com.cervejariabaphomet.exception.CervejaNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

public interface LoteBO {

	public List<Lote> listar();
	
	public Lote pesquisar(int id);
	
	public Lote inserir(LoteJson loteJson) throws CervejaNaoEncontradoException;

	public Lote atualizar(LoteJson loteJson, int id) throws CervejaNaoEncontradoException;
	
	public void remover(int id) throws KeyNotFoundException;
	
	public void valida(Lote lote);
}
