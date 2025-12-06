
    package com.example.demo.dtos;

    import jakarta.validation.constraints.*;

    public record ClienteNovoRecordDto(
            @NotBlank String nome,
            @NotBlank @Size(min = 11, max = 11) String cpf,
            @Email @NotBlank String email,
            @NotBlank String numero,
            @NotNull int pontuacaoInicial,
            @NotNull boolean primeiraCompra) {

    }

