package br.com.zup.transacao.transacoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String numero;
    @NotBlank
    @Email
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(@NotBlank String numero, @NotBlank @Email String email) {
        this.numero = numero;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }
}
