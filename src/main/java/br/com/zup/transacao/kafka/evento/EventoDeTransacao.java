package br.com.zup.transacao.kafka.evento;

import br.com.zup.transacao.transacoes.Transacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

    @NotBlank
    private String id;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private EventoDeEstabelecimento estabelecimento;
    @NotNull
    private EventoDeCartao cartao;
    @NotNull
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EventoDeEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public EventoDeCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(id, valor, estabelecimento.toModel(), cartao.toModel(), efetivadaEm);
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento.toString() +
                ", cartao=" + cartao.toString() +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
