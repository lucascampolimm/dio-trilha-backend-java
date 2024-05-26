public class Conta {
    private String numero;
    private double saldo;

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta contaDestino, double valor) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }
}
