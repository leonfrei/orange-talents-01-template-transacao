package br.com.zup.transacao.transacoes;

public class CartaoResponse {

    private String numero;
    private String email;

    public CartaoResponse(Cartao cartao) {
        this.numero = cartao.getNumero();
        this.email = cartao.getEmail();
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }
}
