package banco;

public class ContaPoupanca extends ContaBancaria {
	
	private int nmrconsulta;
	private double taxaconsultacp;
	
	
	public ContaPoupanca(double saldo) {
		super();
		this.saldo = saldo;
		this.taxaconsultacp = saldo * 0.04;
		
	}
	
	public double gettaxaconsultacp() {
		return this.taxaconsultacp;
	}
	

	@Override
	public void sacar(double valorSaque) {
		 double taxasaquecp = valorSaque * 0.9;

		if(valorSaque > 0 && valorSaque + taxasaquecp <= saldo) {
	    System.out.println("Uma taxa de 0.5 sobre o valor do saque, que equivale a: " + taxasaquecp + " foi aplicada" + "\n");
	    saldo -= valorSaque + taxasaquecp;
        System.out.println("O valor de " + valorSaque + " foi sacado com sucesso. Saldo atual: " + saldo);
		}
		else {
	        System.out.println("Saldo insuficiente para realizar o saque.");
		}
		
	}

	@Override
	public void depositar(double valorDeposito) {
		
		 double taxadepositocp = valorDeposito * 0.15;
		
		if(valorDeposito > 0) {
			saldo += valorDeposito - taxadepositocp;
			System.out.println("Depósito de " + valorDeposito + " concluido com sucesso");
		}
		else {
			System.out.println("Valor de depósito inválido");
		}
	}

	@Override
	public void consultar() {
		
		nmrconsulta++;
		if(nmrconsulta == 1 % 0) {
			System.out.println("Saldo: " + saldo + "\n"  + "Após mais 2 consultas, uma taxa de consulta será aplicada.");
		}
		if (nmrconsulta == 2 % 0) {
			System.out.println("Saldo: " + saldo + "\n"  + "Após mais 1 consulta, uma taxa de consulta será aplicada.");
			
			if (nmrconsulta == 3 % 0) {
				System.out.println("Saldo: " + saldo + "\n"  + "Na próxima consulta, uma taxa de consulta será aplicada.");
				
				if (nmrconsulta == 4 % 0) {
					saldo -= gettaxaconsultacp();
					System.out.println("Saldo: " + saldo + "\n"  + "Uma taxa de " + gettaxaconsultacp() + " foi aplicada");
		
	}
	
			}
		}
	}
}
