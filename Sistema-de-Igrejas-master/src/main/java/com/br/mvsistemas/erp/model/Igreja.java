package com.br.mvsistemas.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Igreja implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_igreja;

	@Column(name = "nome_fantasia", nullable = false, length = 80)
	private String nomeFantasia;

	@Column(name = "razao_social", nullable = false, length = 120)
	private String razaoSocial;

	@Column(nullable = false, length = 18)
	private String cnpj;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_fundacao")
	private Date dataFundacao;

	@Enumerated(EnumType.STRING)
	private TipoIgreja tipo;
	
	@ManyToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="id_endereco") @ForeignKey(name="FK_IGREJA_ENDERECO")
	private Endereco endereco = new Endereco();
	
	@Lob
	private Byte[] foto;

	public Long getId_igreja() {
		return id_igreja;
	}

	public void setId_igreja(Long id_igreja) {
		this.id_igreja = id_igreja;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public TipoIgreja getTipo() {
		return tipo;
	}

	public void setTipo(TipoIgreja tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Byte[] getFoto() {
		return foto;
	}

	public void setFoto(Byte[] foto) {
		this.foto = foto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_igreja == null) ? 0 : id_igreja.hashCode());
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
		Igreja other = (Igreja) obj;
		if (id_igreja == null) {
			if (other.id_igreja != null)
				return false;
		} else if (!id_igreja.equals(other.id_igreja))
			return false;
		return true;
	}	
}