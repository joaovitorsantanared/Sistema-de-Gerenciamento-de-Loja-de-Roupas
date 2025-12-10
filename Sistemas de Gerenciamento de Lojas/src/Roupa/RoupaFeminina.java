package Roupa;


public class RoupaFeminina extends Roupas {


    private String tipoPeca; // Ex: "Saia Plissada", "Blusa Decote V", "Macacão"
    private String tipoTecido; // Ex: "Seda", "Linho", "Lycra"


    public RoupaFeminina(String id, String nome, double preco, String tamanho, String cor,
                         String marca, int quantidadeEstoque, String tipoPeca, String tipoTecido) {


        super(id, nome, preco, tamanho, cor, marca, quantidadeEstoque);


        this.tipoPeca = tipoPeca;
        this.tipoTecido = tipoTecido;
    }


    public String getTipoPeca() {
        return tipoPeca;
    }


    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }


    public String getTipoTecido() {
        return tipoTecido;
    }


    public void setTipoTecido(String tipoTecido) {
        this.tipoTecido = tipoTecido;
    }
}
