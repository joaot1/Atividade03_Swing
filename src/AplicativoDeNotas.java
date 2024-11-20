import javax.swing.*;

public class AplicativoDeNotas {
    private JTextField txtEntradaDeNotas;
    private JTextArea txtExibeNota;
    private JLabel exibeResultado;
    private JPanel painelPrincipal;
    private JButton btnCalcularMedia;
    private JButton btnAdicionar;
    private double[] notas = new double[100];
    private int contador = 0;

    public static void main(String[] args) {
        new AplicativoDeNotas(); // Inicializa o programa
    }

    public AplicativoDeNotas() {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);

        JLabel lblInstrucao = new JLabel("Digite as notas dos alunos:");
        lblInstrucao.setBounds(20, 10, 200, 25);

        txtEntradaDeNotas = new JTextField();
        txtEntradaDeNotas.setBounds(20, 40, 150, 25);

        btnAdicionar = new JButton("Adicionar Nota");
        btnAdicionar.setBounds(180, 40, 150, 25);

        txtExibeNota = new JTextArea();
        txtExibeNota.setBounds(20, 80, 340, 100);
        txtExibeNota.setEditable(false);

        btnCalcularMedia = new JButton("Calcular Média");
        btnCalcularMedia.setBounds(20, 200, 150, 25);

        exibeResultado = new JLabel("Média: -");
        exibeResultado.setBounds(200, 200, 200, 25);

        painelPrincipal.add(lblInstrucao);
        painelPrincipal.add(txtEntradaDeNotas);
        painelPrincipal.add(btnAdicionar);
        painelPrincipal.add(txtExibeNota);
        painelPrincipal.add(btnCalcularMedia);
        painelPrincipal.add(exibeResultado);

        frame.add(painelPrincipal);

        btnAdicionar.addActionListener(e -> adicionarNota());
        btnCalcularMedia.addActionListener(e -> calcularMedia());

        frame.setVisible(true);
    }

    private void adicionarNota() {
        String textoNota = txtEntradaDeNotas.getText();
        if (textoNota.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo está vazio. Digite uma nota.");
        } else {
            try {
                double nota = Double.parseDouble(textoNota); // Converte o texto para número
                if (nota >= 0 && nota <= 10) {
                    notas[contador] = nota; // Adiciona a nota ao array
                    contador++;
                    txtEntradaDeNotas.setText(""); // Limpa o campo
                    atualizarListaNotas(); // Atualiza a lista
                } else {
                    JOptionPane.showMessageDialog(null, "Digite uma nota entre 0 e 10.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um número válido.");
            }
        }
    }

    private void atualizarListaNotas() {
        StringBuilder texto = new StringBuilder("Notas:\n");
        for (int i = 0; i < contador; i++) {
            texto.append(notas[i]).append("\n");
        }
        txtExibeNota.setText(texto.toString());
    }

    private void calcularMedia() {
        if (contador > 0) {
            double soma = 0;
            for (int i = 0; i < contador; i++) {
                soma += notas[i];
            }
            double media = soma / contador;
            String status = media >= 7.0 ? "Aprovado" : "Reprovado";
            exibeResultado.setText(String.format("Média: %.2f (%s)", media, status));
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma nota foi adicionada.");
        }
    }
}