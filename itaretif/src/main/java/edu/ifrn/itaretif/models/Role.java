package edu.ifrn.itaretif.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	@Id
	private Long id;
	
	private String nomeRole;

	@ManyToMany(mappedBy = "roles")
	private List <Usuario> usuarios;
	
	
	public String getNomeRole() {
		return nomeRole;
	}


	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nomeRole;
	}


	@Override
	public String toString() {
		return "Role [id=" + id + ", nomeRole=" + nomeRole + "]";
	}
	
	
	
}
