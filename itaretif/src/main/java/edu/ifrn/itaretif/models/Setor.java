package edu.ifrn.itaretif.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Setor implements Serializable {
	
   private static final long SerialVersionUID = 1; 	
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   @NotEmpty
   private Long codigo;
	
   @NotEmpty
	public String nome;
	
   @NotEmpty
	public String descricao;
	
   
	public Long getCodigo() {
		return codigo;
	}
	
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
