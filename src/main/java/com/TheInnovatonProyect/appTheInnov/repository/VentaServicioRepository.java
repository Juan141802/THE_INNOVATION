package com.TheInnovatonProyect.appTheInnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheInnovatonProyect.appTheInnov.modelo.VentaServicios;

@Repository
public interface VentaServicioRepository extends JpaRepository<VentaServicios, Long>{

}
