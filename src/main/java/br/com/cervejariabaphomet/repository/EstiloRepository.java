package br.com.cervejariabaphomet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cervejariabaphomet.entity.Estilo;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Integer>{

}
