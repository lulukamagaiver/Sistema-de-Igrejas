package com.br.mvsistemas.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.mvsistemas.erp.model.AdmUsuario;
import com.br.mvsistemas.erp.repository.AdmUsuarios;

@Named
@ViewScoped
public class AdmUsuariosBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AdmUsuarios admUsuarios; 
	
	private List<AdmUsuario> todosAdmUsuarios;
	
	public void consultar() {
		todosAdmUsuarios = admUsuarios.todas();
	}

	public List<AdmUsuario> getTodosAdmUsuario() {
		return todosAdmUsuarios;
	}
	
}
