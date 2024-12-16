package br.com.SeguroBanco.controller;

import br.com.CadastroBanco.model.Pessoa;
import br.com.CadastroBanco.service.CadastroService;
import br.com.SeguroBanco.model.Seguro;
import br.com.SeguroBanco.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/seguro")
public class SeguroController {

    @Autowired
    public SeguroService seguroService;

    @GetMapping("/simular/{cpf}")
    public ResponseEntity<List<Seguro>> simularSeguro(@PathVariable String cpf) {
        List<Seguro> seguros = seguroService.obterSimulacao(cpf);
        return ResponseEntity.ok(seguros);
    }
}
