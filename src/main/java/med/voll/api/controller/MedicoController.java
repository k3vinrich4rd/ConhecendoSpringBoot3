package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.Medico;
import med.voll.api.medico.dto.request.AtualizarDadosCadastroMedicoRequestDto;
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

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedicoRequestDto dadosCadastroMedicoRequestDto) {
        medicoRepository.save(new Medico(dadosCadastroMedicoRequestDto));

    }

    @GetMapping
    //Pageable padrão, mas é possível sobrescrever fazendo a busca
    public Page<DadosCadastroMedicoResponseDto> buscarMedicos(@PageableDefault(size = 10, sort = {"nome"}, page = 0) Pageable paginacao) {
        return medicoRepository.findAll(paginacao)
                .map(DadosCadastroMedicoResponseDto::new);
    }

    @GetMapping(path = "/active")
    //Pageable padrão, mas é possível sobrescrever fazendo a busca
    public Page<DadosCadastroMedicoResponseDto> buscarMedicosAtivo(@PageableDefault(size = 10, sort = {"nome"}, page = 0) Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao)
                .map(DadosCadastroMedicoResponseDto::new);
    }

    @PutMapping()
    @Transactional
    public void atualizarCadastroDeMedico(@RequestBody @Valid AtualizarDadosCadastroMedicoRequestDto atualizarDadosCadastroMedicoRequestDto) {
        var medico = medicoRepository.getReferenceById(atualizarDadosCadastroMedicoRequestDto.id());
        medico.atualizarInformacoesDoMedico(atualizarDadosCadastroMedicoRequestDto);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }

    @DeleteMapping(path = "exclusao-logica/{id}")
    @Transactional
    public void exclusaoLogica(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
