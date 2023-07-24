package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.Medico;
import med.voll.api.medico.dto.request.DadosCadastroMedicoRequestDto;
import med.voll.api.medico.dto.response.DadosCadastroMedicoResponseDto;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    @PostMapping
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedicoRequestDto dadosCadastroMedicoRequestDto) {
        medicoRepository.save(new Medico(dadosCadastroMedicoRequestDto));

    }

    @GetMapping
    public List<DadosCadastroMedicoResponseDto> buscarMedicos() {
        return medicoRepository.findAll()
                .stream()
                .map(DadosCadastroMedicoResponseDto::new).toList();
    }
}
