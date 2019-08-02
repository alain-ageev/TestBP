package br.com.brasilprev.dto;

import java.util.List;

public class PessoaDto {

  public Long codigo;

  public String nome;

  public String cpf;

  public List<EnderecoDto> enderecos;

  public List<TelefoneDto> telefones;
}