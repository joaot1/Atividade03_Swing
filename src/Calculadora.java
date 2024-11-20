import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JTextField txtResultado;
    private JButton btnMais;
    private JButton btnLimpar;
    private JButton btn3;
    private JButton btn7;
    private JButton btnMenos;
    private JButton btnVezes;
    private JButton btnDivisao;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn8;
    private JButton btn9;
    private JButton btnResultado;
    private JPanel calcPainel;

    private double num1 = 0;
    private double num2 = 0;
    private String operador = "";

    public Calculadora() {
        btn0.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "0"));
        btn1.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "1"));
        btn2.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "2"));
        btn3.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "3"));
        btn4.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "4"));
        btn5.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "5"));
        btn6.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "6"));
        btn7.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "7"));
        btn8.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "8"));
        btn9.addActionListener(e -> txtResultado.setText(txtResultado.getText() + "9"));
        btnMais.addActionListener(e -> setOperator("+"));
        btnMenos.addActionListener(e -> setOperator("-"));
        btnVezes.addActionListener(e -> setOperator("*"));
        btnDivisao.addActionListener(e -> setOperator("/"));
        btnLimpar.addActionListener(e -> txtResultado.setText(""));
        btnResultado.addActionListener(e -> {
            num2 = Double.parseDouble(txtResultado.getText());
            double resultado = calcularResultado();
            txtResultado.setText(String.valueOf(resultado));
            operador = "";
        });
    }

    private void setOperator(String op) {
        num1 = Double.parseDouble(txtResultado.getText());
        operador = op;
        txtResultado.setText("");
    }

    private double calcularResultado() {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro: Divisão por zero");
                    return 0;
                }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().calcPainel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
