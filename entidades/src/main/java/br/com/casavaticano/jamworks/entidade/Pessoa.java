package br.com.casavaticano.jamworks.entidade;

import br.com.casavaticano.jamworks.exceptions.IdadeInvalidaException;
import br.com.casavaticano.jamworks.exceptions.NomeInvalidoException;
import br.com.casavaticano.jamworks.exceptions.SexoInvalidaException;

public class Pessoa {

	private String nome;
	private Integer idade;
	private String sexo;
	public void setNome(String string) throws NomeInvalidoException {
		if(nome == null || "".equals(nome.trim())) {
			throw new NomeInvalidoException();
		}		
		this.nome = nome;		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setIdade(int idade) throws IdadeInvalidaException {
		if(idade < 18) {
			throw new IdadeInvalidaException();
		}
		
		this.idade = idade;	
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	
	public void setSexo(String sexo) throws SexoInvalidaException {
		if("m".equals(sexo.toLowerCase())
				|| "f".equals(sexo.toLowerCase())) {
			throw new SexoInvalidaException();
		}
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}

}
