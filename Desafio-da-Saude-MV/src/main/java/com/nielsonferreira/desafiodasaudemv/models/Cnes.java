package com.nielsonferreira.desafiodasaudemv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CNES_ATIVO")
public class Cnes {

	@Id
	@Column(name = "CO_CNES")
	private Long codigo;

	@Column(name = "CO_IBGE")
	private String ibge;

	@Column(name = "NO_FANTASIA")
	private String nomeFantasia;

	@Column(name = "DS_TIPO_UNIDADE")
	private String tipoUnidade;

	@Column(name = "TP_GESTAO")
	private String tipoGestao;

	@Column(name = "NO_LOGRADOURO")
	private String logradouro;

	@Column(name = "NU_ENDERECO")
	private String numeroEndereco;

	@Column(name = "NO_BAIRRO")
	private String bairro;

	@Column(name = "CO_CEP")
	private String cep;

	@Column(name = "UF")
	private String uf;

	@Column(name = "MUNICIPIO")
	private String municipio;

	@Column(name = "NU_TELEFONE")
	private String telefone;
}
