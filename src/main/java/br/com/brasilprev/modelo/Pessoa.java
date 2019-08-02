package br.com.brasilprev.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(length = 80, nullable = false)
	private String nome;

	@Column(length = 11, nullable = false)
	private String cpf;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecos = new ArrayList<>();

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Telefone> telefones = new ArrayList<>();

	private Pessoa() {
	}

	public Pessoa(String nome, String cpf, List<Endereco> enderecos, List<Telefone> telefones) {
		this.nome = nome;
		this.cpf = cpf;
		this.enderecos = enderecos;
		this.telefones = telefones;
		this.enderecos.get(0).setPessoa(this);
		this.telefones.get(0).setPessoa(this);
	}

	public String getCpf() {
		return cpf;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public String getNome() {
		return nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
}
