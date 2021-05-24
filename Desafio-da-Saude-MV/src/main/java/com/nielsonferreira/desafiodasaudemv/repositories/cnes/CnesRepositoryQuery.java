package com.nielsonferreira.desafiodasaudemv.repositories.cnes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nielsonferreira.desafiodasaudemv.models.Cnes;
import com.nielsonferreira.desafiodasaudemv.repositories.filters.CnesFilter;

public interface CnesRepositoryQuery {

	public Page<Cnes> filtrar(CnesFilter cnesFilter, Pageable pageable);
}
