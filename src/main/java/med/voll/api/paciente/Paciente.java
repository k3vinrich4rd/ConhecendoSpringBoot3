package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;
import med.voll.api.paciente.dto.request.AtualizarDadosPacienteRequestDto;
import med.voll.api.paciente.dto.request.DadosPacientesRequestDto;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Paciente")
@Table(name = "pacientes")
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    String email;

    String telefone;

    String cpf;

    Boolean ativo;

    @Embedded
    Endereco endereco;

    public Paciente(DadosPacientesRequestDto dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.cpf = dto.cpf();
        this.ativo = true;
        this.endereco = new Endereco(dto.endereco());
    }

    public void atualizarInformacoesDoPaciente(AtualizarDadosPacienteRequestDto atualizarDadosPacienteRequestDto) {

        if (atualizarDadosPacienteRequestDto.nome() != null) {
            this.nome = atualizarDadosPacienteRequestDto.nome();
        }

        if (atualizarDadosPacienteRequestDto.telefone() != null) {
            this.telefone = atualizarDadosPacienteRequestDto.telefone();
        }

        if (atualizarDadosPacienteRequestDto.endereco() != null) {
            this.endereco.atualizarInformacoesEndereco(atualizarDadosPacienteRequestDto.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
