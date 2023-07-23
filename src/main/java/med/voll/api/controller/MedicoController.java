package med.voll.api.controller;

import med.voll.api.medico.dto.request.DadosCadastroMedicoRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/medicos")
public class MedicoController {

    @PostMapping
    public void cadastrarMedico(@RequestBody DadosCadastroMedicoRequestDto dadosCadastroMedicoRequestDto) {
        System.out.println(dadosCadastroMedicoRequestDto);
    }
}
