import java.util.Scanner;

public class ControleSimplesDeSaques {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double limiteDiario = scanner.nextDouble();

        for (;;) {
            double valorSaque = scanner.nextDouble();

            if (valorSaque == 0) {
                System.out.println("Transacoes encerradas.");
                break;
            }

            if (valorSaque > limiteDiario) {
                System.out.println("Limite diario de saque atingido. Transacoes encerradas.");
                break;
            }

            limiteDiario -= valorSaque;

            System.out.printf("Saque realizado. Limite restante: %.1f%n", limiteDiario);
        }

        scanner.close();
    }
}
