public class CalculadoraDeImposto {
    private double totalImposto = 0;

    public void registrar(Tributavel t) {
        totalImposto += t.calcularTributo();
    }

    public double getTotalImposto() {
        return totalImposto;
    }
    
}
