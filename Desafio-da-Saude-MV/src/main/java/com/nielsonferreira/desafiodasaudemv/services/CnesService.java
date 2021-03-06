package com.nielsonferreira.desafiodasaudemv.services;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.nielsonferreira.desafiodasaudemv.events.RecursoCriadoEvent;
import com.nielsonferreira.desafiodasaudemv.models.Cnes;
import com.nielsonferreira.desafiodasaudemv.repositories.CnesRepository;
import com.nielsonferreira.desafiodasaudemv.repositories.filters.CnesFilter;

@Service
public class CnesService {

	@Autowired
	private CnesRepository cnesRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public Page<Cnes> pesquisar(CnesFilter cnesFilter, Pageable pageable){
		return cnesRepository.filtrar(cnesFilter, pageable);
	}
	
	public ResponseEntity<Optional<Cnes>> buscarPeloCodigoCnes(@PathVariable Long codigoCnes){
		Optional<Cnes> cnes = cnesRepository.findById(codigoCnes);
		
		if (!cnes.isEmpty())
			return ResponseEntity.ok(cnes);
		else
			return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<Cnes> salvarCnes(@Valid @RequestBody Cnes cnes, HttpServletResponse response){
		Cnes cnesSalvo = cnesRepository.save(cnes);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cnesSalvo.getCodigoCnes()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cnesSalvo);
	}
	
	public ResponseEntity<Cnes> editarCnes(@PathVariable Long codigoCnes, @Valid @RequestBody Cnes cnes){
		Cnes cnesSalvo = cnesRepository.getById(codigoCnes);
		BeanUtils.copyProperties(cnes, cnesSalvo, "codigoCnes");
		cnesRepository.save(cnesSalvo);
		return ResponseEntity.status(HttpStatus.OK).body(cnesSalvo);
	}

	public void removerCnes(@PathVariable Long codigoCnes) {
		cnesRepository.deleteById(codigoCnes);
	}
	
}
