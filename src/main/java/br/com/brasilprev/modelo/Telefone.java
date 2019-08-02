package br.com.brasilprev.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "telefone")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(length = 2, nullable = false)
	private String ddd;

	@Column(length = 9, nullable = false)
	private String numero;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_pessoa")
	@JsonIgnore
	private Pessoa pessoa;

	private Telefone() {}

	public Telefone(String ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public String getNumero() {
		return numero;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
