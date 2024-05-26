public class BancoDigital {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("001");
        ContaPoupanca contaPoupanca = new ContaPoupanca("002");

        contaCorrente.depositar(500);
        contaPoupanca.depositar(1000);

        System.out.println("Saldo Conta Corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo Conta Poupanca: " + contaPoupanca.getSaldo());

        contaCorrente.sacar(200);
        contaPoupanca.sacar(300);

        System.out.println("Saldo Conta Corrente após saque: " + contaCorrente.getSaldo());
        System.out.println("Saldo Conta Poupanca após saque: " + contaPoupanca.getSaldo());

        contaCorrente.transferir(contaPoupanca, 100);

        System.out.println("Saldo Conta Corrente após transferência: " + contaCorrente.getSaldo());
        System.out.println("Saldo Conta Poupanca após recebimento: " + contaPoupanca.getSaldo());
    }
}
