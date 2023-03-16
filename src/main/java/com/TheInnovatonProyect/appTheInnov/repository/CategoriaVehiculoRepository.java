package com.TheInnovatonProyect.appTheInnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheInnovatonProyect.appTheInnov.modelo.CategoriaVehiculo;

@Repository
public interface CategoriaVehiculoRepository extends JpaRepository<CategoriaVehiculo, Long>{

}
