package com.TheInnovatonProyect.appTheInnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheInnovatonProyect.appTheInnov.modelo.UsuariosSesion;

@Repository
public interface UsuarioSesionRepository extends JpaRepository<UsuariosSesion, Long>{
	
	public UsuariosSesion findByEmail(String email);

}
