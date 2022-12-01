package br.com.cervejariabaphomet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cervejariabaphomet.bo.LoteBO;
import br.com.cervejariabaphomet.entity.Lote;
import br.com.cervejariabaphomet.entity.json.LoteJson;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;


@RestController
@RequestMapping("lote")
public class LoteController {

	@Autowired
	private LoteBO loteBO;
	
	@GetMapping("listar")
	public ResponseEntity<List<Lote>> listar() {
		return new ResponseEntity<List<Lote>>(loteBO.listar(), HttpStatus.OK);
	}

	@GetMapping("pesquisar/{id}")
	public ResponseEntity<Lote> pesquisar(@PathVariable int id){
		return new ResponseEntity<Lote>(loteBO.pesquisar(id), HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping("inserir")
	public ResponseEntity<Lote> cadastrar(@RequestBody LoteJson loteJson) {
		try {
			return new ResponseEntity<Lote>(loteBO.inserir(loteJson), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Lote>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@PutMapping("atualizar/{id}")
	public ResponseEntity<Lote> atualizar(@RequestBody LoteJson loteJson, @PathVariable int id){
		try {
			return new ResponseEntity<Lote>(loteBO.atualizar(loteJson, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Lote>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Lote> deletar(@PathVariable int id){
		try {
			loteBO.remover(id);
			return new ResponseEntity<Lote>(HttpStatus.OK);
		} catch (KeyNotFoundException e) {
			return new ResponseEntity<Lote>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Lote>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
