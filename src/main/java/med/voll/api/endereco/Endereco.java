package med.voll.api.endereco;

import lombok.*;
import med.voll.api.endereco.dto.request.DadosEnderecoRequestDto;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Endereco {

    private String logradouro;

    private String bairro;

    private String cep;

    private String cidade;

    private String uf;

    private String complemento;

    private String numero;

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


