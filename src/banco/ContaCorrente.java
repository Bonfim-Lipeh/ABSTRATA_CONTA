package banco;

public class ContaCorrente extends ContaBancaria{

	
	private double limite = saldo / 3;
	private double valorextra;
	private double taxalimite;
	private int consulta;
	private double taxaconsulta;
	
	
	public ContaCorrente(double saldo) {
		super();
		this.saldo = saldo;
		this.taxalimite = limite * 0.7;
		this.taxaconsulta = saldo * 0.05;
	}
	
	public double gettaxaconsulta() {
		return this.taxaconsulta;
	}
	
	public double gettaxalimite() {
		return this.limite;
	}
	
	public double getlimite() {
		return limite;
	}


	@Override
	public void sacar(double valorSaque) {
		 double taxasaquecc = valorSaque * 0.5;

	    if (valorSaque > 0 && valorSaque + taxasaquecc <= saldo) {
	    	System.out.println("Uma taxa de 0.5 sobre o valor do saque, que equivale a: " + taxasaquecc + "foi aplicada" + "/n");
	        saldo -= valorSaque + taxasaquecc;
	        System.out.println("O valor de " + valorSaque + " foi sacado com sucesso. Saldo atual: " + saldo);
	    } else if (valorSaque > 0 && valorSaque + taxalimite <= saldo + limite) {
	        valorextra = valorSaque + taxalimite - saldo;
	        saldo = 0;
	        System.out.println("Você utilizou " + valorextra + " do seu limite. Uma taxa de 0.7 que equivale a: " + taxalimite + " será aplicada.");
	        System.out.println("Saldo atual: " + saldo + ". Limite restante: " + (limite - valorextra));
	    } else {
	        System.out.println("Saldo insuficiente para realizar o saque.");
	    }
	}


	@Override
	public void depositar(double valorDeposito) {
		 double taxadepcc = valorDeposito * 0.2;

		if(valorDeposito > 0) {
			saldo += valorDeposito - taxadepcc;
			System.out.println("Depósito de " + valorDeposito + " concluido com sucesso");
		}
		else {
			System.out.println("Valor de depósito inválido");
		}
	}


	@Override
	public void consultar() {
		consulta++;
		if(consulta == 1 % 0) {
			System.out.println("Saldo: " + saldo + "\n"  + "Após mais 2 consultas, uma taxa de consulta será aplicada.");
		}
		if (consulta == 2 % 0) {
			System.out.println("Saldo: " + saldo + "\n"  + "Após mais 1 consulta, uma taxa de consulta será aplicada.");
			
			if (consulta == 3 % 0) {
				System.out.println("Saldo: " + saldo + "\n"  + "Na próxima consulta, uma taxa de consulta será aplicada.");
				
				if (consulta == 4 % 0) {
					saldo -= gettaxaconsulta();
					System.out.println("Saldo: " + saldo + "\n"  + "Uma taxa de " + gettaxaconsulta() + " foi aplicada");
	}
	

	
	
			}
		}
	}
	
}
