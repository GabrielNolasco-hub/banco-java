public class ContaCorrente extends Conta implements Tributavel{
    
    public ContaCorrente(int numero) {
        super(numero);
    }

    @Override
    public double calcularTributo() {
        return this.saldo * 0.01; // 1%
    }
}

