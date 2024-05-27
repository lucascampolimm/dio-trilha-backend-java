public class ContaCorrente extends Conta {
    private static final double TAXA_MANUTENCAO = 10.0;

    public ContaCorrente(String numero) {
        super(numero);
    }

    public void cobrarTaxaManutencao() {
        if (sacar(TAXA_MANUTENCAO)) {
            System.out.println("Taxa de manutenção cobrada: " + TAXA_MANUTENCAO);
        } else {
            System.out.println("Saldo insuficiente para cobrar a taxa de manutenção.");
        }
    }
}
