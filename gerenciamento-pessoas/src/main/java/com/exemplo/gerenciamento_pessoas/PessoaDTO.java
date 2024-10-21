package com.exemplo.gerenciamento.pessoas.dto;

import lombok.Data;

@Data
public class PessoaDTO {
    private String nome;
    private String cpf;
    private int idade;
}