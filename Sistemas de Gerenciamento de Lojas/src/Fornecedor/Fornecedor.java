package Fornecedor;

public class Fornecedor {
    private String id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;
    private String tipoProdutoFornecido;

    public Fornecedor(String id, String nome, String cnpj, String email, String telefone, String endereco,
     String tipoProdutoFornecido) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipoProdutoFornecido = tipoProdutoFornecido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoProdutoFornecido() {
        return tipoProdutoFornecido;
    }

    public void setTipoProdutoFornecido(String tipoProdutoFornecido) {
        this.tipoProdutoFornecido = tipoProdutoFornecido;
    }
    public void exibirInformacoes() {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("CNPJ: " + getCnpj());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Tipo de Produto: " + getTipoProdutoFornecido());
    }

    public void cadastrar() {
        System.out.println("Olá " + getNome() + "!");
        exibirInformacoes();
        System.out.println("Cadastro realizado com sucesso!");
    }
}