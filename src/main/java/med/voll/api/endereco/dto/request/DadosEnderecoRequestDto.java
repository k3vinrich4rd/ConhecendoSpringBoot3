package med.voll.api.endereco.dto.request;

public record DadosEnderecoRequestDto(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero) {

}
