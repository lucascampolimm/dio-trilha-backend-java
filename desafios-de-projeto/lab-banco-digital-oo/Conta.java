import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements OperacoesBancarias {
    private String numero;
    private double saldo;
    private List<String> historicoTransacoes;

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0.0;
        this.historicoTransacoes = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            historicoTransacoes.add("Depósito: " + valor);
        } else {
            throw new IllegalArgumentException("O saldo precisa estar positivo para essa operação.");
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            historicoTransacoes.add("Saque: " + valor);
            return true;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public boolean transferir(Conta contaDestino, double valor) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            historicoTransacoes.add("Transferência para conta " + contaDestino.getNumero() + ": " + valor);
            return true;
        }
        return false;
    }

    public List<String> getHistoricoTransacoes() {
        return historicoTransacoes;
    }
}
