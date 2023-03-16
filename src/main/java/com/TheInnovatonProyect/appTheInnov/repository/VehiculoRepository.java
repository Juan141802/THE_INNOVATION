package com.TheInnovatonProyect.appTheInnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheInnovatonProyect.appTheInnov.modelo.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{

}
