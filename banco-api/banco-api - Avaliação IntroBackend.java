import java.util.Scanner;

public class POOAv1Sem2 {
    public static void main(String[] args) {
        double saldo=0; int qntSaques=0;

        digitandoNome();
        digitandoSaldo(saldo);
        saques(saldo, qntSaques);
    }

    private static void digitandoNome(){
        String nome = null; boolean nomeCerto = false;

        do{
            try{
                System.out.println("Digite seu nome: ");
                nome = new Scanner(System.in).nextLine();
                validarNome(nome); nomeCerto = true;
            } catch (Exception ex){
                System.out.println(ex.getMessage());
                nomeCerto = false;
            }
        } while(!nomeCerto);
    }

    private static void digitandoSaldo(double saldo){
        boolean saldoCerto = false;

        do{
            try {
                System.out.println("Qual o valor do primeiro depósito? ");
                saldo = new Scanner(System.in).nextDouble();
                validarDeposito(saldo); saldoCerto = true;
            } catch (Exception ex){
                System.out.println(ex.getMessage());
                saldoCerto = false;
            }
        } while(!saldoCerto);
    }

    private static void saques(double saldo, int qntSaques){
        boolean saqueCerto = false;

        do {
            do {
                try{
                    System.out.println("Quanto deseja sacar? ");
                    double saque = new Scanner(System.in).nextDouble();
                    validarSaque(saque);

                    saqueCerto = true; qntSaques++;

                    if(saque > saldo){
                        System.out.println("O saque excede o saldo disponível, " +
                                "portanto foi sacado o restante (R$" + saldo + ") de sua conta.");
                        saldo =0;
                    }
                    else{
                        saldo -= saque;
                        System.out.println("Saque realzido. Seu aldo atual é R$" + saldo);
                    }
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                    saqueCerto = false;
                }
            } while(!saqueCerto);
        } while (saldo > 0);
    }

    private static void validarDeposito(Double deposito) throws Exception{
        if(deposito < 0)
            throw new IllegalArgumentException("O saldo deve ser positvo. Ponha algo válido.");
    }

    private static void validarSaque(double saque){
        if(saque < 0)
            throw new IllegalArgumentException("O saque deve ser positvo. Ponha algo válido.");
    }

    private static void validarNome(String nome) throws Exception{
        if(nome.toCharArray().length > 2)
            throw new IllegalArgumentException("O nome deve ter mais que dois caracteres. Ponha algo válido.");
    }
}
