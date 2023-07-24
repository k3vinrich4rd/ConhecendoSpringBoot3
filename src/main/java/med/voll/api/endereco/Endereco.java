package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import med.voll.api.endereco.dto.request.DadosEnderecoRequestDto;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Endereco {

    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    //opcional
    private String complemento;
    //opcional
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

    public void atualizarInformacoesEndereco(DadosEnderecoRequestDto dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }

        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }

        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }

        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }

        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
    }
}


