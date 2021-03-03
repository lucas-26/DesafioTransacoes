package br.com.zup.Transacao.persist;

import br.com.zup.Transacao.model.Transacao;
import br.com.zup.Transacao.persist.entity.Cartao;
import br.com.zup.Transacao.persist.entity.Estabelecimento;
import br.com.zup.Transacao.persist.repository.TransacaoRepository;

public class InserirTransacao {

	private TransacaoRepository transacaoRepository;
	
	public InserirTransacao() {}

	public InserirTransacao(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	public void InserirTransacaoNoBanco(Transacao transacao) {

		Cartao cart = new Cartao(transacao.getCartao().getId(), transacao.getCartao().getEmail());

		Estabelecimento estab = new Estabelecimento(transacao.getEstabelecimento().getNome(),
				transacao.getEstabelecimento().getCidade(), transacao.getEstabelecimento().getEndereco());

		br.com.zup.Transacao.persist.entity.Transacao persist = new br.com.zup.Transacao.persist.entity.Transacao(
				transacao.getId(), transacao.getValor(), estab, cart, transacao.getEfetivadaEm());

		transacaoRepository.save(persist);
	}
}
