package br.com.zup.Transacao.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {
	
	private LocalDateTime efetivada_em;
	private String nome;
	private String	cidade;
	private String	endereco;
	private BigDecimal valor;
	
	public TransacaoResponse(LocalDateTime efetivada_em, String nome, String cidade, String endereco,
			BigDecimal valor) {
		super();
		this.efetivada_em = efetivada_em;
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
		this.valor = valor;
	}
	
	public LocalDateTime getEfetivada_em() {
		return efetivada_em;
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
	public BigDecimal getValor() {
		return valor;
	}
	
	

}
