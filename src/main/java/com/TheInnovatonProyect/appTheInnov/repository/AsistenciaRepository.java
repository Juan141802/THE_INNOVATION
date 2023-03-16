package com.TheInnovatonProyect.appTheInnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheInnovatonProyect.appTheInnov.modelo.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia,Long> {

}
