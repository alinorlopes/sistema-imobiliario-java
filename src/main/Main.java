package main;

import util.InterfaceUsuario;
import modelo.Financiamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Financiamento> listaDeFinanciamento = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        InterfaceUsuario intuser1 = new InterfaceUsuario();

        System.out.println("| Sistema imobiliário |\n" +
                "Digite quantos financiamentos serão: (Máximo de 5 financimentos) ");

        int numeroDeFinancas = scanner.nextInt(); // Número de quantos financiamentos serão feitos

        boolean deveFechar = false; //varíavel de controle

        do {
            if (numeroDeFinancas <= 0 || numeroDeFinancas >= 6) {
                System.out.println("A quantidade de financiamentos digitados é inválida, Tente novamente.");
                numeroDeFinancas = scanner.nextInt();
                deveFechar = false;
            } else if (numeroDeFinancas >= 1 && numeroDeFinancas <= 5){
                deveFechar = true;
            }
    } while (deveFechar == false); // máximo de 5 financiamentos, não permite negativos e maior que 5

        // Acumuladores
        double somaValorImoveis = 0;
        double somaValorTotalFinanciamentos = 0;

        for (int i = 1; i <= numeroDeFinancas; i++) {
            intuser1.pedirValorImovel();
            intuser1.pedirPrazoFinanciamento();
            intuser1.pedirTaxaJurosAnual();

            Financiamento financiamento = new Financiamento( //Instância e a criação da finança
                    intuser1.getValorImovel(),
                    intuser1.getPrazoFinanciamento(),
                    intuser1.getTaxaJurosAnual()
            );

            listaDeFinanciamento.add(financiamento); //Adiciona o financiamento na lista

            // Atualiza os acumuladores
            somaValorImoveis += intuser1.getValorImovel();
            somaValorTotalFinanciamentos += financiamento.calcularPagamentoTotal();
        }

        // Exibe os resultados
        System.out.println("\nResumo dos financiamentos:");
        for (Financiamento f : listaDeFinanciamento) {
            System.out.println(f);

        }
        System.out.println("\nSoma dos valores dos imóveis: R$" + String.format("%.2f", somaValorImoveis));
        System.out.println("Soma dos valores totais dos financiamentos: R$" + String.format("%.2f", somaValorTotalFinanciamentos));
    }
}