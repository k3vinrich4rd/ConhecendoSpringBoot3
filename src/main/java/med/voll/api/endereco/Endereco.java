package med.voll.api.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.endereco.dto.request.DadosEnderecoRequestDto;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Endereco {

    @Column(length = 70, nullable = false)
    String logradouro;

    @Column(length = 70, nullable = false)
    String bairro;

    @Column(length = 70, nullable = false)
    String cep;

    @Column(length = 70, nullable = false)
    String cidade;

    @Column(length = 70, nullable = false)
    String uf;

    @Column(length = 70, nullable = false)
    String complemento;

    @Column(length = 70, nullable = false)
    String numero;

    public Endereco(DadosEnderecoRequestDto enderecoRequestDto) {
        this.logradouro = enderecoRequestDto.logradouro();
        this.bairro = enderecoRequestDto.bairro();
        this.cep = enderecoRequestDto.cep();
        this.cidade = enderecoRequestDto.cidade();
        this.uf = enderecoRequestDto.uf();
        this.complemento = enderecoRequestDto.complemento();
        this.numero = enderecoRequestDto.numero();

    }
}


