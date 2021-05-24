package com.nielsonferreira.desafiodasaudemv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.nielsonferreira.desafiodasaudemv.models.Cnes;
import com.nielsonferreira.desafiodasaudemv.repositories.CnesRepository;
import com.nielsonferreira.desafiodasaudemv.repositories.filters.CnesFilter;

@Service
public class CnesService {

	@Autowired
	private CnesRepository cnesRepository;
	
	public Page<Cnes> pesquisar(CnesFilter cnesFilter, Pageable pageable){
		return cnesRepository.filtrar(cnesFilter, pageable);
	}
	
	public ResponseEntity<Optional<Cnes>> buscarPeloCodigoCnes(@PathVariable Long codigoCnes){
		Optional<Cnes> cnes = cnesRepository.findById(codigoCnes);
		
		return ResponseEntity.ok(cnes);
	}
}
