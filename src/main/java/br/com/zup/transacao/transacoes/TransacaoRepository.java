package br.com.zup.transacao.transacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    @Query(value = "SELECT * FROM transacao WHERE transacao.cartao_id = ?1 ORDER BY transacao.efetivadaEm DESC LIMIT 10", nativeQuery = true)
    List<TransacaoResponse> consultarUltimasCompras(Long id);
}
