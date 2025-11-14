package Fornecedor;

public class FornecedorTecido extends Fornecedor {
    private Double gramatura;
    public FornecedorTecido(String id, String nome, String cnpj, String email, String telefone, String endereco,
    String tipoProdutoFornecido, Double gramatura) {
          super(id, nome, cnpj, email, telefone, endereco, tipoProdutoFornecido);
        this.gramatura = gramatura;
    }
    public Double getgramatuta() {
        return gramatura;
    }

    public void setgramatura(Double gramatura) {
        this.gramatura = gramatura;
    }

    public boolean verificarTecidoSustentavel(String tipoTecido) {
        return tipoTecido.equalsIgnoreCase("algodão orgânico") ||
               tipoTecido.equalsIgnoreCase("linho") ||
               tipoTecido.equalsIgnoreCase("bambu");
    }

    public double calcularCustoPorMetro(double valorLote, int metros) {
        if (metros <= 0) return 0;
        return valorLote / metros;
    }

    public void registrarLoteTecido(String tipoTecido, int metrosRecebidos) {
    System.out.println("Lote registrado: " + metrosRecebidos + " metros de " + tipoTecido +
          " recebidos de " + getNome());
    }

    public String gerarEtiquetaOrigem(String tipoTecido, String paisOrigem) {
        return "Tecido: " + tipoTecido + " | Fornecedor: " + getNome() + " | Origem: " + paisOrigem;
    }

     @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Especialidade: Tecidos");
    }

    @Override
    public void cadastrar() {
        super.cadastrar();
        System.out.println("Fornecedor de tecidos cadastrado. Verifique tecidos sustentáveis!");
    }
}