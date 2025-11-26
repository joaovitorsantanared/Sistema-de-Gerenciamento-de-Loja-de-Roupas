package View;

import java.time.LocalDate;

import Cliente.Cliente;
import Cliente.ClienteNovo;
import Cliente.ClienteFidelidade;

import Funcionarios.Vendedor;
import Funcionarios.Gerente;

import Empresa.DepartamentoRH;
import Empresa.DepartamentoFinanceiro;
import Empresa.Matriz;
import Empresa.Filial;

import Fornecedor.FornecedorNacional;
import Fornecedor.FornecedorInternacional;
import Fornecedor.FornecedorAcessorio;
import Fornecedor.FornecedorTecido;

import Roupa.Camiseta;
import Roupa.Calca;
import Roupa.Vestido;
import Roupa.RoupaFeminina;
import Roupa.RoupaMasculina;
import Roupa.Acessorio;

import Vendas.VendasPresencial;
import Vendas.VendasOnline;

public class Principal {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE LOJA =====\n");

        // ===== CLIENTES =====
        System.out.println("--- CLIENTES ---");
        ClienteNovo novo = new ClienteNovo("13213144141","João Vitor","564862987‑10","joaovitor@gmail.com","(81)-994542215");
        Cliente cliente = new Cliente("123414512DSAD","Marcelo","712343568‑70","marcelinhotrevoso@gmail.com","(81)-95412376");
        ClienteFidelidade c1 = new ClienteFidelidade("AS13913","Joana","583423131‑12","joanadarc@gmail.com","(80)-12353218");

        c1.setNome("Marcelo");
        c1.desconto(30.20);
        c1.removerCadastro();
        novo.cadastrar();
        novo.realizarPrimeiraCompra();
        cliente.cadastrar();
        novo.modificarCadastro("12390814","Marceline","574312839856","marcelinevampira@gmail.com","(18)-995627758");
        c1.avaliacao(4);
        c1.acumularPontos(Double.parseDouble("41"));
        System.out.println("=== FIM CLIENTES ===\n");

        // ===== FUNCIONÁRIOS =====
        System.out.println("--- FUNCIONÁRIOS ---");
        Gerente gerente = new Gerente(1, "Ana Beatriz", "741.852.963‑00",
                LocalDate.of(1985,3,7), LocalDate.of(2018,5,30), true, 800.0);
        Vendedor vendedor = new Vendedor(2, "Pedro", "987.654.321‑00",
                LocalDate.of(1995,9,25), LocalDate.of(2021,1,15), true, 500.0);



        vendedor.registrarVenda(800.00);
        vendedor.registrarVenda(500.00);
        System.out.printf("Total vendas do Vendedor: R$ %.2f%n", vendedor.getTotalVendas());
        System.out.printf("Salário do Vendedor: R$ %.2f%n", vendedor.calcularSalario());

        System.out.printf("Salário do Gerente: R$ %.2f%n", gerente.calcularSalario());
        gerente.avaliarDesempenho(vendedor, 1000.0);


        System.out.println("=== FIM FUNCIONÁRIOS ===\n");

        // ===== EMPRESA & DEPARTAMENTOS =====
        System.out.println("--- EMPRESA & DEPARTAMENTOS ---");
        DepartamentoRH rh = new DepartamentoRH("Loja Central", "12.345.678/0001‑99",
                "Rua das Flores, 100", "(81) 90000‑0000");
        rh.adicionarFuncionarioRH(vendedor);
        rh.listarFuncionariosRH();
        rh.relatorioAtivos();

        DepartamentoFinanceiro financeiro = new DepartamentoFinanceiro("Loja Central", "12.345.678/0001‑99",
                "Rua das Flores, 100", "(81) 90000‑0000");
        financeiro.exibirRelatorioFinanceiro();

        Matriz matriz = new Matriz("Loja Central", "12.345.678/0001‑99",
                "Rua das Flores, 100", "(81) 90000‑0000", gerente);
        matriz.adicionarFuncionario(vendedor);

        Filial filial = new Filial("Loja Shopping Recife", "98.765.432/0001‑88",
                "Av. Recife, 2000", "(81) 98888‑7777", 1, gerente);
        System.out.println("=== FIM EMPRESA & DEPARTAMENTOS ===\n");

        // ===== ROUPAS =====
        System.out.println("--- ROUPAS ---");
        Camiseta camiseta = new Camiseta("R001","Camiseta Estampada",89.90,"M","Preta","Hering",50,"Gola Redonda");
        Calca calca = new Calca("R002","Calça Jeans Slim",159.90,"42","Azul","Levi’s",30,"Slim Fit");
        Vestido vestido = new Vestido("R003","Vestido Floral",199.90,"P","Vermelho","Zara",20,"Curto");
        RoupaFeminina blusa = new RoupaFeminina("R004","Blusa Decote V",119.90,"M","Branca","Renner",40,"Blusa","Seda");
        RoupaMasculina camisa = new RoupaMasculina("R005","Camisa Social",139.90,"G","Azul Claro","Aramis",25,"Camisa","Algodão");
        Acessorio acessorio = new Acessorio("R006","Pulseira Elegance",59.90,"Único","Prata","Vivara",15,"Pulseira","Prata 925");

        camiseta.exibirDetalhes();
        calca.exibirDetalhes();
        vestido.exibirDetalhes();
        blusa.exibirDetalhes();
        camisa.exibirDetalhes();
        acessorio.exibirDetalhes();
        System.out.println("=== FIM ROUPAS ===\n");

        // ===== FORNECEDORES =====
        System.out.println("--- FORNECEDORES ---");
        FornecedorNacional fn = new FornecedorNacional("F01","Tecidos Brasil","12.345.678/0001‑99",
                "contato@tecidosbr.com","(81) 91234‑5678","Rua das Indústrias, 400","Tecidos",19.50);
        FornecedorInternacional fi = new FornecedorInternacional("F02","Global Fashion","98.765.432/0001‑11",
                "global@fashion.com","+1 202‑555‑0147","New York","Roupas Premium",1.50);
        FornecedorAcessorio fa = new FornecedorAcessorio("F03","Bijoux Luxo","77.889.955/0001‑90",
                "contato@bijouxluxo.com","(81) 98877‑6655","Recife","Acessórios","Tecido Linho");
        FornecedorTecido ft = new FornecedorTecido("F04","Tecidos Leves","44.556.677/0001‑23",
                "tecidosleves@gmail.com","(81) 99855‑6677","Olinda","Tecidos Sustentáveis",7.20);

        fn.cadastrar();
        System.out.println("CNPJ válido? " + fn.validarCNPJ()+"\n");
        fi.cadastrar();
        fa.cadastrar();
        ft.cadastrar();
        System.out.println("=== FIM FORNECEDORES ===\n");

        // ===== VENDAS =====
        System.out.println("--- VENDAS ---");
        VendasPresencial vp = new VendasPresencial("V01", LocalDate.now(), 500.0, "Crédito", true);
        VendasOnline vo = new VendasOnline("V02", LocalDate.now(), 350.0, "PIX",
                "Rua do Sol, 123", "Enviado", "Amanda");

        vp.exibirInformacoes();
        vo.exibirInformacoes();

        vo.setClienteFidelidade(c1);
        vo.aplicarDescontoClienteFidelidade();

        matriz.registrarVenda(vp);
        filial.registrarVenda(vo);

        matriz.exibirRelatorioCompleto();
        filial.exibirRelatorioCompleto();
        System.out.println("=== FIM VENDAS ===\n");

        System.out.println("===== FIM DO SISTEMA =====");
    }
}
