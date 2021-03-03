package br.com.zup.Transacao.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.Transacao.persist.entity.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	List<Transacao> findTop10TransacaoBycartao_idCartao(String idcartao);

}


