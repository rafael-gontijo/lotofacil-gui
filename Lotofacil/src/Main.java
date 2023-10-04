import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("**************************");
            System.out.println("Menu LOTOFACIL");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar A a Z");
            System.out.println("3) Apostar Par ou Impar");
            System.out.println("0) Sair");
            System.out.println("**************************");
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    aposta0a100();
                    break;
                case 2:
                    apostaAaZ();
                    break;
                case 3:
                    apostaParOuImpar();
                    break;
                case 0:
                    System.out.println("**************************");
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção Invalida");
            }
        } while (opcao != 0);
        sc.close();
    }

    public static void aposta0a100() {
        Scanner sc = new Scanner(System.in);
        System.out.println("**************************");
        System.out.println("Apostar de 0 a 100");
        System.out.print("Digite um numero de 0 a 100: ");
        int numeroApostado = sc.nextInt();
        System.out.println("**************************");

        if (numeroApostado < 0 || numeroApostado > 100) {
            System.out.println("Aposta Invalida");
        } else {
            Random rnd = new Random();
            int numeroSorteado = rnd.nextInt(101);
            if (numeroApostado == numeroSorteado) {
                System.out.println("Parabens, você acertou o numero e ganhou R$1000,00");
            } else {
                System.out.println("Desculpe, você apostou: " + numeroApostado + "\nO numero sorteado foi: " + numeroSorteado);
            }
        }
        System.out.println();
    }

    public static void apostaAaZ() {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        char letraSorteada = (char) (r.nextInt(26) + 'a');
        letraSorteada = Character.toUpperCase(letraSorteada);
        System.out.println("**************************");
        System.out.println("Apostar de A a Z");
        System.out.print("Digite uma letra:");
        char letraApostada = Character.toUpperCase(sc.next().charAt(0));
        System.out.println("**************************");
        if (letraApostada == letraSorteada) {
            System.out.println("Parabens, você acertou a letra e ganhou R$500,00");
        } else {
            System.out.println("Desculpe, você apostou: " + letraApostada + "\nO letra sorteada foi: " + letraSorteada);
        }
        System.out.println();
    }

    public static void apostaParOuImpar() {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int numeroSorteado = rnd.nextInt(101) + 1;
        System.out.println("**************************");
        System.out.println("Apostar par ou impar");
        System.out.print("Digite um numero:");
        int numeroApostado = sc.nextInt();
        System.out.println("**************************");

        if (numeroApostado % 2 == 0 && numeroSorteado % 2 == 0) {
            System.out.println("O numero apostado é PAR e foi sorteado PAR! Você GANHOU!");
        }
        if (numeroApostado % 2 == 0 && numeroSorteado % 2 != 0) {
            System.out.println("O numero apostado é PAR e foi sorteado IMPAR! Você PERDEU!");
        }
        if (numeroApostado % 2 != 0 && numeroSorteado % 2 != 0) {
            System.out.println("O numero apostado é IMPAR e foi sorteado IMPAR! Você GANHOU!");
        }
        if (numeroApostado % 2 != 0 && numeroSorteado % 2 == 0) {
            System.out.println("O numero apostado é IMPAR e foi sorteado PAR! Você PERDEU!");
        }
        System.out.println();
    }
}