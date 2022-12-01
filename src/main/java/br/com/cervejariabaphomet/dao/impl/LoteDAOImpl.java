package br.com.cervejariabaphomet.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.cervejariabaphomet.dao.LoteDAO;
import br.com.cervejariabaphomet.entity.Lote;

@Repository
public class LoteDAOImpl extends GenericDAOImpl<Lote, Integer> implements LoteDAO{

}
