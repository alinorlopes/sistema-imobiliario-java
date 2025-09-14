package main;

import util.InterfaceUsuario;
import modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Financiamento> listaDeFinanciamento = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        InterfaceUsuario intuser1 = new InterfaceUsuario();

        System.out.println("| Sistema imobiliário |\n");

        // Acumuladores
        double somaValorImoveis = 0;
        double somaValorTotalFinanciamentos = 0;

        intuser1.pedirValorImovel();
        intuser1.pedirPrazoFinanciamento();
        intuser1.pedirTaxaJurosAnual();

        for (int i = 1; i <= 2; i++) {

            Casa financiamentoCasa = new Casa (
                    intuser1.getValorImovel(),
                    intuser1.getPrazoFinanciamento(),
                    intuser1.getTaxaJurosAnual());
            financiamentoCasa.calcularPagamentoTotal();

            listaDeFinanciamento.add(financiamentoCasa); //Adiciona o financiamento na lista

            // Atualiza os acumuladores
            somaValorImoveis += intuser1.getValorImovel();
            somaValorTotalFinanciamentos += financiamentoCasa.calcularPagamentoTotal();
        }

        for (int i = 1;i <= 2;i++) {
            Apartamento financiamentoApartamento = new Apartamento(
                    intuser1.getValorImovel(),
                    intuser1.getPrazoFinanciamento(),
                    intuser1.getTaxaJurosAnual());
                    financiamentoApartamento.calcularPagamentoTotal();

            listaDeFinanciamento.add(financiamentoApartamento);

            // Atualiza os acumuladores
            somaValorImoveis += intuser1.getValorImovel();
            somaValorTotalFinanciamentos += financiamentoApartamento.calcularPagamentoTotal();
        }

        Terreno financiamentoTerreno = new Terreno(
                intuser1.getValorImovel(),
                intuser1.getPrazoFinanciamento(),
                intuser1.getTaxaJurosAnual());

        financiamentoTerreno.calcularPagamentoMensal();


        listaDeFinanciamento.add(financiamentoTerreno);

        // Atualiza os acumuladores
        somaValorImoveis += intuser1.getValorImovel();
        somaValorTotalFinanciamentos += financiamentoTerreno.calcularPagamentoTotal();


        // Exibe os resultados
        System.out.println("\nResumo dos financiamentos:");
        for (Financiamento f : listaDeFinanciamento) {
            System.out.println(f);

        }
        System.out.println("\nSoma dos valores dos imóveis: R$" + String.format("%.2f", somaValorImoveis));
        System.out.println("Soma dos valores totais dos financiamentos: R$" + String.format("%.2f", somaValorTotalFinanciamentos));
    }
}