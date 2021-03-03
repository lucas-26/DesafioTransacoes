package br.com.zup.Transacao.persist.entity;

public class Cartao {

	private String idCartao;
	private String email;

	@Deprecated
	public Cartao() {
	}

	public Cartao(String idCartao, String email) {
		super();
		this.idCartao = idCartao;
		this.email = email;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public String getEmail() {
		return email;
	}
}
