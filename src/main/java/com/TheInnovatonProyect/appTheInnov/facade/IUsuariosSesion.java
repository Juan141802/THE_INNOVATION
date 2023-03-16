package com.TheInnovatonProyect.appTheInnov.facade;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;


import com.TheInnovatonProyect.appTheInnov.dto.UsuarioSRegistroDTO;
import com.TheInnovatonProyect.appTheInnov.modelo.UsuariosSesion;

public interface IUsuariosSesion extends UserDetailsService{
	
	public UsuariosSesion guardar(UsuarioSRegistroDTO registroDTO);
	
	public List<UsuariosSesion> listarUsuarios();
	public UsuariosSesion encontrarId(Long id);
	public void crear(UsuariosSesion usuario);
	public void actualizar(UsuariosSesion usuario);
	public void eliminar(UsuariosSesion usuario);


}
