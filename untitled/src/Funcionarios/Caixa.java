package Funcionarios;
import java.time.LocalDate;

public class Caixa extends Funcionario {
    //ATRIBUTOS
    private double totalDinheiroCaixa;
    private int numeroCaixa;


    //CONSTRUTOR
    public Caixa(int id, String nome, String cpf, LocalDate dataNascimento, LocalDate dataContratacao, boolean ativo,  int numeroCaixa) {
        super(id, nome, cpf, dataNascimento, dataContratacao, 1.400, "Caixa", ativo);
        this.totalDinheiroCaixa = 0;
    }


    //CALCULO DO SALÁRIO
    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }


    //GETTER'S E SETTER'S
    public double getTotalDinheiroCaixa() {
        return totalDinheiroCaixa;
    }
    public int getNumeroCaixa() {
        return numeroCaixa;
    }
    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }


    //MÉTODO PARA REGISTRAR PAGAMENTO NO CAIXA
    public void registrarPagamento(double valor) {
        totalDinheiroCaixa += valor;
        System.out.println("Pagamento de R$ " + valor + " registrado no caixa " + numeroCaixa);
    }


    //MÉTODO PARA RETIRAR DINHEIRO (SANGRIA)
    public void realizarSangria(double valor) {
        if (valor <= totalDinheiroCaixa) {
            totalDinheiroCaixa -= valor;
            System.out.println("Sangria de R$ " + valor + " realizada no caixa " + numeroCaixa);
        } else {
            System.out.println("Erro: saldo insuficiente para sangria!");
        }
    }


    //MÉTODO PARA FECHAR O CAIXA
    public void fecharCaixa() {
        System.out.println("Total em caixa " + numeroCaixa + ": R$ " + totalDinheiroCaixa);
    }
}
