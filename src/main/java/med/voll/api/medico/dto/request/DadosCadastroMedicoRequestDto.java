package med.voll.api.medico.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.dto.request.DadosEnderecoRequestDto;
import med.voll.api.enums.EspecialidadeEnum;

public record DadosCadastroMedicoRequestDto(
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        EspecialidadeEnum especialidade,

        @NotNull
        @Valid
        DadosEnderecoRequestDto endereco) {
}
