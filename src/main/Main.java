package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import util.AcrescimoMaiorDoQueJurosException;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criando lista de financiamentos
        ArrayList<Financiamento> lista = new ArrayList<>();
        lista.add(new Apartamento(500000, 30, 5, 2, 5)); // valorImovel, prazo, taxa, vagas, andar

        try {
            lista.add(new Casa(300000, 20, 4, 120, 200)); // valorImovel, prazo, taxa, areaConstruida, areaTerreno
        } catch (AcrescimoMaiorDoQueJurosException e) {
            System.out.println("Erro ao adicionar Casa: " + e.getMessage());
        }

        // Salvar em arquivo de texto
        try (PrintWriter pw = new PrintWriter(new FileWriter("financiamentos.txt"))) {
            for (Financiamento f : lista) {
                pw.println(f.toTexto());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ler arquivo de texto
        System.out.println("Lendo do arquivo de texto:");
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
    }
}
