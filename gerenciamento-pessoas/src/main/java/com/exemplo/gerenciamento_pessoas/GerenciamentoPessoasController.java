package com.exemplo.gerenciamento.pessoas.controller;

import com.exemplo.gerenciamento.pessoas.dto.PessoaDTO;
import com.exemplo.gerenciamento.pessoas.model.Pessoa;
import com.exemplo.gerenciamento.pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;


    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(pessoaDTO.getNome());
        novaPessoa.setCpf(pessoaDTO.getCpf());
        novaPessoa.setIdade(pessoaDTO.getIdade());

        Pessoa pessoaSalva = pessoaRepository.save(novaPessoa);
        return ResponseEntity.ok(pessoaSalva);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
