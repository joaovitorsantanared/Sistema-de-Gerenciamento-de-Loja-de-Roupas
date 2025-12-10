package Funcionarios;
import java.time.LocalDate;

public class Vendedor extends Funcionario {
    //ATRIBUTOS
    private double comissao;
    private double totalVendas = 0;


    //CONSTRUTOR
    public Vendedor(int id, String nome, String cpf, LocalDate dataNascimento, LocalDate dataContratacao, boolean ativo, double comissao) {
        super(id, nome, cpf,dataNascimento, dataContratacao, 1500.0, "Vendedor", ativo);
        this.comissao = comissao;
    }


    //O VENDEDOR RECEBE SEU SALÁRIO DE ACORDO COM A COMISSÃO
    @Override
    public double calcularSalario() {
        return getSalarioBase() + comissao;
    }


    //GETTER'S E SETTER'S
    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    

    //MÉTODO PARA REGISTAR VENDA
    public void registrarVenda(double valor) {
        totalVendas += valor;
        System.out.println("Venda registrada no valor de R$ " + valor);
    }


    //GETTER'S E SETTER'S
    public double getTotalVendas() {
        return totalVendas;
    }
}
