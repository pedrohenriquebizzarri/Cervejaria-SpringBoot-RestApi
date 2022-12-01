package br.com.cervejariabaphomet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cervejariabaphomet.bo.CervejaBO;
import br.com.cervejariabaphomet.entity.Cerveja;
import br.com.cervejariabaphomet.entity.json.CervejaJson;
import br.com.cervejariabaphomet.exception.EstiloNaoEncontradoException;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

@RestController
@RequestMapping("cerveja")
@Validated
public class CervejaController {

	@Autowired
	private CervejaBO cervejaBO;

	@GetMapping("listar")
	public ResponseEntity<List<Cerveja>> listar() {
		return new ResponseEntity<List<Cerveja>>(cervejaBO.listar(), HttpStatus.OK);
	}

	@GetMapping("pesquisar/{id}")
	public ResponseEntity<Cerveja> pesquisar(@PathVariable int id){
		return new ResponseEntity<Cerveja>(cervejaBO.pesquisar(id), HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping("inserir")
	public ResponseEntity<Cerveja> cadastrar(@RequestBody CervejaJson cervejaJson) {
		try {
			return new ResponseEntity<Cerveja>(
					cervejaBO.inserir(cervejaJson), HttpStatus.CREATED);
		} catch (EstiloNaoEncontradoException e) {
			return new ResponseEntity<Cerveja>(HttpStatus.CONFLICT);
		}catch (Exception e) {
			return new ResponseEntity<Cerveja>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@PutMapping("atualizar/{id}")
	public ResponseEntity<Cerveja> atualizar(@RequestBody CervejaJson cervejaJson, @PathVariable int id){
		try {
			return new ResponseEntity<Cerveja>(cervejaBO.atualizar(cervejaJson, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Cerveja>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Cerveja> deletar(@PathVariable int id){
		try {
			cervejaBO.remover(id);
			return new ResponseEntity<Cerveja>(HttpStatus.OK);
		} catch (KeyNotFoundException e) {
			return new ResponseEntity<Cerveja>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Cerveja>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
