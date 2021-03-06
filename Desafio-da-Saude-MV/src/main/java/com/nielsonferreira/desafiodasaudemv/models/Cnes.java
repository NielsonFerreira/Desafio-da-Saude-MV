package com.nielsonferreira.desafiodasaudemv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "SEQUENCE_CNES", sequenceName = "SEQ_CNES", initialValue = 9303597, allocationSize = 1 )
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name="CNES_ATIVO")
public class Cnes {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CNES")
	@Column(name = "CO_CNES")
	private Long codigoCnes;

	@NotEmpty(message = "O campo CÓDIGO IBGE é obrigatório")
	@Column(name = "CO_IBGE")
	private String ibge;

	@NotEmpty(message = "O campo NOME FANTASIA é obrigatório")
	@Column(name = "NO_FANTASIA")
	private String nomeFantasia;

	@NotEmpty(message = "O campo TIPO DE UNIDADE é obrigatório")
	@Column(name = "DS_TIPO_UNIDADE")
	private String tipoUnidade;

	@NotEmpty(message = "O campo TIPO DE GESTÃO é obrigatório")
	@Column(name = "TP_GESTAO")
	private String tipoGestao;

	@NotEmpty(message = "O campo LOGRADOURO é obrigatório")
	@Column(name = "NO_LOGRADOURO")
	private String logradouro;

	@NotEmpty(message = "O campo NÚMERO DO ENDEREÇO é obrigatório. Se não tiver número, colocar apenas S/N")
	@Column(name = "NU_ENDERECO")
	private String numeroEndereco;

	@NotEmpty(message = "O campo BAIRRO é obrigatório")
	@Column(name = "NO_BAIRRO")
	private String bairro;

	@NotEmpty(message = "O campo CEP é obrigatório")
	@Column(name = "CO_CEP")
	private String cep;

	@NotEmpty(message = "O campo UF é obrigatório")
	@Column(name = "UF")
	private String uf;

	@NotEmpty(message = "O campo MUNICÍPIO é obrigatório")
	@Column(name = "MUNICIPIO")
	private String municipio;

	@Column(name = "NU_TELEFONE")
	private String telefone;
}
