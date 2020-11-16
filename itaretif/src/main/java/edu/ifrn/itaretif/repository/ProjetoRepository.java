package edu.ifrn.itaretif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifrn.itaretif.models.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

}

