package banco;

public abstract class ContaBancaria {
	

	protected double saldo;
	
	

	public abstract void sacar(double valorSaque);

	public abstract void depositar(double valorDeposito);

	public abstract void consultar();

}	

