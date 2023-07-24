package med.voll.api.paciente.dto.response;

import med.voll.api.paciente.Paciente;

public record DadosPacienteResponseDto(

        String nome,
        String email,
        String cpf
) {
    public DadosPacienteResponseDto(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
