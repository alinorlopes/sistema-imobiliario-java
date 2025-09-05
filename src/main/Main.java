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
                "Digite quantos financiamentos serão: ");

        int numeroDeFinancas = scanner.nextInt();

        // Acumuladores
        double somaValorImoveis = 0;
        double somaValorTotalFinanciamentos = 0;

        for (int i = 1; i <= numeroDeFinancas; i++) {
            intuser1.pedirValorImovel();
            intuser1.pedirPrazoFinanciamento();
            intuser1.pedirTaxaJurosAnual();

            Financiamento financiamento = new Financiamento(
                    intuser1.getValorImovel(),
                    intuser1.getPrazoFinanciamento(),
                    intuser1.getTaxaJurosAnual()
            );

            listaDeFinanciamento.add(financiamento);

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