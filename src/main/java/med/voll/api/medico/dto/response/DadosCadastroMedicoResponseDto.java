package med.voll.api.medico.dto.response;

import med.voll.api.enums.EspecialidadeEnum;
import med.voll.api.medico.Medico;

public record DadosCadastroMedicoResponseDto(

        String nome,
        String email,
        String crm,
        EspecialidadeEnum especialidade
) {
    public DadosCadastroMedicoResponseDto(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
