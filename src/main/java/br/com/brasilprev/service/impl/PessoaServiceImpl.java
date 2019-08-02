package br.com.brasilprev.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.brasilprev.dto.EnderecoDto;
import br.com.brasilprev.dto.PessoaDto;
import br.com.brasilprev.dto.TelefoneDto;
import br.com.brasilprev.modelo.Endereco;
import br.com.brasilprev.modelo.Pessoa;
import br.com.brasilprev.modelo.Telefone;
import br.com.brasilprev.repository.PessoaRepository;
import br.com.brasilprev.service.PessoaService;
import br.com.brasilprev.service.exception.TelefoneNaoEncontradoException;
import br.com.brasilprev.service.exception.UnicidadeCpfException;
import br.com.brasilprev.service.exception.UnicidadeTelefoneException;

@Service
public class PessoaServiceImpl implements PessoaService {

	private final PessoaRepository pessoaRepository;

	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	@Transactional
	public Pessoa salvar(PessoaDto pessoaDto) throws UnicidadeCpfException, UnicidadeTelefoneException {
		ValidarExistencia(pessoaDto);

		List<Endereco> enderecos = pessoaDto.enderecos.stream().map(e -> mapearEndereco(e)).collect(Collectors.toList());
		List<Telefone> telefones = pessoaDto.telefones.stream().map(t -> mapearTelefone(t)).collect(Collectors.toList());
		Pessoa pessoa = new Pessoa(pessoaDto.nome, pessoaDto.cpf, enderecos, telefones);

		return pessoaRepository.save(pessoa);
	}

	private void ValidarExistencia(PessoaDto pessoaDto) throws UnicidadeCpfException, UnicidadeTelefoneException {
		Optional<Pessoa> optional = pessoaRepository.findByCpf(pessoaDto.cpf);

		if (optional.isPresent()) {
			throw new UnicidadeCpfException("Já existe pessoa cadastrada com o CPF " + pessoaDto.cpf);
		}

		TelefoneDto telefone = pessoaDto.telefones.get(0);

		optional = pessoaRepository.findByTelefoneDddAndTelefoneNumero(telefone.ddd, telefone.numero);

		if (optional.isPresent()) {
			throw new UnicidadeTelefoneException(
					"Já existe pessoa cadastrada com o Telefone (" + telefone.ddd + ")" + telefone.numero);
		}
	}

	private Telefone mapearTelefone(TelefoneDto t) {
		return new Telefone(t.ddd, t.numero);
	}

	private Endereco mapearEndereco(EnderecoDto endereco) {
		return new Endereco(endereco.logradouro, endereco.numero, endereco.complemento, endereco.bairro, endereco.cidade,
				endereco.estado);
	}

	@Override
	public Pessoa buscarPorTelefone(String ddd, String telefone) throws TelefoneNaoEncontradoException {
		Optional<Pessoa> optional = pessoaRepository.findByTelefoneDddAndTelefoneNumero(ddd, telefone);
		return optional.orElseThrow(
				() -> new TelefoneNaoEncontradoException("Não existe pessoa com o telefone (" + ddd + ")" + telefone));
	}
}
