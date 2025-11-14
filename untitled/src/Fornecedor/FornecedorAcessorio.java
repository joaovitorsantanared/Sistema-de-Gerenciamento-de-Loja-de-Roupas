package Fornecedor;

public class FornecedorAcessorio extends Fornecedor {
    private String material;

    public FornecedorAcessorio(String id, String nome, String cnpj, String email, String telefone, String endereco,
    String tipoProdutoFornecido, String material) {
          super(id, nome, cnpj, email, telefone, endereco, tipoProdutoFornecido);
    }
    public String getmaterial() {
        return material;
    }

    public void setmaterial(String material) {
        this.material = material;
    }

    public boolean verificarMaterialReciclavel(String tipoMaterial) {
        return tipoMaterial.equalsIgnoreCase("plástico reciclado") ||
               tipoMaterial.equalsIgnoreCase("metal reaproveitado") ||
               tipoMaterial.equalsIgnoreCase("tecido reaproveitado");
    }

    public double calcularCustoPorUnidade(double valorLote, int quantidade) {
        if (quantidade <= 0) return 0;
        return valorLote / quantidade;
    }

    public void registrarLoteAcessorio(String tipoAcessorio, int quantidadeRecebida) {
        System.out.println("Lote registrado: " + quantidadeRecebida + " unidades de " + tipoAcessorio +
         " recebidas de " + getNome());
    }

    public String gerarEtiquetaAcessorio(String tipoAcessorio, String paisOrigem) {
        return "Acessório: " + tipoAcessorio + " | Fornecedor: " + getNome() + " | Origem: " + paisOrigem;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Especialidade: Acessórios");
    }

     @Override
    public void cadastrar() {
        super.cadastrar();
        System.out.println("Fornecedor de acessórios cadastrado. Verifique materiais recicláveis!");
    }
}