package Cliente;

public class Cliente {


    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String numero;
    private boolean ative = true;

    public Cliente(String id, String nome, String cpf, String email, String numero){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.numero = numero;
    }

    public Cliente(String amsd2135x21, String marcelo, String cpf) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumero() {
        return numero;
    }

    public boolean isAtive() {
        return ative;
    }

    public void setAtive(boolean ative) {
        this.ative = ative;
    }

    public void setNumero(String numero) {
        this.numero = numero;


    }


    public void removerCadastro(){
        ative = false;
            System.out.println("Cliente desativado");

        }

    public void cadastrar(){
        System.out.println(" Olá " +getNome()+ "!" );
        System.out.println("O seu cpf é: " +getCpf());
        System.out.println("O seu email é: "+ getEmail());
        System.out.println("O seu número de telefone é " + getNumero());
        System.out.println("Parabéns! Você está totalmente cadastrado e o seu id a partir de agora é: "+getId()+"\n");
    }

}
