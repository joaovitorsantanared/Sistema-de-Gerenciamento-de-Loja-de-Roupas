package Roupa;

public class RoupaMasculina extends Roupas {
    private String tipoPeca; // Ex: "Bermuda Jeans", "Camisa Social", "Moletom com Capuz"
    private String material; // Útil para qualquer roupa


    // Getters e Setters
    public String getTipoPeca() {
        return tipoPeca;
    }


    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }


    public String getMaterial() {
        return material;
    }


    public void setMaterial(String material) {
        this.material = material;
    }


    public RoupaMasculina(String id, String nome, double preco, String tamanho, String cor,
                          String marca, int quantidadeEstoque, String tipoPeca, String material) {


        super(id, nome, preco, tamanho, cor, marca, quantidadeEstoque);


        this.tipoPeca = tipoPeca;
        this.material = material;
    }
}
