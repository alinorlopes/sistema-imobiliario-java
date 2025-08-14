import java.util.Scanner;


public class InterfaceUsuario{
    //atributos
    int prazoFinanciamento;
    double taxaJurosAnual;
    double valorImovel;
    Scanner scanner = new Scanner (System.in); //Instância do Scanner

    //métodos
    int pedirPrazoFinanciamento(){
        System.out.println("Digite o prazo do financiamento em anos: ");
        prazoFinanciamento = scanner.nextInt();
        return prazoFinanciamento;
    }

    double pedirTaxaJurosAnual(){
        System.out.println("Digite a taxa de juros anual: ");
        taxaJurosAnual = scanner.nextDouble();
        return taxaJurosAnual;
    }
    double pedirValorImovel(){
        System.out.println("Digite o valor do imóvel.");
        System.out.print("R$ ");
        valorImovel = scanner.nextDouble();
        return valorImovel;
    }
}