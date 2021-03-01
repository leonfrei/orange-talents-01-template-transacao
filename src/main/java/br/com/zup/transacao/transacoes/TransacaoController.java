package br.com.zup.transacao.transacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private CartaoRepository cartaoRepository;

    @Transactional
    @PostMapping("/cartao/$idCartao/consulta")
    public ResponseEntity<List<TransacaoResponse>> consultarComprasRecentes(@PathVariable("idCartao") Long idCartao){
        Optional<Cartao> possivelCartao = cartaoRepository.findById(idCartao);
        if (possivelCartao.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<TransacaoResponse> transacoes = transacaoRepository.consultarUltimasCompras(possivelCartao.get().getId());
        return ResponseEntity.ok(transacoes);
    }
}
