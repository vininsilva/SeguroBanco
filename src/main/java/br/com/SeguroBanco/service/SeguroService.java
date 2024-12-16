package br.com.SeguroBanco.service;

import br.com.SeguroBanco.model.Seguro;

import java.util.List;

public interface SeguroService {

    List<Seguro> obterSimulacao(String cpf);

}
