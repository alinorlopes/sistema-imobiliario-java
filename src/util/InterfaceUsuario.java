package util;
import java.util.Scanner;


public class InterfaceUsuario{
	
    //Atributos
	
    int prazoFinanciamento;
    double taxaJurosAnual;
    double valorImovel;
    
    Scanner scanner = new Scanner (System.in); //Instância do Scanner

    //Getters
    
    public double getValorImovel() {
    	return this.valorImovel;
    }
    public int getPrazoFinanciamento() {
    	return this.prazoFinanciamento;
    }
    public double getTaxaJurosAnual() {
    	return this.taxaJurosAnual;
    }
    
  //Métodos
    
    public int pedirPrazoFinanciamento(){
    	do {	
    		System.out.println("Digite o prazo do financiamento em anos: ");
    		prazoFinanciamento = scanner.nextInt();
    		if (prazoFinanciamento < 1) {
    			System.out.println("Insira um valor válido.");
    		} return prazoFinanciamento;
		} while (prazoFinanciamento < 1);}
    	
    public double pedirTaxaJurosAnual(){
    	do {
    		System.out.println("Digite a taxa de juros anual: ");
    		taxaJurosAnual = scanner.nextDouble();
    		if (taxaJurosAnual < 1) {
    			System.out.println("Insira um valor Válido.");    			
    		} return taxaJurosAnual;
    	} while (taxaJurosAnual < 1);}
    
    
    public double pedirValorImovel(){
    	do {
	        System.out.println("Digite o valor do imóvel.");
	        System.out.print("R$ ");
	        valorImovel = scanner.nextDouble();
	        if (valorImovel < 1) {
	        	System.out.println("Insira um válor válido");
	        }return valorImovel;
        } while(valorImovel < 1);
    }
    public double somarValorImovel(){
       return valorImovel =+ valorImovel;
    }

}
