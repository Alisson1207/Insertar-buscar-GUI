import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form_principal {
    private JLabel lb_titulo;
    private JLabel lb_opcion;
    private JButton bt_insertar;
    private JButton bt_buscar;
    public JPanel panel;

    public Form_principal() {
        bt_insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insertarFrame = new JFrame("Insertar Datos");
                insertarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                insertarFrame.setContentPane(new Form_insertar().panel);
                insertarFrame.pack();
                insertarFrame.setSize(550, 600);
                insertarFrame.setLocationRelativeTo(null);
                insertarFrame.setVisible(true);
            }
        });
        bt_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame buscarFrame = new JFrame("Buscar Datos");
                buscarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                buscarFrame.setContentPane(new Form_buscar().panel);
                buscarFrame.pack();
                buscarFrame.setSize(500, 300);
                buscarFrame.setLocationRelativeTo(null);
                buscarFrame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Estudiante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Form_principal().panel);
        frame.pack();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
