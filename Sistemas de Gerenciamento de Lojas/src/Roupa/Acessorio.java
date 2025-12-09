package Roupa;


public class Acessorio extends Roupas {


    private String tipoAcessorio; // Ex: "Anel", "Óculos", "Pulseira"
    private String material;      // Ex: "Prata 925", "Plástico", "Algodão"



    public String getTipoAcessorio() {
        return tipoAcessorio;
    }


    public void setTipoAcessorio(String tipoAcessorio) {
        this.tipoAcessorio = tipoAcessorio;
    }


    public String getMaterial() {
        return material;
    }


    public void setMaterial(String material) {
        this.material = material;
    }




    public Acessorio(String id, String nome, double preco, String tamanho, String cor,
                     String marca, int quantidadeEstoque, String tipoAcessorio, String material) {




        super(id, nome, preco, tamanho, cor, marca, quantidadeEstoque);


        this.tipoAcessorio = tipoAcessorio;
        this.material = material;
    }
}
