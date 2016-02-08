package com.br.mvsistemas.erp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.mvsistemas.erp.model.AdmUsuario;
import com.br.mvsistemas.erp.model.ControleAcesso;
import com.br.mvsistemas.erp.model.Usuario;
import com.br.mvsistemas.erp.repository.AdmUsuarios;
import com.br.mvsistemas.erp.repository.ControleAcessos;
import com.br.mvsistemas.erp.util.FacesMessages;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AdmUsuario admUsuario;
	
	private List<AdmUsuario> listaUsuarios = new ArrayList<AdmUsuario>();
	
	@Inject
	private AdmUsuarios admUsuarios;
		
	@Inject
	private ControleAcesso acesso;
	
	@Inject
	private ControleAcessos salvaAcesso;

	private String nomeUsuario;

	private String senha;

	public String login() {
		FacesMessages msg = new FacesMessages();
		
		listaUsuarios = admUsuarios.todas();
		
		if (listaUsuarios == null) {
			msg.error("Não Há Usuarios Cadastrados");
		} else {
			for (AdmUsuario admUsuario : listaUsuarios) {
				this.admUsuario.setNome(admUsuario.getNome());
				this.admUsuario.setNomeUser(admUsuario.getNomeUser());
				this.admUsuario.setSenhaUser(admUsuario.getSenhaUser());
				
				if (this.admUsuario.getNomeUser().equals(this.nomeUsuario) && this.admUsuario.getSenhaUser().equals(this.senha)) {
					//this.usuario.setNome(this.nomeUsuario);
					
					acesso.setDataLogin(new Date());
					acesso.setUsuario(admUsuario);
					
					salvaAcesso.guardar(acesso);
					
					msg.info("Usuario Logado!");
					
					return "GestaoIgrejas?faces-redirect=true";
					
				} else {
					msg.error("Usuario e/ou Senha Invalidos");
				}
			}
				
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

	/**
	 * @return the listaUsuarios
	 */
	public List<AdmUsuario> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(List<AdmUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
