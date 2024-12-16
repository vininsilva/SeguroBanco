package br.com.SeguroBanco.service.impl;

import br.com.CadastroBanco.model.Pessoa;
import br.com.SeguroBanco.model.Seguro;
import br.com.SeguroBanco.repository.SeguroRepository;
import br.com.SeguroBanco.configuration.CadastroWebClient;
import br.com.SeguroBanco.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SeguroServiceImpl implements SeguroService {

    @Autowired
    CadastroWebClient cadastroWebClient;

    @Autowired
    SeguroRepository seguroRepository;

    public List<Seguro> obterSimulacao(String cpf) {
        Pessoa pessoaCadastrada = cadastroWebClient.consultarCadastro(cpf);
        if (pessoaCadastrada == null) {
            throw new RuntimeException("Pessoa não cadastrada");
        }

        return seguroRepository.findByCategoriaIn(Arrays.asList("bronze", "prata", "ouro"));
    }
}
