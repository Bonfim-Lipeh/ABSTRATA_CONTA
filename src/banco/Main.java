package banco;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 


        System.out.println("Digite 1 para Conta Corrente ou 2 para Conta Poupança:");
        int tipoConta = scanner.nextInt();

        ContaBancaria conta = null;

        switch (tipoConta) {
            case 1:
                System.out.print("Digite o saldo inicial: ");
                double saldoInicial = scanner.nextDouble();
                conta = new ContaCorrente(saldoInicial);
                break;
            case 2:
                System.out.print("Digite o saldo inicial: ");
                saldoInicial = scanner.nextDouble();
                conta = new ContaPoupanca(saldoInicial);
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3: 
                    conta.consultar();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}