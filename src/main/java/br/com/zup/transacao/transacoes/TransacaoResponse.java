package br.com.zup.transacao.transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private CartaoResponse cartao;
    private EstabelecimentoResponse estabelecimento;

    public TransacaoResponse(Transacao transacao) {
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.cartao = new CartaoResponse(transacao.getCartao());
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }
}
