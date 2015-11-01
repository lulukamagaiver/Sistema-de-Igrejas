package com.br.mvsistemas.erp.controller;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.mvsistemas.erp.model.AdmUsuario;
import com.br.mvsistemas.erp.model.Usuario;
import com.br.mvsistemas.erp.repository.AdmUsuarios;
import com.br.mvsistemas.erp.util.FacesMessages;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;

	private String nomeUsuario;

	private String senha;

	public String login() {
		FacesMessages msg = new FacesMessages();

		if ("admin".equals(this.nomeUsuario) && "admin".equals(this.senha)) {
			this.usuario.setNome(this.nomeUsuario);
			this.usuario.setDataLogin(new Date());

			msg.info("Usuario Logado!");

			return "GestaoIgrejas?faces-redirect=true";
			
			
		} else {

			msg.error("Usuario e/ou Senha Invalidos");
			
		}

		return null;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login?faces-redirect=true";
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
