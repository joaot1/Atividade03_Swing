import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcularIMC {
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JButton btnCalculo;
    private JLabel lblResultado;
    private JLabel lblCategoria;
    private JPanel painelPrincipal;

    public CalcularIMC(){

        btnCalculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double peso = Double.valueOf(txtPeso.getText());
                double altura = Double.valueOf(txtAltura.getText());

                if(peso <= 0 || altura <= 0){
                    lblResultado.setText("Peso e altura devem ser correspondente");
                    lblCategoria.setText("");
                }else {
                    double IMC = peso / (altura * altura);

                    lblResultado.setText(String.format("%.2f", IMC));

                    if (IMC < 18.5) {
                        lblCategoria.setText("Abaixo do peso");
                    } else if (IMC > 18.6 && IMC <= 24.9) {
                        lblCategoria.setText("Peso normal");
                    } else if (IMC > 24.9 && IMC <= 29.9) {
                        lblCategoria.setText("Acima do peso");
                    } else if (IMC > 29.9 && IMC <= 34.9) {
                        lblCategoria.setText("Obesidade Grau 1");
                    } else if (IMC > 34.9 && IMC <= 39.9) {
                        lblCategoria.setText("Obesidade Grau 2");
                    } else if (IMC > 39.9) {
                        lblCategoria.setText("Obesidade Grau 3");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new CalcularIMC().painelPrincipal);
        frame.setVisible(true);
        frame.pack();
    }
}