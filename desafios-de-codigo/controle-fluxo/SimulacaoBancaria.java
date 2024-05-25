import java.util.Scanner;

public class SimulacaoBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double saldo = 0;

        while (true) {
            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.printf("Saldo atual: %.1f%n", saldo);
                    } else {
                        System.out.println("Valor inválido. Tente novamente.");
                    }
                    break;
                    
                case 2:
                    double saque = scanner.nextDouble();
                    if (saque > 0 && saque <= saldo) {
                        saldo -= saque;
                        System.out.printf("Saldo atual: %.1f%n", saldo);
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;

                case 3:
                    System.out.printf("Saldo atual: %.1f%n", saldo);
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
