package med.voll.api.paciente.dto.request;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.dto.request.DadosEnderecoRequestDto;

public record AtualizarDadosPacienteRequestDto(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoRequestDto endereco
) {

}
