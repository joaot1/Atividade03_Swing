import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


public class AgendaDiaria {
    private JPanel painelPrincipal;
    private JTextField txtEntradaCompromisso;
    private JSpinner spnData;
    private JTable tblCompromissos;
    private JButton btnAddCompromisso;
    private JButton btnRmvCompromisso;
    private JSpinner spnHora;
    private JLabel lblAviso;

    private void ConfigurandoSpinners() {
        spnData.setModel(new SpinnerDateModel());
        JSpinner.DateEditor editorData = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        spnData.setEditor(editorData);

        spnHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spnHora, "HH:mm");
        spnHora.setEditor(editorHora);
    }


    public AgendaDiaria() {
        ConfigurandoSpinners();

        DefaultTableModel modeloTable = new DefaultTableModel(
                new String[]{"Compromisso", "Data", "Hora"},  0
        );
        tblCompromissos.setModel(modeloTable);


        btnAddCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String atividade = txtEntradaCompromisso.getText();
                String data = new SimpleDateFormat("dd/MM/yyyy").format(spnData.getValue());
                String hora = new SimpleDateFormat("HH:mm").format(spnHora.getValue());

                if(atividade.isBlank()){
                    lblAviso.setText("Fale o nome da atividade");
                    lblAviso.setForeground(Color.red);
                }else{
                    modeloTable.addRow(new Object[]{atividade, data, hora});

                    txtEntradaCompromisso.setText("");
                    lblAviso.setText("");
                }
            }
        });

        btnRmvCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int linhaSelecionada = tblCompromissos.getSelectedRow();

                if(linhaSelecionada != -1) {
                    modeloTable.removeRow(linhaSelecionada);
                    lblAviso.setText("");
                }else {
                    lblAviso.setText("Selecione um compromisso para remover");
                    lblAviso.setForeground(Color.red);
                }


            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda");
        frame.setContentPane(new AgendaDiaria().painelPrincipal);
        frame.setSize(300,400);
        frame.setVisible(true);
    }
}