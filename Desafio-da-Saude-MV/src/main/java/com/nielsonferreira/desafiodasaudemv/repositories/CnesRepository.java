package com.nielsonferreira.desafiodasaudemv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nielsonferreira.desafiodasaudemv.models.Cnes;
import com.nielsonferreira.desafiodasaudemv.repositories.cnes.CnesRepositoryQuery;

@Repository
public interface CnesRepository extends JpaRepository<Cnes, Long>, CnesRepositoryQuery {

}
