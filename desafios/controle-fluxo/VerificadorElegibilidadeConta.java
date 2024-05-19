import java.util.Scanner;

public class VerificadorElegibilidadeConta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int idade = scanner.nextInt();

        if (idade >= 18) {
            System.out.println("Você esta elegível para criar uma conta bancária.");
        } else {
            System.out.println("Você não esta elegível para criar uma conta bancária.");
        }

        scanner.close();
    }
}
