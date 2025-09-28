package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import modelo.Financiamento;
import util.AcrescimoMaiorDoQueJurosException;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        InterfaceUsuario iu = new InterfaceUsuario(sc);

        // 1 financiamento via usuário (exemplo: Casa)
        System.out.println("=== Cadastro de Financiamento (via usuário) ===");
        double valor = iu.pedirValorImovel();
        int prazo = iu.pedirPrazoFinanciamento();
        double taxa = iu.pedirTaxaJurosAnual();

        try {
            lista.add(new Casa(valor, prazo, taxa, 120, 200));
        } catch (AcrescimoMaiorDoQueJurosException e) {
            System.out.println("Erro ao adicionar Casa: " + e.getMessage());
        }

        // 2 casas (uma já cadastrada pelo usuário, outra fixa)
        try {
            lista.add(new Casa(300000, 20, 4, 150, 250));
        } catch (AcrescimoMaiorDoQueJurosException e) {
            System.out.println("Erro ao adicionar Casa: " + e.getMessage());
        }

        // 2 apartamentos
        lista.add(new Apartamento(500000, 30, 5, 2, 5));
        lista.add(new Apartamento(400000, 25, 6, 1, 10));

        // 1 terreno
        lista.add(new Terreno(200000, 15, 6, "Residencial"));

        // Mostrar soma dos valores
        double somaImoveis = 0;
        double somaFinanciamentos = 0;
        for (Financiamento f : lista) {
            somaImoveis += f.getValorImovel();
            somaFinanciamentos += f.calcularPagamentoTotal();
        }

        System.out.println("\n=== Resumo ===");
        System.out.printf("Soma dos valores dos imóveis: R$ %.2f%n", somaImoveis);
        System.out.printf("Soma dos valores dos financiamentos: R$ %.2f%n", somaFinanciamentos);

        // Salvar em arquivo de texto
        try (PrintWriter pw = new PrintWriter(new FileWriter("financiamentos.txt"))) {
            for (Financiamento f : lista) {
                pw.println(f.toTexto());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ler arquivo de texto
        System.out.println("\nLendo do arquivo de texto:");
        try (BufferedReader br = new BufferedReader(new FileReader("financiamentos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Salvar serializado
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("financiamentos.ser"))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ler serializado
        System.out.println("\nLendo do arquivo serializado:");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financiamentos.ser"))) {
            ArrayList<Financiamento> listaLida = (ArrayList<Financiamento>) ois.readObject();
            for (Financiamento f : listaLida) {
                f.exibirDetalhes();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}