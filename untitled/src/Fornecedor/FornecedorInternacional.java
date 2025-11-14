package Fornecedor;

public class FornecedorInternacional extends Fornecedor {
    private Double taxaImportacao;

    public FornecedorInternacional(String id, String nome, String cnpj, String email, String telefone, String endereco,
    String tipoProdutoFornecido, Double taxaImportacao) {
          super(id, nome, cnpj, email, telefone, endereco, tipoProdutoFornecido);
          this.taxaImportacao = taxaImportacao;
    }

    public Double gettaxaImportacao() {
        return taxaImportacao;
    }

    public void settaxaImportacao(Double taxaImportacao) {
        this.taxaImportacao = taxaImportacao;
    }

    public double calcularTaxaImportacao(double valorCompra) {
        double taxaImportacao = 0.25; // 25% de taxa alfandegária
        return valorCompra * taxaImportacao;
    }

    public boolean exigeDocumentacaoExtra(String paisOrigem) {
        return !paisOrigem.equalsIgnoreCase("Brasil") &&
               !paisOrigem.equalsIgnoreCase("Argentina") &&
               !paisOrigem.equalsIgnoreCase("Paraguai") &&
               !paisOrigem.equalsIgnoreCase("Uruguai");
    }

    public String gerarResumoFornecedor() {
        return "Fornecedor Internacional: " + getNome() + "\n" +
               "CNPJ: " + getCnpj() + "\n" +
               "Contato: " + getEmail() + " / " + getTelefone() + "\n" +
               "Endereço: " + getEndereco() + "\n" +
               "Produtos: " + getTipoProdutoFornecido();
    }

    public void enviarPedidoInternacional(String produto, int quantidade, int diasEntrega) {
        System.out.println("Pedido internacional enviado para " + getNome() + ": " +
                           quantidade + " unidades de " + produto +
                           ". Prazo estimado: " + diasEntrega + " dias.");
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo: Internacional");
    }

    @Override
    public void cadastrar() {
        super.cadastrar();
        System.out.println("Fornecedor internacional cadastrado. Taxa de importação estimada: " + calcularTaxaImportacao(1000.0));
    }
}