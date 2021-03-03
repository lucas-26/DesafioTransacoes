package br.com.zup.Transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import br.com.zup.Transacao.persist.InserirTransacao;
import br.com.zup.Transacao.persist.entity.Transacao;
import br.com.zup.Transacao.persist.repository.TransacaoRepository;
import br.com.zup.Transacao.response.TransacaoResponse;

@RestController
@RequestMapping("/Transacao")
public class TransacaoController {

	@Autowired
	TransacaoRepository transacaoRepository;

	InserirTransacao inserirTransacao = new InserirTransacao(transacaoRepository);

	
	@GetMapping("/buscaTransacao/{idCartao}")
	private ResponseEntity<List<TransacaoResponse>> getTransacao(@PathVariable("idCartao") String id) {
		List<Transacao> transacao = transacaoRepository.findTop10TransacaoBycartao_idCartao(id);
		List<TransacaoResponse> ultimasTransacoes = new ArrayList<TransacaoResponse>();
		transacao.forEach(mytransacao -> {
			TransacaoResponse novaTransacao = new TransacaoResponse(mytransacao.getEfetivadaEm(),
					mytransacao.getEstabelecimento().getNome(), mytransacao.getEstabelecimento().getCidade(),
					mytransacao.getEstabelecimento().getEndereco(), mytransacao.getValor());
			ultimasTransacoes.add(novaTransacao);
		});
	return	ResponseEntity.ok().body(ultimasTransacoes);
	}
}
