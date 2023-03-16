package com.TheInnovatonProyect.appTheInnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheInnovatonProyect.appTheInnov.modelo.ProgramacionCurso;

@Repository
public interface ProgramacionCursoRepository extends JpaRepository<ProgramacionCurso, Long>{

}
