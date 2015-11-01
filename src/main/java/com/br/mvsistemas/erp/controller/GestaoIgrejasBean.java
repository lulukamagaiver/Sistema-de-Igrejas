package com.br.mvsistemas.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.mvsistemas.erp.model.Igreja;
import com.br.mvsistemas.erp.repository.Igrejas;

@Named
@ViewScoped
public class GestaoIgrejasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Igrejas igrejas;
	
	private List<Igreja> todasIgrejas;
	
	public void consultar() {
		todasIgrejas = igrejas.todas();
	}

	public List<Igreja> getTodasIgrejas() {
		return todasIgrejas;
	}
	
}