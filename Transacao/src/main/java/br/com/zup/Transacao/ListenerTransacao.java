package br.com.zup.Transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.Transacao.model.Transacao;
import br.com.zup.Transacao.persist.InserirTransacao;
import br.com.zup.Transacao.persist.repository.TransacaoRepository;

@Component
public class ListenerTransacao {

	@Autowired
	TransacaoRepository transacaoRep; 
	
	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void ouvir(Transacao transacao) {
		InserirTransacao inserirTransacao = new InserirTransacao(transacaoRep);
		inserirTransacao.InserirTransacaoNoBanco(transacao);
	}
}
