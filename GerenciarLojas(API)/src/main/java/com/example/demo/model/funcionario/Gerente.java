package com.example.demo.model.funcionario;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_GERENTE")
public class Gerente extends Funcionario{
    //ATRIBUTOS
    @Column(nullable = false)
    private double bonus;

    //CONSTRUTOR
    public Gerente(String nome, String cpf, LocalDate dataNascimento, LocalDate dataContratacao, boolean ativo, double bonus) {
        super(nome, cpf, dataNascimento, dataContratacao, 2500.0, "Gerente", ativo);
        this.bonus = bonus;
    }

    public Gerente() {

    }

    //O GERENTE RECEBE SEU SALÁRIO DE ACORDO COM O BÔNUS
    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonus;
    }

    //GETTER'S E SETTER'S
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


}
