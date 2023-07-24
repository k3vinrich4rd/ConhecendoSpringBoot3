package med.voll.api.controller;

import med.voll.api.medico.Medico;
import med.voll.api.medico.dto.request.DadosCadastroMedicoRequestDto;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    @PostMapping
    public void cadastrarMedico(@RequestBody DadosCadastroMedicoRequestDto dadosCadastroMedicoRequestDto) {
       medicoRepository.save(new Medico(dadosCadastroMedicoRequestDto));

    }
}
