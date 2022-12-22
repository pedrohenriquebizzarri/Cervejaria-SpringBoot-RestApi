package br.com.cervejariabaphomet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cervejariabaphomet.entity.Lote;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Integer>{

}
