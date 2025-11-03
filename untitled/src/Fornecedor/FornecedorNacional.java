package Fornecedor;

public class FornecedorNacional extends Fornecedor {

    public FornecedorNacional(String id, String nome, String cnpj, String email, String telefone, String endereco,
    String tipoProdutoFornecido) {
        super(id, nome, cnpj, email, telefone, endereco, tipoProdutoFornecido);
    }

    public boolean validarCNPJ() {
        return getCnpj() != null && getCnpj().length() == 18;
    }

    public double calcularImpostoNacional(double valorCompra) {
        double taxaImposto = 0.12; // 12% de imposto nacional
        return valorCompra * taxaImposto;
    }

    
    public String gerarResumoFornecedor() {
        return "Fornecedor Nacional: " + getNome() + "\n" +
               "CNPJ: " + getCnpj() + "\n" +
               "Contato: " + getEmail() + " / " + getTelefone() + "\n" +
               "Produtos: " + getTipoProdutoFornecido();
    }

    public void enviarPedido(String produto, int quantidade) {
        System.out.println("Pedido enviado para " + getNome() + ": " + quantidade + " unidades de " + produto);
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo: Nacional");
        System.out.println("CNPJ Válido: " + (validarCNPJ() ? "Sim" : "Não"));
    }

    @Override
    public void cadastrar() {
        super.cadastrar();
        System.out.println("Fornecedor nacional cadastrado. Imposto estimado: " + calcularImpostoNacional(1000.0));
    }
}
