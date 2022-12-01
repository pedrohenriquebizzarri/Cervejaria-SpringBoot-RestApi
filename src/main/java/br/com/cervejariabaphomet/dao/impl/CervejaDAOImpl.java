package br.com.cervejariabaphomet.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.cervejariabaphomet.dao.CervejaDAO;
import br.com.cervejariabaphomet.entity.Cerveja;

@Repository
public class CervejaDAOImpl extends GenericDAOImpl<Cerveja, Integer> implements CervejaDAO{

}
