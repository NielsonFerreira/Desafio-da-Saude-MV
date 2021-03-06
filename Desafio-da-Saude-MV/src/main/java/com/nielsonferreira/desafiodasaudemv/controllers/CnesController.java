package com.nielsonferreira.desafiodasaudemv.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nielsonferreira.desafiodasaudemv.models.Cnes;
import com.nielsonferreira.desafiodasaudemv.repositories.filters.CnesFilter;
import com.nielsonferreira.desafiodasaudemv.services.CnesService;

@RestController
@RequestMapping("/cnes")
public class CnesController {

	@Autowired
	private CnesService cnesService;
	
	@GetMapping
	public Page<Cnes> pesquisar(CnesFilter cnesFilter, Pageable pageable){
		return cnesService.pesquisar(cnesFilter, pageable);
	}
	
	@GetMapping("/{codigoCnes}")
	public ResponseEntity<Optional<Cnes>> buscarPeloCodigoCnes(@PathVariable Long codigoCnes){
		return cnesService.buscarPeloCodigoCnes(codigoCnes);
	}
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public ResponseEntity<Cnes> salvarCnes(@Valid @RequestBody Cnes cnes, HttpServletResponse response){
		return cnesService.salvarCnes(cnes, response);
	}
	
	@PutMapping
	@RequestMapping("/editar/{codigoCnes}")
	public ResponseEntity<Cnes> editarCnes(@PathVariable Long codigoCnes, @Valid @RequestBody Cnes cnes){
		return cnesService.editarCnes(codigoCnes, cnes);
	}
	
	@DeleteMapping("/{codigoCnes}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerCnes(@PathVariable Long codigoCnes){
		cnesService.removerCnes(codigoCnes);
	}
}
