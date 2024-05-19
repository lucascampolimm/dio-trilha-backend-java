import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Insira o seu nome: ");
        String nomeCliente = sc.nextLine();

        System.out.print("Insira o número da agência: ");
        String agencia = sc.nextLine();

        System.out.print("Insira o número da conta: ");
        int numero = sc.nextInt();

        System.out.print("Insira o valor que deseja depositar: ");
        double saldo = sc.nextDouble();

        sc.close();

        System.out.println("\nOlá ".concat(nomeCliente)
                .concat(", obrigado por criar uma conta em nosso banco, sua agência é ")
                .concat(agencia)
                .concat(", conta ")
                .concat(String.valueOf(numero))
                .concat(" e seu saldo ")
                .concat(String.valueOf(saldo))
                .concat(" já está disponível para saque."));
    }
}
