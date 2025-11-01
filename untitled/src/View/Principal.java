package View;

import Cliente.Cliente;
import Cliente.ClienteNovo;
import Cliente.ClienteFidelidade;
import Funcionarios.Funcionario;
import Funcionarios.Caixa;
import Funcionarios.Estoquista;
import Funcionarios.Vendedor;
import Funcionarios.Gerente;


public class Principal {
    public static void main(String[] args) {

        ClienteNovo novo = new ClienteNovo("13213144141","João Vitor","564862987-10","joaovitor@gmail.com","(81)-994542215\n");
        Cliente cliente = new Cliente("123414512DSAD","Marcelo","712343568-70","marcelinhotrevoso@gmail.com","(81)-95412376\n");
        ClienteFidelidade c1 = new ClienteFidelidade("AS13913","Joana","583423131-12","joanadarc@gmail.com","(80)-12353218\n");


        c1.setNome("Marcelo");
        c1.desconto(Double.parseDouble("30.20"));

        c1.removerCadastro();
        novo.cadastrar();
        cliente.cadastrar();
        novo.modificarCadastro("12390814","Marceline","574312839856","marcelinevampira@gmail.com","(18)-995627758\n");
        c1.avaliacao(4);



        }
    }
