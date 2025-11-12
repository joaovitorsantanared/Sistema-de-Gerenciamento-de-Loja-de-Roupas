package Cliente;

public class ClienteFidelidade extends Cliente {
        private int pontosFidelidade;
        private int nivelFideldiade;


    public ClienteFidelidade(String id, String nome, String cpf, String email, String numero) {
        super(id, nome, cpf, email, numero);
    }

    public void acumularPontos(double valorCompra) {
        int pontosGanhos = (int) (valorCompra / 10);
        pontosFidelidade += pontosGanhos;
        System.out.println("Você ganhou " + pontosGanhos + " pontos!");
    }

    public void desconto(double ValorCompra) {
        double valorDesconto = ValorCompra * 0.3;
        double valorfinal = ValorCompra - valorDesconto;

        System.out.println("O cliente " + getNome() + " obteve um desconto de 30% com sucesso!\n");
        System.out.println("VALOR FINAL DA COMPRA: " + valorfinal);
    }
    public void recomendarProdutos(){
        System.out.println("Com base nos seus gostos, recomendamos a você: Calca cargo Streetwear\n");
    }

    public void avaliacao(int nota){
        System.out.println("Por favor avalie a nossa loja!");
        if(nota >=5){
            System.out.println("Agradecemos pela sua avaliação!");

        }else{
            System.out.println("Poxa, tentaremos melhorar na próxima\n");

        }
    }


}
