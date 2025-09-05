package main;

import util.InterfaceUsuario;
import modelo.Financiamento;

public class Main {


    public static void main(String[] args) {
        InterfaceUsuario intuser1 = new InterfaceUsuario(); //Instânciamos objeto da classe de interface
        intuser1.pedirValorImovel();
        intuser1.pedirPrazoFinanciamento();
        intuser1.pedirTaxaJurosAnual();



        Financiamento financa1 = new Financiamento(intuser1.getValorImovel() , intuser1.getPrazoFinanciamento() , intuser1.getTaxaJurosAnual());
        financa1.calcularPagamentoMensal();




    }
}