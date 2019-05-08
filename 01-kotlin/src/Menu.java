import Base.BaseDeDatosMedicina;
import Modelo.Medicina;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel panel;
    private JTextField textField1;
    private JButton button1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton mostrarMedicinaButton;
    private JButton eliminarMedicinaButton;

    public Menu() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medicina medicina = new Medicina();
                medicina.setCodigoMedicina(textField1.getText());
                medicina.setNombreMedicina(textField2.getText());
                medicina.setTipoMedicina(textField3.getText());
                medicina.setFechaCaducidadMedicina(textField4.getText());
                medicina.setDescripcionUsoMedicina(textField5.getText());
                medicina.setCostoMedicina(Double.parseDouble(textField6.getText()));
                medicina.setObservacionMedicina(textField7.getText());
                medicina.setCantidadMedicina(Integer.parseInt(textField8.getText()));
                BaseDeDatosMedicina.Companion.agregarMedicina(medicina);
                limpiar();
            }
        });
        mostrarMedicinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseDeDatosMedicina.Companion.mostrarMedicinas();
            }
        });
        eliminarMedicinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseDeDatosMedicina.Companion.eliminarMedicina(textField2.getText());
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Menu Modelo.Medicina");
        frame.setContentPane(new Menu().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void limpiar(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");

    }

    public JPanel getPanel() {
        return panel;
    }
}
