package br.com.casavaticano.jamworks.entidade;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.casavaticano.jamworks.exceptions.IdadeInvalidaException;
import br.com.casavaticano.jamworks.exceptions.NomeInvalidoException;
import br.com.casavaticano.jamworks.exceptions.SexoInvalidaException;

public class PessoaTest {
	
	//SUT - Stub under test
	private Pessoa sut;
	
	@Before
	public void init() {
		sut = new Pessoa();
	}
	
	@Test(expected=NomeInvalidoException.class)
	public void nome_nao_pode_ser_nulo_ou_vazio() throws Exception{
		sut.setNome("");	
	}
	
	@Test(expected=IdadeInvalidaException.class)
	public void pessoa_nao_pode_ser_menor_de_idade() throws Exception{
		sut.setIdade(17);
	}
	
	@Test(expected=SexoInvalidaException.class)
	public void sexo_deve_ser_m_ou_f() throws Exception{
		sut.setSexo("M");
		
	}
	

}
