import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LotoFacilGui extends JFrame {

    private JPanel panel1 = new JPanel();
    private JButton buttonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton buttonAposta2 = new JButton("Apostar de A a Z");
    private JButton buttonAposta3 = new JButton("Apostar Par ou Impar");

    public LotoFacilGui() {
        this.setTitle("** Lotofácil - Interface Gráfica **");
        this.setSize(400, 200);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        panel1.setBackground(new Color(255, 255, 255));

        buttonAposta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aposta0a100();
            }
        });
        buttonAposta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                apostaAaZ();
            }
        });
        buttonAposta3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                apostaParOuImpar();
            }
        });
        panel1.add(buttonAposta1);
        panel1.add(buttonAposta2);
        panel1.add(buttonAposta3);

        this.getContentPane().add(panel1);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela
    }

     public void aposta0a100() {
        String input = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
        int numeroApostado = Integer.parseInt(input);
        if (numeroApostado < 0 || numeroApostado > 100) {
            JOptionPane.showMessageDialog(null, "Aposta Invalida!");
        } else {
            Random rnd = new Random();
            int numeroSorteado = rnd.nextInt(101);
            if (numeroApostado == numeroSorteado) {
                JOptionPane.showMessageDialog(null, "Parabens, você acertou o numero e ganhou R$1000,00!");
            } else {
                JOptionPane.showMessageDialog(null, "Desculpe, você apostou: " + numeroApostado + "\nO numero sorteado foi: " + numeroSorteado);
            }
        }
    }

    public void apostaAaZ() {
        String input = JOptionPane.showInputDialog(null, "Digite uma letra de A a Z:");
        char letraApostada = Character.toUpperCase(input.charAt(0));
        Random r = new Random();
        char letraSorteada = (char) (r.nextInt(26) + 'a');
        letraSorteada = Character.toUpperCase(letraSorteada);
        if (letraApostada == letraSorteada) {
            JOptionPane.showMessageDialog(null, "Parabens, você acertou a letra " + letraSorteada + " e ganhou R$500,00");
        } else {
            JOptionPane.showMessageDialog(null, "Desculpe, você apostou: " + letraApostada + "\nO letra sorteada foi: " + letraSorteada);

        }
    }

    public static void apostaParOuImpar() {
        Random rnd = new Random();
        int numeroSorteado = rnd.nextInt(101) + 1;
        String input = JOptionPane.showInputDialog(null, "Digite um numero:");
        int numeroApostado = Integer.parseInt(input);
        if (numeroApostado % 2 == 0 && numeroSorteado % 2 == 0) {
            JOptionPane.showMessageDialog(null, "O numero apostado " + numeroApostado + " é PAR e foi sorteado PAR! Você GANHOU!");
        }
        if (numeroApostado % 2 == 0 && numeroSorteado % 2 != 0) {
            JOptionPane.showMessageDialog(null, "O numero apostado " + numeroApostado + " é PAR e foi sorteado IMPAR! Você PERDEU!");
        }
        if (numeroApostado % 2 != 0 && numeroSorteado % 2 != 0) {
            JOptionPane.showMessageDialog(null, "O numero apostado " + numeroApostado + " é IMPAR e foi sorteado IMPAR! Você GANHOU!");
        }
        if (numeroApostado % 2 != 0 && numeroSorteado % 2 == 0) {
            JOptionPane.showMessageDialog(null, "O numero apostado " + numeroApostado + " é IMPAR e foi sorteado PAR! Você PERDEU!");
        }
    }

    public static void main(String[] args) {
        new LotoFacilGui();
    }
}
