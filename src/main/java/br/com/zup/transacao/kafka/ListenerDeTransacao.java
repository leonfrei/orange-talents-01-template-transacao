package br.com.zup.transacao.kafka;

import br.com.zup.transacao.kafka.evento.EventoDeTransacao;
import br.com.zup.transacao.transacoes.Transacao;
import br.com.zup.transacao.transacoes.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ListenerDeTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println("======================================");
        System.out.println(eventoDeTransacao.toString());
        System.out.println("======================================");
        Transacao transacao = eventoDeTransacao.toModel();
        transacaoRepository.save(transacao);
    }

}
