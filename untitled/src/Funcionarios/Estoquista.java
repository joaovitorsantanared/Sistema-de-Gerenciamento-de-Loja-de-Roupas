package Funcionarios;
import java.time.LocalDate;

public class Estoquista extends Funcionario{
    //ATRIBUTOS
    private int quantidadeProdutos;
    private String setor;


    //CONSTRUTOR
    public Estoquista(int id, String nome, String cpf, LocalDate dataNascimento, LocalDate dataContratacao, boolean ativo, String setor) {
        super(id, nome, cpf, dataNascimento, dataContratacao, 1400.0, "Estoquista", ativo);
        this.quantidadeProdutos = 0;
        this.setor = setor;
    }


    //CALCULO DO SALÁRIO
    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }


    //GETTER'S E SETTER'S
    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }


    //MÉTODO QUE ADICIONA PRODUTOS NO ESTOQUE
    public void adicionarProduto(int quantidade) {
        quantidadeProdutos += quantidade;
        System.out.println("Adicionados " + quantidade + " produtos ao setor " + setor);
    }


    //MÉTODO QUE REMOVE PRODUTOS DO SETOR
    public void removerProduto(int quantidade) {
        if (quantidade <= quantidadeProdutos) {
            quantidadeProdutos -= quantidade;
            System.out.println("Removidos " + quantidade + " produtos do setor " + setor);
        } else {
            System.out.println("Erro: estoque insuficiente no setor " + setor);
        }
    }


    //MÉTODO QUE CONSULTA O ESTOQUE DO SETOR
    public void consultarEstoque() {
        System.out.println("Estoque do setor " + setor + ": " + quantidadeProdutos + " produtos");
    }

}
