package util;

import java.util.Scanner;

public class InterfaceUsuario {

    // Atributos
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    private double valorImovel;

    private Scanner scanner = new Scanner(System.in);

    // Getters
    public double getValorImovel() { return valorImovel; }
    public int getPrazoFinanciamento() { return prazoFinanciamento; }
    public double getTaxaJurosAnual() { return taxaJurosAnual; }

    // Métodos com tratamento de exceções
    public int pedirPrazoFinanciamento() {
        while (true) {
            try {
                System.out.print("Digite o prazo do financiamento em anos: ");
                prazoFinanciamento = Integer.parseInt(scanner.nextLine());
                if (prazoFinanciamento < 1) throw new NumberFormatException();
                return prazoFinanciamento;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número inteiro positivo.");
            }
        }
    }

    public double pedirTaxaJurosAnual() {
        while (true) {
            try {
                System.out.print("Digite a taxa de juros anual (%): ");
                taxaJurosAnual = Double.parseDouble(scanner.nextLine());
                if (taxaJurosAnual < 0) throw new NumberFormatException();
                return taxaJurosAnual;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número válido.");
            }
        }
    }

    public double pedirValorImovel() {
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel (R$): ");
                valorImovel = Double.parseDouble(scanner.nextLine());
                if (valorImovel <= 0) throw new NumberFormatException();
                return valorImovel;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número positivo.");
            }
        }
    }

    // Método para somar valor do imóvel (opcional, corrigido)
    public double somarValorImovel(double valor) {
        valorImovel += valor;
        return valorImovel;
    }
}
