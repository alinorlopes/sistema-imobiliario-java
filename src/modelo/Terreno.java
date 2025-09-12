package modelo;

public class Terreno extends Financiamento{

    Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() * 1.02; //Adicionado um acrésimo de 2% no financiamento de terreno
    }





}
