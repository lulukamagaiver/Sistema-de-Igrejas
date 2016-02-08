package com.br.mvsistemas.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.br.mvsistemas.erp.model.Igreja;

public class Igrejas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Igreja porId(Long id) {
		return manager.find(Igreja.class, id);
	}
	
	public List<Igreja> todas() {
		return manager.createQuery("from Igreja", Igreja.class).getResultList();
	}
	
	public Igreja guardar(Igreja igreja) {
		return manager.merge(igreja);
	}
	
	public void remover(Igreja igreja) {
		igreja = porId(igreja.getId_igreja());
		manager.remove(igreja);
	}

}