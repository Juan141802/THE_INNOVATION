package com.TheInnovatonProyect.appTheInnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheInnovatonProyect.appTheInnov.modelo.CategoriaCurso;

@Repository
public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Long>{

}
