package br.com.brasilprev.service;

import br.com.brasilprev.dto.PessoaDto;
import br.com.brasilprev.modelo.Pessoa;
import br.com.brasilprev.service.exception.TelefoneNaoEncontradoException;
import br.com.brasilprev.service.exception.UnicidadeCpfException;
import br.com.brasilprev.service.exception.UnicidadeTelefoneException;

public interface PessoaService {

	Pessoa salvar(PessoaDto pessoa) throws UnicidadeCpfException, UnicidadeTelefoneException;

	Pessoa buscarPorTelefone(String ddd, String telefone) throws TelefoneNaoEncontradoException;

}
