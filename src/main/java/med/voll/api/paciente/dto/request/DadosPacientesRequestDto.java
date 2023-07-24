package med.voll.api.paciente.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.dto.request.DadosEnderecoRequestDto;
import org.hibernate.validator.constraints.br.CPF;

public record DadosPacientesRequestDto(
        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        //@Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        @CPF
        String cpf,

        @NotNull
        @Valid
        DadosEnderecoRequestDto endereco) {

}
