package com.nielsonferreira.desafiodasaudemv.repositories.cnes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.nielsonferreira.desafiodasaudemv.models.Cnes;
import com.nielsonferreira.desafiodasaudemv.models.Cnes_;
import com.nielsonferreira.desafiodasaudemv.repositories.filters.CnesFilter;

public class CnesRepositoryImpl implements CnesRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Cnes> filtrar(CnesFilter cnesFilter, Pageable pageable) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cnes> criteria = builder.createQuery(Cnes.class);
		
		Root<Cnes> root = criteria.from(Cnes.class);
		
		/*
		 * Restrições
		 */
		Predicate[] predicates = criarRestricoes(cnesFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Cnes> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		System.out.println(query.getResultList().toArray());
		
		return new PageImpl<>(query.getResultList(), pageable, total(cnesFilter)) ;
	}

	private Predicate[] criarRestricoes(CnesFilter cnesFilter, CriteriaBuilder builder, Root<Cnes> root) {
		List<Predicate> predicates = new ArrayList<>();

		/*
		 * JPA Metamodel
		 */
		
		if(cnesFilter.getTipoGestao() != null) {
			predicates.add(builder.like(builder.upper(root.get(Cnes_.TIPO_GESTAO)), "%" + cnesFilter.getTipoGestao().toUpperCase() + "%"));
		}
		
		if(cnesFilter.getUf() != null) {
			predicates.add(builder.like(builder.upper(root.get(Cnes_.UF)), "%" + cnesFilter.getUf().toUpperCase() + "%"));
		}
		
		if(cnesFilter.getMunicipio() != null) {
			predicates.add(builder.like(builder.upper(root.get(Cnes_.MUNICIPIO)), cnesFilter.getMunicipio().toUpperCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
		
	}
	
	/*
	 * Paginação da pesquisa
	 */
	private void adicionarRestricoesDePaginacao(TypedQuery<Cnes> query, Pageable pageable) {

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(CnesFilter cnesFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Cnes> root = criteria.from(Cnes.class);
		
		Predicate[] predicates = criarRestricoes(cnesFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}

}
