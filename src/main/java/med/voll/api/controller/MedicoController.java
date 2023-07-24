package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.Medico;
import med.voll.api.medico.dto.request.DadosCadastroMedicoRequestDto;
import med.voll.api.medico.dto.response.DadosCadastroMedicoResponseDto;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    //Pageable padrão, mas é possível sobrescrever fazendo a busca
    public Page<DadosCadastroMedicoResponseDto> buscarMedicos(@PageableDefault(size = 10, sort = {"nome"}, page = 0) Pageable paginacao) {
        return medicoRepository.findAll(paginacao)
                .map(DadosCadastroMedicoResponseDto::new);
    }
}
