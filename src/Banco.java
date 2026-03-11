import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void criarContaCorrente(int numero) {
        ContaCorrente c = new ContaCorrente(numero);
        contas.add(c);
    }

    public void criarContaPoupanca(int numero) {
        ContaPoupanca c = new ContaPoupanca(numero);
        contas.add(c);
    }

    public void listarContas() {

        if (contas.size() == 0) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        for (Conta c : contas) {
            System.out.println("Conta: " + c.getNumero() + " | Saldo: " + c.getSaldo());
        }
    }

    public Conta buscarConta(int numero) {

        for (Conta c : contas) {

            if (c.getNumero() == numero) {
                return c;
            }

        }

        return null;
    }

}