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

import br.com.cervejariabaphomet.entity.Lote;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;
import br.com.cervejariabaphomet.resource.LoteResource;
import br.com.cervejariabaphomet.service.LoteService;


@RestController
@RequestMapping("lote")
public class LoteController {

	@Autowired
	private LoteService loteService;
	
	@GetMapping("listar")
	public ResponseEntity<List<Lote>> listar() {
		return new ResponseEntity<List<Lote>>(loteService.listar(), HttpStatus.OK);
	}

	@GetMapping("pesquisar/{id}")
	public ResponseEntity<Lote> pesquisar(@PathVariable int id){
		return new ResponseEntity<Lote>(loteService.pesquisar(id), HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping("inserir")
	public ResponseEntity<Lote> cadastrar(@RequestBody LoteResource loteResource) {
		try {
			return new ResponseEntity<Lote>(loteService.inserir(loteResource), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Lote>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@PutMapping("atualizar/{id}")
	public ResponseEntity<Lote> atualizar(@RequestBody LoteResource loteResource, @PathVariable int id){
		try {
			return new ResponseEntity<Lote>(loteService.atualizar(loteResource, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Lote>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Lote> deletar(@PathVariable int id){
		try {
			loteService.remover(id);
			return new ResponseEntity<Lote>(HttpStatus.OK);
		} catch (KeyNotFoundException e) {
			return new ResponseEntity<Lote>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Lote>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
