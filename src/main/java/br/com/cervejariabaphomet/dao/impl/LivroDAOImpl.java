package br.com.cervejariabaphomet.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.cervejariabaphomet.dao.LivroDAO;
import br.com.cervejariabaphomet.entity.Livro;

@Repository
public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer> implements LivroDAO{

}
