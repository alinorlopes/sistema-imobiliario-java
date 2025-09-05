package modelo;
public class Financiamento {
	
    //Atributos
	
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    private double pagamentoMensal;
    private double totalPagamento;
    
    //Métodos Getters:
    
    public double getValorImovel() {
    	return valorImovel;
    }
    public int getPrazoFinanciamento() {
    	return prazoFinanciamento;
    }
    
    public double getTaxaJurosAnual() {
    	return taxaJurosAnual;
    }
    
    public double getPagamentoMensal() {
    	return pagamentoMensal;
    }
    
    public double getTotalPagamento() {
    	return totalPagamento;
    }
    
  //Método Construtor:
    
    public Financiamento (double valorImovel, int prazoFinanciamento, double taxaJurosAnual) { 
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    
  //Métodos
    
    public double calcularPagamentoMensal(){
        pagamentoMensal = (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
        System.out.printf(" O valor da parcela mensal desse financiamento é de R$%.2f." ,pagamentoMensal);
        return pagamentoMensal;

    }
    public double calcularPagamentoTotal(){
        totalPagamento = (pagamentoMensal * prazoFinanciamento * 12);
                return totalPagamento;
    }
    public void mostrarDadosFinanciamento() {
    	System.out.println("Valor total do financiamento: " + totalPagamento + "\n 	Valor do Imóvel: " + valorImovel);
    }

}
