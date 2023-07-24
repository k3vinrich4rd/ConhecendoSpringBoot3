package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;
import med.voll.api.enums.EspecialidadeEnum;
import med.voll.api.medico.dto.request.DadosCadastroMedicoRequestDto;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode(of = "id") //Para gerar o equals e hasCode somente conforme o id
@Getter
@Setter
@Entity(name = "Medico")
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100, nullable = false)
    String nome;

    @Column(length = 70, nullable = false)
    String email;

    @Column(length = 25, nullable = false)
    String crm;

    @Enumerated(EnumType.STRING)
    EspecialidadeEnum especialidade;

    @Embedded
    @Column(length = 70, nullable = false)
    Endereco endereco;


    public Medico(DadosCadastroMedicoRequestDto dadosCadastroMedicoRequestDto) {
        this.nome = dadosCadastroMedicoRequestDto.nome();
        this.email = dadosCadastroMedicoRequestDto.email();
        this.crm = dadosCadastroMedicoRequestDto.crm();
        this.especialidade = dadosCadastroMedicoRequestDto.especialidade();
        this.endereco = new Endereco(dadosCadastroMedicoRequestDto.endereco());
    }
}
