package com.example.demo.dtos;

import jakarta.validation.constraints.*;

public record ClienteFidelidadeRecordDto(
        @NotBlank String nome,
        @NotBlank @Size(min = 11, max = 11) String cpf,
        @Email @NotBlank String email,
        @NotBlank String numero,
        @NotNull @Min(0) int pontosFidelidade,
        @NotNull @Min(0) @Max(3) int nivelFidelidade
) {}
