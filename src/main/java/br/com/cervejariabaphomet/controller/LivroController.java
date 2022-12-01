package br.com.cervejariabaphomet.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cervejariabaphomet.bo.LivroBO;
import br.com.cervejariabaphomet.entity.Livro;
import br.com.cervejariabaphomet.exception.KeyNotFoundException;

@RestController
@RequestMapping("livros")
@Validated
public class LivroController {
    
    @Autowired
    private LivroBO livroBO;

    @GetMapping("listar")
    List<Livro> listar() {
        return livroBO.listar();
    }

    @GetMapping("pesquisar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livro pesquisar(@PathVariable @Min(1) int id) {
        return livroBO.pesquisar(id);
    }
    
    @PostMapping("inserir")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Livro inserir(@Valid @RequestBody Livro livro) {
    	return livroBO.inserir(livro);
    }

    @PutMapping("atualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Livro atualizar(@RequestBody Livro livro, @PathVariable int id) {
       return livroBO.atualizar(livro, id);
    }

    @PatchMapping("patch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livro patch(@RequestBody Map<String, String> update, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deletar(@PathVariable int id) throws KeyNotFoundException {
    	livroBO.remover(id);
    }
    

}
