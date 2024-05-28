import java.util.Locale;
import java.util.Scanner;

public class BancoDigital {
    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Campolim", "123.456.789-00");
        ContaCorrente contaCorrente = new ContaCorrente("001");
        ContaPoupanca contaPoupanca = new ContaPoupanca("002");

        cliente1.adicionarConta(contaCorrente);
        cliente1.adicionarConta(contaPoupanca);

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    realizarDeposito(contaCorrente, contaPoupanca);
                    break;
                case 2:
                    realizarSaque(contaCorrente, contaPoupanca);
                    break;
                case 3:
                    realizarTransferencia(contaCorrente, contaPoupanca);
                    break;
                case 4:
                    exibirSaldos(contaCorrente, contaPoupanca);
                    break;
                case 5:
                    exibirHistorico(contaCorrente, contaPoupanca);
                    break;
                case 6:
                    contaPoupanca.aplicarJuros();
                    break;
                case 7:
                    contaCorrente.cobrarTaxaManutencao();
                    break;
                case 8:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Banco Digital ---\n");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Transferir");
        System.out.println("4. Exibir Saldos");
        System.out.println("5. Exibir Histórico de Transações");
        System.out.println("6. Aplicar Juros (Poupança)");
        System.out.println("7. Cobrar Taxa de Manutenção (Corrente)");
        System.out.println("8. Sair\n");
        System.out.print("Escolha uma opção: ");
    }

    private static void realizarDeposito(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        System.out.print("Escolha a conta (1. Corrente, 2. Poupança): ");
        int tipoConta = sc.nextInt();
        System.out.print("Digite o valor do depósito: ");
        double valor = sc.nextDouble();

        if (tipoConta == 1) {
            contaCorrente.depositar(valor);
        } else if (tipoConta == 2) {
            contaPoupanca.depositar(valor);
        } else {
            System.out.println("Tipo de conta inválido.");
        }
    }

    private static void realizarSaque(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        System.out.print("Escolha a conta (1. Corrente, 2. Poupança): ");
        int tipoConta = sc.nextInt();
        System.out.print("Digite o valor do saque: ");
        double valor = sc.nextDouble();

        if (tipoConta == 1) {
            contaCorrente.sacar(valor);
        } else if (tipoConta == 2) {
            contaPoupanca.sacar(valor);
        } else {
            System.out.println("Tipo de conta inválido.");
        }
    }

    private static void realizarTransferencia(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        System.out.print("Escolha a conta de origem (1. Corrente, 2. Poupança): ");
        int tipoContaOrigem = sc.nextInt();
        System.out.print("Digite o valor da transferência: ");
        double valor = sc.nextDouble();

        if (tipoContaOrigem == 1) {
            contaCorrente.transferir(contaPoupanca, valor);
        } else if (tipoContaOrigem == 2) {
            contaPoupanca.transferir(contaCorrente, valor);
        } else {
            System.out.println("Tipo de conta inválido.");
        }
    }

    private static void exibirSaldos(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        System.out.printf("Saldo Conta Corrente: %.2f%n" , contaCorrente.getSaldo());
        System.out.printf("Saldo Conta Poupança: %.2f%n" , contaPoupanca.getSaldo());
    }

    private static void exibirHistorico(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        System.out.println("Histórico de Transações Conta Corrente: " + contaCorrente.getHistoricoTransacoes());
        System.out.println("Histórico de Transações Conta Poupança: " + contaPoupanca.getHistoricoTransacoes());
    }
}
