package med.voll.api.medico.dto.request;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.dto.request.DadosEnderecoRequestDto;

public record AtualizarDadosCadastroMedicoRequestDto(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoRequestDto endereco
) {

}
