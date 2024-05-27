public class ContaPoupanca extends Conta {
    private static final double TAXA_JUROS = 0.02;

    public ContaPoupanca(String numero) {
        super(numero);
    }

    public void aplicarJuros() {
        double juros = getSaldo() * TAXA_JUROS;
        depositar(juros);
        System.out.println("Juros aplicados: " + juros);
    }
}
