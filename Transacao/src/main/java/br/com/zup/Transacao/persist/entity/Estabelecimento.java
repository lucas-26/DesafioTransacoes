package br.com.zup.Transacao.persist.entity;

public class Estabelecimento {

	private String nome;
	private String cidade;
	private String endereco;
	
	@Deprecated
	public Estabelecimento() {}

	public Estabelecimento(String nome, String cidade, String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

}
