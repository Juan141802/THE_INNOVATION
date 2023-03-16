package com.TheInnovatonProyect.appTheInnov.facadeImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.TheInnovatonProyect.appTheInnov.dto.UsuarioSRegistroDTO;
import com.TheInnovatonProyect.appTheInnov.facade.IUsuariosSesion;
import com.TheInnovatonProyect.appTheInnov.modelo.Rol;
import com.TheInnovatonProyect.appTheInnov.modelo.UsuariosSesion;
import com.TheInnovatonProyect.appTheInnov.repository.RolRepository;
import com.TheInnovatonProyect.appTheInnov.repository.UsuarioSesionRepository;

@Service
public class UsuariosSesiondao implements IUsuariosSesion{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioSesionRepository usuarioRepos;
	@Autowired
	private RolRepository rolrepos;
	private UsuariosSesion usuarios;
	
	

	
	@Override
	public UsuariosSesion encontrarId(Long id) {
		// TODO Auto-generated method stub
		return this.usuarioRepos.getReferenceById(id);
	}

	@Override
	public void crear(UsuariosSesion usuario) {
		this.usuarioRepos.save(usuario);
		
	}

	@Override
	public void actualizar(UsuariosSesion usuario) {
		this.usuarioRepos.save(usuario);
		
	}

	@Override
	public void eliminar(UsuariosSesion usuario) {
		this.usuarioRepos.save(usuario);
		
	}
	
	@Override
	public UsuariosSesion guardar(UsuarioSRegistroDTO registroDTO) {
		UsuariosSesion usuariosesion = new UsuariosSesion
				(registroDTO.getNombre(),
				registroDTO.getApellido(),
				registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getContraseña()),rolrepos.EstablecerRol());			
		return usuarioRepos.save(usuariosesion);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuariosSesion usuariosesion = usuarioRepos.findByEmail(username);
		if(usuariosesion == null) {
			throw new UsernameNotFoundException("Usuario o Contraseña Inválidos");
		}
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		session.setAttribute("usersession", usuarios);
		
		return new User(usuariosesion.getEmail(), usuariosesion.getPassword(), mapearAutoridadesRoles(usuariosesion.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}


	@Override
	public List<UsuariosSesion> listarUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepos.findAll();
	}


	





	
	
}
