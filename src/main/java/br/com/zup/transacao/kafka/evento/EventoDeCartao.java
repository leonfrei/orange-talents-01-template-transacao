package br.com.zup.transacao.kafka.evento;

import br.com.zup.transacao.transacoes.Cartao;

public class EventoDeCartao {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }

    @Override
    public String toString() {
        return "EventoDeCartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
