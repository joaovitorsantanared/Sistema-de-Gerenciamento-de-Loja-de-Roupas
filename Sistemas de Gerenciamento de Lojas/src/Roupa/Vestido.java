package Roupa;
public class Vestido extends Roupas {
    private String comprimento;

    public String getComprimento() {
        return comprimento;
    }
    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }

    public Vestido(String id, String nome, double preco, String tamanho, String cor,
                   String marca, int quantidadeEstoque, String comprimento) {


        // Chamada correta à classe pai
        super(id, nome, preco, tamanho, cor, marca, quantidadeEstoque);


        // Inicializa o atributo específico
        this.comprimento = comprimento;
    }
}
