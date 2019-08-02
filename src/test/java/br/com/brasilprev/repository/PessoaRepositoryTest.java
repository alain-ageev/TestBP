package br.com.brasilprev.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class PessoaRepositoryTest {

	@Test
	public void deve_procurar_pessoa_pelo_cpf() {
	}

	@Test
	public void deve_encontrar_pessoa_cpf_inexistente() {
	}

	@Test
	public void deve_encontrar_pessoa_pelo_ddd_e_numero_de_telefone() {
	}

	@Test
	public void nao_deve_encontrar_pessoa_cujo_ddd_e_telefone_nao_estejam_cadastradados() {
	}

	@Test
	public void deve_filtrar_pessoas_por_parte_do_nome() {
	}

	@Test
	public void deve_filtrar_pessoas_por_parte_do_cpf() {
	}

	@Test
	public void deve_filtrar_pessoas_por_filtro_composto() {
	}

	@Test
	public void deve_filtrar_pessoas_pelo_ddd_do_telefone() {
	}

	@Test
	public void deve_filtrar_pessoas_pelo_numero_do_telefone() {
	}
}
