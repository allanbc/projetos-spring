package com.algaworks.brewer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.repository.Cervejas;

@Service
public class CadastroCervejaService {
	
	@Autowired
	private Cervejas cervejas;
	
	//Abre uma transação - Aula 9.8
	@Transactional
	public void salvar(Cerveja cerveja){
		cervejas.save(cerveja);
	}
	
	
}
