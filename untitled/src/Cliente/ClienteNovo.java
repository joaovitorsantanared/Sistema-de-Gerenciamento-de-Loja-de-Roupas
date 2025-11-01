package Cliente;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class ClienteNovo extends Cliente{


    public ClienteNovo(String id, String nome, String cpf, String email, String numero) {
        super(id, nome, cpf, email, numero);
    }

    public void cadastrar(){
        System.out.println(" Olá " + getNome() + "!" );
        System.out.println("O seu cpf é: " +getCpf());
        System.out.println("O seu email é: "+ getEmail());
        System.out.println("O seu número de telefone é " + getNumero());
        System.out.println("Parabéns! Você está totalmente cadastrado e o seu id a partir de agora é: "+getId());
    }

@Override
    public void removerCadastro() {

        setId("");
        setNome("");
        setCpf("");
        setEmail("");
        setNumero("");
        setAtive(false);
        System.out.println("Cadastro removido com sucesso!");


    }

    public void modificarCadastro(String novoId, String novoNome, String novoCpf, String novoEmail, String novoNumero ){
        setId(novoId);
        setNome(novoNome);
        setCpf(novoCpf);
        setEmail(novoEmail);
        setNumero(novoNumero);

        System.out.println("Seu cadastro foi atualizado com sucesso!");
        System.out.println("=============NOVA IDENTIDADE===============)");
        System.out.println("Novo ID: " +novoNumero);
        System.out.println("Novo nome: " +novoNome);
        System.out.println("Novo cpf: " +novoCpf);
        System.out.println("Novo email: " +novoEmail);
        System.out.println("Novo número: " + novoNumero);


    }



    }

