package com.br.mvsistemas.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.br.mvsistemas.erp.model.ControleAcesso;
import com.br.mvsistemas.erp.model.Igreja;
import com.br.mvsistemas.erp.model.Usuario;

public class ControleAcessos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public ControleAcesso porId(Long id) {
		return manager.find(ControleAcesso.class, id);
	}
	
	public List<ControleAcesso> todas() {
		return manager.createQuery("from ControleAcesso", ControleAcesso.class).getResultList();
	}
	
	public ControleAcesso guardar(ControleAcesso controleAcesso) {
		return manager.merge(controleAcesso);
	}

}