package br.com.SeguroBanco.configuration;

import br.com.CadastroBanco.model.Pessoa;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CadastroService {

    private final WebClient webClient;

    public CadastroService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/api/cadastro").build();
    }

    public Pessoa consultarCadastro(String cpf) {
        return this.webClient.get()
                .uri("/cpf/{cpf}", cpf)
                .retrieve()
                .bodyToMono(Pessoa.class)
                .block();
    }
}
