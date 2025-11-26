package Funcionarios;
import java.time.LocalDate;

public class Gerente extends Funcionario {
    //ATRIBUTOS
    private double bonus;


    //CONSTRUTOR
    public Gerente(int id, String nome, String cpf, LocalDate dataNascimento, LocalDate dataContratacao, boolean ativo, double bonus) {
        super(id, nome, cpf, dataNascimento, dataContratacao, 2.500, "Gerente", ativo);
        this.bonus = bonus;
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


    //MÉTODO PARA AVALIAR META MENSAL
    public void avaliarDesempenho(Vendedor vendedor, double metaMensal) {
        if (vendedor.getTotalVendas() >= metaMensal) {
            System.out.println("O vendedor " + vendedor.getNome() + " atingiu a meta!");
        } else {
            System.out.println("O vendedor " + vendedor.getNome() + " não atingiu a meta.");
        }
    }


}
