package Roupa;


public class Calca extends Roupas{
    private String modeloCalca;


    public String getModeloCalca() {
        return modeloCalca;
    }


    public void setModeloCalca(String modeloCalca) {
        this.modeloCalca = modeloCalca;
    }


    public Calca(String id, String nome, double preco, String tamanho, String cor,
                 String marca, int quantidadeEstoque, String modeloCalca) {
        super(id, nome, preco, tamanho, cor, marca, quantidadeEstoque);


        this.modeloCalca = modeloCalca;
    }
}
