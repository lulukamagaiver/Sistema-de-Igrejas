package com.br.mvsistemas.erp.model;

public enum TipoIgreja {

	MATRIZ("Igreja Polo"), 
	FILIAL("Congregação");
	
	private String descricao;

	TipoIgreja(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}