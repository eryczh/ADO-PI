package cadastroAlunos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CadastroAlunosTela extends JFrame {

    private List<Aluno> alunos;
    private JTextField matriculaField;
    private JTextField nomeField;
    private JTextArea resultadoArea;

    public CadastroAlunosTela() {
        alunos = new ArrayList<>();

        // Configuração da janela
        setTitle("Cadastro de Alunos");
        setSize(400, 400); // Aumentei a altura para 400
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new BorderLayout());

        // Painel para os campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Matrícula:"));
        matriculaField = new JTextField();
        inputPanel.add(matriculaField);
        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        // Botões para cadastrar aluno e exibir matrículas
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        JButton exibirMatriculasButton = new JButton("Exibir Matrículas");
        exibirMatriculasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirMatriculas();
            }
        });

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(exibirMatriculasButton);

        // Área para exibir os resultados
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        // Adiciona os painéis à janela
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);
    }

    private void cadastrarAluno() {
        String matricula = matriculaField.getText();
        String nome = nomeField.getText();

        // Verifica se a matrícula e o nome não estão vazios
        if (!matricula.isEmpty() && !nome.isEmpty()) {
            Aluno aluno = new Aluno(matricula, nome);
            alunos.add(aluno);

            // Limpa os campos de entrada
            matriculaField.setText("");
            nomeField.setText("");

            // Atualiza a área de resultados
            atualizarResultado();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirMatriculas() {
        resultadoArea.setText("Matrículas dos Alunos:\n");
        for (Aluno aluno : alunos) {
            resultadoArea.append(aluno.getMatricula() + "\n");
        }
    }

    private void atualizarResultado() {
        resultadoArea.setText("Dados dos Alunos Cadastrados:\n");
        for (Aluno aluno : alunos) {
            resultadoArea.append("Matrícula: " + aluno.getMatricula() + ", Nome: " + aluno.getNome() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CadastroAlunosTela cadastroAlunosTela = new CadastroAlunosTela();
                cadastroAlunosTela.setVisible(true);
            }
        });
    }
}
