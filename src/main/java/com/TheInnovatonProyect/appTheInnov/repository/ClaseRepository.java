package com.TheInnovatonProyect.appTheInnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheInnovatonProyect.appTheInnov.modelo.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long>{

}
