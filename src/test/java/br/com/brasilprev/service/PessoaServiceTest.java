package br.com.brasilprev.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PessoaServiceTest {

	@Before
	public void setUp() {
	}

	@Test
	public void deve_salvar_pessoa_no_repositorio() throws Exception {
	}

	@Test
	public void nao_deve_salvar_duas_pessoas_com_o_mesmo_cpf() throws Exception {
	}

	@Test
	public void nao_deve_salvar_duas_pessoas_com_o_mesmo_telefone() throws Exception {
	}
	
	@Test
	public void deve_retornar_execao_de_nao_encontrado_quando_nao_existir_pessoa_com_o_ddd_e_numero_de_telefone() throws Exception {
	}
	
	@Test
    public void deve_retornar_dados_do_telefone_dentro_da_excecao_de_telefone_nao_encontrado_exception() throws Exception {
    }
	
	@Test
	public void deve_procurar_pessoa_pelo_ddd_e_numero_do_telefone() throws Exception {
	}
}
