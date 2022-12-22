package br.com.cervejariabaphomet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cervejariabaphomet.entity.Cerveja;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Integer>{

}
