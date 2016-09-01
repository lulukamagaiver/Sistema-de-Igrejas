package com.br.mvsistemas.erp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.br.mvsistemas.erp.model.Usuario;
import com.br.mvsistemas.erp.repository.Usuarios;
import com.br.mvsistemas.erp.util.FacesMessages;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;
	
	@Inject
	private Usuario usuario;
	
	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public void consultar() {
		listaUsuarios = usuarios.todas();
	}

	public String login() {
		FacesMessages msg = new FacesMessages();
		consultar();
		if (listaUsuarios.size() > 0) {			
			if (StringUtils.isEmpty(this.usuario.getNome()) && StringUtils.isEmpty(this.usuario.getSenha())) {
				msg.error("Informe Usuario e/ou Senha para Logar.");
			}else{
				for (Usuario usuario : listaUsuarios) {
					if (usuario.getNome().equals(this.usuario.getNome()) && usuario.getSenha().equals(this.usuario.getSenha())) {
						this.usuario.setNome(usuario.getNome());
						msg.info("Usuario Logado!");
						return "GestaoIgrejas?faces-redirect=true";
					}
				}
				msg.error("Usuario e/ou Senha Invalidos");
			}
		}else{
			msg.error("Nenhum Usuario cadastrado no Banco.");
		}

		return null;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login?faces-redirect=true";
	}
	
	public int getAnoAtual() {
		Calendar cal = GregorianCalendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
