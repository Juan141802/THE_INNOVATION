package com.TheInnovatonProyect.appTheInnov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TheInnovatonProyect.appTheInnov.modelo.Rol;



public interface RolRepository extends JpaRepository<Rol, Long>{
	
	@Query(
			value = "SELECT * FROM rol WHERE rol.id = 1",
			nativeQuery = true
	)
	List<Rol> EstablecerRol();

}
