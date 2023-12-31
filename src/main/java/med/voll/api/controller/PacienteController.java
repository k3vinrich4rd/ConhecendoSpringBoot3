package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.dto.request.AtualizarDadosPacienteRequestDto;
import med.voll.api.paciente.dto.request.DadosPacientesRequestDto;
import med.voll.api.paciente.dto.response.DadosPacienteResponseDto;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Transactional
    @PostMapping
    public void cadastrarPaciente(@RequestBody @Valid DadosPacientesRequestDto dto) {
        pacienteRepository.save(new Paciente(dto));
    }

    @GetMapping
    public Page<DadosPacienteResponseDto> buscarPaciente(@PageableDefault(sort = {"nome"}, size = 9, page = 0) Pageable paginacao) {
        return pacienteRepository.findAll(paginacao)
                .map(DadosPacienteResponseDto::new);
    }

    @GetMapping(path = "/active")
    public Page<DadosPacienteResponseDto> buscarPacientesAtivo(@PageableDefault(size = 10, sort = {"nome"}, page = 0) Pageable pageable) {
        return pacienteRepository.findAllByAtivoTrue(pageable)
                .map(DadosPacienteResponseDto::new);
    }

    @PutMapping
    @Transactional
    public void atualizarPaciente(@RequestBody @Valid AtualizarDadosPacienteRequestDto atualizarDadosPacienteRequestDto) {
        var paciente = pacienteRepository.getReferenceById(atualizarDadosPacienteRequestDto.id());
        paciente.atualizarInformacoesDoPaciente(atualizarDadosPacienteRequestDto);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public void deletarPaciente(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
    }

    @DeleteMapping(path = "/exclusao-logica/{id}")
    @Transactional
    public void exclusaoLogica(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
