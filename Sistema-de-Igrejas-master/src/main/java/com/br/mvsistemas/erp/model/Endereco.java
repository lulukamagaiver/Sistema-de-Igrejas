package com.br.mvsistemas.erp.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2954087443444174579L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id_endereco;
		
	@Column(nullable=true, length=60)
	private String endereco;
	
	@Column(nullable=true)
	private String telefone;
	
	@Column(nullable=true, length=60)
	private String bairro;
	
	@Column(nullable=true)
	private String numero;
	
	@Column(nullable=true)
	private String cidade;
	
	@Column(nullable=true, length=2)
	private String uf;
	
	@Column(nullable=true, length=10)
	private String cep;
	
	@Column(nullable=true, length=60)
	private String email;
		
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date DtCadastro;//se o id for = null, insere data de cadastro
		
	@javax.persistence.Transient
	private int calcIdade;
	
	/**
	 * @return the id_endereco
	 */
	public Long getId_endereco() {
		return id_endereco;
	}
	/**
	 * @param id_endereco the id_endereco to set
	 */
	public void setId_endereco(Long id_endereco) {
		this.id_endereco = id_endereco;
	}
	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}
	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}
	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dtCadastro
	 * @throws ParseException 
	 */
	public Date getDtCadastro(){
		return DtCadastro;
	}
	/**
	 * @param dtCadastro the dtCadastro to set
	 */
	public void setDtCadastro(Date dtCadastro) {
		DtCadastro = dtCadastro;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_endereco ^ (id_endereco >>> 32));
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
		Endereco other = (Endereco) obj;
		if (id_endereco != other.id_endereco)
			return false;
		return true;
	}
	
	
}
