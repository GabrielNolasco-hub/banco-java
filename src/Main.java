import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        int opcao = -1;

        CalculadoraDeImposto calc = new CalculadoraDeImposto();
        Gerente gerente = new Gerente("admin","1234");

        while (opcao != 0) {

            System.out.println("\n===== BANCO JAVA =====");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Consultar saldo");
            System.out.println("7 - Calcular tributo");
            System.out.println("8 - Autenticar gerente");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:

                    System.out.println("Tipo de conta:");
                    System.out.println("1 - Corrente");
                    System.out.println("2 - Poupança");

                    int tipo = scanner.nextInt();

                    System.out.print("Número da conta: ");
                    int numero = scanner.nextInt();

                    if (tipo == 1) {
                        banco.criarContaCorrente(numero);
                    } else {
                        banco.criarContaPoupanca(numero);
                    }

                    System.out.println("Conta criada com sucesso.");
                    break;

                case 2:

                    banco.listarContas();
                    break;

                case 3:

                    System.out.print("Número da conta: ");
                    int contaDep = scanner.nextInt();

                    Conta conta = banco.buscarConta(contaDep);

                    if (conta != null) {

                        System.out.print("Valor para depositar: ");
                        double valor = scanner.nextDouble();

                        conta.depositar(valor);

                    } else {
                        System.out.println("Conta não encontrada.");
                    }

                    break;

                case 4:

                    System.out.print("Número da conta: ");
                    int contaSaq = scanner.nextInt();

                    Conta conta2 = banco.buscarConta(contaSaq);

                    if (conta2 != null) {

                        System.out.print("Valor para sacar: ");
                        double valor = scanner.nextDouble();

                        boolean sucesso = conta2.sacar(valor);

                        if (!sucesso) {
                            System.out.println("Saldo insuficiente.");
                        }

                    } else {
                        System.out.println("Conta não encontrada.");
                    }

                    break;

                case 5:

                    System.out.print("Conta origem: ");
                    int origem = scanner.nextInt();

                    System.out.print("Conta destino: ");
                    int destino = scanner.nextInt();

                    Conta c1 = banco.buscarConta(origem);
                    Conta c2 = banco.buscarConta(destino);

                    if (c1 != null && c2 != null) {

                        System.out.print("Valor: ");
                        double valor = scanner.nextDouble();

                        if (c1.sacar(valor)) {
                            c2.depositar(valor);
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }

                    } else {
                        System.out.println("Conta não encontrada.");
                    }

                    break;

                case 6:

                    System.out.print("Número da conta: ");
                    int contaSaldo = scanner.nextInt();

                    Conta conta3 = banco.buscarConta(contaSaldo);

                    if (conta3 != null) {
                        System.out.println("Saldo: " + conta3.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }

                    break;

                case 7:

                    for (Conta c : banco.getContas()) {

                        if (c instanceof Tributavel) {
                            calc.registrar((Tributavel) c);
                        }
                    }

                    System.out.println("Total de tributos: " + calc.getTotalImposto());
                    
                    break;


                case 8:

                    scanner.nextLine(); 

                    System.out.print("Digite a senha do gerente: ");
                    String senha = scanner.nextLine();

                    if (gerente.autenticar(senha)) {
                        System.out.println("Acesso liberado!");
                    } else {
                        System.out.println("Senha incorreta!");
                    }

                    break;

            }

        }

        scanner.close();
    }

}