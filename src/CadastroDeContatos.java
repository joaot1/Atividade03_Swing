import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDeContatos {
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton btnAdicionar;
    private JList<String> listaContatos;
    private JButton btnRemoverContato;
    private JPanel painelPrincipal;
    private JLabel lblMensagem;

    DefaultListModel<String> modelo = new DefaultListModel<>();

    public CadastroDeContatos() {

        listaContatos.setModel(modelo);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText().trim();
                String telefone = txtTelefone.getText().trim();
                String email = txtEmail.getText().trim();


                if(nome.isEmpty() || telefone.isEmpty() || email.isEmpty()){
                    lblMensagem.setText("Todos os campos devem ser preenchidos");
                    return;
                }
                lblMensagem.setText("");

                String contato = nome + ", " + telefone + ", " + email;

                modelo.addElement(contato);

                txtNome.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");

            }
        });

        btnRemoverContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(modelo.getSize() > 0){
                    int ultimoElemento = modelo.getSize() - 1;
                    modelo.removeElementAt(ultimoElemento);
                } else {
                    lblMensagem.setText("Não há contatos para remover");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new CadastroDeContatos().painelPrincipal);
        frame.pack();
        frame.setVisible(true);
    }
}