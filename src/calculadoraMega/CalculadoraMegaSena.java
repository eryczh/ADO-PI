package calculadoraMega;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CalculadoraMegaSena extends JFrame implements ActionListener {
    private JTextField valor1Field, valor2Field, resultadoField;
    private JButton btnSoma, btnSubtracao, btnMultiplicacao, btnDivisao, btnMegaSena;

    public CalculadoraMegaSena() {
        // Configuração da janela
        setTitle("Calculadora e Mega Sena");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(5, 2));

        // Componentes
        add(new JLabel("Valor 1:"));
        valor1Field = new JTextField();
        add(valor1Field);

        add(new JLabel("Valor 2:"));
        valor2Field = new JTextField();
        add(valor2Field);

        add(new JLabel("Resultado:"));
        resultadoField = new JTextField();
        resultadoField.setEditable(false);
        add(resultadoField);

        btnSoma = new JButton("Soma");
        add(btnSoma);

        btnSubtracao = new JButton("Subtração");
        add(btnSubtracao);

        btnMultiplicacao = new JButton("Multiplicação");
        add(btnMultiplicacao);

        btnDivisao = new JButton("Divisão");
        add(btnDivisao);

        btnMegaSena = new JButton("Mega Sena");
        add(btnMegaSena);

        // Adiciona os ouvintes
        btnSoma.addActionListener(this);
        btnSubtracao.addActionListener(this);
        btnMultiplicacao.addActionListener(this);
        btnDivisao.addActionListener(this);
        btnMegaSena.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double valor1 = Double.parseDouble(valor1Field.getText());
        double valor2 = Double.parseDouble(valor2Field.getText());

        if (e.getSource() == btnSoma) {
            resultadoField.setText(String.valueOf(valor1 + valor2));
        } else if (e.getSource() == btnSubtracao) {
            resultadoField.setText(String.valueOf(valor1 - valor2));
        } else if (e.getSource() == btnMultiplicacao) {
            resultadoField.setText(String.valueOf(valor1 * valor2));
        } else if (e.getSource() == btnDivisao) {
            if (valor2 != 0) {
                resultadoField.setText(String.valueOf(valor1 / valor2));
            } else {
                resultadoField.setText("Erro: Divisão por zero");
            }
        } else if (e.getSource() == btnMegaSena) {
            gerarMegaSena();
        }
    }

    private void gerarMegaSena() {
        Random random = new Random();
        StringBuilder numerosMegaSena = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int numero = random.nextInt(60) + 1; // Números de 1 a 60
            numerosMegaSena.append(numero).append(" ");
        }

        resultadoField.setText("Números da Mega Sena: " + numerosMegaSena.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraMegaSena().setVisible(true);
        });
    }
}