package com.br.mvsistemas.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AdmUsuario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_admUsuario;
	
	@Column(nullable = false, length = 80)
	private String nome;
	
	@Column(nullable = false, length = 80)
	private String nomeUser;
	
	@Column(nullable = false, length = 80)
	private String senhaUser;
	
	@Temporal(TemporalType.DATE)
	private Date criacao;

	/**
	 * @return the id_admUsuario
	 */
	public Long getId_admUsuario() {
		return id_admUsuario;
	}

	/**
	 * @param id_admUsuario the id_admUsuario to set
	 */
	public void setId_admUsuario(Long id_admUsuario) {
		this.id_admUsuario = id_admUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public String getSenhaUser() {
		return senhaUser;
	}

	public void setSenhaUser(String senhaUser) {
		this.senhaUser = senhaUser;
	}

	public Date getCriacao() {
		return criacao = new Date();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_admUsuario == null) ? 0 : id_admUsuario.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdmUsuario other = (AdmUsuario) obj;
		if (id_admUsuario == null) {
			if (other.id_admUsuario != null)
				return false;
		} else if (!id_admUsuario.equals(other.id_admUsuario))
			return false;
		return true;
	}

}
