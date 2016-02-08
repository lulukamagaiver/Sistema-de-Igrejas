package com.br.mvsistemas.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

@SuppressWarnings("deprecation")
@Entity
public class ControleAcesso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9219801049250154110L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="id_admUsuario") @ForeignKey(name="FK_USUARIO_CONTROLE_ACESSO")
	private AdmUsuario usuario;

	@Temporal(TemporalType.DATE)
	private Date dataLogin;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public AdmUsuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(AdmUsuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the dataLogin
	 */
	public Date getDataLogin() {
		return dataLogin;
	}

	/**
	 * @param dataLogin the dataLogin to set
	 */
	public void setDataLogin(Date dataLogin) {
		this.dataLogin = dataLogin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ControleAcesso other = (ControleAcesso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
