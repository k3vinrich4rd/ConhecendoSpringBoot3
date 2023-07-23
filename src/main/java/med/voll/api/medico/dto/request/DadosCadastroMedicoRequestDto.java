package med.voll.api.medico.dto.request;

import med.voll.api.endereco.dto.request.DadosEnderecoRequestDto;
import med.voll.api.enums.EspecialidadeEnum;

public record DadosCadastroMedicoRequestDto(
        String nome,
        String email,
        String crm,
        EspecialidadeEnum especialidade,
        //String telefone,
        DadosEnderecoRequestDto endereco) {
}
