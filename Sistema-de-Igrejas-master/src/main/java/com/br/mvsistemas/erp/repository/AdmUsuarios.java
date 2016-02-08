package com.br.mvsistemas.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.br.mvsistemas.erp.model.AdmUsuario;

public class AdmUsuarios implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public AdmUsuario porId(Long id){
		return manager.find(AdmUsuario.class, id);
	}
	
	public List<AdmUsuario> todas() {
		return manager.createQuery("from AdmUsuario", AdmUsuario.class).getResultList();
	}
	
	public AdmUsuario guardar(AdmUsuario admUsuario) {
		return manager.merge(admUsuario);
	}
	
	public void remover(AdmUsuario admUsuario) {
		admUsuario = porId(admUsuario.getId_admUsuario());
		manager.remove(admUsuario);
	}

}
