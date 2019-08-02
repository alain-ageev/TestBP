package br.com.brasilprev.repository.helper;

import java.util.List;

import br.com.brasilprev.modelo.Pessoa;
import br.com.brasilprev.repository.filtro.PessoaFiltro;

public interface PessoaRepositoryQueries {
	
	List<Pessoa> filtrar(PessoaFiltro filtro);
}
