package com.br.mvsistemas.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.mvsistemas.erp.model.Igreja;
import com.br.mvsistemas.erp.repository.Igrejas;
import com.br.mvsistemas.erp.util.Transacional;

public class CadastroIgrejaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Igrejas igrejas;
	
	@Transacional
	public void salvar(Igreja igreja) {
		igrejas.guardar(igreja);
	}
	
	@Transacional
	public void excluir(Igreja igreja) {
		igrejas.remover(igreja);
	}

}