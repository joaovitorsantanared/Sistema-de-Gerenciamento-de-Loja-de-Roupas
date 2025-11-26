package Roupa;


public class Camiseta extends Roupas{
    private String tipoGola;


    public Camiseta(String id, String nome, double preco, String tamanho, String cor,
                    String marca, int quantidadeEstoque, String tipoGola) {


        // Chama o construtor da classe pai (Roupa)
        super(id, nome, preco, tamanho, cor, marca, quantidadeEstoque);


        // Inicializa o atributo específico
        this.tipoGola = tipoGola;
    }


    public String getTipoGola() {
        return tipoGola;
    }


    public void setTipoGola(String tipoGola) {
        this.tipoGola = tipoGola;
    }


    @Override
    public void exibirDetalhes() {


        super.exibirDetalhes();


        System.out.println("Detalhe Específico: Gola " + tipoGola);
    }
}
